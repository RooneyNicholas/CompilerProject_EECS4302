package expression;

import java.util.LinkedList;
import java.util.List;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.ProgramContext;

public class AntlrToProgram extends ExprBaseVisitor<Program> {
	private List<String> semanticErrors;

	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		semanticErrors = new LinkedList<>();
		AntlrToFunction functionVisitor = new AntlrToFunction(semanticErrors);
		for (int childIndex = 0; childIndex < ctx.children.size()-1; childIndex++){
			prog.addFunction(functionVisitor.visit(ctx.children.get(childIndex)));
		}

		return prog;
	}

	public List<String> getSemanticErrors() {
		return semanticErrors;
	}

}
