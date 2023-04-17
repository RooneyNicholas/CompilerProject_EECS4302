package expression.ArithmeticExpressions;

import java.math.BigInteger;

import expression.Evaluator;
import expression.Expression;
import expression.InitializedVariableDeclaration;
import expression.VariableType;

public class Int32InitializedVariableDeclaration extends InitializedVariableDeclaration<BigInteger> {

	public Int32InitializedVariableDeclaration(String ID, Expression initialValue, int lineNumber, String lineString) {
		super(ID, VariableType.Int32, initialValue, lineNumber, lineString);
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

}
