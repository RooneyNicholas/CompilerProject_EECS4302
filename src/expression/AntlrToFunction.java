package expression;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.FunctionDeclarationContext;
import antlr.ExprParser.MainDeclarationContext;
import antlr.ExprParser.TestDeclarationContext;

public class AntlrToFunction extends ExprBaseVisitor<Function> {
	private List<String> semanticErrors;
	static int mainCounter = 0;

	public AntlrToFunction(List<String> semanticErrors) {
		super();
		this.semanticErrors = semanticErrors;
	}

	@Override
	public Function visitFunctionDeclaration(FunctionDeclarationContext ctx) {
		Function newFunction = new Function(ctx.getChild(1).getText());
		return visitFunction(ctx.children, newFunction);
	}
	
	@Override
	public Function visitMainDeclaration(MainDeclarationContext ctx) {
		Function newFunction = new MainFunction("main"+mainCounter);
		mainCounter++;
		return visitFunction(ctx.children, newFunction);
	}
	
	@Override
	public Function visitTestDeclaration(TestDeclarationContext ctx) {
//		Function newFunction = new MainFunction("main"+mainCounter);
		Function newFunction = new MainFunction(ctx.getChild(1).getText());
//		mainCounter++; // need to check after
		return visitFunction(ctx.children, newFunction);
	}

	private Function visitFunction(List<ParseTree> children, Function newFunction) {
		AntlrToExpression expressionVisitor = new AntlrToExpression(semanticErrors);
		ParseTree paramList = children.get(3);
		for (int paramIndex = 0; paramIndex < paramList.getChildCount(); paramIndex++) {
			newFunction.addParameterExpression((UninitializedVariableDeclaration) expressionVisitor.visit(paramList.getChild(paramIndex)));
		}
		expressionVisitor.setupParameters(newFunction.getParameters());
		for (int childIndex = 5; childIndex < children.size()-1; childIndex++){
			Expression newExpression = expressionVisitor.visit(children.get(childIndex));
			addExpression(newFunction, newExpression);
		}
		return newFunction;
	}

	private void addExpression(Function newFunction, Expression newExpression)
	{
		newFunction.addExpression(newExpression);
		if (newExpression != null && newExpression.getContainedExpressionCount() != 1) {
			for (Expression subExpression : ((ExpressionContainer) newExpression).getContainedExpressions()) {
				addExpression(newFunction, subExpression);
			}
			if (newExpression.getExpressionType() == ExpressionType.IfThenElse) {
				Expression elseExpression = ((IfThenElse)newExpression).getElseBlock();
				addExpression(newFunction, elseExpression);
			}
		}
	}
}
