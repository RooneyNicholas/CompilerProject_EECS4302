package expression.ArithmeticExpressions;

import java.math.BigDecimal;

import expression.Evaluator;
import expression.Expression;
import expression.InitializedVariableDeclaration;
import expression.VariableType;

public class DoubleInitializedVariableDeclaration extends InitializedVariableDeclaration<BigDecimal> {

	public DoubleInitializedVariableDeclaration(String ID, Expression initialValue, int lineNumber, String lineString) {
//		super(ID, VariableType.Double, initialValue);
		super(ID, VariableType.Double, initialValue, lineNumber, lineString);
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

}
