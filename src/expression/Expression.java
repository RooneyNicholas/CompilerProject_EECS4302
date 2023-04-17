package expression;


public interface Expression{
	public Expression evaluate(Evaluator evaluateWith);
	public ExpressionType getExpressionType();
	public int getContainedExpressionCount();
	
	/*For Data-Flow Coverage*/
	public boolean hasLineNumber();
	public int getLineNumber();
	public String getLineString();
	
}
