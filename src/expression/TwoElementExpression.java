package expression;

public abstract class TwoElementExpression<Left extends Expression, Right extends Expression> extends BaseExpression {
	
	protected final Left left;
	protected final Right right;
	
	public TwoElementExpression(Left left, Right right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "[" + left + " " + getExpressionType() + " " + right + "]";
	}

	public Left getLeft() {
		return left;
	}

	public Right getRight() {
		return right;
	}
	
}
