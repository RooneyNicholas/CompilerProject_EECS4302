package expression.RelationalExpressions;

import expression.InitializedVariableDeclaration;
import expression.VariableType;
import expression.Evaluator;
import expression.Expression;
import expression.LogicalExpressions.LogicalExpression;

public class BoolInitializedVariableDeclaration extends InitializedVariableDeclaration<Boolean>
		implements LogicalExpression {

	public BoolInitializedVariableDeclaration(String ID, Expression initialValue, int lineNumber, String lineString) {
		super(ID, VariableType.Bool, initialValue, lineNumber, lineString);
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}
}
