package expression;

public class PrintExpression extends BaseExpression
{

    private final Expression expressionToPrint;

    public PrintExpression(Expression expressionToPrint) {
        this.expressionToPrint = expressionToPrint;
    }

    public Expression getExpressionToPrint() {
        return expressionToPrint;
    }

    @Override
    public String toString()
    {
        return "[" + getExpressionType()  + " " + expressionToPrint.toString() + "]";
    }

    @Override
    public Expression evaluate(Evaluator evaluateWith)
    {
        return evaluateWith.evaluate(this);
    }

    @Override
    public ExpressionType getExpressionType()
    {
        return ExpressionType.PrintExpression;
    }
}
