package de.gebit.integrity.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDSLLexer extends Lexer {
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int RULE_SL_VISIBLE_TITLE_COMMENT=5;
    public static final int RULE_ID=10;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RULE_ANY_OTHER=27;
    public static final int RULE_SL_VISIBLE_COMMENT=4;
    public static final int RULE_TWENTYFOURHRSTIME=19;
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
    public static final int T__47=47;
    public static final int T__81=81;
    public static final int T__44=44;
    public static final int T__82=82;
    public static final int RULE_ISOTIME=18;
    public static final int RULE_ISOTIMEZONE=26;
    public static final int T__45=45;
    public static final int RULE_ML_VISIBLE_COMMENT=6;
    public static final int RULE_ML_VISIBLE_TITLE_COMMENT=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_EURODATE=16;
    public static final int RULE_USDATE=17;
    public static final int RULE_SL_COMMENT=25;
    public static final int RULE_ML_COMMENT=24;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=9;
    public static final int RULE_BOOLEAN_TRUE=13;
    public static final int T__33=33;
    public static final int T__71=71;
    public static final int T__34=34;
    public static final int T__72=72;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__70=70;
    public static final int RULE_ISODATE=15;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_TWELVEHRSTIME=20;
    public static final int T__76=76;
    public static final int RULE_WS=23;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int RULE_INTEGER=11;
    public static final int T__78=78;
    public static final int T__77=77;

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

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:11:7: ( 'packagedef' )
            // InternalDSL.g:11:9: 'packagedef'
            {
            match("packagedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:12:7: ( 'with' )
            // InternalDSL.g:12:9: 'with'
            {
            match("with"); 


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
            // InternalDSL.g:13:7: ( 'packageend' )
            // InternalDSL.g:13:9: 'packageend'
            {
            match("packageend"); 


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
            // InternalDSL.g:14:7: ( 'import' )
            // InternalDSL.g:14:9: 'import'
            {
            match("import"); 


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
            // InternalDSL.g:15:7: ( 'private' )
            // InternalDSL.g:15:9: 'private'
            {
            match("private"); 


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
            // InternalDSL.g:16:7: ( 'forkdef' )
            // InternalDSL.g:16:9: 'forkdef'
            {
            match("forkdef"); 


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
            // InternalDSL.g:17:7: ( 'uses' )
            // InternalDSL.g:17:9: 'uses'
            {
            match("uses"); 


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
            // InternalDSL.g:18:7: ( ':' )
            // InternalDSL.g:18:9: ':'
            {
            match(':'); 

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
            // InternalDSL.g:19:7: ( 'variantdef' )
            // InternalDSL.g:19:9: 'variantdef'
            {
            match("variantdef"); 


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
            // InternalDSL.g:20:7: ( 'testdef' )
            // InternalDSL.g:20:9: 'testdef'
            {
            match("testdef"); 


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
            // InternalDSL.g:21:7: ( 'calldef' )
            // InternalDSL.g:21:9: 'calldef'
            {
            match("calldef"); 


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
            // InternalDSL.g:22:7: ( 'single-run' )
            // InternalDSL.g:22:9: 'single-run'
            {
            match("single-run"); 


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
            // InternalDSL.g:23:7: ( 'inlined' )
            // InternalDSL.g:23:9: 'inlined'
            {
            match("inlined"); 


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
            // InternalDSL.g:24:7: ( 'suitedef' )
            // InternalDSL.g:24:9: 'suitedef'
            {
            match("suitedef"); 


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
            // InternalDSL.g:25:7: ( 'gets' )
            // InternalDSL.g:25:9: 'gets'
            {
            match("gets"); 


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
            // InternalDSL.g:26:7: ( 'returns' )
            // InternalDSL.g:26:9: 'returns'
            {
            match("returns"); 


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
            // InternalDSL.g:27:7: ( 'requires' )
            // InternalDSL.g:27:9: 'requires'
            {
            match("requires"); 


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
            // InternalDSL.g:28:7: ( 'concludedby' )
            // InternalDSL.g:28:9: 'concludedby'
            {
            match("concludedby"); 


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
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:30:7: ( 'by default' )
            // InternalDSL.g:30:9: 'by default'
            {
            match("by default"); 


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
            // InternalDSL.g:31:7: ( 'operationdef' )
            // InternalDSL.g:31:9: 'operationdef'
            {
            match("operationdef"); 


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
            // InternalDSL.g:32:7: ( 'variable' )
            // InternalDSL.g:32:9: 'variable'
            {
            match("variable"); 


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
            // InternalDSL.g:33:7: ( 'initially' )
            // InternalDSL.g:33:9: 'initially'
            {
            match("initially"); 


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
            // InternalDSL.g:34:7: ( 'constant' )
            // InternalDSL.g:34:9: 'constant'
            {
            match("constant"); 


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
            // InternalDSL.g:35:7: ( 'parameterized' )
            // InternalDSL.g:35:9: 'parameterized'
            {
            match("parameterized"); 


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
            // InternalDSL.g:36:7: ( 'assign' )
            // InternalDSL.g:36:9: 'assign'
            {
            match("assign"); 


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
            // InternalDSL.g:37:7: ( '->' )
            // InternalDSL.g:37:9: '->'
            {
            match("->"); 


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
            // InternalDSL.g:38:7: ( 'in' )
            // InternalDSL.g:38:9: 'in'
            {
            match("in"); 


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
            // InternalDSL.g:39:7: ( 'checkpoint' )
            // InternalDSL.g:39:9: 'checkpoint'
            {
            match("checkpoint"); 


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
            // InternalDSL.g:40:7: ( 'test' )
            // InternalDSL.g:40:9: 'test'
            {
            match("test"); 


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
            // InternalDSL.g:41:7: ( '=' )
            // InternalDSL.g:41:9: '='
            {
            match('='); 

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
            // InternalDSL.g:42:7: ( 'tabletest' )
            // InternalDSL.g:42:9: 'tabletest'
            {
            match("tabletest"); 


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
            // InternalDSL.g:43:7: ( '|' )
            // InternalDSL.g:43:9: '|'
            {
            match('|'); 

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
            // InternalDSL.g:44:7: ( 'call' )
            // InternalDSL.g:44:9: 'call'
            {
            match("call"); 


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
            // InternalDSL.g:45:7: ( 'suite' )
            // InternalDSL.g:45:9: 'suite'
            {
            match("suite"); 


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
            // InternalDSL.g:46:7: ( 'on' )
            // InternalDSL.g:46:9: 'on'
            {
            match("on"); 


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
            // InternalDSL.g:47:7: ( '+' )
            // InternalDSL.g:47:9: '+'
            {
            match('+'); 

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
            // InternalDSL.g:48:7: ( '(' )
            // InternalDSL.g:48:9: '('
            {
            match('('); 

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
            // InternalDSL.g:49:7: ( '-' )
            // InternalDSL.g:49:9: '-'
            {
            match('-'); 

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
            // InternalDSL.g:50:7: ( '*' )
            // InternalDSL.g:50:9: '*'
            {
            match('*'); 

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
            // InternalDSL.g:51:7: ( '/' )
            // InternalDSL.g:51:9: '/'
            {
            match('/'); 

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
            // InternalDSL.g:52:7: ( '%' )
            // InternalDSL.g:52:9: '%'
            {
            match('%'); 

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
            // InternalDSL.g:53:7: ( '..' )
            // InternalDSL.g:53:9: '..'
            {
            match(".."); 


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
            // InternalDSL.g:54:7: ( ')' )
            // InternalDSL.g:54:9: ')'
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
            // InternalDSL.g:55:7: ( '[' )
            // InternalDSL.g:55:9: '['
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
            // InternalDSL.g:56:7: ( ']' )
            // InternalDSL.g:56:9: ']'
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
            // InternalDSL.g:57:7: ( ',' )
            // InternalDSL.g:57:9: ','
            {
            match(','); 

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
            // InternalDSL.g:58:7: ( '<' )
            // InternalDSL.g:58:9: '<'
            {
            match('<'); 

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
            // InternalDSL.g:59:7: ( '>' )
            // InternalDSL.g:59:9: '>'
            {
            match('>'); 

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
            // InternalDSL.g:60:7: ( '#' )
            // InternalDSL.g:60:9: '#'
            {
            match('#'); 

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
            // InternalDSL.g:61:7: ( 'null' )
            // InternalDSL.g:61:9: 'null'
            {
            match("null"); 


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
            // InternalDSL.g:62:7: ( '{' )
            // InternalDSL.g:62:9: '{'
            {
            match('{'); 

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
            // InternalDSL.g:63:7: ( '}' )
            // InternalDSL.g:63:9: '}'
            {
            match('}'); 

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
            // InternalDSL.g:64:7: ( '.' )
            // InternalDSL.g:64:9: '.'
            {
            match('.'); 

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
            // InternalDSL.g:65:7: ( '.*' )
            // InternalDSL.g:65:9: '.*'
            {
            match(".*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "RULE_BOOLEAN_TRUE"
    public final void mRULE_BOOLEAN_TRUE() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:6319:19: ( 'true' )
            // InternalDSL.g:6319:21: 'true'
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
            // InternalDSL.g:6321:20: ( 'false' )
            // InternalDSL.g:6321:22: 'false'
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
            // InternalDSL.g:6323:19: ( 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* )
            // InternalDSL.g:6323:21: 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            {
            matchRange('A','Z'); 
            // InternalDSL.g:6323:30: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
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
            // InternalDSL.g:6325:9: ( ( '^' )? ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalDSL.g:6325:11: ( '^' )? ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalDSL.g:6325:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalDSL.g:6325:11: '^'
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

            // InternalDSL.g:6325:31: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // InternalDSL.g:6327:14: ( ( '-' )? ( '0' .. '9' )+ )
            // InternalDSL.g:6327:16: ( '-' )? ( '0' .. '9' )+
            {
            // InternalDSL.g:6327:16: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalDSL.g:6327:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalDSL.g:6327:21: ( '0' .. '9' )+
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
            	    // InternalDSL.g:6327:22: '0' .. '9'
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
            // InternalDSL.g:6329:14: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // InternalDSL.g:6329:16: ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // InternalDSL.g:6329:16: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDSL.g:6329:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalDSL.g:6329:21: ( '0' .. '9' )+
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
            	    // InternalDSL.g:6329:22: '0' .. '9'
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
            // InternalDSL.g:6329:37: ( '0' .. '9' )+
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
            	    // InternalDSL.g:6329:38: '0' .. '9'
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
            // InternalDSL.g:6331:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalDSL.g:6331:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalDSL.g:6331:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalDSL.g:6331:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalDSL.g:6331:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalDSL.g:6331:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // InternalDSL.g:6331:66: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalDSL.g:6331:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalDSL.g:6331:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalDSL.g:6331:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // InternalDSL.g:6331:137: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalDSL.g:6333:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalDSL.g:6333:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalDSL.g:6333:24: ( options {greedy=false; } : . )*
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
            	    // InternalDSL.g:6333:52: .
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
            // InternalDSL.g:6335:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalDSL.g:6335:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalDSL.g:6335:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDSL.g:6335:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalDSL.g:6335:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDSL.g:6335:41: ( '\\r' )? '\\n'
                    {
                    // InternalDSL.g:6335:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalDSL.g:6335:41: '\\r'
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
            // InternalDSL.g:6337:25: ( '-- ' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalDSL.g:6337:27: '-- ' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match("-- "); 

            // InternalDSL.g:6337:33: (~ ( ( '\\n' | '\\r' ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDSL.g:6337:33: ~ ( ( '\\n' | '\\r' ) )
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
            // InternalDSL.g:6339:31: ( '--- ' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalDSL.g:6339:33: '--- ' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match("--- "); 

            // InternalDSL.g:6339:40: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDSL.g:6339:40: ~ ( ( '\\n' | '\\r' ) )
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
            // InternalDSL.g:6341:25: ( '/- ' ( options {greedy=false; } : . )* '-/' )
            // InternalDSL.g:6341:27: '/- ' ( options {greedy=false; } : . )* '-/'
            {
            match("/- "); 

            // InternalDSL.g:6341:33: ( options {greedy=false; } : . )*
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
            	    // InternalDSL.g:6341:61: .
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
            // InternalDSL.g:6343:31: ( '/-- ' ( options {greedy=false; } : . )* '--/' )
            // InternalDSL.g:6343:33: '/-- ' ( options {greedy=false; } : . )* '--/'
            {
            match("/-- "); 

            // InternalDSL.g:6343:40: ( options {greedy=false; } : . )*
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
            	    // InternalDSL.g:6343:68: .
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

    // $ANTLR start "RULE_DIVIDER"
    public final void mRULE_DIVIDER() throws RecognitionException {
        try {
            int _type = RULE_DIVIDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:6345:14: ( '----' ( '-' )* )
            // InternalDSL.g:6345:16: '----' ( '-' )*
            {
            match("----"); 

            // InternalDSL.g:6345:23: ( '-' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='-') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalDSL.g:6345:23: '-'
            	    {
            	    match('-'); 

            	    }
            	    break;

            	default :
            	    break loop20;
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
            // InternalDSL.g:6347:9: ( ( ' ' | '\\t' )+ )
            // InternalDSL.g:6347:11: ( ' ' | '\\t' )+
            {
            // InternalDSL.g:6347:11: ( ' ' | '\\t' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\t'||LA21_0==' ') ) {
                    alt21=1;
                }


                switch (alt21) {
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
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
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
            // InternalDSL.g:6349:14: ( ( '\\r' | '\\n' )+ )
            // InternalDSL.g:6349:16: ( '\\r' | '\\n' )+
            {
            // InternalDSL.g:6349:16: ( '\\r' | '\\n' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\n'||LA22_0=='\r') ) {
                    alt22=1;
                }


                switch (alt22) {
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
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "RULE_ISODATE"
    public final void mRULE_ISODATE() throws RecognitionException {
        try {
            int _type = RULE_ISODATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDSL.g:6351:14: ( '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '1' '0' .. '9' '-' '0' .. '3' '0' .. '9' )
            // InternalDSL.g:6351:16: '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '-' '0' .. '1' '0' .. '9' '-' '0' .. '3' '0' .. '9'
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
            // InternalDSL.g:6353:14: ( ( 'T' RULE_TWENTYFOURHRSTIME ( RULE_ISOTIMEZONE )? | RULE_TWENTYFOURHRSTIME RULE_ISOTIMEZONE ) )
            // InternalDSL.g:6353:16: ( 'T' RULE_TWENTYFOURHRSTIME ( RULE_ISOTIMEZONE )? | RULE_TWENTYFOURHRSTIME RULE_ISOTIMEZONE )
            {
            // InternalDSL.g:6353:16: ( 'T' RULE_TWENTYFOURHRSTIME ( RULE_ISOTIMEZONE )? | RULE_TWENTYFOURHRSTIME RULE_ISOTIMEZONE )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='T') ) {
                alt24=1;
            }
            else if ( ((LA24_0>='0' && LA24_0<='2')) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalDSL.g:6353:17: 'T' RULE_TWENTYFOURHRSTIME ( RULE_ISOTIMEZONE )?
                    {
                    match('T'); 
                    mRULE_TWENTYFOURHRSTIME(); 
                    // InternalDSL.g:6353:44: ( RULE_ISOTIMEZONE )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='+'||LA23_0=='-'||LA23_0=='Z') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalDSL.g:6353:44: RULE_ISOTIMEZONE
                            {
                            mRULE_ISOTIMEZONE(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:6353:62: RULE_TWENTYFOURHRSTIME RULE_ISOTIMEZONE
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
            // InternalDSL.g:6355:27: ( ( 'Z' | ( '+' | '-' ) '0' .. '2' '0' .. '9' ( ':' )? '0' .. '5' '0' .. '9' ) )
            // InternalDSL.g:6355:29: ( 'Z' | ( '+' | '-' ) '0' .. '2' '0' .. '9' ( ':' )? '0' .. '5' '0' .. '9' )
            {
            // InternalDSL.g:6355:29: ( 'Z' | ( '+' | '-' ) '0' .. '2' '0' .. '9' ( ':' )? '0' .. '5' '0' .. '9' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='Z') ) {
                alt26=1;
            }
            else if ( (LA26_0=='+'||LA26_0=='-') ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalDSL.g:6355:30: 'Z'
                    {
                    match('Z'); 

                    }
                    break;
                case 2 :
                    // InternalDSL.g:6355:34: ( '+' | '-' ) '0' .. '2' '0' .. '9' ( ':' )? '0' .. '5' '0' .. '9'
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
                    // InternalDSL.g:6355:62: ( ':' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==':') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalDSL.g:6355:62: ':'
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
            // InternalDSL.g:6357:15: ( '0' .. '3' '0' .. '9' '.' '0' .. '1' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' )
            // InternalDSL.g:6357:17: '0' .. '3' '0' .. '9' '.' '0' .. '1' '0' .. '9' '.' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9'
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
            // InternalDSL.g:6359:13: ( '0' .. '1' '0' .. '9' '/' '0' .. '3' '0' .. '9' '/' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' )
            // InternalDSL.g:6359:15: '0' .. '1' '0' .. '9' '/' '0' .. '3' '0' .. '9' '/' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9'
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
            // InternalDSL.g:6361:24: ( '0' .. '2' '0' .. '9' ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )? )
            // InternalDSL.g:6361:26: '0' .. '2' '0' .. '9' ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )?
            {
            matchRange('0','2'); 
            matchRange('0','9'); 
            match(':'); 
            matchRange('0','5'); 
            matchRange('0','9'); 
            // InternalDSL.g:6361:66: ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==':') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalDSL.g:6361:67: ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )?
                    {
                    match(':'); 
                    matchRange('0','6'); 
                    matchRange('0','9'); 
                    // InternalDSL.g:6361:89: ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0=='.') ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalDSL.g:6361:90: '.' '0' .. '9' '0' .. '9' '0' .. '9'
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
            // InternalDSL.g:6363:20: ( '0' .. '1' '0' .. '9' ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )? ( 'am' | 'pm' ) )
            // InternalDSL.g:6363:22: '0' .. '1' '0' .. '9' ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )? ( 'am' | 'pm' )
            {
            matchRange('0','1'); 
            matchRange('0','9'); 
            match(':'); 
            matchRange('0','5'); 
            matchRange('0','9'); 
            // InternalDSL.g:6363:62: ( ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )? )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==':') ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDSL.g:6363:63: ':' '0' .. '6' '0' .. '9' ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )?
                    {
                    match(':'); 
                    matchRange('0','6'); 
                    matchRange('0','9'); 
                    // InternalDSL.g:6363:85: ( '.' '0' .. '9' '0' .. '9' '0' .. '9' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0=='.') ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalDSL.g:6363:86: '.' '0' .. '9' '0' .. '9' '0' .. '9'
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

            // InternalDSL.g:6363:121: ( 'am' | 'pm' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0=='a') ) {
                alt31=1;
            }
            else if ( (LA31_0=='p') ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalDSL.g:6363:122: 'am'
                    {
                    match("am"); 


                    }
                    break;
                case 2 :
                    // InternalDSL.g:6363:127: 'pm'
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
            // InternalDSL.g:6365:16: ( . )
            // InternalDSL.g:6365:18: .
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
        // InternalDSL.g:1:8: ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | RULE_BOOLEAN_TRUE | RULE_BOOLEAN_FALSE | RULE_UPPERCASE_ID | RULE_ID | RULE_INTEGER | RULE_DECIMAL | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SL_VISIBLE_COMMENT | RULE_SL_VISIBLE_TITLE_COMMENT | RULE_ML_VISIBLE_COMMENT | RULE_ML_VISIBLE_TITLE_COMMENT | RULE_DIVIDER | RULE_WS | RULE_NEWLINE | RULE_ISODATE | RULE_ISOTIME | RULE_EURODATE | RULE_USDATE | RULE_TWENTYFOURHRSTIME | RULE_TWELVEHRSTIME | RULE_ANY_OTHER )
        int alt32=78;
        alt32 = dfa32.predict(input);
        switch (alt32) {
            case 1 :
                // InternalDSL.g:1:10: T__28
                {
                mT__28(); 

                }
                break;
            case 2 :
                // InternalDSL.g:1:16: T__29
                {
                mT__29(); 

                }
                break;
            case 3 :
                // InternalDSL.g:1:22: T__30
                {
                mT__30(); 

                }
                break;
            case 4 :
                // InternalDSL.g:1:28: T__31
                {
                mT__31(); 

                }
                break;
            case 5 :
                // InternalDSL.g:1:34: T__32
                {
                mT__32(); 

                }
                break;
            case 6 :
                // InternalDSL.g:1:40: T__33
                {
                mT__33(); 

                }
                break;
            case 7 :
                // InternalDSL.g:1:46: T__34
                {
                mT__34(); 

                }
                break;
            case 8 :
                // InternalDSL.g:1:52: T__35
                {
                mT__35(); 

                }
                break;
            case 9 :
                // InternalDSL.g:1:58: T__36
                {
                mT__36(); 

                }
                break;
            case 10 :
                // InternalDSL.g:1:64: T__37
                {
                mT__37(); 

                }
                break;
            case 11 :
                // InternalDSL.g:1:70: T__38
                {
                mT__38(); 

                }
                break;
            case 12 :
                // InternalDSL.g:1:76: T__39
                {
                mT__39(); 

                }
                break;
            case 13 :
                // InternalDSL.g:1:82: T__40
                {
                mT__40(); 

                }
                break;
            case 14 :
                // InternalDSL.g:1:88: T__41
                {
                mT__41(); 

                }
                break;
            case 15 :
                // InternalDSL.g:1:94: T__42
                {
                mT__42(); 

                }
                break;
            case 16 :
                // InternalDSL.g:1:100: T__43
                {
                mT__43(); 

                }
                break;
            case 17 :
                // InternalDSL.g:1:106: T__44
                {
                mT__44(); 

                }
                break;
            case 18 :
                // InternalDSL.g:1:112: T__45
                {
                mT__45(); 

                }
                break;
            case 19 :
                // InternalDSL.g:1:118: T__46
                {
                mT__46(); 

                }
                break;
            case 20 :
                // InternalDSL.g:1:124: T__47
                {
                mT__47(); 

                }
                break;
            case 21 :
                // InternalDSL.g:1:130: T__48
                {
                mT__48(); 

                }
                break;
            case 22 :
                // InternalDSL.g:1:136: T__49
                {
                mT__49(); 

                }
                break;
            case 23 :
                // InternalDSL.g:1:142: T__50
                {
                mT__50(); 

                }
                break;
            case 24 :
                // InternalDSL.g:1:148: T__51
                {
                mT__51(); 

                }
                break;
            case 25 :
                // InternalDSL.g:1:154: T__52
                {
                mT__52(); 

                }
                break;
            case 26 :
                // InternalDSL.g:1:160: T__53
                {
                mT__53(); 

                }
                break;
            case 27 :
                // InternalDSL.g:1:166: T__54
                {
                mT__54(); 

                }
                break;
            case 28 :
                // InternalDSL.g:1:172: T__55
                {
                mT__55(); 

                }
                break;
            case 29 :
                // InternalDSL.g:1:178: T__56
                {
                mT__56(); 

                }
                break;
            case 30 :
                // InternalDSL.g:1:184: T__57
                {
                mT__57(); 

                }
                break;
            case 31 :
                // InternalDSL.g:1:190: T__58
                {
                mT__58(); 

                }
                break;
            case 32 :
                // InternalDSL.g:1:196: T__59
                {
                mT__59(); 

                }
                break;
            case 33 :
                // InternalDSL.g:1:202: T__60
                {
                mT__60(); 

                }
                break;
            case 34 :
                // InternalDSL.g:1:208: T__61
                {
                mT__61(); 

                }
                break;
            case 35 :
                // InternalDSL.g:1:214: T__62
                {
                mT__62(); 

                }
                break;
            case 36 :
                // InternalDSL.g:1:220: T__63
                {
                mT__63(); 

                }
                break;
            case 37 :
                // InternalDSL.g:1:226: T__64
                {
                mT__64(); 

                }
                break;
            case 38 :
                // InternalDSL.g:1:232: T__65
                {
                mT__65(); 

                }
                break;
            case 39 :
                // InternalDSL.g:1:238: T__66
                {
                mT__66(); 

                }
                break;
            case 40 :
                // InternalDSL.g:1:244: T__67
                {
                mT__67(); 

                }
                break;
            case 41 :
                // InternalDSL.g:1:250: T__68
                {
                mT__68(); 

                }
                break;
            case 42 :
                // InternalDSL.g:1:256: T__69
                {
                mT__69(); 

                }
                break;
            case 43 :
                // InternalDSL.g:1:262: T__70
                {
                mT__70(); 

                }
                break;
            case 44 :
                // InternalDSL.g:1:268: T__71
                {
                mT__71(); 

                }
                break;
            case 45 :
                // InternalDSL.g:1:274: T__72
                {
                mT__72(); 

                }
                break;
            case 46 :
                // InternalDSL.g:1:280: T__73
                {
                mT__73(); 

                }
                break;
            case 47 :
                // InternalDSL.g:1:286: T__74
                {
                mT__74(); 

                }
                break;
            case 48 :
                // InternalDSL.g:1:292: T__75
                {
                mT__75(); 

                }
                break;
            case 49 :
                // InternalDSL.g:1:298: T__76
                {
                mT__76(); 

                }
                break;
            case 50 :
                // InternalDSL.g:1:304: T__77
                {
                mT__77(); 

                }
                break;
            case 51 :
                // InternalDSL.g:1:310: T__78
                {
                mT__78(); 

                }
                break;
            case 52 :
                // InternalDSL.g:1:316: T__79
                {
                mT__79(); 

                }
                break;
            case 53 :
                // InternalDSL.g:1:322: T__80
                {
                mT__80(); 

                }
                break;
            case 54 :
                // InternalDSL.g:1:328: T__81
                {
                mT__81(); 

                }
                break;
            case 55 :
                // InternalDSL.g:1:334: T__82
                {
                mT__82(); 

                }
                break;
            case 56 :
                // InternalDSL.g:1:340: RULE_BOOLEAN_TRUE
                {
                mRULE_BOOLEAN_TRUE(); 

                }
                break;
            case 57 :
                // InternalDSL.g:1:358: RULE_BOOLEAN_FALSE
                {
                mRULE_BOOLEAN_FALSE(); 

                }
                break;
            case 58 :
                // InternalDSL.g:1:377: RULE_UPPERCASE_ID
                {
                mRULE_UPPERCASE_ID(); 

                }
                break;
            case 59 :
                // InternalDSL.g:1:395: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 60 :
                // InternalDSL.g:1:403: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 61 :
                // InternalDSL.g:1:416: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 62 :
                // InternalDSL.g:1:429: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 63 :
                // InternalDSL.g:1:441: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 64 :
                // InternalDSL.g:1:457: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 65 :
                // InternalDSL.g:1:473: RULE_SL_VISIBLE_COMMENT
                {
                mRULE_SL_VISIBLE_COMMENT(); 

                }
                break;
            case 66 :
                // InternalDSL.g:1:497: RULE_SL_VISIBLE_TITLE_COMMENT
                {
                mRULE_SL_VISIBLE_TITLE_COMMENT(); 

                }
                break;
            case 67 :
                // InternalDSL.g:1:527: RULE_ML_VISIBLE_COMMENT
                {
                mRULE_ML_VISIBLE_COMMENT(); 

                }
                break;
            case 68 :
                // InternalDSL.g:1:551: RULE_ML_VISIBLE_TITLE_COMMENT
                {
                mRULE_ML_VISIBLE_TITLE_COMMENT(); 

                }
                break;
            case 69 :
                // InternalDSL.g:1:581: RULE_DIVIDER
                {
                mRULE_DIVIDER(); 

                }
                break;
            case 70 :
                // InternalDSL.g:1:594: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 71 :
                // InternalDSL.g:1:602: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 72 :
                // InternalDSL.g:1:615: RULE_ISODATE
                {
                mRULE_ISODATE(); 

                }
                break;
            case 73 :
                // InternalDSL.g:1:628: RULE_ISOTIME
                {
                mRULE_ISOTIME(); 

                }
                break;
            case 74 :
                // InternalDSL.g:1:641: RULE_EURODATE
                {
                mRULE_EURODATE(); 

                }
                break;
            case 75 :
                // InternalDSL.g:1:655: RULE_USDATE
                {
                mRULE_USDATE(); 

                }
                break;
            case 76 :
                // InternalDSL.g:1:667: RULE_TWENTYFOURHRSTIME
                {
                mRULE_TWENTYFOURHRSTIME(); 

                }
                break;
            case 77 :
                // InternalDSL.g:1:690: RULE_TWELVEHRSTIME
                {
                mRULE_TWELVEHRSTIME(); 

                }
                break;
            case 78 :
                // InternalDSL.g:1:709: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA32_eotS =
        "\1\uffff\5\62\1\uffff\11\62\1\113\5\uffff\1\125\1\uffff\1\131\7\uffff\1\62\2\uffff\1\145\1\57\1\uffff\1\147\2\57\3\uffff\3\147\1\uffff\2\62\1\uffff\2\62\1\166\3\62\1\uffff\15\62\1\u0088\1\62\3\uffff\1\147\24\uffff\1\62\2\uffff\1\145\1\uffff\1\147\5\uffff\3\147\7\62\1\uffff\17\62\1\uffff\1\62\1\uffff\1\62\4\uffff\1\62\1\145\1\147\4\uffff\3\62\1\u00b9\5\62\1\u00bf\1\62\1\u00c2\1\62\1\u00c4\1\u00c6\5\62\1\u00cc\4\62\2\uffff\1\u00d1\1\uffff\1\147\1\uffff\1\150\1\uffff\3\62\1\uffff\4\62\1\u00dd\1\uffff\2\62\1\uffff\1\62\1\uffff\1\62\1\uffff\4\62\1\u00e9\1\uffff\4\62\2\uffff\1\u00ef\1\150\1\u00ef\3\62\1\u00f6\3\62\1\uffff\13\62\1\uffff\3\62\1\u0108\5\uffff\2\62\1\u010e\1\uffff\1\u010f\1\62\1\u0111\2\62\1\u0114\1\62\1\u0116\3\62\1\uffff\2\62\1\u011c\2\62\3\uffff\3\62\2\uffff\1\62\1\uffff\1\62\1\u0126\1\uffff\1\62\1\uffff\1\62\1\u0129\1\62\1\u012b\1\u012c\1\uffff\1\u012d\1\62\2\u00ef\3\62\1\u0134\1\62\1\uffff\1\u0136\1\62\1\uffff\1\62\3\uffff\1\62\2\uffff\1\u013c\1\u013d\1\62\1\uffff\1\u013f\1\uffff\1\62\1\u0141\1\62\4\uffff\1\62\1\uffff\1\u0146\1\uffff\1\62\2\uffff\1\62\1\uffff\1\u014b\2\u00ef\1\u014c\2\uffff";
    static final String DFA32_eofS =
        "\u014d\uffff";
    static final String DFA32_minS =
        "\1\0\1\141\1\151\1\155\1\141\1\163\1\uffff\3\141\1\151\2\145\1\171\1\156\1\163\1\55\5\uffff\1\52\1\uffff\1\52\7\uffff\1\165\2\uffff\1\60\1\137\1\uffff\1\56\2\0\3\uffff\3\56\1\uffff\1\143\1\151\1\uffff\1\164\1\160\1\60\1\162\1\154\1\145\1\uffff\1\162\1\163\1\142\1\165\1\154\1\156\1\145\1\156\1\151\1\164\1\161\1\40\1\145\1\60\1\163\1\uffff\1\40\1\uffff\1\56\7\uffff\1\40\14\uffff\1\154\2\uffff\1\60\1\uffff\1\56\5\uffff\3\56\1\153\1\141\1\166\1\150\1\157\1\151\1\164\1\uffff\1\153\2\163\1\151\1\164\1\154\1\145\1\154\2\143\1\147\1\164\1\163\2\165\1\uffff\1\162\1\uffff\1\151\1\uffff\1\40\2\uffff\1\154\1\72\1\56\2\60\1\uffff\1\60\1\141\1\155\1\141\1\60\1\162\1\156\1\151\1\144\1\145\1\60\1\141\1\60\1\145\2\60\1\154\1\164\1\153\1\154\1\145\1\60\1\162\1\151\1\141\1\147\2\uffff\1\60\1\uffff\1\55\3\60\1\147\1\145\1\164\1\uffff\1\164\1\145\1\141\1\145\1\60\1\uffff\1\142\1\145\1\uffff\1\164\1\uffff\1\145\1\uffff\1\165\1\141\1\160\1\145\1\60\1\uffff\1\156\1\162\1\164\1\156\2\uffff\1\53\1\56\1\53\1\145\1\164\1\145\1\60\1\144\1\154\1\146\1\uffff\1\164\1\154\1\146\1\145\1\146\1\144\1\156\1\157\1\55\1\145\1\156\1\uffff\1\163\1\145\1\151\2\60\3\uffff\1\60\1\144\1\145\1\60\1\uffff\1\60\1\154\1\60\1\144\1\145\1\60\1\163\1\60\1\145\1\164\1\151\1\uffff\1\146\1\144\1\60\1\163\1\157\1\uffff\2\60\1\145\1\156\1\162\2\uffff\1\171\1\uffff\1\145\1\60\1\uffff\1\164\1\uffff\1\144\1\60\1\156\2\60\1\uffff\1\60\1\156\2\53\1\146\1\144\1\151\1\60\1\146\1\uffff\1\60\1\142\1\uffff\1\164\3\uffff\1\144\4\60\1\172\1\uffff\1\60\1\uffff\1\171\1\60\1\145\2\60\2\uffff\1\145\1\uffff\1\60\1\uffff\1\146\2\60\1\144\1\uffff\1\60\2\53\1\60\2\uffff";
    static final String DFA32_maxS =
        "\1\uffff\1\162\1\151\1\156\1\157\1\163\1\uffff\1\141\1\162\1\157\1\165\2\145\1\171\1\160\1\163\1\76\5\uffff\1\57\1\uffff\1\56\7\uffff\1\165\2\uffff\1\62\1\172\1\uffff\1\71\2\uffff\3\uffff\3\71\1\uffff\1\162\1\151\1\uffff\1\164\1\160\1\172\1\162\1\154\1\145\1\uffff\1\162\1\163\1\142\1\165\1\154\1\156\1\145\1\156\1\151\2\164\1\40\1\145\1\172\1\163\1\uffff\1\55\1\uffff\1\71\7\uffff\1\55\14\uffff\1\154\2\uffff\1\71\1\uffff\1\72\5\uffff\2\71\1\72\1\153\1\141\1\166\1\150\1\157\1\151\1\164\1\uffff\1\153\2\163\1\151\1\164\1\154\1\145\1\154\1\163\1\143\1\147\1\164\1\163\2\165\1\uffff\1\162\1\uffff\1\151\1\uffff\1\55\2\uffff\1\154\1\72\1\71\1\65\1\71\1\uffff\1\65\1\141\1\155\1\141\1\172\1\162\1\156\1\151\1\144\1\145\1\172\1\141\1\172\1\145\2\172\1\154\1\164\1\153\1\154\1\145\1\172\1\162\1\151\1\141\1\147\2\uffff\1\172\1\uffff\4\71\1\147\1\145\1\164\1\uffff\1\164\1\145\1\141\1\145\1\172\1\uffff\1\156\1\145\1\uffff\1\164\1\uffff\1\145\1\uffff\1\165\1\141\1\160\1\145\1\172\1\uffff\1\156\1\162\1\164\1\156\2\uffff\1\160\1\56\1\132\1\145\1\164\1\145\1\172\1\144\1\154\1\146\1\uffff\1\164\1\154\1\146\1\145\1\146\1\144\1\156\1\157\1\55\1\145\1\156\1\uffff\1\163\1\145\1\151\1\172\1\66\3\uffff\1\66\2\145\1\172\1\uffff\1\172\1\154\1\172\1\144\1\145\1\172\1\163\1\172\1\145\1\164\1\151\1\uffff\1\146\1\144\1\172\1\163\1\157\1\uffff\2\71\1\145\1\156\1\162\2\uffff\1\171\1\uffff\1\145\1\172\1\uffff\1\164\1\uffff\1\144\1\172\1\156\2\172\1\uffff\1\172\1\156\1\160\1\132\1\146\1\144\1\151\1\172\1\146\1\uffff\1\172\1\142\1\uffff\1\164\3\uffff\1\144\2\71\3\172\1\uffff\1\172\1\uffff\1\171\1\172\1\145\2\71\2\uffff\1\145\1\uffff\1\172\1\uffff\1\146\2\71\1\144\1\uffff\1\172\1\160\1\132\1\172\2\uffff";
    static final String DFA32_acceptS =
        "\6\uffff\1\10\12\uffff\1\37\1\41\1\45\1\46\1\50\1\uffff\1\52\1\uffff\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\uffff\1\64\1\65\2\uffff\1\73\3\uffff\1\106\1\107\1\72\3\uffff\1\116\2\uffff\1\73\6\uffff\1\10\17\uffff\1\33\1\uffff\1\47\1\uffff\1\37\1\41\1\45\1\46\1\50\1\77\1\100\1\uffff\1\51\1\52\1\53\1\67\1\66\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\uffff\1\64\1\65\1\uffff\1\72\1\uffff\1\74\1\75\1\76\1\106\1\107\12\uffff\1\34\17\uffff\1\24\1\uffff\1\44\1\uffff\1\101\1\uffff\1\103\1\104\5\uffff\1\113\32\uffff\1\102\1\105\1\uffff\1\111\7\uffff\1\2\5\uffff\1\7\2\uffff\1\36\1\uffff\1\70\1\uffff\1\42\5\uffff\1\17\4\uffff\1\63\1\110\12\uffff\1\71\13\uffff\1\43\5\uffff\1\114\1\115\1\112\4\uffff\1\4\13\uffff\1\14\5\uffff\1\32\5\uffff\1\5\1\15\1\uffff\1\6\2\uffff\1\12\1\uffff\1\13\5\uffff\1\20\11\uffff\1\26\2\uffff\1\30\1\uffff\1\16\1\23\1\21\6\uffff\1\27\1\uffff\1\40\5\uffff\1\1\1\3\1\uffff\1\11\1\uffff\1\35\4\uffff\1\22\4\uffff\1\25\1\31";
    static final String DFA32_specialS =
        "\1\2\46\uffff\1\0\1\1\u0124\uffff}>";
    static final String[] DFA32_transitionS = {
            "\11\57\1\51\1\52\2\57\1\52\22\57\1\51\1\57\1\47\1\37\1\57\1\27\1\57\1\50\1\24\1\31\1\25\1\23\1\34\1\20\1\30\1\26\2\46\1\56\1\54\6\55\1\6\1\57\1\35\1\21\1\36\2\57\23\53\1\43\6\53\1\32\1\57\1\33\1\44\1\45\1\57\1\17\1\15\1\11\2\45\1\4\1\13\1\45\1\3\4\45\1\40\1\16\1\1\1\45\1\14\1\12\1\10\1\5\1\7\1\2\3\45\1\41\1\22\1\42\uff82\57",
            "\1\60\20\uffff\1\61",
            "\1\63",
            "\1\64\1\65",
            "\1\67\15\uffff\1\66",
            "\1\70",
            "",
            "\1\72",
            "\1\74\3\uffff\1\73\14\uffff\1\75",
            "\1\76\6\uffff\1\100\6\uffff\1\77",
            "\1\101\13\uffff\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\107\1\uffff\1\106",
            "\1\110",
            "\1\112\2\uffff\12\114\4\uffff\1\111",
            "",
            "",
            "",
            "",
            "",
            "\1\122\2\uffff\1\124\1\uffff\1\123",
            "",
            "\1\130\3\uffff\1\127",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\141",
            "",
            "",
            "\3\144",
            "\1\62\1\uffff\32\62",
            "",
            "\1\150\1\uffff\12\146",
            "\0\151",
            "\0\151",
            "",
            "",
            "",
            "\1\150\1\uffff\12\154",
            "\1\150\1\uffff\12\155",
            "\1\150\1\uffff\12\156",
            "",
            "\1\157\16\uffff\1\160",
            "\1\161",
            "",
            "\1\162",
            "\1\163",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\165\2\62\1\164\16\62",
            "\1\167",
            "\1\170",
            "\1\171",
            "",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0085\2\uffff\1\u0084",
            "\1\u0086",
            "\1\u0087",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0089",
            "",
            "\1\u008a\14\uffff\1\u008b",
            "",
            "\1\150\1\uffff\12\114",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008c\14\uffff\1\u008d",
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
            "",
            "\1\u008e",
            "",
            "",
            "\12\u008f",
            "",
            "\1\u0092\1\u0093\12\u0090\1\u0091",
            "",
            "",
            "",
            "",
            "",
            "\1\u0092\1\uffff\12\u0090",
            "\1\150\1\uffff\12\u0090",
            "\1\u0092\1\uffff\12\u0090\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4\17\uffff\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "",
            "\1\u00ac",
            "",
            "\1\u00ad",
            "",
            "\1\u00ae\14\uffff\1\u00af",
            "",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\150\1\uffff\12\u00b2",
            "\6\u00b3",
            "\2\u00b4\10\150",
            "",
            "\6\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00c0",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\3\62\1\u00c1\26\62",
            "\1\u00c3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\3\62\1\u00c5\26\62",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u00d2\1\150\1\uffff\12\114",
            "\12\u00d3",
            "\12\u00d4",
            "\12\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u00df\13\uffff\1\u00de",
            "\1\u00e0",
            "",
            "\1\u00e1",
            "",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\3\62\1\u00e7\1\u00e8\25\62",
            "",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "",
            "",
            "\1\u00b1\1\uffff\1\u00b1\14\uffff\1\u00ee\37\uffff\1\u00b1\6\uffff\1\u00f0\16\uffff\1\u00f0",
            "\1\u00f1",
            "\1\u00b1\1\uffff\1\u00b1\14\uffff\1\u00f2\37\uffff\1\u00b1",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\7\u0109",
            "",
            "",
            "",
            "\7\u010a",
            "\1\u010b\1\u010c",
            "\1\u010d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0110",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0112",
            "\1\u0113",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0115",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "",
            "\1\u011a",
            "\1\u011b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u011d",
            "\1\u011e",
            "",
            "\12\u011f",
            "\12\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "",
            "",
            "\1\u0124",
            "",
            "\1\u0125",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0127",
            "",
            "\1\u0128",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u012a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u012e",
            "\1\u00b1\1\uffff\1\u00b1\1\u012f\53\uffff\1\u00b1\6\uffff\1\u00f0\16\uffff\1\u00f0",
            "\1\u00b1\1\uffff\1\u00b1\1\u0130\53\uffff\1\u00b1",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0135",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0137",
            "",
            "\1\u0138",
            "",
            "",
            "",
            "\1\u0139",
            "\12\u013a",
            "\12\u013b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u013e",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0140",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0142",
            "\12\u0143",
            "\12\u0144",
            "",
            "",
            "\1\u0145",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0147",
            "\12\u0148",
            "\12\u0149",
            "\1\u014a",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00b1\1\uffff\1\u00b1\54\uffff\1\u00b1\6\uffff\1\u00f0\16\uffff\1\u00f0",
            "\1\u00b1\1\uffff\1\u00b1\54\uffff\1\u00b1",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | RULE_BOOLEAN_TRUE | RULE_BOOLEAN_FALSE | RULE_UPPERCASE_ID | RULE_ID | RULE_INTEGER | RULE_DECIMAL | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SL_VISIBLE_COMMENT | RULE_SL_VISIBLE_TITLE_COMMENT | RULE_ML_VISIBLE_COMMENT | RULE_ML_VISIBLE_TITLE_COMMENT | RULE_DIVIDER | RULE_WS | RULE_NEWLINE | RULE_ISODATE | RULE_ISOTIME | RULE_EURODATE | RULE_USDATE | RULE_TWENTYFOURHRSTIME | RULE_TWELVEHRSTIME | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_39 = input.LA(1);

                        s = -1;
                        if ( ((LA32_39>='\u0000' && LA32_39<='\uFFFF')) ) {s = 105;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_40 = input.LA(1);

                        s = -1;
                        if ( ((LA32_40>='\u0000' && LA32_40<='\uFFFF')) ) {s = 105;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_0 = input.LA(1);

                        s = -1;
                        if ( (LA32_0=='p') ) {s = 1;}

                        else if ( (LA32_0=='w') ) {s = 2;}

                        else if ( (LA32_0=='i') ) {s = 3;}

                        else if ( (LA32_0=='f') ) {s = 4;}

                        else if ( (LA32_0=='u') ) {s = 5;}

                        else if ( (LA32_0==':') ) {s = 6;}

                        else if ( (LA32_0=='v') ) {s = 7;}

                        else if ( (LA32_0=='t') ) {s = 8;}

                        else if ( (LA32_0=='c') ) {s = 9;}

                        else if ( (LA32_0=='s') ) {s = 10;}

                        else if ( (LA32_0=='g') ) {s = 11;}

                        else if ( (LA32_0=='r') ) {s = 12;}

                        else if ( (LA32_0=='b') ) {s = 13;}

                        else if ( (LA32_0=='o') ) {s = 14;}

                        else if ( (LA32_0=='a') ) {s = 15;}

                        else if ( (LA32_0=='-') ) {s = 16;}

                        else if ( (LA32_0=='=') ) {s = 17;}

                        else if ( (LA32_0=='|') ) {s = 18;}

                        else if ( (LA32_0=='+') ) {s = 19;}

                        else if ( (LA32_0=='(') ) {s = 20;}

                        else if ( (LA32_0=='*') ) {s = 21;}

                        else if ( (LA32_0=='/') ) {s = 22;}

                        else if ( (LA32_0=='%') ) {s = 23;}

                        else if ( (LA32_0=='.') ) {s = 24;}

                        else if ( (LA32_0==')') ) {s = 25;}

                        else if ( (LA32_0=='[') ) {s = 26;}

                        else if ( (LA32_0==']') ) {s = 27;}

                        else if ( (LA32_0==',') ) {s = 28;}

                        else if ( (LA32_0=='<') ) {s = 29;}

                        else if ( (LA32_0=='>') ) {s = 30;}

                        else if ( (LA32_0=='#') ) {s = 31;}

                        else if ( (LA32_0=='n') ) {s = 32;}

                        else if ( (LA32_0=='{') ) {s = 33;}

                        else if ( (LA32_0=='}') ) {s = 34;}

                        else if ( (LA32_0=='T') ) {s = 35;}

                        else if ( (LA32_0=='^') ) {s = 36;}

                        else if ( (LA32_0=='_'||(LA32_0>='d' && LA32_0<='e')||LA32_0=='h'||(LA32_0>='j' && LA32_0<='m')||LA32_0=='q'||(LA32_0>='x' && LA32_0<='z')) ) {s = 37;}

                        else if ( ((LA32_0>='0' && LA32_0<='1')) ) {s = 38;}

                        else if ( (LA32_0=='\"') ) {s = 39;}

                        else if ( (LA32_0=='\'') ) {s = 40;}

                        else if ( (LA32_0=='\t'||LA32_0==' ') ) {s = 41;}

                        else if ( (LA32_0=='\n'||LA32_0=='\r') ) {s = 42;}

                        else if ( ((LA32_0>='A' && LA32_0<='S')||(LA32_0>='U' && LA32_0<='Z')) ) {s = 43;}

                        else if ( (LA32_0=='3') ) {s = 44;}

                        else if ( ((LA32_0>='4' && LA32_0<='9')) ) {s = 45;}

                        else if ( (LA32_0=='2') ) {s = 46;}

                        else if ( ((LA32_0>='\u0000' && LA32_0<='\b')||(LA32_0>='\u000B' && LA32_0<='\f')||(LA32_0>='\u000E' && LA32_0<='\u001F')||LA32_0=='!'||LA32_0=='$'||LA32_0=='&'||LA32_0==';'||(LA32_0>='?' && LA32_0<='@')||LA32_0=='\\'||LA32_0=='`'||(LA32_0>='~' && LA32_0<='\uFFFF')) ) {s = 47;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}