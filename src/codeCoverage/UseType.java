package codeCoverage;

public enum UseType {
		Definition("Variable Definition"), 
		UninitializedDefinition("Uninitialized"),
		CUse("Computation use"),
		PUse("Predicate use");
			
		private final String stringRepresentation;
			
		UseType(String stringRepresentation){
			this.stringRepresentation = stringRepresentation;
		}
			
		@Override
		public String toString() {
			return stringRepresentation;
		}
	}
