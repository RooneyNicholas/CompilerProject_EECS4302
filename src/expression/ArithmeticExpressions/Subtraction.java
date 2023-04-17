package expression.ArithmeticExpressions;

import expression.Evaluator;
import expression.Expression;
import expression.ExpressionType;

public class Subtraction extends ArithmeticTwoElementExpression {

	public Subtraction(ArithmeticExpression left, ArithmeticExpression right) {
		super(left, right);
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.Subtraction;
	}
}
