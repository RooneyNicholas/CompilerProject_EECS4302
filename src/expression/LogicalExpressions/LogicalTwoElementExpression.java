package expression.LogicalExpressions;

import expression.TwoElementExpression;

public abstract class LogicalTwoElementExpression extends TwoElementExpression<LogicalExpression, LogicalExpression> implements LogicalExpression {

	public LogicalTwoElementExpression(LogicalExpression left, LogicalExpression right) {
		super(left, right);
	}

}
