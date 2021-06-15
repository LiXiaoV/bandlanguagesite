package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.parser;// Generated from BL.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Show=2, Execute=3, Get=4, Find=5, Remove=6, Qiu=7, Set=8, Count=9, 
		CarryOut=10, SortAscending=11, SortDescending=12, Group=13, Change=14, 
		New=15, Rename=16, Merge=17, Equals=18, MoreThan=19, LessThan=20, NoEquals=21, 
		NoMoreThan=22, NoLessThan=23, InputPart=24, OutputPart=25, Element=26, 
		Amount=27, Data=28, Max=29, Min=30, Average=31, Today=32, Ge=33, Old=34, 
		De=35, Among=36, In=37, Jiang=38, According=39, At=40, AsParam=41, Comma=42, 
		Dot=43, Split=44, Mark=45, Number=46, Str=47, ObjName=48, Ws=49, Comment=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "Show", "Execute", "Get", "Find", "Remove", "Qiu", "Set", "Count", 
			"CarryOut", "SortAscending", "SortDescending", "Group", "Change", "New", 
			"Rename", "Merge", "Equals", "MoreThan", "LessThan", "NoEquals", "NoMoreThan", 
			"NoLessThan", "InputPart", "OutputPart", "Element", "Amount", "Data", 
			"Max", "Min", "Average", "Today", "Ge", "Old", "De", "Among", "In", "Jiang", 
			"According", "At", "AsParam", "Comma", "Dot", "Split", "Mark", "Number", 
			"Str", "ObjName", "Ws", "Comment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'\u663E\u793A'", "'\u6267\u884C'", "'\u5F97\u5230'", "'\u627E\u51FA'", 
			"'\u53BB\u6389'", "'\u6C42'", "'\u8BBE\u5B9A'", "'\u7EDF\u8BA1'", "'\u8FDB\u884C'", 
			"'\u5347\u5E8F\u6392\u5E8F'", "'\u964D\u5E8F\u6392\u5E8F'", "'\u8FDB\u884C\u5206\u7EC4'", 
			"'\u6539\u6210'", "'\u65B0\u5EFA'", "'\u91CD\u547D\u540D\u4E3A'", "'\u5408\u5E76\u6210\u4E3A'", 
			"'\u7B49\u4E8E'", null, null, null, null, null, "'\u8F93\u5165\u90E8\u4EF6'", 
			"'\u8F93\u51FA\u90E8\u4EF6'", null, "'\u6570\u91CF'", "'\u6570\u636E'", 
			"'\u6700\u5927\u503C'", "'\u6700\u5C0F\u503C'", "'\u5E73\u5747\u503C'", 
			"'\u4ECA\u5929'", "'\u4E2A'", "'\u8001\u7684'", "'\u7684'", "'\u5176\u4E2D'", 
			"'\u4E2D'", null, null, "'\u5728'", "'\u4F5C\u4E3A\u53C2\u6570'", null, 
			null, "'\u3001'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Show", "Execute", "Get", "Find", "Remove", "Qiu", "Set", 
			"Count", "CarryOut", "SortAscending", "SortDescending", "Group", "Change", 
			"New", "Rename", "Merge", "Equals", "MoreThan", "LessThan", "NoEquals", 
			"NoMoreThan", "NoLessThan", "InputPart", "OutputPart", "Element", "Amount", 
			"Data", "Max", "Min", "Average", "Today", "Ge", "Old", "De", "Among", 
			"In", "Jiang", "According", "At", "AsParam", "Comma", "Dot", "Split", 
			"Mark", "Number", "Str", "ObjName", "Ws", "Comment"
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


	public BLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BL.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0130\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\5\24\u00a9\n\24\3\25\3\25\3\25\5\25\u00ae\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u00b5\n\26\3\27\3\27\3\27\3\27\3\27\5\27\u00bc\n\27\3"+
		"\30\3\30\3\30\3\30\3\30\5\30\u00c3\n\30\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\5\33\u00d3\n\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		"!\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\5(\u00fc"+
		"\n(\3)\3)\3*\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\6/\u010e\n/\r/\16"+
		"/\u010f\3\60\3\60\6\60\u0114\n\60\r\60\16\60\u0115\3\60\3\60\3\61\6\61"+
		"\u011b\n\61\r\61\16\61\u011c\3\62\6\62\u0120\n\62\r\62\16\62\u0121\3\62"+
		"\3\62\3\63\3\63\3\63\3\63\7\63\u012a\n\63\f\63\16\63\u012d\13\63\3\63"+
		"\3\63\2\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64\3"+
		"\2\n\4\2\u5c08\u5c08\u628c\u628c\4\2..\uff0e\uff0e\4\2\60\60\u3004\u3004"+
		"\4\2AA\uff21\uff21\3\2\62;\b\2&&\62;C\\aac|\u4e02\u9fa7\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\2\u013b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3g\3\2\2\2\5i\3\2"+
		"\2\2\7l\3\2\2\2\to\3\2\2\2\13r\3\2\2\2\ru\3\2\2\2\17x\3\2\2\2\21z\3\2"+
		"\2\2\23}\3\2\2\2\25\u0080\3\2\2\2\27\u0083\3\2\2\2\31\u0088\3\2\2\2\33"+
		"\u008d\3\2\2\2\35\u0092\3\2\2\2\37\u0095\3\2\2\2!\u0098\3\2\2\2#\u009d"+
		"\3\2\2\2%\u00a2\3\2\2\2\'\u00a8\3\2\2\2)\u00ad\3\2\2\2+\u00b4\3\2\2\2"+
		"-\u00bb\3\2\2\2/\u00c2\3\2\2\2\61\u00c4\3\2\2\2\63\u00c9\3\2\2\2\65\u00d2"+
		"\3\2\2\2\67\u00d4\3\2\2\29\u00d7\3\2\2\2;\u00da\3\2\2\2=\u00de\3\2\2\2"+
		"?\u00e2\3\2\2\2A\u00e6\3\2\2\2C\u00e9\3\2\2\2E\u00eb\3\2\2\2G\u00ee\3"+
		"\2\2\2I\u00f0\3\2\2\2K\u00f3\3\2\2\2M\u00f5\3\2\2\2O\u00fb\3\2\2\2Q\u00fd"+
		"\3\2\2\2S\u00ff\3\2\2\2U\u0104\3\2\2\2W\u0106\3\2\2\2Y\u0108\3\2\2\2["+
		"\u010a\3\2\2\2]\u010d\3\2\2\2_\u0111\3\2\2\2a\u011a\3\2\2\2c\u011f\3\2"+
		"\2\2e\u0125\3\2\2\2gh\7?\2\2h\4\3\2\2\2ij\7\u6640\2\2jk\7\u793c\2\2k\6"+
		"\3\2\2\2lm\7\u6269\2\2mn\7\u884e\2\2n\b\3\2\2\2op\7\u5f99\2\2pq\7\u5232"+
		"\2\2q\n\3\2\2\2rs\7\u6280\2\2st\7\u51fc\2\2t\f\3\2\2\2uv\7\u53bd\2\2v"+
		"w\7\u638b\2\2w\16\3\2\2\2xy\7\u6c44\2\2y\20\3\2\2\2z{\7\u8bc0\2\2{|\7"+
		"\u5b9c\2\2|\22\3\2\2\2}~\7\u7ee1\2\2~\177\7\u8ba3\2\2\177\24\3\2\2\2\u0080"+
		"\u0081\7\u8fdd\2\2\u0081\u0082\7\u884e\2\2\u0082\26\3\2\2\2\u0083\u0084"+
		"\7\u5349\2\2\u0084\u0085\7\u5e91\2\2\u0085\u0086\7\u6394\2\2\u0086\u0087"+
		"\7\u5e91\2\2\u0087\30\3\2\2\2\u0088\u0089\7\u964f\2\2\u0089\u008a\7\u5e91"+
		"\2\2\u008a\u008b\7\u6394\2\2\u008b\u008c\7\u5e91\2\2\u008c\32\3\2\2\2"+
		"\u008d\u008e\7\u8fdd\2\2\u008e\u008f\7\u884e\2\2\u008f\u0090\7\u5208\2"+
		"\2\u0090\u0091\7\u7ec6\2\2\u0091\34\3\2\2\2\u0092\u0093\7\u653b\2\2\u0093"+
		"\u0094\7\u6212\2\2\u0094\36\3\2\2\2\u0095\u0096\7\u65b2\2\2\u0096\u0097"+
		"\7\u5efc\2\2\u0097 \3\2\2\2\u0098\u0099\7\u91cf\2\2\u0099\u009a\7\u547f"+
		"\2\2\u009a\u009b\7\u540f\2\2\u009b\u009c\7\u4e3c\2\2\u009c\"\3\2\2\2\u009d"+
		"\u009e\7\u540a\2\2\u009e\u009f\7\u5e78\2\2\u009f\u00a0\7\u6212\2\2\u00a0"+
		"\u00a1\7\u4e3c\2\2\u00a1$\3\2\2\2\u00a2\u00a3\7\u7b4b\2\2\u00a3\u00a4"+
		"\7\u4e90\2\2\u00a4&\3\2\2\2\u00a5\u00a6\7\u5929\2\2\u00a6\u00a9\7\u4e90"+
		"\2\2\u00a7\u00a9\7@\2\2\u00a8\u00a5\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"(\3\2\2\2\u00aa\u00ab\7\u5c11\2\2\u00ab\u00ae\7\u4e90\2\2\u00ac\u00ae"+
		"\7>\2\2\u00ad\u00aa\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae*\3\2\2\2\u00af\u00b0"+
		"\7\u4e0f\2\2\u00b0\u00b1\7\u7b4b\2\2\u00b1\u00b5\7\u4e90\2\2\u00b2\u00b3"+
		"\7#\2\2\u00b3\u00b5\7?\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		",\3\2\2\2\u00b6\u00b7\7\u4e0f\2\2\u00b7\u00b8\7\u5929\2\2\u00b8\u00bc"+
		"\7\u4e90\2\2\u00b9\u00ba\7>\2\2\u00ba\u00bc\7?\2\2\u00bb\u00b6\3\2\2\2"+
		"\u00bb\u00b9\3\2\2\2\u00bc.\3\2\2\2\u00bd\u00be\7\u4e0f\2\2\u00be\u00bf"+
		"\7\u5c11\2\2\u00bf\u00c3\7\u4e90\2\2\u00c0\u00c1\7@\2\2\u00c1\u00c3\7"+
		"?\2\2\u00c2\u00bd\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\60\3\2\2\2\u00c4\u00c5"+
		"\7\u8f95\2\2\u00c5\u00c6\7\u5167\2\2\u00c6\u00c7\7\u90ea\2\2\u00c7\u00c8"+
		"\7\u4ef8\2\2\u00c8\62\3\2\2\2\u00c9\u00ca\7\u8f95\2\2\u00ca\u00cb\7\u51fc"+
		"\2\2\u00cb\u00cc\7\u90ea\2\2\u00cc\u00cd\7\u4ef8\2\2\u00cd\64\3\2\2\2"+
		"\u00ce\u00cf\7\u5145\2\2\u00cf\u00d3\7\u7d22\2\2\u00d0\u00d1\7\u8bb2\2"+
		"\2\u00d1\u00d3\7\u5f57\2\2\u00d2\u00ce\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3"+
		"\66\3\2\2\2\u00d4\u00d5\7\u6572\2\2\u00d5\u00d6\7\u91d1\2\2\u00d68\3\2"+
		"\2\2\u00d7\u00d8\7\u6572\2\2\u00d8\u00d9\7\u6370\2\2\u00d9:\3\2\2\2\u00da"+
		"\u00db\7\u6702\2\2\u00db\u00dc\7\u5929\2\2\u00dc\u00dd\7\u503e\2\2\u00dd"+
		"<\3\2\2\2\u00de\u00df\7\u6702\2\2\u00df\u00e0\7\u5c11\2\2\u00e0\u00e1"+
		"\7\u503e\2\2\u00e1>\3\2\2\2\u00e2\u00e3\7\u5e75\2\2\u00e3\u00e4\7\u5749"+
		"\2\2\u00e4\u00e5\7\u503e\2\2\u00e5@\3\2\2\2\u00e6\u00e7\7\u4ecc\2\2\u00e7"+
		"\u00e8\7\u592b\2\2\u00e8B\3\2\2\2\u00e9\u00ea\7\u4e2c\2\2\u00eaD\3\2\2"+
		"\2\u00eb\u00ec\7\u8003\2\2\u00ec\u00ed\7\u7686\2\2\u00edF\3\2\2\2\u00ee"+
		"\u00ef\7\u7686\2\2\u00efH\3\2\2\2\u00f0\u00f1\7\u5178\2\2\u00f1\u00f2"+
		"\7\u4e2f\2\2\u00f2J\3\2\2\2\u00f3\u00f4\7\u4e2f\2\2\u00f4L\3\2\2\2\u00f5"+
		"\u00f6\t\2\2\2\u00f6N\3\2\2\2\u00f7\u00f8\7\u683b\2\2\u00f8\u00fc\7\u6370"+
		"\2\2\u00f9\u00fa\7\u630b\2\2\u00fa\u00fc\7\u7169\2\2\u00fb\u00f7\3\2\2"+
		"\2\u00fb\u00f9\3\2\2\2\u00fcP\3\2\2\2\u00fd\u00fe\7\u572a\2\2\u00feR\3"+
		"\2\2\2\u00ff\u0100\7\u4f5e\2\2\u0100\u0101\7\u4e3c\2\2\u0101\u0102\7\u53c4"+
		"\2\2\u0102\u0103\7\u6572\2\2\u0103T\3\2\2\2\u0104\u0105\t\3\2\2\u0105"+
		"V\3\2\2\2\u0106\u0107\t\4\2\2\u0107X\3\2\2\2\u0108\u0109\7\u3003\2\2\u0109"+
		"Z\3\2\2\2\u010a\u010b\t\5\2\2\u010b\\\3\2\2\2\u010c\u010e\t\6\2\2\u010d"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110^\3\2\2\2\u0111\u0113\7\u201a\2\2\u0112\u0114\t\7\2\2\u0113"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0118\7\u201b\2\2\u0118`\3\2\2\2\u0119"+
		"\u011b\t\7\2\2\u011a\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011db\3\2\2\2\u011e\u0120\t\b\2\2\u011f\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0124\b\62\2\2\u0124d\3\2\2\2\u0125\u0126\7\61\2"+
		"\2\u0126\u0127\7\61\2\2\u0127\u012b\3\2\2\2\u0128\u012a\n\t\2\2\u0129"+
		"\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\b\63\3\2\u012f"+
		"f\3\2\2\2\21\2\u00a8\u00ad\u00b4\u00bb\u00c2\u00d2\u00fb\u010f\u0113\u0115"+
		"\u011a\u011c\u0121\u012b\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}