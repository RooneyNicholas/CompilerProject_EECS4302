package expression.ArithmeticExpressions;

import expression.BaseVariable;
import expression.VariableType;

public class Int32Expression extends BaseVariable implements ArithmeticExpression {

	public Int32Expression(String id) {
		super(id);
	}

	@Override
	public VariableType getVariableType() {
		return VariableType.Int32;
	}
}
