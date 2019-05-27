// Generated from C:/Users/Thomas-PC/IdeaProjects/believe-revision\Grammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		QUANTIFIER=1, VARIABLE=2, NOT=3, AND=4, OR=5, IMPLIES=6, BICONDITION=7, 
		PARENTHESIS=8, BRACKET=9, PREDICATE=10, WHITESPACE=11, COMMENT=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"QUANTIFIER", "VARIABLE", "NOT", "AND", "OR", "IMPLIES", "BICONDITION", 
		"PARENTHESIS", "BRACKET", "PREDICATE", "WHITESPACE", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "QUANTIFIER", "VARIABLE", "NOT", "AND", "OR", "IMPLIES", "BICONDITION", 
		"PARENTHESIS", "BRACKET", "PREDICATE", "WHITESPACE", "COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\5\2\"\n\2\3\3\3\3\3\4\3\4"+
		"\3\4\5\4)\n\4\3\5\3\5\3\5\3\5\5\5/\n\5\3\6\3\6\3\6\3\6\5\6\65\n\6\3\7"+
		"\3\7\3\7\3\7\5\7;\n\7\3\b\3\b\3\b\3\b\3\b\5\bB\n\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13Q\n\13\3\f\6\fT\n\f\r\f\16"+
		"\fU\3\f\3\f\3\r\3\r\3\r\3\r\7\r^\n\r\f\r\16\ra\13\r\3\r\3\r\2\2\16\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\5\4\2]]__\5"+
		"\2\13\f\17\17\"\"\3\2\f\f\2l\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7(\3\2\2"+
		"\2\t.\3\2\2\2\13\64\3\2\2\2\r:\3\2\2\2\17A\3\2\2\2\21C\3\2\2\2\23E\3\2"+
		"\2\2\25P\3\2\2\2\27S\3\2\2\2\31Y\3\2\2\2\33\34\7\u00e4\2\2\34\35\7\u02c8"+
		"\2\2\35\"\7\u20ae\2\2\36\37\7\u00e4\2\2\37 \7\u02c8\2\2 \"\7\u0194\2\2"+
		"!\33\3\2\2\2!\36\3\2\2\2\"\4\3\2\2\2#$\4ru\2$\6\3\2\2\2%&\7\u00c4\2\2"+
		"&)\7\u00ae\2\2\')\7#\2\2(%\3\2\2\2(\'\3\2\2\2)\b\3\2\2\2*+\7\u00e4\2\2"+
		"+,\7\u02c8\2\2,/\7\u00a9\2\2-/\7(\2\2.*\3\2\2\2.-\3\2\2\2/\n\3\2\2\2\60"+
		"\61\7\u00e4\2\2\61\62\7\u02c8\2\2\62\65\7\u00aa\2\2\63\65\7~\2\2\64\60"+
		"\3\2\2\2\64\63\3\2\2\2\65\f\3\2\2\2\66\67\7\u00e4\2\2\678\7\u2023\2\2"+
		"8;\7\u201b\2\29;\7@\2\2:\66\3\2\2\2:9\3\2\2\2;\16\3\2\2\2<=\7\u00e4\2"+
		"\2=>\7\u2023\2\2>B\7\u201f\2\2?@\7>\2\2@B\7@\2\2A<\3\2\2\2A?\3\2\2\2B"+
		"\20\3\2\2\2CD\4*+\2D\22\3\2\2\2EF\t\2\2\2F\24\3\2\2\2GH\7V\2\2HI\7t\2"+
		"\2IJ\7w\2\2JQ\7g\2\2KL\7H\2\2LM\7c\2\2MN\7n\2\2NO\7u\2\2OQ\7g\2\2PG\3"+
		"\2\2\2PK\3\2\2\2Q\26\3\2\2\2RT\t\3\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2U"+
		"V\3\2\2\2VW\3\2\2\2WX\b\f\2\2X\30\3\2\2\2YZ\7\61\2\2Z[\7\61\2\2[_\3\2"+
		"\2\2\\^\n\4\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3"+
		"\2\2\2bc\b\r\2\2c\32\3\2\2\2\f\2!(.\64:APU_\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}