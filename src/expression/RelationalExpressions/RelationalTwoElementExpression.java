package expression.RelationalExpressions;

import expression.TwoElementExpression;
import expression.ArithmeticExpressions.ArithmeticExpression;

public abstract class RelationalTwoElementExpression
		extends TwoElementExpression<ArithmeticExpression, ArithmeticExpression> implements RelationalExpression {

	public RelationalTwoElementExpression(ArithmeticExpression left, ArithmeticExpression right) {
		super(left, right);
	}

}
