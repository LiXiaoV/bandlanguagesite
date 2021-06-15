// Generated from /Users/xiaov/IdeaProjects/bandlanguagesite/bandlanguagesite-java/src/main/java/com/bandlanguage/bandlanguagesite/compilecore/papersanalysis/parser/Language.g4 by ANTLR 4.9.1
package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Paper=1, Abstract=2, Add=3, Me=4, Comma=5, Dot=6, Number=7, String=8, 
		Identifier=9, Ws=10, Comment=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Paper", "Abstract", "Add", "Me", "Comma", "Dot", "Number", "String", 
			"Identifier", "Ws", "Comment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\u8BBA\u6587'", "'\u6458\u8981'", "'\u6DFB\u52A0'", "'\u6211'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Paper", "Abstract", "Add", "Me", "Comma", "Dot", "Number", "String", 
			"Identifier", "Ws", "Comment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\rM\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\6\b*\n\b\r\b\16\b+\3\t\3\t\7\t\60\n\t\f\t\16\t\63\13\t\3\t\3\t"+
		"\3\n\6\n8\n\n\r\n\16\n9\3\13\6\13=\n\13\r\13\16\13>\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\7\fG\n\f\f\f\16\fJ\13\f\3\f\3\f\3\61\2\r\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\3\2\b\4\2..\uff0e\uff0e\4\2\60\60\u3004"+
		"\u3004\3\2\62;\b\2&&\62;C\\aac|\u4e02\u9fa7\5\2\13\f\17\17\"\"\4\2\f\f"+
		"\17\17\2Q\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\3\31\3\2\2\2\5\34\3\2\2\2\7\37\3\2\2\2\t\"\3\2\2\2\13$\3\2\2"+
		"\2\r&\3\2\2\2\17)\3\2\2\2\21-\3\2\2\2\23\67\3\2\2\2\25<\3\2\2\2\27B\3"+
		"\2\2\2\31\32\7\u8bbc\2\2\32\33\7\u6589\2\2\33\4\3\2\2\2\34\35\7\u645a"+
		"\2\2\35\36\7\u8983\2\2\36\6\3\2\2\2\37 \7\u6dfd\2\2 !\7\u52a2\2\2!\b\3"+
		"\2\2\2\"#\7\u6213\2\2#\n\3\2\2\2$%\t\2\2\2%\f\3\2\2\2&\'\t\3\2\2\'\16"+
		"\3\2\2\2(*\t\4\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\20\3\2\2\2"+
		"-\61\7\u201a\2\2.\60\13\2\2\2/.\3\2\2\2\60\63\3\2\2\2\61\62\3\2\2\2\61"+
		"/\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\u201b\2\2\65\22\3\2\2\2"+
		"\668\t\5\2\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:\24\3\2\2\2"+
		";=\t\6\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\b\13\2"+
		"\2A\26\3\2\2\2BC\7\61\2\2CD\7\61\2\2DH\3\2\2\2EG\n\7\2\2FE\3\2\2\2GJ\3"+
		"\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\b\f\3\2L\30\3\2\2\2\t"+
		"\2+\61\679>H\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}