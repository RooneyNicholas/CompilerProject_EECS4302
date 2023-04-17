package codeCoverage;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import expression.Expression;
import expression.Function;
import expression.LogicalExpressions.BooleanLiteral;

public class ControlCoverage implements ExpressionListener{
	private LinkedHashMap<Function, List<EvaluationStatus>> evals = new LinkedHashMap<>();
	private LinkedHashMap<Function, List<Expression>> allExpr = new LinkedHashMap<>();
	private Function currentFunction;
	
	
	public ControlCoverage(Map<String, Function> expressions) {
		evals = new LinkedHashMap<>();
		for (Entry<String, Function> e: expressions.entrySet()) {
			evals.put(e.getValue(), new ArrayList<>(e.getValue().getExpressions().size()));
			allExpr.put(e.getValue(), new ArrayList<>(e.getValue().getExpressions().size()));
			List<Expression> temp = allExpr.get(e.getValue());
			for (Expression expr: e.getValue().getExpressions()) {
				temp.add(expr);
				evals.get(e.getValue()).add(EvaluationStatus.None);
			}
		}
	}
	
	public LinkedHashMap<Function, List<EvaluationStatus>> getControlCoverage() {
		return evals;
	}

	public void expressionExecuted(Expression e) {
		if(allExpr.get(currentFunction).contains(e)) {
			int index = allExpr.get(currentFunction).indexOf(e);
			List<EvaluationStatus> temp = evals.get(currentFunction);
			temp.set(index, EvaluationStatus.Complete);
		}
		
	}
	
	public void conditionalExecuted(Expression e, BooleanLiteral condition) {
		if(allExpr.get(currentFunction).contains(e)) {
			int index = allExpr.get(currentFunction).indexOf(e);
			List<EvaluationStatus> temp = evals.get(currentFunction);
			if (temp.get(index) == EvaluationStatus.None) {
				if(condition.getValue()) {
					temp.set(index, EvaluationStatus.SomeTrue);
				}else {
					temp.set(index, EvaluationStatus.SomeFalse);
				}
				
			}else if(temp.get(index) == EvaluationStatus.SomeTrue || temp.get(index) == EvaluationStatus.SomeFalse) {
				if((condition.getValue() && temp.get(index) == EvaluationStatus.SomeFalse) || (!condition.getValue() && temp.get(index) == EvaluationStatus.SomeTrue)) {
					temp.set(index, EvaluationStatus.Complete);
				}
			}
		}
		
	}
	public void currentFunction(Function f) {
		currentFunction = f;
	}
}
