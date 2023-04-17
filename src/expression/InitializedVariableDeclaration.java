package expression;

public abstract class InitializedVariableDeclaration<T> extends BaseExpression {

	private final String ID;
	private final VariableType variableType;
	private final Expression initialValue;
	
	public Expression getInitialValue() {
		return initialValue;
	}

	public String getID() {
		return ID;
	}

	public VariableType getVariableType() {
		return variableType;
	}

	public InitializedVariableDeclaration(String ID, VariableType variableType, Expression initialValue, int lineNumber, String lineString) {
		super();
		this.ID = ID;
		this.variableType = variableType;
		this.initialValue = initialValue;
		
		this.hasLine = true;
		this.lineNumber = lineNumber;
		this.lineString = lineString;
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.InitializedVariableDeclaration;
	}

	@Override
	public String toString() {
		return "[" + getExpressionType() + " ID: " + getID() + ", type: "+ variableType + ", value:"+ getInitialValue() +"]";
	}

}
