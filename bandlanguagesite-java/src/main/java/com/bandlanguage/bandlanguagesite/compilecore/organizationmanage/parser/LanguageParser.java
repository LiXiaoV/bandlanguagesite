package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser;// Generated from Language.g4 by ANTLR 4.8

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
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_script = 0, RULE_stmt = 1, RULE_simpleStmt = 2, RULE_complexStmt = 3, 
		RULE_subject_predicate_object_stmt = 4, RULE_subject_predicate_attribute_object_stmt = 5, 
		RULE_subject_adverbial_predicate_attribute_object_stmt = 6, RULE_subject_adverbial_predicate_complement_attribute_object_stmt = 7, 
		RULE_ifStmt = 8, RULE_concurrentStmt = 9, RULE_judgeStmt = 10, RULE_subject = 11, 
		RULE_predicate = 12, RULE_object = 13, RULE_attribute = 14, RULE_adverbial = 15, 
		RULE_complement = 16, RULE_place_adverbial = 17, RULE_preposition_object = 18, 
		RULE_isExist = 19, RULE_notExist = 20, RULE_time_complement = 21, RULE_comparator = 22, 
		RULE_logic_operator = 23, RULE_noun = 24, RULE_verb = 25, RULE_adjective = 26, 
		RULE_preposition = 27, RULE_direction = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "stmt", "simpleStmt", "complexStmt", "subject_predicate_object_stmt", 
			"subject_predicate_attribute_object_stmt", "subject_adverbial_predicate_attribute_object_stmt", 
			"subject_adverbial_predicate_complement_attribute_object_stmt", "ifStmt", 
			"concurrentStmt", "judgeStmt", "subject", "predicate", "object", "attribute", 
			"adverbial", "complement", "place_adverbial", "preposition_object", "isExist", 
			"notExist", "time_complement", "comparator", "logic_operator", "noun", 
			"verb", "adjective", "preposition", "direction"
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

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
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
		public List<TerminalNode> Dot() { return getTokens(LanguageParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(LanguageParser.Dot, i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitScript(this);
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
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				stmt();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Dot) {
					{
					setState(59);
					match(Dot);
					}
				}

				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Organization) | (1L << Department) | (1L << ParentDepartment) | (1L << SuperiorDepartment) | (1L << SubDepartment) | (1L << Band) | (1L << ParentBand) | (1L << SubBand) | (1L << Position) | (1L << Member) | (1L << Tool) | (1L << Role) | (1L << Authority) | (1L << Reader) | (1L << Writer) | (1L << Speaker) | (1L << Worker) | (1L << Administrator) | (1L << Drama) | (1L << File) | (1L << Chatroom) | (1L << MaxAuthority) | (1L << MinAuthority) | (1L << Deadline) | (1L << NewStaff) | (1L << SeniorStaff) | (1L << Show) | (1L << Establish) | (1L << Join) | (1L << Revoke) | (1L << Set) | (1L << Change) | (1L << Edit) | (1L << Delete) | (1L << Merge) | (1L << Move) | (1L << Appoint) | (1L << Grant) | (1L << Disable) | (1L << Enable) | (1L << SendMsg) | (1L << Accept) | (1L << Dispatch) | (1L << Publish) | (1L << CancelPub) | (1L << Appear) | (1L << Have) | (1L << Me) | (1L << At) | (1L << Make) | (1L << From))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (If - 67)) | (1L << (Number - 67)) | (1L << (String - 67)) | (1L << (Identifier - 67)))) != 0) );
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
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				simpleStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
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

	public static class SimpleStmtContext extends ParserRuleContext {
		public Subject_predicate_object_stmtContext subject_predicate_object_stmt() {
			return getRuleContext(Subject_predicate_object_stmtContext.class,0);
		}
		public Subject_predicate_attribute_object_stmtContext subject_predicate_attribute_object_stmt() {
			return getRuleContext(Subject_predicate_attribute_object_stmtContext.class,0);
		}
		public Subject_adverbial_predicate_attribute_object_stmtContext subject_adverbial_predicate_attribute_object_stmt() {
			return getRuleContext(Subject_adverbial_predicate_attribute_object_stmtContext.class,0);
		}
		public Subject_adverbial_predicate_complement_attribute_object_stmtContext subject_adverbial_predicate_complement_attribute_object_stmt() {
			return getRuleContext(Subject_adverbial_predicate_complement_attribute_object_stmtContext.class,0);
		}
		public JudgeStmtContext judgeStmt() {
			return getRuleContext(JudgeStmtContext.class,0);
		}
		public SimpleStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitSimpleStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleStmtContext simpleStmt() throws RecognitionException {
		SimpleStmtContext _localctx = new SimpleStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simpleStmt);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				subject_predicate_object_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				subject_predicate_attribute_object_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				subject_adverbial_predicate_attribute_object_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				subject_adverbial_predicate_complement_attribute_object_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				judgeStmt(0);
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
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public AdverbialContext adverbial() {
			return getRuleContext(AdverbialContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LanguageParser.Comma, 0); }
		public ConcurrentStmtContext concurrentStmt() {
			return getRuleContext(ConcurrentStmtContext.class,0);
		}
		public ComplexStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitComplexStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexStmtContext complexStmt() throws RecognitionException {
		ComplexStmtContext _localctx = new ComplexStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_complexStmt);
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << At) | (1L << Make) | (1L << From))) != 0)) {
					{
					setState(77);
					adverbial();
					setState(78);
					match(Comma);
					}
				}

				setState(82);
				ifStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				concurrentStmt();
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

	public static class Subject_predicate_object_stmtContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public Subject_predicate_object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject_predicate_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitSubject_predicate_object_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subject_predicate_object_stmtContext subject_predicate_object_stmt() throws RecognitionException {
		Subject_predicate_object_stmtContext _localctx = new Subject_predicate_object_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_subject_predicate_object_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Me || _la==Identifier) {
				{
				setState(86);
				subject();
				}
			}

			setState(89);
			predicate();
			setState(90);
			object(0);
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

	public static class Subject_predicate_attribute_object_stmtContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public Subject_predicate_attribute_object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject_predicate_attribute_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitSubject_predicate_attribute_object_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subject_predicate_attribute_object_stmtContext subject_predicate_attribute_object_stmt() throws RecognitionException {
		Subject_predicate_attribute_object_stmtContext _localctx = new Subject_predicate_attribute_object_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subject_predicate_attribute_object_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Me || _la==Identifier) {
				{
				setState(92);
				subject();
				}
			}

			setState(95);
			predicate();
			setState(96);
			attribute();
			setState(97);
			object(0);
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

	public static class Subject_adverbial_predicate_attribute_object_stmtContext extends ParserRuleContext {
		public AdverbialContext adverbial() {
			return getRuleContext(AdverbialContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LanguageParser.Comma, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public Subject_adverbial_predicate_attribute_object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject_adverbial_predicate_attribute_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitSubject_adverbial_predicate_attribute_object_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subject_adverbial_predicate_attribute_object_stmtContext subject_adverbial_predicate_attribute_object_stmt() throws RecognitionException {
		Subject_adverbial_predicate_attribute_object_stmtContext _localctx = new Subject_adverbial_predicate_attribute_object_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_subject_adverbial_predicate_attribute_object_stmt);
		int _la;
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				adverbial();
				setState(100);
				match(Comma);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Me || _la==Identifier) {
					{
					setState(101);
					subject();
					}
				}

				setState(104);
				predicate();
				setState(106);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(105);
					attribute();
					}
					break;
				}
				setState(108);
				object(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Me || _la==Identifier) {
					{
					setState(110);
					subject();
					}
				}

				setState(113);
				adverbial();
				setState(114);
				predicate();
				setState(116);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(115);
					attribute();
					}
					break;
				}
				setState(118);
				object(0);
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

	public static class Subject_adverbial_predicate_complement_attribute_object_stmtContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ComplementContext complement() {
			return getRuleContext(ComplementContext.class,0);
		}
		public AdverbialContext adverbial() {
			return getRuleContext(AdverbialContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LanguageParser.Comma, 0); }
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public Subject_adverbial_predicate_complement_attribute_object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject_adverbial_predicate_complement_attribute_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitSubject_adverbial_predicate_complement_attribute_object_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subject_adverbial_predicate_complement_attribute_object_stmtContext subject_adverbial_predicate_complement_attribute_object_stmt() throws RecognitionException {
		Subject_adverbial_predicate_complement_attribute_object_stmtContext _localctx = new Subject_adverbial_predicate_complement_attribute_object_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_subject_adverbial_predicate_complement_attribute_object_stmt);
		int _la;
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << At) | (1L << Make) | (1L << From))) != 0)) {
					{
					setState(122);
					adverbial();
					setState(123);
					match(Comma);
					}
				}

				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Me || _la==Identifier) {
					{
					setState(127);
					subject();
					}
				}

				setState(130);
				predicate();
				setState(132);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(131);
					attribute();
					}
					break;
				}
				setState(134);
				object(0);
				setState(135);
				complement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Me || _la==Identifier) {
					{
					setState(137);
					subject();
					}
				}

				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << At) | (1L << Make) | (1L << From))) != 0)) {
					{
					setState(140);
					adverbial();
					}
				}

				setState(143);
				predicate();
				setState(145);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(144);
					attribute();
					}
					break;
				}
				setState(147);
				object(0);
				setState(148);
				complement();
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(LanguageParser.If, 0); }
		public JudgeStmtContext judgeStmt() {
			return getRuleContext(JudgeStmtContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(LanguageParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(LanguageParser.Comma, i);
		}
		public TerminalNode Then() { return getToken(LanguageParser.Then, 0); }
		public List<SimpleStmtContext> simpleStmt() {
			return getRuleContexts(SimpleStmtContext.class);
		}
		public SimpleStmtContext simpleStmt(int i) {
			return getRuleContext(SimpleStmtContext.class,i);
		}
		public TerminalNode Else() { return getToken(LanguageParser.Else, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(If);
			setState(153);
			judgeStmt(0);
			setState(154);
			match(Comma);
			setState(155);
			match(Then);
			setState(156);
			simpleStmt();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(157);
				match(Comma);
				setState(158);
				match(Else);
				setState(159);
				simpleStmt();
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

	public static class ConcurrentStmtContext extends ParserRuleContext {
		public List<SimpleStmtContext> simpleStmt() {
			return getRuleContexts(SimpleStmtContext.class);
		}
		public SimpleStmtContext simpleStmt(int i) {
			return getRuleContext(SimpleStmtContext.class,i);
		}
		public TerminalNode Comma() { return getToken(LanguageParser.Comma, 0); }
		public TerminalNode Concurrent() { return getToken(LanguageParser.Concurrent, 0); }
		public ConcurrentStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concurrentStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitConcurrentStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcurrentStmtContext concurrentStmt() throws RecognitionException {
		ConcurrentStmtContext _localctx = new ConcurrentStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_concurrentStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			simpleStmt();
			setState(163);
			match(Comma);
			setState(164);
			match(Concurrent);
			setState(165);
			simpleStmt();
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

	public static class JudgeStmtContext extends ParserRuleContext {
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public IsExistContext isExist() {
			return getRuleContext(IsExistContext.class,0);
		}
		public NotExistContext notExist() {
			return getRuleContext(NotExistContext.class,0);
		}
		public List<JudgeStmtContext> judgeStmt() {
			return getRuleContexts(JudgeStmtContext.class);
		}
		public JudgeStmtContext judgeStmt(int i) {
			return getRuleContext(JudgeStmtContext.class,i);
		}
		public Logic_operatorContext logic_operator() {
			return getRuleContext(Logic_operatorContext.class,0);
		}
		public JudgeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_judgeStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitJudgeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JudgeStmtContext judgeStmt() throws RecognitionException {
		return judgeStmt(0);
	}

	private JudgeStmtContext judgeStmt(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		JudgeStmtContext _localctx = new JudgeStmtContext(_ctx, _parentState);
		JudgeStmtContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_judgeStmt, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(168);
				object(0);
				setState(169);
				comparator();
				setState(170);
				object(0);
				}
				break;
			case 2:
				{
				setState(172);
				object(0);
				setState(173);
				isExist();
				}
				break;
			case 3:
				{
				setState(175);
				object(0);
				setState(176);
				notExist();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new JudgeStmtContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_judgeStmt);
					setState(180);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(181);
					logic_operator();
					setState(182);
					judgeStmt(2);
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class SubjectContext extends ParserRuleContext {
		public TerminalNode Me() { return getToken(LanguageParser.Me, 0); }
		public TerminalNode Identifier() { return getToken(LanguageParser.Identifier, 0); }
		public SubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitSubject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubjectContext subject() throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_subject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if ( !(_la==Me || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)== Token.EOF ) matchedEOF = true;
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
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
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

	public static class ObjectContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(LanguageParser.Number, 0); }
		public TerminalNode String() { return getToken(LanguageParser.String, 0); }
		public TerminalNode Identifier() { return getToken(LanguageParser.Identifier, 0); }
		public NounContext noun() {
			return getRuleContext(NounContext.class,0);
		}
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public TerminalNode With() { return getToken(LanguageParser.With, 0); }
		public TerminalNode Of() { return getToken(LanguageParser.Of, 0); }
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		return object(0);
	}

	private ObjectContext object(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ObjectContext _localctx = new ObjectContext(_ctx, _parentState);
		ObjectContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_object, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				{
				setState(194);
				match(Number);
				}
				break;
			case String:
				{
				setState(195);
				match(String);
				}
				break;
			case Identifier:
				{
				setState(196);
				match(Identifier);
				}
				break;
			case Organization:
			case Department:
			case ParentDepartment:
			case SuperiorDepartment:
			case SubDepartment:
			case Band:
			case ParentBand:
			case SubBand:
			case Position:
			case Member:
			case Tool:
			case Role:
			case Authority:
			case Reader:
			case Writer:
			case Speaker:
			case Worker:
			case Administrator:
			case Drama:
			case File:
			case Chatroom:
			case MaxAuthority:
			case MinAuthority:
			case Deadline:
			case NewStaff:
			case SeniorStaff:
				{
				setState(197);
				noun();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(206);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ObjectContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_object);
						setState(200);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(201);
						match(With);
						setState(202);
						object(7);
						}
						break;
					case 2:
						{
						_localctx = new ObjectContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_object);
						setState(203);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(204);
						match(Of);
						setState(205);
						object(6);
						}
						break;
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class AttributeContext extends ParserRuleContext {
		public AdjectiveContext adjective() {
			return getRuleContext(AdjectiveContext.class,0);
		}
		public TerminalNode String() { return getToken(LanguageParser.String, 0); }
		public TerminalNode Identifier() { return getToken(LanguageParser.Identifier, 0); }
		public NounContext noun() {
			return getRuleContext(NounContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_attribute);
		try {
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Incumbent:
			case Leaved:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				adjective();
				}
				break;
			case String:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(String);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
				match(Identifier);
				}
				break;
			case Organization:
			case Department:
			case ParentDepartment:
			case SuperiorDepartment:
			case SubDepartment:
			case Band:
			case ParentBand:
			case SubBand:
			case Position:
			case Member:
			case Tool:
			case Role:
			case Authority:
			case Reader:
			case Writer:
			case Speaker:
			case Worker:
			case Administrator:
			case Drama:
			case File:
			case Chatroom:
			case MaxAuthority:
			case MinAuthority:
			case Deadline:
			case NewStaff:
			case SeniorStaff:
				enterOuterAlt(_localctx, 4);
				{
				setState(214);
				noun();
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
		public Preposition_objectContext preposition_object() {
			return getRuleContext(Preposition_objectContext.class,0);
		}
		public AdverbialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adverbial; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitAdverbial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdverbialContext adverbial() throws RecognitionException {
		AdverbialContext _localctx = new AdverbialContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_adverbial);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				place_adverbial();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				preposition_object();
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

	public static class ComplementContext extends ParserRuleContext {
		public Time_complementContext time_complement() {
			return getRuleContext(Time_complementContext.class,0);
		}
		public DirectionContext direction() {
			return getRuleContext(DirectionContext.class,0);
		}
		public ComplementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitComplement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplementContext complement() throws RecognitionException {
		ComplementContext _localctx = new ComplementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_complement);
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				time_complement();
				}
				break;
			case Inside:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				direction();
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

	public static class Place_adverbialContext extends ParserRuleContext {
		public PrepositionContext preposition() {
			return getRuleContext(PrepositionContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public DirectionContext direction() {
			return getRuleContext(DirectionContext.class,0);
		}
		public Place_adverbialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_place_adverbial; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitPlace_adverbial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Place_adverbialContext place_adverbial() throws RecognitionException {
		Place_adverbialContext _localctx = new Place_adverbialContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_place_adverbial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			preposition();
			setState(226);
			object(0);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Inside) {
				{
				setState(227);
				direction();
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

	public static class Preposition_objectContext extends ParserRuleContext {
		public PrepositionContext preposition() {
			return getRuleContext(PrepositionContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public Place_adverbialContext place_adverbial() {
			return getRuleContext(Place_adverbialContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public Preposition_objectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preposition_object; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitPreposition_object(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Preposition_objectContext preposition_object() throws RecognitionException {
		Preposition_objectContext _localctx = new Preposition_objectContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_preposition_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(230);
				place_adverbial();
				}
				break;
			}
			setState(233);
			preposition();
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(234);
				attribute();
				}
				break;
			}
			setState(237);
			object(0);
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

	public static class IsExistContext extends ParserRuleContext {
		public TerminalNode Exist() { return getToken(LanguageParser.Exist, 0); }
		public IsExistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isExist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitIsExist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsExistContext isExist() throws RecognitionException {
		IsExistContext _localctx = new IsExistContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_isExist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(Exist);
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

	public static class NotExistContext extends ParserRuleContext {
		public TerminalNode NotExist() { return getToken(LanguageParser.NotExist, 0); }
		public NotExistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitNotExist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExistContext notExist() throws RecognitionException {
		NotExistContext _localctx = new NotExistContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_notExist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(NotExist);
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

	public static class Time_complementContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(LanguageParser.Number, 0); }
		public TerminalNode TimeUnit() { return getToken(LanguageParser.TimeUnit, 0); }
		public TerminalNode Quantifier() { return getToken(LanguageParser.Quantifier, 0); }
		public Time_complementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_complement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitTime_complement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_complementContext time_complement() throws RecognitionException {
		Time_complementContext _localctx = new Time_complementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_time_complement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(Number);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Quantifier) {
				{
				setState(244);
				match(Quantifier);
				}
			}

			setState(247);
			match(TimeUnit);
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

	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode MoreThan() { return getToken(LanguageParser.MoreThan, 0); }
		public TerminalNode LessThan() { return getToken(LanguageParser.LessThan, 0); }
		public TerminalNode Equals() { return getToken(LanguageParser.Equals, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MoreThan) | (1L << LessThan) | (1L << Equals))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)== Token.EOF ) matchedEOF = true;
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

	public static class Logic_operatorContext extends ParserRuleContext {
		public TerminalNode And() { return getToken(LanguageParser.And, 0); }
		public TerminalNode Or() { return getToken(LanguageParser.Or, 0); }
		public Logic_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitLogic_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_operatorContext logic_operator() throws RecognitionException {
		Logic_operatorContext _localctx = new Logic_operatorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logic_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !(_la==And || _la==Or) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)== Token.EOF ) matchedEOF = true;
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

	public static class NounContext extends ParserRuleContext {
		public TerminalNode Organization() { return getToken(LanguageParser.Organization, 0); }
		public TerminalNode Department() { return getToken(LanguageParser.Department, 0); }
		public TerminalNode SubDepartment() { return getToken(LanguageParser.SubDepartment, 0); }
		public TerminalNode Band() { return getToken(LanguageParser.Band, 0); }
		public TerminalNode Position() { return getToken(LanguageParser.Position, 0); }
		public TerminalNode Role() { return getToken(LanguageParser.Role, 0); }
		public TerminalNode Member() { return getToken(LanguageParser.Member, 0); }
		public TerminalNode Tool() { return getToken(LanguageParser.Tool, 0); }
		public TerminalNode MaxAuthority() { return getToken(LanguageParser.MaxAuthority, 0); }
		public TerminalNode MinAuthority() { return getToken(LanguageParser.MinAuthority, 0); }
		public TerminalNode Deadline() { return getToken(LanguageParser.Deadline, 0); }
		public TerminalNode Reader() { return getToken(LanguageParser.Reader, 0); }
		public TerminalNode Writer() { return getToken(LanguageParser.Writer, 0); }
		public TerminalNode Speaker() { return getToken(LanguageParser.Speaker, 0); }
		public TerminalNode Worker() { return getToken(LanguageParser.Worker, 0); }
		public TerminalNode Administrator() { return getToken(LanguageParser.Administrator, 0); }
		public TerminalNode Drama() { return getToken(LanguageParser.Drama, 0); }
		public TerminalNode File() { return getToken(LanguageParser.File, 0); }
		public TerminalNode Chatroom() { return getToken(LanguageParser.Chatroom, 0); }
		public TerminalNode SuperiorDepartment() { return getToken(LanguageParser.SuperiorDepartment, 0); }
		public TerminalNode ParentDepartment() { return getToken(LanguageParser.ParentDepartment, 0); }
		public TerminalNode ParentBand() { return getToken(LanguageParser.ParentBand, 0); }
		public TerminalNode SubBand() { return getToken(LanguageParser.SubBand, 0); }
		public TerminalNode Authority() { return getToken(LanguageParser.Authority, 0); }
		public TerminalNode NewStaff() { return getToken(LanguageParser.NewStaff, 0); }
		public TerminalNode SeniorStaff() { return getToken(LanguageParser.SeniorStaff, 0); }
		public NounContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitNoun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NounContext noun() throws RecognitionException {
		NounContext _localctx = new NounContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_noun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Organization) | (1L << Department) | (1L << ParentDepartment) | (1L << SuperiorDepartment) | (1L << SubDepartment) | (1L << Band) | (1L << ParentBand) | (1L << SubBand) | (1L << Position) | (1L << Member) | (1L << Tool) | (1L << Role) | (1L << Authority) | (1L << Reader) | (1L << Writer) | (1L << Speaker) | (1L << Worker) | (1L << Administrator) | (1L << Drama) | (1L << File) | (1L << Chatroom) | (1L << MaxAuthority) | (1L << MinAuthority) | (1L << Deadline) | (1L << NewStaff) | (1L << SeniorStaff))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)== Token.EOF ) matchedEOF = true;
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
		public TerminalNode Establish() { return getToken(LanguageParser.Establish, 0); }
		public TerminalNode Join() { return getToken(LanguageParser.Join, 0); }
		public TerminalNode Delete() { return getToken(LanguageParser.Delete, 0); }
		public TerminalNode Accept() { return getToken(LanguageParser.Accept, 0); }
		public TerminalNode Grant() { return getToken(LanguageParser.Grant, 0); }
		public TerminalNode Publish() { return getToken(LanguageParser.Publish, 0); }
		public TerminalNode Dispatch() { return getToken(LanguageParser.Dispatch, 0); }
		public TerminalNode SendMsg() { return getToken(LanguageParser.SendMsg, 0); }
		public TerminalNode Show() { return getToken(LanguageParser.Show, 0); }
		public TerminalNode Edit() { return getToken(LanguageParser.Edit, 0); }
		public TerminalNode Disable() { return getToken(LanguageParser.Disable, 0); }
		public TerminalNode Enable() { return getToken(LanguageParser.Enable, 0); }
		public TerminalNode Appear() { return getToken(LanguageParser.Appear, 0); }
		public TerminalNode Have() { return getToken(LanguageParser.Have, 0); }
		public TerminalNode Merge() { return getToken(LanguageParser.Merge, 0); }
		public TerminalNode Change() { return getToken(LanguageParser.Change, 0); }
		public TerminalNode Set() { return getToken(LanguageParser.Set, 0); }
		public TerminalNode Move() { return getToken(LanguageParser.Move, 0); }
		public TerminalNode Revoke() { return getToken(LanguageParser.Revoke, 0); }
		public TerminalNode CancelPub() { return getToken(LanguageParser.CancelPub, 0); }
		public TerminalNode Appoint() { return getToken(LanguageParser.Appoint, 0); }
		public VerbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitVerb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerbContext verb() throws RecognitionException {
		VerbContext _localctx = new VerbContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_verb);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Show) | (1L << Establish) | (1L << Join) | (1L << Revoke) | (1L << Set) | (1L << Change) | (1L << Edit) | (1L << Delete) | (1L << Merge) | (1L << Move) | (1L << Appoint) | (1L << Grant) | (1L << Disable) | (1L << Enable) | (1L << SendMsg) | (1L << Accept) | (1L << Dispatch) | (1L << Publish) | (1L << CancelPub) | (1L << Appear) | (1L << Have))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)== Token.EOF ) matchedEOF = true;
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

	public static class AdjectiveContext extends ParserRuleContext {
		public TerminalNode Incumbent() { return getToken(LanguageParser.Incumbent, 0); }
		public TerminalNode Leaved() { return getToken(LanguageParser.Leaved, 0); }
		public AdjectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adjective; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitAdjective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdjectiveContext adjective() throws RecognitionException {
		AdjectiveContext _localctx = new AdjectiveContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_adjective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !(_la==Incumbent || _la==Leaved) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)== Token.EOF ) matchedEOF = true;
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

	public static class PrepositionContext extends ParserRuleContext {
		public TerminalNode At() { return getToken(LanguageParser.At, 0); }
		public TerminalNode Make() { return getToken(LanguageParser.Make, 0); }
		public TerminalNode From() { return getToken(LanguageParser.From, 0); }
		public PrepositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preposition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitPreposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrepositionContext preposition() throws RecognitionException {
		PrepositionContext _localctx = new PrepositionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_preposition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << At) | (1L << Make) | (1L << From))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)== Token.EOF ) matchedEOF = true;
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

	public static class DirectionContext extends ParserRuleContext {
		public TerminalNode Inside() { return getToken(LanguageParser.Inside, 0); }
		public DirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor) return ((LanguageVisitor<? extends T>)visitor).visitDirection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectionContext direction() throws RecognitionException {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_direction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(Inside);
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
		case 10:
			return judgeStmt_sempred((JudgeStmtContext)_localctx, predIndex);
		case 13:
			return object_sempred((ObjectContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean judgeStmt_sempred(JudgeStmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean object_sempred(ObjectContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3O\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\5\2?\n\2\6"+
		"\2A\n\2\r\2\16\2B\3\3\3\3\5\3G\n\3\3\4\3\4\3\4\3\4\3\4\5\4N\n\4\3\5\3"+
		"\5\3\5\5\5S\n\5\3\5\3\5\5\5W\n\5\3\6\5\6Z\n\6\3\6\3\6\3\6\3\7\5\7`\n\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bi\n\b\3\b\3\b\5\bm\n\b\3\b\3\b\3\b\5\b"+
		"r\n\b\3\b\3\b\3\b\5\bw\n\b\3\b\3\b\5\b{\n\b\3\t\3\t\3\t\5\t\u0080\n\t"+
		"\3\t\5\t\u0083\n\t\3\t\3\t\5\t\u0087\n\t\3\t\3\t\3\t\3\t\5\t\u008d\n\t"+
		"\3\t\5\t\u0090\n\t\3\t\3\t\5\t\u0094\n\t\3\t\3\t\3\t\5\t\u0099\n\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a3\n\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b5\n\f\3\f\3\f\3\f\3"+
		"\f\7\f\u00bb\n\f\f\f\16\f\u00be\13\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u00c9\n\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00d1\n"+
		"\17\f\17\16\17\u00d4\13\17\3\20\3\20\3\20\3\20\5\20\u00da\n\20\3\21\3"+
		"\21\5\21\u00de\n\21\3\22\3\22\5\22\u00e2\n\22\3\23\3\23\3\23\5\23\u00e7"+
		"\n\23\3\24\5\24\u00ea\n\24\3\24\3\24\5\24\u00ee\n\24\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\5\27\u00f8\n\27\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\2\4\26\34\37\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\t\4\2\67"+
		"\67MM\3\2=?\3\2@A\3\2\3\34\5\2\35\')\60\63\64\3\2\65\66\3\28:\2\u0115"+
		"\2@\3\2\2\2\4F\3\2\2\2\6M\3\2\2\2\bV\3\2\2\2\nY\3\2\2\2\f_\3\2\2\2\16"+
		"z\3\2\2\2\20\u0098\3\2\2\2\22\u009a\3\2\2\2\24\u00a4\3\2\2\2\26\u00b4"+
		"\3\2\2\2\30\u00bf\3\2\2\2\32\u00c1\3\2\2\2\34\u00c8\3\2\2\2\36\u00d9\3"+
		"\2\2\2 \u00dd\3\2\2\2\"\u00e1\3\2\2\2$\u00e3\3\2\2\2&\u00e9\3\2\2\2(\u00f1"+
		"\3\2\2\2*\u00f3\3\2\2\2,\u00f5\3\2\2\2.\u00fb\3\2\2\2\60\u00fd\3\2\2\2"+
		"\62\u00ff\3\2\2\2\64\u0101\3\2\2\2\66\u0103\3\2\2\28\u0105\3\2\2\2:\u0107"+
		"\3\2\2\2<>\5\4\3\2=?\7J\2\2>=\3\2\2\2>?\3\2\2\2?A\3\2\2\2@<\3\2\2\2AB"+
		"\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\3\3\2\2\2DG\5\6\4\2EG\5\b\5\2FD\3\2\2\2"+
		"FE\3\2\2\2G\5\3\2\2\2HN\5\n\6\2IN\5\f\7\2JN\5\16\b\2KN\5\20\t\2LN\5\26"+
		"\f\2MH\3\2\2\2MI\3\2\2\2MJ\3\2\2\2MK\3\2\2\2ML\3\2\2\2N\7\3\2\2\2OP\5"+
		" \21\2PQ\7I\2\2QS\3\2\2\2RO\3\2\2\2RS\3\2\2\2ST\3\2\2\2TW\5\22\n\2UW\5"+
		"\24\13\2VR\3\2\2\2VU\3\2\2\2W\t\3\2\2\2XZ\5\30\r\2YX\3\2\2\2YZ\3\2\2\2"+
		"Z[\3\2\2\2[\\\5\32\16\2\\]\5\34\17\2]\13\3\2\2\2^`\5\30\r\2_^\3\2\2\2"+
		"_`\3\2\2\2`a\3\2\2\2ab\5\32\16\2bc\5\36\20\2cd\5\34\17\2d\r\3\2\2\2ef"+
		"\5 \21\2fh\7I\2\2gi\5\30\r\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jl\5\32\16\2"+
		"km\5\36\20\2lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\5\34\17\2o{\3\2\2\2pr\5\30"+
		"\r\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\5 \21\2tv\5\32\16\2uw\5\36\20\2v"+
		"u\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\5\34\17\2y{\3\2\2\2ze\3\2\2\2zq\3\2\2"+
		"\2{\17\3\2\2\2|}\5 \21\2}~\7I\2\2~\u0080\3\2\2\2\177|\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0082\3\2\2\2\u0081\u0083\5\30\r\2\u0082\u0081\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\5\32\16\2\u0085\u0087"+
		"\5\36\20\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2"+
		"\u0088\u0089\5\34\17\2\u0089\u008a\5\"\22\2\u008a\u0099\3\2\2\2\u008b"+
		"\u008d\5\30\r\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3"+
		"\2\2\2\u008e\u0090\5 \21\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0093\5\32\16\2\u0092\u0094\5\36\20\2\u0093\u0092"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\5\34\17\2"+
		"\u0096\u0097\5\"\22\2\u0097\u0099\3\2\2\2\u0098\177\3\2\2\2\u0098\u008c"+
		"\3\2\2\2\u0099\21\3\2\2\2\u009a\u009b\7E\2\2\u009b\u009c\5\26\f\2\u009c"+
		"\u009d\7I\2\2\u009d\u009e\7F\2\2\u009e\u00a2\5\6\4\2\u009f\u00a0\7I\2"+
		"\2\u00a0\u00a1\7H\2\2\u00a1\u00a3\5\6\4\2\u00a2\u009f\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\23\3\2\2\2\u00a4\u00a5\5\6\4\2\u00a5\u00a6\7I\2\2\u00a6"+
		"\u00a7\7G\2\2\u00a7\u00a8\5\6\4\2\u00a8\25\3\2\2\2\u00a9\u00aa\b\f\1\2"+
		"\u00aa\u00ab\5\34\17\2\u00ab\u00ac\5.\30\2\u00ac\u00ad\5\34\17\2\u00ad"+
		"\u00b5\3\2\2\2\u00ae\u00af\5\34\17\2\u00af\u00b0\5(\25\2\u00b0\u00b5\3"+
		"\2\2\2\u00b1\u00b2\5\34\17\2\u00b2\u00b3\5*\26\2\u00b3\u00b5\3\2\2\2\u00b4"+
		"\u00a9\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b5\u00bc\3\2"+
		"\2\2\u00b6\u00b7\f\3\2\2\u00b7\u00b8\5\60\31\2\u00b8\u00b9\5\26\f\4\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00b6\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\27\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0"+
		"\t\2\2\2\u00c0\31\3\2\2\2\u00c1\u00c2\5\64\33\2\u00c2\33\3\2\2\2\u00c3"+
		"\u00c4\b\17\1\2\u00c4\u00c9\7K\2\2\u00c5\u00c9\7L\2\2\u00c6\u00c9\7M\2"+
		"\2\u00c7\u00c9\5\62\32\2\u00c8\u00c3\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00d2\3\2\2\2\u00ca\u00cb\f\b"+
		"\2\2\u00cb\u00cc\7C\2\2\u00cc\u00d1\5\34\17\t\u00cd\u00ce\f\7\2\2\u00ce"+
		"\u00cf\7D\2\2\u00cf\u00d1\5\34\17\b\u00d0\u00ca\3\2\2\2\u00d0\u00cd\3"+
		"\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\35\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00da\5\66\34\2\u00d6\u00da\7L\2"+
		"\2\u00d7\u00da\7M\2\2\u00d8\u00da\5\62\32\2\u00d9\u00d5\3\2\2\2\u00d9"+
		"\u00d6\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\37\3\2\2"+
		"\2\u00db\u00de\5$\23\2\u00dc\u00de\5&\24\2\u00dd\u00db\3\2\2\2\u00dd\u00dc"+
		"\3\2\2\2\u00de!\3\2\2\2\u00df\u00e2\5,\27\2\u00e0\u00e2\5:\36\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2#\3\2\2\2\u00e3\u00e4\58\35\2"+
		"\u00e4\u00e6\5\34\17\2\u00e5\u00e7\5:\36\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7%\3\2\2\2\u00e8\u00ea\5$\23\2\u00e9\u00e8\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\58\35\2\u00ec\u00ee\5\36"+
		"\20\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\5\34\17\2\u00f0\'\3\2\2\2\u00f1\u00f2\7\61\2\2\u00f2)\3\2\2\2\u00f3"+
		"\u00f4\7\62\2\2\u00f4+\3\2\2\2\u00f5\u00f7\7K\2\2\u00f6\u00f8\7;\2\2\u00f7"+
		"\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\7<"+
		"\2\2\u00fa-\3\2\2\2\u00fb\u00fc\t\3\2\2\u00fc/\3\2\2\2\u00fd\u00fe\t\4"+
		"\2\2\u00fe\61\3\2\2\2\u00ff\u0100\t\5\2\2\u0100\63\3\2\2\2\u0101\u0102"+
		"\t\6\2\2\u0102\65\3\2\2\2\u0103\u0104\t\7\2\2\u0104\67\3\2\2\2\u0105\u0106"+
		"\t\b\2\2\u01069\3\2\2\2\u0107\u0108\7B\2\2\u0108;\3\2\2\2#>BFMRVY_hlq"+
		"vz\177\u0082\u0086\u008c\u008f\u0093\u0098\u00a2\u00b4\u00bc\u00c8\u00d0"+
		"\u00d2\u00d9\u00dd\u00e1\u00e6\u00e9\u00ed\u00f7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}