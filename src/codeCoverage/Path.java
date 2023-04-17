package codeCoverage;

import expression.AssignmentExpression;
import expression.BaseVariable;
import expression.Expression;
import expression.ExpressionType;
import expression.InitializedVariableDeclaration;
import expression.UninitializedVariableDeclaration;
import expression.ArithmeticExpressions.DoubleExpression;
import expression.ArithmeticExpressions.Int32Expression;
import expression.LogicalExpressions.BoolExpression;

public class Path {
	protected Expression def;
	protected UseType defType;
	protected BaseVariable defVar;
	protected Expression use = null;
	protected UseType useType;
	protected EvaluationStatus eval = EvaluationStatus.None;
	protected int inConditional = 0;
	protected boolean isParameter = false;

	public Path(Expression d) {
		def = d;
		if(d.getExpressionType() == ExpressionType.Assignment) {
			defType = UseType.Definition;
			defVar = ((AssignmentExpression)d).getAssignTo();
		}else if(d.getExpressionType() == ExpressionType.UninitializedVariableDeclaration) {
			defType = UseType.UninitializedDefinition;
			switch (((UninitializedVariableDeclaration)d).getVariableType()) {
			case Bool:
				defVar = new BoolExpression(((UninitializedVariableDeclaration)d).getID());
				break;
			case Double:
				defVar = new DoubleExpression(((UninitializedVariableDeclaration)d).getID());
				break;
			case Int32:
				defVar = new Int32Expression(((UninitializedVariableDeclaration)d).getID());
				break;
			default:
				break;
			}
		}else if(d.getExpressionType() == ExpressionType.InitializedVariableDeclaration) {
			defType = UseType.Definition;

			switch (((InitializedVariableDeclaration<?>)d).getVariableType()) {
			case Bool:
				defVar = new BoolExpression(((InitializedVariableDeclaration<?>)d).getID());
				break;
			case Double:
				defVar = new DoubleExpression(((InitializedVariableDeclaration<?>)d).getID());
				break;
			case Int32:
				defVar = new Int32Expression(((InitializedVariableDeclaration<?>)d).getID());
				break;
			default:
				break;
			}
		}
	}

	public void setUse(Expression newUse) {
		use = newUse;
		if(newUse.getExpressionType() == ExpressionType.IfThen || newUse.getExpressionType() == ExpressionType.WhileLoop
				|| newUse.getExpressionType() == ExpressionType.IfThenElse) {
			useType = UseType.PUse;
		}else {
			useType = UseType.CUse;
		}
	}


	public BaseVariable getDefVar() {
		return defVar;
	}

	public void evaluated() {
		eval = EvaluationStatus.Complete;
	}

	public EvaluationStatus getEvaluation() {
		return eval;
	}

	public Expression getDefinition() {
		return def;
	}

	public String getDefinitionString() {
		if (def != null && def.hasLineNumber()) {
			return  "<strong> "+ def.getLineNumber() + ". </strong>" + def.getLineString();
		} else {
			return getDefinition().toString();
		}
	}


	public UseType getDefType() {
		return defType;
	}

	public Expression getUse() {
		return use;
	}

	public String getUseString() {
		if(this.use != null) {
			if(use.hasLineNumber()) { // we can simplify
				return "<strong>" + use.getLineNumber() + ". </strong>" + use.getLineString();
			} else { // can't simplify use regular toString
				return use.toString();
			}
		}
		return null;
	}

	public UseType getUseType() {
		return useType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}
		Path other = (Path) obj;
		return def == other.def && use == other.use;
	}

	@Override
	public String toString() {
//		return "From " + def + " to " + use + " " + eval; // original
		String useString = null;
		String defString = null;
		if(this.use != null && use.hasLineNumber()) {
			useString = "Line " + use.getLineNumber() + " " + use;
		}
		
		if(this.def != null & def.hasLineNumber()) {
			defString = "Line " + def.getLineNumber() + " " + def;
		}
		
		return "From " + defString + " to " + useString + " " + eval;
	}


}
