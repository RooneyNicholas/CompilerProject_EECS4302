package expression;

public enum LiteralType {
	Integer("Integer"), 
	Real("Real"), 
	Boolean("Bool");

	private final String stringRepresentation;

	LiteralType(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}

	@Override
	public String toString() {
		return stringRepresentation;
	}
}
