package expression;

public abstract class BaseLiteral<T> extends BaseExpression {

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.Literal;
	}

	@Override
	public String toString() {
		return "[" + getExpressionType() + " " + getLiteralType() + ": " + getValue() + "]";
	}

	protected abstract LiteralType getLiteralType();

	protected abstract T getValue();
}
