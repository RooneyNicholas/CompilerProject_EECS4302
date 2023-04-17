package expression.LogicalExpressions;

import expression.BaseVariable;
import expression.VariableType;

public class BoolExpression extends BaseVariable implements LogicalExpression{

	public BoolExpression(String id) {
		super(id);
	}

	@Override
	public VariableType getVariableType() {
		return VariableType.Bool;
	}

}
