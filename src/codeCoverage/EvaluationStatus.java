package codeCoverage;

public enum EvaluationStatus {
	None("not Evaluated"), 
	SomeTrue("only true was evaluated"),
	SomeFalse("only false was evaluated"),
	Complete("complete");
		
	private final String stringRepresentation;
		
	EvaluationStatus(String stringRepresentation){
		this.stringRepresentation = stringRepresentation;
	}
		
	@Override
	public String toString() {
		return stringRepresentation;
	}
}
