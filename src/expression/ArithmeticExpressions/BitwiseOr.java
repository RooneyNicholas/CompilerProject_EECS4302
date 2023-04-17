package expression.ArithmeticExpressions;

import expression.Evaluator;
import expression.Expression;
import expression.ExpressionType;

public class BitwiseOr extends ArithmeticTwoElementExpression{

    public BitwiseOr(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    public Expression evaluate(Evaluator evaluateWith) {
        return evaluateWith.evaluate(this);
    }

    @Override
    public ExpressionType getExpressionType() {
        return ExpressionType.BitwiseOr;
    }
}
