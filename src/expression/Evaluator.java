package expression;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import codeCoverage.ControlCoverage;
import codeCoverage.DataCoverage;
import expression.ArithmeticExpressions.*;
import expression.ArrayExpressions.ArrayAccessExpression;
import expression.ArrayExpressions.ArrayAssignmentExpression;
import expression.ArrayExpressions.ArrayDeclaration;
import expression.LogicalExpressions.AndExpression;
import expression.LogicalExpressions.OrExpression;
import expression.LogicalExpressions.BooleanLiteral;
import expression.RelationalExpressions.BoolInitializedVariableDeclaration;
import expression.RelationalExpressions.EqualsExpression;
import expression.RelationalExpressions.GreaterExpression;
import expression.RelationalExpressions.GreaterOrEqualExpression;
import expression.RelationalExpressions.LessExpression;
import expression.RelationalExpressions.LessOrEqualExpression;

public class Evaluator {
	
	public static final boolean OUTPUT_WRITTEN_STATEMENTS = true;
	public static final boolean OUTPUT_EVALUATED_STATEMENTS = true;
	public static final boolean OUTPUT_FUNCTION_CALLS = true;
	
	private ControlCoverage controlCoverage;
	private DataCoverage dataCoverage;
	
	private Map<String, VariableType> variableTypes = new HashMap<>();
	private Map<String, Object> values = new HashMap<>();
	private Map<String, Function> functions;
	private List<String> evaluationResults;

	private boolean skipElseIf = false;
	
	
	//Do not implement this method, it'll cover up the fact that actual evaluate methods need to be implemented for new classes
//	private final Expression evaluate(Expression expression) {
//		return null;
//	}

	public Evaluator(Map<String, Function> functions, List<String> evaluationResults, ControlCoverage controlCoverage, DataCoverage dataCoverage) {
		this.functions = functions;
		this.evaluationResults = evaluationResults;
		if (controlCoverage == null) {
			initControlCoverage(functions);
		}else {
			this.controlCoverage = controlCoverage;
		}
		
		if (dataCoverage == null) {
			initDataCoverage(functions);
		}else {
			this.dataCoverage = dataCoverage;
		}
	}
	
	public Evaluator(Map<String, Function> functions, List<String> evaluationResults) {
		this.functions = functions;
		this.evaluationResults = evaluationResults;
		initControlCoverage(functions);
		initDataCoverage(functions);
		
	}

	private void initControlCoverage(Map<String, Function> functions) {
		controlCoverage = new ControlCoverage(functions);
	}
	
	private void initDataCoverage(Map<String, Function> functions) {
		dataCoverage = new DataCoverage(functions);
	}
	
	
	@SuppressWarnings({ "incomplete-switch", "rawtypes" })
	private Expression doNumericOperation(BaseLiteral left, ExpressionType expressionType, BaseLiteral right) {
		switch (left.getLiteralType()) {
		case Integer:
			switch(right.getLiteralType()) {
			case Integer:
				return doNumericOperation(((IntegerLiteral)left).getValue(), expressionType, ((IntegerLiteral)right).getValue());
			case Real:
				return doNumericOperation(((IntegerLiteral)left).getValue(), expressionType, ((RealLiteral)right).getValue());
			}
			break;
		case Real:
			switch(right.getLiteralType()) {
			case Integer:
				return doNumericOperation(((RealLiteral)left).getValue(), expressionType, ((IntegerLiteral)right).getValue());
			case Real:
				return doNumericOperation(((RealLiteral)left).getValue(), expressionType, ((RealLiteral)right).getValue());
			}
			break;
		}
		return null;
	}

	@SuppressWarnings("incomplete-switch")
	private Expression doNumericOperation(BigInteger left, ExpressionType expressionType, BigInteger right) {
		BigInteger numberResult = null;
		boolean boolResult = false;
		switch(expressionType) {
		case Addition:
			numberResult = left.add(right);
			break;
		case Division:
			numberResult = left.divide(right);
			break;
		case Multiplication:
			numberResult = left.multiply(right);
			break;
		case Subtraction:
			numberResult = left.subtract(right);
			break;
		case Equals:
			boolResult = left.compareTo(right) == 0;
			break;
		case Greater:
			boolResult = left.compareTo(right) > 0;
			break;
		case GreaterOrEqual:
			boolResult = left.compareTo(right) >= 0;
			break;
		case Less:
			boolResult = left.compareTo(right) < 0;
			break;
		case LessOrEqual:
			boolResult = left.compareTo(right) <= 0;
			break;
		case BitwiseAnd:
			numberResult = left.and(right);
			break;
		case BitwiseOr:
			numberResult = left.or(right);
			break;
		case BitwiseXor:
			numberResult = left.xor(right);
			break;
		}
		if (numberResult != null) {
			return new IntegerLiteral(numberResult);
		}else {
			return new BooleanLiteral(boolResult);
		}
	}
	
	private Expression doNumericOperation(BigDecimal left, ExpressionType expressionType, BigInteger right) {
		return doNumericOperation(left, expressionType, new BigDecimal(right));
	}

	private Expression doNumericOperation(BigInteger left, ExpressionType expressionType, BigDecimal right) {
		return doNumericOperation(new BigDecimal(left), expressionType, right);
	}

	@SuppressWarnings("incomplete-switch")
	private Expression doNumericOperation(BigDecimal left, ExpressionType expressionType, BigDecimal right) {
		BigDecimal numberResult = null;
		boolean boolResult = false;
		switch(expressionType) {
		case Addition:
			numberResult = left.add(right);
			break;
		case Division:
			numberResult = left.divide(right);
			break;
		case Multiplication:
			numberResult = left.multiply(right);
			break;
		case Subtraction:
			numberResult = left.subtract(right);
			break;
		case Equals:
			boolResult = left.compareTo(right) == 0;
			break;
		case Greater:
			boolResult = left.compareTo(right) > 0;
			break;
		case GreaterOrEqual:
			boolResult = left.compareTo(right) >= 0;
			break;
		case Less:
			boolResult = left.compareTo(right) < 0;
			break;
		case LessOrEqual:
			boolResult = left.compareTo(right) <= 0;
			break;
		}
		if (numberResult != null) {
			return new RealLiteral(numberResult);
		}else {
			return new BooleanLiteral(boolResult);
		}
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(Addition operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}
	
	@SuppressWarnings("rawtypes")
	public Expression evaluate(Division operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}
	
	@SuppressWarnings("rawtypes")
	public Expression evaluate(Multiplication operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}
	
	@SuppressWarnings("rawtypes")
	public Expression evaluate(Subtraction operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}

	public Expression evaluate(BaseVariable baseVariable) {
		switch(baseVariable.getVariableType()) {
		case Bool:
			return new BooleanLiteral((Boolean)values.get(baseVariable.getId()));
		case Double:
			return new RealLiteral((BigDecimal)values.get(baseVariable.getId()));
		case Int32:
			return new IntegerLiteral((BigInteger)values.get(baseVariable.getId()));
		}
		return null;
	}

	public Expression evaluate(IntegerLiteral integerLiteral) {
		//Note: realLiteral.getValue returns a BigInteger, which has an intValue() method that may be useful
		//Or you can use BigInteger other methods to do perfect precision math on other BigIntegers
		return integerLiteral;
	}

	public Expression evaluate(RealLiteral realLiteral) {
		//Note: realLiteral.getValue returns a BigDecimal, which has a doubleValue() method that may be useful
		//Or you can use BigDecimal's other methods to do perfect precision math on other BigDecimals
		return realLiteral;
	}
	
	public Expression evaluate(BooleanLiteral booleanLiteral) {
		return booleanLiteral;
	}

	public Expression evaluate(AndExpression andExpression) {
		BooleanLiteral left = (BooleanLiteral) andExpression.getLeft().evaluate(this);
		BooleanLiteral right = (BooleanLiteral) andExpression.getRight().evaluate(this);
		return new BooleanLiteral(left.getValue() && right.getValue());
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(GreaterExpression operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}
	
	@SuppressWarnings("rawtypes")
	public Expression evaluate(GreaterOrEqualExpression operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(LessExpression operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(LessOrEqualExpression operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(AssignmentExpression assignmentExpression) {
		BaseLiteral evaluatedValue = (BaseLiteral) assignmentExpression.getRightSide().evaluate(this);
		evaluatedValue = typeCoerce(evaluatedValue, assignmentExpression.getAssignTo().getVariableType());
		values.put(assignmentExpression.getAssignTo().getId(), evaluatedValue.getValue());
//		AssignmentExpression evaluatedExpression = new AssignmentExpression(assignmentExpression.getAssignTo(), evaluatedValue);
		AssignmentExpression evaluatedExpression = new AssignmentExpression(assignmentExpression.getAssignTo(), evaluatedValue, assignmentExpression.lineNumber, assignmentExpression.lineString);
		return evaluatedExpression;
	}
	
	public Expression evaluate(UninitializedVariableDeclaration uninitializedVariableDeclaration) {
		String ID = uninitializedVariableDeclaration.getID();
		VariableType varType = uninitializedVariableDeclaration.getVariableType();
		values.put(ID, null);
		variableTypes.put(ID, varType);
		return uninitializedVariableDeclaration;
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(EqualsExpression equalsExpression) {
		BaseLiteral left = (BaseLiteral) equalsExpression.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) equalsExpression.getRight().evaluate(this);
		BooleanLiteral equals;
		if (left.getLiteralType() == LiteralType.Real || left.getLiteralType() == LiteralType.Integer) {
			equals = (BooleanLiteral)doNumericOperation(left, ExpressionType.Equals, right);
		}else {
			equals = new BooleanLiteral(left.getValue().equals(right.getValue()));
		}
		return equals;
	}

	public Expression evaluate(OrExpression orExpression) {
		BooleanLiteral left = (BooleanLiteral) orExpression.getLeft().evaluate(this);
		BooleanLiteral right = (BooleanLiteral) orExpression.getRight().evaluate(this);
		return new BooleanLiteral(left.getValue() || right.getValue());
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(Int32InitializedVariableDeclaration declaration) {
		String ID = declaration.getID();
		VariableType varType = declaration.getVariableType();
		BaseLiteral initialValue = (BaseLiteral) declaration.getInitialValue().evaluate(this);
		initialValue = typeCoerce(initialValue, varType);
		Int32InitializedVariableDeclaration evaluatedDeclaration = new Int32InitializedVariableDeclaration(ID, initialValue, declaration.lineNumber, declaration.lineString);
		values.put(ID, initialValue.getValue());
		variableTypes.put(ID, varType);
		return evaluatedDeclaration;
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(DoubleInitializedVariableDeclaration declaration) {
		String ID = declaration.getID();
		VariableType varType = declaration.getVariableType();
		BaseLiteral initialValue = (BaseLiteral) declaration.getInitialValue().evaluate(this);
		initialValue = typeCoerce(initialValue, varType);
		DoubleInitializedVariableDeclaration evaluatedDeclaration = new DoubleInitializedVariableDeclaration(ID, initialValue, declaration.lineNumber, declaration.lineString);
		values.put(ID, initialValue.getValue());
		variableTypes.put(ID, varType);
		return evaluatedDeclaration;
	}

	@SuppressWarnings("rawtypes")
	private BaseLiteral typeCoerce(BaseLiteral initialValue, VariableType varType) {
		if (initialValue.getLiteralType() == LiteralType.Integer && varType == VariableType.Double) {
			BigDecimal convertedInteger = new BigDecimal((BigInteger)initialValue.getValue());
			return new RealLiteral(convertedInteger);
		}else if (initialValue.getLiteralType() == LiteralType.Real && varType == VariableType.Int32) {
			BigInteger truncated = ((BigDecimal)initialValue.getValue()).toBigInteger();
			return new IntegerLiteral(truncated);
		}
		return initialValue;
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(BoolInitializedVariableDeclaration declaration) {
		String ID = declaration.getID();
		VariableType varType = declaration.getVariableType();
		BaseLiteral initialValue = (BaseLiteral) declaration.getInitialValue().evaluate(this);
		BoolInitializedVariableDeclaration evaluatedDeclaration = new BoolInitializedVariableDeclaration(ID, initialValue, declaration.lineNumber, declaration.lineString);
		values.put(ID, initialValue.getValue());
		variableTypes.put(ID, varType);
		return evaluatedDeclaration;
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(FunctionCall functionCall) {
		Function toCall = functions.get(functionCall.getFunctionId());
		List<InitializedVariableDeclaration> initialValues = new ArrayList<>();
		for (int paramIndex = 0; paramIndex < toCall.getParameters().size(); paramIndex++) {
			UninitializedVariableDeclaration declaration = toCall.getParameter(paramIndex);
			Expression value = functionCall.getParameter(paramIndex).evaluate(this);
			initialValues.add(declaration.initialize(value));
		}
		return evaluate(toCall, initialValues);
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(Function currentFunction, List<InitializedVariableDeclaration> initialValues) {
		if (OUTPUT_FUNCTION_CALLS) {
			evaluationResults.add("CALL:" + currentFunction + "," + initialValues);
		}
		Evaluator functionEvaluator = new Evaluator(functions, evaluationResults, controlCoverage, dataCoverage);
		for (InitializedVariableDeclaration declaration : initialValues) {
			declaration.evaluate(functionEvaluator);
		}
		
		
		List<Expression> expressionList = currentFunction.getExpressions();
		Expression toReturn = null;
		
		/*These 3 variables keep track of while loops*/
		boolean inWhileLoop = false;
		int indexOfEndOfWhile = 0;
		int whileLoopExpressionSize = 0;
		
		for (int expressionIndex = 0; expressionIndex < expressionList.size(); expressionIndex++) {
			Expression currentExpression = expressionList.get(expressionIndex);
			dataCoverage.setFunction(currentFunction);
			dataCoverage.setExpression(currentExpression);
			dataCoverage.expressionExecuted();
			
			if (OUTPUT_WRITTEN_STATEMENTS) {
				evaluationResults.add("WRIT:"+currentExpression.toString());
			}
			Expression result = currentExpression.evaluate(functionEvaluator);
			
			if (OUTPUT_EVALUATED_STATEMENTS) {
				evaluationResults.add("EVAL:"+result.toString());
			}

			controlCoverage.currentFunction(currentFunction);
			
			
			if(currentExpression.getExpressionType() != ExpressionType.IfThen 
					&& currentExpression.getExpressionType() != ExpressionType.IfThenElse
					&& currentExpression.getExpressionType() != ExpressionType.WhileLoop) {
				controlCoverage.expressionExecuted(currentExpression);
			}else if(currentExpression.getExpressionType() == ExpressionType.IfThen){
				IfThen condResult = (IfThen)result;
				BooleanLiteral condValue = (BooleanLiteral) condResult.getCondition();
				controlCoverage.conditionalExecuted((IfThen) currentExpression, condValue);
			}else if(currentExpression.getExpressionType() == ExpressionType.WhileLoop) {
				WhileLoop condResult = (WhileLoop) result;
				BooleanLiteral condValue = (BooleanLiteral) condResult.getCondition();
				controlCoverage.conditionalExecuted((WhileLoop) currentExpression, condValue);
			}else {
				IfThenElse condResult = (IfThenElse)result;
				BooleanLiteral condValue = (BooleanLiteral) condResult.getCondition();
				controlCoverage.conditionalExecuted((IfThenElse) currentExpression, condValue);
			}
			
			if(skipElseIf) {
				expressionIndex = getEndOfElseIfChain(expressionIndex, expressionList);
				continue;
			}
			
			if(inWhileLoop && expressionIndex == indexOfEndOfWhile) {
				expressionIndex -= whileLoopExpressionSize +1; //+1 to include the whileclause
			}else if (result.getExpressionType() == ExpressionType.Return) {
				toReturn = ((Return)result).getValue();
				break;
			} else if (result.getExpressionType() == ExpressionType.IfThen) {
				IfThen ifThenResult = (IfThen)result;
				BooleanLiteral executeThen = (BooleanLiteral) ifThenResult.getCondition();
				//If the if condition evaluates to false then skip forward by however many expressions are contained in it
				if (!executeThen.getValue() || skipElseIf) {
					//Subtract 1 here because the contained expression count includes the if expression we are currently on
					expressionIndex=getEndOfElseIfChain(expressionIndex, expressionList);
				}
			} else if (result.getExpressionType() == ExpressionType.IfThenElse) {
				IfThenElse ifThenElseResult = (IfThenElse)result;
				BooleanLiteral executeThen = (BooleanLiteral) ifThenElseResult.getCondition();
				if (!executeThen.getValue() || skipElseIf) {
					expressionIndex=getEndOfElseIfChain(expressionIndex, expressionList);
				} else {
					skipElseIf = true;
				}
			}else if (result.getExpressionType() == ExpressionType.WhileLoop) {
				WhileLoop whileResult = (WhileLoop)result;
				BooleanLiteral executeLoop = (BooleanLiteral) whileResult.getCondition();
				if(!executeLoop.getValue()) {
					expressionIndex += whileResult.getContainedExpressionCount() - 1;
				} else {
					//while condition is true, after we finish evaluating the expressions inside
					//we would have to go back and check condition is true
					inWhileLoop = true;
					//Subtract 1 here because the contained expression count includes the if expression we are currently on
					whileLoopExpressionSize = whileResult.getContainedExpressionCount() - 1;
					indexOfEndOfWhile = expressionIndex + whileResult.getContainedExpressionCount() - 1;

				}
			}
			
		}
		return toReturn;
	}

	private int getEndOfElseIfChain(int expressionIndex, List<Expression> expressions) {
		Expression currentExpression = expressions.get(expressionIndex);
		do {
			if(currentExpression.getExpressionType() == ExpressionType.IfThen 
					|| currentExpression.getExpressionType() == ExpressionType.IfThenElse) {
				controlCoverage.conditionalExecuted(currentExpression, new BooleanLiteral(false));
			}
			if(currentExpression.getExpressionType() == ExpressionType.IfThen || currentExpression.getExpressionType() == ExpressionType.ElseBody)
				skipElseIf = false;
			expressionIndex += currentExpression.getContainedExpressionCount();
			if (expressionIndex >= expressions.size()) {
				skipElseIf = false;
				return expressionIndex;
			}
			currentExpression = expressions.get(expressionIndex);
		}
		while (skipElseIf);
		return expressionIndex - 1; //Subtract 1 to capture the starting if statement
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(Function currentFunction) {
		return evaluate(currentFunction, new ArrayList<InitializedVariableDeclaration>());		
	}

	public Expression evaluate(Return returnExpression) {
		return new Return(returnExpression.getValue().evaluate(this), returnExpression.getLineNumber(), returnExpression.getLineString());
	}

	public Expression evaluate(IfThen ifThen) {
		BooleanLiteral evaluatedCondition = (BooleanLiteral) ifThen.getCondition().evaluate(this);
		return new IfThen(evaluatedCondition, ifThen.getContainedExpressions(), ifThen.getLineNumber(), ifThen.getLineString());
	}

	public Expression evaluate(IfThenElse ifThenElse)
	{
		BooleanLiteral evaluatedCondition = (BooleanLiteral) ifThenElse.getCondition().evaluate(this);
		return new IfThenElse(evaluatedCondition, ifThenElse.getContainedExpressions(), ifThenElse.getElseBlock(), ifThenElse.getLineNumber(), ifThenElse.getLineString());
	}

	public Expression evaluate(ElseBody elseBody)
	{
		return new ElseBody(elseBody.getContainedExpressions());
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(BitwiseAnd operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(BitwiseOr operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}

	@SuppressWarnings("rawtypes")
	public Expression evaluate(BitwiseXor operation) {
		BaseLiteral left = (BaseLiteral) operation.getLeft().evaluate(this);
		BaseLiteral right = (BaseLiteral) operation.getRight().evaluate(this);
		return doNumericOperation(left, operation.getExpressionType(), right);
	}

	public Expression evaluate(WhileLoop whileLoop) {
		BooleanLiteral evaluatedCondition = (BooleanLiteral) whileLoop.getCondition().evaluate(this);
		return new WhileLoop(evaluatedCondition, whileLoop.getContainedExpressions(), whileLoop.getLineNumber(), whileLoop.getLineString());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Expression evaluate(ArrayDeclaration arrayDeclaration) {
		String ID = arrayDeclaration.getID();
		VariableType varType = arrayDeclaration.getVariableType();

		List<Expression> initialValues = arrayDeclaration.getInitialValues();
		List evaluatedValues;
		switch(varType) {
		case Bool:
			evaluatedValues = new ArrayList<BooleanLiteral>();
			break;
		case Double:
			evaluatedValues= new ArrayList<RealLiteral>();
			break;
		case Int32:
			evaluatedValues= new ArrayList<IntegerLiteral>();
			break;
		default:
			evaluatedValues=null;
			break;
		}
		for (Expression currentExpression : initialValues) {
			evaluatedValues.add(currentExpression.evaluate(this));
		}
		ArrayDeclaration evaluatedDeclaration = new ArrayDeclaration(ID, varType, evaluatedValues);
		values.put(ID, evaluatedValues);
		variableTypes.put(ID, varType);
		return evaluatedDeclaration;
	}

	@SuppressWarnings("unchecked")
	public Expression evaluate(ArrayAccessExpression arrayAccessExpression) {
		String id = arrayAccessExpression.getId();
		Expression indexExpression = arrayAccessExpression.getIndex().evaluate(this);
		int indexNumber = ((IntegerLiteral) indexExpression).getValue().intValue();
		List<Expression> arrayValues = (List<Expression>) values.get(id);
		return arrayValues.get(indexNumber);
	}

	@SuppressWarnings("unchecked")
	public Expression evaluate(ArrayAssignmentExpression arrayAssignmentExpression)
	{
		Expression evaluatedValue = arrayAssignmentExpression.getRightSide().evaluate(this);
		ArrayAccessExpression assignTo = (ArrayAccessExpression) arrayAssignmentExpression.getAssignTo();

		IntegerLiteral indexExpression =  (IntegerLiteral) assignTo.getIndex().evaluate(this);
		int indexNumber = indexExpression.getValue().intValue();
		List<Expression> arrayValues = (List<Expression>) values.get(assignTo.getId());

		arrayValues.set(indexNumber, evaluatedValue);

		return assignTo;
	}


	@SuppressWarnings("rawtypes")
	public Expression evaluate(PrintExpression printExpression)
	{
		Expression exprToPrint = printExpression.getExpressionToPrint().evaluate(this);
		System.out.println( ((BaseLiteral) exprToPrint).getValue());
		return printExpression;
	}
}
