package expression;

public class AssignmentExpression extends BaseExpression {
	
	private final BaseVariable assignTo;
	private final Expression rightSide;
	
	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.Assignment;
	}

	public AssignmentExpression(BaseVariable assignTo, Expression rightHandSide, int lineNumber, String lineString) {
		super();
		this.assignTo = assignTo;
		this.rightSide = rightHandSide;
		
		this.hasLine = true;
		this.lineNumber = lineNumber;
		this.lineString = lineString;
	}

	public BaseVariable getAssignTo() {
		return assignTo;
	}

	public Expression getRightSide() {
		return rightSide;
	}

	@Override
	public String toString() {
		return "[" + getAssignTo() + " " + getExpressionType() + " " + getRightSide() + "]";
	}

}
