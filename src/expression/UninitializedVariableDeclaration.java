package expression;

import expression.ArithmeticExpressions.DoubleInitializedVariableDeclaration;
import expression.ArithmeticExpressions.Int32InitializedVariableDeclaration;
import expression.RelationalExpressions.BoolInitializedVariableDeclaration;

public class UninitializedVariableDeclaration extends BaseExpression {
	
	private final String ID;
	private final VariableType variableType;
	
	public String getID() {
		return ID;
	}

	public VariableType getVariableType() {
		return variableType;
	}

	public UninitializedVariableDeclaration(String ID, VariableType variableType, int lineNumber, String lineString) {
		super();
		this.ID = ID;
		this.variableType = variableType;
		
		this.hasLine = true;
		this.lineNumber = lineNumber;
		this.lineString = lineString;
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}
	
	@SuppressWarnings("rawtypes")
	public InitializedVariableDeclaration initialize(Expression value) {
		switch(variableType) {
		case Bool:
			return new BoolInitializedVariableDeclaration(getID(), value, value.getLineNumber(), value.getLineString());
		case Double:
			return new DoubleInitializedVariableDeclaration(getID(), value, value.getLineNumber(), value.getLineString());
		case Int32:
			return new Int32InitializedVariableDeclaration(getID(), value, value.getLineNumber(), value.getLineString());
		}
		return null;
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.UninitializedVariableDeclaration;
	}

	@Override
	public String toString() {
		return "[" + getExpressionType() + " ID: " + getID() + ", type: "+ variableType +"]";
	}

}
