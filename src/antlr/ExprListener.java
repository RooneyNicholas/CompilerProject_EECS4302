// Generated from java-escape by ANTLR 4.11.1

	package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainDeclaration}
	 * labeled alternative in {@link ExprParser#main_decl}.
	 * @param ctx the parse tree
	 */
	void enterMainDeclaration(ExprParser.MainDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainDeclaration}
	 * labeled alternative in {@link ExprParser#main_decl}.
	 * @param ctx the parse tree
	 */
	void exitMainDeclaration(ExprParser.MainDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestDeclaration}
	 * labeled alternative in {@link ExprParser#test_decl}.
	 * @param ctx the parse tree
	 */
	void enterTestDeclaration(ExprParser.TestDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestDeclaration}
	 * labeled alternative in {@link ExprParser#test_decl}.
	 * @param ctx the parse tree
	 */
	void exitTestDeclaration(ExprParser.TestDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link ExprParser#function_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(ExprParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link ExprParser#function_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(ExprParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionParams}
	 * labeled alternative in {@link ExprParser#param_list}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParams(ExprParser.FunctionParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionParams}
	 * labeled alternative in {@link ExprParser#param_list}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParams(ExprParser.FunctionParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(ExprParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(ExprParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ExprParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ExprParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#print_options}.
	 * @param ctx the parse tree
	 */
	void enterPrint_options(ExprParser.Print_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#print_options}.
	 * @param ctx the parse tree
	 */
	void exitPrint_options(ExprParser.Print_optionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UninitializedDeclaration}
	 * labeled alternative in {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterUninitializedDeclaration(ExprParser.UninitializedDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UninitializedDeclaration}
	 * labeled alternative in {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitUninitializedDeclaration(ExprParser.UninitializedDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InitializedDeclaration}
	 * labeled alternative in {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterInitializedDeclaration(ExprParser.InitializedDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InitializedDeclaration}
	 * labeled alternative in {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitInitializedDeclaration(ExprParser.InitializedDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayDeclaration}
	 * labeled alternative in {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(ExprParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayDeclaration}
	 * labeled alternative in {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(ExprParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UninitializedArray}
	 * labeled alternative in {@link ExprParser#array_decl}.
	 * @param ctx the parse tree
	 */
	void enterUninitializedArray(ExprParser.UninitializedArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UninitializedArray}
	 * labeled alternative in {@link ExprParser#array_decl}.
	 * @param ctx the parse tree
	 */
	void exitUninitializedArray(ExprParser.UninitializedArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InitializedArray}
	 * labeled alternative in {@link ExprParser#array_decl}.
	 * @param ctx the parse tree
	 */
	void enterInitializedArray(ExprParser.InitializedArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InitializedArray}
	 * labeled alternative in {@link ExprParser#array_decl}.
	 * @param ctx the parse tree
	 */
	void exitInitializedArray(ExprParser.InitializedArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InitialArrayValues}
	 * labeled alternative in {@link ExprParser#array_init}.
	 * @param ctx the parse tree
	 */
	void enterInitialArrayValues(ExprParser.InitialArrayValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InitialArrayValues}
	 * labeled alternative in {@link ExprParser#array_init}.
	 * @param ctx the parse tree
	 */
	void exitInitialArrayValues(ExprParser.InitialArrayValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#array_access}.
	 * @param ctx the parse tree
	 */
	void enterArray_access(ExprParser.Array_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#array_access}.
	 * @param ctx the parse tree
	 */
	void exitArray_access(ExprParser.Array_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#array_index}.
	 * @param ctx the parse tree
	 */
	void enterArray_index(ExprParser.Array_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#array_index}.
	 * @param ctx the parse tree
	 */
	void exitArray_index(ExprParser.Array_indexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperation(ExprParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperation(ExprParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayOperation}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayOperation(ExprParser.ArrayOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayOperation}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayOperation(ExprParser.ArrayOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoReturnFunction}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNoReturnFunction(ExprParser.NoReturnFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoReturnFunction}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNoReturnFunction(ExprParser.NoReturnFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpression(ExprParser.ReturnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpression(ExprParser.ReturnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAccessExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(ExprParser.ArrayAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAccessExpression}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(ExprParser.ArrayAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ExprParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ExprParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link ExprParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(ExprParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link ExprParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(ExprParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfThen}
	 * labeled alternative in {@link ExprParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterIfThen(ExprParser.IfThenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfThen}
	 * labeled alternative in {@link ExprParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitIfThen(ExprParser.IfThenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfThenElse}
	 * labeled alternative in {@link ExprParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElse(ExprParser.IfThenElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfThenElse}
	 * labeled alternative in {@link ExprParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElse(ExprParser.IfThenElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseIf}
	 * labeled alternative in {@link ExprParser#else_block}.
	 * @param ctx the parse tree
	 */
	void enterElseIf(ExprParser.ElseIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseIf}
	 * labeled alternative in {@link ExprParser#else_block}.
	 * @param ctx the parse tree
	 */
	void exitElseIf(ExprParser.ElseIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseBody}
	 * labeled alternative in {@link ExprParser#else_block}.
	 * @param ctx the parse tree
	 */
	void enterElseBody(ExprParser.ElseBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseBody}
	 * labeled alternative in {@link ExprParser#else_block}.
	 * @param ctx the parse tree
	 */
	void exitElseBody(ExprParser.ElseBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Arithmetic}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(ExprParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Arithmetic}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(ExprParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterLogical(ExprParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitLogical(ExprParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational(ExprParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational(ExprParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(ExprParser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(ExprParser.ExprNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprVariable}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterExprVariable(ExprParser.ExprVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprVariable}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitExprVariable(ExprParser.ExprVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBool}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterExprBool(ExprParser.ExprBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBool}
	 * labeled alternative in {@link ExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitExprBool(ExprParser.ExprBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(ExprParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(ExprParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterAddition(ExprParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitAddition(ExprParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(ExprParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(ExprParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOr}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOr(ExprParser.BitwiseOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOr}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOr(ExprParser.BitwiseOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseXor}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseXor(ExprParser.BitwiseXorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseXor}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseXor(ExprParser.BitwiseXorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAnd}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAnd(ExprParser.BitwiseAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAnd}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAnd(ExprParser.BitwiseAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticVariable}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticVariable(ExprParser.ArithmeticVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticVariable}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticVariable(ExprParser.ArithmeticVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterDivision(ExprParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitDivision(ExprParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticNumber}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticNumber(ExprParser.ArithmeticNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticNumber}
	 * labeled alternative in {@link ExprParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticNumber(ExprParser.ArithmeticNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalVariable}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalVariable(ExprParser.LogicalVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalVariable}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalVariable(ExprParser.LogicalVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalBool}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalBool(ExprParser.LogicalBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalBool}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalBool(ExprParser.LogicalBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalRelational}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalRelational(ExprParser.LogicalRelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalRelational}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalRelational(ExprParser.LogicalRelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(ExprParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(ExprParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(ExprParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link ExprParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(ExprParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThan(ExprParser.GreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThan(ExprParser.GreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(ExprParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(ExprParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterLessOrEqual(ExprParser.LessOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitLessOrEqual(ExprParser.LessOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterOrEqual}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterGreaterOrEqual(ExprParser.GreaterOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterOrEqual}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitGreaterOrEqual(ExprParser.GreaterOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterEquals(ExprParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitEquals(ExprParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalVariable}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterRelationalVariable(ExprParser.RelationalVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalVariable}
	 * labeled alternative in {@link ExprParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitRelationalVariable(ExprParser.RelationalVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link ExprParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(ExprParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link ExprParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(ExprParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INT32}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterINT32(ExprParser.INT32Context ctx);
	/**
	 * Exit a parse tree produced by the {@code INT32}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitINT32(ExprParser.INT32Context ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLE(ExprParser.DOUBLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLE(ExprParser.DOUBLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBOOL(ExprParser.BOOLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link ExprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBOOL(ExprParser.BOOLContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ExprParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link ExprParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterIntegerNumber(ExprParser.IntegerNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link ExprParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitIntegerNumber(ExprParser.IntegerNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealNumber}
	 * labeled alternative in {@link ExprParser#real_number}.
	 * @param ctx the parse tree
	 */
	void enterRealNumber(ExprParser.RealNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealNumber}
	 * labeled alternative in {@link ExprParser#real_number}.
	 * @param ctx the parse tree
	 */
	void exitRealNumber(ExprParser.RealNumberContext ctx);
}