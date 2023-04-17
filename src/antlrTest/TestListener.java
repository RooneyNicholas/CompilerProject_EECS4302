// Generated from java-escape by ANTLR 4.11.1

	package antlrTest;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code TestProgram}
	 * labeled alternative in {@link TestParser#testProg}.
	 * @param ctx the parse tree
	 */
	void enterTestProgram(TestParser.TestProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestProgram}
	 * labeled alternative in {@link TestParser#testProg}.
	 * @param ctx the parse tree
	 */
	void exitTestProgram(TestParser.TestProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestDeclaration}
	 * labeled alternative in {@link TestParser#testDecl}.
	 * @param ctx the parse tree
	 */
	void enterTestDeclaration(TestParser.TestDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestDeclaration}
	 * labeled alternative in {@link TestParser#testDecl}.
	 * @param ctx the parse tree
	 */
	void exitTestDeclaration(TestParser.TestDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UninitializedDeclaration}
	 * labeled alternative in {@link TestParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterUninitializedDeclaration(TestParser.UninitializedDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UninitializedDeclaration}
	 * labeled alternative in {@link TestParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitUninitializedDeclaration(TestParser.UninitializedDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InitializedDeclaration}
	 * labeled alternative in {@link TestParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterInitializedDeclaration(TestParser.InitializedDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InitializedDeclaration}
	 * labeled alternative in {@link TestParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitInitializedDeclaration(TestParser.InitializedDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CheckStatement}
	 * labeled alternative in {@link TestParser#check}.
	 * @param ctx the parse tree
	 */
	void enterCheckStatement(TestParser.CheckStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CheckStatement}
	 * labeled alternative in {@link TestParser#check}.
	 * @param ctx the parse tree
	 */
	void exitCheckStatement(TestParser.CheckStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperation(TestParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperation(TestParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfConditional}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfConditional(TestParser.IfConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfConditional}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfConditional(TestParser.IfConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoReturnFunction}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNoReturnFunction(TestParser.NoReturnFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoReturnFunction}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNoReturnFunction(TestParser.NoReturnFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Arithmetic}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(TestParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Arithmetic}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(TestParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterLogical(TestParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitLogical(TestParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational(TestParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational(TestParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(TestParser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(TestParser.ExprNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprVariable}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterExprVariable(TestParser.ExprVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprVariable}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitExprVariable(TestParser.ExprVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBool}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterExprBool(TestParser.ExprBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBool}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitExprBool(TestParser.ExprBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(TestParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(TestParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterAddition(TestParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitAddition(TestParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(TestParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(TestParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOr}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOr(TestParser.BitwiseOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOr}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOr(TestParser.BitwiseOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseXor}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseXor(TestParser.BitwiseXorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseXor}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseXor(TestParser.BitwiseXorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAnd}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAnd(TestParser.BitwiseAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAnd}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAnd(TestParser.BitwiseAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterDivision(TestParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitDivision(TestParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AritmeticVariable}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterAritmeticVariable(TestParser.AritmeticVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AritmeticVariable}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitAritmeticVariable(TestParser.AritmeticVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticNumber}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticNumber(TestParser.ArithmeticNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticNumber}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticNumber(TestParser.ArithmeticNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalVariable}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalVariable(TestParser.LogicalVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalVariable}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalVariable(TestParser.LogicalVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalBool}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalBool(TestParser.LogicalBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalBool}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalBool(TestParser.LogicalBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(TestParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(TestParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(TestParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(TestParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThan(TestParser.GreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThan(TestParser.GreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(TestParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(TestParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterLessOrEqual(TestParser.LessOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitLessOrEqual(TestParser.LessOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterOrEqual}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterGreaterOrEqual(TestParser.GreaterOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterOrEqual}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitGreaterOrEqual(TestParser.GreaterOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterEquals(TestParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitEquals(TestParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalVariable}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterRelationalVariable(TestParser.RelationalVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalVariable}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitRelationalVariable(TestParser.RelationalVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link TestParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(TestParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link TestParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(TestParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INT32}
	 * labeled alternative in {@link TestParser#type}.
	 * @param ctx the parse tree
	 */
	void enterINT32(TestParser.INT32Context ctx);
	/**
	 * Exit a parse tree produced by the {@code INT32}
	 * labeled alternative in {@link TestParser#type}.
	 * @param ctx the parse tree
	 */
	void exitINT32(TestParser.INT32Context ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link TestParser#type}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLE(TestParser.DOUBLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link TestParser#type}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLE(TestParser.DOUBLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link TestParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBOOL(TestParser.BOOLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link TestParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBOOL(TestParser.BOOLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link TestParser#number}.
	 * @param ctx the parse tree
	 */
	void enterIntegerNumber(TestParser.IntegerNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link TestParser#number}.
	 * @param ctx the parse tree
	 */
	void exitIntegerNumber(TestParser.IntegerNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealNumber}
	 * labeled alternative in {@link TestParser#number}.
	 * @param ctx the parse tree
	 */
	void enterRealNumber(TestParser.RealNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealNumber}
	 * labeled alternative in {@link TestParser#number}.
	 * @param ctx the parse tree
	 */
	void exitRealNumber(TestParser.RealNumberContext ctx);
}