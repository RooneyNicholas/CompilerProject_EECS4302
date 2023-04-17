package expression.ArithmeticExpressions;

import expression.TwoElementExpression;

public abstract class ArithmeticTwoElementExpression extends TwoElementExpression<ArithmeticExpression, ArithmeticExpression> implements ArithmeticExpression {

	public ArithmeticTwoElementExpression(ArithmeticExpression left, ArithmeticExpression right) {
		super(left, right);
	}
}
