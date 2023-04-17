package codeCoverage;

public enum CoverageType {
	Statement("Statement Coverage"), 
	Decision("Decision Coverage");
		
	private final String stringRepresentation;
		
	CoverageType(String stringRepresentation){
		this.stringRepresentation = stringRepresentation;
	}
		
	@Override
	public String toString() {
		return stringRepresentation;
	}
}
