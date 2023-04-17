// Generated from java-escape by ANTLR 4.11.1

	package antlrTest;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code TestProgram}
	 * labeled alternative in {@link TestParser#testProg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestProgram(TestParser.TestProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestDeclaration}
	 * labeled alternative in {@link TestParser#testDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestDeclaration(TestParser.TestDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UninitializedDeclaration}
	 * labeled alternative in {@link TestParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUninitializedDeclaration(TestParser.UninitializedDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitializedDeclaration}
	 * labeled alternative in {@link TestParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializedDeclaration(TestParser.InitializedDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CheckStatement}
	 * labeled alternative in {@link TestParser#check}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckStatement(TestParser.CheckStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(TestParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfConditional}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfConditional(TestParser.IfConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoReturnFunction}
	 * labeled alternative in {@link TestParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoReturnFunction(TestParser.NoReturnFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Arithmetic}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic(TestParser.ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical(TestParser.LogicalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(TestParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNumber(TestParser.ExprNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVariable}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVariable(TestParser.ExprVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBool}
	 * labeled alternative in {@link TestParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBool(TestParser.ExprBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(TestParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(TestParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(TestParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseOr}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOr(TestParser.BitwiseOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseXor}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseXor(TestParser.BitwiseXorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseAnd}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAnd(TestParser.BitwiseAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(TestParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AritmeticVariable}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritmeticVariable(TestParser.AritmeticVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticNumber}
	 * labeled alternative in {@link TestParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticNumber(TestParser.ArithmeticNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalVariable}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalVariable(TestParser.LogicalVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalBool}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalBool(TestParser.LogicalBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAnd(TestParser.LogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link TestParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOr(TestParser.LogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(TestParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(TestParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessOrEqual(TestParser.LessOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterOrEqual}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterOrEqual(TestParser.GreaterOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(TestParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalVariable}
	 * labeled alternative in {@link TestParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalVariable(TestParser.RelationalVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link TestParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(TestParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INT32}
	 * labeled alternative in {@link TestParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINT32(TestParser.INT32Context ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link TestParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLE(TestParser.DOUBLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link TestParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOL(TestParser.BOOLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link TestParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerNumber(TestParser.IntegerNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RealNumber}
	 * labeled alternative in {@link TestParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealNumber(TestParser.RealNumberContext ctx);
}