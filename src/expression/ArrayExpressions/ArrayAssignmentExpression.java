package expression.ArrayExpressions;

import expression.*;

public class ArrayAssignmentExpression extends AssignmentExpression
{
	public ArrayAssignmentExpression(ArrayAccessExpression assignTo, Expression rightHandSide, int lineNumber, String lineString) {
		super(assignTo, rightHandSide, lineNumber, lineString);
	}

    @Override
    public Expression evaluate(Evaluator evaluateWith) {
        return evaluateWith.evaluate(this);
    }

    @Override
    public ExpressionType getExpressionType() {
        return ExpressionType.ArrayAssignment;
    }

    
}
