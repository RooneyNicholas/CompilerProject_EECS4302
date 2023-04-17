package expression;

public enum ExpressionType {
	Multiplication("*"),
	Addition("+"),
	Variable("var"),
	Literal("literal"), 
	And("&&"), 
	Greater(">"), 
	Assignment("="), 
	UninitializedVariableDeclaration("declaration"), 
	InitializedVariableDeclaration("declaration"), 
	GreaterOrEqual(">="), 
	Less("<"), 
	LessOrEqual("<="), 
	Equals("=="), 
	Or("||"), 
	True("true"),
	False("false"), 
	Division("/"), // slash might interfere later, need to recheck this*
	Subtraction("-"), 
	FunctionCall("call"), 
	Return("return"),
	Function("function"), 
	IfThen("ifthen"),
	WhileLoop("whileloop"),
	BitwiseAnd("&"),
	BitwiseOr("|"),
	BitwiseXor("^"),
	IfThenElse("ifthenelse"),
	ElseBody("else"),
	Array("array"), 
	ArrayAssignment("array_assignment"), 
	ArrayIndexed("array_indexed"),
	PrintExpression("print");

	private final String symbol;
	
	ExpressionType(String symbol){
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
}
