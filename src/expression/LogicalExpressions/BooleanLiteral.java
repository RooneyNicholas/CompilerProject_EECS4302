package expression.LogicalExpressions;

import expression.BaseLiteral;
import expression.Evaluator;
import expression.Expression;
import expression.LiteralType;

public class BooleanLiteral extends BaseLiteral<Boolean> implements LogicalExpression {
	Boolean value;
	
	public BooleanLiteral(boolean value) {
		this.value = value;
	}

	public BooleanLiteral(String boolVal) {
		this.value = Boolean.parseBoolean(boolVal);
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public LiteralType getLiteralType() {
		return LiteralType.Boolean;
	}

	@Override
	public Boolean getValue() {
		return value;
	}

}
