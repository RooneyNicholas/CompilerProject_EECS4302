package expression;

import java.util.ArrayList;
import java.util.List;

public class Function extends BaseExpression {
	protected List<UninitializedVariableDeclaration> parameters = new ArrayList<>();
	protected List<Expression> expressions = new ArrayList<>();
	protected boolean isMain;
	protected final String id;
	
	public boolean isMain() {
		return isMain;
	}

	public Function(String id) {
		super();
		isMain = false;
		this.id = id;
	}

	public void addExpression(Expression newExpression) {
		if (newExpression != null) {
			expressions.add(newExpression);
		}
	}

	public List<Expression> getExpressions() {
		return expressions;
	}

	public List<UninitializedVariableDeclaration> getParameters() {
		return parameters;
	}

	public String getID() {
		return this.id;
	}

	public void addParameterExpression(UninitializedVariableDeclaration newParameter) {
		if (newParameter != null) {
			parameters.add(newParameter);
		}
	}

	public UninitializedVariableDeclaration getParameter(int paramIndex) {
		return parameters.get(paramIndex);
	}

	@Override
	public Expression evaluate(Evaluator evaluateWith) {
		return evaluateWith.evaluate(this);
	}

	@Override
	public ExpressionType getExpressionType() {
		return ExpressionType.Function;
	}

	@Override
	public String toString() {
		return "[" + getExpressionType() + " " + getID() + "]";
	}
	
}
