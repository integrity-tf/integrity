package de.gebit.integrity.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDSLLexer extends Lexer {
    public static final int RULE_ISOTIME=21;
    public static final int T__50=50;
    public static final int RULE_DIVIDER=14;
    public static final int RULE_UPPERCASE_ID=7;
    public static final int RULE_ML_DOC_COMMENT=24;
    public static final int T__59=59;
    public static final int RULE_BOOLEAN_TRUE=4;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ML_VISIBLE_COMMENT=12;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=6;
    public static final int RULE_TWENTYFOURHRSTIME=22;
    public static final int RULE_ISOTIMEZONE=27;
    public static final int RULE_DECIMAL=17;
    public static final int T__29=29;
    public static final int RULE_ISODATE=18;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=25;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int RULE_SL_VISIBLE_COMMENT=10;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int RULE_USDATE=20;
    public static final int T__63=63;
    public static final int RULE_BOOLEAN_FALSE=5;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_NEWLINE=8;
    public static final int RULE_STRING=15;
    public static final int RULE_SL_VISIBLE_TITLE_COMMENT=11;
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
    public static final int RULE_TWELVEHRSTIME=23;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=28;
    public static final int RULE_EURODATE=19;
    public static final int RULE_ML_VISIBLE_TITLE_COMMENT=13;
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
    public static final int RULE_INTEGER=16;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators

    public InternalDSLLexer() {;} 
    public InternalDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalDSL.g"; }

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:11:7: ( '+' )
            // InternalDSL.g:11:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:12:7: ( '-' )
            // InternalDSL.g:12:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:13:7: ( '*' )
            // InternalDSL.g:13:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:14:7: ( '/' )
            // InternalDSL.g:14:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:15:7: ( '%' )
            // InternalDSL.g:15:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:16:7: ( '..' )
            // InternalDSL.g:16:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:17:7: ( 'packagedef' )
            // InternalDSL.g:17:9: 'packagedef'
            {
            match("packagedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18:7: ( 'with' )
            // InternalDSL.g:18:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:19:7: ( 'packageend' )
            // InternalDSL.g:19:9: 'packageend'
            {
            match("packageend"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:20:7: ( 'import' )
            // InternalDSL.g:20:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:21:7: ( 'forkdef' )
            // InternalDSL.g:21:9: 'forkdef'
            {
            match("forkdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:22:7: ( 'uses' )
            // InternalDSL.g:22:9: 'uses'
            {
            match("uses"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:23:7: ( 'based on' )
            // InternalDSL.g:23:9: 'based on'
            {
            match("based on"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:24:7: ( ':' )
            // InternalDSL.g:24:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:25:7: ( 'variantdef' )
            // InternalDSL.g:25:9: 'variantdef'
            {
            match("variantdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:26:7: ( 'testdef' )
            // InternalDSL.g:26:9: 'testdef'
            {
            match("testdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:27:7: ( 'calldef' )
            // InternalDSL.g:27:9: 'calldef'
            {
            match("calldef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:28:7: ( 'suitedef' )
            // InternalDSL.g:28:9: 'suitedef'
            {
            match("suitedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:29:7: ( 'suiteend' )
            // InternalDSL.g:29:9: 'suiteend'
            {
            match("suiteend"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:30:7: ( 'gets' )
            // InternalDSL.g:30:9: 'gets'
            {
            match("gets"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:31:7: ( 'returns' )
            // InternalDSL.g:31:9: 'returns'
            {
            match("returns"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:32:7: ( 'requires' )
            // InternalDSL.g:32:9: 'requires'
            {
            match("requires"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:33:7: ( 'concludedby' )
            // InternalDSL.g:33:9: 'concludedby'
            {
            match("concludedby"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:34:7: ( 'by default' )
            // InternalDSL.g:34:9: 'by default'
            {
            match("by default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:35:7: ( 'operationdef' )
            // InternalDSL.g:35:9: 'operationdef'
            {
            match("operationdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:36:7: ( 'variable' )
            // InternalDSL.g:36:9: 'variable'
            {
            match("variable"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:37:7: ( 'initially' )
            // InternalDSL.g:37:9: 'initially'
            {
            match("initially"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:38:7: ( 'constant' )
            // InternalDSL.g:38:9: 'constant'
            {
            match("constant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:39:7: ( 'assign' )
            // InternalDSL.g:39:9: 'assign'
            {
            match("assign"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:40:7: ( '->' )
            // InternalDSL.g:40:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:41:7: ( 'in' )
            // InternalDSL.g:41:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:42:7: ( 'test' )
            // InternalDSL.g:42:9: 'test'
            {
            match("test"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:43:7: ( '=' )
            // InternalDSL.g:43:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:44:7: ( 'tabletest' )
            // InternalDSL.g:44:9: 'tabletest'
            {
            match("tabletest"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:45:7: ( '|' )
            // InternalDSL.g:45:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:46:7: ( 'call' )
            // InternalDSL.g:46:9: 'call'
            {
            match("call"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:47:7: ( 'timeset' )
            // InternalDSL.g:47:9: 'timeset'
            {
            match("timeset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:48:7: ( 'x' )
            // InternalDSL.g:48:9: 'x'
            {
            match('x'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:49:7: ( 'on' )
            // InternalDSL.g:49:9: 'on'
            {
            match("on"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:50:7: ( ',' )
            // InternalDSL.g:50:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:51:7: ( 'suite' )
            // InternalDSL.g:51:9: 'suite'
            {
            match("suite"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:52:7: ( '(' )
            // InternalDSL.g:52:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:53:7: ( ')' )
            // InternalDSL.g:53:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:54:7: ( '[' )
            // InternalDSL.g:54:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:55:7: ( ']' )
            // InternalDSL.g:55:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:56:7: ( '<' )
            // InternalDSL.g:56:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:57:7: ( '>' )
            // InternalDSL.g:57:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:58:7: ( '#' )
            // InternalDSL.g:58:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:59:7: ( 'null' )
            // InternalDSL.g:59:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:60:7: ( '{' )
            // InternalDSL.g:60:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:61:7: ( '}' )
            // InternalDSL.g:61:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:62:7: ( '.' )
            // InternalDSL.g:62:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:63:7: ( '.*' )
            // InternalDSL.g:63:9: '.*'
            {
            match(".*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:64:7: ( 'private' )
            // InternalDSL.g:64:9: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:65:7: ( 'single-run' )
            // InternalDSL.g:65:9: 'single-run'
            {
            match("single-run"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:66:7: ( 'inlined' )
            // InternalDSL.g:66:9: 'inlined'
            {
            match("inlined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:67:7: ( 'parameterized' )
            // InternalDSL.g:67:9: 'parameterized'
            {
            match("parameterized"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:68:7: ( 'checkpoint' )
            // InternalDSL.g:68:9: 'checkpoint'
            {
            match("checkpoint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:69:7: ( 'live' )
            // InternalDSL.g:69:9: 'live'
            {
            match("live"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:70:7: ( 'progressing' )
            // InternalDSL.g:70:9: 'progressing'
            {
            match("progressing"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:71:7: ( 'master' )
            // InternalDSL.g:71:9: 'master'
            {
            match("master"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "RULE_BOOLEAN_TRUE"
    public final void mRULE_BOOLEAN_TRUE() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18238:19: ( 'true' )
            // InternalDSL.g:18238:21: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN_TRUE"

    // $ANTLR start "RULE_BOOLEAN_FALSE"
    public final void mRULE_BOOLEAN_FALSE() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18240:20: ( 'false' )
            // InternalDSL.g:18240:22: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN_FALSE"

    // $ANTLR start "RULE_UPPERCASE_ID"
    public final void mRULE_UPPERCASE_ID() throws RecognitionException {
        try {
            int _type = RULE_UPPERCASE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18242:19: ( 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* )
            // InternalDSL.g:18242:21: 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            {
            matchRange('A','Z'); 
            // InternalDSL.g:18242:30: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDSL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UPPERCASE_ID"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18244:9: ( ( '^' )? ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalDSL.g:18244:11: ( '^' )? ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalDSL.g:18244:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalDSL.g:18244:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalDSL.g:18244:31: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDSL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INTEGER"
    public final void mRULE_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18246:14: ( ( '-' )? ( '0' .. '9' )+ )
            // InternalDSL.g:18246:16: ( '-' )? ( '0' .. '9' )+
            {
            // InternalDSL.g:18246:16: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalDSL.g:18246:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalDSL.g:18246:21: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalDSL.g:18246:22: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER"

    // $ANTLR start "RULE_DECIMAL"
    public final void mRULE_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18248:14: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // InternalDSL.g:18248:16: ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // InternalDSL.g:18248:16: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDSL.g:18248:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalDSL.g:18248:21: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDSL.g:18248:22: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            match('.'); 
            // InternalDSL.g:18248:37: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDSL.g:18248:38: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECIMAL"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18250:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalDSL.g:18250:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalDSL.g:18250:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\"') ) {
                alt11=1;
            }
            else if ( (LA11_0=='\'') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalDSL.g:18250:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalDSL.g:18250:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalDSL.g:18250:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalDSL.g:18250:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalDSL.g:18250:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalDSL.g:18250:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop10:
                    do {
                        int alt10=3;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\\') ) {
                            alt10=1;
                        }
                        else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFF')) ) {
                            alt10=2;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalDSL.g:18250:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalDSL.g:18250:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18252:17: ( '/*' ~ ( '*' ) ( options {greedy=false; } : . )* '*/' )
            // InternalDSL.g:18252:19: '/*' ~ ( '*' ) ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            if ( (input.LA(1)>='\u0000' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalDSL.g:18252:31: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='/') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalDSL.g:18252:59: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18254:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalDSL.g:18254:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalDSL.g:18254:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDSL.g:18254:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalDSL.g:18254:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDSL.g:18254:41: ( '\\r' )? '\\n'
                    {
                    // InternalDSL.g:18254:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalDSL.g:18254:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_SL_VISIBLE_COMMENT"
    public final void mRULE_SL_VISIBLE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_VISIBLE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18256:25: ( '-- ' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalDSL.g:18256:27: '-- ' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match("-- "); 

            // InternalDSL.g:18256:33: (~ ( ( '\\n' | '\\r' ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDSL.g:18256:33: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_VISIBLE_COMMENT"

    // $ANTLR start "RULE_SL_VISIBLE_TITLE_COMMENT"
    public final void mRULE_SL_VISIBLE_TITLE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_VISIBLE_TITLE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18258:31: ( '--- ' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalDSL.g:18258:33: '--- ' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match("--- "); 

            // InternalDSL.g:18258:40: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDSL.g:18258:40: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_VISIBLE_TITLE_COMMENT"

    // $ANTLR start "RULE_ML_VISIBLE_COMMENT"
    public final void mRULE_ML_VISIBLE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_VISIBLE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18260:25: ( '/- ' ( options {greedy=false; } : . )* '-/' )
            // InternalDSL.g:18260:27: '/- ' ( options {greedy=false; } : . )* '-/'
            {
            match("/- "); 

            // InternalDSL.g:18260:33: ( options {greedy=false; } : . )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='-') ) {
                    int LA18_1 = input.LA(2);

                    if ( (LA18_1=='/') ) {
                        alt18=2;
                    }
                    else if ( ((LA18_1>='\u0000' && LA18_1<='.')||(LA18_1>='0' && LA18_1<='\uFFFF')) ) {
                        alt18=1;
                    }


                }
                else if ( ((LA18_0>='\u0000' && LA18_0<=',')||(LA18_0>='.' && LA18_0<='\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDSL.g:18260:61: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            match("-/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_VISIBLE_COMMENT"

    // $ANTLR start "RULE_ML_VISIBLE_TITLE_COMMENT"
    public final void mRULE_ML_VISIBLE_TITLE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_VISIBLE_TITLE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18262:31: ( '/-- ' ( options {greedy=false; } : . )* '--/' )
            // InternalDSL.g:18262:33: '/-- ' ( options {greedy=false; } : . )* '--/'
            {
            match("/-- "); 

            // InternalDSL.g:18262:40: ( options {greedy=false; } : . )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='-') ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1=='-') ) {
                        int LA19_3 = input.LA(3);

                        if ( (LA19_3=='/') ) {
                            alt19=2;
                        }
                        else if ( ((LA19_3>='\u0000' && LA19_3<='.')||(LA19_3>='0' && LA19_3<='\uFFFF')) ) {
                            alt19=1;
                        }


                    }
                    else if ( ((LA19_1>='\u0000' && LA19_1<=',')||(LA19_1>='.' && LA19_1<='\uFFFF')) ) {
                        alt19=1;
                    }


                }
                else if ( ((LA19_0>='\u0000' && LA19_0<=',')||(LA19_0>='.' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDSL.g:18262:68: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match("--/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_VISIBLE_TITLE_COMMENT"

    // $ANTLR start "RULE_ML_DOC_COMMENT"
    public final void mRULE_ML_DOC_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_DOC_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18264:21: ( '/**' ( options {greedy=false; } : . )* '*/' )
            // InternalDSL.g:18264:23: '/**' ( options {greedy=false; } : . )* '*/'
            {
            match("/**"); 

            // InternalDSL.g:18264:29: ( options {greedy=false; } : . )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='*') ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1=='/') ) {
                        alt20=2;
                    }
                    else if ( ((LA20_1>='\u0000' && LA20_1<='.')||(LA20_1>='0' && LA20_1<='\uFFFF')) ) {
                        alt20=1;
                    }


                }
                else if ( ((LA20_0>='\u0000' && LA20_0<=')')||(LA20_0>='+' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDSL.g:18264:57: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_DOC_COMMENT"

    // $ANTLR start "RULE_DIVIDER"
    public final void mRULE_DIVIDER() throws RecognitionException {
        try {
            int _type = RULE_DIVIDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18266:14: ( '----' ( '-' )* )
            // InternalDSL.g:18266:16: '----' ( '-' )*
            {
            match("----"); 

            // InternalDSL.g:18266:23: ( '-' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='-') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDSL.g:18266:23: '-'
            	    {
            	    match('-'); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIVIDER"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18268:9: ( ( ' ' | '\\t' )+ )
            // InternalDSL.g:18268:11: ( ' ' | '\\t' )+
            {
            // InternalDSL.g:18268:11: ( ' ' | '\\t' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\t'||LA22_0==' ') ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDSL.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18270:14: ( ( '\\r' | '\\n' )+ )
            // InternalDSL.g:18270:16: ( '\\r' | '\\n' )+
            {
            // InternalDSL.g:18270:16: ( '\\r' | '\\n' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='\n'||LA23_0=='\r') ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDSL.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "RULE_ISODATE"
    public final void mRULE_ISODATE() throws RecognitionException {
        try {
            int _type = RULE_ISODATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18272:14: ( '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '1' '0' .. '9' '-' '0' .. '3' '0' .. '9' )
            // InternalDSL.g:18272:16: '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '1' '0' .. '9' '-' '0' .. '3' '0' .. '9'
            {
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            match('-'); 
            matchRange('0','1'); 
            matchRange('0','9'); 
            match('-'); 
            matchRange('0','3'); 
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISODATE"

    // $ANTLR start "RULE_ISOTIME"
    public final void mRULE_ISOTIME() throws RecognitionException {
        try {
            int _type = RULE_ISOTIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18274:14: ( ( 'T' RULE_TWENTYFOURHRSTIME ( RULE_ISOTIMEZONE )? | RULE_TWENTYFOURHRSTIME RULE_ISOTIMEZONE ) )
            // InternalDSL.g:18274:16: ( 'T' RULE_TWENTYFOURHRSTIME ( RULE_ISOTIMEZONE )? | RULE_TWENTYFOURHRSTIME RULE_ISOTIMEZONE )
            {
            // InternalDSL.g:18274:16: ( 'T' RULE_TWENTYFOURHRSTIME ( RULE_ISOTIMEZONE )? | RULE_TWENTYFOURHRSTIME RULE_ISOTIMEZONE )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='T') ) {
                alt25=1;
            }
            else if ( ((LA25_0>='0' && LA25_0<='2')) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalDSL.g:18274:17: 'T' RULE_TWENTYFOURHRSTIME ( RULE_ISOTIMEZONE )?
                    {
                    match('T'); 
                    mRULE_TWENTYFOURHRSTIME(); 
                    // InternalDSL.g:18274:44: ( RULE_ISOTIMEZONE )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='+'||LA24_0=='-'||LA24_0=='Z') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalDSL.g:18274:44: RULE_ISOTIMEZONE
                            {
                            mRULE_ISOTIMEZONE(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:18274:62: RULE_TWENTYFOURHRSTIME RULE_ISOTIMEZONE
                    {
                    mRULE_TWENTYFOURHRSTIME(); 
                    mRULE_ISOTIMEZONE(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISOTIME"

    // $ANTLR start "RULE_ISOTIMEZONE"
    public final void mRULE_ISOTIMEZONE() throws RecognitionException {
        try {
            // InternalDSL.g:18276:27: ( ( 'Z' | ( '+' | '-' ) '0' .. '2' '0' .. '9' ( ':' )? '0' .. '5' '0' .. '9' ) )
            // InternalDSL.g:18276:29: ( 'Z' | ( '+' | '-' ) '0' .. '2' '0' .. '9' ( ':' )? '0' .. '5' '0' .. '9' )
            {
            // InternalDSL.g:18276:29: ( 'Z' | ( '+' | '-' ) '0' .. '2' '0' .. '9' ( ':' )? '0' .. '5' '0' .. '9' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='Z') ) {
                alt27=1;
            }
            else if ( (LA27_0=='+'||LA27_0=='-') ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalDSL.g:18276:30: 'Z'
                    {
                    match('Z'); 

                    }
                    break;
                case 2 :
                    // InternalDSL.g:18276:34: ( '+' | '-' ) '0' .. '2' '0' .. '9' ( ':' )? '0' .. '5' '0' .. '9'
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    matchRange('0','2'); 
                    matchRange('0','9'); 
                    // InternalDSL.g:18276:62: ( ':' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==':') ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalDSL.g:18276:62: ':'
                            {
                            match(':'); 

                            }
                            break;

                    }

                    matchRange('0','5'); 
                    matchRange('0','9'); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ISOTIMEZONE"

    // $ANTLR start "RULE_EURODATE"
    public final void mRULE_EURODATE() throws RecognitionException {
        try {
            int _type = RULE_EURODATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18278:15: ( '0' .. '3' '0' .. '9' '.' '0' .. '1' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' )
            // InternalDSL.g:18278:17: '0' .. '3' '0' .. '9' '.' '0' .. '1' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9'
            {
            matchRange('0','3'); 
            matchRange('0','9'); 
            match('.'); 
            matchRange('0','1'); 
            matchRange('0','9'); 
            match('.'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EURODATE"

    // $ANTLR start "RULE_USDATE"
    public final void mRULE_USDATE() throws RecognitionException {
        try {
            int _type = RULE_USDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18280:13: ( '0' .. '1' '0' .. '9' '/' '0' .. '3' '0' .. '9' '/' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' )
            // InternalDSL.g:18280:15: '0' .. '1' '0' .. '9' '/' '0' .. '3' '0' .. '9' '/' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9'
            {
            matchRange('0','1'); 
            matchRange('0','9'); 
            match('/'); 
            matchRange('0','3'); 
            matchRange('0','9'); 
            match('/'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_USDATE"

    // $ANTLR start "RULE_TWENTYFOURHRSTIME"
    public final void mRULE_TWENTYFOURHRSTIME() throws RecognitionException {
        try {
            int _type = RULE_TWENTYFOURHRSTIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18282:24: ( '0' .. '2' '0' .. '9' ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )? )
            // InternalDSL.g:18282:26: '0' .. '2' '0' .. '9' ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )?
            {
            matchRange('0','2'); 
            matchRange('0','9'); 
            match(':'); 
            matchRange('0','5'); 
            matchRange('0','9'); 
            // InternalDSL.g:18282:66: ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==':') ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDSL.g:18282:67: ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )?
                    {
                    match(':'); 
                    matchRange('0','6'); 
                    matchRange('0','9'); 
                    // InternalDSL.g:18282:89: ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0=='.') ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalDSL.g:18282:90: '.' '0' .. '9' '0' .. '9' '0' .. '9'
                            {
                            match('.'); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TWENTYFOURHRSTIME"

    // $ANTLR start "RULE_TWELVEHRSTIME"
    public final void mRULE_TWELVEHRSTIME() throws RecognitionException {
        try {
            int _type = RULE_TWELVEHRSTIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18284:20: ( '0' .. '1' '0' .. '9' ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )? ( 'am' | 'pm' ) )
            // InternalDSL.g:18284:22: '0' .. '1' '0' .. '9' ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )? ( 'am' | 'pm' )
            {
            matchRange('0','1'); 
            matchRange('0','9'); 
            match(':'); 
            matchRange('0','5'); 
            matchRange('0','9'); 
            // InternalDSL.g:18284:62: ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==':') ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDSL.g:18284:63: ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )?
                    {
                    match(':'); 
                    matchRange('0','6'); 
                    matchRange('0','9'); 
                    // InternalDSL.g:18284:85: ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0=='.') ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalDSL.g:18284:86: '.' '0' .. '9' '0' .. '9' '0' .. '9'
                            {
                            match('.'); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalDSL.g:18284:121: ( 'am' | 'pm' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='a') ) {
                alt32=1;
            }
            else if ( (LA32_0=='p') ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalDSL.g:18284:122: 'am'
                    {
                    match("am"); 


                    }
                    break;
                case 2 :
                    // InternalDSL.g:18284:127: 'pm'
                    {
                    match("pm"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TWELVEHRSTIME"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:18286:16: ( . )
            // InternalDSL.g:18286:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalDSL.g:1:8: ( T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | RULE_BOOLEAN_TRUE | RULE_BOOLEAN_FALSE | RULE_UPPERCASE_ID | RULE_ID | RULE_INTEGER | RULE_DECIMAL | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SL_VISIBLE_COMMENT | RULE_SL_VISIBLE_TITLE_COMMENT | RULE_ML_VISIBLE_COMMENT | RULE_ML_VISIBLE_TITLE_COMMENT | RULE_ML_DOC_COMMENT | RULE_DIVIDER | RULE_WS | RULE_NEWLINE | RULE_ISODATE | RULE_ISOTIME | RULE_EURODATE | RULE_USDATE | RULE_TWENTYFOURHRSTIME | RULE_TWELVEHRSTIME | RULE_ANY_OTHER )
        int alt33=85;
        alt33 = dfa33.predict(input);
        switch (alt33) {
            case 1 :
                // InternalDSL.g:1:10: T__29
                {
                mT__29(); 

                }
                break;
            case 2 :
                // InternalDSL.g:1:16: T__30
                {
                mT__30(); 

                }
                break;
            case 3 :
                // InternalDSL.g:1:22: T__31
                {
                mT__31(); 

                }
                break;
            case 4 :
                // InternalDSL.g:1:28: T__32
                {
                mT__32(); 

                }
                break;
            case 5 :
                // InternalDSL.g:1:34: T__33
                {
                mT__33(); 

                }
                break;
            case 6 :
                // InternalDSL.g:1:40: T__34
                {
                mT__34(); 

                }
                break;
            case 7 :
                // InternalDSL.g:1:46: T__35
                {
                mT__35(); 

                }
                break;
            case 8 :
                // InternalDSL.g:1:52: T__36
                {
                mT__36(); 

                }
                break;
            case 9 :
                // InternalDSL.g:1:58: T__37
                {
                mT__37(); 

                }
                break;
            case 10 :
                // InternalDSL.g:1:64: T__38
                {
                mT__38(); 

                }
                break;
            case 11 :
                // InternalDSL.g:1:70: T__39
                {
                mT__39(); 

                }
                break;
            case 12 :
                // InternalDSL.g:1:76: T__40
                {
                mT__40(); 

                }
                break;
            case 13 :
                // InternalDSL.g:1:82: T__41
                {
                mT__41(); 

                }
                break;
            case 14 :
                // InternalDSL.g:1:88: T__42
                {
                mT__42(); 

                }
                break;
            case 15 :
                // InternalDSL.g:1:94: T__43
                {
                mT__43(); 

                }
                break;
            case 16 :
                // InternalDSL.g:1:100: T__44
                {
                mT__44(); 

                }
                break;
            case 17 :
                // InternalDSL.g:1:106: T__45
                {
                mT__45(); 

                }
                break;
            case 18 :
                // InternalDSL.g:1:112: T__46
                {
                mT__46(); 

                }
                break;
            case 19 :
                // InternalDSL.g:1:118: T__47
                {
                mT__47(); 

                }
                break;
            case 20 :
                // InternalDSL.g:1:124: T__48
                {
                mT__48(); 

                }
                break;
            case 21 :
                // InternalDSL.g:1:130: T__49
                {
                mT__49(); 

                }
                break;
            case 22 :
                // InternalDSL.g:1:136: T__50
                {
                mT__50(); 

                }
                break;
            case 23 :
                // InternalDSL.g:1:142: T__51
                {
                mT__51(); 

                }
                break;
            case 24 :
                // InternalDSL.g:1:148: T__52
                {
                mT__52(); 

                }
                break;
            case 25 :
                // InternalDSL.g:1:154: T__53
                {
                mT__53(); 

                }
                break;
            case 26 :
                // InternalDSL.g:1:160: T__54
                {
                mT__54(); 

                }
                break;
            case 27 :
                // InternalDSL.g:1:166: T__55
                {
                mT__55(); 

                }
                break;
            case 28 :
                // InternalDSL.g:1:172: T__56
                {
                mT__56(); 

                }
                break;
            case 29 :
                // InternalDSL.g:1:178: T__57
                {
                mT__57(); 

                }
                break;
            case 30 :
                // InternalDSL.g:1:184: T__58
                {
                mT__58(); 

                }
                break;
            case 31 :
                // InternalDSL.g:1:190: T__59
                {
                mT__59(); 

                }
                break;
            case 32 :
                // InternalDSL.g:1:196: T__60
                {
                mT__60(); 

                }
                break;
            case 33 :
                // InternalDSL.g:1:202: T__61
                {
                mT__61(); 

                }
                break;
            case 34 :
                // InternalDSL.g:1:208: T__62
                {
                mT__62(); 

                }
                break;
            case 35 :
                // InternalDSL.g:1:214: T__63
                {
                mT__63(); 

                }
                break;
            case 36 :
                // InternalDSL.g:1:220: T__64
                {
                mT__64(); 

                }
                break;
            case 37 :
                // InternalDSL.g:1:226: T__65
                {
                mT__65(); 

                }
                break;
            case 38 :
                // InternalDSL.g:1:232: T__66
                {
                mT__66(); 

                }
                break;
            case 39 :
                // InternalDSL.g:1:238: T__67
                {
                mT__67(); 

                }
                break;
            case 40 :
                // InternalDSL.g:1:244: T__68
                {
                mT__68(); 

                }
                break;
            case 41 :
                // InternalDSL.g:1:250: T__69
                {
                mT__69(); 

                }
                break;
            case 42 :
                // InternalDSL.g:1:256: T__70
                {
                mT__70(); 

                }
                break;
            case 43 :
                // InternalDSL.g:1:262: T__71
                {
                mT__71(); 

                }
                break;
            case 44 :
                // InternalDSL.g:1:268: T__72
                {
                mT__72(); 

                }
                break;
            case 45 :
                // InternalDSL.g:1:274: T__73
                {
                mT__73(); 

                }
                break;
            case 46 :
                // InternalDSL.g:1:280: T__74
                {
                mT__74(); 

                }
                break;
            case 47 :
                // InternalDSL.g:1:286: T__75
                {
                mT__75(); 

                }
                break;
            case 48 :
                // InternalDSL.g:1:292: T__76
                {
                mT__76(); 

                }
                break;
            case 49 :
                // InternalDSL.g:1:298: T__77
                {
                mT__77(); 

                }
                break;
            case 50 :
                // InternalDSL.g:1:304: T__78
                {
                mT__78(); 

                }
                break;
            case 51 :
                // InternalDSL.g:1:310: T__79
                {
                mT__79(); 

                }
                break;
            case 52 :
                // InternalDSL.g:1:316: T__80
                {
                mT__80(); 

                }
                break;
            case 53 :
                // InternalDSL.g:1:322: T__81
                {
                mT__81(); 

                }
                break;
            case 54 :
                // InternalDSL.g:1:328: T__82
                {
                mT__82(); 

                }
                break;
            case 55 :
                // InternalDSL.g:1:334: T__83
                {
                mT__83(); 

                }
                break;
            case 56 :
                // InternalDSL.g:1:340: T__84
                {
                mT__84(); 

                }
                break;
            case 57 :
                // InternalDSL.g:1:346: T__85
                {
                mT__85(); 

                }
                break;
            case 58 :
                // InternalDSL.g:1:352: T__86
                {
                mT__86(); 

                }
                break;
            case 59 :
                // InternalDSL.g:1:358: T__87
                {
                mT__87(); 

                }
                break;
            case 60 :
                // InternalDSL.g:1:364: T__88
                {
                mT__88(); 

                }
                break;
            case 61 :
                // InternalDSL.g:1:370: T__89
                {
                mT__89(); 

                }
                break;
            case 62 :
                // InternalDSL.g:1:376: RULE_BOOLEAN_TRUE
                {
                mRULE_BOOLEAN_TRUE(); 

                }
                break;
            case 63 :
                // InternalDSL.g:1:394: RULE_BOOLEAN_FALSE
                {
                mRULE_BOOLEAN_FALSE(); 

                }
                break;
            case 64 :
                // InternalDSL.g:1:413: RULE_UPPERCASE_ID
                {
                mRULE_UPPERCASE_ID(); 

                }
                break;
            case 65 :
                // InternalDSL.g:1:431: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 66 :
                // InternalDSL.g:1:439: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 67 :
                // InternalDSL.g:1:452: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 68 :
                // InternalDSL.g:1:465: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 69 :
                // InternalDSL.g:1:477: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 70 :
                // InternalDSL.g:1:493: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 71 :
                // InternalDSL.g:1:509: RULE_SL_VISIBLE_COMMENT
                {
                mRULE_SL_VISIBLE_COMMENT(); 

                }
                break;
            case 72 :
                // InternalDSL.g:1:533: RULE_SL_VISIBLE_TITLE_COMMENT
                {
                mRULE_SL_VISIBLE_TITLE_COMMENT(); 

                }
                break;
            case 73 :
                // InternalDSL.g:1:563: RULE_ML_VISIBLE_COMMENT
                {
                mRULE_ML_VISIBLE_COMMENT(); 

                }
                break;
            case 74 :
                // InternalDSL.g:1:587: RULE_ML_VISIBLE_TITLE_COMMENT
                {
                mRULE_ML_VISIBLE_TITLE_COMMENT(); 

                }
                break;
            case 75 :
                // InternalDSL.g:1:617: RULE_ML_DOC_COMMENT
                {
                mRULE_ML_DOC_COMMENT(); 

                }
                break;
            case 76 :
                // InternalDSL.g:1:637: RULE_DIVIDER
                {
                mRULE_DIVIDER(); 

                }
                break;
            case 77 :
                // InternalDSL.g:1:650: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 78 :
                // InternalDSL.g:1:658: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 79 :
                // InternalDSL.g:1:671: RULE_ISODATE
                {
                mRULE_ISODATE(); 

                }
                break;
            case 80 :
                // InternalDSL.g:1:684: RULE_ISOTIME
                {
                mRULE_ISOTIME(); 

                }
                break;
            case 81 :
                // InternalDSL.g:1:697: RULE_EURODATE
                {
                mRULE_EURODATE(); 

                }
                break;
            case 82 :
                // InternalDSL.g:1:711: RULE_USDATE
                {
                mRULE_USDATE(); 

                }
                break;
            case 83 :
                // InternalDSL.g:1:723: RULE_TWENTYFOURHRSTIME
                {
                mRULE_TWENTYFOURHRSTIME(); 

                }
                break;
            case 84 :
                // InternalDSL.g:1:746: RULE_TWELVEHRSTIME
                {
                mRULE_TWELVEHRSTIME(); 

                }
                break;
            case 85 :
                // InternalDSL.g:1:765: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA33_eotS =
        "\2\uffff\1\66\1\uffff\1\74\1\uffff\1\100\6\103\1\uffff\10\103\2\uffff\1\136\10\uffff\1\103\2\uffff\2\103\1\155\1\62\1\uffff\1\160\2\62\3\uffff\3\160\5\uffff\1\160\11\uffff\2\103\1\uffff\2\103\1\u0085\5\103\1\uffff\15\103\1\u0099\1\103\13\uffff\1\103\2\uffff\2\103\1\155\1\uffff\1\160\5\uffff\3\160\6\uffff\10\103\1\uffff\4\103\1\uffff\16\103\1\uffff\4\103\1\155\1\160\6\uffff\4\103\1\u00ce\5\103\1\u00d4\2\103\1\u00d8\2\103\1\u00db\1\u00dd\5\103\1\u00e3\4\103\1\u00e8\1\u00e9\1\103\1\uffff\1\160\1\uffff\1\157\1\uffff\4\103\1\uffff\4\103\1\u00f7\1\uffff\3\103\1\uffff\2\103\1\uffff\1\103\1\uffff\3\103\1\u0104\1\103\1\uffff\4\103\2\uffff\1\103\1\uffff\1\u010c\1\157\1\u010c\4\103\1\u0114\3\103\2\uffff\13\103\1\uffff\4\103\1\u0127\1\u0128\5\uffff\2\103\1\u012e\1\103\1\uffff\1\103\1\u0131\1\u0132\2\103\1\u0135\1\103\1\u0137\1\u0138\5\103\1\uffff\1\u013e\2\103\4\uffff\3\103\1\uffff\2\103\2\uffff\1\103\1\u0149\1\uffff\1\103\2\uffff\1\103\1\u014c\1\103\1\u014e\1\u014f\1\uffff\1\u0150\1\103\2\u010c\4\103\1\u0158\1\103\1\uffff\1\u015a\1\103\1\uffff\1\103\3\uffff\1\103\2\uffff\1\u0160\1\u0161\2\103\1\uffff\1\u0164\1\uffff\1\103\1\u0166\1\103\4\uffff\1\103\1\u016b\1\uffff\1\u016c\1\uffff\1\103\2\uffff\1\103\2\uffff\1\u0171\2\u010c\1\u0172\2\uffff";
    static final String DFA33_eofS =
        "\u0173\uffff";
    static final String DFA33_minS =
        "\1\0\1\uffff\1\55\1\uffff\1\52\1\uffff\1\52\1\141\1\151\1\155\1\141\1\163\1\141\1\uffff\3\141\1\151\2\145\1\156\1\163\2\uffff\1\60\10\uffff\1\165\2\uffff\1\151\1\141\1\60\1\137\1\uffff\1\56\2\0\3\uffff\3\56\3\uffff\1\40\1\uffff\1\56\1\uffff\1\0\1\uffff\1\40\5\uffff\1\143\1\151\1\uffff\1\164\1\160\1\60\1\162\1\154\1\145\1\163\1\40\1\uffff\1\162\1\163\1\142\1\155\1\165\1\154\1\156\1\145\1\151\1\156\1\164\1\161\1\145\1\60\1\163\13\uffff\1\154\2\uffff\1\166\1\163\1\60\1\uffff\1\56\5\uffff\3\56\1\uffff\1\40\4\uffff\1\153\1\141\1\166\1\147\1\150\1\157\1\164\1\151\1\uffff\1\153\2\163\1\145\1\uffff\1\151\1\164\1\154\2\145\1\154\2\143\1\164\1\147\1\163\2\165\1\162\1\uffff\1\151\1\154\1\145\1\164\1\72\1\56\2\60\1\uffff\1\60\2\uffff\1\141\1\155\1\141\1\162\1\60\1\162\1\151\1\156\1\144\1\145\1\60\1\144\1\141\1\60\1\145\1\163\2\60\1\154\1\164\1\153\1\145\1\154\1\60\1\162\1\151\1\141\1\147\2\60\1\145\1\uffff\1\55\3\60\1\147\1\145\1\164\1\145\1\uffff\1\164\1\141\2\145\1\60\1\uffff\1\40\1\142\1\145\1\uffff\1\164\1\145\1\uffff\1\145\1\uffff\1\165\1\141\1\160\1\60\1\145\1\uffff\1\156\1\162\1\164\1\156\2\uffff\1\162\1\uffff\1\53\1\56\1\53\1\145\1\164\1\145\1\163\1\60\1\154\1\144\1\146\2\uffff\1\164\1\154\1\146\1\145\1\164\1\146\1\144\1\156\1\157\1\145\1\156\1\uffff\1\55\1\163\1\145\1\151\3\60\3\uffff\1\60\1\144\1\145\1\60\1\163\1\uffff\1\154\2\60\1\144\1\145\1\60\1\163\2\60\1\145\1\164\1\151\1\146\1\144\1\uffff\1\60\1\163\1\157\2\uffff\2\60\1\145\1\156\1\162\1\uffff\1\151\1\171\2\uffff\1\145\1\60\1\uffff\1\164\2\uffff\1\144\1\60\1\156\2\60\1\uffff\1\60\1\156\2\53\1\146\1\144\1\151\1\156\1\60\1\146\1\uffff\1\60\1\142\1\uffff\1\164\3\uffff\1\144\4\60\1\172\1\147\1\uffff\1\60\1\uffff\1\171\1\60\1\145\2\60\2\uffff\1\145\1\60\1\uffff\1\60\1\uffff\1\146\2\60\1\144\2\uffff\1\60\2\53\1\60\2\uffff";
    static final String DFA33_maxS =
        "\1\uffff\1\uffff\1\76\1\uffff\1\57\1\uffff\1\56\1\162\1\151\1\156\1\157\1\163\1\171\1\uffff\1\141\1\162\1\157\1\165\2\145\1\160\1\163\2\uffff\1\172\10\uffff\1\165\2\uffff\1\151\1\141\1\62\1\172\1\uffff\1\71\2\uffff\3\uffff\3\71\3\uffff\1\55\1\uffff\1\71\1\uffff\1\uffff\1\uffff\1\55\5\uffff\1\162\1\157\1\uffff\1\164\1\160\1\172\1\162\1\154\1\145\1\163\1\40\1\uffff\1\162\1\163\1\142\1\155\1\165\1\154\1\156\1\145\1\151\1\156\2\164\1\145\1\172\1\163\13\uffff\1\154\2\uffff\1\166\1\163\1\71\1\uffff\1\72\5\uffff\2\71\1\72\1\uffff\1\55\4\uffff\1\153\1\141\1\166\1\147\1\150\1\157\1\164\1\151\1\uffff\1\153\2\163\1\145\1\uffff\1\151\1\164\1\154\2\145\1\154\1\163\1\143\1\164\1\147\1\163\2\165\1\162\1\uffff\1\151\1\154\1\145\1\164\1\72\1\71\1\65\1\71\1\uffff\1\65\2\uffff\1\141\1\155\1\141\1\162\1\172\1\162\1\151\1\156\1\144\1\145\1\172\1\144\1\141\1\172\1\145\1\163\2\172\1\154\1\164\1\153\1\145\1\154\1\172\1\162\1\151\1\141\1\147\2\172\1\145\1\uffff\4\71\1\147\1\145\1\164\1\145\1\uffff\1\164\1\141\2\145\1\172\1\uffff\1\40\1\156\1\145\1\uffff\1\164\1\145\1\uffff\1\145\1\uffff\1\165\1\141\1\160\1\172\1\145\1\uffff\1\156\1\162\1\164\1\156\2\uffff\1\162\1\uffff\1\160\1\56\1\132\1\145\1\164\1\145\1\163\1\172\1\154\1\144\1\146\2\uffff\1\164\1\154\1\146\1\145\1\164\1\146\1\144\1\156\1\157\1\145\1\156\1\uffff\1\55\1\163\1\145\1\151\2\172\1\66\3\uffff\1\66\2\145\1\172\1\163\1\uffff\1\154\2\172\1\144\1\145\1\172\1\163\2\172\1\145\1\164\1\151\1\146\1\144\1\uffff\1\172\1\163\1\157\2\uffff\2\71\1\145\1\156\1\162\1\uffff\1\151\1\171\2\uffff\1\145\1\172\1\uffff\1\164\2\uffff\1\144\1\172\1\156\2\172\1\uffff\1\172\1\156\1\160\1\132\1\146\1\144\1\151\1\156\1\172\1\146\1\uffff\1\172\1\142\1\uffff\1\164\3\uffff\1\144\2\71\3\172\1\147\1\uffff\1\172\1\uffff\1\171\1\172\1\145\2\71\2\uffff\1\145\1\172\1\uffff\1\172\1\uffff\1\146\2\71\1\144\2\uffff\1\172\1\160\1\132\1\172\2\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\uffff\1\5\7\uffff\1\16\10\uffff\1\41\1\43\1\uffff\1\50\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\uffff\1\62\1\63\4\uffff\1\101\3\uffff\1\115\1\116\1\100\3\uffff\1\125\1\1\1\36\1\uffff\1\2\1\uffff\1\3\1\uffff\1\106\1\uffff\1\4\1\5\1\6\1\65\1\64\2\uffff\1\101\10\uffff\1\16\17\uffff\1\41\1\43\1\46\1\50\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\uffff\1\62\1\63\3\uffff\1\100\1\uffff\1\103\1\102\1\104\1\115\1\116\3\uffff\1\107\1\uffff\1\105\1\113\1\111\1\112\10\uffff\1\37\4\uffff\1\30\16\uffff\1\47\10\uffff\1\122\1\uffff\1\110\1\114\37\uffff\1\120\10\uffff\1\10\5\uffff\1\14\3\uffff\1\40\2\uffff\1\76\1\uffff\1\44\5\uffff\1\24\4\uffff\1\61\1\73\1\uffff\1\117\13\uffff\1\77\1\15\13\uffff\1\51\7\uffff\1\123\1\124\1\121\5\uffff\1\12\16\uffff\1\67\3\uffff\1\35\1\75\5\uffff\1\66\2\uffff\1\70\1\13\2\uffff\1\20\1\uffff\1\45\1\21\5\uffff\1\25\12\uffff\1\32\2\uffff\1\34\1\uffff\1\22\1\23\1\26\7\uffff\1\33\1\uffff\1\42\5\uffff\1\7\1\11\2\uffff\1\17\1\uffff\1\72\4\uffff\1\74\1\27\4\uffff\1\31\1\71";
    static final String DFA33_specialS =
        "\1\1\51\uffff\1\3\1\0\15\uffff\1\2\u0139\uffff}>";
    static final String[] DFA33_transitionS = {
            "\11\62\1\54\1\55\2\62\1\55\22\62\1\54\1\62\1\52\1\40\1\62\1\5\1\62\1\53\1\32\1\33\1\3\1\1\1\31\1\2\1\6\1\4\2\51\1\61\1\57\6\60\1\15\1\62\1\36\1\26\1\37\2\62\23\56\1\46\6\56\1\34\1\62\1\35\1\47\1\50\1\62\1\25\1\14\1\20\2\50\1\12\1\22\1\50\1\11\2\50\1\44\1\45\1\41\1\24\1\7\1\50\1\23\1\21\1\17\1\13\1\16\1\10\1\30\2\50\1\42\1\27\1\43\uff82\62",
            "",
            "\1\65\2\uffff\12\67\4\uffff\1\64",
            "",
            "\1\71\2\uffff\1\73\1\uffff\1\72",
            "",
            "\1\77\3\uffff\1\76",
            "\1\101\20\uffff\1\102",
            "\1\104",
            "\1\105\1\106",
            "\1\110\15\uffff\1\107",
            "\1\111",
            "\1\112\27\uffff\1\113",
            "",
            "\1\115",
            "\1\117\3\uffff\1\116\3\uffff\1\120\10\uffff\1\121",
            "\1\122\6\uffff\1\124\6\uffff\1\123",
            "\1\126\13\uffff\1\125",
            "\1\127",
            "\1\130",
            "\1\132\1\uffff\1\131",
            "\1\133",
            "",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\147",
            "",
            "",
            "\1\152",
            "\1\153",
            "\3\154",
            "\1\103\1\uffff\32\103",
            "",
            "\1\157\1\uffff\12\156",
            "\0\161",
            "\0\161",
            "",
            "",
            "",
            "\1\157\1\uffff\12\164",
            "\1\157\1\uffff\12\165",
            "\1\157\1\uffff\12\166",
            "",
            "",
            "",
            "\1\167\14\uffff\1\170",
            "",
            "\1\157\1\uffff\12\67",
            "",
            "\52\171\1\172\uffd5\171",
            "",
            "\1\173\14\uffff\1\174",
            "",
            "",
            "",
            "",
            "",
            "\1\175\16\uffff\1\176",
            "\1\177\5\uffff\1\u0080",
            "",
            "\1\u0081",
            "\1\u0082",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\10\103\1\u0083\2\103\1\u0084\16\103",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0097\2\uffff\1\u0096",
            "\1\u0098",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u009a",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u009b",
            "",
            "",
            "\1\u009c",
            "\1\u009d",
            "\12\u009e",
            "",
            "\1\u00a1\1\u00a2\12\u009f\1\u00a0",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a1\1\uffff\12\u009f",
            "\1\157\1\uffff\12\u009f",
            "\1\u00a1\1\uffff\12\u009f\1\u00a3",
            "",
            "\1\u00a4\14\uffff\1\u00a5",
            "",
            "",
            "",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8\17\uffff\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\157\1\uffff\12\u00c6",
            "\6\u00c7",
            "\2\u00c8\10\157",
            "",
            "\6\u00c9",
            "",
            "",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u00d5",
            "\1\u00d6",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\3\103\1\u00d7\26\103",
            "\1\u00d9",
            "\1\u00da",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\3\103\1\u00dc\26\103",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u00ea",
            "",
            "\1\u00eb\1\157\1\uffff\12\67",
            "\12\u00ec",
            "\12\u00ed",
            "\12\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "\1\u00f8",
            "\1\u00fa\13\uffff\1\u00f9",
            "\1\u00fb",
            "",
            "\1\u00fc",
            "\1\u00fd",
            "",
            "\1\u00fe",
            "",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\3\103\1\u0102\1\u0103\25\103",
            "\1\u0105",
            "",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "",
            "",
            "\1\u010a",
            "",
            "\1\u00c5\1\uffff\1\u00c5\14\uffff\1\u010b\37\uffff\1\u00c5\6\uffff\1\u010d\16\uffff\1\u010d",
            "\1\u010e",
            "\1\u00c5\1\uffff\1\u00c5\14\uffff\1\u010f\37\uffff\1\u00c5",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "",
            "",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\7\u0129",
            "",
            "",
            "",
            "\7\u012a",
            "\1\u012b\1\u012c",
            "\1\u012d",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u012f",
            "",
            "\1\u0130",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u0133",
            "\1\u0134",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u0136",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u013f",
            "\1\u0140",
            "",
            "",
            "\12\u0141",
            "\12\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "",
            "\1\u0146",
            "\1\u0147",
            "",
            "",
            "\1\u0148",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "\1\u014a",
            "",
            "",
            "\1\u014b",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u014d",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u0151",
            "\1\u00c5\1\uffff\1\u00c5\1\u0152\53\uffff\1\u00c5\6\uffff\1\u010d\16\uffff\1\u010d",
            "\1\u00c5\1\uffff\1\u00c5\1\u0153\53\uffff\1\u00c5",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u0159",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u015b",
            "",
            "\1\u015c",
            "",
            "",
            "",
            "\1\u015d",
            "\12\u015e",
            "\12\u015f",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u0162",
            "\1\u0163",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "\1\u0165",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u0167",
            "\12\u0168",
            "\12\u0169",
            "",
            "",
            "\1\u016a",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            "\1\u016d",
            "\12\u016e",
            "\12\u016f",
            "\1\u0170",
            "",
            "",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "\1\u00c5\1\uffff\1\u00c5\54\uffff\1\u00c5\6\uffff\1\u010d\16\uffff\1\u010d",
            "\1\u00c5\1\uffff\1\u00c5\54\uffff\1\u00c5",
            "\12\103\7\uffff\32\103\4\uffff\1\103\1\uffff\32\103",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | RULE_BOOLEAN_TRUE | RULE_BOOLEAN_FALSE | RULE_UPPERCASE_ID | RULE_ID | RULE_INTEGER | RULE_DECIMAL | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SL_VISIBLE_COMMENT | RULE_SL_VISIBLE_TITLE_COMMENT | RULE_ML_VISIBLE_COMMENT | RULE_ML_VISIBLE_TITLE_COMMENT | RULE_ML_DOC_COMMENT | RULE_DIVIDER | RULE_WS | RULE_NEWLINE | RULE_ISODATE | RULE_ISOTIME | RULE_EURODATE | RULE_USDATE | RULE_TWENTYFOURHRSTIME | RULE_TWELVEHRSTIME | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_43 = input.LA(1);

                        s = -1;
                        if ( ((LA33_43>='\u0000' && LA33_43<='\uFFFF')) ) {s = 113;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_0 = input.LA(1);

                        s = -1;
                        if ( (LA33_0=='+') ) {s = 1;}

                        else if ( (LA33_0=='-') ) {s = 2;}

                        else if ( (LA33_0=='*') ) {s = 3;}

                        else if ( (LA33_0=='/') ) {s = 4;}

                        else if ( (LA33_0=='%') ) {s = 5;}

                        else if ( (LA33_0=='.') ) {s = 6;}

                        else if ( (LA33_0=='p') ) {s = 7;}

                        else if ( (LA33_0=='w') ) {s = 8;}

                        else if ( (LA33_0=='i') ) {s = 9;}

                        else if ( (LA33_0=='f') ) {s = 10;}

                        else if ( (LA33_0=='u') ) {s = 11;}

                        else if ( (LA33_0=='b') ) {s = 12;}

                        else if ( (LA33_0==':') ) {s = 13;}

                        else if ( (LA33_0=='v') ) {s = 14;}

                        else if ( (LA33_0=='t') ) {s = 15;}

                        else if ( (LA33_0=='c') ) {s = 16;}

                        else if ( (LA33_0=='s') ) {s = 17;}

                        else if ( (LA33_0=='g') ) {s = 18;}

                        else if ( (LA33_0=='r') ) {s = 19;}

                        else if ( (LA33_0=='o') ) {s = 20;}

                        else if ( (LA33_0=='a') ) {s = 21;}

                        else if ( (LA33_0=='=') ) {s = 22;}

                        else if ( (LA33_0=='|') ) {s = 23;}

                        else if ( (LA33_0=='x') ) {s = 24;}

                        else if ( (LA33_0==',') ) {s = 25;}

                        else if ( (LA33_0=='(') ) {s = 26;}

                        else if ( (LA33_0==')') ) {s = 27;}

                        else if ( (LA33_0=='[') ) {s = 28;}

                        else if ( (LA33_0==']') ) {s = 29;}

                        else if ( (LA33_0=='<') ) {s = 30;}

                        else if ( (LA33_0=='>') ) {s = 31;}

                        else if ( (LA33_0=='#') ) {s = 32;}

                        else if ( (LA33_0=='n') ) {s = 33;}

                        else if ( (LA33_0=='{') ) {s = 34;}

                        else if ( (LA33_0=='}') ) {s = 35;}

                        else if ( (LA33_0=='l') ) {s = 36;}

                        else if ( (LA33_0=='m') ) {s = 37;}

                        else if ( (LA33_0=='T') ) {s = 38;}

                        else if ( (LA33_0=='^') ) {s = 39;}

                        else if ( (LA33_0=='_'||(LA33_0>='d' && LA33_0<='e')||LA33_0=='h'||(LA33_0>='j' && LA33_0<='k')||LA33_0=='q'||(LA33_0>='y' && LA33_0<='z')) ) {s = 40;}

                        else if ( ((LA33_0>='0' && LA33_0<='1')) ) {s = 41;}

                        else if ( (LA33_0=='\"') ) {s = 42;}

                        else if ( (LA33_0=='\'') ) {s = 43;}

                        else if ( (LA33_0=='\t'||LA33_0==' ') ) {s = 44;}

                        else if ( (LA33_0=='\n'||LA33_0=='\r') ) {s = 45;}

                        else if ( ((LA33_0>='A' && LA33_0<='S')||(LA33_0>='U' && LA33_0<='Z')) ) {s = 46;}

                        else if ( (LA33_0=='3') ) {s = 47;}

                        else if ( ((LA33_0>='4' && LA33_0<='9')) ) {s = 48;}

                        else if ( (LA33_0=='2') ) {s = 49;}

                        else if ( ((LA33_0>='\u0000' && LA33_0<='\b')||(LA33_0>='\u000B' && LA33_0<='\f')||(LA33_0>='\u000E' && LA33_0<='\u001F')||LA33_0=='!'||LA33_0=='$'||LA33_0=='&'||LA33_0==';'||(LA33_0>='?' && LA33_0<='@')||LA33_0=='\\'||LA33_0=='`'||(LA33_0>='~' && LA33_0<='\uFFFF')) ) {s = 50;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA33_57 = input.LA(1);

                        s = -1;
                        if ( ((LA33_57>='\u0000' && LA33_57<=')')||(LA33_57>='+' && LA33_57<='\uFFFF')) ) {s = 121;}

                        else if ( (LA33_57=='*') ) {s = 122;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA33_42 = input.LA(1);

                        s = -1;
                        if ( ((LA33_42>='\u0000' && LA33_42<='\uFFFF')) ) {s = 113;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}