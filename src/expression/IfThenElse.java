package expression;

import java.util.List;

public class IfThenElse extends BaseExpression implements ExpressionContainer
{
    private final Expression condition;
    private final List<Expression> containedExpressions;
    private final Expression elseBlock;

    public IfThenElse(Expression condition, List<Expression> containedExpressions, Expression elseBlock, int lineNumber, String lineString) {
        this.condition = condition;
        this.containedExpressions = containedExpressions;
        this.elseBlock = elseBlock;
        
        this.hasLine = true;
        this.lineNumber = lineNumber;
        this.lineString = lineString;
    }


    public Expression getCondition() {
        return condition;
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
        return ExpressionType.IfThenElse;
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

    public Expression getElseBlock() {
        return elseBlock;
    }

}
