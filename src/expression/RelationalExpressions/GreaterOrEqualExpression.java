package expression.RelationalExpressions;

import expression.Evaluator;
import expression.Expression;
import expression.ExpressionType;
import expression.ArithmeticExpressions.ArithmeticExpression;

public class GreaterOrEqualExpression extends RelationalTwoElementExpression {

	public GreaterOrEqualExpression(ArithmeticExpression left, ArithmeticExpression right) {
		super(left, right);
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.GreaterOrEqual;
	}

}
