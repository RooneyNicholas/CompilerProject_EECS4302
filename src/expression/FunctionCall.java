package expression;

import java.util.List;

public class FunctionCall extends BaseExpression {
	private final String functionId;
	private final List<Expression> parameters;
	
	public String getFunctionId() {
		return functionId;
	}

	public List<Expression> getParameters() {
		return parameters;
	}

	public FunctionCall(String functionId, List<Expression> parameters) {
		super();
		this.functionId = functionId;
		this.parameters = parameters;
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.FunctionCall;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[" + getExpressionType());
		builder.append(" " + functionId);
		for (Expression currentParameter: parameters) {
			builder.append(currentParameter.toString());
		}
		builder.append("]");
		return builder.toString();
	}

	public Expression getParameter(int paramIndex) {
		return parameters.get(paramIndex);
	}

}
