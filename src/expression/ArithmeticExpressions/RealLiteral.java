package expression.ArithmeticExpressions;

import java.math.BigDecimal;

import expression.BaseLiteral;
import expression.Evaluator;
import expression.Expression;
import expression.LiteralType;

public class RealLiteral extends BaseLiteral<BigDecimal> implements ArithmeticExpression{

	private BigDecimal value;
	
	public RealLiteral(String value) {
		super();
		this.value = new BigDecimal(value);
	}

	public RealLiteral(BigDecimal value) {
		super();
		this.value = value;
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public LiteralType getLiteralType() {
		return LiteralType.Real;
	}

	@Override
	public BigDecimal getValue() {
		return value;
	}

}
