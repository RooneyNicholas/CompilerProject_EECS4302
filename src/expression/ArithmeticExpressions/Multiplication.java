package expression.ArithmeticExpressions;

import expression.Evaluator;
import expression.Expression;
import expression.ExpressionType;

public class Multiplication extends ArithmeticTwoElementExpression {

	public Multiplication(ArithmeticExpression left, ArithmeticExpression right) {
		super(left, right);
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.Multiplication;
	}
}
