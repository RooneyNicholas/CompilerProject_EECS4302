// Generated from java-escape by ANTLR 4.11.1

	package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MainDeclaration}
	 * labeled alternative in {@link ExprParser#main_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDeclaration(ExprParser.MainDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestDeclaration}
	 * labeled alternative in {@link ExprParser#test_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestDeclaration(ExprParser.TestDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link ExprParser#function_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(ExprParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionParams}
	 * labeled alternative in {@link ExprParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParams(ExprParser.FunctionParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(ExprParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ExprParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#print_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_options(ExprParser.Print_optionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UninitializedDeclaration}
	 * labeled alternative in {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUninitializedDeclaration(ExprParser.UninitializedDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitializedDeclaration}
	 * labeled alternative in {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializedDeclaration(ExprParser.InitializedDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayDeclaration}
	 * labeled alternative in {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaration(ExprParser.ArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UninitializedArray}
	 * labeled alternative in {@link ExprParser#array_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUninitializedArray(ExprParser.UninitializedArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitializedArray}
	 * labeled alternative in {@link ExprParser#array_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializedArray(ExprParser.InitializedArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitialArrayValues}
	 * labeled alternative in {@link ExprParser#array_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialArrayValues(ExprParser.InitialArrayValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#array_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_access(ExprParser.Array_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#array_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_index(ExprParser.Array_indexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(ExprParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayOperation}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayOperation(ExprParser.ArrayOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoReturnFunction}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoReturnFunction(ExprParser.NoReturnFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpression(ExprParser.ReturnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAccessExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpression(ExprParser.ArrayAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ExprParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link ExprParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(ExprParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfThen}
	 * labeled alternative in {@link ExprParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThen(ExprParser.IfThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfThenElse}
	 * labeled alternative in {@link ExprParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElse(ExprParser.IfThenElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseIf}
	 * labeled alternative in {@link ExprParser#else_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIf(ExprParser.ElseIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseBody}
	 * labeled alternative in {@link ExprParser#else_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBody(ExprParser.ElseBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Arithmetic}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic(ExprParser.ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical(ExprParser.LogicalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(ExprParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNumber(ExprParser.ExprNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVariable}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVariable(ExprParser.ExprVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBool}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBool(ExprParser.ExprBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(ExprParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(ExprParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(ExprParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseOr}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOr(ExprParser.BitwiseOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseXor}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseXor(ExprParser.BitwiseXorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseAnd}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAnd(ExprParser.BitwiseAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticVariable}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticVariable(ExprParser.ArithmeticVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(ExprParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticNumber}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticNumber(ExprParser.ArithmeticNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalVariable}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalVariable(ExprParser.LogicalVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalBool}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalBool(ExprParser.LogicalBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalRelational}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalRelational(ExprParser.LogicalRelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAnd(ExprParser.LogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOr(ExprParser.LogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(ExprParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(ExprParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessOrEqual(ExprParser.LessOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterOrEqual}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterOrEqual(ExprParser.GreaterOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(ExprParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalVariable}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalVariable(ExprParser.RelationalVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link ExprParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(ExprParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INT32}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINT32(ExprParser.INT32Context ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLE(ExprParser.DOUBLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOL(ExprParser.BOOLContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ExprParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link ExprParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerNumber(ExprParser.IntegerNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RealNumber}
	 * labeled alternative in {@link ExprParser#real_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealNumber(ExprParser.RealNumberContext ctx);
}