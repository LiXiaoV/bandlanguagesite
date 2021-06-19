// Generated from /Users/xiaov/IdeaProjects/bandlanguagesite/bandlanguagesite-java/src/main/java/com/bandlanguage/bandlanguagesite/compilecore/organizationmanage/parser/Language.g4 by ANTLR 4.9.1
package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Organization=1, Department=2, ParentDepartment=3, SuperiorDepartment=4, 
		SubDepartment=5, Band=6, ParentBand=7, SubBand=8, Position=9, Member=10, 
		Tool=11, Role=12, Authority=13, Reader=14, Writer=15, Speaker=16, Worker=17, 
		Administrator=18, Drama=19, File=20, Chatroom=21, MaxAuthority=22, MinAuthority=23, 
		Deadline=24, NewStaff=25, SeniorStaff=26, Show=27, Establish=28, Join=29, 
		Revoke=30, Set=31, Change=32, Edit=33, Delete=34, Merge=35, Move=36, Appoint=37, 
		Relieve=38, Grant=39, Disable=40, Enable=41, SendMsg=42, Accept=43, Dispatch=44, 
		Publish=45, CancelPub=46, Exist=47, NotExist=48, Appear=49, Have=50, Incumbent=51, 
		Leaved=52, Me=53, At=54, Make=55, From=56, Quantifier=57, TimeUnit=58, 
		MoreThan=59, LessThan=60, Equals=61, And=62, Or=63, Inside=64, With=65, 
		Of=66, If=67, Then=68, Concurrent=69, Else=70, Comma=71, Dot=72, Number=73, 
		String=74, Identifier=75, Ws=76, Comment=77;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Organization", "Department", "ParentDepartment", "SuperiorDepartment", 
			"SubDepartment", "Band", "ParentBand", "SubBand", "Position", "Member", 
			"Tool", "Role", "Authority", "Reader", "Writer", "Speaker", "Worker", 
			"Administrator", "Drama", "File", "Chatroom", "MaxAuthority", "MinAuthority", 
			"Deadline", "NewStaff", "SeniorStaff", "Show", "Establish", "Join", "Revoke", 
			"Set", "Change", "Edit", "Delete", "Merge", "Move", "Appoint", "Relieve", 
			"Grant", "Disable", "Enable", "SendMsg", "Accept", "Dispatch", "Publish", 
			"CancelPub", "Exist", "NotExist", "Appear", "Have", "Incumbent", "Leaved", 
			"Me", "At", "Make", "From", "Quantifier", "TimeUnit", "MoreThan", "LessThan", 
			"Equals", "And", "Or", "Inside", "With", "Of", "If", "Then", "Concurrent", 
			"Else", "Comma", "Dot", "Number", "String", "Identifier", "Ws", "Comment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\u673A\u6784'", "'\u90E8\u95E8'", "'\u7236\u90E8\u95E8'", "'\u4E0A\u7EA7\u90E8\u95E8'", 
			null, "'\u5E2E\u533A'", "'\u7236\u5E2E\u533A'", "'\u5B50\u5E2E\u533A'", 
			"'\u5C97\u4F4D'", "'\u6210\u5458'", "'\u5DE5\u5177'", "'\u89D2\u8272'", 
			"'\u6743\u9650'", "'\u8BFB\u8005'", "'\u5199\u8005'", "'\u8A00\u8005'", 
			"'\u5DE5\u8005'", "'\u7BA1\u7406\u5458'", "'\u5267\u672C'", "'\u6587\u6863'", 
			"'\u6D88\u606F\u677F'", null, null, null, "'\u65B0\u5458\u5DE5'", "'\u8001\u5458\u5DE5'", 
			null, null, null, null, "'\u8BBE\u5B9A'", null, null, null, null, null, 
			null, "'\u514D\u9664'", "'\u6388\u4E88'", "'\u505C\u7528'", "'\u542F\u7528'", 
			null, null, null, null, "'\u53D6\u6D88\u53D1\u5E03'", "'\u5B58\u5728'", 
			"'\u4E0D\u5B58\u5728'", null, null, "'\u5728\u804C\u7684'", "'\u79BB\u804C\u7684'", 
			"'\u6211'", null, null, "'\u4ECE'", null, null, null, null, "'\u7B49\u4E8E'", 
			"'\u4E14'", "'\u6216'", null, "'\u548C'", "'\u7684'", null, null, null, 
			"'\u5426\u5219'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Organization", "Department", "ParentDepartment", "SuperiorDepartment", 
			"SubDepartment", "Band", "ParentBand", "SubBand", "Position", "Member", 
			"Tool", "Role", "Authority", "Reader", "Writer", "Speaker", "Worker", 
			"Administrator", "Drama", "File", "Chatroom", "MaxAuthority", "MinAuthority", 
			"Deadline", "NewStaff", "SeniorStaff", "Show", "Establish", "Join", "Revoke", 
			"Set", "Change", "Edit", "Delete", "Merge", "Move", "Appoint", "Relieve", 
			"Grant", "Disable", "Enable", "SendMsg", "Accept", "Dispatch", "Publish", 
			"CancelPub", "Exist", "NotExist", "Appear", "Have", "Incumbent", "Leaved", 
			"Me", "At", "Make", "From", "Quantifier", "TimeUnit", "MoreThan", "LessThan", 
			"Equals", "And", "Or", "Inside", "With", "Of", "If", "Then", "Concurrent", 
			"Else", "Comma", "Dot", "Number", "String", "Identifier", "Ws", "Comment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2O\u0222\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00b4\n\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5"+
		"\27\u00f2\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00fc\n\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0105\n\31\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0115\n\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u011d\n\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u012b\n\36\3\37\3\37\3\37\3\37\3\37"+
		"\5\37\u0132\n\37\3 \3 \3 \3!\3!\3!\3!\3!\5!\u013c\n!\3\"\3\"\3\"\3\"\3"+
		"\"\5\"\u0143\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u014f\n#\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\5$\u0159\n$\3%\3%\3%\3%\3%\5%\u0160\n%\3&\3&\3&\3&\5&\u0166"+
		"\n&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\5+\u0179\n+"+
		"\3,\3,\3,\3,\5,\u017f\n,\3-\3-\3-\3-\3-\3-\5-\u0187\n-\3.\3.\3.\3.\3."+
		"\3.\3.\3.\5.\u0191\n.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u01a8\n\62\3\63\3\63"+
		"\3\63\3\63\3\63\5\63\u01af\n\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3;\3;\3;\5;\u01c8\n;\3<\3"+
		"<\3<\3<\3<\3<\5<\u01d0\n<\3=\3=\3=\3=\3=\3=\5=\u01d8\n=\3>\3>\3>\3?\3"+
		"?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3D\3D\5D\u01eb\nD\3E\3E\3E\5E\u01f0\n"+
		"E\3F\3F\3F\5F\u01f5\nF\3G\3G\3G\3H\3H\3I\3I\3J\6J\u01ff\nJ\rJ\16J\u0200"+
		"\3K\3K\7K\u0205\nK\fK\16K\u0208\13K\3K\3K\3L\6L\u020d\nL\rL\16L\u020e"+
		"\3M\6M\u0212\nM\rM\16M\u0213\3M\3M\3N\3N\3N\3N\7N\u021c\nN\fN\16N\u021f"+
		"\13N\3N\3N\3\u0206\2O\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089"+
		"F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\3\2\r"+
		"\4\2\u4e90\u4e90\u572a\u572a\7\2\u4e3c\u4e3c\u5bfb\u5bfb\u5c08\u5c08\u628c"+
		"\u628c\u7edb\u7edb\5\2\u4e2c\u4e2c\u6763\u6763\u6b23\u6b23\5\2\u592b\u592b"+
		"\u5e76\u5e76\u670a\u670a\5\2\u4e2f\u4e2f\u5187\u5187\u91ce\u91ce\4\2."+
		".\uff0e\uff0e\4\2\60\60\u3004\u3004\3\2\62;\b\2&&\62;C\\aac|\u4e02\u9fa7"+
		"\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u024c\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s"+
		"\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\3\u009d\3\2\2\2\5\u00a0\3\2\2\2\7\u00a3\3\2\2\2\t\u00a7"+
		"\3\2\2\2\13\u00b3\3\2\2\2\r\u00b5\3\2\2\2\17\u00b8\3\2\2\2\21\u00bc\3"+
		"\2\2\2\23\u00c0\3\2\2\2\25\u00c3\3\2\2\2\27\u00c6\3\2\2\2\31\u00c9\3\2"+
		"\2\2\33\u00cc\3\2\2\2\35\u00cf\3\2\2\2\37\u00d2\3\2\2\2!\u00d5\3\2\2\2"+
		"#\u00d8\3\2\2\2%\u00db\3\2\2\2\'\u00df\3\2\2\2)\u00e2\3\2\2\2+\u00e5\3"+
		"\2\2\2-\u00f1\3\2\2\2/\u00fb\3\2\2\2\61\u0104\3\2\2\2\63\u0106\3\2\2\2"+
		"\65\u010a\3\2\2\2\67\u0114\3\2\2\29\u011c\3\2\2\2;\u012a\3\2\2\2=\u0131"+
		"\3\2\2\2?\u0133\3\2\2\2A\u013b\3\2\2\2C\u0142\3\2\2\2E\u014e\3\2\2\2G"+
		"\u0158\3\2\2\2I\u015f\3\2\2\2K\u0165\3\2\2\2M\u0167\3\2\2\2O\u016a\3\2"+
		"\2\2Q\u016d\3\2\2\2S\u0170\3\2\2\2U\u0178\3\2\2\2W\u017e\3\2\2\2Y\u0186"+
		"\3\2\2\2[\u0190\3\2\2\2]\u0192\3\2\2\2_\u0197\3\2\2\2a\u019a\3\2\2\2c"+
		"\u01a7\3\2\2\2e\u01ae\3\2\2\2g\u01b0\3\2\2\2i\u01b4\3\2\2\2k\u01b8\3\2"+
		"\2\2m\u01ba\3\2\2\2o\u01bc\3\2\2\2q\u01be\3\2\2\2s\u01c0\3\2\2\2u\u01c7"+
		"\3\2\2\2w\u01cf\3\2\2\2y\u01d7\3\2\2\2{\u01d9\3\2\2\2}\u01dc\3\2\2\2\177"+
		"\u01de\3\2\2\2\u0081\u01e0\3\2\2\2\u0083\u01e2\3\2\2\2\u0085\u01e4\3\2"+
		"\2\2\u0087\u01ea\3\2\2\2\u0089\u01ef\3\2\2\2\u008b\u01f4\3\2\2\2\u008d"+
		"\u01f6\3\2\2\2\u008f\u01f9\3\2\2\2\u0091\u01fb\3\2\2\2\u0093\u01fe\3\2"+
		"\2\2\u0095\u0202\3\2\2\2\u0097\u020c\3\2\2\2\u0099\u0211\3\2\2\2\u009b"+
		"\u0217\3\2\2\2\u009d\u009e\7\u673c\2\2\u009e\u009f\7\u6786\2\2\u009f\4"+
		"\3\2\2\2\u00a0\u00a1\7\u90ea\2\2\u00a1\u00a2\7\u95ea\2\2\u00a2\6\3\2\2"+
		"\2\u00a3\u00a4\7\u7238\2\2\u00a4\u00a5\7\u90ea\2\2\u00a5\u00a6\7\u95ea"+
		"\2\2\u00a6\b\3\2\2\2\u00a7\u00a8\7\u4e0c\2\2\u00a8\u00a9\7\u7ea9\2\2\u00a9"+
		"\u00aa\7\u90ea\2\2\u00aa\u00ab\7\u95ea\2\2\u00ab\n\3\2\2\2\u00ac\u00ad"+
		"\7\u5b52\2\2\u00ad\u00ae\7\u90ea\2\2\u00ae\u00b4\7\u95ea\2\2\u00af\u00b0"+
		"\7\u4e0d\2\2\u00b0\u00b1\7\u7ea9\2\2\u00b1\u00b2\7\u90ea\2\2\u00b2\u00b4"+
		"\7\u95ea\2\2\u00b3\u00ac\3\2\2\2\u00b3\u00af\3\2\2\2\u00b4\f\3\2\2\2\u00b5"+
		"\u00b6\7\u5e30\2\2\u00b6\u00b7\7\u533c\2\2\u00b7\16\3\2\2\2\u00b8\u00b9"+
		"\7\u7238\2\2\u00b9\u00ba\7\u5e30\2\2\u00ba\u00bb\7\u533c\2\2\u00bb\20"+
		"\3\2\2\2\u00bc\u00bd\7\u5b52\2\2\u00bd\u00be\7\u5e30\2\2\u00be\u00bf\7"+
		"\u533c\2\2\u00bf\22\3\2\2\2\u00c0\u00c1\7\u5c99\2\2\u00c1\u00c2\7\u4f4f"+
		"\2\2\u00c2\24\3\2\2\2\u00c3\u00c4\7\u6212\2\2\u00c4\u00c5\7\u545a\2\2"+
		"\u00c5\26\3\2\2\2\u00c6\u00c7\7\u5de7\2\2\u00c7\u00c8\7\u5179\2\2\u00c8"+
		"\30\3\2\2\2\u00c9\u00ca\7\u89d4\2\2\u00ca\u00cb\7\u8274\2\2\u00cb\32\3"+
		"\2\2\2\u00cc\u00cd\7\u6745\2\2\u00cd\u00ce\7\u9652\2\2\u00ce\34\3\2\2"+
		"\2\u00cf\u00d0\7\u8bfd\2\2\u00d0\u00d1\7\u8007\2\2\u00d1\36\3\2\2\2\u00d2"+
		"\u00d3\7\u519b\2\2\u00d3\u00d4\7\u8007\2\2\u00d4 \3\2\2\2\u00d5\u00d6"+
		"\7\u8a02\2\2\u00d6\u00d7\7\u8007\2\2\u00d7\"\3\2\2\2\u00d8\u00d9\7\u5de7"+
		"\2\2\u00d9\u00da\7\u8007\2\2\u00da$\3\2\2\2\u00db\u00dc\7\u7ba3\2\2\u00dc"+
		"\u00dd\7\u7408\2\2\u00dd\u00de\7\u545a\2\2\u00de&\3\2\2\2\u00df\u00e0"+
		"\7\u5269\2\2\u00e0\u00e1\7\u672e\2\2\u00e1(\3\2\2\2\u00e2\u00e3\7\u6589"+
		"\2\2\u00e3\u00e4\7\u6865\2\2\u00e4*\3\2\2\2\u00e5\u00e6\7\u6d8a\2\2\u00e6"+
		"\u00e7\7\u6071\2\2\u00e7\u00e8\7\u6781\2\2\u00e8,\3\2\2\2\u00e9\u00ea"+
		"\7\u6702\2\2\u00ea\u00eb\7\u9ada\2\2\u00eb\u00ec\7\u6745\2\2\u00ec\u00f2"+
		"\7\u9652\2\2\u00ed\u00ee\7\u6702\2\2\u00ee\u00ef\7\u5929\2\2\u00ef\u00f0"+
		"\7\u6745\2\2\u00f0\u00f2\7\u9652\2\2\u00f1\u00e9\3\2\2\2\u00f1\u00ed\3"+
		"\2\2\2\u00f2.\3\2\2\2\u00f3\u00f4\7\u6702\2\2\u00f4\u00f5\7\u5c11\2\2"+
		"\u00f5\u00f6\7\u6745\2\2\u00f6\u00fc\7\u9652\2\2\u00f7\u00f8\7\u6702\2"+
		"\2\u00f8\u00f9\7\u4f50\2\2\u00f9\u00fa\7\u6745\2\2\u00fa\u00fc\7\u9652"+
		"\2\2\u00fb\u00f3\3\2\2\2\u00fb\u00f7\3\2\2\2\u00fc\60\3\2\2\2\u00fd\u00fe"+
		"\7\u670b\2\2\u00fe\u00ff\7\u654a\2\2\u00ff\u0105\7\u6721\2\2\u0100\u0101"+
		"\7\u670b\2\2\u0101\u0102\7\u654a\2\2\u0102\u0103\7\u65f8\2\2\u0103\u0105"+
		"\7\u9581\2\2\u0104\u00fd\3\2\2\2\u0104\u0100\3\2\2\2\u0105\62\3\2\2\2"+
		"\u0106\u0107\7\u65b2\2\2\u0107\u0108\7\u545a\2\2\u0108\u0109\7\u5de7\2"+
		"\2\u0109\64\3\2\2\2\u010a\u010b\7\u8003\2\2\u010b\u010c\7\u545a\2\2\u010c"+
		"\u010d\7\u5de7\2\2\u010d\66\3\2\2\2\u010e\u010f\7\u6640\2\2\u010f\u0115"+
		"\7\u793c\2\2\u0110\u0111\7\u5219\2\2\u0111\u0115\7\u51fc\2\2\u0112\u0113"+
		"\7\u67e7\2\2\u0113\u0115\7\u770d\2\2\u0114\u010e\3\2\2\2\u0114\u0110\3"+
		"\2\2\2\u0114\u0112\3\2\2\2\u01158\3\2\2\2\u0116\u0117\7\u521d\2\2\u0117"+
		"\u011d\7\u5efc\2\2\u0118\u0119\7\u65b2\2\2\u0119\u011d\7\u5efc\2\2\u011a"+
		"\u011b\7\u65b2\2\2\u011b\u011d\7\u58a0\2\2\u011c\u0116\3\2\2\2\u011c\u0118"+
		"\3\2\2\2\u011c\u011a\3\2\2\2\u011d:\3\2\2\2\u011e\u011f\7\u6dfd\2\2\u011f"+
		"\u012b\7\u52a2\2\2\u0120\u0121\7\u52a2\2\2\u0121\u012b\7\u5167\2\2\u0122"+
		"\u0123\7\u52a2\2\2\u0123\u0124\7\u5167\2\2\u0124\u012b\7\u5232\2\2\u0125"+
		"\u0126\7\u62cb\2\2\u0126\u012b\7\u5167\2\2\u0127\u0128\7\u62cb\2\2\u0128"+
		"\u0129\7\u5167\2\2\u0129\u012b\7\u5232\2\2\u012a\u011e\3\2\2\2\u012a\u0120"+
		"\3\2\2\2\u012a\u0122\3\2\2\2\u012a\u0125\3\2\2\2\u012a\u0127\3\2\2\2\u012b"+
		"<\3\2\2\2\u012c\u012d\7\u64a6\2\2\u012d\u0132\7\u6d8a\2\2\u012e\u012f"+
		"\7\u64a6\2\2\u012f\u0130\7\u6d8a\2\2\u0130\u0132\7\u638b\2\2\u0131\u012c"+
		"\3\2\2\2\u0131\u012e\3\2\2\2\u0132>\3\2\2\2\u0133\u0134\7\u8bc0\2\2\u0134"+
		"\u0135\7\u5b9c\2\2\u0135@\3\2\2\2\u0136\u0137\7\u66f6\2\2\u0137\u013c"+
		"\7\u6364\2\2\u0138\u0139\7\u66f6\2\2\u0139\u013a\7\u6364\2\2\u013a\u013c"+
		"\7\u5232\2\2\u013b\u0136\3\2\2\2\u013b\u0138\3\2\2\2\u013cB\3\2\2\2\u013d"+
		"\u013e\7\u4ff0\2\2\u013e\u0143\7\u653b\2\2\u013f\u0140\7\u4ff0\2\2\u0140"+
		"\u0141\7\u653b\2\2\u0141\u0143\7\u4e3c\2\2\u0142\u013d\3\2\2\2\u0142\u013f"+
		"\3\2\2\2\u0143D\3\2\2\2\u0144\u0145\7\u79fd\2\2\u0145\u014f\7\u9666\2"+
		"\2\u0146\u0147\7\u5222\2\2\u0147\u014f\7\u9666\2\2\u0148\u0149\7\u5256"+
		"\2\2\u0149\u014f\7\u9666\2\2\u014a\u014b\7\u53bd\2\2\u014b\u014f\7\u9666"+
		"\2\2\u014c\u014d\7\u5222\2\2\u014d\u014f\7\u638b\2\2\u014e\u0144\3\2\2"+
		"\2\u014e\u0146\3\2\2\2\u014e\u0148\3\2\2\2\u014e\u014a\3\2\2\2\u014e\u014c"+
		"\3\2\2\2\u014fF\3\2\2\2\u0150\u0151\7\u540a\2\2\u0151\u0159\7\u5e78\2"+
		"\2\u0152\u0153\7\u540a\2\2\u0153\u0154\7\u5e78\2\2\u0154\u0159\7\u4e3c"+
		"\2\2\u0155\u0156\7\u540a\2\2\u0156\u0157\7\u5e78\2\2\u0157\u0159\7\u5232"+
		"\2\2\u0158\u0150\3\2\2\2\u0158\u0152\3\2\2\2\u0158\u0155\3\2\2\2\u0159"+
		"H\3\2\2\2\u015a\u015b\7\u79fd\2\2\u015b\u0160\7\u52aa\2\2\u015c\u015d"+
		"\7\u79fd\2\2\u015d\u015e\7\u52aa\2\2\u015e\u0160\7\u5232\2\2\u015f\u015a"+
		"\3\2\2\2\u015f\u015c\3\2\2\2\u0160J\3\2\2\2\u0161\u0162\7\u4efd\2\2\u0162"+
		"\u0166\7\u547f\2\2\u0163\u0164\7\u5b8b\2\2\u0164\u0166\7\u6394\2\2\u0165"+
		"\u0161\3\2\2\2\u0165\u0163\3\2\2\2\u0166L\3\2\2\2\u0167\u0168\7\u514f"+
		"\2\2\u0168\u0169\7\u9666\2\2\u0169N\3\2\2\2\u016a\u016b\7\u638a\2\2\u016b"+
		"\u016c\7\u4e8a\2\2\u016cP\3\2\2\2\u016d\u016e\7\u505e\2\2\u016e\u016f"+
		"\7\u752a\2\2\u016fR\3\2\2\2\u0170\u0171\7\u5431\2\2\u0171\u0172\7\u752a"+
		"\2\2\u0172T\3\2\2\2\u0173\u0174\7\u53d3\2\2\u0174\u0175\7\u6d8a\2\2\u0175"+
		"\u0179\7\u6071\2\2\u0176\u0177\7\u901c\2\2\u0177\u0179\7\u77e7\2\2\u0178"+
		"\u0173\3\2\2\2\u0178\u0176\3\2\2\2\u0179V\3\2\2\2\u017a\u017b\7\u543a"+
		"\2\2\u017b\u017f\7\u6538\2\2\u017c\u017d\7\u63a7\2\2\u017d\u017f\7\u7eb5"+
		"\2\2\u017e\u017a\3\2\2\2\u017e\u017c\3\2\2\2\u017fX\3\2\2\2\u0180\u0181"+
		"\7\u6d40\2\2\u0181\u0182\7\u9065\2\2\u0182\u0187\7\u5232\2\2\u0183\u0184"+
		"\7\u5208\2\2\u0184\u0185\7\u6d40\2\2\u0185\u0187\7\u5232\2\2\u0186\u0180"+
		"\3\2\2\2\u0186\u0183\3\2\2\2\u0187Z\3\2\2\2\u0188\u0189\7\u53d3\2\2\u0189"+
		"\u0191\7\u5e05\2\2\u018a\u018b\7\u53d3\2\2\u018b\u018c\7\u5e05\2\2\u018c"+
		"\u0191\7\u5232\2\2\u018d\u018e\7\u53d3\2\2\u018e\u018f\7\u5e05\2\2\u018f"+
		"\u0191\7\u7edb\2\2\u0190\u0188\3\2\2\2\u0190\u018a\3\2\2\2\u0190\u018d"+
		"\3\2\2\2\u0191\\\3\2\2\2\u0192\u0193\7\u53d8\2\2\u0193\u0194\7\u6d8a\2"+
		"\2\u0194\u0195\7\u53d3\2\2\u0195\u0196\7\u5e05\2\2\u0196^\3\2\2\2\u0197"+
		"\u0198\7\u5b5a\2\2\u0198\u0199\7\u572a\2\2\u0199`\3\2\2\2\u019a\u019b"+
		"\7\u4e0f\2\2\u019b\u019c\7\u5b5a\2\2\u019c\u019d\7\u572a\2\2\u019db\3"+
		"\2\2\2\u019e\u019f\7\u51fc\2\2\u019f\u01a8\7\u73b2\2\2\u01a0\u01a1\7\u51fc"+
		"\2\2\u01a1\u01a2\7\u73b2\2\2\u01a2\u01a8\7\u572a\2\2\u01a3\u01a4\7\u8983"+
		"\2\2\u01a4\u01a5\7\u51fc\2\2\u01a5\u01a6\7\u73b2\2\2\u01a6\u01a8\7\u572a"+
		"\2\2\u01a7\u019e\3\2\2\2\u01a7\u01a0\3\2\2\2\u01a7\u01a3\3\2\2\2\u01a8"+
		"d\3\2\2\2\u01a9\u01aa\7\u62e7\2\2\u01aa\u01af\7\u670b\2\2\u01ab\u01ac"+
		"\7\u8983\2\2\u01ac\u01ad\7\u62e7\2\2\u01ad\u01af\7\u670b\2\2\u01ae\u01a9"+
		"\3\2\2\2\u01ae\u01ab\3\2\2\2\u01aff\3\2\2\2\u01b0\u01b1\7\u572a\2\2\u01b1"+
		"\u01b2\7\u804e\2\2\u01b2\u01b3\7\u7686\2\2\u01b3h\3\2\2\2\u01b4\u01b5"+
		"\7\u79bd\2\2\u01b5\u01b6\7\u804e\2\2\u01b6\u01b7\7\u7686\2\2\u01b7j\3"+
		"\2\2\2\u01b8\u01b9\7\u6213\2\2\u01b9l\3\2\2\2\u01ba\u01bb\t\2\2\2\u01bb"+
		"n\3\2\2\2\u01bc\u01bd\t\3\2\2\u01bdp\3\2\2\2\u01be\u01bf\7\u4ed0\2\2\u01bf"+
		"r\3\2\2\2\u01c0\u01c1\t\4\2\2\u01c1t\3\2\2\2\u01c2\u01c3\7\u5208\2\2\u01c3"+
		"\u01c8\7\u94a1\2\2\u01c4\u01c5\7\u5c11\2\2\u01c5\u01c8\7\u65f8\2\2\u01c6"+
		"\u01c8\t\5\2\2\u01c7\u01c2\3\2\2\2\u01c7\u01c4\3\2\2\2\u01c7\u01c6\3\2"+
		"\2\2\u01c8v\3\2\2\2\u01c9\u01ca\7\u5929\2\2\u01ca\u01d0\7\u4e90\2\2\u01cb"+
		"\u01cc\7\u5929\2\2\u01cc\u01cd\7\u4e90\2\2\u01cd\u01ce\7\u7b4b\2\2\u01ce"+
		"\u01d0\7\u4e90\2\2\u01cf\u01c9\3\2\2\2\u01cf\u01cb\3\2\2\2\u01d0x\3\2"+
		"\2\2\u01d1\u01d2\7\u5c11\2\2\u01d2\u01d8\7\u4e90\2\2\u01d3\u01d4\7\u5c11"+
		"\2\2\u01d4\u01d5\7\u4e90\2\2\u01d5\u01d6\7\u7b4b\2\2\u01d6\u01d8\7\u4e90"+
		"\2\2\u01d7\u01d1\3\2\2\2\u01d7\u01d3\3\2\2\2\u01d8z\3\2\2\2\u01d9\u01da"+
		"\7\u7b4b\2\2\u01da\u01db\7\u4e90\2\2\u01db|\3\2\2\2\u01dc\u01dd\7\u4e16"+
		"\2\2\u01dd~\3\2\2\2\u01de\u01df\7\u6218\2\2\u01df\u0080\3\2\2\2\u01e0"+
		"\u01e1\t\6\2\2\u01e1\u0082\3\2\2\2\u01e2\u01e3\7\u548e\2\2\u01e3\u0084"+
		"\3\2\2\2\u01e4\u01e5\7\u7686\2\2\u01e5\u0086\3\2\2\2\u01e6\u01e7\7\u5984"+
		"\2\2\u01e7\u01eb\7\u679e\2\2\u01e8\u01e9\7\u5049\2\2\u01e9\u01eb\7\u5984"+
		"\2\2\u01ea\u01e6\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u0088\3\2\2\2\u01ec"+
		"\u01f0\7\u521b\2\2\u01ed\u01ee\7\u90a5\2\2\u01ee\u01f0\7\u4e4a\2\2\u01ef"+
		"\u01ec\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u008a\3\2\2\2\u01f1\u01f2\7\u540e"+
		"\2\2\u01f2\u01f5\7\u65f8\2\2\u01f3\u01f5\7\u5e78\2\2\u01f4\u01f1\3\2\2"+
		"\2\u01f4\u01f3\3\2\2\2\u01f5\u008c\3\2\2\2\u01f6\u01f7\7\u5428\2\2\u01f7"+
		"\u01f8\7\u521b\2\2\u01f8\u008e\3\2\2\2\u01f9\u01fa\t\7\2\2\u01fa\u0090"+
		"\3\2\2\2\u01fb\u01fc\t\b\2\2\u01fc\u0092\3\2\2\2\u01fd\u01ff\t\t\2\2\u01fe"+
		"\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2"+
		"\2\2\u0201\u0094\3\2\2\2\u0202\u0206\7\u201a\2\2\u0203\u0205\13\2\2\2"+
		"\u0204\u0203\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0207\3\2\2\2\u0206\u0204"+
		"\3\2\2\2\u0207\u0209\3\2\2\2\u0208\u0206\3\2\2\2\u0209\u020a\7\u201b\2"+
		"\2\u020a\u0096\3\2\2\2\u020b\u020d\t\n\2\2\u020c\u020b\3\2\2\2\u020d\u020e"+
		"\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0098\3\2\2\2\u0210"+
		"\u0212\t\13\2\2\u0211\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0211\3"+
		"\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\bM\2\2\u0216"+
		"\u009a\3\2\2\2\u0217\u0218\7\61\2\2\u0218\u0219\7\61\2\2\u0219\u021d\3"+
		"\2\2\2\u021a\u021c\n\f\2\2\u021b\u021a\3\2\2\2\u021c\u021f\3\2\2\2\u021d"+
		"\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0220\3\2\2\2\u021f\u021d\3\2"+
		"\2\2\u0220\u0221\bN\3\2\u0221\u009c\3\2\2\2#\2\u00b3\u00f1\u00fb\u0104"+
		"\u0114\u011c\u012a\u0131\u013b\u0142\u014e\u0158\u015f\u0165\u0178\u017e"+
		"\u0186\u0190\u01a7\u01ae\u01c7\u01cf\u01d7\u01ea\u01ef\u01f4\u0200\u0206"+
		"\u020c\u020e\u0213\u021d\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}