package expression.LogicalExpressions;

import expression.Evaluator;
import expression.Expression;
import expression.ExpressionType;

public class OrExpression extends LogicalTwoElementExpression {

	public OrExpression(LogicalExpression left, LogicalExpression right) {
		super(left, right);
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.Or;
	}

}
