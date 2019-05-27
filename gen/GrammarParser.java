// Generated from C:/Users/Thomas-PC/IdeaProjects/believe-revision\Grammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		QUANTIFIER=1, VARIABLE=2, NOT=3, AND=4, OR=5, IMPLIES=6, BICONDITION=7, 
		PARENTHESIS=8, BRACKET=9, PREDICATE=10, WHITESPACE=11, COMMENT=12;
	public static final int
		RULE_start = 0, RULE_sentence = 1, RULE_atomicSentence = 2;
	public static final String[] ruleNames = {
		"start", "sentence", "atomicSentence"
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

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public SentenceContext sentence;
		public List<SentenceContext> s = new ArrayList<SentenceContext>();
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VARIABLE) | (1L << NOT) | (1L << PARENTHESIS) | (1L << BRACKET) | (1L << PREDICATE))) != 0)) {
				{
				{
				setState(6);
				((StartContext)_localctx).sentence = sentence(0);
				((StartContext)_localctx).s.add(((StartContext)_localctx).sentence);
				}
				}
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(12);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
	 
		public SentenceContext() { }
		public void copyFrom(SentenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BracketContext extends SentenceContext {
		public List<TerminalNode> BRACKET() { return getTokens(GrammarParser.BRACKET); }
		public TerminalNode BRACKET(int i) {
			return getToken(GrammarParser.BRACKET, i);
		}
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public BracketContext(SentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends SentenceContext {
		public List<TerminalNode> PARENTHESIS() { return getTokens(GrammarParser.PARENTHESIS); }
		public TerminalNode PARENTHESIS(int i) {
			return getToken(GrammarParser.PARENTHESIS, i);
		}
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public ParenthesisContext(SentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends SentenceContext {
		public TerminalNode NOT() { return getToken(GrammarParser.NOT, 0); }
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public NotContext(SentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends SentenceContext {
		public SentenceContext s1;
		public SentenceContext s2;
		public TerminalNode OR() { return getToken(GrammarParser.OR, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public OrContext(SentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImpliesContext extends SentenceContext {
		public SentenceContext s1;
		public SentenceContext s2;
		public TerminalNode IMPLIES() { return getToken(GrammarParser.IMPLIES, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public ImpliesContext(SentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitImplies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitImplies(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends SentenceContext {
		public SentenceContext s1;
		public SentenceContext s2;
		public TerminalNode AND() { return getToken(GrammarParser.AND, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public AndContext(SentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfAndOnlyIfContext extends SentenceContext {
		public SentenceContext s1;
		public SentenceContext s2;
		public TerminalNode BICONDITION() { return getToken(GrammarParser.BICONDITION, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public IfAndOnlyIfContext(SentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIfAndOnlyIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIfAndOnlyIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIfAndOnlyIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomicContext extends SentenceContext {
		public AtomicSentenceContext atomicSentence() {
			return getRuleContext(AtomicSentenceContext.class,0);
		}
		public AtomicContext(SentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAtomic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAtomic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAtomic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		return sentence(0);
	}

	private SentenceContext sentence(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SentenceContext _localctx = new SentenceContext(_ctx, _parentState);
		SentenceContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_sentence, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
			case PREDICATE:
				{
				_localctx = new AtomicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(15);
				atomicSentence();
				}
				break;
			case PARENTHESIS:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16);
				match(PARENTHESIS);
				setState(17);
				sentence(0);
				setState(18);
				match(PARENTHESIS);
				}
				break;
			case BRACKET:
				{
				_localctx = new BracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(BRACKET);
				setState(21);
				sentence(0);
				setState(22);
				match(BRACKET);
				}
				break;
			case NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(NOT);
				setState(25);
				sentence(5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(40);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new SentenceContext(_parentctx, _parentState));
						((AndContext)_localctx).s1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_sentence);
						setState(28);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(29);
						match(AND);
						setState(30);
						((AndContext)_localctx).s2 = sentence(5);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new SentenceContext(_parentctx, _parentState));
						((OrContext)_localctx).s1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_sentence);
						setState(31);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(32);
						match(OR);
						setState(33);
						((OrContext)_localctx).s2 = sentence(4);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new SentenceContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).s1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_sentence);
						setState(34);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(35);
						match(IMPLIES);
						setState(36);
						((ImpliesContext)_localctx).s2 = sentence(3);
						}
						break;
					case 4:
						{
						_localctx = new IfAndOnlyIfContext(new SentenceContext(_parentctx, _parentState));
						((IfAndOnlyIfContext)_localctx).s1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_sentence);
						setState(37);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(38);
						match(BICONDITION);
						setState(39);
						((IfAndOnlyIfContext)_localctx).s2 = sentence(2);
						}
						break;
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomicSentenceContext extends ParserRuleContext {
		public AtomicSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicSentence; }
	 
		public AtomicSentenceContext() { }
		public void copyFrom(AtomicSentenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TermsContext extends AtomicSentenceContext {
		public Token x;
		public TerminalNode VARIABLE() { return getToken(GrammarParser.VARIABLE, 0); }
		public TermsContext(AtomicSentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PredicateContext extends AtomicSentenceContext {
		public TerminalNode PREDICATE() { return getToken(GrammarParser.PREDICATE, 0); }
		public PredicateContext(AtomicSentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicSentenceContext atomicSentence() throws RecognitionException {
		AtomicSentenceContext _localctx = new AtomicSentenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_atomicSentence);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PREDICATE:
				_localctx = new PredicateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(PREDICATE);
				}
				break;
			case VARIABLE:
				_localctx = new TermsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				((TermsContext)_localctx).x = match(VARIABLE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return sentence_sempred((SentenceContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean sentence_sempred(SentenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16\64\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\35\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\4\3\4\5\4\62\n\4\3\4\2\3"+
		"\4\5\2\4\6\2\2\29\2\13\3\2\2\2\4\34\3\2\2\2\6\61\3\2\2\2\b\n\5\4\3\2\t"+
		"\b\3\2\2\2\n\r\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\16\3\2\2\2\r\13\3\2"+
		"\2\2\16\17\7\2\2\3\17\3\3\2\2\2\20\21\b\3\1\2\21\35\5\6\4\2\22\23\7\n"+
		"\2\2\23\24\5\4\3\2\24\25\7\n\2\2\25\35\3\2\2\2\26\27\7\13\2\2\27\30\5"+
		"\4\3\2\30\31\7\13\2\2\31\35\3\2\2\2\32\33\7\5\2\2\33\35\5\4\3\7\34\20"+
		"\3\2\2\2\34\22\3\2\2\2\34\26\3\2\2\2\34\32\3\2\2\2\35,\3\2\2\2\36\37\f"+
		"\6\2\2\37 \7\6\2\2 +\5\4\3\7!\"\f\5\2\2\"#\7\7\2\2#+\5\4\3\6$%\f\4\2\2"+
		"%&\7\b\2\2&+\5\4\3\5\'(\f\3\2\2()\7\t\2\2)+\5\4\3\4*\36\3\2\2\2*!\3\2"+
		"\2\2*$\3\2\2\2*\'\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\5\3\2\2\2.,\3"+
		"\2\2\2/\62\7\f\2\2\60\62\7\4\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\7\3\2\2"+
		"\2\7\13\34*,\61";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}