package expression;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import expression.ArithmeticExpressions.*;
import expression.ArrayExpressions.ArrayAccessExpression;
import expression.ArrayExpressions.ArrayAssignmentExpression;
import expression.ArrayExpressions.ArrayDeclaration;
import org.antlr.v4.runtime.Token;

import antlr.ExprBaseVisitor;
import antlr.ExprParser;
import antlr.ExprParser.*;
import expression.LogicalExpressions.AndExpression;
import expression.LogicalExpressions.LogicalExpression;
import expression.LogicalExpressions.OrExpression;
import expression.LogicalExpressions.BoolExpression;
import expression.LogicalExpressions.BooleanLiteral;
import expression.RelationalExpressions.BoolInitializedVariableDeclaration;
import expression.RelationalExpressions.EqualsExpression;
import expression.RelationalExpressions.GreaterExpression;
import expression.RelationalExpressions.GreaterOrEqualExpression;
import expression.RelationalExpressions.LessExpression;
import expression.RelationalExpressions.LessOrEqualExpression;

public class AntlrToExpression extends ExprBaseVisitor<Expression> {

	private Map<String, VariableType> vars = new HashMap<>();
	private Map<String, Boolean> hasAssignedValue = new HashMap<>();
	private static Map<String, VariableType> typeConverter;
	private List<String> semanticErrors;

	public AntlrToExpression(List<String> semanticErrors) {
		super();
		this.semanticErrors = semanticErrors;
		if (typeConverter == null) {
			typeConverter = new HashMap<>();
			for (VariableType var : VariableType.values()) {
				typeConverter.put(var.toString(), var);
			}
		}
	}
	
	/**
	 * Tells this expression generator that all of the parameters in the list have been assigned to, avoids semantic errors
	 * @param list
	 */
	public void setupParameters(List<UninitializedVariableDeclaration> list) {
		for (UninitializedVariableDeclaration currentExpression : list) {
			hasAssignedValue.put(currentExpression.getID(), true);
		}
	}

	@Override
	public Expression visitUninitializedDeclaration(UninitializedDeclarationContext ctx) {
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(1).getText();
		String textType = ctx.getChild(0).getText();
		VariableType type = typeConverter.get(textType);
		if (type == null) {
			System.err.println("In visitUninitializedDeclaration the type " + textType
					+ "was encountered but unhandled. Make sure there is a String representation of it in VariableType");
		}
		if (vars.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " already declared(" + line + ", " + column + ")");
		} else {
			vars.put(id, type);
			hasAssignedValue.put(id, false);
		}
//		return new UninitializedVariableDeclaration(id, type);

		try {
			String varType = ctx.getChild(0).getText();
			String varName = ctx.getChild(1).getText();
			return new UninitializedVariableDeclaration(id, type, line, varType + " " + varName);
		} catch(Exception e) { // failsafe
			return new UninitializedVariableDeclaration(id, type, line, ctx.getText());
		}
	}

	@Override
	public Expression visitInitializedDeclaration(InitializedDeclarationContext ctx) {
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(1).getText();
		String textType = ctx.getChild(0).getText();
		VariableType type = typeConverter.get(textType);
		if (vars.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " already declared(" + line + ", " + column + ")");
		} else {
			vars.put(id, type);
			hasAssignedValue.put(id, true);
		}
		Expression value = visit(ctx.getChild(3));
		
		String varFullName = textType + " " + id;
		switch (type) {
		case Double:
			return new DoubleInitializedVariableDeclaration(id, value, line, varFullName);
		case Int32:
			return new Int32InitializedVariableDeclaration(id, value, line, varFullName);
		case Bool:
			return new BoolInitializedVariableDeclaration(id, value, line, varFullName);
		default:
			break;
		}
		System.err.println("In visitInitializedDeclaration the type " + textType
				+ "was encountered but unhandled. Add a case for it to the switch statement");
		return null;
	}

	@Override
	public Expression visitOperation(ExprParser.OperationContext ctx) {
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(0).getText();
		Expression rightSide = visit(ctx.getChild(2));
		BaseVariable assignTo = null;
		if (!vars.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " doesn't exist(" + line + ", " + column + ")");
		} else {
			hasAssignedValue.put(id, true);
			switch (vars.get(id)) {
			case Double:
				assignTo = new DoubleExpression(id);
				break;
			case Int32:
				assignTo = new Int32Expression(id);
				break;
			case Bool:
				assignTo = new BoolExpression(id);
				break;
			default:
				break;
			}
		}
//		return new AssignmentExpression(assignTo, rightSide);
		return new AssignmentExpression(assignTo, rightSide, line, ctx.getText());

	}
	
	@Override
	public Expression visitWhileLoop(ExprParser.WhileLoopContext ctx) {
		Token idToken = ctx.getStart();
		int line = idToken.getLine();
		
		Expression condition = visit(ctx.getChild(2)); // might need to get refractored when we have multiple conditions
		String text = ctx.getChild(2).getText();
		
		List<Expression> containedExpressions = new ArrayList<>();
		for (int childIndex = 5; childIndex < ctx.getChildCount()-1; childIndex++) {
			containedExpressions.add(visit(ctx.getChild(childIndex)));
		}
		
		return new WhileLoop(condition, containedExpressions, line, text);
	}

	@Override
	public Expression visitIfThen(ExprParser.IfThenContext ctx) {
		Token idToken = ctx.getStart();
		int line = idToken.getLine();
		
		Expression condition = visit(ctx.getChild(2));
		List<Expression> containedExpressions = new ArrayList<>();
		for (int childIndex = 5; childIndex < ctx.getChildCount()-1; childIndex++) {
			containedExpressions.add(visit(ctx.getChild(childIndex)));
		}
		return new IfThen(condition, containedExpressions, line, ctx.getChild(2).getText());
	}

	@Override
	public Expression visitIfThenElse(IfThenElseContext ctx)
	{
		Token idToken = ctx.getStart();
		int line = idToken.getLine();
		
		Expression condition = visit(ctx.getChild(2));
		List<Expression> containedExpressions = new ArrayList<>();
		for (int childIndex = 5; childIndex < ctx.getChildCount()-3; childIndex++) {
			containedExpressions.add(visit(ctx.getChild(childIndex)));
		}
		Expression elseBlock = visit(ctx.getChild(ctx.getChildCount()-1));
		return new IfThenElse(condition, containedExpressions, elseBlock, line, ctx.getChild(2).getText());
	}

	@Override
	public Expression visitElseIf(ElseIfContext ctx)
	{
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitElseBody(ElseBodyContext ctx)
	{
		List<Expression> containedExpressions = new ArrayList<>();
		for (int childIndex = 1; childIndex < ctx.getChildCount()-1; childIndex++) {
			containedExpressions.add(visit(ctx.getChild(childIndex)));
		}
		return new ElseBody(containedExpressions);
	}

	@Override
	public Expression visitNoReturnFunction(ExprParser.NoReturnFunctionContext ctx) {
		return null;
	}

	@Override
	public Expression visitReturnExpression(ExprParser.ReturnExpressionContext ctx) {
		Token idToken = ctx.getStart();
		int line = idToken.getLine();
		Expression child = visit(ctx.getChild(1));
		if (child == null) {
			String boolVal = ctx.getChild(1).getText();
			child = new BooleanLiteral(boolVal);
		}
		return new Return(child, line, ctx.getChild(1).getText());
	}

	@Override
	public Expression visitVariable(ExprParser.VariableContext ctx) {
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(0).getText();
		return visitVariableHelper(line, column, id);
	}

	private BaseVariable visitVariableHelper(int line, int column, String id) {
		BaseVariable variable = null;
		if (!vars.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " doesn't exist(" + line + ", " + column + ")");
		}else if (!hasAssignedValue.get(id)) {
			semanticErrors.add("Error: variable " + id + " used before assignment(" + line + ", " + column + ")");
		} else {
			switch (vars.get(id)) {
			case Double:
				variable = new DoubleExpression(id);
				break;
			case Int32:
				variable = new Int32Expression(id);
				break;
			case Bool:
				variable = new BoolExpression(id);
				break;
			default:
				break;
			}
		}
		return variable;
	}

	@Override
	public Expression visitArithmetic(ExprParser.ArithmeticContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitLogical(ExprParser.LogicalContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitRelational(ExprParser.RelationalContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitExprNumber(ExprParser.ExprNumberContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitExprVariable(ExprParser.ExprVariableContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitExprBool(ExprParser.ExprBoolContext ctx) {
		String boolVal = ctx.getChild(0).getText();
		return new BooleanLiteral(boolVal);
	}
	
	@Override
	public Expression visitBOOL(ExprParser.BOOLContext ctx) {
		String boolVal = ctx.getChild(0).getText();
		return new BooleanLiteral(boolVal);
	}

	@Override
	public Expression visitMultiplication(ExprParser.MultiplicationContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new Multiplication(leftSide, rightSide);
	}

	@Override
	public Expression visitAddition(ExprParser.AdditionContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new Addition(leftSide, rightSide);
	}

	@Override
	public Expression visitSubtraction(ExprParser.SubtractionContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new Subtraction(leftSide, rightSide);
	}

	@Override
	public Expression visitBitwiseOr(ExprParser.BitwiseOrContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new BitwiseOr(leftSide, rightSide);
	}

	@Override
	public Expression visitBitwiseXor(ExprParser.BitwiseXorContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new BitwiseXor(leftSide, rightSide);
	}

	@Override
	public Expression visitBitwiseAnd(ExprParser.BitwiseAndContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new BitwiseAnd(leftSide, rightSide);
	}

	@Override
	public Expression visitArithmeticVariable(ExprParser.ArithmeticVariableContext ctx) {
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(0).getText();
		return visitVariableHelper(line, column, id);
	}

	@Override
	public Expression visitDivision(ExprParser.DivisionContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new Division(leftSide, rightSide);
	}

	@Override
	public Expression visitArithmeticNumber(ExprParser.ArithmeticNumberContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitLogicalVariable(ExprParser.LogicalVariableContext ctx) {
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(0).getText();
		return visitVariableHelper(line, column, id);
	}

	// BOOL
	// BOOL: 'true' | 'false'
	@Override
	public Expression visitLogicalBool(ExprParser.LogicalBoolContext ctx) {
		String boolVal = ctx.getChild(0).getText();
		return new BooleanLiteral(boolVal);
	}

	@Override
	public Expression visitLogicalAnd(ExprParser.LogicalAndContext ctx) {
		LogicalExpression rightSide = (LogicalExpression) visit(ctx.getChild(2));
		LogicalExpression leftSide = (LogicalExpression) visit(ctx.getChild(0));
		return new AndExpression(leftSide, rightSide);
	}

	@Override
	public Expression visitLogicalOr(ExprParser.LogicalOrContext ctx) {
		LogicalExpression rightSide = (LogicalExpression) visit(ctx.getChild(2));
		LogicalExpression leftSide = (LogicalExpression) visit(ctx.getChild(0));
		return new OrExpression(leftSide, rightSide);
	}

	@Override
	public Expression visitGreaterThan(ExprParser.GreaterThanContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		// visit returns type Expression, assuming casting should be fine
		return new GreaterExpression(leftSide, rightSide);
	}

	@Override
	public Expression visitLessThan(ExprParser.LessThanContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new LessExpression(leftSide, rightSide);
	}

	@Override
	public Expression visitLessOrEqual(ExprParser.LessOrEqualContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new LessOrEqualExpression(leftSide, rightSide);
	}

	@Override
	public Expression visitGreaterOrEqual(ExprParser.GreaterOrEqualContext ctx) {
		ArithmeticExpression rightSide = (ArithmeticExpression) visit(ctx.getChild(2));
		ArithmeticExpression leftSide = (ArithmeticExpression) visit(ctx.getChild(0));
		return new GreaterOrEqualExpression(leftSide, rightSide);
	}

	@Override
	public Expression visitEquals(ExprParser.EqualsContext ctx) {
		return new EqualsExpression((ArithmeticExpression) visit(ctx.getChild(0)),
				(ArithmeticExpression) visit(ctx.getChild(2)));
	}

	// ID
	@Override
	public Expression visitRelationalVariable(ExprParser.RelationalVariableContext ctx) {
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(0).getText();
		return visitVariableHelper(line, column, id);
	}

	// ID '(' ')'
	// or:
	// ID '(' (operator (',' operator)*)? ')'
	// THIS MIGHT NEED TO GET REFRACTORED LATER
	@Override
	public Expression visitFunctionCall(ExprParser.FunctionCallContext ctx) {
		int numOfChildren = ctx.getChildCount();
		List<Expression> parameterList = new ArrayList<>();
		String id = ctx.getChild(0).getText();
		for (int i = 2; i < numOfChildren; i += 2) { // need += 2 to skip the ','
			Expression newParameter = visit(ctx.getChild(i));
			if (newParameter != null) {
				parameterList.add(newParameter);
			}
		}
		return new FunctionCall(id, parameterList);
	}

	@Override
	public Expression visitIntegerNumber(ExprParser.IntegerNumberContext ctx) {
		String numText = ctx.getChild(0).getText();

		return new IntegerLiteral(numText);
	}

	@Override
	public Expression visitRealNumber(ExprParser.RealNumberContext ctx) {
		String numText = ctx.getChild(0).getText();

		return new RealLiteral(numText);
	}

	@Override
	public Expression visitArrayDeclaration(ArrayDeclarationContext ctx)
	{
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitUninitializedArray(UninitializedArrayContext ctx)
	{
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(4).getText();
		String textType = ctx.getChild(0).getText();
		VariableType type = typeConverter.get(textType);
		Expression arraySizeExpression = visit(ctx.getChild(2));
		int arraySize = ((IntegerLiteral) arraySizeExpression).getValue().intValue();
		if (vars.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " already declared(" + line + ", " + column + ")");
		} else {
			vars.put(id, type);
			hasAssignedValue.put(id, false);
		}

		List<Expression> initialValues = new ArrayList<>(arraySize);
		for (int i = 0; i < arraySize; i++) {
			initialValues.add(new IntegerLiteral(new BigInteger("0")));
		}
		return new ArrayDeclaration(id, type, initialValues);
	}

	@Override
	public Expression visitInitializedArray(InitializedArrayContext ctx)
	{
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = ctx.getChild(4).getText();
		String textType = ctx.getChild(0).getText();
		VariableType type = typeConverter.get(textType);

		List<Expression> initialValues = new ArrayList<>();
		for (int i = 1; i < ctx.getChild(6).getChildCount(); i+=2) {
			Expression exprToAdd = visit(ctx.getChild(6).getChild(i));
			initialValues.add(visit(ctx.getChild(6).getChild(i)));

		}

		if (vars.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " already declared(" + line + ", " + column + ")");
		} else {
			vars.put(id, type);
			hasAssignedValue.put(id, true);
		}

		return new ArrayDeclaration(id, type, initialValues);
	}

	@Override
	public Expression visitArrayAccessExpression(ArrayAccessExpressionContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitArray_access(Array_accessContext ctx) {
		String id = ctx.ID().getText();
		int line = ctx.ID().getSymbol().getLine();
		int column = ctx.ID().getSymbol().getCharPositionInLine() + 1;
		BaseVariable assignTo = null;
		if (!vars.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " doesn't exist(" + line + ", " + column + ")");
		} else {
			switch (vars.get(id)) {
			case Double:
				assignTo = new DoubleExpression(id);
				break;
			case Int32:
				assignTo = new Int32Expression(id);
				break;
			case Bool:
				assignTo = new BoolExpression(id);
				break;
			default:
				break;
			}
		}
		return new ArrayAccessExpression(assignTo, visit(ctx.getChild(2)));
	}

	@Override
	public Expression visitArray_index(Array_indexContext ctx) {
		if (ctx.ID() == null) {
			return visit(ctx.getChild(0));
		}
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id = idToken.getText();
		return visitVariableHelper(line, column, id);
	}

	@Override
	public Expression visitNumber(NumberContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitArrayOperation(ArrayOperationContext ctx)
	{
		Token idToken = ((Array_accessContext)ctx.getChild(0)).ID().getSymbol();
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		String id =idToken.getText();
		Expression rightSide = visit(ctx.getChild(2));
		BaseVariable assignTo = null;
		ArrayAccessExpression arrayAssignTo = null;
		if (!vars.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " doesn't exist(" + line + ", " + column + ")");
		} else {
			hasAssignedValue.put(id, true);
			switch (vars.get(id)) {
			case Double:
				assignTo = new DoubleExpression(id);
				break;
			case Int32:
				assignTo = new Int32Expression(id);
				break;
			case Bool:
				assignTo = new BoolExpression(id);
				break;
			default:
				break;
			}
		}
		arrayAssignTo = new ArrayAccessExpression(assignTo, visit(ctx.getChild(0).getChild(2)));
		return new ArrayAssignmentExpression(arrayAssignTo, rightSide, line, ctx.getText());
	}

	@Override
	public Expression visitPrint(PrintContext ctx)
	{
		Expression expressionToPrint = visit(ctx.getChild(2));
		return new PrintExpression(expressionToPrint);
	}


}