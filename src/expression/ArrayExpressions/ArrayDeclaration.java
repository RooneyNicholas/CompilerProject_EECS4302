package expression.ArrayExpressions;

import expression.*;

import java.util.List;

public class ArrayDeclaration extends BaseExpression
{
    private final String id;
    private final VariableType variableType;
    private final List<Expression> initialValues;

    public String getID() {
        return this.id;
    }

    public VariableType getVariableType() {
        return this.variableType;
    }

    public List<Expression> getInitialValues() {
        return this.initialValues;
    }

    public ArrayDeclaration(String id, VariableType variableType, List<Expression> initialValues) {
        this.id = id;
        this.variableType = variableType;
        this.initialValues = initialValues;
    }

    @Override
    public Expression evaluate(Evaluator evaluateWith) {
        return evaluateWith.evaluate(this);
    }

    @Override
    public ExpressionType getExpressionType()
    {
        return ExpressionType.Array;
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder("[" + getExpressionType() + " ID: " + getID() + ", type: "+ variableType + ", value:");
        for(Expression e : getInitialValues()){
            output.append(" ");
            output.append(e.toString());
        }
        output.append("]");
        return output.toString();
    }


}
