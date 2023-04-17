package expression;

import java.util.LinkedHashMap;
import java.util.Map;

public class Program {
	
	Map<String, Function> functions = new LinkedHashMap<>();

	public void addFunction(Function newFunction) {
		functions.put(newFunction.getID(), newFunction);
	}

	public Map<String, Function> getFunctions() {
		return functions;
	}
}
