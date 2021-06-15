package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.parser;// Generated from BL.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BLParser extends Parser {
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
	public static final int
		RULE_script = 0, RULE_stmt = 1, RULE_complexStmt = 2, RULE_simpleStmt = 3, 
		RULE_runToolStmt = 4, RULE_setStmt = 5, RULE_sortStmt = 6, RULE_groupStmt = 7, 
		RULE_baStmt = 8, RULE_newObj = 9, RULE_predicate_adverbial_attribute_object_stmt = 10, 
		RULE_predicate_adverbial_object_stmt = 11, RULE_predicate_attribute_object_stmt = 12, 
		RULE_subject_predicate_object_stmt = 13, RULE_predicate_object_stmt = 14, 
		RULE_compare_stmt = 15, RULE_compare = 16, RULE_subject = 17, RULE_object = 18, 
		RULE_object_split = 19, RULE_object_single = 20, RULE_predicate = 21, 
		RULE_attribute = 22, RULE_adverbial = 23, RULE_place_adverbial = 24, RULE_time_adverbial = 25, 
		RULE_common_adverbial = 26, RULE_noun = 27, RULE_verb = 28, RULE_adjective = 29, 
		RULE_numerals = 30, RULE_quantifiers = 31, RULE_time = 32, RULE_compareWord = 33, 
		RULE_sort = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "stmt", "complexStmt", "simpleStmt", "runToolStmt", "setStmt", 
			"sortStmt", "groupStmt", "baStmt", "newObj", "predicate_adverbial_attribute_object_stmt", 
			"predicate_adverbial_object_stmt", "predicate_attribute_object_stmt", 
			"subject_predicate_object_stmt", "predicate_object_stmt", "compare_stmt", 
			"compare", "subject", "object", "object_split", "object_single", "predicate", 
			"attribute", "adverbial", "place_adverbial", "time_adverbial", "common_adverbial", 
			"noun", "verb", "adjective", "numerals", "quantifiers", "time", "compareWord", 
			"sort"
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

	@Override
	public String getGrammarFileName() { return "BL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ScriptContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> Dot() { return getTokens(BLParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(BLParser.Dot, i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				stmt();
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Dot) {
					{
					setState(71);
					match(Dot);
					}
				}

				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Show) | (1L << Execute) | (1L << Get) | (1L << Find) | (1L << Remove) | (1L << Qiu) | (1L << Set) | (1L << Count) | (1L << CarryOut) | (1L << SortAscending) | (1L << SortDescending) | (1L << Group) | (1L << Change) | (1L << New) | (1L << Rename) | (1L << Merge) | (1L << InputPart) | (1L << OutputPart) | (1L << Element) | (1L << Amount) | (1L << Data) | (1L << Max) | (1L << Min) | (1L << Average) | (1L << Today) | (1L << Jiang) | (1L << According) | (1L << Number) | (1L << Str) | (1L << ObjName))) != 0) );
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

	public static class StmtContext extends ParserRuleContext {
		public SimpleStmtContext simpleStmt() {
			return getRuleContext(SimpleStmtContext.class,0);
		}
		public ComplexStmtContext complexStmt() {
			return getRuleContext(ComplexStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				simpleStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				complexStmt();
				}
				break;
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

	public static class ComplexStmtContext extends ParserRuleContext {
		public RunToolStmtContext runToolStmt() {
			return getRuleContext(RunToolStmtContext.class,0);
		}
		public SetStmtContext setStmt() {
			return getRuleContext(SetStmtContext.class,0);
		}
		public SortStmtContext sortStmt() {
			return getRuleContext(SortStmtContext.class,0);
		}
		public GroupStmtContext groupStmt() {
			return getRuleContext(GroupStmtContext.class,0);
		}
		public NewObjContext newObj() {
			return getRuleContext(NewObjContext.class,0);
		}
		public BaStmtContext baStmt() {
			return getRuleContext(BaStmtContext.class,0);
		}
		public ComplexStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitComplexStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexStmtContext complexStmt() throws RecognitionException {
		ComplexStmtContext _localctx = new ComplexStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_complexStmt);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				runToolStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				setStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				sortStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				groupStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				newObj();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(87);
				baStmt();
				}
				break;
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

	public static class SimpleStmtContext extends ParserRuleContext {
		public Subject_predicate_object_stmtContext subject_predicate_object_stmt() {
			return getRuleContext(Subject_predicate_object_stmtContext.class,0);
		}
		public Predicate_attribute_object_stmtContext predicate_attribute_object_stmt() {
			return getRuleContext(Predicate_attribute_object_stmtContext.class,0);
		}
		public Predicate_adverbial_object_stmtContext predicate_adverbial_object_stmt() {
			return getRuleContext(Predicate_adverbial_object_stmtContext.class,0);
		}
		public Predicate_adverbial_attribute_object_stmtContext predicate_adverbial_attribute_object_stmt() {
			return getRuleContext(Predicate_adverbial_attribute_object_stmtContext.class,0);
		}
		public Predicate_object_stmtContext predicate_object_stmt() {
			return getRuleContext(Predicate_object_stmtContext.class,0);
		}
		public Compare_stmtContext compare_stmt() {
			return getRuleContext(Compare_stmtContext.class,0);
		}
		public SimpleStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitSimpleStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleStmtContext simpleStmt() throws RecognitionException {
		SimpleStmtContext _localctx = new SimpleStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_simpleStmt);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				subject_predicate_object_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				predicate_attribute_object_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				predicate_adverbial_object_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				predicate_adverbial_attribute_object_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				predicate_object_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(95);
				compare_stmt();
				}
				break;
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

	public static class RunToolStmtContext extends ParserRuleContext {
		public List<Predicate_object_stmtContext> predicate_object_stmt() {
			return getRuleContexts(Predicate_object_stmtContext.class);
		}
		public Predicate_object_stmtContext predicate_object_stmt(int i) {
			return getRuleContext(Predicate_object_stmtContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(BLParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(BLParser.Comma, i);
		}
		public TerminalNode Among() { return getToken(BLParser.Among, 0); }
		public List<CompareContext> compare() {
			return getRuleContexts(CompareContext.class);
		}
		public CompareContext compare(int i) {
			return getRuleContext(CompareContext.class,i);
		}
		public TerminalNode Jiang() { return getToken(BLParser.Jiang, 0); }
		public TerminalNode ObjName() { return getToken(BLParser.ObjName, 0); }
		public TerminalNode AsParam() { return getToken(BLParser.AsParam, 0); }
		public RunToolStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_runToolStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitRunToolStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RunToolStmtContext runToolStmt() throws RecognitionException {
		RunToolStmtContext _localctx = new RunToolStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_runToolStmt);
		try {
			int _alt;
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Show:
			case Execute:
			case Get:
			case Find:
			case Remove:
			case Qiu:
			case Set:
			case Count:
			case CarryOut:
			case SortAscending:
			case SortDescending:
			case Group:
			case Change:
			case New:
			case Rename:
			case Merge:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				predicate_object_stmt();
				setState(107);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(99);
					match(Comma);
					setState(100);
					match(Among);
					setState(103); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(101);
							match(Comma);
							setState(102);
							compare();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(105); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
					} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
					}
					break;
				}
				setState(109);
				match(Comma);
				setState(110);
				predicate_object_stmt();
				}
				break;
			case Jiang:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(Jiang);
				setState(113);
				match(ObjName);
				setState(114);
				match(AsParam);
				setState(115);
				match(Comma);
				setState(116);
				predicate_object_stmt();
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

	public static class SetStmtContext extends ParserRuleContext {
		public TerminalNode Set() { return getToken(BLParser.Set, 0); }
		public List<TerminalNode> Str() { return getTokens(BLParser.Str); }
		public TerminalNode Str(int i) {
			return getToken(BLParser.Str, i);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode Number() { return getToken(BLParser.Number, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public SetStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitSetStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetStmtContext setStmt() throws RecognitionException {
		SetStmtContext _localctx = new SetStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_setStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(Set);
			setState(120);
			match(Str);
			setState(121);
			match(T__0);
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(122);
				stmt();
				}
				break;
			case 2:
				{
				setState(123);
				match(Str);
				}
				break;
			case 3:
				{
				setState(124);
				match(Number);
				}
				break;
			case 4:
				{
				setState(125);
				object();
				}
				break;
			}
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

	public static class SortStmtContext extends ParserRuleContext {
		public TerminalNode According() { return getToken(BLParser.According, 0); }
		public List<TerminalNode> ObjName() { return getTokens(BLParser.ObjName); }
		public TerminalNode ObjName(int i) {
			return getToken(BLParser.ObjName, i);
		}
		public TerminalNode Jiang() { return getToken(BLParser.Jiang, 0); }
		public TerminalNode CarryOut() { return getToken(BLParser.CarryOut, 0); }
		public SortContext sort() {
			return getRuleContext(SortContext.class,0);
		}
		public SortStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitSortStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortStmtContext sortStmt() throws RecognitionException {
		SortStmtContext _localctx = new SortStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sortStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(According);
			setState(129);
			match(ObjName);
			setState(130);
			match(Jiang);
			setState(131);
			match(ObjName);
			setState(132);
			match(CarryOut);
			setState(133);
			sort();
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

	public static class GroupStmtContext extends ParserRuleContext {
		public TerminalNode Jiang() { return getToken(BLParser.Jiang, 0); }
		public TerminalNode ObjName() { return getToken(BLParser.ObjName, 0); }
		public TerminalNode According() { return getToken(BLParser.According, 0); }
		public TerminalNode Str() { return getToken(BLParser.Str, 0); }
		public TerminalNode Group() { return getToken(BLParser.Group, 0); }
		public GroupStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitGroupStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupStmtContext groupStmt() throws RecognitionException {
		GroupStmtContext _localctx = new GroupStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_groupStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(Jiang);
			setState(136);
			match(ObjName);
			setState(137);
			match(According);
			setState(138);
			match(Str);
			setState(139);
			match(Group);
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

	public static class BaStmtContext extends ParserRuleContext {
		public TerminalNode Jiang() { return getToken(BLParser.Jiang, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public VerbContext verb() {
			return getRuleContext(VerbContext.class,0);
		}
		public Object_singleContext object_single() {
			return getRuleContext(Object_singleContext.class,0);
		}
		public TerminalNode According() { return getToken(BLParser.According, 0); }
		public TerminalNode Str() { return getToken(BLParser.Str, 0); }
		public BaStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitBaStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaStmtContext baStmt() throws RecognitionException {
		BaStmtContext _localctx = new BaStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_baStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(Jiang);
			setState(142);
			object();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==According) {
				{
				setState(143);
				match(According);
				setState(144);
				match(Str);
				}
			}

			setState(147);
			verb();
			setState(148);
			object_single();
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

	public static class NewObjContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(BLParser.New, 0); }
		public TerminalNode Str() { return getToken(BLParser.Str, 0); }
		public List<TerminalNode> Comma() { return getTokens(BLParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(BLParser.Comma, i);
		}
		public TerminalNode Among() { return getToken(BLParser.Among, 0); }
		public List<CompareContext> compare() {
			return getRuleContexts(CompareContext.class);
		}
		public CompareContext compare(int i) {
			return getRuleContext(CompareContext.class,i);
		}
		public NewObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newObj; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitNewObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewObjContext newObj() throws RecognitionException {
		NewObjContext _localctx = new NewObjContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_newObj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(New);
			setState(151);
			match(Str);
			setState(152);
			match(Comma);
			setState(153);
			match(Among);
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				match(Comma);
				setState(155);
				compare();
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Comma );
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

	public static class Predicate_adverbial_attribute_object_stmtContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public AdverbialContext adverbial() {
			return getRuleContext(AdverbialContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public Predicate_adverbial_attribute_object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_adverbial_attribute_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitPredicate_adverbial_attribute_object_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Predicate_adverbial_attribute_object_stmtContext predicate_adverbial_attribute_object_stmt() throws RecognitionException {
		Predicate_adverbial_attribute_object_stmtContext _localctx = new Predicate_adverbial_attribute_object_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_predicate_adverbial_attribute_object_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			predicate();
			setState(161);
			adverbial();
			setState(162);
			attribute();
			setState(163);
			object();
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

	public static class Predicate_adverbial_object_stmtContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public AdverbialContext adverbial() {
			return getRuleContext(AdverbialContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public Predicate_adverbial_object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_adverbial_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitPredicate_adverbial_object_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Predicate_adverbial_object_stmtContext predicate_adverbial_object_stmt() throws RecognitionException {
		Predicate_adverbial_object_stmtContext _localctx = new Predicate_adverbial_object_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_predicate_adverbial_object_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			predicate();
			setState(166);
			adverbial();
			setState(167);
			object();
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

	public static class Predicate_attribute_object_stmtContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public Predicate_attribute_object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_attribute_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitPredicate_attribute_object_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Predicate_attribute_object_stmtContext predicate_attribute_object_stmt() throws RecognitionException {
		Predicate_attribute_object_stmtContext _localctx = new Predicate_attribute_object_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_predicate_attribute_object_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			predicate();
			setState(170);
			attribute();
			setState(171);
			object();
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

	public static class Subject_predicate_object_stmtContext extends ParserRuleContext {
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public Subject_predicate_object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject_predicate_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitSubject_predicate_object_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subject_predicate_object_stmtContext subject_predicate_object_stmt() throws RecognitionException {
		Subject_predicate_object_stmtContext _localctx = new Subject_predicate_object_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_subject_predicate_object_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			subject();
			setState(174);
			predicate();
			setState(175);
			object();
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

	public static class Predicate_object_stmtContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public Predicate_object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitPredicate_object_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Predicate_object_stmtContext predicate_object_stmt() throws RecognitionException {
		Predicate_object_stmtContext _localctx = new Predicate_object_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_predicate_object_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			predicate();
			setState(178);
			object();
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

	public static class Compare_stmtContext extends ParserRuleContext {
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public TerminalNode Mark() { return getToken(BLParser.Mark, 0); }
		public Compare_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitCompare_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compare_stmtContext compare_stmt() throws RecognitionException {
		Compare_stmtContext _localctx = new Compare_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_compare_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			compare();
			setState(181);
			match(Mark);
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

	public static class CompareContext extends ParserRuleContext {
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public CompareWordContext compareWord() {
			return getRuleContext(CompareWordContext.class,0);
		}
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		CompareContext _localctx = new CompareContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_compare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			object();
			setState(184);
			compareWord();
			setState(185);
			object();
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

	public static class SubjectContext extends ParserRuleContext {
		public TerminalNode ObjName() { return getToken(BLParser.ObjName, 0); }
		public SubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitSubject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubjectContext subject() throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(ObjName);
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

	public static class ObjectContext extends ParserRuleContext {
		public List<Object_singleContext> object_single() {
			return getRuleContexts(Object_singleContext.class);
		}
		public Object_singleContext object_single(int i) {
			return getRuleContext(Object_singleContext.class,i);
		}
		public List<Object_splitContext> object_split() {
			return getRuleContexts(Object_splitContext.class);
		}
		public Object_splitContext object_split(int i) {
			return getRuleContext(Object_splitContext.class,i);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_object);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			object_single();
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(190);
					object_split();
					setState(191);
					object_single();
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
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

	public static class Object_splitContext extends ParserRuleContext {
		public TerminalNode Split() { return getToken(BLParser.Split, 0); }
		public Object_splitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_split; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitObject_split(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object_splitContext object_split() throws RecognitionException {
		Object_splitContext _localctx = new Object_splitContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_object_split);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(Split);
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

	public static class Object_singleContext extends ParserRuleContext {
		public List<NounContext> noun() {
			return getRuleContexts(NounContext.class);
		}
		public NounContext noun(int i) {
			return getRuleContext(NounContext.class,i);
		}
		public List<TerminalNode> ObjName() { return getTokens(BLParser.ObjName); }
		public TerminalNode ObjName(int i) {
			return getToken(BLParser.ObjName, i);
		}
		public List<TerminalNode> De() { return getTokens(BLParser.De); }
		public TerminalNode De(int i) {
			return getToken(BLParser.De, i);
		}
		public TerminalNode Str() { return getToken(BLParser.Str, 0); }
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public NumeralsContext numerals() {
			return getRuleContext(NumeralsContext.class,0);
		}
		public Object_singleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_single; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitObject_single(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object_singleContext object_single() throws RecognitionException {
		Object_singleContext _localctx = new Object_singleContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_object_single);
		try {
			int _alt;
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case InputPart:
			case OutputPart:
			case Element:
			case Amount:
			case Data:
			case Max:
			case Min:
			case Average:
			case ObjName:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case InputPart:
				case OutputPart:
				case Element:
				case Amount:
				case Data:
				case Max:
				case Min:
				case Average:
					{
					setState(200);
					noun();
					}
					break;
				case ObjName:
					{
					setState(201);
					match(ObjName);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(204);
						match(De);
						setState(207);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case InputPart:
						case OutputPart:
						case Element:
						case Amount:
						case Data:
						case Max:
						case Min:
						case Average:
							{
							setState(205);
							noun();
							}
							break;
						case ObjName:
							{
							setState(206);
							match(ObjName);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(213);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(Str);
				}
				break;
			case Today:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				time();
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				numerals();
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

	public static class PredicateContext extends ParserRuleContext {
		public VerbContext verb() {
			return getRuleContext(VerbContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			verb();
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

	public static class AttributeContext extends ParserRuleContext {
		public List<CompareContext> compare() {
			return getRuleContexts(CompareContext.class);
		}
		public CompareContext compare(int i) {
			return getRuleContext(CompareContext.class,i);
		}
		public TerminalNode De() { return getToken(BLParser.De, 0); }
		public List<TerminalNode> Split() { return getTokens(BLParser.Split); }
		public TerminalNode Split(int i) {
			return getToken(BLParser.Split, i);
		}
		public AdjectiveContext adjective() {
			return getRuleContext(AdjectiveContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_attribute);
		int _la;
		try {
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case InputPart:
			case OutputPart:
			case Element:
			case Amount:
			case Data:
			case Max:
			case Min:
			case Average:
			case Today:
			case Number:
			case Str:
			case ObjName:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				compare();
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Split) {
					{
					{
					setState(222);
					match(Split);
					setState(223);
					compare();
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(229);
				match(De);
				}
				break;
			case Old:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				adjective();
				setState(232);
				match(De);
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

	public static class AdverbialContext extends ParserRuleContext {
		public Place_adverbialContext place_adverbial() {
			return getRuleContext(Place_adverbialContext.class,0);
		}
		public Time_adverbialContext time_adverbial() {
			return getRuleContext(Time_adverbialContext.class,0);
		}
		public Common_adverbialContext common_adverbial() {
			return getRuleContext(Common_adverbialContext.class,0);
		}
		public AdverbialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adverbial; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitAdverbial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdverbialContext adverbial() throws RecognitionException {
		AdverbialContext _localctx = new AdverbialContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_adverbial);
		try {
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				place_adverbial();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				time_adverbial();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				common_adverbial();
				}
				break;
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

	public static class Place_adverbialContext extends ParserRuleContext {
		public TerminalNode At() { return getToken(BLParser.At, 0); }
		public TerminalNode ObjName() { return getToken(BLParser.ObjName, 0); }
		public TerminalNode In() { return getToken(BLParser.In, 0); }
		public Place_adverbialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_place_adverbial; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitPlace_adverbial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Place_adverbialContext place_adverbial() throws RecognitionException {
		Place_adverbialContext _localctx = new Place_adverbialContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_place_adverbial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(At);
			setState(242);
			match(ObjName);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==In) {
				{
				setState(243);
				match(In);
				}
			}

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

	public static class Time_adverbialContext extends ParserRuleContext {
		public TerminalNode At() { return getToken(BLParser.At, 0); }
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public Time_adverbialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_adverbial; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitTime_adverbial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_adverbialContext time_adverbial() throws RecognitionException {
		Time_adverbialContext _localctx = new Time_adverbialContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_time_adverbial);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(At);
			setState(247);
			time();
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

	public static class Common_adverbialContext extends ParserRuleContext {
		public TerminalNode ObjName() { return getToken(BLParser.ObjName, 0); }
		public TerminalNode In() { return getToken(BLParser.In, 0); }
		public Common_adverbialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_adverbial; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitCommon_adverbial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Common_adverbialContext common_adverbial() throws RecognitionException {
		Common_adverbialContext _localctx = new Common_adverbialContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_common_adverbial);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(ObjName);
			setState(250);
			match(In);
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

	public static class NounContext extends ParserRuleContext {
		public TerminalNode InputPart() { return getToken(BLParser.InputPart, 0); }
		public TerminalNode OutputPart() { return getToken(BLParser.OutputPart, 0); }
		public TerminalNode Element() { return getToken(BLParser.Element, 0); }
		public TerminalNode Amount() { return getToken(BLParser.Amount, 0); }
		public TerminalNode Data() { return getToken(BLParser.Data, 0); }
		public TerminalNode Max() { return getToken(BLParser.Max, 0); }
		public TerminalNode Min() { return getToken(BLParser.Min, 0); }
		public TerminalNode Average() { return getToken(BLParser.Average, 0); }
		public NounContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitNoun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NounContext noun() throws RecognitionException {
		NounContext _localctx = new NounContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_noun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << InputPart) | (1L << OutputPart) | (1L << Element) | (1L << Amount) | (1L << Data) | (1L << Max) | (1L << Min) | (1L << Average))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class VerbContext extends ParserRuleContext {
		public TerminalNode Show() { return getToken(BLParser.Show, 0); }
		public TerminalNode Execute() { return getToken(BLParser.Execute, 0); }
		public TerminalNode Get() { return getToken(BLParser.Get, 0); }
		public TerminalNode Find() { return getToken(BLParser.Find, 0); }
		public TerminalNode Remove() { return getToken(BLParser.Remove, 0); }
		public TerminalNode Qiu() { return getToken(BLParser.Qiu, 0); }
		public TerminalNode Set() { return getToken(BLParser.Set, 0); }
		public TerminalNode Count() { return getToken(BLParser.Count, 0); }
		public TerminalNode CarryOut() { return getToken(BLParser.CarryOut, 0); }
		public SortContext sort() {
			return getRuleContext(SortContext.class,0);
		}
		public TerminalNode Group() { return getToken(BLParser.Group, 0); }
		public TerminalNode Change() { return getToken(BLParser.Change, 0); }
		public TerminalNode New() { return getToken(BLParser.New, 0); }
		public TerminalNode Rename() { return getToken(BLParser.Rename, 0); }
		public TerminalNode Merge() { return getToken(BLParser.Merge, 0); }
		public VerbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitVerb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerbContext verb() throws RecognitionException {
		VerbContext _localctx = new VerbContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_verb);
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Show:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(Show);
				}
				break;
			case Execute:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(Execute);
				}
				break;
			case Get:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(Get);
				}
				break;
			case Find:
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				match(Find);
				}
				break;
			case Remove:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				match(Remove);
				}
				break;
			case Qiu:
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				match(Qiu);
				}
				break;
			case Set:
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				match(Set);
				}
				break;
			case Count:
				enterOuterAlt(_localctx, 8);
				{
				setState(261);
				match(Count);
				}
				break;
			case CarryOut:
				enterOuterAlt(_localctx, 9);
				{
				setState(262);
				match(CarryOut);
				}
				break;
			case SortAscending:
			case SortDescending:
				enterOuterAlt(_localctx, 10);
				{
				setState(263);
				sort();
				}
				break;
			case Group:
				enterOuterAlt(_localctx, 11);
				{
				setState(264);
				match(Group);
				}
				break;
			case Change:
				enterOuterAlt(_localctx, 12);
				{
				setState(265);
				match(Change);
				}
				break;
			case New:
				enterOuterAlt(_localctx, 13);
				{
				setState(266);
				match(New);
				}
				break;
			case Rename:
				enterOuterAlt(_localctx, 14);
				{
				setState(267);
				match(Rename);
				}
				break;
			case Merge:
				enterOuterAlt(_localctx, 15);
				{
				setState(268);
				match(Merge);
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

	public static class AdjectiveContext extends ParserRuleContext {
		public TerminalNode Old() { return getToken(BLParser.Old, 0); }
		public AdjectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adjective; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitAdjective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdjectiveContext adjective() throws RecognitionException {
		AdjectiveContext _localctx = new AdjectiveContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_adjective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(Old);
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

	public static class NumeralsContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(BLParser.Number, 0); }
		public NumeralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitNumerals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumeralsContext numerals() throws RecognitionException {
		NumeralsContext _localctx = new NumeralsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_numerals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(Number);
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

	public static class QuantifiersContext extends ParserRuleContext {
		public TerminalNode Ge() { return getToken(BLParser.Ge, 0); }
		public QuantifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifiers; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitQuantifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifiersContext quantifiers() throws RecognitionException {
		QuantifiersContext _localctx = new QuantifiersContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_quantifiers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(Ge);
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

	public static class TimeContext extends ParserRuleContext {
		public TerminalNode Today() { return getToken(BLParser.Today, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(Today);
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

	public static class CompareWordContext extends ParserRuleContext {
		public TerminalNode Equals() { return getToken(BLParser.Equals, 0); }
		public TerminalNode NoEquals() { return getToken(BLParser.NoEquals, 0); }
		public TerminalNode MoreThan() { return getToken(BLParser.MoreThan, 0); }
		public TerminalNode NoMoreThan() { return getToken(BLParser.NoMoreThan, 0); }
		public TerminalNode LessThan() { return getToken(BLParser.LessThan, 0); }
		public TerminalNode NoLessThan() { return getToken(BLParser.NoLessThan, 0); }
		public CompareWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitCompareWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareWordContext compareWord() throws RecognitionException {
		CompareWordContext _localctx = new CompareWordContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_compareWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equals) | (1L << MoreThan) | (1L << LessThan) | (1L << NoEquals) | (1L << NoMoreThan) | (1L << NoLessThan))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class SortContext extends ParserRuleContext {
		public TerminalNode SortDescending() { return getToken(BLParser.SortDescending, 0); }
		public TerminalNode SortAscending() { return getToken(BLParser.SortAscending, 0); }
		public SortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BLVisitor) return ((BLVisitor<? extends T>)visitor).visitSort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortContext sort() throws RecognitionException {
		SortContext _localctx = new SortContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_sort);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if ( !(_la==SortAscending || _la==SortDescending) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u011e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\5\2K\n\2\6\2M\n\2\r\2\16\2N\3\3\3\3\5"+
		"\3S\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4[\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5c"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\6\6j\n\6\r\6\16\6k\5\6n\n\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6x\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0081\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u0094"+
		"\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u009f\n\13\r\13\16"+
		"\13\u00a0\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\7\24\u00c4\n\24\f\24\16\24\u00c7\13\24\3\25"+
		"\3\25\3\26\3\26\5\26\u00cd\n\26\3\26\3\26\3\26\5\26\u00d2\n\26\7\26\u00d4"+
		"\n\26\f\26\16\26\u00d7\13\26\3\26\3\26\3\26\5\26\u00dc\n\26\3\27\3\27"+
		"\3\30\3\30\3\30\7\30\u00e3\n\30\f\30\16\30\u00e6\13\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u00ed\n\30\3\31\3\31\3\31\5\31\u00f2\n\31\3\32\3\32\3"+
		"\32\5\32\u00f7\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u0110\n\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\2\2%\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\5\3\2\32"+
		"!\3\2\24\31\3\2\r\16\2\u0129\2L\3\2\2\2\4R\3\2\2\2\6Z\3\2\2\2\bb\3\2\2"+
		"\2\nw\3\2\2\2\fy\3\2\2\2\16\u0082\3\2\2\2\20\u0089\3\2\2\2\22\u008f\3"+
		"\2\2\2\24\u0098\3\2\2\2\26\u00a2\3\2\2\2\30\u00a7\3\2\2\2\32\u00ab\3\2"+
		"\2\2\34\u00af\3\2\2\2\36\u00b3\3\2\2\2 \u00b6\3\2\2\2\"\u00b9\3\2\2\2"+
		"$\u00bd\3\2\2\2&\u00bf\3\2\2\2(\u00c8\3\2\2\2*\u00db\3\2\2\2,\u00dd\3"+
		"\2\2\2.\u00ec\3\2\2\2\60\u00f1\3\2\2\2\62\u00f3\3\2\2\2\64\u00f8\3\2\2"+
		"\2\66\u00fb\3\2\2\28\u00fe\3\2\2\2:\u010f\3\2\2\2<\u0111\3\2\2\2>\u0113"+
		"\3\2\2\2@\u0115\3\2\2\2B\u0117\3\2\2\2D\u0119\3\2\2\2F\u011b\3\2\2\2H"+
		"J\5\4\3\2IK\7-\2\2JI\3\2\2\2JK\3\2\2\2KM\3\2\2\2LH\3\2\2\2MN\3\2\2\2N"+
		"L\3\2\2\2NO\3\2\2\2O\3\3\2\2\2PS\5\b\5\2QS\5\6\4\2RP\3\2\2\2RQ\3\2\2\2"+
		"S\5\3\2\2\2T[\5\n\6\2U[\5\f\7\2V[\5\16\b\2W[\5\20\t\2X[\5\24\13\2Y[\5"+
		"\22\n\2ZT\3\2\2\2ZU\3\2\2\2ZV\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\7"+
		"\3\2\2\2\\c\5\34\17\2]c\5\32\16\2^c\5\30\r\2_c\5\26\f\2`c\5\36\20\2ac"+
		"\5 \21\2b\\\3\2\2\2b]\3\2\2\2b^\3\2\2\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2"+
		"c\t\3\2\2\2dm\5\36\20\2ef\7,\2\2fi\7&\2\2gh\7,\2\2hj\5\"\22\2ig\3\2\2"+
		"\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2me\3\2\2\2mn\3\2\2\2no\3\2\2"+
		"\2op\7,\2\2pq\5\36\20\2qx\3\2\2\2rs\7(\2\2st\7\62\2\2tu\7+\2\2uv\7,\2"+
		"\2vx\5\36\20\2wd\3\2\2\2wr\3\2\2\2x\13\3\2\2\2yz\7\n\2\2z{\7\61\2\2{\u0080"+
		"\7\3\2\2|\u0081\5\4\3\2}\u0081\7\61\2\2~\u0081\7\60\2\2\177\u0081\5&\24"+
		"\2\u0080|\3\2\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081"+
		"\r\3\2\2\2\u0082\u0083\7)\2\2\u0083\u0084\7\62\2\2\u0084\u0085\7(\2\2"+
		"\u0085\u0086\7\62\2\2\u0086\u0087\7\f\2\2\u0087\u0088\5F$\2\u0088\17\3"+
		"\2\2\2\u0089\u008a\7(\2\2\u008a\u008b\7\62\2\2\u008b\u008c\7)\2\2\u008c"+
		"\u008d\7\61\2\2\u008d\u008e\7\17\2\2\u008e\21\3\2\2\2\u008f\u0090\7(\2"+
		"\2\u0090\u0093\5&\24\2\u0091\u0092\7)\2\2\u0092\u0094\7\61\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\5:\36\2\u0096"+
		"\u0097\5*\26\2\u0097\23\3\2\2\2\u0098\u0099\7\21\2\2\u0099\u009a\7\61"+
		"\2\2\u009a\u009b\7,\2\2\u009b\u009e\7&\2\2\u009c\u009d\7,\2\2\u009d\u009f"+
		"\5\"\22\2\u009e\u009c\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a1\25\3\2\2\2\u00a2\u00a3\5,\27\2\u00a3\u00a4"+
		"\5\60\31\2\u00a4\u00a5\5.\30\2\u00a5\u00a6\5&\24\2\u00a6\27\3\2\2\2\u00a7"+
		"\u00a8\5,\27\2\u00a8\u00a9\5\60\31\2\u00a9\u00aa\5&\24\2\u00aa\31\3\2"+
		"\2\2\u00ab\u00ac\5,\27\2\u00ac\u00ad\5.\30\2\u00ad\u00ae\5&\24\2\u00ae"+
		"\33\3\2\2\2\u00af\u00b0\5$\23\2\u00b0\u00b1\5,\27\2\u00b1\u00b2\5&\24"+
		"\2\u00b2\35\3\2\2\2\u00b3\u00b4\5,\27\2\u00b4\u00b5\5&\24\2\u00b5\37\3"+
		"\2\2\2\u00b6\u00b7\5\"\22\2\u00b7\u00b8\7/\2\2\u00b8!\3\2\2\2\u00b9\u00ba"+
		"\5&\24\2\u00ba\u00bb\5D#\2\u00bb\u00bc\5&\24\2\u00bc#\3\2\2\2\u00bd\u00be"+
		"\7\62\2\2\u00be%\3\2\2\2\u00bf\u00c5\5*\26\2\u00c0\u00c1\5(\25\2\u00c1"+
		"\u00c2\5*\26\2\u00c2\u00c4\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3\2"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\'\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c8\u00c9\7.\2\2\u00c9)\3\2\2\2\u00ca\u00cd\58\35\2\u00cb\u00cd"+
		"\7\62\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d5\3\2\2\2"+
		"\u00ce\u00d1\7%\2\2\u00cf\u00d2\58\35\2\u00d0\u00d2\7\62\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00dc\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00dc\7\61\2\2\u00d9\u00dc\5B\"\2\u00da"+
		"\u00dc\5> \2\u00db\u00cc\3\2\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2"+
		"\2\u00db\u00da\3\2\2\2\u00dc+\3\2\2\2\u00dd\u00de\5:\36\2\u00de-\3\2\2"+
		"\2\u00df\u00e4\5\"\22\2\u00e0\u00e1\7.\2\2\u00e1\u00e3\5\"\22\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7%\2\2\u00e8"+
		"\u00ed\3\2\2\2\u00e9\u00ea\5<\37\2\u00ea\u00eb\7%\2\2\u00eb\u00ed\3\2"+
		"\2\2\u00ec\u00df\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ed/\3\2\2\2\u00ee\u00f2"+
		"\5\62\32\2\u00ef\u00f2\5\64\33\2\u00f0\u00f2\5\66\34\2\u00f1\u00ee\3\2"+
		"\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\61\3\2\2\2\u00f3\u00f4"+
		"\7*\2\2\u00f4\u00f6\7\62\2\2\u00f5\u00f7\7\'\2\2\u00f6\u00f5\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\63\3\2\2\2\u00f8\u00f9\7*\2\2\u00f9\u00fa\5B\"\2"+
		"\u00fa\65\3\2\2\2\u00fb\u00fc\7\62\2\2\u00fc\u00fd\7\'\2\2\u00fd\67\3"+
		"\2\2\2\u00fe\u00ff\t\2\2\2\u00ff9\3\2\2\2\u0100\u0110\7\4\2\2\u0101\u0110"+
		"\7\5\2\2\u0102\u0110\7\6\2\2\u0103\u0110\7\7\2\2\u0104\u0110\7\b\2\2\u0105"+
		"\u0110\7\t\2\2\u0106\u0110\7\n\2\2\u0107\u0110\7\13\2\2\u0108\u0110\7"+
		"\f\2\2\u0109\u0110\5F$\2\u010a\u0110\7\17\2\2\u010b\u0110\7\20\2\2\u010c"+
		"\u0110\7\21\2\2\u010d\u0110\7\22\2\2\u010e\u0110\7\23\2\2\u010f\u0100"+
		"\3\2\2\2\u010f\u0101\3\2\2\2\u010f\u0102\3\2\2\2\u010f\u0103\3\2\2\2\u010f"+
		"\u0104\3\2\2\2\u010f\u0105\3\2\2\2\u010f\u0106\3\2\2\2\u010f\u0107\3\2"+
		"\2\2\u010f\u0108\3\2\2\2\u010f\u0109\3\2\2\2\u010f\u010a\3\2\2\2\u010f"+
		"\u010b\3\2\2\2\u010f\u010c\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2"+
		"\2\2\u0110;\3\2\2\2\u0111\u0112\7$\2\2\u0112=\3\2\2\2\u0113\u0114\7\60"+
		"\2\2\u0114?\3\2\2\2\u0115\u0116\7#\2\2\u0116A\3\2\2\2\u0117\u0118\7\""+
		"\2\2\u0118C\3\2\2\2\u0119\u011a\t\3\2\2\u011aE\3\2\2\2\u011b\u011c\t\4"+
		"\2\2\u011cG\3\2\2\2\27JNRZbkmw\u0080\u0093\u00a0\u00c5\u00cc\u00d1\u00d5"+
		"\u00db\u00e4\u00ec\u00f1\u00f6\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}