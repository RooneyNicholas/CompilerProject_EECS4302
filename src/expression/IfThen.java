package expression;

import java.util.List;

public class IfThen extends BaseExpression implements ExpressionContainer {
	private final Expression condition;
	private final List<Expression> containedExpressions;
	
	public Expression getCondition() {
		return condition;
	}

	/**
	 * This returns a list of expressions contained in this if/then block.
	 * With the way the compiler is written we copy each expression out of this list and put it
	 * into the function body directly, and then if the condition statement evaluates to false we
	 * jump forwards by getContainedExpressionCount() (possible +/- 1) expressions to skip those statements
	 * @return
	 */
	@Override
	public List<Expression> getContainedExpressions() {
		return containedExpressions;
	}

	public IfThen(Expression condition, List<Expression> containedExpressions, int lineNumber, String lineString) {
		this.condition = condition;
		this.containedExpressions = containedExpressions;
		
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
		return ExpressionType.IfThen;
	}

	@Override
	public String toString() {
		return "[" + getExpressionType() + ": " + condition + "]";
	}

	@Override
	public int getContainedExpressionCount() {
		int expressionCount = 1;
		for (Expression containedExpression : containedExpressions) {
			expressionCount += containedExpression.getContainedExpressionCount();
		}
		return expressionCount;
	}
}
