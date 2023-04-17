package expression;

public abstract class BaseExpression implements Expression {

	@Override
	public abstract String toString();
	
	@Override
	public int getContainedExpressionCount() {
		return 1;
	}

	/*Main usecase for data-flow cov:*/
	public boolean hasLine = false;
	public String lineString = null;
	public int lineNumber = -1;
	
	@Override
	public boolean hasLineNumber() {
		
		return hasLine;
	}

	@Override
	public int getLineNumber() {
		
		return lineNumber;
	}

	@Override
	public String getLineString() {
		
		return lineString;
	}
	
	
	
}
