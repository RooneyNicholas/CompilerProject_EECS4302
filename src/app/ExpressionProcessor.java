package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import codeCoverage.ControlCoverage;
import codeCoverage.DataCoverage;
import expression.Evaluator;
import expression.Function;

public class ExpressionProcessor {
	private Map<String, Function> functions;
	private ControlCoverage controlCoverage;
	private DataCoverage dataCoverage;
	
	public ExpressionProcessor(Map<String, Function> functions) {
		this.functions = functions;
		dataCoverage = new DataCoverage(functions);
		controlCoverage = new ControlCoverage(functions);
	}
	
	public List<String> getEvaluationResults() {
		List<String> evaluationResults = new ArrayList<>();
		for (Function currentFunction : functions.values()) {
			if (currentFunction.isMain()) {
				execute(currentFunction, evaluationResults);
			}
		}
		return evaluationResults;
	}
	
	public DataCoverage getDataCoverage(){
		return dataCoverage;
	}
	
	public ControlCoverage getControlCoverage(){
		return controlCoverage;
	}
	
	private void execute(Function currentFunction, List<String> evaluationResults) {
		Evaluator functionEvaluator;
		functionEvaluator = new Evaluator(functions, evaluationResults, controlCoverage, dataCoverage);
		currentFunction.evaluate(functionEvaluator);
	}
	
	
}
