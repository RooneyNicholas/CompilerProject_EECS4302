package expression;

import java.util.List;

public class ElseBody extends BaseExpression implements ExpressionContainer
{

    private final List<Expression> containedExpressions;

    public ElseBody(List<Expression> containedExpressions) {
        this.containedExpressions = containedExpressions;
    }

    public List<Expression> getContainedExpressions() {
        return containedExpressions;
    }

    @Override
    public Expression evaluate(Evaluator evaluateWith) {
        return evaluateWith.evaluate(this);
    }

    @Override
    public ExpressionType getExpressionType() {
        return ExpressionType.ElseBody;
    }

    @Override
    public String toString() {
        return "[" + getExpressionType() + ": " + "]";
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
