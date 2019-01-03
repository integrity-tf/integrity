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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_VISIBLE_COMMENT", "RULE_SL_VISIBLE_TITLE_COMMENT", "RULE_ML_VISIBLE_COMMENT", "RULE_ML_VISIBLE_TITLE_COMMENT", "RULE_DIVIDER", "RULE_STRING", "RULE_ID", "RULE_TIMESPAN", "RULE_INTEGER", "RULE_DECIMAL", "RULE_BOOLEAN_TRUE", "RULE_BOOLEAN_FALSE", "RULE_ISODATE", "RULE_EURODATE", "RULE_USDATE", "RULE_ISOTIME", "RULE_TWENTYFOURHRSTIME", "RULE_TWELVEHRSTIME", "RULE_UPPERCASE_ID", "RULE_ML_DOC_COMMENT", "RULE_NEWLINE", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ISOTIMEZONE", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'private'", "'forkdef'", "'uses'", "'based on'", "':'", "'variantdef'", "'testdef'", "'calldef'", "'single-run'", "'inlined'", "'suitedef'", "'gets'", "'returns'", "'requires'", "'concludedby'", "'suiteend'", "'by default'", "'operationdef'", "'variable'", "'initially'", "'constant'", "'parameterized'", "'assign'", "'->'", "'in'", "'checkpoint'", "'test'", "'='", "'tabletest'", "'|'", "'call'", "'timeset'", "'live'", "'progressing'", "'x'", "'on'", "'master'", "','", "'+'", "'-'", "'suite'", "'('", "'*'", "'/'", "'%'", "'..'", "')'", "'['", "']'", "'<'", "'>'", "'#'", "'null'", "'{'", "'}'", "'.'", "'.*'"
    };
    public static final int RULE_ISOTIME=19;
    public static final int T__50=50;
    public static final int T__90=90;
    public static final int RULE_DIVIDER=8;
    public static final int RULE_TIMESPAN=11;
    public static final int RULE_UPPERCASE_ID=22;
    public static final int RULE_ML_DOC_COMMENT=23;
    public static final int T__59=59;
    public static final int RULE_BOOLEAN_TRUE=14;
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
    public static final int RULE_TWENTYFOURHRSTIME=20;
    public static final int RULE_ISOTIMEZONE=28;
    public static final int RULE_DECIMAL=13;
    public static final int RULE_ISODATE=16;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=26;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int RULE_SL_VISIBLE_COMMENT=4;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int RULE_USDATE=18;
    public static final int T__63=63;
    public static final int RULE_BOOLEAN_FALSE=15;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_NEWLINE=24;
    public static final int RULE_STRING=9;
    public static final int RULE_SL_VISIBLE_TITLE_COMMENT=5;
    public static final int RULE_SL_COMMENT=27;
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
    public static final int RULE_TWELVEHRSTIME=21;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=25;
    public static final int RULE_ANY_OTHER=29;
    public static final int RULE_EURODATE=17;
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
    public static final int RULE_INTEGER=12;
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
    // InternalDSL.g:76:1: ruleModel returns [EObject current=null] : ( () ruleNL ( ( (lv_imports_2_0= ruleImport ) ) ruleNL )* ( (lv_statements_4_0= ruleStatement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_2_0 = null;

        EObject lv_statements_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:79:28: ( ( () ruleNL ( ( (lv_imports_2_0= ruleImport ) ) ruleNL )* ( (lv_statements_4_0= ruleStatement ) )* ) )
            // InternalDSL.g:80:1: ( () ruleNL ( ( (lv_imports_2_0= ruleImport ) ) ruleNL )* ( (lv_statements_4_0= ruleStatement ) )* )
            {
            // InternalDSL.g:80:1: ( () ruleNL ( ( (lv_imports_2_0= ruleImport ) ) ruleNL )* ( (lv_statements_4_0= ruleStatement ) )* )
            // InternalDSL.g:80:2: () ruleNL ( ( (lv_imports_2_0= ruleImport ) ) ruleNL )* ( (lv_statements_4_0= ruleStatement ) )*
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
                
            // InternalDSL.g:94:1: ( ( (lv_imports_2_0= ruleImport ) ) ruleNL )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==33) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDSL.g:94:2: ( (lv_imports_2_0= ruleImport ) ) ruleNL
            	    {
            	    // InternalDSL.g:94:2: ( (lv_imports_2_0= ruleImport ) )
            	    // InternalDSL.g:95:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // InternalDSL.g:95:1: (lv_imports_2_0= ruleImport )
            	    // InternalDSL.g:96:3: lv_imports_2_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_4);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_2_0, 
            	            		"de.gebit.integrity.DSL.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getModelAccess().getNLParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_3);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalDSL.g:120:3: ( (lv_statements_4_0= ruleStatement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ML_DOC_COMMENT||LA2_0==30||(LA2_0>=34 && LA2_0<=35)||LA2_0==39) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDSL.g:121:1: (lv_statements_4_0= ruleStatement )
            	    {
            	    // InternalDSL.g:121:1: (lv_statements_4_0= ruleStatement )
            	    // InternalDSL.g:122:3: lv_statements_4_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_statements_4_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_4_0, 
            	            		"de.gebit.integrity.DSL.Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // InternalDSL.g:146:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalDSL.g:147:2: (iv_ruleStatement= ruleStatement EOF )
            // InternalDSL.g:148:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalDSL.g:155:1: ruleStatement returns [EObject current=null] : (this_PackageDefinition_0= rulePackageDefinition | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDefinition_0 = null;

        EObject this_ForkDefinition_1 = null;

        EObject this_VariantDefinition_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:158:28: ( (this_PackageDefinition_0= rulePackageDefinition | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition ) )
            // InternalDSL.g:159:1: (this_PackageDefinition_0= rulePackageDefinition | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition )
            {
            // InternalDSL.g:159:1: (this_PackageDefinition_0= rulePackageDefinition | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition )
            int alt3=3;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalDSL.g:160:5: this_PackageDefinition_0= rulePackageDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_PackageDefinition_0=rulePackageDefinition();

                    state._fsp--;

                     
                            current = this_PackageDefinition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:170:5: this_ForkDefinition_1= ruleForkDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getForkDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ForkDefinition_1=ruleForkDefinition();

                    state._fsp--;

                     
                            current = this_ForkDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:180:5: this_VariantDefinition_2= ruleVariantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getVariantDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VariantDefinition_2=ruleVariantDefinition();

                    state._fsp--;

                     
                            current = this_VariantDefinition_2; 
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
    // InternalDSL.g:196:1: entryRuleVisibleComment returns [EObject current=null] : iv_ruleVisibleComment= ruleVisibleComment EOF ;
    public final EObject entryRuleVisibleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleComment = null;


        try {
            // InternalDSL.g:197:2: (iv_ruleVisibleComment= ruleVisibleComment EOF )
            // InternalDSL.g:198:2: iv_ruleVisibleComment= ruleVisibleComment EOF
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
    // InternalDSL.g:205:1: ruleVisibleComment returns [EObject current=null] : (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment ) ;
    public final EObject ruleVisibleComment() throws RecognitionException {
        EObject current = null;

        EObject this_VisibleSingleLineComment_0 = null;

        EObject this_VisibleMultiLineComment_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:208:28: ( (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment ) )
            // InternalDSL.g:209:1: (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment )
            {
            // InternalDSL.g:209:1: (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_SL_VISIBLE_COMMENT && LA4_0<=RULE_SL_VISIBLE_TITLE_COMMENT)) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=RULE_ML_VISIBLE_COMMENT && LA4_0<=RULE_ML_VISIBLE_TITLE_COMMENT)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalDSL.g:210:5: this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment
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
                    // InternalDSL.g:220:5: this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment
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
    // InternalDSL.g:236:1: entryRuleVisibleSingleLineComment returns [EObject current=null] : iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF ;
    public final EObject entryRuleVisibleSingleLineComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineComment = null;


        try {
            // InternalDSL.g:237:2: (iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF )
            // InternalDSL.g:238:2: iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF
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
    // InternalDSL.g:245:1: ruleVisibleSingleLineComment returns [EObject current=null] : (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment ) ;
    public final EObject ruleVisibleSingleLineComment() throws RecognitionException {
        EObject current = null;

        EObject this_VisibleSingleLineNormalComment_0 = null;

        EObject this_VisibleSingleLineTitleComment_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:248:28: ( (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment ) )
            // InternalDSL.g:249:1: (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment )
            {
            // InternalDSL.g:249:1: (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_SL_VISIBLE_COMMENT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_SL_VISIBLE_TITLE_COMMENT) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalDSL.g:250:5: this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment
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
                    // InternalDSL.g:260:5: this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment
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
    // InternalDSL.g:276:1: entryRuleVisibleSingleLineNormalComment returns [EObject current=null] : iv_ruleVisibleSingleLineNormalComment= ruleVisibleSingleLineNormalComment EOF ;
    public final EObject entryRuleVisibleSingleLineNormalComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineNormalComment = null;


        try {
            // InternalDSL.g:277:2: (iv_ruleVisibleSingleLineNormalComment= ruleVisibleSingleLineNormalComment EOF )
            // InternalDSL.g:278:2: iv_ruleVisibleSingleLineNormalComment= ruleVisibleSingleLineNormalComment EOF
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
    // InternalDSL.g:285:1: ruleVisibleSingleLineNormalComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleSingleLineNormalComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:288:28: ( ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:289:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:289:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL )
            // InternalDSL.g:289:2: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:289:2: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) )
            // InternalDSL.g:290:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            {
            // InternalDSL.g:290:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            // InternalDSL.g:291:3: lv_content_0_0= RULE_SL_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_SL_VISIBLE_COMMENT,FOLLOW_6); 

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
    // InternalDSL.g:323:1: entryRuleVisibleSingleLineTitleComment returns [EObject current=null] : iv_ruleVisibleSingleLineTitleComment= ruleVisibleSingleLineTitleComment EOF ;
    public final EObject entryRuleVisibleSingleLineTitleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineTitleComment = null;


        try {
            // InternalDSL.g:324:2: (iv_ruleVisibleSingleLineTitleComment= ruleVisibleSingleLineTitleComment EOF )
            // InternalDSL.g:325:2: iv_ruleVisibleSingleLineTitleComment= ruleVisibleSingleLineTitleComment EOF
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
    // InternalDSL.g:332:1: ruleVisibleSingleLineTitleComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleSingleLineTitleComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:335:28: ( ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:336:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:336:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            // InternalDSL.g:336:2: ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:336:2: ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) )
            // InternalDSL.g:337:1: (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT )
            {
            // InternalDSL.g:337:1: (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT )
            // InternalDSL.g:338:3: lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_SL_VISIBLE_TITLE_COMMENT,FOLLOW_6); 

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
    // InternalDSL.g:370:1: entryRuleVisibleMultiLineComment returns [EObject current=null] : iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF ;
    public final EObject entryRuleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineComment = null;


        try {
            // InternalDSL.g:371:2: (iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF )
            // InternalDSL.g:372:2: iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF
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
    // InternalDSL.g:379:1: ruleVisibleMultiLineComment returns [EObject current=null] : (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment ) ;
    public final EObject ruleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        EObject this_VisibleMultiLineNormalComment_0 = null;

        EObject this_VisibleMultiLineTitleComment_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:382:28: ( (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment ) )
            // InternalDSL.g:383:1: (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment )
            {
            // InternalDSL.g:383:1: (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ML_VISIBLE_COMMENT) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ML_VISIBLE_TITLE_COMMENT) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalDSL.g:384:5: this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment
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
                    // InternalDSL.g:394:5: this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment
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
    // InternalDSL.g:410:1: entryRuleVisibleMultiLineNormalComment returns [EObject current=null] : iv_ruleVisibleMultiLineNormalComment= ruleVisibleMultiLineNormalComment EOF ;
    public final EObject entryRuleVisibleMultiLineNormalComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineNormalComment = null;


        try {
            // InternalDSL.g:411:2: (iv_ruleVisibleMultiLineNormalComment= ruleVisibleMultiLineNormalComment EOF )
            // InternalDSL.g:412:2: iv_ruleVisibleMultiLineNormalComment= ruleVisibleMultiLineNormalComment EOF
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
    // InternalDSL.g:419:1: ruleVisibleMultiLineNormalComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleMultiLineNormalComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:422:28: ( ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:423:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:423:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL )
            // InternalDSL.g:423:2: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:423:2: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) )
            // InternalDSL.g:424:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            {
            // InternalDSL.g:424:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            // InternalDSL.g:425:3: lv_content_0_0= RULE_ML_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_VISIBLE_COMMENT,FOLLOW_6); 

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
    // InternalDSL.g:457:1: entryRuleVisibleMultiLineTitleComment returns [EObject current=null] : iv_ruleVisibleMultiLineTitleComment= ruleVisibleMultiLineTitleComment EOF ;
    public final EObject entryRuleVisibleMultiLineTitleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineTitleComment = null;


        try {
            // InternalDSL.g:458:2: (iv_ruleVisibleMultiLineTitleComment= ruleVisibleMultiLineTitleComment EOF )
            // InternalDSL.g:459:2: iv_ruleVisibleMultiLineTitleComment= ruleVisibleMultiLineTitleComment EOF
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
    // InternalDSL.g:466:1: ruleVisibleMultiLineTitleComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleMultiLineTitleComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:469:28: ( ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:470:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:470:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            // InternalDSL.g:470:2: ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:470:2: ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) )
            // InternalDSL.g:471:1: (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT )
            {
            // InternalDSL.g:471:1: (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT )
            // InternalDSL.g:472:3: lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_VISIBLE_TITLE_COMMENT,FOLLOW_6); 

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
    // InternalDSL.g:504:1: entryRuleVisibleDivider returns [EObject current=null] : iv_ruleVisibleDivider= ruleVisibleDivider EOF ;
    public final EObject entryRuleVisibleDivider() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleDivider = null;


        try {
            // InternalDSL.g:505:2: (iv_ruleVisibleDivider= ruleVisibleDivider EOF )
            // InternalDSL.g:506:2: iv_ruleVisibleDivider= ruleVisibleDivider EOF
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
    // InternalDSL.g:513:1: ruleVisibleDivider returns [EObject current=null] : ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL ) ;
    public final EObject ruleVisibleDivider() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:516:28: ( ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL ) )
            // InternalDSL.g:517:1: ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL )
            {
            // InternalDSL.g:517:1: ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL )
            // InternalDSL.g:517:2: ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL
            {
            // InternalDSL.g:517:2: ( (lv_content_0_0= RULE_DIVIDER ) )
            // InternalDSL.g:518:1: (lv_content_0_0= RULE_DIVIDER )
            {
            // InternalDSL.g:518:1: (lv_content_0_0= RULE_DIVIDER )
            // InternalDSL.g:519:3: lv_content_0_0= RULE_DIVIDER
            {
            lv_content_0_0=(Token)match(input,RULE_DIVIDER,FOLLOW_6); 

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
    // InternalDSL.g:551:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // InternalDSL.g:552:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // InternalDSL.g:553:2: iv_rulePackageDefinition= rulePackageDefinition EOF
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
    // InternalDSL.g:560:1: rulePackageDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL ) ;
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
            // InternalDSL.g:563:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL ) )
            // InternalDSL.g:564:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL )
            {
            // InternalDSL.g:564:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL )
            // InternalDSL.g:564:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL
            {
            // InternalDSL.g:564:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ML_DOC_COMMENT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalDSL.g:565:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:565:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:566:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_7);
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

            otherlv_1=(Token)match(input,30,FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:594:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDSL.g:595:1: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDSL.g:595:1: (lv_name_3_0= ruleQualifiedName )
            // InternalDSL.g:596:3: lv_name_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_9);
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

            otherlv_4=(Token)match(input,31,FOLLOW_10); 

                	newLeafNode(otherlv_4, grammarAccess.getPackageDefinitionAccess().getWithKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_11);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:624:1: ( (lv_statements_6_0= rulePackageStatement ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ML_DOC_COMMENT||(LA8_0>=34 && LA8_0<=35)||(LA8_0>=39 && LA8_0<=44)||(LA8_0>=51 && LA8_0<=52)||LA8_0==54) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDSL.g:625:1: (lv_statements_6_0= rulePackageStatement )
            	    {
            	    // InternalDSL.g:625:1: (lv_statements_6_0= rulePackageStatement )
            	    // InternalDSL.g:626:3: lv_statements_6_0= rulePackageStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_11);
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
            	    break loop8;
                }
            } while (true);

            otherlv_7=(Token)match(input,32,FOLLOW_6); 

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
    // InternalDSL.g:662:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // InternalDSL.g:663:2: (iv_rulePackageStatement= rulePackageStatement EOF )
            // InternalDSL.g:664:2: iv_rulePackageStatement= rulePackageStatement EOF
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
    // InternalDSL.g:671:1: rulePackageStatement returns [EObject current=null] : (this_ForkDefinition_0= ruleForkDefinition | this_VariantDefinition_1= ruleVariantDefinition | this_TestDefinition_2= ruleTestDefinition | this_CallDefinition_3= ruleCallDefinition | this_OperationDefinition_4= ruleOperationDefinition | this_SuiteDefinition_5= ruleSuiteDefinition | this_VariableDefinition_6= ruleVariableDefinition | this_ConstantDefinition_7= ruleConstantDefinition ) ;
    public final EObject rulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject this_ForkDefinition_0 = null;

        EObject this_VariantDefinition_1 = null;

        EObject this_TestDefinition_2 = null;

        EObject this_CallDefinition_3 = null;

        EObject this_OperationDefinition_4 = null;

        EObject this_SuiteDefinition_5 = null;

        EObject this_VariableDefinition_6 = null;

        EObject this_ConstantDefinition_7 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:674:28: ( (this_ForkDefinition_0= ruleForkDefinition | this_VariantDefinition_1= ruleVariantDefinition | this_TestDefinition_2= ruleTestDefinition | this_CallDefinition_3= ruleCallDefinition | this_OperationDefinition_4= ruleOperationDefinition | this_SuiteDefinition_5= ruleSuiteDefinition | this_VariableDefinition_6= ruleVariableDefinition | this_ConstantDefinition_7= ruleConstantDefinition ) )
            // InternalDSL.g:675:1: (this_ForkDefinition_0= ruleForkDefinition | this_VariantDefinition_1= ruleVariantDefinition | this_TestDefinition_2= ruleTestDefinition | this_CallDefinition_3= ruleCallDefinition | this_OperationDefinition_4= ruleOperationDefinition | this_SuiteDefinition_5= ruleSuiteDefinition | this_VariableDefinition_6= ruleVariableDefinition | this_ConstantDefinition_7= ruleConstantDefinition )
            {
            // InternalDSL.g:675:1: (this_ForkDefinition_0= ruleForkDefinition | this_VariantDefinition_1= ruleVariantDefinition | this_TestDefinition_2= ruleTestDefinition | this_CallDefinition_3= ruleCallDefinition | this_OperationDefinition_4= ruleOperationDefinition | this_SuiteDefinition_5= ruleSuiteDefinition | this_VariableDefinition_6= ruleVariableDefinition | this_ConstantDefinition_7= ruleConstantDefinition )
            int alt9=8;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalDSL.g:676:5: this_ForkDefinition_0= ruleForkDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getForkDefinitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ForkDefinition_0=ruleForkDefinition();

                    state._fsp--;

                     
                            current = this_ForkDefinition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:686:5: this_VariantDefinition_1= ruleVariantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariantDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VariantDefinition_1=ruleVariantDefinition();

                    state._fsp--;

                     
                            current = this_VariantDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:696:5: this_TestDefinition_2= ruleTestDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TestDefinition_2=ruleTestDefinition();

                    state._fsp--;

                     
                            current = this_TestDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalDSL.g:706:5: this_CallDefinition_3= ruleCallDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_CallDefinition_3=ruleCallDefinition();

                    state._fsp--;

                     
                            current = this_CallDefinition_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalDSL.g:716:5: this_OperationDefinition_4= ruleOperationDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getOperationDefinitionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_OperationDefinition_4=ruleOperationDefinition();

                    state._fsp--;

                     
                            current = this_OperationDefinition_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalDSL.g:726:5: this_SuiteDefinition_5= ruleSuiteDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SuiteDefinition_5=ruleSuiteDefinition();

                    state._fsp--;

                     
                            current = this_SuiteDefinition_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalDSL.g:736:5: this_VariableDefinition_6= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VariableDefinition_6=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalDSL.g:746:5: this_ConstantDefinition_7= ruleConstantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getConstantDefinitionParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ConstantDefinition_7=ruleConstantDefinition();

                    state._fsp--;

                     
                            current = this_ConstantDefinition_7; 
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
    // InternalDSL.g:762:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalDSL.g:763:2: (iv_ruleImport= ruleImport EOF )
            // InternalDSL.g:764:2: iv_ruleImport= ruleImport EOF
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
    // InternalDSL.g:771:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:774:28: ( (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ) )
            // InternalDSL.g:775:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // InternalDSL.g:775:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) )
            // InternalDSL.g:775:3: otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getImportAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:787:1: ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) )
            // InternalDSL.g:788:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            {
            // InternalDSL.g:788:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            // InternalDSL.g:789:3: lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
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


            }


            }

             leaveRule(); 
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
    // InternalDSL.g:813:1: entryRuleForkDefinition returns [EObject current=null] : iv_ruleForkDefinition= ruleForkDefinition EOF ;
    public final EObject entryRuleForkDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkDefinition = null;


        try {
            // InternalDSL.g:814:2: (iv_ruleForkDefinition= ruleForkDefinition EOF )
            // InternalDSL.g:815:2: iv_ruleForkDefinition= ruleForkDefinition EOF
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
    // InternalDSL.g:822:1: ruleForkDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )* ) ;
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
            // InternalDSL.g:825:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )* ) )
            // InternalDSL.g:826:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )* )
            {
            // InternalDSL.g:826:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )* )
            // InternalDSL.g:826:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )*
            {
            // InternalDSL.g:826:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ML_DOC_COMMENT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDSL.g:827:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:827:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:828:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_12);
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

            // InternalDSL.g:844:3: ( (lv_private_1_0= 'private' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==34) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalDSL.g:845:1: (lv_private_1_0= 'private' )
                    {
                    // InternalDSL.g:845:1: (lv_private_1_0= 'private' )
                    // InternalDSL.g:846:3: lv_private_1_0= 'private'
                    {
                    lv_private_1_0=(Token)match(input,34,FOLLOW_13); 

                            newLeafNode(lv_private_1_0, grammarAccess.getForkDefinitionAccess().getPrivatePrivateKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getForkDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_1_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,35,FOLLOW_8); 

                	newLeafNode(otherlv_2, grammarAccess.getForkDefinitionAccess().getForkdefKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:871:1: ( (lv_name_4_0= ruleQualifiedName ) )
            // InternalDSL.g:872:1: (lv_name_4_0= ruleQualifiedName )
            {
            // InternalDSL.g:872:1: (lv_name_4_0= ruleQualifiedName )
            // InternalDSL.g:873:3: lv_name_4_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getNameQualifiedNameParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_14);
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
                
            pushFollow(FOLLOW_15);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:897:1: ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalDSL.g:897:2: ( (lv_description_6_0= RULE_STRING ) ) ruleNL
                    {
                    // InternalDSL.g:897:2: ( (lv_description_6_0= RULE_STRING ) )
                    // InternalDSL.g:898:1: (lv_description_6_0= RULE_STRING )
                    {
                    // InternalDSL.g:898:1: (lv_description_6_0= RULE_STRING )
                    // InternalDSL.g:899:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

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
                        
                    pushFollow(FOLLOW_17);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:923:3: ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=36 && LA14_0<=37)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDSL.g:923:4: ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL
                    {
                    // InternalDSL.g:923:4: ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==36) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==37) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalDSL.g:923:5: (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) )
                            {
                            // InternalDSL.g:923:5: (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) )
                            // InternalDSL.g:923:7: otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) )
                            {
                            otherlv_8=(Token)match(input,36,FOLLOW_8); 

                                	newLeafNode(otherlv_8, grammarAccess.getForkDefinitionAccess().getUsesKeyword_7_0_0_0());
                                
                             
                                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_7_0_0_1()); 
                                
                            pushFollow(FOLLOW_8);
                            ruleNL();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                
                            // InternalDSL.g:935:1: ( (lv_forkerClass_10_0= ruleJavaClassReference ) )
                            // InternalDSL.g:936:1: (lv_forkerClass_10_0= ruleJavaClassReference )
                            {
                            // InternalDSL.g:936:1: (lv_forkerClass_10_0= ruleJavaClassReference )
                            // InternalDSL.g:937:3: lv_forkerClass_10_0= ruleJavaClassReference
                            {
                             
                            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getForkerClassJavaClassReferenceParserRuleCall_7_0_0_2_0()); 
                            	    
                            pushFollow(FOLLOW_8);
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
                            // InternalDSL.g:954:6: (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) )
                            {
                            // InternalDSL.g:954:6: (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) )
                            // InternalDSL.g:954:8: otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) )
                            {
                            otherlv_11=(Token)match(input,37,FOLLOW_8); 

                                	newLeafNode(otherlv_11, grammarAccess.getForkDefinitionAccess().getBasedOnKeyword_7_0_1_0());
                                
                             
                                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_7_0_1_1()); 
                                
                            pushFollow(FOLLOW_8);
                            ruleNL();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                
                            // InternalDSL.g:966:1: ( ( ruleQualifiedName ) )
                            // InternalDSL.g:967:1: ( ruleQualifiedName )
                            {
                            // InternalDSL.g:967:1: ( ruleQualifiedName )
                            // InternalDSL.g:968:3: ruleQualifiedName
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getForkDefinitionRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getBaseForkForkDefinitionCrossReference_7_0_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_8);
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
                        
                    pushFollow(FOLLOW_18);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:989:3: ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalDSL.g:989:4: ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL
            	    {
            	    // InternalDSL.g:989:4: ( (lv_parameters_15_0= ruleForkParameter ) )
            	    // InternalDSL.g:990:1: (lv_parameters_15_0= ruleForkParameter )
            	    {
            	    // InternalDSL.g:990:1: (lv_parameters_15_0= ruleForkParameter )
            	    // InternalDSL.g:991:3: lv_parameters_15_0= ruleForkParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getParametersForkParameterParserRuleCall_8_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_8);
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
            	        
            	    pushFollow(FOLLOW_18);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalDSL.g:1023:1: entryRuleForkParameter returns [EObject current=null] : iv_ruleForkParameter= ruleForkParameter EOF ;
    public final EObject entryRuleForkParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkParameter = null;


        try {
            // InternalDSL.g:1024:2: (iv_ruleForkParameter= ruleForkParameter EOF )
            // InternalDSL.g:1025:2: iv_ruleForkParameter= ruleForkParameter EOF
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
    // InternalDSL.g:1032:1: ruleForkParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) ;
    public final EObject ruleForkParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1035:28: ( ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) )
            // InternalDSL.g:1036:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            {
            // InternalDSL.g:1036:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            // InternalDSL.g:1036:2: ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            {
            // InternalDSL.g:1036:2: ( (lv_name_0_0= ruleFixedParameterName ) )
            // InternalDSL.g:1037:1: (lv_name_0_0= ruleFixedParameterName )
            {
            // InternalDSL.g:1037:1: (lv_name_0_0= ruleFixedParameterName )
            // InternalDSL.g:1038:3: lv_name_0_0= ruleFixedParameterName
            {
             
            	        newCompositeNode(grammarAccess.getForkParameterAccess().getNameFixedParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_19);
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
                
            pushFollow(FOLLOW_20);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,38,FOLLOW_21); 

                	newLeafNode(otherlv_2, grammarAccess.getForkParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getForkParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1074:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            // InternalDSL.g:1075:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            {
            // InternalDSL.g:1075:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            // InternalDSL.g:1076:3: lv_value_4_0= ruleValueOrEnumValueOrOperation
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
    // InternalDSL.g:1100:1: entryRuleVariantDefinition returns [EObject current=null] : iv_ruleVariantDefinition= ruleVariantDefinition EOF ;
    public final EObject entryRuleVariantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantDefinition = null;


        try {
            // InternalDSL.g:1101:2: (iv_ruleVariantDefinition= ruleVariantDefinition EOF )
            // InternalDSL.g:1102:2: iv_ruleVariantDefinition= ruleVariantDefinition EOF
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
    // InternalDSL.g:1109:1: ruleVariantDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? ) ;
    public final EObject ruleVariantDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_description_5_0=null;
        EObject lv_documentation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1112:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? ) )
            // InternalDSL.g:1113:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? )
            {
            // InternalDSL.g:1113:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? )
            // InternalDSL.g:1113:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )?
            {
            // InternalDSL.g:1113:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ML_DOC_COMMENT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDSL.g:1114:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:1114:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:1115:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariantDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_22);
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

            otherlv_1=(Token)match(input,39,FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getVariantDefinitionAccess().getVariantdefKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1143:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDSL.g:1144:1: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDSL.g:1144:1: (lv_name_3_0= ruleQualifiedName )
            // InternalDSL.g:1145:3: lv_name_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_23);
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
                
            pushFollow(FOLLOW_24);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1169:1: ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDSL.g:1169:2: ( (lv_description_5_0= RULE_STRING ) ) ruleNL
                    {
                    // InternalDSL.g:1169:2: ( (lv_description_5_0= RULE_STRING ) )
                    // InternalDSL.g:1170:1: (lv_description_5_0= RULE_STRING )
                    {
                    // InternalDSL.g:1170:1: (lv_description_5_0= RULE_STRING )
                    // InternalDSL.g:1171:3: lv_description_5_0= RULE_STRING
                    {
                    lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

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
    // InternalDSL.g:1203:1: entryRuleTestDefinition returns [EObject current=null] : iv_ruleTestDefinition= ruleTestDefinition EOF ;
    public final EObject entryRuleTestDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestDefinition = null;


        try {
            // InternalDSL.g:1204:2: (iv_ruleTestDefinition= ruleTestDefinition EOF )
            // InternalDSL.g:1205:2: iv_ruleTestDefinition= ruleTestDefinition EOF
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
    // InternalDSL.g:1212:1: ruleTestDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleTestDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_documentation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_fixtureMethod_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1215:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL ) )
            // InternalDSL.g:1216:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL )
            {
            // InternalDSL.g:1216:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL )
            // InternalDSL.g:1216:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL
            {
            // InternalDSL.g:1216:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ML_DOC_COMMENT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDSL.g:1217:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:1217:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:1218:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_25);
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

            otherlv_1=(Token)match(input,40,FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getTestDefinitionAccess().getTestdefKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1246:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDSL.g:1247:1: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDSL.g:1247:1: (lv_name_3_0= ruleQualifiedName )
            // InternalDSL.g:1248:3: lv_name_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_26);
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
                
            pushFollow(FOLLOW_27);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_5=(Token)match(input,36,FOLLOW_8); 

                	newLeafNode(otherlv_5, grammarAccess.getTestDefinitionAccess().getUsesKeyword_5());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_6()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1284:1: ( (lv_fixtureMethod_7_0= ruleMethodReference ) )
            // InternalDSL.g:1285:1: (lv_fixtureMethod_7_0= ruleMethodReference )
            {
            // InternalDSL.g:1285:1: (lv_fixtureMethod_7_0= ruleMethodReference )
            // InternalDSL.g:1286:3: lv_fixtureMethod_7_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_6);
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
    // InternalDSL.g:1318:1: entryRuleCallDefinition returns [EObject current=null] : iv_ruleCallDefinition= ruleCallDefinition EOF ;
    public final EObject entryRuleCallDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallDefinition = null;


        try {
            // InternalDSL.g:1319:2: (iv_ruleCallDefinition= ruleCallDefinition EOF )
            // InternalDSL.g:1320:2: iv_ruleCallDefinition= ruleCallDefinition EOF
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
    // InternalDSL.g:1327:1: ruleCallDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleCallDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_documentation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_fixtureMethod_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1330:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL ) )
            // InternalDSL.g:1331:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL )
            {
            // InternalDSL.g:1331:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL )
            // InternalDSL.g:1331:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL
            {
            // InternalDSL.g:1331:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ML_DOC_COMMENT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalDSL.g:1332:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:1332:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:1333:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_28);
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

            otherlv_1=(Token)match(input,41,FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getCallDefinitionAccess().getCalldefKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1361:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDSL.g:1362:1: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDSL.g:1362:1: (lv_name_3_0= ruleQualifiedName )
            // InternalDSL.g:1363:3: lv_name_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_26);
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
                
            pushFollow(FOLLOW_27);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_5=(Token)match(input,36,FOLLOW_8); 

                	newLeafNode(otherlv_5, grammarAccess.getCallDefinitionAccess().getUsesKeyword_5());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_6()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1399:1: ( (lv_fixtureMethod_7_0= ruleMethodReference ) )
            // InternalDSL.g:1400:1: (lv_fixtureMethod_7_0= ruleMethodReference )
            {
            // InternalDSL.g:1400:1: (lv_fixtureMethod_7_0= ruleMethodReference )
            // InternalDSL.g:1401:3: lv_fixtureMethod_7_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_6);
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
    // InternalDSL.g:1433:1: entryRuleSuiteDefinition returns [EObject current=null] : iv_ruleSuiteDefinition= ruleSuiteDefinition EOF ;
    public final EObject entryRuleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteDefinition = null;


        try {
            // InternalDSL.g:1434:2: (iv_ruleSuiteDefinition= ruleSuiteDefinition EOF )
            // InternalDSL.g:1435:2: iv_ruleSuiteDefinition= ruleSuiteDefinition EOF
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
    // InternalDSL.g:1442:1: ruleSuiteDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL ) ;
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
            // InternalDSL.g:1445:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL ) )
            // InternalDSL.g:1446:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL )
            {
            // InternalDSL.g:1446:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL )
            // InternalDSL.g:1446:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL
            {
            // InternalDSL.g:1446:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ML_DOC_COMMENT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDSL.g:1447:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:1447:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:1448:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_29);
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

            // InternalDSL.g:1464:3: ( (lv_private_1_0= 'private' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDSL.g:1465:1: (lv_private_1_0= 'private' )
                    {
                    // InternalDSL.g:1465:1: (lv_private_1_0= 'private' )
                    // InternalDSL.g:1466:3: lv_private_1_0= 'private'
                    {
                    lv_private_1_0=(Token)match(input,34,FOLLOW_30); 

                            newLeafNode(lv_private_1_0, grammarAccess.getSuiteDefinitionAccess().getPrivatePrivateKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_1_0, "private");
                    	    

                    }


                    }
                    break;

            }

            // InternalDSL.g:1479:3: ( (lv_singleRun_2_0= 'single-run' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==42) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDSL.g:1480:1: (lv_singleRun_2_0= 'single-run' )
                    {
                    // InternalDSL.g:1480:1: (lv_singleRun_2_0= 'single-run' )
                    // InternalDSL.g:1481:3: lv_singleRun_2_0= 'single-run'
                    {
                    lv_singleRun_2_0=(Token)match(input,42,FOLLOW_31); 

                            newLeafNode(lv_singleRun_2_0, grammarAccess.getSuiteDefinitionAccess().getSingleRunSingleRunKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "singleRun", lv_singleRun_2_0, "single-run");
                    	    

                    }


                    }
                    break;

            }

            // InternalDSL.g:1494:3: ( (lv_inlined_3_0= 'inlined' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==43) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDSL.g:1495:1: (lv_inlined_3_0= 'inlined' )
                    {
                    // InternalDSL.g:1495:1: (lv_inlined_3_0= 'inlined' )
                    // InternalDSL.g:1496:3: lv_inlined_3_0= 'inlined'
                    {
                    lv_inlined_3_0=(Token)match(input,43,FOLLOW_32); 

                            newLeafNode(lv_inlined_3_0, grammarAccess.getSuiteDefinitionAccess().getInlinedInlinedKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "inlined", lv_inlined_3_0, "inlined");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,44,FOLLOW_8); 

                	newLeafNode(otherlv_4, grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1521:1: ( (lv_name_6_0= ruleQualifiedName ) )
            // InternalDSL.g:1522:1: (lv_name_6_0= ruleQualifiedName )
            {
            // InternalDSL.g:1522:1: (lv_name_6_0= ruleQualifiedName )
            // InternalDSL.g:1523:3: lv_name_6_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_33);
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
                
            pushFollow(FOLLOW_34);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1547:1: (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==45) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDSL.g:1547:3: otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+
                    {
                    otherlv_8=(Token)match(input,45,FOLLOW_8); 

                        	newLeafNode(otherlv_8, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_8_0());
                        
                    // InternalDSL.g:1551:1: ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_ID) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalDSL.g:1551:2: ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1551:2: ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) )
                    	    // InternalDSL.g:1552:1: (lv_parameters_9_0= ruleSuiteParameterDefinition )
                    	    {
                    	    // InternalDSL.g:1552:1: (lv_parameters_9_0= ruleSuiteParameterDefinition )
                    	    // InternalDSL.g:1553:3: lv_parameters_9_0= ruleSuiteParameterDefinition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getParametersSuiteParameterDefinitionParserRuleCall_8_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_35);
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
                    	        
                    	    pushFollow(FOLLOW_35);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);


                    }
                    break;

            }

            // InternalDSL.g:1577:5: (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==46) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDSL.g:1577:7: otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+
                    {
                    otherlv_11=(Token)match(input,46,FOLLOW_8); 

                        	newLeafNode(otherlv_11, grammarAccess.getSuiteDefinitionAccess().getReturnsKeyword_9_0());
                        
                    // InternalDSL.g:1581:1: ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_ID) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalDSL.g:1581:2: ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1581:2: ( (lv_return_12_0= ruleSuiteReturnDefinition ) )
                    	    // InternalDSL.g:1582:1: (lv_return_12_0= ruleSuiteReturnDefinition )
                    	    {
                    	    // InternalDSL.g:1582:1: (lv_return_12_0= ruleSuiteReturnDefinition )
                    	    // InternalDSL.g:1583:3: lv_return_12_0= ruleSuiteReturnDefinition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getReturnSuiteReturnDefinitionParserRuleCall_9_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_36);
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
                    	        
                    	    pushFollow(FOLLOW_36);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    }
                    break;

            }

            // InternalDSL.g:1607:5: (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==47) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDSL.g:1607:7: otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_14=(Token)match(input,47,FOLLOW_37); 

                        	newLeafNode(otherlv_14, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_10_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_10_1()); 
                        
                    pushFollow(FOLLOW_37);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:1619:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_ID) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalDSL.g:1619:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1619:2: ( ( ruleQualifiedName ) )
                    	    // InternalDSL.g:1620:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalDSL.g:1620:1: ( ruleQualifiedName )
                    	    // InternalDSL.g:1621:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_10_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_37);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_10_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_37);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDSL.g:1642:5: (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==48) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDSL.g:1642:7: otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_18=(Token)match(input,48,FOLLOW_38); 

                        	newLeafNode(otherlv_18, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_11_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_11_1()); 
                        
                    pushFollow(FOLLOW_38);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:1654:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalDSL.g:1654:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1654:2: ( ( ruleQualifiedName ) )
                    	    // InternalDSL.g:1655:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalDSL.g:1655:1: ( ruleQualifiedName )
                    	    // InternalDSL.g:1656:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_11_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_38);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_11_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_38);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_22=(Token)match(input,31,FOLLOW_39); 

                	newLeafNode(otherlv_22, grammarAccess.getSuiteDefinitionAccess().getWithKeyword_12());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_13()); 
                
            pushFollow(FOLLOW_40);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1689:1: ( (lv_statements_24_0= ruleSuiteStatement ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_SL_VISIBLE_COMMENT && LA32_0<=RULE_DIVIDER)||LA32_0==RULE_ML_DOC_COMMENT||LA32_0==34||LA32_0==43||LA32_0==52||LA32_0==54||LA32_0==56||(LA32_0>=59 && LA32_0<=60)||LA32_0==62||(LA32_0>=64 && LA32_0<=65)||LA32_0==74) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalDSL.g:1690:1: (lv_statements_24_0= ruleSuiteStatement )
            	    {
            	    // InternalDSL.g:1690:1: (lv_statements_24_0= ruleSuiteStatement )
            	    // InternalDSL.g:1691:3: lv_statements_24_0= ruleSuiteStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_14_0()); 
            	    	    
            	    pushFollow(FOLLOW_40);
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
            	    break loop32;
                }
            } while (true);

            otherlv_25=(Token)match(input,49,FOLLOW_6); 

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
    // InternalDSL.g:1727:1: entryRuleSuiteParameterDefinition returns [EObject current=null] : iv_ruleSuiteParameterDefinition= ruleSuiteParameterDefinition EOF ;
    public final EObject entryRuleSuiteParameterDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameterDefinition = null;


        try {
            // InternalDSL.g:1728:2: (iv_ruleSuiteParameterDefinition= ruleSuiteParameterDefinition EOF )
            // InternalDSL.g:1729:2: iv_ruleSuiteParameterDefinition= ruleSuiteParameterDefinition EOF
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
    // InternalDSL.g:1736:1: ruleSuiteParameterDefinition returns [EObject current=null] : ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ) ;
    public final EObject ruleSuiteParameterDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_default_3_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1739:28: ( ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ) )
            // InternalDSL.g:1740:1: ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? )
            {
            // InternalDSL.g:1740:1: ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? )
            // InternalDSL.g:1740:2: ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            {
            // InternalDSL.g:1740:2: ( (lv_name_0_0= ruleVariableEntity ) )
            // InternalDSL.g:1741:1: (lv_name_0_0= ruleVariableEntity )
            {
            // InternalDSL.g:1741:1: (lv_name_0_0= ruleVariableEntity )
            // InternalDSL.g:1742:3: lv_name_0_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterDefinitionAccess().getNameVariableEntityParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_41);
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

            // InternalDSL.g:1758:2: ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // InternalDSL.g:1759:5: ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteParameterDefinitionAccess().getNLParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_42);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,50,FOLLOW_21); 

                        	newLeafNode(otherlv_2, grammarAccess.getSuiteParameterDefinitionAccess().getByDefaultKeyword_1_1());
                        
                    // InternalDSL.g:1770:1: ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:1771:1: (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:1771:1: (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:1772:3: lv_default_3_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:1796:1: entryRuleSuiteReturnDefinition returns [EObject current=null] : iv_ruleSuiteReturnDefinition= ruleSuiteReturnDefinition EOF ;
    public final EObject entryRuleSuiteReturnDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteReturnDefinition = null;


        try {
            // InternalDSL.g:1797:2: (iv_ruleSuiteReturnDefinition= ruleSuiteReturnDefinition EOF )
            // InternalDSL.g:1798:2: iv_ruleSuiteReturnDefinition= ruleSuiteReturnDefinition EOF
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
    // InternalDSL.g:1805:1: ruleSuiteReturnDefinition returns [EObject current=null] : ( (lv_name_0_0= ruleVariableEntity ) ) ;
    public final EObject ruleSuiteReturnDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1808:28: ( ( (lv_name_0_0= ruleVariableEntity ) ) )
            // InternalDSL.g:1809:1: ( (lv_name_0_0= ruleVariableEntity ) )
            {
            // InternalDSL.g:1809:1: ( (lv_name_0_0= ruleVariableEntity ) )
            // InternalDSL.g:1810:1: (lv_name_0_0= ruleVariableEntity )
            {
            // InternalDSL.g:1810:1: (lv_name_0_0= ruleVariableEntity )
            // InternalDSL.g:1811:3: lv_name_0_0= ruleVariableEntity
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
    // InternalDSL.g:1835:1: entryRuleOperationDefinition returns [EObject current=null] : iv_ruleOperationDefinition= ruleOperationDefinition EOF ;
    public final EObject entryRuleOperationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationDefinition = null;


        try {
            // InternalDSL.g:1836:2: (iv_ruleOperationDefinition= ruleOperationDefinition EOF )
            // InternalDSL.g:1837:2: iv_ruleOperationDefinition= ruleOperationDefinition EOF
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
    // InternalDSL.g:1844:1: ruleOperationDefinition returns [EObject current=null] : (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL ) ;
    public final EObject ruleOperationDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_operationType_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1847:28: ( (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL ) )
            // InternalDSL.g:1848:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL )
            {
            // InternalDSL.g:1848:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL )
            // InternalDSL.g:1848:3: otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,51,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getOperationDefinitionAccess().getOperationdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1860:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDSL.g:1861:1: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDSL.g:1861:1: (lv_name_2_0= ruleQualifiedName )
            // InternalDSL.g:1862:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_26);
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
                
            pushFollow(FOLLOW_27);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,36,FOLLOW_8); 

                	newLeafNode(otherlv_4, grammarAccess.getOperationDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1898:1: ( (lv_operationType_6_0= ruleJavaClassReference ) )
            // InternalDSL.g:1899:1: (lv_operationType_6_0= ruleJavaClassReference )
            {
            // InternalDSL.g:1899:1: (lv_operationType_6_0= ruleJavaClassReference )
            // InternalDSL.g:1900:3: lv_operationType_6_0= ruleJavaClassReference
            {
             
            	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getOperationTypeJavaClassReferenceParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_6);
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
    // InternalDSL.g:1932:1: entryRuleSuiteStatement returns [EObject current=null] : iv_ruleSuiteStatement= ruleSuiteStatement EOF ;
    public final EObject entryRuleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatement = null;


        try {
            // InternalDSL.g:1933:2: (iv_ruleSuiteStatement= ruleSuiteStatement EOF )
            // InternalDSL.g:1934:2: iv_ruleSuiteStatement= ruleSuiteStatement EOF
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
    // InternalDSL.g:1941:1: ruleSuiteStatement returns [EObject current=null] : (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_TimeSet_4= ruleTimeSet | this_VisibleComment_5= ruleVisibleComment | this_VisibleDivider_6= ruleVisibleDivider ) ;
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
            // InternalDSL.g:1944:28: ( (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_TimeSet_4= ruleTimeSet | this_VisibleComment_5= ruleVisibleComment | this_VisibleDivider_6= ruleVisibleDivider ) )
            // InternalDSL.g:1945:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_TimeSet_4= ruleTimeSet | this_VisibleComment_5= ruleVisibleComment | this_VisibleDivider_6= ruleVisibleDivider )
            {
            // InternalDSL.g:1945:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_TimeSet_4= ruleTimeSet | this_VisibleComment_5= ruleVisibleComment | this_VisibleDivider_6= ruleVisibleDivider )
            int alt34=7;
            switch ( input.LA(1) ) {
            case 43:
            case 59:
            case 60:
            case 62:
            case 64:
            case 74:
                {
                alt34=1;
                }
                break;
            case 34:
                {
                int LA34_2 = input.LA(2);

                if ( (LA34_2==54) ) {
                    alt34=3;
                }
                else if ( (LA34_2==52) ) {
                    alt34=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 2, input);

                    throw nvae;
                }
                }
                break;
            case 52:
                {
                alt34=2;
                }
                break;
            case RULE_ML_DOC_COMMENT:
            case 54:
                {
                alt34=3;
                }
                break;
            case 56:
                {
                alt34=4;
                }
                break;
            case 65:
                {
                alt34=5;
                }
                break;
            case RULE_SL_VISIBLE_COMMENT:
            case RULE_SL_VISIBLE_TITLE_COMMENT:
            case RULE_ML_VISIBLE_COMMENT:
            case RULE_ML_VISIBLE_TITLE_COMMENT:
                {
                alt34=6;
                }
                break;
            case RULE_DIVIDER:
                {
                alt34=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalDSL.g:1946:5: this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult
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
                    // InternalDSL.g:1956:5: this_VariableDefinition_1= ruleVariableDefinition
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
                    // InternalDSL.g:1966:5: this_ConstantDefinition_2= ruleConstantDefinition
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
                    // InternalDSL.g:1976:5: this_VariableAssignment_3= ruleVariableAssignment
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
                    // InternalDSL.g:1986:5: this_TimeSet_4= ruleTimeSet
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
                    // InternalDSL.g:1996:5: this_VisibleComment_5= ruleVisibleComment
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
                    // InternalDSL.g:2006:5: this_VisibleDivider_6= ruleVisibleDivider
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
    // InternalDSL.g:2022:1: entryRuleSuiteStatementWithResult returns [EObject current=null] : iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF ;
    public final EObject entryRuleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatementWithResult = null;


        try {
            // InternalDSL.g:2023:2: (iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF )
            // InternalDSL.g:2024:2: iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF
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
    // InternalDSL.g:2031:1: ruleSuiteStatementWithResult returns [EObject current=null] : (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) ;
    public final EObject ruleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject this_Suite_0 = null;

        EObject this_Test_1 = null;

        EObject this_TableTest_2 = null;

        EObject this_Call_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2034:28: ( (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) )
            // InternalDSL.g:2035:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            {
            // InternalDSL.g:2035:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            int alt35=4;
            switch ( input.LA(1) ) {
            case 43:
            case 74:
                {
                alt35=1;
                }
                break;
            case 59:
            case 60:
                {
                alt35=2;
                }
                break;
            case 62:
                {
                alt35=3;
                }
                break;
            case 64:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalDSL.g:2036:5: this_Suite_0= ruleSuite
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
                    // InternalDSL.g:2046:5: this_Test_1= ruleTest
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
                    // InternalDSL.g:2056:5: this_TableTest_2= ruleTableTest
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
                    // InternalDSL.g:2066:5: this_Call_3= ruleCall
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
    // InternalDSL.g:2082:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // InternalDSL.g:2083:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // InternalDSL.g:2084:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
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
    // InternalDSL.g:2091:1: ruleVariableDefinition returns [EObject current=null] : ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_name_3_0 = null;

        EObject lv_initialValue_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2094:28: ( ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ) )
            // InternalDSL.g:2095:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? )
            {
            // InternalDSL.g:2095:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? )
            // InternalDSL.g:2095:2: ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            {
            // InternalDSL.g:2095:2: ( (lv_private_0_0= 'private' ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==34) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDSL.g:2096:1: (lv_private_0_0= 'private' )
                    {
                    // InternalDSL.g:2096:1: (lv_private_0_0= 'private' )
                    // InternalDSL.g:2097:3: lv_private_0_0= 'private'
                    {
                    lv_private_0_0=(Token)match(input,34,FOLLOW_43); 

                            newLeafNode(lv_private_0_0, grammarAccess.getVariableDefinitionAccess().getPrivatePrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_0_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,52,FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableDefinitionAccess().getVariableKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2122:1: ( (lv_name_3_0= ruleVariableEntity ) )
            // InternalDSL.g:2123:1: (lv_name_3_0= ruleVariableEntity )
            {
            // InternalDSL.g:2123:1: (lv_name_3_0= ruleVariableEntity )
            // InternalDSL.g:2124:3: lv_name_3_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_44);
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
                
            pushFollow(FOLLOW_45);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2148:1: (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==53) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalDSL.g:2148:3: otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    otherlv_5=(Token)match(input,53,FOLLOW_21); 

                        	newLeafNode(otherlv_5, grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
                    pushFollow(FOLLOW_21);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:2160:1: ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:2161:1: (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:2161:1: (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:2162:3: lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueValueOrEnumValueOrOperationCollectionParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_6);
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
    // InternalDSL.g:2194:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // InternalDSL.g:2195:2: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // InternalDSL.g:2196:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
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
    // InternalDSL.g:2203:1: ruleConstantDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )? ) ;
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
            // InternalDSL.g:2206:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )? ) )
            // InternalDSL.g:2207:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )? )
            {
            // InternalDSL.g:2207:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )? )
            // InternalDSL.g:2207:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )?
            {
            // InternalDSL.g:2207:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ML_DOC_COMMENT) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalDSL.g:2208:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:2208:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:2209:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_46);
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

            // InternalDSL.g:2225:3: ( (lv_private_1_0= 'private' ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==34) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalDSL.g:2226:1: (lv_private_1_0= 'private' )
                    {
                    // InternalDSL.g:2226:1: (lv_private_1_0= 'private' )
                    // InternalDSL.g:2227:3: lv_private_1_0= 'private'
                    {
                    lv_private_1_0=(Token)match(input,34,FOLLOW_47); 

                            newLeafNode(lv_private_1_0, grammarAccess.getConstantDefinitionAccess().getPrivatePrivateKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_1_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,54,FOLLOW_8); 

                	newLeafNode(otherlv_2, grammarAccess.getConstantDefinitionAccess().getConstantKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2252:1: ( (lv_name_4_0= ruleConstantEntity ) )
            // InternalDSL.g:2253:1: (lv_name_4_0= ruleConstantEntity )
            {
            // InternalDSL.g:2253:1: (lv_name_4_0= ruleConstantEntity )
            // InternalDSL.g:2254:3: lv_name_4_0= ruleConstantEntity
            {
             
            	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNameConstantEntityParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_48);
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
                
            pushFollow(FOLLOW_49);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2278:1: ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* )
            // InternalDSL.g:2278:2: ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )*
            {
            // InternalDSL.g:2278:2: ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||(LA40_0>=RULE_INTEGER && LA40_0<=RULE_UPPERCASE_ID)||LA40_0==75||LA40_0==81||LA40_0==83||(LA40_0>=86 && LA40_0<=87)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalDSL.g:2278:3: ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    // InternalDSL.g:2278:3: ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:2279:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:2279:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:2280:3: lv_value_6_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_6_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_50);
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
                        
                    pushFollow(FOLLOW_51);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:2304:3: ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==58) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalDSL.g:2304:4: ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL
            	    {
            	    // InternalDSL.g:2304:4: ( (lv_variantValues_8_0= ruleVariantValue ) )
            	    // InternalDSL.g:2305:1: (lv_variantValues_8_0= ruleVariantValue )
            	    {
            	    // InternalDSL.g:2305:1: (lv_variantValues_8_0= ruleVariantValue )
            	    // InternalDSL.g:2306:3: lv_variantValues_8_0= ruleVariantValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getVariantValuesVariantValueParserRuleCall_6_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_50);
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
            	        
            	    pushFollow(FOLLOW_51);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            // InternalDSL.g:2330:4: ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==55) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalDSL.g:2330:5: ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL
                    {
                    // InternalDSL.g:2330:5: ( (lv_parameterized_10_0= 'parameterized' ) )
                    // InternalDSL.g:2331:1: (lv_parameterized_10_0= 'parameterized' )
                    {
                    // InternalDSL.g:2331:1: (lv_parameterized_10_0= 'parameterized' )
                    // InternalDSL.g:2332:3: lv_parameterized_10_0= 'parameterized'
                    {
                    lv_parameterized_10_0=(Token)match(input,55,FOLLOW_6); 

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
    // InternalDSL.g:2361:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // InternalDSL.g:2362:2: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // InternalDSL.g:2363:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
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
    // InternalDSL.g:2370:1: ruleVariableAssignment returns [EObject current=null] : (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_value_2_0 = null;

        EObject lv_target_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2373:28: ( (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL ) )
            // InternalDSL.g:2374:1: (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL )
            {
            // InternalDSL.g:2374:1: (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL )
            // InternalDSL.g:2374:3: otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL
            {
            otherlv_0=(Token)match(input,56,FOLLOW_21); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableAssignmentAccess().getAssignKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2386:1: ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:2387:1: (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:2387:1: (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:2388:3: lv_value_2_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_52);
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
                
            pushFollow(FOLLOW_53);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,57,FOLLOW_8); 

                	newLeafNode(otherlv_4, grammarAccess.getVariableAssignmentAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2424:1: ( (lv_target_6_0= ruleVariableVariable ) )
            // InternalDSL.g:2425:1: (lv_target_6_0= ruleVariableVariable )
            {
            // InternalDSL.g:2425:1: (lv_target_6_0= ruleVariableVariable )
            // InternalDSL.g:2426:3: lv_target_6_0= ruleVariableVariable
            {
             
            	        newCompositeNode(grammarAccess.getVariableAssignmentAccess().getTargetVariableVariableParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_6);
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
    // InternalDSL.g:2458:1: entryRuleVariantValue returns [EObject current=null] : iv_ruleVariantValue= ruleVariantValue EOF ;
    public final EObject entryRuleVariantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantValue = null;


        try {
            // InternalDSL.g:2459:2: (iv_ruleVariantValue= ruleVariantValue EOF )
            // InternalDSL.g:2460:2: iv_ruleVariantValue= ruleVariantValue EOF
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
    // InternalDSL.g:2467:1: ruleVariantValue returns [EObject current=null] : (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleVariantValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2470:28: ( (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:2471:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:2471:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:2471:3: otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getVariantValueAccess().getInKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2483:1: ( ( ( ruleQualifiedName ) ) ruleNL )+
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
            	    // InternalDSL.g:2483:2: ( ( ruleQualifiedName ) ) ruleNL
            	    {
            	    // InternalDSL.g:2483:2: ( ( ruleQualifiedName ) )
            	    // InternalDSL.g:2484:1: ( ruleQualifiedName )
            	    {
            	    // InternalDSL.g:2484:1: ( ruleQualifiedName )
            	    // InternalDSL.g:2485:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVariantValueRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getVariantValueAccess().getNamesVariantDefinitionCrossReference_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_54);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_54);
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

            otherlv_4=(Token)match(input,38,FOLLOW_21); 

                	newLeafNode(otherlv_4, grammarAccess.getVariantValueAccess().getColonKeyword_3());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2518:1: ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:2519:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:2519:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:2520:3: lv_value_6_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:2544:1: entryRuleVariableEntity returns [EObject current=null] : iv_ruleVariableEntity= ruleVariableEntity EOF ;
    public final EObject entryRuleVariableEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEntity = null;


        try {
            // InternalDSL.g:2545:2: (iv_ruleVariableEntity= ruleVariableEntity EOF )
            // InternalDSL.g:2546:2: iv_ruleVariableEntity= ruleVariableEntity EOF
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
    // InternalDSL.g:2553:1: ruleVariableEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleVariableEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2556:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // InternalDSL.g:2557:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // InternalDSL.g:2557:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalDSL.g:2558:1: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalDSL.g:2558:1: (lv_name_0_0= ruleQualifiedName )
            // InternalDSL.g:2559:3: lv_name_0_0= ruleQualifiedName
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
    // InternalDSL.g:2583:1: entryRuleConstantEntity returns [EObject current=null] : iv_ruleConstantEntity= ruleConstantEntity EOF ;
    public final EObject entryRuleConstantEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantEntity = null;


        try {
            // InternalDSL.g:2584:2: (iv_ruleConstantEntity= ruleConstantEntity EOF )
            // InternalDSL.g:2585:2: iv_ruleConstantEntity= ruleConstantEntity EOF
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
    // InternalDSL.g:2592:1: ruleConstantEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleConstantEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2595:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // InternalDSL.g:2596:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // InternalDSL.g:2596:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalDSL.g:2597:1: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalDSL.g:2597:1: (lv_name_0_0= ruleQualifiedName )
            // InternalDSL.g:2598:3: lv_name_0_0= ruleQualifiedName
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
    // InternalDSL.g:2624:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalDSL.g:2625:2: (iv_ruleTest= ruleTest EOF )
            // InternalDSL.g:2626:2: iv_ruleTest= ruleTest EOF
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
    // InternalDSL.g:2633:1: ruleTest returns [EObject current=null] : ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) ;
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
            // InternalDSL.g:2636:28: ( ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) )
            // InternalDSL.g:2637:1: ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            {
            // InternalDSL.g:2637:1: ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            // InternalDSL.g:2637:2: ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL
            {
            // InternalDSL.g:2637:2: ( (lv_checkpoint_0_0= 'checkpoint' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==59) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalDSL.g:2638:1: (lv_checkpoint_0_0= 'checkpoint' )
                    {
                    // InternalDSL.g:2638:1: (lv_checkpoint_0_0= 'checkpoint' )
                    // InternalDSL.g:2639:3: lv_checkpoint_0_0= 'checkpoint'
                    {
                    lv_checkpoint_0_0=(Token)match(input,59,FOLLOW_55); 

                            newLeafNode(lv_checkpoint_0_0, grammarAccess.getTestAccess().getCheckpointCheckpointKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTestRule());
                    	        }
                           		setWithLastConsumed(current, "checkpoint", lv_checkpoint_0_0, "checkpoint");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,60,FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getTestAccess().getTestKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2664:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:2665:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:2665:1: ( ruleQualifiedName )
            // InternalDSL.g:2666:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_56);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:2679:2: ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )*
            loop45:
            do {
                int alt45=2;
                alt45 = dfa45.predict(input);
                switch (alt45) {
            	case 1 :
            	    // InternalDSL.g:2680:5: ruleNL ( (lv_parameters_5_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_57);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2687:1: ( (lv_parameters_5_0= ruleParameter ) )
            	    // InternalDSL.g:2688:1: (lv_parameters_5_0= ruleParameter )
            	    {
            	    // InternalDSL.g:2688:1: (lv_parameters_5_0= ruleParameter )
            	    // InternalDSL.g:2689:3: lv_parameters_5_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_56);
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
            	    break loop45;
                }
            } while (true);

            // InternalDSL.g:2705:4: ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )*
            loop46:
            do {
                int alt46=2;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // InternalDSL.g:2706:5: ruleNL ( (lv_results_7_0= ruleNamedResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_5_0()); 
            	        
            	    pushFollow(FOLLOW_57);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2713:1: ( (lv_results_7_0= ruleNamedResult ) )
            	    // InternalDSL.g:2714:1: (lv_results_7_0= ruleNamedResult )
            	    {
            	    // InternalDSL.g:2714:1: (lv_results_7_0= ruleNamedResult )
            	    // InternalDSL.g:2715:3: lv_results_7_0= ruleNamedResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_56);
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
            	    break loop46;
                }
            } while (true);

            // InternalDSL.g:2731:4: ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // InternalDSL.g:2732:5: ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_6_0()); 
                        
                    pushFollow(FOLLOW_58);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_9=(Token)match(input,61,FOLLOW_21); 

                        	newLeafNode(otherlv_9, grammarAccess.getTestAccess().getEqualsSignKeyword_6_1());
                        
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_6_2()); 
                        
                    pushFollow(FOLLOW_21);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:2751:1: ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:2752:1: (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:2752:1: (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:2753:3: lv_result_11_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestAccess().getResultValueOrEnumValueOrOperationCollectionParserRuleCall_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_6);
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
    // InternalDSL.g:2785:1: entryRuleTableTest returns [EObject current=null] : iv_ruleTableTest= ruleTableTest EOF ;
    public final EObject entryRuleTableTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTest = null;


        try {
            // InternalDSL.g:2786:2: (iv_ruleTableTest= ruleTableTest EOF )
            // InternalDSL.g:2787:2: iv_ruleTableTest= ruleTableTest EOF
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
    // InternalDSL.g:2794:1: ruleTableTest returns [EObject current=null] : (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) ;
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
            // InternalDSL.g:2797:28: ( (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) )
            // InternalDSL.g:2798:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            {
            // InternalDSL.g:2798:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            // InternalDSL.g:2798:3: otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED
            {
            otherlv_0=(Token)match(input,62,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getTableTestAccess().getTabletestKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2810:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:2811:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:2811:1: ( ruleQualifiedName )
            // InternalDSL.g:2812:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTableTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_57);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:2825:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*
            loop48:
            do {
                int alt48=2;
                alt48 = dfa48.predict(input);
                switch (alt48) {
            	case 1 :
            	    // InternalDSL.g:2826:5: ruleNL ( (lv_parameters_4_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_3_0()); 
            	        
            	    pushFollow(FOLLOW_57);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2833:1: ( (lv_parameters_4_0= ruleParameter ) )
            	    // InternalDSL.g:2834:1: (lv_parameters_4_0= ruleParameter )
            	    {
            	    // InternalDSL.g:2834:1: (lv_parameters_4_0= ruleParameter )
            	    // InternalDSL.g:2835:3: lv_parameters_4_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_57);
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
            	    break loop48;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_4()); 
                
            pushFollow(FOLLOW_59);
            ruleNLFORCED();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2859:1: ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==63) ) {
                    int LA49_1 = input.LA(2);

                    if ( (LA49_1==RULE_ID) ) {
                        int LA49_2 = input.LA(3);

                        if ( (LA49_2==63) ) {
                            alt49=1;
                        }


                    }
                    else if ( (LA49_1==72) ) {
                        int LA49_3 = input.LA(3);

                        if ( (LA49_3==RULE_ID) ) {
                            int LA49_6 = input.LA(4);

                            if ( (LA49_6==63) ) {
                                alt49=1;
                            }


                        }
                        else if ( (LA49_3==RULE_STRING) ) {
                            int LA49_7 = input.LA(4);

                            if ( (LA49_7==63) ) {
                                alt49=1;
                            }


                        }


                    }


                }


                switch (alt49) {
            	case 1 :
            	    // InternalDSL.g:2860:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    {
            	    // InternalDSL.g:2860:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    // InternalDSL.g:2861:3: lv_parameterHeaders_6_0= ruleParameterTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_59);
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
            	    break loop49;
                }
            } while (true);

            // InternalDSL.g:2877:3: ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==63) ) {
                    int LA50_1 = input.LA(2);

                    if ( (LA50_1==RULE_ID||LA50_1==72) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // InternalDSL.g:2878:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    {
            	    // InternalDSL.g:2878:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    // InternalDSL.g:2879:3: lv_resultHeaders_7_0= ruleResultTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_59);
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
            	    break loop50;
                }
            } while (true);

            otherlv_8=(Token)match(input,63,FOLLOW_56); 

                	newLeafNode(otherlv_8, grammarAccess.getTableTestAccess().getVerticalLineKeyword_7());
                
            // InternalDSL.g:2899:1: ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==61) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalDSL.g:2899:2: ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|'
                    {
                    // InternalDSL.g:2899:2: ( (lv_defaultResultColumn_9_0= '=' ) )
                    // InternalDSL.g:2900:1: (lv_defaultResultColumn_9_0= '=' )
                    {
                    // InternalDSL.g:2900:1: (lv_defaultResultColumn_9_0= '=' )
                    // InternalDSL.g:2901:3: lv_defaultResultColumn_9_0= '='
                    {
                    lv_defaultResultColumn_9_0=(Token)match(input,61,FOLLOW_59); 

                            newLeafNode(lv_defaultResultColumn_9_0, grammarAccess.getTableTestAccess().getDefaultResultColumnEqualsSignKeyword_8_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTableTestRule());
                    	        }
                           		setWithLastConsumed(current, "defaultResultColumn", lv_defaultResultColumn_9_0, "=");
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,63,FOLLOW_57); 

                        	newLeafNode(otherlv_10, grammarAccess.getTableTestAccess().getVerticalLineKeyword_8_1());
                        

                    }
                    break;

            }

            // InternalDSL.g:2918:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                alt52 = dfa52.predict(input);
                switch (alt52) {
            	case 1 :
            	    // InternalDSL.g:2919:5: ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_9_0()); 
            	        
            	    pushFollow(FOLLOW_59);
            	    ruleNLFORCED();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2926:1: ( (lv_rows_12_0= ruleTableTestRow ) )
            	    // InternalDSL.g:2927:1: (lv_rows_12_0= ruleTableTestRow )
            	    {
            	    // InternalDSL.g:2927:1: (lv_rows_12_0= ruleTableTestRow )
            	    // InternalDSL.g:2928:3: lv_rows_12_0= ruleTableTestRow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_57);
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
            	    if ( cnt52 >= 1 ) break loop52;
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
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
    // InternalDSL.g:2960:1: entryRuleTableTestRow returns [EObject current=null] : iv_ruleTableTestRow= ruleTableTestRow EOF ;
    public final EObject entryRuleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTestRow = null;


        try {
            // InternalDSL.g:2961:2: (iv_ruleTableTestRow= ruleTableTestRow EOF )
            // InternalDSL.g:2962:2: iv_ruleTableTestRow= ruleTableTestRow EOF
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
    // InternalDSL.g:2969:1: ruleTableTestRow returns [EObject current=null] : ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) ;
    public final EObject ruleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject lv_values_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2972:28: ( ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) )
            // InternalDSL.g:2973:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            {
            // InternalDSL.g:2973:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            // InternalDSL.g:2973:2: () ( (lv_values_1_0= ruleParameterTableValue ) )+
            {
            // InternalDSL.g:2973:2: ()
            // InternalDSL.g:2974:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTableTestRowAccess().getTableTestRowAction_0(),
                        current);
                

            }

            // InternalDSL.g:2979:2: ( (lv_values_1_0= ruleParameterTableValue ) )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==63) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalDSL.g:2980:1: (lv_values_1_0= ruleParameterTableValue )
            	    {
            	    // InternalDSL.g:2980:1: (lv_values_1_0= ruleParameterTableValue )
            	    // InternalDSL.g:2981:3: lv_values_1_0= ruleParameterTableValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_60);
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
            	    if ( cnt53 >= 1 ) break loop53;
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
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
    // InternalDSL.g:3005:1: entryRuleParameterTableHeader returns [EObject current=null] : iv_ruleParameterTableHeader= ruleParameterTableHeader EOF ;
    public final EObject entryRuleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableHeader = null;


        try {
            // InternalDSL.g:3006:2: (iv_ruleParameterTableHeader= ruleParameterTableHeader EOF )
            // InternalDSL.g:3007:2: iv_ruleParameterTableHeader= ruleParameterTableHeader EOF
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
    // InternalDSL.g:3014:1: ruleParameterTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3017:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) )
            // InternalDSL.g:3018:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            {
            // InternalDSL.g:3018:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            // InternalDSL.g:3018:3: otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,63,FOLLOW_57); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0());
                
            // InternalDSL.g:3022:1: ( (lv_name_1_0= ruleParameterName ) )
            // InternalDSL.g:3023:1: (lv_name_1_0= ruleParameterName )
            {
            // InternalDSL.g:3023:1: (lv_name_1_0= ruleParameterName )
            // InternalDSL.g:3024:3: lv_name_1_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_60);
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

            // InternalDSL.g:3040:2: (otherlv_2= '|' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==63) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==EOF||LA54_1==63) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalDSL.g:3040:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,63,FOLLOW_2); 

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
    // InternalDSL.g:3052:1: entryRuleResultTableHeader returns [EObject current=null] : iv_ruleResultTableHeader= ruleResultTableHeader EOF ;
    public final EObject entryRuleResultTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultTableHeader = null;


        try {
            // InternalDSL.g:3053:2: (iv_ruleResultTableHeader= ruleResultTableHeader EOF )
            // InternalDSL.g:3054:2: iv_ruleResultTableHeader= ruleResultTableHeader EOF
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
    // InternalDSL.g:3061:1: ruleResultTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) ;
    public final EObject ruleResultTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3064:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) )
            // InternalDSL.g:3065:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            {
            // InternalDSL.g:3065:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            // InternalDSL.g:3065:3: otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )?
            {
            otherlv_0=(Token)match(input,63,FOLLOW_57); 

                	newLeafNode(otherlv_0, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0());
                
            // InternalDSL.g:3069:1: ( (lv_name_1_0= ruleResultName ) )
            // InternalDSL.g:3070:1: (lv_name_1_0= ruleResultName )
            {
            // InternalDSL.g:3070:1: (lv_name_1_0= ruleResultName )
            // InternalDSL.g:3071:3: lv_name_1_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_58);
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

            otherlv_2=(Token)match(input,61,FOLLOW_60); 

                	newLeafNode(otherlv_2, grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2());
                
            // InternalDSL.g:3091:1: (otherlv_3= '|' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==63) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==EOF||LA55_1==63) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // InternalDSL.g:3091:3: otherlv_3= '|'
                    {
                    otherlv_3=(Token)match(input,63,FOLLOW_2); 

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
    // InternalDSL.g:3103:1: entryRuleParameterTableValue returns [EObject current=null] : iv_ruleParameterTableValue= ruleParameterTableValue EOF ;
    public final EObject entryRuleParameterTableValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableValue = null;


        try {
            // InternalDSL.g:3104:2: (iv_ruleParameterTableValue= ruleParameterTableValue EOF )
            // InternalDSL.g:3105:2: iv_ruleParameterTableValue= ruleParameterTableValue EOF
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
    // InternalDSL.g:3112:1: ruleParameterTableValue returns [EObject current=null] : (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3115:28: ( (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) )
            // InternalDSL.g:3116:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            {
            // InternalDSL.g:3116:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            // InternalDSL.g:3116:3: otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,63,FOLLOW_21); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0());
                
            // InternalDSL.g:3120:1: ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:3121:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:3121:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:3122:3: lv_value_1_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_60);
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

            // InternalDSL.g:3138:2: (otherlv_2= '|' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==63) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==EOF||LA56_1==RULE_NEWLINE||LA56_1==63) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // InternalDSL.g:3138:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,63,FOLLOW_2); 

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
    // InternalDSL.g:3150:1: entryRuleNamedResult returns [EObject current=null] : iv_ruleNamedResult= ruleNamedResult EOF ;
    public final EObject entryRuleNamedResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResult = null;


        try {
            // InternalDSL.g:3151:2: (iv_ruleNamedResult= ruleNamedResult EOF )
            // InternalDSL.g:3152:2: iv_ruleNamedResult= ruleNamedResult EOF
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
    // InternalDSL.g:3159:1: ruleNamedResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleNamedResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3162:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:3163:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:3163:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:3163:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:3163:2: ( (lv_name_0_0= ruleResultName ) )
            // InternalDSL.g:3164:1: (lv_name_0_0= ruleResultName )
            {
            // InternalDSL.g:3164:1: (lv_name_0_0= ruleResultName )
            // InternalDSL.g:3165:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_61);
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
                
            pushFollow(FOLLOW_58);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,61,FOLLOW_21); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedResultAccess().getEqualsSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3201:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:3202:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:3202:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:3203:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:3227:1: entryRuleResultName returns [EObject current=null] : iv_ruleResultName= ruleResultName EOF ;
    public final EObject entryRuleResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultName = null;


        try {
            // InternalDSL.g:3228:2: (iv_ruleResultName= ruleResultName EOF )
            // InternalDSL.g:3229:2: iv_ruleResultName= ruleResultName EOF
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
    // InternalDSL.g:3236:1: ruleResultName returns [EObject current=null] : (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleResultName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedResultName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3239:28: ( (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // InternalDSL.g:3240:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // InternalDSL.g:3240:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                alt57=1;
            }
            else if ( (LA57_0==72) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalDSL.g:3241:5: this_FixedResultName_0= ruleFixedResultName
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
                    // InternalDSL.g:3251:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
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
    // InternalDSL.g:3267:1: entryRuleFixedResultName returns [EObject current=null] : iv_ruleFixedResultName= ruleFixedResultName EOF ;
    public final EObject entryRuleFixedResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedResultName = null;


        try {
            // InternalDSL.g:3268:2: (iv_ruleFixedResultName= ruleFixedResultName EOF )
            // InternalDSL.g:3269:2: iv_ruleFixedResultName= ruleFixedResultName EOF
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
    // InternalDSL.g:3276:1: ruleFixedResultName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:3279:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalDSL.g:3280:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalDSL.g:3280:1: ( (otherlv_0= RULE_ID ) )
            // InternalDSL.g:3281:1: (otherlv_0= RULE_ID )
            {
            // InternalDSL.g:3281:1: (otherlv_0= RULE_ID )
            // InternalDSL.g:3282:3: otherlv_0= RULE_ID
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
    // InternalDSL.g:3301:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalDSL.g:3302:2: (iv_ruleCall= ruleCall EOF )
            // InternalDSL.g:3303:2: iv_ruleCall= ruleCall EOF
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
    // InternalDSL.g:3310:1: ruleCall returns [EObject current=null] : (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL ) ;
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
            // InternalDSL.g:3313:28: ( (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL ) )
            // InternalDSL.g:3314:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL )
            {
            // InternalDSL.g:3314:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL )
            // InternalDSL.g:3314:3: otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL
            {
            otherlv_0=(Token)match(input,64,FOLLOW_62); 

                	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getCallKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_62);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3326:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // InternalDSL.g:3326:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // InternalDSL.g:3326:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) )
                    // InternalDSL.g:3327:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    {
                    // InternalDSL.g:3327:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    // InternalDSL.g:3328:3: lv_multiplier_2_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getMultiplierExecutionMultiplierParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_8);
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
                        
                    pushFollow(FOLLOW_8);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:3352:3: ( ( ruleQualifiedName ) )
            // InternalDSL.g:3353:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:3353:1: ( ruleQualifiedName )
            // InternalDSL.g:3354:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_63);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:3367:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*
            loop59:
            do {
                int alt59=2;
                alt59 = dfa59.predict(input);
                switch (alt59) {
            	case 1 :
            	    // InternalDSL.g:3368:5: ruleNL ( (lv_parameters_6_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_57);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:3375:1: ( (lv_parameters_6_0= ruleParameter ) )
            	    // InternalDSL.g:3376:1: (lv_parameters_6_0= ruleParameter )
            	    {
            	    // InternalDSL.g:3376:1: (lv_parameters_6_0= ruleParameter )
            	    // InternalDSL.g:3377:3: lv_parameters_6_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_63);
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
            	    break loop59;
                }
            } while (true);

            // InternalDSL.g:3393:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*
            loop60:
            do {
                int alt60=2;
                alt60 = dfa60.predict(input);
                switch (alt60) {
            	case 1 :
            	    // InternalDSL.g:3394:5: ruleNL ( (lv_results_8_0= ruleNamedCallResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_5_0()); 
            	        
            	    pushFollow(FOLLOW_57);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:3401:1: ( (lv_results_8_0= ruleNamedCallResult ) )
            	    // InternalDSL.g:3402:1: (lv_results_8_0= ruleNamedCallResult )
            	    {
            	    // InternalDSL.g:3402:1: (lv_results_8_0= ruleNamedCallResult )
            	    // InternalDSL.g:3403:3: lv_results_8_0= ruleNamedCallResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getResultsNamedCallResultParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_63);
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
            	    break loop60;
                }
            } while (true);

            // InternalDSL.g:3419:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalDSL.g:3420:5: ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) )
                    {
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_0()); 
                        
                    pushFollow(FOLLOW_53);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_10=(Token)match(input,57,FOLLOW_8); 

                        	newLeafNode(otherlv_10, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_6_1());
                        
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_2()); 
                        
                    pushFollow(FOLLOW_8);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3439:1: ( (lv_result_12_0= ruleVariableVariable ) )
                    // InternalDSL.g:3440:1: (lv_result_12_0= ruleVariableVariable )
                    {
                    // InternalDSL.g:3440:1: (lv_result_12_0= ruleVariableVariable )
                    // InternalDSL.g:3441:3: lv_result_12_0= ruleVariableVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getResultVariableVariableParserRuleCall_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_6);
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
    // InternalDSL.g:3473:1: entryRuleNamedCallResult returns [EObject current=null] : iv_ruleNamedCallResult= ruleNamedCallResult EOF ;
    public final EObject entryRuleNamedCallResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedCallResult = null;


        try {
            // InternalDSL.g:3474:2: (iv_ruleNamedCallResult= ruleNamedCallResult EOF )
            // InternalDSL.g:3475:2: iv_ruleNamedCallResult= ruleNamedCallResult EOF
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
    // InternalDSL.g:3482:1: ruleNamedCallResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) ;
    public final EObject ruleNamedCallResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_target_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3485:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) )
            // InternalDSL.g:3486:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            {
            // InternalDSL.g:3486:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            // InternalDSL.g:3486:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) )
            {
            // InternalDSL.g:3486:2: ( (lv_name_0_0= ruleResultName ) )
            // InternalDSL.g:3487:1: (lv_name_0_0= ruleResultName )
            {
            // InternalDSL.g:3487:1: (lv_name_0_0= ruleResultName )
            // InternalDSL.g:3488:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedCallResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_52);
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
                
            pushFollow(FOLLOW_53);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,57,FOLLOW_8); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedCallResultAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedCallResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3524:1: ( (lv_target_4_0= ruleVariableVariable ) )
            // InternalDSL.g:3525:1: (lv_target_4_0= ruleVariableVariable )
            {
            // InternalDSL.g:3525:1: (lv_target_4_0= ruleVariableVariable )
            // InternalDSL.g:3526:3: lv_target_4_0= ruleVariableVariable
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
    // InternalDSL.g:3550:1: entryRuleTimeSet returns [EObject current=null] : iv_ruleTimeSet= ruleTimeSet EOF ;
    public final EObject entryRuleTimeSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeSet = null;


        try {
            // InternalDSL.g:3551:2: (iv_ruleTimeSet= ruleTimeSet EOF )
            // InternalDSL.g:3552:2: iv_ruleTimeSet= ruleTimeSet EOF
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
    // InternalDSL.g:3559:1: ruleTimeSet returns [EObject current=null] : (otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) ) ruleNL ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )? ) ) (otherlv_12= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) ) (otherlv_16= ',' )? ruleNL )+ )? ) ;
    public final EObject ruleTimeSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_live_2_0=null;
        Token lv_progressionMode_7_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_masterFork_15_0=null;
        Token otherlv_16=null;
        EObject lv_startTime_4_0 = null;

        EObject lv_diffTime_5_0 = null;

        EObject lv_progressionFactor_9_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3562:28: ( (otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) ) ruleNL ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )? ) ) (otherlv_12= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) ) (otherlv_16= ',' )? ruleNL )+ )? ) )
            // InternalDSL.g:3563:1: (otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) ) ruleNL ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )? ) ) (otherlv_12= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) ) (otherlv_16= ',' )? ruleNL )+ )? )
            {
            // InternalDSL.g:3563:1: (otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) ) ruleNL ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )? ) ) (otherlv_12= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) ) (otherlv_16= ',' )? ruleNL )+ )? )
            // InternalDSL.g:3563:3: otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) ) ruleNL ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )? ) ) (otherlv_12= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) ) (otherlv_16= ',' )? ruleNL )+ )?
            {
            otherlv_0=(Token)match(input,65,FOLLOW_64); 

                	newLeafNode(otherlv_0, grammarAccess.getTimeSetAccess().getTimesetKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_64);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3575:1: ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) ) ruleNL ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )? ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==66) ) {
                alt65=1;
            }
            else if ( ((LA65_0>=RULE_STRING && LA65_0<=RULE_ID)||(LA65_0>=RULE_INTEGER && LA65_0<=RULE_UPPERCASE_ID)||(LA65_0>=72 && LA65_0<=73)||LA65_0==75||LA65_0==81||LA65_0==83||(LA65_0>=86 && LA65_0<=87)) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalDSL.g:3575:2: ( ( (lv_live_2_0= 'live' ) ) ruleNL )
                    {
                    // InternalDSL.g:3575:2: ( ( (lv_live_2_0= 'live' ) ) ruleNL )
                    // InternalDSL.g:3575:3: ( (lv_live_2_0= 'live' ) ) ruleNL
                    {
                    // InternalDSL.g:3575:3: ( (lv_live_2_0= 'live' ) )
                    // InternalDSL.g:3576:1: (lv_live_2_0= 'live' )
                    {
                    // InternalDSL.g:3576:1: (lv_live_2_0= 'live' )
                    // InternalDSL.g:3577:3: lv_live_2_0= 'live'
                    {
                    lv_live_2_0=(Token)match(input,66,FOLLOW_65); 

                            newLeafNode(lv_live_2_0, grammarAccess.getTimeSetAccess().getLiveLiveKeyword_2_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTimeSetRule());
                    	        }
                           		setWithLastConsumed(current, "live", lv_live_2_0, "live");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_2_0_1()); 
                        
                    pushFollow(FOLLOW_66);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:3599:6: ( ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) ) ruleNL ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )? )
                    {
                    // InternalDSL.g:3599:6: ( ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) ) ruleNL ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )? )
                    // InternalDSL.g:3599:7: ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) ) ruleNL ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )?
                    {
                    // InternalDSL.g:3599:7: ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) | ( (lv_diffTime_5_0= ruleTimeDifference ) ) )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( ((LA62_0>=RULE_STRING && LA62_0<=RULE_ID)||(LA62_0>=RULE_INTEGER && LA62_0<=RULE_UPPERCASE_ID)||LA62_0==75||LA62_0==81||LA62_0==83||(LA62_0>=86 && LA62_0<=87)) ) {
                        alt62=1;
                    }
                    else if ( ((LA62_0>=72 && LA62_0<=73)) ) {
                        alt62=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalDSL.g:3599:8: ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) )
                            {
                            // InternalDSL.g:3599:8: ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) )
                            // InternalDSL.g:3600:1: (lv_startTime_4_0= ruleValueOrEnumValueOrOperation )
                            {
                            // InternalDSL.g:3600:1: (lv_startTime_4_0= ruleValueOrEnumValueOrOperation )
                            // InternalDSL.g:3601:3: lv_startTime_4_0= ruleValueOrEnumValueOrOperation
                            {
                             
                            	        newCompositeNode(grammarAccess.getTimeSetAccess().getStartTimeValueOrEnumValueOrOperationParserRuleCall_2_1_0_0_0()); 
                            	    
                            pushFollow(FOLLOW_67);
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


                            }
                            break;
                        case 2 :
                            // InternalDSL.g:3618:6: ( (lv_diffTime_5_0= ruleTimeDifference ) )
                            {
                            // InternalDSL.g:3618:6: ( (lv_diffTime_5_0= ruleTimeDifference ) )
                            // InternalDSL.g:3619:1: (lv_diffTime_5_0= ruleTimeDifference )
                            {
                            // InternalDSL.g:3619:1: (lv_diffTime_5_0= ruleTimeDifference )
                            // InternalDSL.g:3620:3: lv_diffTime_5_0= ruleTimeDifference
                            {
                             
                            	        newCompositeNode(grammarAccess.getTimeSetAccess().getDiffTimeTimeDifferenceParserRuleCall_2_1_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_67);
                            lv_diffTime_5_0=ruleTimeDifference();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTimeSetRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"diffTime",
                                    		lv_diffTime_5_0, 
                                    		"de.gebit.integrity.DSL.TimeDifference");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                     
                            newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_2_1_1()); 
                        
                    pushFollow(FOLLOW_68);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3644:1: ( ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )? )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==67) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // InternalDSL.g:3644:2: ( (lv_progressionMode_7_0= 'progressing' ) ) ruleNL ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )?
                            {
                            // InternalDSL.g:3644:2: ( (lv_progressionMode_7_0= 'progressing' ) )
                            // InternalDSL.g:3645:1: (lv_progressionMode_7_0= 'progressing' )
                            {
                            // InternalDSL.g:3645:1: (lv_progressionMode_7_0= 'progressing' )
                            // InternalDSL.g:3646:3: lv_progressionMode_7_0= 'progressing'
                            {
                            lv_progressionMode_7_0=(Token)match(input,67,FOLLOW_69); 

                                    newLeafNode(lv_progressionMode_7_0, grammarAccess.getTimeSetAccess().getProgressionModeProgressingKeyword_2_1_2_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTimeSetRule());
                            	        }
                                   		setWithLastConsumed(current, "progressionMode", lv_progressionMode_7_0, "progressing");
                            	    

                            }


                            }

                             
                                    newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_2_1_2_1()); 
                                
                            pushFollow(FOLLOW_70);
                            ruleNL();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                
                            // InternalDSL.g:3667:1: ( ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL )?
                            int alt63=2;
                            int LA63_0 = input.LA(1);

                            if ( ((LA63_0>=RULE_STRING && LA63_0<=RULE_ID)||(LA63_0>=RULE_INTEGER && LA63_0<=RULE_UPPERCASE_ID)||LA63_0==75||LA63_0==81||LA63_0==83||(LA63_0>=86 && LA63_0<=87)) ) {
                                alt63=1;
                            }
                            switch (alt63) {
                                case 1 :
                                    // InternalDSL.g:3667:2: ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) ) otherlv_10= 'x' ruleNL
                                    {
                                    // InternalDSL.g:3667:2: ( (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation ) )
                                    // InternalDSL.g:3668:1: (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation )
                                    {
                                    // InternalDSL.g:3668:1: (lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation )
                                    // InternalDSL.g:3669:3: lv_progressionFactor_9_0= ruleValueOrEnumValueOrOperation
                                    {
                                     
                                    	        newCompositeNode(grammarAccess.getTimeSetAccess().getProgressionFactorValueOrEnumValueOrOperationParserRuleCall_2_1_2_2_0_0()); 
                                    	    
                                    pushFollow(FOLLOW_71);
                                    lv_progressionFactor_9_0=ruleValueOrEnumValueOrOperation();

                                    state._fsp--;


                                    	        if (current==null) {
                                    	            current = createModelElementForParent(grammarAccess.getTimeSetRule());
                                    	        }
                                           		set(
                                           			current, 
                                           			"progressionFactor",
                                            		lv_progressionFactor_9_0, 
                                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperation");
                                    	        afterParserOrEnumRuleCall();
                                    	    

                                    }


                                    }

                                    otherlv_10=(Token)match(input,68,FOLLOW_65); 

                                        	newLeafNode(otherlv_10, grammarAccess.getTimeSetAccess().getXKeyword_2_1_2_2_1());
                                        
                                     
                                            newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_2_1_2_2_2()); 
                                        
                                    pushFollow(FOLLOW_66);
                                    ruleNL();

                                    state._fsp--;

                                     
                                            afterParserOrEnumRuleCall();
                                        

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalDSL.g:3697:7: (otherlv_12= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) ) (otherlv_16= ',' )? ruleNL )+ )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==69) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalDSL.g:3697:9: otherlv_12= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) ) (otherlv_16= ',' )? ruleNL )+
                    {
                    otherlv_12=(Token)match(input,69,FOLLOW_72); 

                        	newLeafNode(otherlv_12, grammarAccess.getTimeSetAccess().getOnKeyword_3_0());
                        
                     
                            newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_3_1()); 
                        
                    pushFollow(FOLLOW_72);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3709:1: ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) ) (otherlv_16= ',' )? ruleNL )+
                    int cnt68=0;
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==RULE_ID||LA68_0==70) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalDSL.g:3709:2: ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) ) (otherlv_16= ',' )? ruleNL
                    	    {
                    	    // InternalDSL.g:3709:2: ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_15_0= 'master' ) ) )
                    	    int alt66=2;
                    	    int LA66_0 = input.LA(1);

                    	    if ( (LA66_0==RULE_ID) ) {
                    	        alt66=1;
                    	    }
                    	    else if ( (LA66_0==70) ) {
                    	        alt66=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 66, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt66) {
                    	        case 1 :
                    	            // InternalDSL.g:3709:3: ( ( ruleQualifiedName ) )
                    	            {
                    	            // InternalDSL.g:3709:3: ( ( ruleQualifiedName ) )
                    	            // InternalDSL.g:3710:1: ( ruleQualifiedName )
                    	            {
                    	            // InternalDSL.g:3710:1: ( ruleQualifiedName )
                    	            // InternalDSL.g:3711:3: ruleQualifiedName
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getTimeSetRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getTimeSetAccess().getForksForkDefinitionCrossReference_3_2_0_0_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_73);
                    	            ruleQualifiedName();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalDSL.g:3725:6: ( (lv_masterFork_15_0= 'master' ) )
                    	            {
                    	            // InternalDSL.g:3725:6: ( (lv_masterFork_15_0= 'master' ) )
                    	            // InternalDSL.g:3726:1: (lv_masterFork_15_0= 'master' )
                    	            {
                    	            // InternalDSL.g:3726:1: (lv_masterFork_15_0= 'master' )
                    	            // InternalDSL.g:3727:3: lv_masterFork_15_0= 'master'
                    	            {
                    	            lv_masterFork_15_0=(Token)match(input,70,FOLLOW_73); 

                    	                    newLeafNode(lv_masterFork_15_0, grammarAccess.getTimeSetAccess().getMasterForkMasterKeyword_3_2_0_1_0());
                    	                

                    	            	        if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getTimeSetRule());
                    	            	        }
                    	                   		setWithLastConsumed(current, "masterFork", lv_masterFork_15_0, "master");
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }

                    	    // InternalDSL.g:3740:3: (otherlv_16= ',' )?
                    	    int alt67=2;
                    	    int LA67_0 = input.LA(1);

                    	    if ( (LA67_0==71) ) {
                    	        alt67=1;
                    	    }
                    	    switch (alt67) {
                    	        case 1 :
                    	            // InternalDSL.g:3740:5: otherlv_16= ','
                    	            {
                    	            otherlv_16=(Token)match(input,71,FOLLOW_72); 

                    	                	newLeafNode(otherlv_16, grammarAccess.getTimeSetAccess().getCommaKeyword_3_2_1());
                    	                

                    	            }
                    	            break;

                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_3_2_2()); 
                    	        
                    	    pushFollow(FOLLOW_74);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt68 >= 1 ) break loop68;
                                EarlyExitException eee =
                                    new EarlyExitException(68, input);
                                throw eee;
                        }
                        cnt68++;
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


    // $ANTLR start "entryRuleTimeDifference"
    // InternalDSL.g:3760:1: entryRuleTimeDifference returns [EObject current=null] : iv_ruleTimeDifference= ruleTimeDifference EOF ;
    public final EObject entryRuleTimeDifference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeDifference = null;


        try {
            // InternalDSL.g:3761:2: (iv_ruleTimeDifference= ruleTimeDifference EOF )
            // InternalDSL.g:3762:2: iv_ruleTimeDifference= ruleTimeDifference EOF
            {
             newCompositeNode(grammarAccess.getTimeDifferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeDifference=ruleTimeDifference();

            state._fsp--;

             current =iv_ruleTimeDifference; 
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
    // $ANTLR end "entryRuleTimeDifference"


    // $ANTLR start "ruleTimeDifference"
    // InternalDSL.g:3769:1: ruleTimeDifference returns [EObject current=null] : ( ( ( (lv_direction_0_1= '+' | lv_direction_0_2= '-' ) ) ) ( ruleNL ( (lv_values_2_0= RULE_TIMESPAN ) ) )+ ) ;
    public final EObject ruleTimeDifference() throws RecognitionException {
        EObject current = null;

        Token lv_direction_0_1=null;
        Token lv_direction_0_2=null;
        Token lv_values_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:3772:28: ( ( ( ( (lv_direction_0_1= '+' | lv_direction_0_2= '-' ) ) ) ( ruleNL ( (lv_values_2_0= RULE_TIMESPAN ) ) )+ ) )
            // InternalDSL.g:3773:1: ( ( ( (lv_direction_0_1= '+' | lv_direction_0_2= '-' ) ) ) ( ruleNL ( (lv_values_2_0= RULE_TIMESPAN ) ) )+ )
            {
            // InternalDSL.g:3773:1: ( ( ( (lv_direction_0_1= '+' | lv_direction_0_2= '-' ) ) ) ( ruleNL ( (lv_values_2_0= RULE_TIMESPAN ) ) )+ )
            // InternalDSL.g:3773:2: ( ( (lv_direction_0_1= '+' | lv_direction_0_2= '-' ) ) ) ( ruleNL ( (lv_values_2_0= RULE_TIMESPAN ) ) )+
            {
            // InternalDSL.g:3773:2: ( ( (lv_direction_0_1= '+' | lv_direction_0_2= '-' ) ) )
            // InternalDSL.g:3774:1: ( (lv_direction_0_1= '+' | lv_direction_0_2= '-' ) )
            {
            // InternalDSL.g:3774:1: ( (lv_direction_0_1= '+' | lv_direction_0_2= '-' ) )
            // InternalDSL.g:3775:1: (lv_direction_0_1= '+' | lv_direction_0_2= '-' )
            {
            // InternalDSL.g:3775:1: (lv_direction_0_1= '+' | lv_direction_0_2= '-' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==72) ) {
                alt70=1;
            }
            else if ( (LA70_0==73) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalDSL.g:3776:3: lv_direction_0_1= '+'
                    {
                    lv_direction_0_1=(Token)match(input,72,FOLLOW_75); 

                            newLeafNode(lv_direction_0_1, grammarAccess.getTimeDifferenceAccess().getDirectionPlusSignKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTimeDifferenceRule());
                    	        }
                           		setWithLastConsumed(current, "direction", lv_direction_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalDSL.g:3788:8: lv_direction_0_2= '-'
                    {
                    lv_direction_0_2=(Token)match(input,73,FOLLOW_75); 

                            newLeafNode(lv_direction_0_2, grammarAccess.getTimeDifferenceAccess().getDirectionHyphenMinusKeyword_0_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTimeDifferenceRule());
                    	        }
                           		setWithLastConsumed(current, "direction", lv_direction_0_2, null);
                    	    

                    }
                    break;

            }


            }


            }

            // InternalDSL.g:3803:2: ( ruleNL ( (lv_values_2_0= RULE_TIMESPAN ) ) )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                alt71 = dfa71.predict(input);
                switch (alt71) {
            	case 1 :
            	    // InternalDSL.g:3804:5: ruleNL ( (lv_values_2_0= RULE_TIMESPAN ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTimeDifferenceAccess().getNLParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_76);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:3811:1: ( (lv_values_2_0= RULE_TIMESPAN ) )
            	    // InternalDSL.g:3812:1: (lv_values_2_0= RULE_TIMESPAN )
            	    {
            	    // InternalDSL.g:3812:1: (lv_values_2_0= RULE_TIMESPAN )
            	    // InternalDSL.g:3813:3: lv_values_2_0= RULE_TIMESPAN
            	    {
            	    lv_values_2_0=(Token)match(input,RULE_TIMESPAN,FOLLOW_77); 

            	    			newLeafNode(lv_values_2_0, grammarAccess.getTimeDifferenceAccess().getValuesTIMESPANTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTimeDifferenceRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"values",
            	            		lv_values_2_0, 
            	            		"de.gebit.integrity.DSL.TIMESPAN");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt71 >= 1 ) break loop71;
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
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
    // $ANTLR end "ruleTimeDifference"


    // $ANTLR start "entryRuleSuite"
    // InternalDSL.g:3837:1: entryRuleSuite returns [EObject current=null] : iv_ruleSuite= ruleSuite EOF ;
    public final EObject entryRuleSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuite = null;


        try {
            // InternalDSL.g:3838:2: (iv_ruleSuite= ruleSuite EOF )
            // InternalDSL.g:3839:2: iv_ruleSuite= ruleSuite EOF
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
    // InternalDSL.g:3846:1: ruleSuite returns [EObject current=null] : ( ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )? ) ;
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
            // InternalDSL.g:3849:28: ( ( ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )? ) )
            // InternalDSL.g:3850:1: ( ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )? )
            {
            // InternalDSL.g:3850:1: ( ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )? )
            // InternalDSL.g:3850:2: ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )?
            {
            // InternalDSL.g:3850:2: ( (lv_inlined_0_0= 'inlined' ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==43) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalDSL.g:3851:1: (lv_inlined_0_0= 'inlined' )
                    {
                    // InternalDSL.g:3851:1: (lv_inlined_0_0= 'inlined' )
                    // InternalDSL.g:3852:3: lv_inlined_0_0= 'inlined'
                    {
                    lv_inlined_0_0=(Token)match(input,43,FOLLOW_78); 

                            newLeafNode(lv_inlined_0_0, grammarAccess.getSuiteAccess().getInlinedInlinedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	        }
                           		setWithLastConsumed(current, "inlined", lv_inlined_0_0, "inlined");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,74,FOLLOW_62); 

                	newLeafNode(otherlv_1, grammarAccess.getSuiteAccess().getSuiteKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_62);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3877:1: ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt73=2;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // InternalDSL.g:3877:2: ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // InternalDSL.g:3877:2: ( (lv_multiplier_3_0= ruleExecutionMultiplier ) )
                    // InternalDSL.g:3878:1: (lv_multiplier_3_0= ruleExecutionMultiplier )
                    {
                    // InternalDSL.g:3878:1: (lv_multiplier_3_0= ruleExecutionMultiplier )
                    // InternalDSL.g:3879:3: lv_multiplier_3_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getMultiplierExecutionMultiplierParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_8);
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
                        
                    pushFollow(FOLLOW_8);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:3903:3: ( ( ruleQualifiedName ) )
            // InternalDSL.g:3904:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:3904:1: ( ruleQualifiedName )
            // InternalDSL.g:3905:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_79);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_80);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3926:1: ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )*
            loop74:
            do {
                int alt74=2;
                alt74 = dfa74.predict(input);
                switch (alt74) {
            	case 1 :
            	    // InternalDSL.g:3926:2: ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL
            	    {
            	    // InternalDSL.g:3926:2: ( (lv_parameters_7_0= ruleSuiteParameter ) )
            	    // InternalDSL.g:3927:1: (lv_parameters_7_0= ruleSuiteParameter )
            	    {
            	    // InternalDSL.g:3927:1: (lv_parameters_7_0= ruleSuiteParameter )
            	    // InternalDSL.g:3928:3: lv_parameters_7_0= ruleSuiteParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_6_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_79);
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
            	        
            	    pushFollow(FOLLOW_80);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            // InternalDSL.g:3952:3: ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_ID) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalDSL.g:3952:4: ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL
            	    {
            	    // InternalDSL.g:3952:4: ( (lv_return_9_0= ruleSuiteReturn ) )
            	    // InternalDSL.g:3953:1: (lv_return_9_0= ruleSuiteReturn )
            	    {
            	    // InternalDSL.g:3953:1: (lv_return_9_0= ruleSuiteReturn )
            	    // InternalDSL.g:3954:3: lv_return_9_0= ruleSuiteReturn
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getReturnSuiteReturnParserRuleCall_7_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_79);
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
            	        
            	    pushFollow(FOLLOW_80);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            // InternalDSL.g:3978:3: (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==69) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalDSL.g:3978:5: otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL
                    {
                    otherlv_11=(Token)match(input,69,FOLLOW_8); 

                        	newLeafNode(otherlv_11, grammarAccess.getSuiteAccess().getOnKeyword_8_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_8_1()); 
                        
                    pushFollow(FOLLOW_8);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3990:1: ( ( ruleQualifiedName ) )
                    // InternalDSL.g:3991:1: ( ruleQualifiedName )
                    {
                    // InternalDSL.g:3991:1: ( ruleQualifiedName )
                    // InternalDSL.g:3992:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_8_2_0()); 
                    	    
                    pushFollow(FOLLOW_81);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_8_3()); 
                        
                    pushFollow(FOLLOW_82);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:4013:3: (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==58) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalDSL.g:4013:5: otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+
                    {
                    otherlv_15=(Token)match(input,58,FOLLOW_8); 

                        	newLeafNode(otherlv_15, grammarAccess.getSuiteAccess().getInKeyword_9_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_9_1()); 
                        
                    pushFollow(FOLLOW_8);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:4025:1: ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+
                    int cnt78=0;
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==RULE_ID) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalDSL.g:4025:2: ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL
                    	    {
                    	    // InternalDSL.g:4025:2: ( ( ruleQualifiedName ) )
                    	    // InternalDSL.g:4026:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalDSL.g:4026:1: ( ruleQualifiedName )
                    	    // InternalDSL.g:4027:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteAccess().getVariantsVariantDefinitionCrossReference_9_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_83);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    // InternalDSL.g:4040:2: (otherlv_18= ',' )?
                    	    int alt77=2;
                    	    int LA77_0 = input.LA(1);

                    	    if ( (LA77_0==71) ) {
                    	        alt77=1;
                    	    }
                    	    switch (alt77) {
                    	        case 1 :
                    	            // InternalDSL.g:4040:4: otherlv_18= ','
                    	            {
                    	            otherlv_18=(Token)match(input,71,FOLLOW_8); 

                    	                	newLeafNode(otherlv_18, grammarAccess.getSuiteAccess().getCommaKeyword_9_2_1());
                    	                

                    	            }
                    	            break;

                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_9_2_2()); 
                    	        
                    	    pushFollow(FOLLOW_84);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt78 >= 1 ) break loop78;
                                EarlyExitException eee =
                                    new EarlyExitException(78, input);
                                throw eee;
                        }
                        cnt78++;
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
    // InternalDSL.g:4060:1: entryRuleSuiteParameter returns [EObject current=null] : iv_ruleSuiteParameter= ruleSuiteParameter EOF ;
    public final EObject entryRuleSuiteParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameter = null;


        try {
            // InternalDSL.g:4061:2: (iv_ruleSuiteParameter= ruleSuiteParameter EOF )
            // InternalDSL.g:4062:2: iv_ruleSuiteParameter= ruleSuiteParameter EOF
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
    // InternalDSL.g:4069:1: ruleSuiteParameter returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleSuiteParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4072:28: ( ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:4073:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:4073:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:4073:2: ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:4073:2: ( ( ruleQualifiedName ) )
            // InternalDSL.g:4074:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:4074:1: ( ruleQualifiedName )
            // InternalDSL.g:4075:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getNameVariableOrConstantEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_19);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_20);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,38,FOLLOW_21); 

                	newLeafNode(otherlv_2, grammarAccess.getSuiteParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4108:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:4109:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:4109:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:4110:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:4134:1: entryRuleSuiteReturn returns [EObject current=null] : iv_ruleSuiteReturn= ruleSuiteReturn EOF ;
    public final EObject entryRuleSuiteReturn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteReturn = null;


        try {
            // InternalDSL.g:4135:2: (iv_ruleSuiteReturn= ruleSuiteReturn EOF )
            // InternalDSL.g:4136:2: iv_ruleSuiteReturn= ruleSuiteReturn EOF
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
    // InternalDSL.g:4143:1: ruleSuiteReturn returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) ;
    public final EObject ruleSuiteReturn() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_target_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4146:28: ( ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) )
            // InternalDSL.g:4147:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            {
            // InternalDSL.g:4147:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            // InternalDSL.g:4147:2: ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) )
            {
            // InternalDSL.g:4147:2: ( ( ruleQualifiedName ) )
            // InternalDSL.g:4148:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:4148:1: ( ruleQualifiedName )
            // InternalDSL.g:4149:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteReturnRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteReturnAccess().getNameSuiteReturnDefinitionCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_52);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteReturnAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_53);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,57,FOLLOW_8); 

                	newLeafNode(otherlv_2, grammarAccess.getSuiteReturnAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getSuiteReturnAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4182:1: ( (lv_target_4_0= ruleVariableVariable ) )
            // InternalDSL.g:4183:1: (lv_target_4_0= ruleVariableVariable )
            {
            // InternalDSL.g:4183:1: (lv_target_4_0= ruleVariableVariable )
            // InternalDSL.g:4184:3: lv_target_4_0= ruleVariableVariable
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
    // InternalDSL.g:4208:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalDSL.g:4209:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalDSL.g:4210:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalDSL.g:4217:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4220:28: ( ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:4221:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:4221:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:4221:2: ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:4221:2: ( (lv_name_0_0= ruleParameterName ) )
            // InternalDSL.g:4222:1: (lv_name_0_0= ruleParameterName )
            {
            // InternalDSL.g:4222:1: (lv_name_0_0= ruleParameterName )
            // InternalDSL.g:4223:3: lv_name_0_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_19);
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
                
            pushFollow(FOLLOW_20);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,38,FOLLOW_21); 

                	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4259:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:4260:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:4260:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:4261:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:4285:1: entryRuleParameterName returns [EObject current=null] : iv_ruleParameterName= ruleParameterName EOF ;
    public final EObject entryRuleParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterName = null;


        try {
            // InternalDSL.g:4286:2: (iv_ruleParameterName= ruleParameterName EOF )
            // InternalDSL.g:4287:2: iv_ruleParameterName= ruleParameterName EOF
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
    // InternalDSL.g:4294:1: ruleParameterName returns [EObject current=null] : (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleParameterName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedParameterName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4297:28: ( (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // InternalDSL.g:4298:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // InternalDSL.g:4298:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID) ) {
                alt80=1;
            }
            else if ( (LA80_0==72) ) {
                alt80=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalDSL.g:4299:5: this_FixedParameterName_0= ruleFixedParameterName
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
                    // InternalDSL.g:4309:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
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
    // InternalDSL.g:4325:1: entryRuleFixedParameterName returns [EObject current=null] : iv_ruleFixedParameterName= ruleFixedParameterName EOF ;
    public final EObject entryRuleFixedParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedParameterName = null;


        try {
            // InternalDSL.g:4326:2: (iv_ruleFixedParameterName= ruleFixedParameterName EOF )
            // InternalDSL.g:4327:2: iv_ruleFixedParameterName= ruleFixedParameterName EOF
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
    // InternalDSL.g:4334:1: ruleFixedParameterName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4337:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalDSL.g:4338:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalDSL.g:4338:1: ( (otherlv_0= RULE_ID ) )
            // InternalDSL.g:4339:1: (otherlv_0= RULE_ID )
            {
            // InternalDSL.g:4339:1: (otherlv_0= RULE_ID )
            // InternalDSL.g:4340:3: otherlv_0= RULE_ID
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
    // InternalDSL.g:4359:1: entryRuleArbitraryParameterOrResultName returns [EObject current=null] : iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF ;
    public final EObject entryRuleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryParameterOrResultName = null;


        try {
            // InternalDSL.g:4360:2: (iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF )
            // InternalDSL.g:4361:2: iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF
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
    // InternalDSL.g:4368:1: ruleArbitraryParameterOrResultName returns [EObject current=null] : (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;
        Token lv_stringIdentifier_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4371:28: ( (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) ) )
            // InternalDSL.g:4372:1: (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) )
            {
            // InternalDSL.g:4372:1: (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) )
            // InternalDSL.g:4372:3: otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_85); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0());
                
            // InternalDSL.g:4376:1: ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_ID) ) {
                alt81=1;
            }
            else if ( (LA81_0==RULE_STRING) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // InternalDSL.g:4376:2: ( (lv_identifier_1_0= RULE_ID ) )
                    {
                    // InternalDSL.g:4376:2: ( (lv_identifier_1_0= RULE_ID ) )
                    // InternalDSL.g:4377:1: (lv_identifier_1_0= RULE_ID )
                    {
                    // InternalDSL.g:4377:1: (lv_identifier_1_0= RULE_ID )
                    // InternalDSL.g:4378:3: lv_identifier_1_0= RULE_ID
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
                    // InternalDSL.g:4395:6: ( (lv_stringIdentifier_2_0= RULE_STRING ) )
                    {
                    // InternalDSL.g:4395:6: ( (lv_stringIdentifier_2_0= RULE_STRING ) )
                    // InternalDSL.g:4396:1: (lv_stringIdentifier_2_0= RULE_STRING )
                    {
                    // InternalDSL.g:4396:1: (lv_stringIdentifier_2_0= RULE_STRING )
                    // InternalDSL.g:4397:3: lv_stringIdentifier_2_0= RULE_STRING
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
    // InternalDSL.g:4421:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalDSL.g:4422:2: (iv_ruleOperation= ruleOperation EOF )
            // InternalDSL.g:4423:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalDSL.g:4430:1: ruleOperation returns [EObject current=null] : (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        EObject this_StandardOperation_0 = null;

        EObject this_CustomOperation_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4433:28: ( (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation ) )
            // InternalDSL.g:4434:1: (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation )
            {
            // InternalDSL.g:4434:1: (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==75) ) {
                alt82=1;
            }
            else if ( (LA82_0==81) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalDSL.g:4435:5: this_StandardOperation_0= ruleStandardOperation
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
                    // InternalDSL.g:4445:5: this_CustomOperation_1= ruleCustomOperation
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
    // InternalDSL.g:4461:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // InternalDSL.g:4462:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // InternalDSL.g:4463:2: iv_ruleStandardOperation= ruleStandardOperation EOF
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
    // InternalDSL.g:4470:1: ruleStandardOperation returns [EObject current=null] : (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' ) ;
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
            // InternalDSL.g:4473:28: ( (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' ) )
            // InternalDSL.g:4474:1: (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' )
            {
            // InternalDSL.g:4474:1: (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' )
            // InternalDSL.g:4474:3: otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_21); 

                	newLeafNode(otherlv_0, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getStandardOperationAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4486:1: ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) )
            // InternalDSL.g:4487:1: (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation )
            {
            // InternalDSL.g:4487:1: (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation )
            // InternalDSL.g:4488:3: lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getFirstOperandValueOrEnumValueOrOperationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_86);
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
                
            pushFollow(FOLLOW_87);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4512:1: ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+
            int cnt84=0;
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( ((LA84_0>=72 && LA84_0<=73)||(LA84_0>=76 && LA84_0<=79)) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalDSL.g:4512:2: ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL
            	    {
            	    // InternalDSL.g:4512:2: ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) )
            	    // InternalDSL.g:4513:1: ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) )
            	    {
            	    // InternalDSL.g:4513:1: ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) )
            	    // InternalDSL.g:4514:1: (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' )
            	    {
            	    // InternalDSL.g:4514:1: (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' )
            	    int alt83=6;
            	    switch ( input.LA(1) ) {
            	    case 72:
            	        {
            	        alt83=1;
            	        }
            	        break;
            	    case 73:
            	        {
            	        alt83=2;
            	        }
            	        break;
            	    case 76:
            	        {
            	        alt83=3;
            	        }
            	        break;
            	    case 77:
            	        {
            	        alt83=4;
            	        }
            	        break;
            	    case 78:
            	        {
            	        alt83=5;
            	        }
            	        break;
            	    case 79:
            	        {
            	        alt83=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 83, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt83) {
            	        case 1 :
            	            // InternalDSL.g:4515:3: lv_operators_4_1= '+'
            	            {
            	            lv_operators_4_1=(Token)match(input,72,FOLLOW_21); 

            	                    newLeafNode(lv_operators_4_1, grammarAccess.getStandardOperationAccess().getOperatorsPlusSignKeyword_4_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalDSL.g:4527:8: lv_operators_4_2= '-'
            	            {
            	            lv_operators_4_2=(Token)match(input,73,FOLLOW_21); 

            	                    newLeafNode(lv_operators_4_2, grammarAccess.getStandardOperationAccess().getOperatorsHyphenMinusKeyword_4_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // InternalDSL.g:4539:8: lv_operators_4_3= '*'
            	            {
            	            lv_operators_4_3=(Token)match(input,76,FOLLOW_21); 

            	                    newLeafNode(lv_operators_4_3, grammarAccess.getStandardOperationAccess().getOperatorsAsteriskKeyword_4_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_3, null);
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // InternalDSL.g:4551:8: lv_operators_4_4= '/'
            	            {
            	            lv_operators_4_4=(Token)match(input,77,FOLLOW_21); 

            	                    newLeafNode(lv_operators_4_4, grammarAccess.getStandardOperationAccess().getOperatorsSolidusKeyword_4_0_0_3());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_4, null);
            	            	    

            	            }
            	            break;
            	        case 5 :
            	            // InternalDSL.g:4563:8: lv_operators_4_5= '%'
            	            {
            	            lv_operators_4_5=(Token)match(input,78,FOLLOW_21); 

            	                    newLeafNode(lv_operators_4_5, grammarAccess.getStandardOperationAccess().getOperatorsPercentSignKeyword_4_0_0_4());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_5, null);
            	            	    

            	            }
            	            break;
            	        case 6 :
            	            // InternalDSL.g:4575:8: lv_operators_4_6= '..'
            	            {
            	            lv_operators_4_6=(Token)match(input,79,FOLLOW_21); 

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
            	        
            	    pushFollow(FOLLOW_21);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:4598:1: ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) )
            	    // InternalDSL.g:4599:1: (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation )
            	    {
            	    // InternalDSL.g:4599:1: (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation )
            	    // InternalDSL.g:4600:3: lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getMoreOperandsValueOrEnumValueOrOperationParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_88);
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
            	        
            	    pushFollow(FOLLOW_89);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt84 >= 1 ) break loop84;
                        EarlyExitException eee =
                            new EarlyExitException(84, input);
                        throw eee;
                }
                cnt84++;
            } while (true);

            otherlv_8=(Token)match(input,80,FOLLOW_2); 

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
    // InternalDSL.g:4636:1: entryRuleCustomOperation returns [EObject current=null] : iv_ruleCustomOperation= ruleCustomOperation EOF ;
    public final EObject entryRuleCustomOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomOperation = null;


        try {
            // InternalDSL.g:4637:2: (iv_ruleCustomOperation= ruleCustomOperation EOF )
            // InternalDSL.g:4638:2: iv_ruleCustomOperation= ruleCustomOperation EOF
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
    // InternalDSL.g:4645:1: ruleCustomOperation returns [EObject current=null] : (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' ) ;
    public final EObject ruleCustomOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_prefixOperand_2_0 = null;

        EObject lv_postfixOperand_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4648:28: ( (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' ) )
            // InternalDSL.g:4649:1: (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' )
            {
            // InternalDSL.g:4649:1: (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' )
            // InternalDSL.g:4649:3: otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_21); 

                	newLeafNode(otherlv_0, grammarAccess.getCustomOperationAccess().getLeftSquareBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4661:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt85=2;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // InternalDSL.g:4661:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    // InternalDSL.g:4661:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:4662:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:4662:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:4663:3: lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getCustomOperationAccess().getPrefixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_8);
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
                        
                    pushFollow(FOLLOW_8);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:4687:3: ( ( ruleQualifiedName ) )
            // InternalDSL.g:4688:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:4688:1: ( ruleQualifiedName )
            // InternalDSL.g:4689:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCustomOperationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCustomOperationAccess().getDefinitionOperationDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_90);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:4702:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // InternalDSL.g:4703:5: ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_4_0()); 
                        
                    pushFollow(FOLLOW_9);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_6=(Token)match(input,31,FOLLOW_21); 

                        	newLeafNode(otherlv_6, grammarAccess.getCustomOperationAccess().getWithKeyword_4_1());
                        
                    // InternalDSL.g:4714:1: ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:4715:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:4715:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:4716:3: lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getCustomOperationAccess().getPostfixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_91);
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
                
            pushFollow(FOLLOW_92);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_9=(Token)match(input,82,FOLLOW_2); 

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
    // InternalDSL.g:4752:1: entryRuleValueOrEnumValueOrOperationCollection returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperationCollection = null;


        try {
            // InternalDSL.g:4753:2: (iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF )
            // InternalDSL.g:4754:2: iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF
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
    // InternalDSL.g:4761:1: ruleValueOrEnumValueOrOperationCollection returns [EObject current=null] : ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) ;
    public final EObject ruleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_0_0 = null;

        EObject lv_moreValues_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4764:28: ( ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) )
            // InternalDSL.g:4765:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            {
            // InternalDSL.g:4765:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            // InternalDSL.g:4765:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            {
            // InternalDSL.g:4765:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) )
            // InternalDSL.g:4766:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            {
            // InternalDSL.g:4766:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            // InternalDSL.g:4767:3: lv_value_0_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getValueValueOrEnumValueOrOperationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_93);
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

            // InternalDSL.g:4783:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            loop87:
            do {
                int alt87=2;
                alt87 = dfa87.predict(input);
                switch (alt87) {
            	case 1 :
            	    // InternalDSL.g:4784:5: ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_94);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    otherlv_2=(Token)match(input,71,FOLLOW_21); 

            	        	newLeafNode(otherlv_2, grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getCommaKeyword_1_1());
            	        
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_2()); 
            	        
            	    pushFollow(FOLLOW_21);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:4803:1: ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    // InternalDSL.g:4804:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    {
            	    // InternalDSL.g:4804:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    // InternalDSL.g:4805:3: lv_moreValues_4_0= ruleValueOrEnumValueOrOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getMoreValuesValueOrEnumValueOrOperationParserRuleCall_1_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_93);
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
            	    break loop87;
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
    // InternalDSL.g:4829:1: entryRuleValueOrEnumValueOrOperation returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperation = null;


        try {
            // InternalDSL.g:4830:2: (iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF )
            // InternalDSL.g:4831:2: iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF
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
    // InternalDSL.g:4838:1: ruleValueOrEnumValueOrOperation returns [EObject current=null] : (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) ;
    public final EObject ruleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        EObject this_EnumValue_1 = null;

        EObject this_Operation_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4841:28: ( (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) )
            // InternalDSL.g:4842:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            {
            // InternalDSL.g:4842:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            int alt88=3;
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
            case 83:
            case 86:
            case 87:
                {
                alt88=1;
                }
                break;
            case RULE_UPPERCASE_ID:
                {
                alt88=2;
                }
                break;
            case 75:
            case 81:
                {
                alt88=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalDSL.g:4843:5: this_Value_0= ruleValue
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
                    // InternalDSL.g:4853:5: this_EnumValue_1= ruleEnumValue
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
                    // InternalDSL.g:4863:5: this_Operation_2= ruleOperation
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
    // InternalDSL.g:4879:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalDSL.g:4880:2: (iv_ruleValue= ruleValue EOF )
            // InternalDSL.g:4881:2: iv_ruleValue= ruleValue EOF
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
    // InternalDSL.g:4888:1: ruleValue returns [EObject current=null] : (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StaticValue_0 = null;

        EObject this_Variable_1 = null;

        EObject this_NestedObject_2 = null;

        EObject this_TypedNestedObject_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4891:28: ( (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject ) )
            // InternalDSL.g:4892:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )
            {
            // InternalDSL.g:4892:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )
            int alt89=4;
            alt89 = dfa89.predict(input);
            switch (alt89) {
                case 1 :
                    // InternalDSL.g:4893:5: this_StaticValue_0= ruleStaticValue
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
                    // InternalDSL.g:4903:5: this_Variable_1= ruleVariable
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
                    // InternalDSL.g:4913:5: this_NestedObject_2= ruleNestedObject
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
                    // InternalDSL.g:4923:5: this_TypedNestedObject_3= ruleTypedNestedObject
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
    // InternalDSL.g:4939:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalDSL.g:4940:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalDSL.g:4941:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalDSL.g:4948:1: ruleConstantValue returns [EObject current=null] : (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject this_StaticValue_0 = null;

        EObject this_Constant_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4951:28: ( (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant ) )
            // InternalDSL.g:4952:1: (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant )
            {
            // InternalDSL.g:4952:1: (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_STRING||(LA90_0>=RULE_INTEGER && LA90_0<=RULE_TWELVEHRSTIME)||LA90_0==83||LA90_0==86) ) {
                alt90=1;
            }
            else if ( (LA90_0==RULE_ID) ) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalDSL.g:4953:5: this_StaticValue_0= ruleStaticValue
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
                    // InternalDSL.g:4963:5: this_Constant_1= ruleConstant
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
    // InternalDSL.g:4979:1: entryRuleStaticValue returns [EObject current=null] : iv_ruleStaticValue= ruleStaticValue EOF ;
    public final EObject entryRuleStaticValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticValue = null;


        try {
            // InternalDSL.g:4980:2: (iv_ruleStaticValue= ruleStaticValue EOF )
            // InternalDSL.g:4981:2: iv_ruleStaticValue= ruleStaticValue EOF
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
    // InternalDSL.g:4988:1: ruleStaticValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue ) ;
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
            // InternalDSL.g:4991:28: ( (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue ) )
            // InternalDSL.g:4992:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )
            {
            // InternalDSL.g:4992:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )
            int alt91=9;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // InternalDSL.g:4993:5: this_StringValue_0= ruleStringValue
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
                    // InternalDSL.g:5003:5: this_IntegerValue_1= ruleIntegerValue
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
                    // InternalDSL.g:5013:5: this_DecimalValue_2= ruleDecimalValue
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
                    // InternalDSL.g:5023:5: this_BooleanValue_3= ruleBooleanValue
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
                    // InternalDSL.g:5033:5: this_DateValue_4= ruleDateValue
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
                    // InternalDSL.g:5043:5: this_TimeValue_5= ruleTimeValue
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
                    // InternalDSL.g:5053:5: this_DateAndTimeValue_6= ruleDateAndTimeValue
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
                    // InternalDSL.g:5063:5: this_NullValue_7= ruleNullValue
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
                    // InternalDSL.g:5073:5: this_JavaConstantValue_8= ruleJavaConstantValue
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
    // InternalDSL.g:5089:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // InternalDSL.g:5090:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // InternalDSL.g:5091:2: iv_ruleIntegerValue= ruleIntegerValue EOF
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
    // InternalDSL.g:5098:1: ruleIntegerValue returns [EObject current=null] : ( (lv_integerValue_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_integerValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5101:28: ( ( (lv_integerValue_0_0= RULE_INTEGER ) ) )
            // InternalDSL.g:5102:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            {
            // InternalDSL.g:5102:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            // InternalDSL.g:5103:1: (lv_integerValue_0_0= RULE_INTEGER )
            {
            // InternalDSL.g:5103:1: (lv_integerValue_0_0= RULE_INTEGER )
            // InternalDSL.g:5104:3: lv_integerValue_0_0= RULE_INTEGER
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
    // InternalDSL.g:5128:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalDSL.g:5129:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalDSL.g:5130:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalDSL.g:5137:1: ruleDecimalValue returns [EObject current=null] : ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_decimalValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5140:28: ( ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) )
            // InternalDSL.g:5141:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            {
            // InternalDSL.g:5141:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            // InternalDSL.g:5142:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            {
            // InternalDSL.g:5142:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            // InternalDSL.g:5143:3: lv_decimalValue_0_0= RULE_DECIMAL
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
    // InternalDSL.g:5167:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // InternalDSL.g:5168:2: (iv_ruleStringValue= ruleStringValue EOF )
            // InternalDSL.g:5169:2: iv_ruleStringValue= ruleStringValue EOF
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
    // InternalDSL.g:5176:1: ruleStringValue returns [EObject current=null] : ( (lv_stringValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5179:28: ( ( (lv_stringValue_0_0= RULE_STRING ) ) )
            // InternalDSL.g:5180:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            {
            // InternalDSL.g:5180:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            // InternalDSL.g:5181:1: (lv_stringValue_0_0= RULE_STRING )
            {
            // InternalDSL.g:5181:1: (lv_stringValue_0_0= RULE_STRING )
            // InternalDSL.g:5182:3: lv_stringValue_0_0= RULE_STRING
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
    // InternalDSL.g:5206:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // InternalDSL.g:5207:2: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // InternalDSL.g:5208:2: iv_ruleBooleanValue= ruleBooleanValue EOF
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
    // InternalDSL.g:5215:1: ruleBooleanValue returns [EObject current=null] : ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_booleanValue_0_1=null;
        Token lv_booleanValue_0_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5218:28: ( ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) )
            // InternalDSL.g:5219:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            {
            // InternalDSL.g:5219:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            // InternalDSL.g:5220:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            {
            // InternalDSL.g:5220:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            // InternalDSL.g:5221:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            {
            // InternalDSL.g:5221:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_BOOLEAN_TRUE) ) {
                alt92=1;
            }
            else if ( (LA92_0==RULE_BOOLEAN_FALSE) ) {
                alt92=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // InternalDSL.g:5222:3: lv_booleanValue_0_1= RULE_BOOLEAN_TRUE
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
                    // InternalDSL.g:5237:8: lv_booleanValue_0_2= RULE_BOOLEAN_FALSE
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
    // InternalDSL.g:5263:1: entryRuleDateValue returns [EObject current=null] : iv_ruleDateValue= ruleDateValue EOF ;
    public final EObject entryRuleDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateValue = null;


        try {
            // InternalDSL.g:5264:2: (iv_ruleDateValue= ruleDateValue EOF )
            // InternalDSL.g:5265:2: iv_ruleDateValue= ruleDateValue EOF
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
    // InternalDSL.g:5272:1: ruleDateValue returns [EObject current=null] : (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) ;
    public final EObject ruleDateValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateValue_0 = null;

        EObject this_EuropeanDateValue_1 = null;

        EObject this_USDateValue_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5275:28: ( (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) )
            // InternalDSL.g:5276:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            {
            // InternalDSL.g:5276:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            int alt93=3;
            switch ( input.LA(1) ) {
            case RULE_ISODATE:
                {
                alt93=1;
                }
                break;
            case RULE_EURODATE:
                {
                alt93=2;
                }
                break;
            case RULE_USDATE:
                {
                alt93=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalDSL.g:5277:5: this_IsoDateValue_0= ruleIsoDateValue
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
                    // InternalDSL.g:5287:5: this_EuropeanDateValue_1= ruleEuropeanDateValue
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
                    // InternalDSL.g:5297:5: this_USDateValue_2= ruleUSDateValue
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
    // InternalDSL.g:5313:1: entryRuleIsoDateValue returns [EObject current=null] : iv_ruleIsoDateValue= ruleIsoDateValue EOF ;
    public final EObject entryRuleIsoDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateValue = null;


        try {
            // InternalDSL.g:5314:2: (iv_ruleIsoDateValue= ruleIsoDateValue EOF )
            // InternalDSL.g:5315:2: iv_ruleIsoDateValue= ruleIsoDateValue EOF
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
    // InternalDSL.g:5322:1: ruleIsoDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_ISODATE ) ) ;
    public final EObject ruleIsoDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5325:28: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) )
            // InternalDSL.g:5326:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            {
            // InternalDSL.g:5326:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // InternalDSL.g:5327:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // InternalDSL.g:5327:1: (lv_dateValue_0_0= RULE_ISODATE )
            // InternalDSL.g:5328:3: lv_dateValue_0_0= RULE_ISODATE
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
    // InternalDSL.g:5352:1: entryRuleEuropeanDateValue returns [EObject current=null] : iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF ;
    public final EObject entryRuleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateValue = null;


        try {
            // InternalDSL.g:5353:2: (iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF )
            // InternalDSL.g:5354:2: iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF
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
    // InternalDSL.g:5361:1: ruleEuropeanDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_EURODATE ) ) ;
    public final EObject ruleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5364:28: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) )
            // InternalDSL.g:5365:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            {
            // InternalDSL.g:5365:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // InternalDSL.g:5366:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // InternalDSL.g:5366:1: (lv_dateValue_0_0= RULE_EURODATE )
            // InternalDSL.g:5367:3: lv_dateValue_0_0= RULE_EURODATE
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
    // InternalDSL.g:5391:1: entryRuleUSDateValue returns [EObject current=null] : iv_ruleUSDateValue= ruleUSDateValue EOF ;
    public final EObject entryRuleUSDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateValue = null;


        try {
            // InternalDSL.g:5392:2: (iv_ruleUSDateValue= ruleUSDateValue EOF )
            // InternalDSL.g:5393:2: iv_ruleUSDateValue= ruleUSDateValue EOF
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
    // InternalDSL.g:5400:1: ruleUSDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_USDATE ) ) ;
    public final EObject ruleUSDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5403:28: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) )
            // InternalDSL.g:5404:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            {
            // InternalDSL.g:5404:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // InternalDSL.g:5405:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // InternalDSL.g:5405:1: (lv_dateValue_0_0= RULE_USDATE )
            // InternalDSL.g:5406:3: lv_dateValue_0_0= RULE_USDATE
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
    // InternalDSL.g:5430:1: entryRuleTimeValue returns [EObject current=null] : iv_ruleTimeValue= ruleTimeValue EOF ;
    public final EObject entryRuleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeValue = null;


        try {
            // InternalDSL.g:5431:2: (iv_ruleTimeValue= ruleTimeValue EOF )
            // InternalDSL.g:5432:2: iv_ruleTimeValue= ruleTimeValue EOF
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
    // InternalDSL.g:5439:1: ruleTimeValue returns [EObject current=null] : (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) ;
    public final EObject ruleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoTimeValue_0 = null;

        EObject this_Simple24HrsTimeValue_1 = null;

        EObject this_Simple12HrsTimeValue_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5442:28: ( (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) )
            // InternalDSL.g:5443:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            {
            // InternalDSL.g:5443:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            int alt94=3;
            switch ( input.LA(1) ) {
            case RULE_ISOTIME:
                {
                alt94=1;
                }
                break;
            case RULE_TWENTYFOURHRSTIME:
                {
                alt94=2;
                }
                break;
            case RULE_TWELVEHRSTIME:
                {
                alt94=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // InternalDSL.g:5444:5: this_IsoTimeValue_0= ruleIsoTimeValue
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
                    // InternalDSL.g:5454:5: this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue
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
                    // InternalDSL.g:5464:5: this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue
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
    // InternalDSL.g:5480:1: entryRuleIsoTimeValue returns [EObject current=null] : iv_ruleIsoTimeValue= ruleIsoTimeValue EOF ;
    public final EObject entryRuleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoTimeValue = null;


        try {
            // InternalDSL.g:5481:2: (iv_ruleIsoTimeValue= ruleIsoTimeValue EOF )
            // InternalDSL.g:5482:2: iv_ruleIsoTimeValue= ruleIsoTimeValue EOF
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
    // InternalDSL.g:5489:1: ruleIsoTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_ISOTIME ) ) ;
    public final EObject ruleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5492:28: ( ( (lv_timeValue_0_0= RULE_ISOTIME ) ) )
            // InternalDSL.g:5493:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            {
            // InternalDSL.g:5493:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            // InternalDSL.g:5494:1: (lv_timeValue_0_0= RULE_ISOTIME )
            {
            // InternalDSL.g:5494:1: (lv_timeValue_0_0= RULE_ISOTIME )
            // InternalDSL.g:5495:3: lv_timeValue_0_0= RULE_ISOTIME
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
    // InternalDSL.g:5519:1: entryRuleSimple24HrsTimeValue returns [EObject current=null] : iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF ;
    public final EObject entryRuleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple24HrsTimeValue = null;


        try {
            // InternalDSL.g:5520:2: (iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF )
            // InternalDSL.g:5521:2: iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF
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
    // InternalDSL.g:5528:1: ruleSimple24HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) ;
    public final EObject ruleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5531:28: ( ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) )
            // InternalDSL.g:5532:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // InternalDSL.g:5532:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            // InternalDSL.g:5533:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            {
            // InternalDSL.g:5533:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            // InternalDSL.g:5534:3: lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME
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
    // InternalDSL.g:5558:1: entryRuleSimple12HrsTimeValue returns [EObject current=null] : iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF ;
    public final EObject entryRuleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple12HrsTimeValue = null;


        try {
            // InternalDSL.g:5559:2: (iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF )
            // InternalDSL.g:5560:2: iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF
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
    // InternalDSL.g:5567:1: ruleSimple12HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) ;
    public final EObject ruleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5570:28: ( ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) )
            // InternalDSL.g:5571:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            {
            // InternalDSL.g:5571:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            // InternalDSL.g:5572:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            {
            // InternalDSL.g:5572:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            // InternalDSL.g:5573:3: lv_timeValue_0_0= RULE_TWELVEHRSTIME
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
    // InternalDSL.g:5597:1: entryRuleDateAndTimeValue returns [EObject current=null] : iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF ;
    public final EObject entryRuleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateAndTimeValue = null;


        try {
            // InternalDSL.g:5598:2: (iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF )
            // InternalDSL.g:5599:2: iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF
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
    // InternalDSL.g:5606:1: ruleDateAndTimeValue returns [EObject current=null] : (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) ;
    public final EObject ruleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateAndTimeValue_0 = null;

        EObject this_EuropeanDateAnd24HrsTimeValue_1 = null;

        EObject this_EuropeanDateAnd12HrsTimeValue_2 = null;

        EObject this_USDateAnd12HrsTimeValue_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5609:28: ( (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) )
            // InternalDSL.g:5610:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            {
            // InternalDSL.g:5610:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            int alt95=4;
            alt95 = dfa95.predict(input);
            switch (alt95) {
                case 1 :
                    // InternalDSL.g:5611:5: this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue
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
                    // InternalDSL.g:5621:5: this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue
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
                    // InternalDSL.g:5631:5: this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue
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
                    // InternalDSL.g:5641:5: this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue
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
    // InternalDSL.g:5657:1: entryRuleIsoDateAndTimeValue returns [EObject current=null] : iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF ;
    public final EObject entryRuleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateAndTimeValue = null;


        try {
            // InternalDSL.g:5658:2: (iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF )
            // InternalDSL.g:5659:2: iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF
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
    // InternalDSL.g:5666:1: ruleIsoDateAndTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) ;
    public final EObject ruleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_1_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5669:28: ( ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) )
            // InternalDSL.g:5670:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            {
            // InternalDSL.g:5670:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            // InternalDSL.g:5670:2: ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            {
            // InternalDSL.g:5670:2: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // InternalDSL.g:5671:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // InternalDSL.g:5671:1: (lv_dateValue_0_0= RULE_ISODATE )
            // InternalDSL.g:5672:3: lv_dateValue_0_0= RULE_ISODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_ISODATE,FOLLOW_95); 

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

            // InternalDSL.g:5688:2: ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            // InternalDSL.g:5689:1: (lv_timeValue_1_0= RULE_ISOTIME )
            {
            // InternalDSL.g:5689:1: (lv_timeValue_1_0= RULE_ISOTIME )
            // InternalDSL.g:5690:3: lv_timeValue_1_0= RULE_ISOTIME
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
    // InternalDSL.g:5714:1: entryRuleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd24HrsTimeValue = null;


        try {
            // InternalDSL.g:5715:2: (iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF )
            // InternalDSL.g:5716:2: iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF
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
    // InternalDSL.g:5723:1: ruleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5726:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) )
            // InternalDSL.g:5727:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            {
            // InternalDSL.g:5727:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            // InternalDSL.g:5727:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // InternalDSL.g:5727:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // InternalDSL.g:5728:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // InternalDSL.g:5728:1: (lv_dateValue_0_0= RULE_EURODATE )
            // InternalDSL.g:5729:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_96); 

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
                
            pushFollow(FOLLOW_97);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5753:1: ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            // InternalDSL.g:5754:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            {
            // InternalDSL.g:5754:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            // InternalDSL.g:5755:3: lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME
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
    // InternalDSL.g:5779:1: entryRuleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd12HrsTimeValue = null;


        try {
            // InternalDSL.g:5780:2: (iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF )
            // InternalDSL.g:5781:2: iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF
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
    // InternalDSL.g:5788:1: ruleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5791:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // InternalDSL.g:5792:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // InternalDSL.g:5792:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // InternalDSL.g:5792:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // InternalDSL.g:5792:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // InternalDSL.g:5793:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // InternalDSL.g:5793:1: (lv_dateValue_0_0= RULE_EURODATE )
            // InternalDSL.g:5794:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_98); 

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
                
            pushFollow(FOLLOW_99);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5818:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // InternalDSL.g:5819:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // InternalDSL.g:5819:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // InternalDSL.g:5820:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
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
    // InternalDSL.g:5844:1: entryRuleUSDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateAnd12HrsTimeValue = null;


        try {
            // InternalDSL.g:5845:2: (iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF )
            // InternalDSL.g:5846:2: iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF
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
    // InternalDSL.g:5853:1: ruleUSDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5856:28: ( ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // InternalDSL.g:5857:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // InternalDSL.g:5857:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // InternalDSL.g:5857:2: ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // InternalDSL.g:5857:2: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // InternalDSL.g:5858:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // InternalDSL.g:5858:1: (lv_dateValue_0_0= RULE_USDATE )
            // InternalDSL.g:5859:3: lv_dateValue_0_0= RULE_USDATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_USDATE,FOLLOW_98); 

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
                
            pushFollow(FOLLOW_99);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5883:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // InternalDSL.g:5884:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // InternalDSL.g:5884:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // InternalDSL.g:5885:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
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
    // InternalDSL.g:5909:1: entryRuleJavaConstantValue returns [EObject current=null] : iv_ruleJavaConstantValue= ruleJavaConstantValue EOF ;
    public final EObject entryRuleJavaConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaConstantValue = null;


        try {
            // InternalDSL.g:5910:2: (iv_ruleJavaConstantValue= ruleJavaConstantValue EOF )
            // InternalDSL.g:5911:2: iv_ruleJavaConstantValue= ruleJavaConstantValue EOF
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
    // InternalDSL.g:5918:1: ruleJavaConstantValue returns [EObject current=null] : (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' ) ;
    public final EObject ruleJavaConstantValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_constant_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5921:28: ( (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' ) )
            // InternalDSL.g:5922:1: (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' )
            {
            // InternalDSL.g:5922:1: (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' )
            // InternalDSL.g:5922:3: otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getJavaConstantValueAccess().getLessThanSignKeyword_0());
                
            // InternalDSL.g:5926:1: ( (lv_constant_1_0= ruleJavaConstantReference ) )
            // InternalDSL.g:5927:1: (lv_constant_1_0= ruleJavaConstantReference )
            {
            // InternalDSL.g:5927:1: (lv_constant_1_0= ruleJavaConstantReference )
            // InternalDSL.g:5928:3: lv_constant_1_0= ruleJavaConstantReference
            {
             
            	        newCompositeNode(grammarAccess.getJavaConstantValueAccess().getConstantJavaConstantReferenceParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_100);
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

            otherlv_2=(Token)match(input,84,FOLLOW_2); 

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
    // InternalDSL.g:5956:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalDSL.g:5957:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalDSL.g:5958:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalDSL.g:5965:1: ruleVariable returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_attribute_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5968:28: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? ) )
            // InternalDSL.g:5969:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? )
            {
            // InternalDSL.g:5969:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? )
            // InternalDSL.g:5969:2: ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )?
            {
            // InternalDSL.g:5969:2: ( ( ruleQualifiedName ) )
            // InternalDSL.g:5970:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:5970:1: ( ruleQualifiedName )
            // InternalDSL.g:5971:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getNameVariableOrConstantEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_101);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:5984:2: (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==85) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalDSL.g:5984:4: otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) )
                    {
                    otherlv_1=(Token)match(input,85,FOLLOW_8); 

                        	newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getNumberSignKeyword_1_0());
                        
                    // InternalDSL.g:5988:1: ( (lv_attribute_2_0= ruleQualifiedName ) )
                    // InternalDSL.g:5989:1: (lv_attribute_2_0= ruleQualifiedName )
                    {
                    // InternalDSL.g:5989:1: (lv_attribute_2_0= ruleQualifiedName )
                    // InternalDSL.g:5990:3: lv_attribute_2_0= ruleQualifiedName
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
    // InternalDSL.g:6014:1: entryRuleVariableVariable returns [EObject current=null] : iv_ruleVariableVariable= ruleVariableVariable EOF ;
    public final EObject entryRuleVariableVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableVariable = null;


        try {
            // InternalDSL.g:6015:2: (iv_ruleVariableVariable= ruleVariableVariable EOF )
            // InternalDSL.g:6016:2: iv_ruleVariableVariable= ruleVariableVariable EOF
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
    // InternalDSL.g:6023:1: ruleVariableVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariableVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6026:28: ( ( ( ruleQualifiedName ) ) )
            // InternalDSL.g:6027:1: ( ( ruleQualifiedName ) )
            {
            // InternalDSL.g:6027:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:6028:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:6028:1: ( ruleQualifiedName )
            // InternalDSL.g:6029:3: ruleQualifiedName
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
    // InternalDSL.g:6050:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalDSL.g:6051:2: (iv_ruleConstant= ruleConstant EOF )
            // InternalDSL.g:6052:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalDSL.g:6059:1: ruleConstant returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6062:28: ( ( ( ruleQualifiedName ) ) )
            // InternalDSL.g:6063:1: ( ( ruleQualifiedName ) )
            {
            // InternalDSL.g:6063:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:6064:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:6064:1: ( ruleQualifiedName )
            // InternalDSL.g:6065:3: ruleQualifiedName
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
    // InternalDSL.g:6086:1: entryRuleNullValue returns [EObject current=null] : iv_ruleNullValue= ruleNullValue EOF ;
    public final EObject entryRuleNullValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullValue = null;


        try {
            // InternalDSL.g:6087:2: (iv_ruleNullValue= ruleNullValue EOF )
            // InternalDSL.g:6088:2: iv_ruleNullValue= ruleNullValue EOF
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
    // InternalDSL.g:6095:1: ruleNullValue returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6098:28: ( ( () otherlv_1= 'null' ) )
            // InternalDSL.g:6099:1: ( () otherlv_1= 'null' )
            {
            // InternalDSL.g:6099:1: ( () otherlv_1= 'null' )
            // InternalDSL.g:6099:2: () otherlv_1= 'null'
            {
            // InternalDSL.g:6099:2: ()
            // InternalDSL.g:6100:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNullValueAccess().getNullAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,86,FOLLOW_2); 

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
    // InternalDSL.g:6117:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // InternalDSL.g:6118:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // InternalDSL.g:6119:2: iv_ruleEnumValue= ruleEnumValue EOF
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
    // InternalDSL.g:6126:1: ruleEnumValue returns [EObject current=null] : ( (otherlv_0= RULE_UPPERCASE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6129:28: ( ( (otherlv_0= RULE_UPPERCASE_ID ) ) )
            // InternalDSL.g:6130:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            {
            // InternalDSL.g:6130:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            // InternalDSL.g:6131:1: (otherlv_0= RULE_UPPERCASE_ID )
            {
            // InternalDSL.g:6131:1: (otherlv_0= RULE_UPPERCASE_ID )
            // InternalDSL.g:6132:3: otherlv_0= RULE_UPPERCASE_ID
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
    // InternalDSL.g:6151:1: entryRuleNestedObject returns [EObject current=null] : iv_ruleNestedObject= ruleNestedObject EOF ;
    public final EObject entryRuleNestedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedObject = null;


        try {
            // InternalDSL.g:6152:2: (iv_ruleNestedObject= ruleNestedObject EOF )
            // InternalDSL.g:6153:2: iv_ruleNestedObject= ruleNestedObject EOF
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
    // InternalDSL.g:6160:1: ruleNestedObject returns [EObject current=null] : (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) ;
    public final EObject ruleNestedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_attributes_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6163:28: ( (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) )
            // InternalDSL.g:6164:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            {
            // InternalDSL.g:6164:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            // InternalDSL.g:6164:3: otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,87,FOLLOW_102); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedObjectAccess().getLeftCurlyBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getNestedObjectAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_102);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:6176:1: ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+
            int cnt97=0;
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( ((LA97_0>=RULE_STRING && LA97_0<=RULE_ID)) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalDSL.g:6176:2: ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL
            	    {
            	    // InternalDSL.g:6176:2: ( (lv_attributes_2_0= ruleKeyValuePair ) )
            	    // InternalDSL.g:6177:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    {
            	    // InternalDSL.g:6177:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    // InternalDSL.g:6178:3: lv_attributes_2_0= ruleKeyValuePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNestedObjectAccess().getAttributesKeyValuePairParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_103);
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
            	        
            	    pushFollow(FOLLOW_103);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt97 >= 1 ) break loop97;
                        EarlyExitException eee =
                            new EarlyExitException(97, input);
                        throw eee;
                }
                cnt97++;
            } while (true);

            otherlv_4=(Token)match(input,88,FOLLOW_2); 

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
    // InternalDSL.g:6214:1: entryRuleTypedNestedObject returns [EObject current=null] : iv_ruleTypedNestedObject= ruleTypedNestedObject EOF ;
    public final EObject entryRuleTypedNestedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedNestedObject = null;


        try {
            // InternalDSL.g:6215:2: (iv_ruleTypedNestedObject= ruleTypedNestedObject EOF )
            // InternalDSL.g:6216:2: iv_ruleTypedNestedObject= ruleTypedNestedObject EOF
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
    // InternalDSL.g:6223:1: ruleTypedNestedObject returns [EObject current=null] : (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) ) ;
    public final EObject ruleTypedNestedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_nestedObject_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6226:28: ( (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) ) )
            // InternalDSL.g:6227:1: (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) )
            {
            // InternalDSL.g:6227:1: (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) )
            // InternalDSL.g:6227:3: otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) )
            {
            otherlv_0=(Token)match(input,83,FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getTypedNestedObjectAccess().getLessThanSignKeyword_0());
                
            // InternalDSL.g:6231:1: ( (lv_type_1_0= ruleJavaClassReference ) )
            // InternalDSL.g:6232:1: (lv_type_1_0= ruleJavaClassReference )
            {
            // InternalDSL.g:6232:1: (lv_type_1_0= ruleJavaClassReference )
            // InternalDSL.g:6233:3: lv_type_1_0= ruleJavaClassReference
            {
             
            	        newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getTypeJavaClassReferenceParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_100);
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

            otherlv_2=(Token)match(input,84,FOLLOW_104); 

                	newLeafNode(otherlv_2, grammarAccess.getTypedNestedObjectAccess().getGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_105);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:6261:1: ( (lv_nestedObject_4_0= ruleNestedObject ) )
            // InternalDSL.g:6262:1: (lv_nestedObject_4_0= ruleNestedObject )
            {
            // InternalDSL.g:6262:1: (lv_nestedObject_4_0= ruleNestedObject )
            // InternalDSL.g:6263:3: lv_nestedObject_4_0= ruleNestedObject
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
    // InternalDSL.g:6287:1: entryRuleKeyValuePair returns [EObject current=null] : iv_ruleKeyValuePair= ruleKeyValuePair EOF ;
    public final EObject entryRuleKeyValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValuePair = null;


        try {
            // InternalDSL.g:6288:2: (iv_ruleKeyValuePair= ruleKeyValuePair EOF )
            // InternalDSL.g:6289:2: iv_ruleKeyValuePair= ruleKeyValuePair EOF
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
    // InternalDSL.g:6296:1: ruleKeyValuePair returns [EObject current=null] : ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleKeyValuePair() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        Token lv_stringIdentifier_1_0=null;
        Token otherlv_3=null;
        EObject lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6299:28: ( ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:6300:1: ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:6300:1: ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:6300:2: ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:6300:2: ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==RULE_ID) ) {
                alt98=1;
            }
            else if ( (LA98_0==RULE_STRING) ) {
                alt98=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // InternalDSL.g:6300:3: ( (lv_identifier_0_0= RULE_ID ) )
                    {
                    // InternalDSL.g:6300:3: ( (lv_identifier_0_0= RULE_ID ) )
                    // InternalDSL.g:6301:1: (lv_identifier_0_0= RULE_ID )
                    {
                    // InternalDSL.g:6301:1: (lv_identifier_0_0= RULE_ID )
                    // InternalDSL.g:6302:3: lv_identifier_0_0= RULE_ID
                    {
                    lv_identifier_0_0=(Token)match(input,RULE_ID,FOLLOW_19); 

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
                    // InternalDSL.g:6319:6: ( (lv_stringIdentifier_1_0= RULE_STRING ) )
                    {
                    // InternalDSL.g:6319:6: ( (lv_stringIdentifier_1_0= RULE_STRING ) )
                    // InternalDSL.g:6320:1: (lv_stringIdentifier_1_0= RULE_STRING )
                    {
                    // InternalDSL.g:6320:1: (lv_stringIdentifier_1_0= RULE_STRING )
                    // InternalDSL.g:6321:3: lv_stringIdentifier_1_0= RULE_STRING
                    {
                    lv_stringIdentifier_1_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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
                
            pushFollow(FOLLOW_20);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_3=(Token)match(input,38,FOLLOW_21); 

                	newLeafNode(otherlv_3, grammarAccess.getKeyValuePairAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getKeyValuePairAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:6357:1: ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:6358:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:6358:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:6359:3: lv_value_5_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:6383:1: entryRuleJavaClassReference returns [EObject current=null] : iv_ruleJavaClassReference= ruleJavaClassReference EOF ;
    public final EObject entryRuleJavaClassReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaClassReference = null;


        try {
            // InternalDSL.g:6384:2: (iv_ruleJavaClassReference= ruleJavaClassReference EOF )
            // InternalDSL.g:6385:2: iv_ruleJavaClassReference= ruleJavaClassReference EOF
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
    // InternalDSL.g:6392:1: ruleJavaClassReference returns [EObject current=null] : ( ( ruleQualifiedJavaClassName ) ) ;
    public final EObject ruleJavaClassReference() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6395:28: ( ( ( ruleQualifiedJavaClassName ) ) )
            // InternalDSL.g:6396:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // InternalDSL.g:6396:1: ( ( ruleQualifiedJavaClassName ) )
            // InternalDSL.g:6397:1: ( ruleQualifiedJavaClassName )
            {
            // InternalDSL.g:6397:1: ( ruleQualifiedJavaClassName )
            // InternalDSL.g:6398:3: ruleQualifiedJavaClassName
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
    // InternalDSL.g:6419:1: entryRuleMethodReference returns [EObject current=null] : iv_ruleMethodReference= ruleMethodReference EOF ;
    public final EObject entryRuleMethodReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodReference = null;


        try {
            // InternalDSL.g:6420:2: (iv_ruleMethodReference= ruleMethodReference EOF )
            // InternalDSL.g:6421:2: iv_ruleMethodReference= ruleMethodReference EOF
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
    // InternalDSL.g:6428:1: ruleMethodReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMethodReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6431:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalDSL.g:6432:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalDSL.g:6432:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // InternalDSL.g:6432:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // InternalDSL.g:6432:2: ( ( ruleQualifiedJavaClassName ) )
            // InternalDSL.g:6433:1: ( ruleQualifiedJavaClassName )
            {
            // InternalDSL.g:6433:1: ( ruleQualifiedJavaClassName )
            // InternalDSL.g:6434:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_106);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,85,FOLLOW_107); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1());
                
            // InternalDSL.g:6451:1: ( (otherlv_2= RULE_ID ) )
            // InternalDSL.g:6452:1: (otherlv_2= RULE_ID )
            {
            // InternalDSL.g:6452:1: (otherlv_2= RULE_ID )
            // InternalDSL.g:6453:3: otherlv_2= RULE_ID
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
    // InternalDSL.g:6472:1: entryRuleJavaConstantReference returns [EObject current=null] : iv_ruleJavaConstantReference= ruleJavaConstantReference EOF ;
    public final EObject entryRuleJavaConstantReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaConstantReference = null;


        try {
            // InternalDSL.g:6473:2: (iv_ruleJavaConstantReference= ruleJavaConstantReference EOF )
            // InternalDSL.g:6474:2: iv_ruleJavaConstantReference= ruleJavaConstantReference EOF
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
    // InternalDSL.g:6481:1: ruleJavaConstantReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) ) ;
    public final EObject ruleJavaConstantReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6484:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) ) )
            // InternalDSL.g:6485:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) )
            {
            // InternalDSL.g:6485:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) )
            // InternalDSL.g:6485:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) )
            {
            // InternalDSL.g:6485:2: ( ( ruleQualifiedJavaClassName ) )
            // InternalDSL.g:6486:1: ( ruleQualifiedJavaClassName )
            {
            // InternalDSL.g:6486:1: ( ruleQualifiedJavaClassName )
            // InternalDSL.g:6487:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaConstantReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getJavaConstantReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_106);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,85,FOLLOW_108); 

                	newLeafNode(otherlv_1, grammarAccess.getJavaConstantReferenceAccess().getNumberSignKeyword_1());
                
            // InternalDSL.g:6504:1: ( (otherlv_2= RULE_UPPERCASE_ID ) )
            // InternalDSL.g:6505:1: (otherlv_2= RULE_UPPERCASE_ID )
            {
            // InternalDSL.g:6505:1: (otherlv_2= RULE_UPPERCASE_ID )
            // InternalDSL.g:6506:3: otherlv_2= RULE_UPPERCASE_ID
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
    // InternalDSL.g:6525:1: entryRuleExecutionMultiplier returns [EObject current=null] : iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF ;
    public final EObject entryRuleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutionMultiplier = null;


        try {
            // InternalDSL.g:6526:2: (iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF )
            // InternalDSL.g:6527:2: iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF
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
    // InternalDSL.g:6534:1: ruleExecutionMultiplier returns [EObject current=null] : ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' ) ;
    public final EObject ruleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_count_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6537:28: ( ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' ) )
            // InternalDSL.g:6538:1: ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' )
            {
            // InternalDSL.g:6538:1: ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' )
            // InternalDSL.g:6538:2: ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*'
            {
            // InternalDSL.g:6538:2: ( (lv_count_0_0= ruleConstantValue ) )
            // InternalDSL.g:6539:1: (lv_count_0_0= ruleConstantValue )
            {
            // InternalDSL.g:6539:1: (lv_count_0_0= ruleConstantValue )
            // InternalDSL.g:6540:3: lv_count_0_0= ruleConstantValue
            {
             
            	        newCompositeNode(grammarAccess.getExecutionMultiplierAccess().getCountConstantValueParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_109);
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

            otherlv_1=(Token)match(input,76,FOLLOW_2); 

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
    // InternalDSL.g:6568:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDSL.g:6569:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDSL.g:6570:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalDSL.g:6577:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6580:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalDSL.g:6581:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalDSL.g:6581:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalDSL.g:6581:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_110); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalDSL.g:6588:1: (kw= '.' this_ID_2= RULE_ID )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==89) ) {
                    int LA99_2 = input.LA(2);

                    if ( (LA99_2==RULE_ID) ) {
                        alt99=1;
                    }


                }


                switch (alt99) {
            	case 1 :
            	    // InternalDSL.g:6589:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,89,FOLLOW_107); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_110); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop99;
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
    // InternalDSL.g:6609:1: entryRuleQualifiedJavaClassName returns [String current=null] : iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF ;
    public final String entryRuleQualifiedJavaClassName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedJavaClassName = null;


        try {
            // InternalDSL.g:6610:2: (iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF )
            // InternalDSL.g:6611:2: iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF
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
    // InternalDSL.g:6618:1: ruleQualifiedJavaClassName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedJavaClassName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_UPPERCASE_ID_2=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6621:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) )
            // InternalDSL.g:6622:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            {
            // InternalDSL.g:6622:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            // InternalDSL.g:6623:5: this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID
            {
             
                    newCompositeNode(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_111);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,89,FOLLOW_108); 

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
    // InternalDSL.g:6654:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalDSL.g:6655:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalDSL.g:6656:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
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
    // InternalDSL.g:6663:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6666:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalDSL.g:6667:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalDSL.g:6667:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalDSL.g:6668:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_112);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:6678:1: (kw= '.*' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==90) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalDSL.g:6679:2: kw= '.*'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

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
    // InternalDSL.g:6692:1: entryRuleDocumentationComment returns [EObject current=null] : iv_ruleDocumentationComment= ruleDocumentationComment EOF ;
    public final EObject entryRuleDocumentationComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentationComment = null;


        try {
            // InternalDSL.g:6693:2: (iv_ruleDocumentationComment= ruleDocumentationComment EOF )
            // InternalDSL.g:6694:2: iv_ruleDocumentationComment= ruleDocumentationComment EOF
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
    // InternalDSL.g:6701:1: ruleDocumentationComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL ) ;
    public final EObject ruleDocumentationComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6704:28: ( ( ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:6705:1: ( ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:6705:1: ( ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL )
            // InternalDSL.g:6705:2: ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:6705:2: ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) )
            // InternalDSL.g:6706:1: (lv_content_0_0= RULE_ML_DOC_COMMENT )
            {
            // InternalDSL.g:6706:1: (lv_content_0_0= RULE_ML_DOC_COMMENT )
            // InternalDSL.g:6707:3: lv_content_0_0= RULE_ML_DOC_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_DOC_COMMENT,FOLLOW_6); 

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
    // InternalDSL.g:6739:1: entryRuleNL returns [String current=null] : iv_ruleNL= ruleNL EOF ;
    public final String entryRuleNL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNL = null;


        try {
            // InternalDSL.g:6740:2: (iv_ruleNL= ruleNL EOF )
            // InternalDSL.g:6741:2: iv_ruleNL= ruleNL EOF
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
    // InternalDSL.g:6748:1: ruleNL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* ;
    public final AntlrDatatypeRuleToken ruleNL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6751:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* )
            // InternalDSL.g:6752:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            {
            // InternalDSL.g:6752:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==RULE_NEWLINE) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalDSL.g:6752:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )?
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_113); 

            	    		current.merge(this_NEWLINE_0);
            	        
            	     
            	        newLeafNode(this_NEWLINE_0, grammarAccess.getNLAccess().getNEWLINETerminalRuleCall_0()); 
            	        
            	    // InternalDSL.g:6759:1: (this_WS_1= RULE_WS )?
            	    int alt101=2;
            	    int LA101_0 = input.LA(1);

            	    if ( (LA101_0==RULE_WS) ) {
            	        alt101=1;
            	    }
            	    switch (alt101) {
            	        case 1 :
            	            // InternalDSL.g:6759:6: this_WS_1= RULE_WS
            	            {
            	            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_114); 

            	            		current.merge(this_WS_1);
            	                
            	             
            	                newLeafNode(this_WS_1, grammarAccess.getNLAccess().getWSTerminalRuleCall_1()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
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
    // InternalDSL.g:6774:1: entryRuleNLFORCED returns [String current=null] : iv_ruleNLFORCED= ruleNLFORCED EOF ;
    public final String entryRuleNLFORCED() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNLFORCED = null;


        try {
            // InternalDSL.g:6775:2: (iv_ruleNLFORCED= ruleNLFORCED EOF )
            // InternalDSL.g:6776:2: iv_ruleNLFORCED= ruleNLFORCED EOF
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
    // InternalDSL.g:6783:1: ruleNLFORCED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) ;
    public final AntlrDatatypeRuleToken ruleNLFORCED() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_NL_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6786:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) )
            // InternalDSL.g:6787:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            {
            // InternalDSL.g:6787:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            // InternalDSL.g:6787:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL
            {
            this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_115); 

            		current.merge(this_NEWLINE_0);
                
             
                newLeafNode(this_NEWLINE_0, grammarAccess.getNLFORCEDAccess().getNEWLINETerminalRuleCall_0()); 
                
            // InternalDSL.g:6794:1: (this_WS_1= RULE_WS )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_WS) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalDSL.g:6794:6: this_WS_1= RULE_WS
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_6); 

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


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA71 dfa71 = new DFA71(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA89 dfa89 = new DFA89(this);
    protected DFA91 dfa91 = new DFA91(this);
    protected DFA95 dfa95 = new DFA95(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\27\1\30\3\uffff\2\30";
    static final String dfa_3s = "\2\47\3\uffff\2\47";
    static final String dfa_4s = "\2\uffff\1\1\1\2\1\3\2\uffff";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\6\uffff\1\2\3\uffff\2\3\3\uffff\1\4",
            "\1\5\5\uffff\1\2\3\uffff\2\3\3\uffff\1\4",
            "",
            "",
            "",
            "\1\5\1\6\4\uffff\1\2\3\uffff\2\3\3\uffff\1\4",
            "\1\5\5\uffff\1\2\3\uffff\2\3\3\uffff\1\4"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "159:1: (this_PackageDefinition_0= rulePackageDefinition | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition )";
        }
    }
    static final String dfa_7s = "\16\uffff";
    static final String dfa_8s = "\1\27\1\30\1\43\10\uffff\1\30\1\43\1\30";
    static final String dfa_9s = "\3\66\10\uffff\3\66";
    static final String dfa_10s = "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\3\uffff";
    static final String dfa_11s = "\16\uffff}>";
    static final String[] dfa_12s = {
            "\1\1\12\uffff\1\2\1\3\3\uffff\1\4\1\5\1\6\3\10\6\uffff\1\7\1\11\1\uffff\1\12",
            "\1\13\11\uffff\1\14\1\3\3\uffff\1\4\1\5\1\6\3\10\11\uffff\1\12",
            "\1\3\6\uffff\3\10\7\uffff\1\11\1\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13\1\15\10\uffff\1\14\1\3\3\uffff\1\4\1\5\1\6\3\10\11\uffff\1\12",
            "\1\3\6\uffff\3\10\11\uffff\1\12",
            "\1\13\11\uffff\1\14\1\3\3\uffff\1\4\1\5\1\6\3\10\11\uffff\1\12"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "675:1: (this_ForkDefinition_0= ruleForkDefinition | this_VariantDefinition_1= ruleVariantDefinition | this_TestDefinition_2= ruleTestDefinition | this_CallDefinition_3= ruleCallDefinition | this_OperationDefinition_4= ruleOperationDefinition | this_SuiteDefinition_5= ruleSuiteDefinition | this_VariableDefinition_6= ruleVariableDefinition | this_ConstantDefinition_7= ruleConstantDefinition )";
        }
    }
    static final String dfa_13s = "\5\uffff";
    static final String dfa_14s = "\1\3\4\uffff";
    static final String dfa_15s = "\2\12\2\uffff\1\12";
    static final String dfa_16s = "\2\62\2\uffff\1\62";
    static final String dfa_17s = "\2\uffff\1\1\1\2\1\uffff";
    static final String dfa_18s = "\5\uffff}>";
    static final String[] dfa_19s = {
            "\1\3\15\uffff\1\1\6\uffff\1\3\16\uffff\3\3\1\uffff\1\2",
            "\1\3\15\uffff\1\1\1\4\5\uffff\1\3\16\uffff\3\3\1\uffff\1\2",
            "",
            "",
            "\1\3\15\uffff\1\1\6\uffff\1\3\16\uffff\3\3\1\uffff\1\2"
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1758:2: ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String dfa_20s = "\13\uffff";
    static final String dfa_21s = "\2\4\3\uffff\1\4\5\uffff";
    static final String dfa_22s = "\2\4\1\30\1\11\1\uffff\1\4\1\30\1\uffff\3\30";
    static final String dfa_23s = "\2\112\1\75\1\12\1\uffff\1\112\1\75\1\uffff\3\75";
    static final String dfa_24s = "\4\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String dfa_25s = "\13\uffff}>";
    static final String[] dfa_26s = {
            "\5\4\1\uffff\1\2\14\uffff\1\4\1\1\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\4\4\1\uffff\2\4\6\uffff\1\3\1\uffff\1\4",
            "\5\4\1\uffff\1\2\14\uffff\1\4\1\1\1\5\10\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\4\4\1\uffff\2\4\6\uffff\1\3\1\uffff\1\4",
            "\1\6\15\uffff\1\7\26\uffff\1\4",
            "\1\11\1\10",
            "",
            "\5\4\1\uffff\1\2\14\uffff\1\4\1\1\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\4\4\1\uffff\2\4\6\uffff\1\3\1\uffff\1\4",
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

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "()* loopback of 2679:2: ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )*";
        }
    }
    static final String dfa_27s = "\2\2\2\uffff\1\2";
    static final String dfa_28s = "\2\4\2\uffff\1\4";
    static final String dfa_29s = "\2\112\2\uffff\1\112";
    static final String dfa_30s = "\2\uffff\1\2\1\1\1\uffff";
    static final String[] dfa_31s = {
            "\5\2\1\uffff\1\3\14\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff\2\2\6\uffff\1\3\1\uffff\1\2",
            "\5\2\1\uffff\1\3\14\uffff\1\2\1\1\1\4\10\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff\2\2\6\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\5\2\1\uffff\1\3\14\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff\2\2\6\uffff\1\3\1\uffff\1\2"
    };
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = dfa_13;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_18;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "()* loopback of 2705:4: ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )*";
        }
    }
    static final String dfa_32s = "\2\3\2\uffff\1\3";
    static final String[] dfa_33s = {
            "\5\3\16\uffff\1\3\1\1\11\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\2\3\1\2\1\3\1\uffff\2\3\10\uffff\1\3",
            "\5\3\16\uffff\1\3\1\1\1\4\10\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\2\3\1\2\1\3\1\uffff\2\3\10\uffff\1\3",
            "",
            "",
            "\5\3\16\uffff\1\3\1\1\11\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\2\3\1\2\1\3\1\uffff\2\3\10\uffff\1\3"
    };
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = dfa_13;
            this.eof = dfa_32;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "2731:4: ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String dfa_34s = "\2\12\1\uffff\2\12\1\uffff\1\12";
    static final String dfa_35s = "\2\110\1\uffff\2\110\1\uffff\1\110";
    static final String dfa_36s = "\2\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String[] dfa_37s = {
            "\1\2\15\uffff\1\1\57\uffff\1\2",
            "\1\2\15\uffff\1\4\1\3\45\uffff\1\5\10\uffff\1\2",
            "",
            "\1\2\15\uffff\1\4\46\uffff\1\5\10\uffff\1\2",
            "\1\2\15\uffff\1\4\1\6\45\uffff\1\5\10\uffff\1\2",
            "",
            "\1\2\15\uffff\1\4\46\uffff\1\5\10\uffff\1\2"
    };
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[][] dfa_37 = unpackEncodedStringArray(dfa_37s);

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_5;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "()* loopback of 2825:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*";
        }
    }
    static final String dfa_38s = "\1\uffff\3\5\2\uffff\1\5";
    static final String dfa_39s = "\1\30\3\4\2\uffff\1\4";
    static final String dfa_40s = "\1\30\3\112\2\uffff\1\112";
    static final String dfa_41s = "\4\uffff\1\1\1\2\1\uffff";
    static final String[] dfa_42s = {
            "\1\1",
            "\5\5\16\uffff\1\5\1\3\1\2\10\uffff\1\5\10\uffff\1\5\5\uffff\1\5\2\uffff\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\2\5\1\uffff\1\5\1\4\2\5\10\uffff\1\5",
            "\5\5\16\uffff\1\5\1\3\11\uffff\1\5\10\uffff\1\5\5\uffff\1\5\2\uffff\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\2\5\1\uffff\1\5\1\4\2\5\10\uffff\1\5",
            "\5\5\16\uffff\1\5\1\3\1\6\10\uffff\1\5\10\uffff\1\5\5\uffff\1\5\2\uffff\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\2\5\1\uffff\1\5\1\4\2\5\10\uffff\1\5",
            "",
            "",
            "\5\5\16\uffff\1\5\1\3\11\uffff\1\5\10\uffff\1\5\5\uffff\1\5\2\uffff\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\2\5\1\uffff\1\5\1\4\2\5\10\uffff\1\5"
    };
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final short[][] dfa_42 = unpackEncodedStringArray(dfa_42s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_1;
            this.eof = dfa_38;
            this.min = dfa_39;
            this.max = dfa_40;
            this.accept = dfa_41;
            this.special = dfa_5;
            this.transition = dfa_42;
        }
        public String getDescription() {
            return "()+ loopback of 2918:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+";
        }
    }
    static final String dfa_43s = "\6\uffff";
    static final String dfa_44s = "\2\uffff\1\4\2\uffff\1\4";
    static final String dfa_45s = "\1\11\1\uffff\1\4\1\12\1\uffff\1\4";
    static final String dfa_46s = "\1\126\1\uffff\1\131\1\12\1\uffff\1\131";
    static final String dfa_47s = "\1\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String dfa_48s = "\6\uffff}>";
    static final String[] dfa_49s = {
            "\1\1\1\2\1\uffff\12\1\75\uffff\1\1\2\uffff\1\1",
            "",
            "\5\4\1\uffff\1\4\14\uffff\2\4\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\1\4\1\uffff\1\4\1\uffff\1\1\14\uffff\1\3",
            "\1\5",
            "",
            "\5\4\1\uffff\1\4\14\uffff\2\4\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\1\4\1\uffff\1\4\1\uffff\1\1\14\uffff\1\3"
    };

    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final char[] dfa_45 = DFA.unpackEncodedStringToUnsignedChars(dfa_45s);
    static final char[] dfa_46 = DFA.unpackEncodedStringToUnsignedChars(dfa_46s);
    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final short[] dfa_48 = DFA.unpackEncodedString(dfa_48s);
    static final short[][] dfa_49 = unpackEncodedStringArray(dfa_49s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_43;
            this.eof = dfa_44;
            this.min = dfa_45;
            this.max = dfa_46;
            this.accept = dfa_47;
            this.special = dfa_48;
            this.transition = dfa_49;
        }
        public String getDescription() {
            return "3326:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?";
        }
    }
    static final String dfa_50s = "\2\112\1\71\1\12\1\uffff\1\112\1\71\1\uffff\3\71";
    static final String[] dfa_51s = {
            "\5\4\1\uffff\1\2\14\uffff\1\4\1\1\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\1\3\1\uffff\1\4",
            "\5\4\1\uffff\1\2\14\uffff\1\4\1\1\1\5\10\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\1\3\1\uffff\1\4",
            "\1\6\15\uffff\1\7\22\uffff\1\4",
            "\1\11\1\10",
            "",
            "\5\4\1\uffff\1\2\14\uffff\1\4\1\1\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\1\3\1\uffff\1\4",
            "\1\6\1\12\14\uffff\1\7\22\uffff\1\4",
            "",
            "\1\6\15\uffff\1\7\22\uffff\1\4",
            "\1\6\15\uffff\1\7\22\uffff\1\4",
            "\1\6\15\uffff\1\7\22\uffff\1\4"
    };
    static final char[] dfa_50 = DFA.unpackEncodedStringToUnsignedChars(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_50;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "()* loopback of 3367:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*";
        }
    }
    static final String[] dfa_52s = {
            "\5\2\1\uffff\1\3\14\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\6\uffff\1\3\1\uffff\1\2",
            "\5\2\1\uffff\1\3\14\uffff\1\2\1\1\1\4\10\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\6\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\5\2\1\uffff\1\3\14\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\6\uffff\1\3\1\uffff\1\2"
    };
    static final short[][] dfa_52 = unpackEncodedStringArray(dfa_52s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_13;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_18;
            this.transition = dfa_52;
        }
        public String getDescription() {
            return "()* loopback of 3393:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*";
        }
    }
    static final String[] dfa_53s = {
            "\5\3\16\uffff\1\3\1\1\11\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3\10\uffff\1\3",
            "\5\3\16\uffff\1\3\1\1\1\4\10\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3\10\uffff\1\3",
            "",
            "",
            "\5\3\16\uffff\1\3\1\1\11\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3\10\uffff\1\3"
    };
    static final short[][] dfa_53 = unpackEncodedStringArray(dfa_53s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_13;
            this.eof = dfa_32;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_53;
        }
        public String getDescription() {
            return "3419:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )?";
        }
    }
    static final String[] dfa_54s = {
            "\5\2\2\uffff\1\3\13\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\2\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\2\1\uffff\1\2\4\uffff\1\2",
            "\5\2\2\uffff\1\3\13\uffff\1\2\1\1\1\4\10\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\2\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\2\1\uffff\1\2\4\uffff\1\2",
            "",
            "",
            "\5\2\2\uffff\1\3\13\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\2\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\2\1\uffff\1\2\4\uffff\1\2"
    };
    static final short[][] dfa_54 = unpackEncodedStringArray(dfa_54s);

    class DFA71 extends DFA {

        public DFA71(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 71;
            this.eot = dfa_13;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_18;
            this.transition = dfa_54;
        }
        public String getDescription() {
            return "()+ loopback of 3803:2: ( ruleNL ( (lv_values_2_0= RULE_TIMESPAN ) ) )+";
        }
    }
    static final String[] dfa_55s = {
            "\1\1\1\2\1\uffff\12\1\75\uffff\1\1\2\uffff\1\1",
            "",
            "\5\4\1\uffff\1\4\14\uffff\2\4\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff\2\4\3\uffff\1\4\4\uffff\1\4\1\uffff\1\1\14\uffff\1\3",
            "\1\5",
            "",
            "\5\4\1\uffff\1\4\14\uffff\2\4\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff\2\4\3\uffff\1\4\4\uffff\1\4\1\uffff\1\1\14\uffff\1\3"
    };
    static final short[][] dfa_55 = unpackEncodedStringArray(dfa_55s);

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = dfa_43;
            this.eof = dfa_44;
            this.min = dfa_45;
            this.max = dfa_46;
            this.accept = dfa_47;
            this.special = dfa_48;
            this.transition = dfa_55;
        }
        public String getDescription() {
            return "3877:1: ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )?";
        }
    }
    static final String dfa_56s = "\10\uffff";
    static final String dfa_57s = "\1\2\7\uffff";
    static final String dfa_58s = "\1\4\1\30\1\uffff\1\12\1\30\1\uffff\2\30";
    static final String dfa_59s = "\1\112\1\131\1\uffff\1\12\1\71\1\uffff\1\131\1\71";
    static final String dfa_60s = "\2\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String dfa_61s = "\10\uffff}>";
    static final String[] dfa_62s = {
            "\5\2\1\uffff\1\1\14\uffff\1\2\12\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1\2\1\uffff\2\2\3\uffff\1\2\4\uffff\1\2",
            "\1\4\15\uffff\1\5\22\uffff\1\2\37\uffff\1\3",
            "",
            "\1\6",
            "\1\4\1\7\14\uffff\1\5\22\uffff\1\2",
            "",
            "\1\4\15\uffff\1\5\22\uffff\1\2\37\uffff\1\3",
            "\1\4\15\uffff\1\5\22\uffff\1\2"
    };

    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final short[] dfa_57 = DFA.unpackEncodedString(dfa_57s);
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final char[] dfa_59 = DFA.unpackEncodedStringToUnsignedChars(dfa_59s);
    static final short[] dfa_60 = DFA.unpackEncodedString(dfa_60s);
    static final short[] dfa_61 = DFA.unpackEncodedString(dfa_61s);
    static final short[][] dfa_62 = unpackEncodedStringArray(dfa_62s);

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = dfa_56;
            this.eof = dfa_57;
            this.min = dfa_58;
            this.max = dfa_59;
            this.accept = dfa_60;
            this.special = dfa_61;
            this.transition = dfa_62;
        }
        public String getDescription() {
            return "()* loopback of 3926:1: ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )*";
        }
    }
    static final String dfa_63s = "\1\11\1\uffff\3\12\1\uffff\2\12";
    static final String dfa_64s = "\1\127\1\uffff\1\131\1\12\1\122\1\uffff\1\131\1\122";
    static final String dfa_65s = "\1\uffff\1\1\3\uffff\1\2\2\uffff";
    static final String[] dfa_66s = {
            "\1\1\1\2\1\uffff\13\1\64\uffff\1\1\5\uffff\1\1\1\uffff\1\1\2\uffff\2\1",
            "",
            "\1\1\15\uffff\1\4\6\uffff\1\5\47\uffff\1\1\12\uffff\1\5\2\uffff\1\1\3\uffff\1\3",
            "\1\6",
            "\1\1\15\uffff\1\4\1\7\5\uffff\1\5\47\uffff\1\1\12\uffff\1\5",
            "",
            "\1\1\15\uffff\1\4\6\uffff\1\5\47\uffff\1\1\12\uffff\1\5\2\uffff\1\1\3\uffff\1\3",
            "\1\1\15\uffff\1\4\6\uffff\1\5\47\uffff\1\1\12\uffff\1\5"
    };
    static final char[] dfa_63 = DFA.unpackEncodedStringToUnsignedChars(dfa_63s);
    static final char[] dfa_64 = DFA.unpackEncodedStringToUnsignedChars(dfa_64s);
    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[][] dfa_66 = unpackEncodedStringArray(dfa_66s);

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = dfa_56;
            this.eof = dfa_56;
            this.min = dfa_63;
            this.max = dfa_64;
            this.accept = dfa_65;
            this.special = dfa_61;
            this.transition = dfa_66;
        }
        public String getDescription() {
            return "4661:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?";
        }
    }
    static final String dfa_67s = "\2\30\2\uffff\1\30";
    static final String dfa_68s = "\2\122\2\uffff\1\122";
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

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_69;
        }
        public String getDescription() {
            return "4702:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String dfa_70s = "\2\2\2\uffff\3\2";
    static final String dfa_71s = "\2\4\2\uffff\3\4";
    static final String dfa_72s = "\2\130\2\uffff\3\130";
    static final String dfa_73s = "\2\uffff\1\2\1\1\3\uffff";
    static final String[] dfa_74s = {
            "\7\2\14\uffff\1\2\1\1\6\uffff\2\2\1\uffff\2\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\1\2\1\uffff\1\2\7\uffff\1\2\5\uffff\1\2",
            "\7\2\14\uffff\1\2\1\5\1\4\5\uffff\2\2\1\uffff\2\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\1\2\1\uffff\1\2\7\uffff\1\2\5\uffff\1\2",
            "",
            "",
            "\7\2\14\uffff\1\2\1\5\6\uffff\2\2\1\uffff\2\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\1\2\1\uffff\1\2\7\uffff\1\2\5\uffff\1\2",
            "\7\2\14\uffff\1\2\1\5\1\6\5\uffff\2\2\1\uffff\2\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\1\2\1\uffff\1\2\7\uffff\1\2\5\uffff\1\2",
            "\7\2\14\uffff\1\2\1\5\6\uffff\2\2\1\uffff\2\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\1\2\1\uffff\1\2\7\uffff\1\2\5\uffff\1\2"
    };
    static final short[] dfa_70 = DFA.unpackEncodedString(dfa_70s);
    static final char[] dfa_71 = DFA.unpackEncodedStringToUnsignedChars(dfa_71s);
    static final char[] dfa_72 = DFA.unpackEncodedStringToUnsignedChars(dfa_72s);
    static final short[] dfa_73 = DFA.unpackEncodedString(dfa_73s);
    static final short[][] dfa_74 = unpackEncodedStringArray(dfa_74s);

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = dfa_1;
            this.eof = dfa_70;
            this.min = dfa_71;
            this.max = dfa_72;
            this.accept = dfa_73;
            this.special = dfa_5;
            this.transition = dfa_74;
        }
        public String getDescription() {
            return "()* loopback of 4783:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*";
        }
    }
    static final String dfa_75s = "\12\uffff";
    static final String dfa_76s = "\1\11\1\uffff\1\12\2\uffff\1\131\1\12\1\131\1\124\1\uffff";
    static final String dfa_77s = "\1\127\1\uffff\1\12\2\uffff\1\131\1\26\1\131\1\125\1\uffff";
    static final String dfa_78s = "\1\uffff\1\1\1\uffff\1\2\1\3\4\uffff\1\4";
    static final String dfa_79s = "\12\uffff}>";
    static final String[] dfa_80s = {
            "\1\1\1\3\1\uffff\12\1\75\uffff\1\2\2\uffff\1\1\1\4",
            "",
            "\1\5",
            "",
            "",
            "\1\6",
            "\1\7\13\uffff\1\10",
            "\1\6",
            "\1\11\1\1",
            ""
    };

    static final short[] dfa_75 = DFA.unpackEncodedString(dfa_75s);
    static final char[] dfa_76 = DFA.unpackEncodedStringToUnsignedChars(dfa_76s);
    static final char[] dfa_77 = DFA.unpackEncodedStringToUnsignedChars(dfa_77s);
    static final short[] dfa_78 = DFA.unpackEncodedString(dfa_78s);
    static final short[] dfa_79 = DFA.unpackEncodedString(dfa_79s);
    static final short[][] dfa_80 = unpackEncodedStringArray(dfa_80s);

    class DFA89 extends DFA {

        public DFA89(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 89;
            this.eot = dfa_75;
            this.eof = dfa_75;
            this.min = dfa_76;
            this.max = dfa_77;
            this.accept = dfa_78;
            this.special = dfa_79;
            this.transition = dfa_80;
        }
        public String getDescription() {
            return "4892:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )";
        }
    }
    static final String dfa_81s = "\25\uffff";
    static final String dfa_82s = "\5\uffff\3\14\5\uffff\10\14";
    static final String dfa_83s = "\1\11\4\uffff\3\4\5\uffff\10\4";
    static final String dfa_84s = "\1\126\4\uffff\3\130\5\uffff\10\130";
    static final String dfa_85s = "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\6\1\10\1\11\1\7\1\5\10\uffff";
    static final String dfa_86s = "\25\uffff}>";
    static final String[] dfa_87s = {
            "\1\1\2\uffff\1\2\1\3\2\4\1\5\1\6\1\7\3\10\75\uffff\1\12\2\uffff\1\11",
            "",
            "",
            "",
            "",
            "\7\14\10\uffff\1\13\3\uffff\2\14\5\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\3\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "\7\14\11\uffff\2\13\1\uffff\1\14\1\15\5\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\3\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "\7\14\12\uffff\1\13\1\uffff\1\14\1\16\5\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\3\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            "\7\14\11\uffff\2\13\1\uffff\1\14\1\20\1\17\4\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "\7\14\12\uffff\1\13\1\uffff\1\14\1\22\1\21\4\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "\7\14\11\uffff\2\13\1\uffff\1\14\1\20\5\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "\7\14\11\uffff\2\13\1\uffff\1\14\1\20\1\23\4\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "\7\14\12\uffff\1\13\1\uffff\1\14\1\22\5\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "\7\14\12\uffff\1\13\1\uffff\1\14\1\22\1\24\4\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "\7\14\11\uffff\2\13\1\uffff\1\14\1\20\5\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14",
            "\7\14\12\uffff\1\13\1\uffff\1\14\1\22\5\uffff\3\14\1\uffff\2\14\3\uffff\6\14\1\uffff\4\14\1\uffff\2\14\1\uffff\14\14\1\uffff\1\14\1\uffff\1\14\1\uffff\4\14\1\uffff\5\14\1\uffff\1\14\5\uffff\1\14"
    };

    static final short[] dfa_81 = DFA.unpackEncodedString(dfa_81s);
    static final short[] dfa_82 = DFA.unpackEncodedString(dfa_82s);
    static final char[] dfa_83 = DFA.unpackEncodedStringToUnsignedChars(dfa_83s);
    static final char[] dfa_84 = DFA.unpackEncodedStringToUnsignedChars(dfa_84s);
    static final short[] dfa_85 = DFA.unpackEncodedString(dfa_85s);
    static final short[] dfa_86 = DFA.unpackEncodedString(dfa_86s);
    static final short[][] dfa_87 = unpackEncodedStringArray(dfa_87s);

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = dfa_81;
            this.eof = dfa_82;
            this.min = dfa_83;
            this.max = dfa_84;
            this.accept = dfa_85;
            this.special = dfa_86;
            this.transition = dfa_87;
        }
        public String getDescription() {
            return "4992:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )";
        }
    }
    static final String dfa_88s = "\1\20\1\uffff\1\24\1\uffff\1\24\2\uffff\1\24";
    static final String dfa_89s = "\1\22\1\uffff\1\30\1\uffff\1\31\2\uffff\1\30";
    static final String dfa_90s = "\1\uffff\1\1\1\uffff\1\4\1\uffff\1\3\1\2\1\uffff";
    static final String[] dfa_91s = {
            "\1\1\1\2\1\3",
            "",
            "\1\6\1\5\2\uffff\1\4",
            "",
            "\1\6\1\5\2\uffff\1\4\1\7",
            "",
            "",
            "\1\6\1\5\2\uffff\1\4"
    };
    static final char[] dfa_88 = DFA.unpackEncodedStringToUnsignedChars(dfa_88s);
    static final char[] dfa_89 = DFA.unpackEncodedStringToUnsignedChars(dfa_89s);
    static final short[] dfa_90 = DFA.unpackEncodedString(dfa_90s);
    static final short[][] dfa_91 = unpackEncodedStringArray(dfa_91s);

    class DFA95 extends DFA {

        public DFA95(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 95;
            this.eot = dfa_56;
            this.eof = dfa_56;
            this.min = dfa_88;
            this.max = dfa_89;
            this.accept = dfa_90;
            this.special = dfa_61;
            this.transition = dfa_91;
        }
        public String getDescription() {
            return "5610:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000008E40800002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000008E41800000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000008C40800002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001000400L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00581F8D41800000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00581F8D40800000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000003001000600L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000003000000602L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000003001000400L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000003000000402L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000004001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000000017FF600L,0x0000000000CA0800L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001000200L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00001C0400000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00001C0000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0001E00081000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0001E00080000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0001C00081000400L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0001800081000400L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0001000081000400L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000081000400L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x595A1F8C418001F0L,0x0000000000000403L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x595A1F8C408001F0L,0x0000000000000403L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0004000001000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0020000001000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0040000400000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x04800000017FF600L,0x0000000000CA0800L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x04800000017FF602L,0x0000000000CA0800L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0480000001000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0480000000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0200000001000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000004001000400L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x2000000001000400L,0x0000000000000100L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000001000400L,0x0000000000000100L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x2000000001000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x00000000013FF600L,0x0000000000480000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0200000001000400L,0x0000000000000100L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x00000000017FF600L,0x0000000000CA0B04L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000028L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000028L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x00000000017FF600L,0x0000000000CA0820L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x00000000017FF602L,0x0000000000CA0820L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000001000400L,0x0000000000000040L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000001000400L,0x00000000000000C0L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000001000402L,0x0000000000000040L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000001000802L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0400000001000400L,0x0000000000000020L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0400000001000402L,0x0000000000000020L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0400000001000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000001000400L,0x0000000000000080L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000001000402L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000001000000L,0x000000000000F300L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x000000000000F300L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000001000000L,0x000000000001F300L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000000L,0x000000000001F300L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000081000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000001000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000001000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000001000600L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000001000600L,0x0000000001000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000001000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000003000000L});

}