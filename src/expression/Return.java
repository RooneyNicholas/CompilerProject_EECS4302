package expression;

public class Return extends BaseExpression {
	private final Expression value;
	
	public Expression getValue() {
		return value;
	}

	public Return(Expression value, int lineNumber, String lineString) {
		this.value = value;
		
		this.hasLine = true;
		this.lineNumber = lineNumber;
		this.lineString = lineString;
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.Return;
	}

	@Override
	public String toString() {
		return "[" + getExpressionType() + " " + value + "]";
	}

}
