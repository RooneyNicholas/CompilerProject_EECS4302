package expression;

public enum VariableType {
	Int32("int32"), 
	Double("double"), 
	Bool("bool");
	
	private final String stringRepresentation;
	
	VariableType(String stringRepresentation){
		this.stringRepresentation = stringRepresentation;
	}
	
	@Override
	public String toString() {
		return stringRepresentation;
	}
}
