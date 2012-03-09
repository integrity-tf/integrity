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
    public static final int RULE_ID=6;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=16;
    public static final int T__20=20;
    public static final int RULE_SL_VISIBLE_COMMENT=8;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_BOOLEAN_FALSE=5;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_UPPERCASE_ID=7;
    public static final int RULE_DECIMAL=12;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_ML_VISIBLE_COMMENT=9;
    public static final int T__48=48;
    public static final int RULE_SL_COMMENT=14;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_BOOLEAN_TRUE=4;
    public static final int RULE_STRING=10;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=15;
    public static final int RULE_INTEGER=11;

    // delegates
    // delegators

    public InternalDSLLexer() {;} 
    public InternalDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:11:7: ( 'packagedef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:11:9: 'packagedef'
            {
            match("packagedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:12:7: ( 'with' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:12:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:13:7: ( 'packageend' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:13:9: 'packageend'
            {
            match("packageend"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:14:7: ( 'import' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:14:9: 'import'
            {
            match("import"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:15:7: ( 'forkdef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:15:9: 'forkdef'
            {
            match("forkdef"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:16:7: ( 'uses' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:16:9: 'uses'
            {
            match("uses"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:17:7: ( 'testdef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:17:9: 'testdef'
            {
            match("testdef"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:18:7: ( 'calldef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:18:9: 'calldef'
            {
            match("calldef"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:19:7: ( 'suitedef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:19:9: 'suitedef'
            {
            match("suitedef"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:20:7: ( 'suiteend' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:20:9: 'suiteend'
            {
            match("suiteend"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:21:7: ( 'gets' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:21:9: 'gets'
            {
            match("gets"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:22:7: ( 'requires' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:22:9: 'requires'
            {
            match("requires"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:23:7: ( 'concludedby' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:23:9: 'concludedby'
            {
            match("concludedby"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:24:7: ( 'variable' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:24:9: 'variable'
            {
            match("variable"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:25:7: ( 'initially' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:25:9: 'initially'
            {
            match("initially"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:26:7: ( 'constant' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:26:9: 'constant'
            {
            match("constant"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:27:7: ( 'test' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:27:9: 'test'
            {
            match("test"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:28:7: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:28:9: '='
            {
            match('='); 

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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:29:7: ( 'tabletest' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:29:9: 'tabletest'
            {
            match("tabletest"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:30:7: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:30:9: '|'
            {
            match('|'); 

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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:31:7: ( 'call' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:31:9: 'call'
            {
            match("call"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:32:7: ( '->' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:32:9: '->'
            {
            match("->"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:33:7: ( 'suite' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:33:9: 'suite'
            {
            match("suite"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:34:7: ( 'on' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:34:9: 'on'
            {
            match("on"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:35:7: ( ':' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:35:9: ':'
            {
            match(':'); 

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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:36:7: ( '+' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:36:9: '+'
            {
            match('+'); 

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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:37:7: ( ',' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:37:9: ','
            {
            match(','); 

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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:38:7: ( 'null' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:38:9: 'null'
            {
            match("null"); 


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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:39:7: ( '#' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:39:9: '#'
            {
            match('#'); 

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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:40:7: ( '*' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:40:9: '*'
            {
            match('*'); 

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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:41:7: ( '.' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:41:9: '.'
            {
            match('.'); 

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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:42:7: ( '.*' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:42:9: '.*'
            {
            match(".*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "RULE_BOOLEAN_TRUE"
    public final void mRULE_BOOLEAN_TRUE() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6536:19: ( 'true' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6536:21: 'true'
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6538:20: ( 'false' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6538:22: 'false'
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6540:19: ( 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6540:21: 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            {
            matchRange('A','Z'); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6540:30: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6542:9: ( ( '^' )? ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6542:11: ( '^' )? ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6542:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6542:11: '^'
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

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6542:31: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6544:14: ( ( '-' )? ( '0' .. '9' )+ )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6544:16: ( '-' )? ( '0' .. '9' )+
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6544:16: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6544:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6544:21: ( '0' .. '9' )+
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
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6544:22: '0' .. '9'
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6546:14: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6546:16: ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6546:16: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6546:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6546:21: ( '0' .. '9' )+
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
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6546:22: '0' .. '9'
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6546:37: ( '0' .. '9' )+
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
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6546:38: '0' .. '9'
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:66: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6548:137: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6550:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6550:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6550:24: ( options {greedy=false; } : . )*
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
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6550:52: .
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6552:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6552:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6552:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6552:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6552:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6552:41: ( '\\r' )? '\\n'
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6552:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6552:41: '\\r'
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
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6554:25: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6554:27: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6554:32: (~ ( ( '\\n' | '\\r' ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6554:32: ~ ( ( '\\n' | '\\r' ) )
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

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6554:48: ( ( '\\r' )? '\\n' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\n'||LA18_0=='\r') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6554:49: ( '\\r' )? '\\n'
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6554:49: ( '\\r' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='\r') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6554:49: '\\r'
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
    // $ANTLR end "RULE_SL_VISIBLE_COMMENT"

    // $ANTLR start "RULE_ML_VISIBLE_COMMENT"
    public final void mRULE_ML_VISIBLE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_VISIBLE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6556:25: ( '/-' ( options {greedy=false; } : . )* '-/' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6556:27: '/-' ( options {greedy=false; } : . )* '-/'
            {
            match("/-"); 

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6556:32: ( options {greedy=false; } : . )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='-') ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1=='/') ) {
                        alt19=2;
                    }
                    else if ( ((LA19_1>='\u0000' && LA19_1<='.')||(LA19_1>='0' && LA19_1<='\uFFFF')) ) {
                        alt19=1;
                    }


                }
                else if ( ((LA19_0>='\u0000' && LA19_0<=',')||(LA19_0>='.' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6556:60: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop19;
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6558:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6558:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6558:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\t' && LA20_0<='\n')||LA20_0=='\r'||LA20_0==' ') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6560:16: ( . )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6560:18: .
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
        // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | RULE_BOOLEAN_TRUE | RULE_BOOLEAN_FALSE | RULE_UPPERCASE_ID | RULE_ID | RULE_INTEGER | RULE_DECIMAL | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SL_VISIBLE_COMMENT | RULE_ML_VISIBLE_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt21=45;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:10: T__17
                {
                mT__17(); 

                }
                break;
            case 2 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:16: T__18
                {
                mT__18(); 

                }
                break;
            case 3 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:22: T__19
                {
                mT__19(); 

                }
                break;
            case 4 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:28: T__20
                {
                mT__20(); 

                }
                break;
            case 5 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:34: T__21
                {
                mT__21(); 

                }
                break;
            case 6 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:40: T__22
                {
                mT__22(); 

                }
                break;
            case 7 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:46: T__23
                {
                mT__23(); 

                }
                break;
            case 8 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:52: T__24
                {
                mT__24(); 

                }
                break;
            case 9 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:58: T__25
                {
                mT__25(); 

                }
                break;
            case 10 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:64: T__26
                {
                mT__26(); 

                }
                break;
            case 11 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:70: T__27
                {
                mT__27(); 

                }
                break;
            case 12 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:76: T__28
                {
                mT__28(); 

                }
                break;
            case 13 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:82: T__29
                {
                mT__29(); 

                }
                break;
            case 14 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:88: T__30
                {
                mT__30(); 

                }
                break;
            case 15 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:94: T__31
                {
                mT__31(); 

                }
                break;
            case 16 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:100: T__32
                {
                mT__32(); 

                }
                break;
            case 17 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:106: T__33
                {
                mT__33(); 

                }
                break;
            case 18 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:112: T__34
                {
                mT__34(); 

                }
                break;
            case 19 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:118: T__35
                {
                mT__35(); 

                }
                break;
            case 20 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:124: T__36
                {
                mT__36(); 

                }
                break;
            case 21 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:130: T__37
                {
                mT__37(); 

                }
                break;
            case 22 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:136: T__38
                {
                mT__38(); 

                }
                break;
            case 23 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:142: T__39
                {
                mT__39(); 

                }
                break;
            case 24 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:148: T__40
                {
                mT__40(); 

                }
                break;
            case 25 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:154: T__41
                {
                mT__41(); 

                }
                break;
            case 26 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:160: T__42
                {
                mT__42(); 

                }
                break;
            case 27 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:166: T__43
                {
                mT__43(); 

                }
                break;
            case 28 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:172: T__44
                {
                mT__44(); 

                }
                break;
            case 29 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:178: T__45
                {
                mT__45(); 

                }
                break;
            case 30 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:184: T__46
                {
                mT__46(); 

                }
                break;
            case 31 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:190: T__47
                {
                mT__47(); 

                }
                break;
            case 32 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:196: T__48
                {
                mT__48(); 

                }
                break;
            case 33 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:202: RULE_BOOLEAN_TRUE
                {
                mRULE_BOOLEAN_TRUE(); 

                }
                break;
            case 34 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:220: RULE_BOOLEAN_FALSE
                {
                mRULE_BOOLEAN_FALSE(); 

                }
                break;
            case 35 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:239: RULE_UPPERCASE_ID
                {
                mRULE_UPPERCASE_ID(); 

                }
                break;
            case 36 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:257: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 37 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:265: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 38 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:278: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 39 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:291: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 40 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:303: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 41 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:319: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 42 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:335: RULE_SL_VISIBLE_COMMENT
                {
                mRULE_SL_VISIBLE_COMMENT(); 

                }
                break;
            case 43 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:359: RULE_ML_VISIBLE_COMMENT
                {
                mRULE_ML_VISIBLE_COMMENT(); 

                }
                break;
            case 44 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:383: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 45 :
                // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1:391: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\1\uffff\13\41\2\uffff\1\37\1\41\3\uffff\1\41\2\uffff\1\76\1\uffff"+
        "\1\37\1\uffff\1\101\3\37\2\uffff\1\41\1\uffff\17\41\4\uffff\1\101"+
        "\1\127\3\uffff\1\41\14\uffff\20\41\1\uffff\2\41\1\154\4\41\1\161"+
        "\1\163\1\41\1\165\1\167\3\41\1\173\2\41\1\176\1\41\1\uffff\3\41"+
        "\1\u0083\1\uffff\1\41\1\uffff\1\41\1\uffff\1\41\1\uffff\2\41\1\u008b"+
        "\1\uffff\2\41\1\uffff\1\41\1\u008f\2\41\1\uffff\7\41\1\uffff\3\41"+
        "\1\uffff\1\41\1\u009e\1\u009f\1\41\1\u00a1\11\41\2\uffff\1\41\1"+
        "\uffff\1\41\1\u00ad\1\u00ae\1\u00af\1\u00b0\1\u00b1\2\41\1\u00b4"+
        "\1\u00b5\1\41\5\uffff\1\u00b7\1\u00b8\2\uffff\1\41\2\uffff\1\u00ba"+
        "\1\uffff";
    static final String DFA21_eofS =
        "\u00bb\uffff";
    static final String DFA21_minS =
        "\1\0\1\141\1\151\1\155\1\141\1\163\2\141\1\165\2\145\1\141\2\uffff"+
        "\1\55\1\156\3\uffff\1\165\2\uffff\1\52\1\uffff\1\137\1\uffff\1\56"+
        "\2\0\1\52\2\uffff\1\143\1\uffff\1\164\1\160\1\151\1\162\1\154\1"+
        "\145\1\163\1\142\1\165\1\154\1\156\1\151\1\164\1\161\1\162\4\uffff"+
        "\1\56\1\60\3\uffff\1\154\14\uffff\1\153\1\150\1\157\1\164\1\153"+
        "\2\163\1\164\1\154\1\145\1\154\1\143\1\164\1\163\1\165\1\151\1\uffff"+
        "\1\154\1\141\1\60\1\162\1\151\1\144\1\145\2\60\1\145\2\60\1\154"+
        "\1\164\1\145\1\60\1\151\1\141\1\60\1\147\1\uffff\1\164\1\141\1\145"+
        "\1\60\1\uffff\1\145\1\uffff\1\164\1\uffff\1\145\1\uffff\1\165\1"+
        "\141\1\60\1\uffff\1\162\1\142\1\uffff\1\145\1\60\1\154\1\146\1\uffff"+
        "\1\146\1\145\1\146\1\144\1\156\1\145\1\156\1\uffff\1\145\1\154\1"+
        "\144\1\uffff\1\154\2\60\1\163\1\60\1\145\1\164\1\146\1\144\1\163"+
        "\2\145\1\156\1\171\2\uffff\1\164\1\uffff\1\144\5\60\1\146\1\144"+
        "\2\60\1\142\5\uffff\2\60\2\uffff\1\171\2\uffff\1\60\1\uffff";
    static final String DFA21_maxS =
        "\1\uffff\1\141\1\151\1\156\1\157\1\163\1\162\1\157\1\165\2\145"+
        "\1\141\2\uffff\1\76\1\156\3\uffff\1\165\2\uffff\1\52\1\uffff\1\172"+
        "\1\uffff\1\71\2\uffff\1\57\2\uffff\1\143\1\uffff\1\164\1\160\1\151"+
        "\1\162\1\154\1\145\1\163\1\142\1\165\1\154\1\156\1\151\1\164\1\161"+
        "\1\162\4\uffff\1\71\1\172\3\uffff\1\154\14\uffff\1\153\1\150\1\157"+
        "\1\164\1\153\2\163\1\164\1\154\1\145\1\154\1\163\1\164\1\163\1\165"+
        "\1\151\1\uffff\1\154\1\141\1\172\1\162\1\151\1\144\1\145\2\172\1"+
        "\145\2\172\1\154\1\164\1\145\1\172\1\151\1\141\1\172\1\147\1\uffff"+
        "\1\164\1\141\1\145\1\172\1\uffff\1\145\1\uffff\1\164\1\uffff\1\145"+
        "\1\uffff\1\165\1\141\1\172\1\uffff\1\162\1\142\1\uffff\1\145\1\172"+
        "\1\154\1\146\1\uffff\1\146\1\145\1\146\1\144\1\156\1\145\1\156\1"+
        "\uffff\1\145\1\154\1\145\1\uffff\1\154\2\172\1\163\1\172\1\145\1"+
        "\164\1\146\1\144\1\163\2\145\1\156\1\171\2\uffff\1\164\1\uffff\1"+
        "\144\5\172\1\146\1\144\2\172\1\142\5\uffff\2\172\2\uffff\1\171\2"+
        "\uffff\1\172\1\uffff";
    static final String DFA21_acceptS =
        "\14\uffff\1\22\1\24\2\uffff\1\31\1\32\1\33\1\uffff\1\35\1\36\1"+
        "\uffff\1\43\1\uffff\1\44\4\uffff\1\54\1\55\1\uffff\1\44\17\uffff"+
        "\1\22\1\24\1\26\1\52\2\uffff\1\31\1\32\1\33\1\uffff\1\35\1\36\1"+
        "\40\1\37\1\43\1\46\1\45\1\47\1\50\1\51\1\53\1\54\20\uffff\1\30\24"+
        "\uffff\1\2\4\uffff\1\6\1\uffff\1\21\1\uffff\1\41\1\uffff\1\25\3"+
        "\uffff\1\13\2\uffff\1\34\4\uffff\1\42\7\uffff\1\27\3\uffff\1\4\16"+
        "\uffff\1\5\1\7\1\uffff\1\10\13\uffff\1\20\1\11\1\12\1\14\1\16\2"+
        "\uffff\1\17\1\23\1\uffff\1\1\1\3\1\uffff\1\15";
    static final String DFA21_specialS =
        "\1\1\32\uffff\1\2\1\0\u009e\uffff}>";
    static final String[] DFA21_transitionS = {
            "\11\37\2\36\2\37\1\36\22\37\1\36\1\37\1\33\1\24\3\37\1\34\2"+
            "\37\1\25\1\21\1\22\1\16\1\26\1\35\12\32\1\20\2\37\1\14\3\37"+
            "\32\27\3\37\1\30\1\31\1\37\2\31\1\7\2\31\1\4\1\11\1\31\1\3\4"+
            "\31\1\23\1\17\1\1\1\31\1\12\1\10\1\6\1\5\1\13\1\2\3\31\1\37"+
            "\1\15\uff83\37",
            "\1\40",
            "\1\42",
            "\1\43\1\44",
            "\1\46\15\uffff\1\45",
            "\1\47",
            "\1\51\3\uffff\1\50\14\uffff\1\52",
            "\1\53\15\uffff\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "\1\64\2\uffff\12\65\4\uffff\1\63",
            "\1\66",
            "",
            "",
            "",
            "\1\72",
            "",
            "",
            "\1\75",
            "",
            "\1\41\1\uffff\32\41",
            "",
            "\1\100\1\uffff\12\65",
            "\0\102",
            "\0\102",
            "\1\103\2\uffff\1\105\1\uffff\1\104",
            "",
            "",
            "\1\107",
            "",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "",
            "",
            "",
            "",
            "\1\100\1\uffff\12\65",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "",
            "\1\130",
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
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144\17\uffff\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "",
            "\1\152",
            "\1\153",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\3\41\1\162\26\41",
            "\1\164",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\3\41\1\166\26\41",
            "\1\170",
            "\1\171",
            "\1\172",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\174",
            "\1\175",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\177",
            "",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\1\u0084",
            "",
            "\1\u0085",
            "",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\u0088",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\3\41\1\u0089\1\u008a"+
            "\25\41",
            "",
            "\1\u008c",
            "\1\u008d",
            "",
            "\1\u008e",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u0090",
            "\1\u0091",
            "",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b\1\u009c",
            "",
            "\1\u009d",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00a0",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "",
            "",
            "\1\u00ab",
            "",
            "\1\u00ac",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00b2",
            "\1\u00b3",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u00b6",
            "",
            "",
            "",
            "",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "\1\u00b9",
            "",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
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
            return "1:1: Tokens : ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | RULE_BOOLEAN_TRUE | RULE_BOOLEAN_FALSE | RULE_UPPERCASE_ID | RULE_ID | RULE_INTEGER | RULE_DECIMAL | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_SL_VISIBLE_COMMENT | RULE_ML_VISIBLE_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_28 = input.LA(1);

                        s = -1;
                        if ( ((LA21_28>='\u0000' && LA21_28<='\uFFFF')) ) {s = 66;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_0 = input.LA(1);

                        s = -1;
                        if ( (LA21_0=='p') ) {s = 1;}

                        else if ( (LA21_0=='w') ) {s = 2;}

                        else if ( (LA21_0=='i') ) {s = 3;}

                        else if ( (LA21_0=='f') ) {s = 4;}

                        else if ( (LA21_0=='u') ) {s = 5;}

                        else if ( (LA21_0=='t') ) {s = 6;}

                        else if ( (LA21_0=='c') ) {s = 7;}

                        else if ( (LA21_0=='s') ) {s = 8;}

                        else if ( (LA21_0=='g') ) {s = 9;}

                        else if ( (LA21_0=='r') ) {s = 10;}

                        else if ( (LA21_0=='v') ) {s = 11;}

                        else if ( (LA21_0=='=') ) {s = 12;}

                        else if ( (LA21_0=='|') ) {s = 13;}

                        else if ( (LA21_0=='-') ) {s = 14;}

                        else if ( (LA21_0=='o') ) {s = 15;}

                        else if ( (LA21_0==':') ) {s = 16;}

                        else if ( (LA21_0=='+') ) {s = 17;}

                        else if ( (LA21_0==',') ) {s = 18;}

                        else if ( (LA21_0=='n') ) {s = 19;}

                        else if ( (LA21_0=='#') ) {s = 20;}

                        else if ( (LA21_0=='*') ) {s = 21;}

                        else if ( (LA21_0=='.') ) {s = 22;}

                        else if ( ((LA21_0>='A' && LA21_0<='Z')) ) {s = 23;}

                        else if ( (LA21_0=='^') ) {s = 24;}

                        else if ( (LA21_0=='_'||(LA21_0>='a' && LA21_0<='b')||(LA21_0>='d' && LA21_0<='e')||LA21_0=='h'||(LA21_0>='j' && LA21_0<='m')||LA21_0=='q'||(LA21_0>='x' && LA21_0<='z')) ) {s = 25;}

                        else if ( ((LA21_0>='0' && LA21_0<='9')) ) {s = 26;}

                        else if ( (LA21_0=='\"') ) {s = 27;}

                        else if ( (LA21_0=='\'') ) {s = 28;}

                        else if ( (LA21_0=='/') ) {s = 29;}

                        else if ( ((LA21_0>='\t' && LA21_0<='\n')||LA21_0=='\r'||LA21_0==' ') ) {s = 30;}

                        else if ( ((LA21_0>='\u0000' && LA21_0<='\b')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\u001F')||LA21_0=='!'||(LA21_0>='$' && LA21_0<='&')||(LA21_0>='(' && LA21_0<=')')||(LA21_0>=';' && LA21_0<='<')||(LA21_0>='>' && LA21_0<='@')||(LA21_0>='[' && LA21_0<=']')||LA21_0=='`'||LA21_0=='{'||(LA21_0>='}' && LA21_0<='\uFFFF')) ) {s = 31;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_27 = input.LA(1);

                        s = -1;
                        if ( ((LA21_27>='\u0000' && LA21_27<='\uFFFF')) ) {s = 66;}

                        else s = 31;

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