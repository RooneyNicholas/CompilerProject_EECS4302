package expression.ArrayExpressions;

import expression.BaseVariable;
import expression.Evaluator;
import expression.Expression;
import expression.ExpressionType;
import expression.VariableType;

public class ArrayAccessExpression extends BaseVariable
{
    final private BaseVariable arrayVariable;
    final private Expression index;

    public ArrayAccessExpression(BaseVariable arrayVariable, Expression index) {
    	super(arrayVariable.getId());
    	this.arrayVariable = arrayVariable;
		this.index = index;
    }

    public String getId() {
        return arrayVariable.getId();
    }

    public Expression getIndex() {
        return this.index;
    }

    @Override
    public String toString()
    {
        return "[" + getExpressionType() + " ID: " + getId() + " @ index:" + index.toString() + "]";
    }

    @Override
    public Expression evaluate(Evaluator evaluateWith)
    {
        return evaluateWith.evaluate(this);
    }

    @Override
    public ExpressionType getExpressionType()
    {
        return ExpressionType.ArrayIndexed;
    }

	@Override
	public VariableType getVariableType() {
		return arrayVariable.getVariableType();
	}
}
