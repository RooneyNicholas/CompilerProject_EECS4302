// Generated from java-escape by ANTLR 4.11.1

	package antlrTest;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		BOOL=25, BOOL_TYPE=26, INT32_TYPE=27, DOUBLE_TYPE=28, ID=29, INTEGER_NUMBER=30, 
		REAL_NUMBER=31, COMMENT=32, WS=33;
	public static final int
		RULE_testProg = 0, RULE_testDecl = 1, RULE_varDecl = 2, RULE_check = 3, 
		RULE_expr = 4, RULE_operator = 5, RULE_arithmeticOp = 6, RULE_logicalOp = 7, 
		RULE_relationalOp = 8, RULE_function_call = 9, RULE_type = 10, RULE_number = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"testProg", "testDecl", "varDecl", "check", "expr", "operator", "arithmeticOp", 
			"logicalOp", "relationalOp", "function_call", "type", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Test'", "':'", "'='", "'check'", "'if'", "'('", "')'", "'{'", 
			"'}'", "'*'", "'+'", "'-'", "'/'", "'&'", "'|'", "'^'", "'&&'", "'||'", 
			"'>'", "'<'", "'<='", "'>='", "'=='", "','", null, "'bool'", "'int32'", 
			"'double'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "BOOL", "BOOL_TYPE", "INT32_TYPE", "DOUBLE_TYPE", "ID", "INTEGER_NUMBER", 
			"REAL_NUMBER", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TestProgContext extends ParserRuleContext {
		public TestProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testProg; }
	 
		public TestProgContext() { }
		public void copyFrom(TestProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TestProgramContext extends TestProgContext {
		public TerminalNode EOF() { return getToken(TestParser.EOF, 0); }
		public List<TestDeclContext> testDecl() {
			return getRuleContexts(TestDeclContext.class);
		}
		public TestDeclContext testDecl(int i) {
			return getRuleContext(TestDeclContext.class,i);
		}
		public TestProgramContext(TestProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterTestProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitTestProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitTestProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestProgContext testProg() throws RecognitionException {
		TestProgContext _localctx = new TestProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_testProg);
		int _la;
		try {
			_localctx = new TestProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				testDecl();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(29);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TestDeclContext extends ParserRuleContext {
		public TestDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testDecl; }
	 
		public TestDeclContext() { }
		public void copyFrom(TestDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TestDeclarationContext extends TestDeclContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public CheckContext check() {
			return getRuleContext(CheckContext.class,0);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TestDeclarationContext(TestDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterTestDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitTestDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitTestDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestDeclContext testDecl() throws RecognitionException {
		TestDeclContext _localctx = new TestDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_testDecl);
		int _la;
		try {
			_localctx = new TestDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__0);
			setState(32);
			match(ID);
			setState(33);
			match(T__1);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1006632992L) != 0) {
				{
				setState(36);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_TYPE:
				case INT32_TYPE:
				case DOUBLE_TYPE:
					{
					setState(34);
					varDecl();
					}
					break;
				case T__4:
				case ID:
					{
					setState(35);
					expr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			check();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	 
		public VarDeclContext() { }
		public void copyFrom(VarDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InitializedDeclarationContext extends VarDeclContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public InitializedDeclarationContext(VarDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterInitializedDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitInitializedDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitInitializedDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UninitializedDeclarationContext extends VarDeclContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public UninitializedDeclarationContext(VarDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterUninitializedDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitUninitializedDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitUninitializedDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDecl);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new UninitializedDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				type();
				setState(44);
				match(ID);
				}
				break;
			case 2:
				_localctx = new InitializedDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				type();
				setState(47);
				match(ID);
				setState(48);
				match(T__2);
				setState(51);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(49);
					operator();
					}
					break;
				case 2:
					{
					setState(50);
					function_call();
					}
					break;
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class CheckContext extends ParserRuleContext {
		public CheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check; }
	 
		public CheckContext() { }
		public void copyFrom(CheckContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CheckStatementContext extends CheckContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public CheckStatementContext(CheckContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterCheckStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitCheckStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitCheckStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckContext check() throws RecognitionException {
		CheckContext _localctx = new CheckContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_check);
		try {
			_localctx = new CheckStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__3);
			setState(56);
			function_call();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoReturnFunctionContext extends ExprContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public NoReturnFunctionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterNoReturnFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitNoReturnFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitNoReturnFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfConditionalContext extends ExprContext {
		public LogicalOpContext logicalOp() {
			return getRuleContext(LogicalOpContext.class,0);
		}
		public RelationalOpContext relationalOp() {
			return getRuleContext(RelationalOpContext.class,0);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfConditionalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterIfConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitIfConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitIfConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperationContext extends ExprContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public OperationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		int _la;
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new OperationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(ID);
				setState(59);
				match(T__2);
				setState(62);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(60);
					operator();
					}
					break;
				case 2:
					{
					setState(61);
					function_call();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new IfConditionalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(T__4);
				setState(65);
				match(T__5);
				setState(68);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(66);
					logicalOp(0);
					}
					break;
				case 2:
					{
					setState(67);
					relationalOp();
					}
					break;
				}
				setState(70);
				match(T__6);
				setState(71);
				match(T__7);
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(74);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BOOL_TYPE:
					case INT32_TYPE:
					case DOUBLE_TYPE:
						{
						setState(72);
						varDecl();
						}
						break;
					case T__4:
					case ID:
						{
						setState(73);
						expr();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(76); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1006632992L) != 0 );
				setState(78);
				match(T__8);
				}
				break;
			case 3:
				_localctx = new NoReturnFunctionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				function_call();
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	 
		public OperatorContext() { }
		public void copyFrom(OperatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends OperatorContext {
		public RelationalOpContext relationalOp() {
			return getRuleContext(RelationalOpContext.class,0);
		}
		public RelationalContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitRelational(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalContext extends OperatorContext {
		public LogicalOpContext logicalOp() {
			return getRuleContext(LogicalOpContext.class,0);
		}
		public LogicalContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitLogical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitLogical(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNumberContext extends OperatorContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ExprNumberContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterExprNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitExprNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitExprNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVariableContext extends OperatorContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public ExprVariableContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterExprVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitExprVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitExprVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoolContext extends OperatorContext {
		public TerminalNode BOOL() { return getToken(TestParser.BOOL, 0); }
		public ExprBoolContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterExprBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitExprBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitExprBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticContext extends OperatorContext {
		public ArithmeticOpContext arithmeticOp() {
			return getRuleContext(ArithmeticOpContext.class,0);
		}
		public ArithmeticContext(OperatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitArithmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitArithmetic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operator);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new ArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				arithmeticOp(0);
				}
				break;
			case 2:
				_localctx = new LogicalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				logicalOp(0);
				}
				break;
			case 3:
				_localctx = new RelationalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				relationalOp();
				}
				break;
			case 4:
				_localctx = new ExprNumberContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				number();
				}
				break;
			case 5:
				_localctx = new ExprVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				match(ID);
				}
				break;
			case 6:
				_localctx = new ExprBoolContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				match(BOOL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticOpContext extends ParserRuleContext {
		public ArithmeticOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOp; }
	 
		public ArithmeticOpContext() { }
		public void copyFrom(ArithmeticOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationContext extends ArithmeticOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public MultiplicationContext(ArithmeticOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditionContext extends ArithmeticOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public AdditionContext(ArithmeticOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubtractionContext extends ArithmeticOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public SubtractionContext(ArithmeticOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitSubtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseOrContext extends ArithmeticOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public BitwiseOrContext(ArithmeticOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterBitwiseOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitBitwiseOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitBitwiseOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseXorContext extends ArithmeticOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public BitwiseXorContext(ArithmeticOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterBitwiseXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitBitwiseXor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitBitwiseXor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseAndContext extends ArithmeticOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public BitwiseAndContext(ArithmeticOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterBitwiseAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitBitwiseAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitBitwiseAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivisionContext extends ArithmeticOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public DivisionContext(ArithmeticOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AritmeticVariableContext extends ArithmeticOpContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public AritmeticVariableContext(ArithmeticOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterAritmeticVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitAritmeticVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitAritmeticVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticNumberContext extends ArithmeticOpContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ArithmeticNumberContext(ArithmeticOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterArithmeticNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitArithmeticNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitArithmeticNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticOpContext arithmeticOp() throws RecognitionException {
		return arithmeticOp(0);
	}

	private ArithmeticOpContext arithmeticOp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticOpContext _localctx = new ArithmeticOpContext(_ctx, _parentState);
		ArithmeticOpContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_arithmeticOp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_NUMBER:
			case REAL_NUMBER:
				{
				_localctx = new ArithmeticNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(92);
				number();
				}
				break;
			case ID:
				{
				_localctx = new AritmeticVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(117);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new ArithmeticOpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOp);
						setState(96);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(97);
						match(T__9);
						setState(98);
						arithmeticOp(10);
						}
						break;
					case 2:
						{
						_localctx = new AdditionContext(new ArithmeticOpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOp);
						setState(99);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(100);
						match(T__10);
						setState(101);
						arithmeticOp(9);
						}
						break;
					case 3:
						{
						_localctx = new SubtractionContext(new ArithmeticOpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOp);
						setState(102);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(103);
						match(T__11);
						setState(104);
						arithmeticOp(8);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new ArithmeticOpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOp);
						setState(105);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(106);
						match(T__12);
						setState(107);
						arithmeticOp(7);
						}
						break;
					case 5:
						{
						_localctx = new BitwiseAndContext(new ArithmeticOpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOp);
						setState(108);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(109);
						match(T__13);
						setState(110);
						arithmeticOp(6);
						}
						break;
					case 6:
						{
						_localctx = new BitwiseOrContext(new ArithmeticOpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOp);
						setState(111);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(112);
						match(T__14);
						setState(113);
						arithmeticOp(5);
						}
						break;
					case 7:
						{
						_localctx = new BitwiseXorContext(new ArithmeticOpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOp);
						setState(114);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(115);
						match(T__15);
						setState(116);
						arithmeticOp(4);
						}
						break;
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOpContext extends ParserRuleContext {
		public LogicalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOp; }
	 
		public LogicalOpContext() { }
		public void copyFrom(LogicalOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalVariableContext extends LogicalOpContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public LogicalVariableContext(LogicalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterLogicalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitLogicalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitLogicalVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalBoolContext extends LogicalOpContext {
		public TerminalNode BOOL() { return getToken(TestParser.BOOL, 0); }
		public LogicalBoolContext(LogicalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterLogicalBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitLogicalBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitLogicalBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndContext extends LogicalOpContext {
		public List<LogicalOpContext> logicalOp() {
			return getRuleContexts(LogicalOpContext.class);
		}
		public LogicalOpContext logicalOp(int i) {
			return getRuleContext(LogicalOpContext.class,i);
		}
		public LogicalAndContext(LogicalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterLogicalAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitLogicalAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitLogicalAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrContext extends LogicalOpContext {
		public List<LogicalOpContext> logicalOp() {
			return getRuleContexts(LogicalOpContext.class);
		}
		public LogicalOpContext logicalOp(int i) {
			return getRuleContext(LogicalOpContext.class,i);
		}
		public LogicalOrContext(LogicalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterLogicalOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitLogicalOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitLogicalOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOpContext logicalOp() throws RecognitionException {
		return logicalOp(0);
	}

	private LogicalOpContext logicalOp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalOpContext _localctx = new LogicalOpContext(_ctx, _parentState);
		LogicalOpContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_logicalOp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new LogicalVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(123);
				match(ID);
				}
				break;
			case BOOL:
				{
				_localctx = new LogicalBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(BOOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(133);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalAndContext(new LogicalOpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logicalOp);
						setState(127);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(128);
						match(T__16);
						setState(129);
						logicalOp(5);
						}
						break;
					case 2:
						{
						_localctx = new LogicalOrContext(new LogicalOpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logicalOp);
						setState(130);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(131);
						match(T__17);
						setState(132);
						logicalOp(4);
						}
						break;
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalOpContext extends ParserRuleContext {
		public RelationalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalOp; }
	 
		public RelationalOpContext() { }
		public void copyFrom(RelationalOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessOrEqualContext extends RelationalOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public LessOrEqualContext(RelationalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterLessOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitLessOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitLessOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessThanContext extends RelationalOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public LessThanContext(RelationalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualsContext extends RelationalOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public EqualsContext(RelationalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitEquals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThanContext extends RelationalOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public GreaterThanContext(RelationalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterGreaterThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitGreaterThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalVariableContext extends RelationalOpContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public RelationalVariableContext(RelationalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterRelationalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitRelationalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitRelationalVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterOrEqualContext extends RelationalOpContext {
		public List<ArithmeticOpContext> arithmeticOp() {
			return getRuleContexts(ArithmeticOpContext.class);
		}
		public ArithmeticOpContext arithmeticOp(int i) {
			return getRuleContext(ArithmeticOpContext.class,i);
		}
		public GreaterOrEqualContext(RelationalOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterGreaterOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitGreaterOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitGreaterOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalOpContext relationalOp() throws RecognitionException {
		RelationalOpContext _localctx = new RelationalOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_relationalOp);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new GreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				arithmeticOp(0);
				setState(139);
				match(T__18);
				setState(140);
				arithmeticOp(0);
				}
				break;
			case 2:
				_localctx = new LessThanContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				arithmeticOp(0);
				setState(143);
				match(T__19);
				setState(144);
				arithmeticOp(0);
				}
				break;
			case 3:
				_localctx = new LessOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				arithmeticOp(0);
				setState(147);
				match(T__20);
				setState(148);
				arithmeticOp(0);
				}
				break;
			case 4:
				_localctx = new GreaterOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				arithmeticOp(0);
				setState(151);
				match(T__21);
				setState(152);
				arithmeticOp(0);
				}
				break;
			case 5:
				_localctx = new EqualsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				arithmeticOp(0);
				setState(155);
				match(T__22);
				setState(156);
				arithmeticOp(0);
				}
				break;
			case 6:
				_localctx = new RelationalVariableContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(158);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_callContext extends ParserRuleContext {
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
	 
		public Function_callContext() { }
		public void copyFrom(Function_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends Function_callContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public FunctionCallContext(Function_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_function_call);
		int _la;
		try {
			_localctx = new FunctionCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(ID);
			setState(162);
			match(T__5);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 3791650816L) != 0) {
				{
				setState(163);
				operator();
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(164);
					match(T__23);
					setState(165);
					operator();
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(173);
			match(T__6);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BOOLContext extends TypeContext {
		public TerminalNode BOOL_TYPE() { return getToken(TestParser.BOOL_TYPE, 0); }
		public BOOLContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterBOOL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitBOOL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitBOOL(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class INT32Context extends TypeContext {
		public TerminalNode INT32_TYPE() { return getToken(TestParser.INT32_TYPE, 0); }
		public INT32Context(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterINT32(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitINT32(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitINT32(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DOUBLEContext extends TypeContext {
		public TerminalNode DOUBLE_TYPE() { return getToken(TestParser.DOUBLE_TYPE, 0); }
		public DOUBLEContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterDOUBLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitDOUBLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitDOUBLE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT32_TYPE:
				_localctx = new INT32Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(INT32_TYPE);
				}
				break;
			case DOUBLE_TYPE:
				_localctx = new DOUBLEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(DOUBLE_TYPE);
				}
				break;
			case BOOL_TYPE:
				_localctx = new BOOLContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(BOOL_TYPE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RealNumberContext extends NumberContext {
		public TerminalNode REAL_NUMBER() { return getToken(TestParser.REAL_NUMBER, 0); }
		public RealNumberContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterRealNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitRealNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitRealNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerNumberContext extends NumberContext {
		public TerminalNode INTEGER_NUMBER() { return getToken(TestParser.INTEGER_NUMBER, 0); }
		public IntegerNumberContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterIntegerNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitIntegerNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TestVisitor ) return ((TestVisitor<? extends T>)visitor).visitIntegerNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_number);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_NUMBER:
				_localctx = new IntegerNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(INTEGER_NUMBER);
				}
				break;
			case REAL_NUMBER:
				_localctx = new RealNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(REAL_NUMBER);
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
		case 6:
			return arithmeticOp_sempred((ArithmeticOpContext)_localctx, predIndex);
		case 7:
			return logicalOp_sempred((LogicalOpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmeticOp_sempred(ArithmeticOpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean logicalOp_sempred(LogicalOpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u00b9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00024\b\u0002\u0003\u00026\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004?\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004E\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0004\u0004K\b\u0004\u000b\u0004\f\u0004L\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004R\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005Z\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006_\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006v\b\u0006\n\u0006\f\u0006y\t\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007~\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0086\b\u0007"+
		"\n\u0007\f\u0007\u0089\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a0"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00a7\b\t\n\t\f\t"+
		"\u00aa\t\t\u0003\t\u00ac\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00b3\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u00b7\b\u000b\u0001\u000b"+
		"\u0000\u0002\f\u000e\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0000\u0000\u00d1\u0000\u0019\u0001\u0000\u0000\u0000\u0002"+
		"\u001f\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u00067\u0001"+
		"\u0000\u0000\u0000\bQ\u0001\u0000\u0000\u0000\nY\u0001\u0000\u0000\u0000"+
		"\f^\u0001\u0000\u0000\u0000\u000e}\u0001\u0000\u0000\u0000\u0010\u009f"+
		"\u0001\u0000\u0000\u0000\u0012\u00a1\u0001\u0000\u0000\u0000\u0014\u00b2"+
		"\u0001\u0000\u0000\u0000\u0016\u00b6\u0001\u0000\u0000\u0000\u0018\u001a"+
		"\u0003\u0002\u0001\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0005\u0000\u0000\u0001\u001e\u0001\u0001\u0000\u0000\u0000\u001f \u0005"+
		"\u0001\u0000\u0000 !\u0005\u001d\u0000\u0000!&\u0005\u0002\u0000\u0000"+
		"\"%\u0003\u0004\u0002\u0000#%\u0003\b\u0004\u0000$\"\u0001\u0000\u0000"+
		"\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000"+
		"\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000(&\u0001"+
		"\u0000\u0000\u0000)*\u0003\u0006\u0003\u0000*\u0003\u0001\u0000\u0000"+
		"\u0000+,\u0003\u0014\n\u0000,-\u0005\u001d\u0000\u0000-6\u0001\u0000\u0000"+
		"\u0000./\u0003\u0014\n\u0000/0\u0005\u001d\u0000\u000003\u0005\u0003\u0000"+
		"\u000014\u0003\n\u0005\u000024\u0003\u0012\t\u000031\u0001\u0000\u0000"+
		"\u000032\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u00005+\u0001\u0000"+
		"\u0000\u00005.\u0001\u0000\u0000\u00006\u0005\u0001\u0000\u0000\u0000"+
		"78\u0005\u0004\u0000\u000089\u0003\u0012\t\u00009\u0007\u0001\u0000\u0000"+
		"\u0000:;\u0005\u001d\u0000\u0000;>\u0005\u0003\u0000\u0000<?\u0003\n\u0005"+
		"\u0000=?\u0003\u0012\t\u0000><\u0001\u0000\u0000\u0000>=\u0001\u0000\u0000"+
		"\u0000?R\u0001\u0000\u0000\u0000@A\u0005\u0005\u0000\u0000AD\u0005\u0006"+
		"\u0000\u0000BE\u0003\u000e\u0007\u0000CE\u0003\u0010\b\u0000DB\u0001\u0000"+
		"\u0000\u0000DC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0005"+
		"\u0007\u0000\u0000GJ\u0005\b\u0000\u0000HK\u0003\u0004\u0002\u0000IK\u0003"+
		"\b\u0004\u0000JH\u0001\u0000\u0000\u0000JI\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NO\u0005\t\u0000\u0000OR\u0001\u0000\u0000\u0000"+
		"PR\u0003\u0012\t\u0000Q:\u0001\u0000\u0000\u0000Q@\u0001\u0000\u0000\u0000"+
		"QP\u0001\u0000\u0000\u0000R\t\u0001\u0000\u0000\u0000SZ\u0003\f\u0006"+
		"\u0000TZ\u0003\u000e\u0007\u0000UZ\u0003\u0010\b\u0000VZ\u0003\u0016\u000b"+
		"\u0000WZ\u0005\u001d\u0000\u0000XZ\u0005\u0019\u0000\u0000YS\u0001\u0000"+
		"\u0000\u0000YT\u0001\u0000\u0000\u0000YU\u0001\u0000\u0000\u0000YV\u0001"+
		"\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000"+
		"Z\u000b\u0001\u0000\u0000\u0000[\\\u0006\u0006\uffff\uffff\u0000\\_\u0003"+
		"\u0016\u000b\u0000]_\u0005\u001d\u0000\u0000^[\u0001\u0000\u0000\u0000"+
		"^]\u0001\u0000\u0000\u0000_w\u0001\u0000\u0000\u0000`a\n\t\u0000\u0000"+
		"ab\u0005\n\u0000\u0000bv\u0003\f\u0006\ncd\n\b\u0000\u0000de\u0005\u000b"+
		"\u0000\u0000ev\u0003\f\u0006\tfg\n\u0007\u0000\u0000gh\u0005\f\u0000\u0000"+
		"hv\u0003\f\u0006\bij\n\u0006\u0000\u0000jk\u0005\r\u0000\u0000kv\u0003"+
		"\f\u0006\u0007lm\n\u0005\u0000\u0000mn\u0005\u000e\u0000\u0000nv\u0003"+
		"\f\u0006\u0006op\n\u0004\u0000\u0000pq\u0005\u000f\u0000\u0000qv\u0003"+
		"\f\u0006\u0005rs\n\u0003\u0000\u0000st\u0005\u0010\u0000\u0000tv\u0003"+
		"\f\u0006\u0004u`\u0001\u0000\u0000\u0000uc\u0001\u0000\u0000\u0000uf\u0001"+
		"\u0000\u0000\u0000ui\u0001\u0000\u0000\u0000ul\u0001\u0000\u0000\u0000"+
		"uo\u0001\u0000\u0000\u0000ur\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x\r\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0006\u0007\uffff\uffff\u0000"+
		"{~\u0005\u001d\u0000\u0000|~\u0005\u0019\u0000\u0000}z\u0001\u0000\u0000"+
		"\u0000}|\u0001\u0000\u0000\u0000~\u0087\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\n\u0004\u0000\u0000\u0080\u0081\u0005\u0011\u0000\u0000\u0081\u0086"+
		"\u0003\u000e\u0007\u0005\u0082\u0083\n\u0003\u0000\u0000\u0083\u0084\u0005"+
		"\u0012\u0000\u0000\u0084\u0086\u0003\u000e\u0007\u0004\u0085\u007f\u0001"+
		"\u0000\u0000\u0000\u0085\u0082\u0001\u0000\u0000\u0000\u0086\u0089\u0001"+
		"\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u000f\u0001\u0000\u0000\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0003\f\u0006\u0000\u008b\u008c\u0005\u0013"+
		"\u0000\u0000\u008c\u008d\u0003\f\u0006\u0000\u008d\u00a0\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0003\f\u0006\u0000\u008f\u0090\u0005\u0014\u0000\u0000"+
		"\u0090\u0091\u0003\f\u0006\u0000\u0091\u00a0\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0003\f\u0006\u0000\u0093\u0094\u0005\u0015\u0000\u0000\u0094\u0095"+
		"\u0003\f\u0006\u0000\u0095\u00a0\u0001\u0000\u0000\u0000\u0096\u0097\u0003"+
		"\f\u0006\u0000\u0097\u0098\u0005\u0016\u0000\u0000\u0098\u0099\u0003\f"+
		"\u0006\u0000\u0099\u00a0\u0001\u0000\u0000\u0000\u009a\u009b\u0003\f\u0006"+
		"\u0000\u009b\u009c\u0005\u0017\u0000\u0000\u009c\u009d\u0003\f\u0006\u0000"+
		"\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u00a0\u0005\u001d\u0000\u0000"+
		"\u009f\u008a\u0001\u0000\u0000\u0000\u009f\u008e\u0001\u0000\u0000\u0000"+
		"\u009f\u0092\u0001\u0000\u0000\u0000\u009f\u0096\u0001\u0000\u0000\u0000"+
		"\u009f\u009a\u0001\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000"+
		"\u00a0\u0011\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u001d\u0000\u0000"+
		"\u00a2\u00ab\u0005\u0006\u0000\u0000\u00a3\u00a8\u0003\n\u0005\u0000\u00a4"+
		"\u00a5\u0005\u0018\u0000\u0000\u00a5\u00a7\u0003\n\u0005\u0000\u00a6\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ac"+
		"\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u00a3"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0007\u0000\u0000\u00ae\u0013"+
		"\u0001\u0000\u0000\u0000\u00af\u00b3\u0005\u001b\u0000\u0000\u00b0\u00b3"+
		"\u0005\u001c\u0000\u0000\u00b1\u00b3\u0005\u001a\u0000\u0000\u00b2\u00af"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b3\u0015\u0001\u0000\u0000\u0000\u00b4\u00b7"+
		"\u0005\u001e\u0000\u0000\u00b5\u00b7\u0005\u001f\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7\u0017"+
		"\u0001\u0000\u0000\u0000\u0016\u001b$&35>DJLQY^uw}\u0085\u0087\u009f\u00a8"+
		"\u00ab\u00b2\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}