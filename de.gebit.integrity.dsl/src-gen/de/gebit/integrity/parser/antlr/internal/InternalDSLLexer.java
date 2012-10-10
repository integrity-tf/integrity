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
    public static final int RULE_ID=8;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=18;
    public static final int T__20=20;
    public static final int RULE_SL_VISIBLE_COMMENT=4;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_BOOLEAN_FALSE=12;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_UPPERCASE_ID=13;
    public static final int RULE_DIVIDER=6;
    public static final int RULE_DECIMAL=10;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int RULE_NEWLINE=14;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_ML_VISIBLE_COMMENT=5;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=17;
    public static final int RULE_ML_COMMENT=16;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=7;
    public static final int RULE_BOOLEAN_TRUE=11;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=15;
    public static final int RULE_INTEGER=9;

    // delegates
    // delegators

    public InternalDSLLexer() {;} 
    public InternalDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g"; }

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:11:7: ( 'packagedef' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:11:9: 'packagedef'
            {
            match("packagedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:12:7: ( 'with' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:12:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:13:7: ( 'packageend' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:13:9: 'packageend'
            {
            match("packageend"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:14:7: ( 'import' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:14:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:15:7: ( 'forkdef' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:15:9: 'forkdef'
            {
            match("forkdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:16:7: ( 'uses' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:16:9: 'uses'
            {
            match("uses"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:17:7: ( ':' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:17:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:18:7: ( 'variantdef' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:18:9: 'variantdef'
            {
            match("variantdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:19:7: ( 'testdef' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:19:9: 'testdef'
            {
            match("testdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:20:7: ( 'calldef' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:20:9: 'calldef'
            {
            match("calldef"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:21:7: ( 'suitedef' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:21:9: 'suitedef'
            {
            match("suitedef"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:22:7: ( 'gets' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:22:9: 'gets'
            {
            match("gets"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:23:7: ( 'requires' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:23:9: 'requires'
            {
            match("requires"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:24:7: ( 'concludedby' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:24:9: 'concludedby'
            {
            match("concludedby"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:25:7: ( 'suiteend' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:25:9: 'suiteend'
            {
            match("suiteend"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:26:7: ( 'operationdef' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:26:9: 'operationdef'
            {
            match("operationdef"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:27:7: ( 'variable' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:27:9: 'variable'
            {
            match("variable"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:28:7: ( 'initially' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:28:9: 'initially'
            {
            match("initially"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:29:7: ( 'constant' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:29:9: 'constant'
            {
            match("constant"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:30:7: ( 'in' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:30:9: 'in'
            {
            match("in"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:31:7: ( 'test' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:31:9: 'test'
            {
            match("test"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:32:7: ( '=' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:32:9: '='
            {
            match('='); 

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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:33:7: ( 'tabletest' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:33:9: 'tabletest'
            {
            match("tabletest"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:34:7: ( '|' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:34:9: '|'
            {
            match('|'); 

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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:35:7: ( 'call' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:35:9: 'call'
            {
            match("call"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:36:7: ( '->' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:36:9: '->'
            {
            match("->"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:37:7: ( 'suite' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:37:9: 'suite'
            {
            match("suite"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:38:7: ( 'on' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:38:9: 'on'
            {
            match("on"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:39:7: ( '+' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:39:9: '+'
            {
            match('+'); 

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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:40:7: ( '(' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:40:9: '('
            {
            match('('); 

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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:41:7: ( ')' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:41:9: ')'
            {
            match(')'); 

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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:42:7: ( ',' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:42:9: ','
            {
            match(','); 

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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:43:7: ( 'null' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:43:9: 'null'
            {
            match("null"); 


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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:44:7: ( '#' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:44:9: '#'
            {
            match('#'); 

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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:45:7: ( '*' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:45:9: '*'
            {
            match('*'); 

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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:46:7: ( '.' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:46:9: '.'
            {
            match('.'); 

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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:47:7: ( '.*' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:47:9: '.*'
            {
            match(".*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "RULE_BOOLEAN_TRUE"
    public final void mRULE_BOOLEAN_TRUE() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4215:19: ( 'true' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4215:21: 'true'
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4217:20: ( 'false' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4217:22: 'false'
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4219:19: ( 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4219:21: 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            {
            matchRange('A','Z'); 
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4219:30: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4221:9: ( ( '^' )? ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4221:11: ( '^' )? ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4221:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4221:11: '^'
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4221:31: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4223:14: ( ( '-' )? ( '0' .. '9' )+ )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4223:16: ( '-' )? ( '0' .. '9' )+
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4223:16: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4223:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4223:21: ( '0' .. '9' )+
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
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4223:22: '0' .. '9'
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:14: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:16: ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:16: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:21: ( '0' .. '9' )+
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
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:22: '0' .. '9'
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:37: ( '0' .. '9' )+
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
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:38: '0' .. '9'
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:66: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:137: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4229:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4229:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4229:24: ( options {greedy=false; } : . )*
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
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4229:52: .
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4231:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4231:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4231:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4231:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4231:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4231:41: ( '\\r' )? '\\n'
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4231:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4231:41: '\\r'
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4233:25: ( '-- ' (~ ( ( '\\n' | '\\r' ) ) )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4233:27: '-- ' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match("-- "); 

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4233:33: (~ ( ( '\\n' | '\\r' ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4233:33: ~ ( ( '\\n' | '\\r' ) )
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

    // $ANTLR start "RULE_ML_VISIBLE_COMMENT"
    public final void mRULE_ML_VISIBLE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_VISIBLE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4235:25: ( '/-' ( options {greedy=false; } : . )* '-/' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4235:27: '/-' ( options {greedy=false; } : . )* '-/'
            {
            match("/-"); 

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4235:32: ( options {greedy=false; } : . )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='-') ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1=='/') ) {
                        alt17=2;
                    }
                    else if ( ((LA17_1>='\u0000' && LA17_1<='.')||(LA17_1>='0' && LA17_1<='\uFFFF')) ) {
                        alt17=1;
                    }


                }
                else if ( ((LA17_0>='\u0000' && LA17_0<=',')||(LA17_0>='.' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4235:60: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop17;
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

    // $ANTLR start "RULE_DIVIDER"
    public final void mRULE_DIVIDER() throws RecognitionException {
        try {
            int _type = RULE_DIVIDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4237:14: ( '---' ( '-' )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4237:16: '---' ( '-' )*
            {
            match("---"); 

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4237:22: ( '-' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='-') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4237:22: '-'
            	    {
            	    match('-'); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4239:9: ( ( ' ' | '\\t' )+ )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4239:11: ( ' ' | '\\t' )+
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4239:11: ( ' ' | '\\t' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\t'||LA19_0==' ') ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:
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
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4241:14: ( ( '\\r' | '\\n' )+ )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4241:16: ( '\\r' | '\\n' )+
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4241:16: ( '\\r' | '\\n' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='\n'||LA20_0=='\r') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:
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
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4243:16: ( . )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4243:18: .
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
        // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | RULE_BOOLEAN_TRUE | RULE_BOOLEAN_FALSE | RULE_UPPERCASE_ID | RULE_ID | RULE_INTEGER | RULE_DECIMAL | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SL_VISIBLE_COMMENT | RULE_ML_VISIBLE_COMMENT | RULE_DIVIDER | RULE_WS | RULE_NEWLINE | RULE_ANY_OTHER )
        int alt21=52;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:10: T__19
                {
                mT__19(); 

                }
                break;
            case 2 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:16: T__20
                {
                mT__20(); 

                }
                break;
            case 3 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:22: T__21
                {
                mT__21(); 

                }
                break;
            case 4 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:28: T__22
                {
                mT__22(); 

                }
                break;
            case 5 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:34: T__23
                {
                mT__23(); 

                }
                break;
            case 6 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:40: T__24
                {
                mT__24(); 

                }
                break;
            case 7 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:46: T__25
                {
                mT__25(); 

                }
                break;
            case 8 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:52: T__26
                {
                mT__26(); 

                }
                break;
            case 9 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:58: T__27
                {
                mT__27(); 

                }
                break;
            case 10 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:64: T__28
                {
                mT__28(); 

                }
                break;
            case 11 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:70: T__29
                {
                mT__29(); 

                }
                break;
            case 12 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:76: T__30
                {
                mT__30(); 

                }
                break;
            case 13 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:82: T__31
                {
                mT__31(); 

                }
                break;
            case 14 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:88: T__32
                {
                mT__32(); 

                }
                break;
            case 15 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:94: T__33
                {
                mT__33(); 

                }
                break;
            case 16 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:100: T__34
                {
                mT__34(); 

                }
                break;
            case 17 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:106: T__35
                {
                mT__35(); 

                }
                break;
            case 18 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:112: T__36
                {
                mT__36(); 

                }
                break;
            case 19 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:118: T__37
                {
                mT__37(); 

                }
                break;
            case 20 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:124: T__38
                {
                mT__38(); 

                }
                break;
            case 21 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:130: T__39
                {
                mT__39(); 

                }
                break;
            case 22 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:136: T__40
                {
                mT__40(); 

                }
                break;
            case 23 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:142: T__41
                {
                mT__41(); 

                }
                break;
            case 24 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:148: T__42
                {
                mT__42(); 

                }
                break;
            case 25 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:154: T__43
                {
                mT__43(); 

                }
                break;
            case 26 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:160: T__44
                {
                mT__44(); 

                }
                break;
            case 27 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:166: T__45
                {
                mT__45(); 

                }
                break;
            case 28 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:172: T__46
                {
                mT__46(); 

                }
                break;
            case 29 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:178: T__47
                {
                mT__47(); 

                }
                break;
            case 30 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:184: T__48
                {
                mT__48(); 

                }
                break;
            case 31 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:190: T__49
                {
                mT__49(); 

                }
                break;
            case 32 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:196: T__50
                {
                mT__50(); 

                }
                break;
            case 33 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:202: T__51
                {
                mT__51(); 

                }
                break;
            case 34 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:208: T__52
                {
                mT__52(); 

                }
                break;
            case 35 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:214: T__53
                {
                mT__53(); 

                }
                break;
            case 36 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:220: T__54
                {
                mT__54(); 

                }
                break;
            case 37 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:226: T__55
                {
                mT__55(); 

                }
                break;
            case 38 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:232: RULE_BOOLEAN_TRUE
                {
                mRULE_BOOLEAN_TRUE(); 

                }
                break;
            case 39 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:250: RULE_BOOLEAN_FALSE
                {
                mRULE_BOOLEAN_FALSE(); 

                }
                break;
            case 40 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:269: RULE_UPPERCASE_ID
                {
                mRULE_UPPERCASE_ID(); 

                }
                break;
            case 41 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:287: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 42 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:295: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 43 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:308: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 44 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:321: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 45 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:333: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 46 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:349: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 47 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:365: RULE_SL_VISIBLE_COMMENT
                {
                mRULE_SL_VISIBLE_COMMENT(); 

                }
                break;
            case 48 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:389: RULE_ML_VISIBLE_COMMENT
                {
                mRULE_ML_VISIBLE_COMMENT(); 

                }
                break;
            case 49 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:413: RULE_DIVIDER
                {
                mRULE_DIVIDER(); 

                }
                break;
            case 50 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:426: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 51 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:434: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 52 :
                // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1:447: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\1\uffff\5\44\1\uffff\7\44\2\uffff\1\42\4\uffff\1\44\2\uffff\1"+
        "\104\1\uffff\1\42\1\uffff\1\106\3\42\3\uffff\1\44\1\uffff\2\44\1"+
        "\122\3\44\1\uffff\12\44\1\140\4\uffff\1\106\4\uffff\1\44\15\uffff"+
        "\4\44\1\uffff\15\44\3\uffff\2\44\1\170\4\44\1\175\1\44\1\u0080\1"+
        "\44\1\u0082\1\u0084\3\44\1\u0088\2\44\1\u008b\1\44\1\uffff\3\44"+
        "\1\u0090\1\uffff\2\44\1\uffff\1\44\1\uffff\1\44\1\uffff\2\44\1\u009a"+
        "\1\uffff\2\44\1\uffff\1\44\1\u009e\2\44\1\uffff\11\44\1\uffff\3"+
        "\44\1\uffff\1\44\1\u00af\2\44\1\u00b2\1\44\1\u00b4\11\44\1\uffff"+
        "\1\44\1\u00bf\1\uffff\1\44\1\uffff\1\44\1\u00c2\1\u00c3\1\u00c4"+
        "\1\u00c5\3\44\1\u00c9\1\44\1\uffff\1\u00cb\1\44\4\uffff\1\44\1\u00ce"+
        "\1\u00cf\1\uffff\1\u00d0\1\uffff\2\44\3\uffff\1\u00d3\1\44\1\uffff"+
        "\1\u00d5\1\uffff";
    static final String DFA21_eofS =
        "\u00d6\uffff";
    static final String DFA21_minS =
        "\1\0\1\141\1\151\1\155\1\141\1\163\1\uffff\3\141\1\165\2\145\1"+
        "\156\2\uffff\1\55\4\uffff\1\165\2\uffff\1\52\1\uffff\1\137\1\uffff"+
        "\1\56\2\0\1\52\3\uffff\1\143\1\uffff\1\164\1\160\1\60\1\162\1\154"+
        "\1\145\1\uffff\1\162\1\163\1\142\1\165\1\154\1\156\1\151\1\164\1"+
        "\161\1\145\1\60\3\uffff\1\40\1\56\4\uffff\1\154\15\uffff\1\153\1"+
        "\150\1\157\1\164\1\uffff\1\153\2\163\1\151\1\164\1\154\1\145\1\154"+
        "\1\143\1\164\1\163\1\165\1\162\3\uffff\1\154\1\141\1\60\1\162\1"+
        "\151\1\144\1\145\1\60\1\141\1\60\1\145\2\60\1\154\1\164\1\145\1"+
        "\60\1\151\1\141\1\60\1\147\1\uffff\1\164\1\141\1\145\1\60\1\uffff"+
        "\1\142\1\145\1\uffff\1\164\1\uffff\1\145\1\uffff\1\165\1\141\1\60"+
        "\1\uffff\1\162\1\164\1\uffff\1\145\1\60\1\154\1\146\1\uffff\1\164"+
        "\1\154\1\146\1\145\1\146\1\144\1\156\1\145\1\156\1\uffff\1\145\1"+
        "\151\1\144\1\uffff\1\154\1\60\1\144\1\145\1\60\1\163\1\60\1\145"+
        "\1\164\1\146\1\144\1\163\1\157\1\145\1\156\1\171\1\uffff\1\145\1"+
        "\60\1\uffff\1\164\1\uffff\1\144\4\60\1\156\1\146\1\144\1\60\1\146"+
        "\1\uffff\1\60\1\142\4\uffff\1\144\2\60\1\uffff\1\60\1\uffff\1\171"+
        "\1\145\3\uffff\1\60\1\146\1\uffff\1\60\1\uffff";
    static final String DFA21_maxS =
        "\1\uffff\1\141\1\151\1\156\1\157\1\163\1\uffff\1\141\1\162\1\157"+
        "\1\165\2\145\1\160\2\uffff\1\76\4\uffff\1\165\2\uffff\1\52\1\uffff"+
        "\1\172\1\uffff\1\71\2\uffff\1\57\3\uffff\1\143\1\uffff\1\164\1\160"+
        "\1\172\1\162\1\154\1\145\1\uffff\1\162\1\163\1\142\1\165\1\154\1"+
        "\156\1\151\1\164\1\161\1\145\1\172\3\uffff\1\55\1\71\4\uffff\1\154"+
        "\15\uffff\1\153\1\150\1\157\1\164\1\uffff\1\153\2\163\1\151\1\164"+
        "\1\154\1\145\1\154\1\163\1\164\1\163\1\165\1\162\3\uffff\1\154\1"+
        "\141\1\172\1\162\1\151\1\144\1\145\1\172\1\141\1\172\1\145\2\172"+
        "\1\154\1\164\1\145\1\172\1\151\1\141\1\172\1\147\1\uffff\1\164\1"+
        "\141\1\145\1\172\1\uffff\1\156\1\145\1\uffff\1\164\1\uffff\1\145"+
        "\1\uffff\1\165\1\141\1\172\1\uffff\1\162\1\164\1\uffff\1\145\1\172"+
        "\1\154\1\146\1\uffff\1\164\1\154\1\146\1\145\1\146\1\144\1\156\1"+
        "\145\1\156\1\uffff\1\145\1\151\1\145\1\uffff\1\154\1\172\1\144\1"+
        "\145\1\172\1\163\1\172\1\145\1\164\1\146\1\144\1\163\1\157\1\145"+
        "\1\156\1\171\1\uffff\1\145\1\172\1\uffff\1\164\1\uffff\1\144\4\172"+
        "\1\156\1\146\1\144\1\172\1\146\1\uffff\1\172\1\142\4\uffff\1\144"+
        "\2\172\1\uffff\1\172\1\uffff\1\171\1\145\3\uffff\1\172\1\146\1\uffff"+
        "\1\172\1\uffff";
    static final String DFA21_acceptS =
        "\6\uffff\1\7\7\uffff\1\26\1\30\1\uffff\1\35\1\36\1\37\1\40\1\uffff"+
        "\1\42\1\43\1\uffff\1\50\1\uffff\1\51\4\uffff\1\62\1\63\1\64\1\uffff"+
        "\1\51\6\uffff\1\7\13\uffff\1\26\1\30\1\32\2\uffff\1\35\1\36\1\37"+
        "\1\40\1\uffff\1\42\1\43\1\45\1\44\1\50\1\52\1\53\1\54\1\55\1\56"+
        "\1\60\1\62\1\63\4\uffff\1\24\15\uffff\1\34\1\57\1\61\25\uffff\1"+
        "\2\4\uffff\1\6\2\uffff\1\25\1\uffff\1\46\1\uffff\1\31\3\uffff\1"+
        "\14\2\uffff\1\41\4\uffff\1\47\11\uffff\1\33\3\uffff\1\4\20\uffff"+
        "\1\5\2\uffff\1\11\1\uffff\1\12\12\uffff\1\21\2\uffff\1\23\1\13\1"+
        "\17\1\15\3\uffff\1\22\1\uffff\1\27\2\uffff\1\1\1\3\1\10\2\uffff"+
        "\1\16\1\uffff\1\20";
    static final String DFA21_specialS =
        "\1\0\34\uffff\1\2\1\1\u00b7\uffff}>";
    static final String[] DFA21_transitionS = {
            "\11\42\1\40\1\41\2\42\1\41\22\42\1\40\1\42\1\35\1\26\3\42\1"+
            "\36\1\22\1\23\1\27\1\21\1\24\1\20\1\30\1\37\12\34\1\6\2\42\1"+
            "\16\3\42\32\31\3\42\1\32\1\33\1\42\2\33\1\11\2\33\1\4\1\13\1"+
            "\33\1\3\4\33\1\25\1\15\1\1\1\33\1\14\1\12\1\10\1\5\1\7\1\2\3"+
            "\33\1\42\1\17\uff83\42",
            "\1\43",
            "\1\45",
            "\1\46\1\47",
            "\1\51\15\uffff\1\50",
            "\1\52",
            "",
            "\1\54",
            "\1\56\3\uffff\1\55\14\uffff\1\57",
            "\1\60\15\uffff\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\66\1\uffff\1\65",
            "",
            "",
            "\1\72\2\uffff\12\73\4\uffff\1\71",
            "",
            "",
            "",
            "",
            "\1\100",
            "",
            "",
            "\1\103",
            "",
            "\1\44\1\uffff\32\44",
            "",
            "\1\107\1\uffff\12\73",
            "\0\110",
            "\0\110",
            "\1\111\2\uffff\1\113\1\uffff\1\112",
            "",
            "",
            "",
            "\1\116",
            "",
            "\1\117",
            "\1\120",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\10\44\1\121\21\44",
            "\1\123",
            "\1\124",
            "\1\125",
            "",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "",
            "\1\141\14\uffff\1\142",
            "\1\107\1\uffff\12\73",
            "",
            "",
            "",
            "",
            "\1\143",
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
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160\17\uffff\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "",
            "",
            "",
            "\1\166",
            "\1\167",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\176",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\177\26\44",
            "\1\u0081",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\u0083\26"+
            "\44",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0089",
            "\1\u008a",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u008c",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\u0092\13\uffff\1\u0091",
            "\1\u0093",
            "",
            "\1\u0094",
            "",
            "\1\u0095",
            "",
            "\1\u0096",
            "\1\u0097",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\u0098\1\u0099"+
            "\25\44",
            "",
            "\1\u009b",
            "\1\u009c",
            "",
            "\1\u009d",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u009f",
            "\1\u00a0",
            "",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac\1\u00ad",
            "",
            "\1\u00ae",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00b0",
            "\1\u00b1",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00b3",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "\1\u00be",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\u00c0",
            "",
            "\1\u00c1",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00ca",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00cc",
            "",
            "",
            "",
            "",
            "\1\u00cd",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\u00d1",
            "\1\u00d2",
            "",
            "",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00d4",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | RULE_BOOLEAN_TRUE | RULE_BOOLEAN_FALSE | RULE_UPPERCASE_ID | RULE_ID | RULE_INTEGER | RULE_DECIMAL | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SL_VISIBLE_COMMENT | RULE_ML_VISIBLE_COMMENT | RULE_DIVIDER | RULE_WS | RULE_NEWLINE | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_0 = input.LA(1);

                        s = -1;
                        if ( (LA21_0=='p') ) {s = 1;}

                        else if ( (LA21_0=='w') ) {s = 2;}

                        else if ( (LA21_0=='i') ) {s = 3;}

                        else if ( (LA21_0=='f') ) {s = 4;}

                        else if ( (LA21_0=='u') ) {s = 5;}

                        else if ( (LA21_0==':') ) {s = 6;}

                        else if ( (LA21_0=='v') ) {s = 7;}

                        else if ( (LA21_0=='t') ) {s = 8;}

                        else if ( (LA21_0=='c') ) {s = 9;}

                        else if ( (LA21_0=='s') ) {s = 10;}

                        else if ( (LA21_0=='g') ) {s = 11;}

                        else if ( (LA21_0=='r') ) {s = 12;}

                        else if ( (LA21_0=='o') ) {s = 13;}

                        else if ( (LA21_0=='=') ) {s = 14;}

                        else if ( (LA21_0=='|') ) {s = 15;}

                        else if ( (LA21_0=='-') ) {s = 16;}

                        else if ( (LA21_0=='+') ) {s = 17;}

                        else if ( (LA21_0=='(') ) {s = 18;}

                        else if ( (LA21_0==')') ) {s = 19;}

                        else if ( (LA21_0==',') ) {s = 20;}

                        else if ( (LA21_0=='n') ) {s = 21;}

                        else if ( (LA21_0=='#') ) {s = 22;}

                        else if ( (LA21_0=='*') ) {s = 23;}

                        else if ( (LA21_0=='.') ) {s = 24;}

                        else if ( ((LA21_0>='A' && LA21_0<='Z')) ) {s = 25;}

                        else if ( (LA21_0=='^') ) {s = 26;}

                        else if ( (LA21_0=='_'||(LA21_0>='a' && LA21_0<='b')||(LA21_0>='d' && LA21_0<='e')||LA21_0=='h'||(LA21_0>='j' && LA21_0<='m')||LA21_0=='q'||(LA21_0>='x' && LA21_0<='z')) ) {s = 27;}

                        else if ( ((LA21_0>='0' && LA21_0<='9')) ) {s = 28;}

                        else if ( (LA21_0=='\"') ) {s = 29;}

                        else if ( (LA21_0=='\'') ) {s = 30;}

                        else if ( (LA21_0=='/') ) {s = 31;}

                        else if ( (LA21_0=='\t'||LA21_0==' ') ) {s = 32;}

                        else if ( (LA21_0=='\n'||LA21_0=='\r') ) {s = 33;}

                        else if ( ((LA21_0>='\u0000' && LA21_0<='\b')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\u001F')||LA21_0=='!'||(LA21_0>='$' && LA21_0<='&')||(LA21_0>=';' && LA21_0<='<')||(LA21_0>='>' && LA21_0<='@')||(LA21_0>='[' && LA21_0<=']')||LA21_0=='`'||LA21_0=='{'||(LA21_0>='}' && LA21_0<='\uFFFF')) ) {s = 34;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_30 = input.LA(1);

                        s = -1;
                        if ( ((LA21_30>='\u0000' && LA21_30<='\uFFFF')) ) {s = 72;}

                        else s = 34;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_29 = input.LA(1);

                        s = -1;
                        if ( ((LA21_29>='\u0000' && LA21_29<='\uFFFF')) ) {s = 72;}

                        else s = 34;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}