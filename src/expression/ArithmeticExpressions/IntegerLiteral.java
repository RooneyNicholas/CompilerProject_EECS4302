package expression.ArithmeticExpressions;

import java.math.BigInteger;

import expression.BaseLiteral;
import expression.Evaluator;
import expression.Expression;
import expression.LiteralType;

public class IntegerLiteral extends BaseLiteral<BigInteger> implements ArithmeticExpression {
	private final BigInteger value;
	
	public IntegerLiteral(String value) {
		super();
		this.value = new BigInteger(value);
	}

	public IntegerLiteral(BigInteger value) {
		super();
		this.value = value;
	}

	public BigInteger getValue() {
		return value;
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	protected LiteralType getLiteralType() {
		return LiteralType.Integer;
	}
}
