package expression;

import java.util.List;


public class WhileLoop extends BaseExpression implements ExpressionContainer{
	private final Expression condition;
	private final List<Expression> containedExpressions;
	
	public List<Expression> getContainedExpressions() {
		return containedExpressions;
	}
	
	public WhileLoop(Expression condition, List<Expression> containedExpressions, int lineNumber, String lineString) {
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
		return ExpressionType.WhileLoop;
	}

	@Override
	public String toString() {
		return "[" + getExpressionType() + ": " + condition + "]";
	}

	public Expression getCondition() {
		return condition;
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
