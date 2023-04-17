package expression.ArithmeticExpressions;

import expression.BaseVariable;
import expression.VariableType;

public class DoubleExpression extends BaseVariable implements ArithmeticExpression{

	public DoubleExpression(String id) {
		super(id);
	}

	@Override
	public VariableType getVariableType() {
		return VariableType.Double;
	}
}