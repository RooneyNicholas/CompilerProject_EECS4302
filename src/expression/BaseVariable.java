package expression;

import java.util.Objects;

public abstract class BaseVariable extends BaseExpression {
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseVariable other = (BaseVariable) obj;
		return Objects.equals(id, other.id);
	}

	private final String id;

	public BaseVariable(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}
	
	public abstract VariableType getVariableType();
	
	@Override
	public String toString() {
		return "[" + getExpressionType() + " " + getVariableType() + " id=" + id + "]";
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.Variable;
	}
}
