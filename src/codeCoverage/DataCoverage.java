package codeCoverage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import expression.AssignmentExpression;

import expression.BaseVariable;

import expression.Expression;
import expression.ExpressionType;
import expression.Function;
import expression.FunctionCall;
import expression.IfThen;
import expression.IfThenElse;
import expression.InitializedVariableDeclaration;

import expression.Return;
import expression.TwoElementExpression;
import expression.UninitializedVariableDeclaration;
import expression.VariableType;
import expression.WhileLoop;
import expression.ArithmeticExpressions.DoubleExpression;
import expression.ArithmeticExpressions.Int32Expression;
import expression.LogicalExpressions.BoolExpression;


public class DataCoverage implements ExpressionListener{
	List<Expression> expressions; 
	
	
	Function currentFunction;
	Expression currentExpression;
	List<BaseVariable> partVar = new ArrayList<>();
	Map<Function, List<Path>> defsUses = new LinkedHashMap<>(); //to return contains all possible paths
	Map<Function, List<Path>> currentPaths = new LinkedHashMap<>(); // The paths seen during execution
	boolean inConditional;
 	
	public DataCoverage(Map<String, Function> functions) {
		for (Entry<String, Function> entry: functions.entrySet()) {
			defsUses.put(entry.getValue(), new ArrayList<>());
			List<Expression> tempExpr = new ArrayList<>();
			if(!entry.getValue().getParameters().isEmpty()) {
				for (UninitializedVariableDeclaration parameter: entry.getValue().getParameters()) {
					tempExpr.add(parameter);
				}
			}
			List<Path> tempPath = defsUses.get(entry.getValue());
			tempExpr.addAll(entry.getValue().getExpressions());
			Stack<Expression> loops = new Stack<>();
			Stack<Integer> back = new Stack<>();
			for(int i = 0; i< tempExpr.size(); i++) {
				Expression ex = tempExpr.get(i);
				if(ex.getExpressionType() == ExpressionType.Assignment 
						|| ex.getExpressionType() == ExpressionType.UninitializedVariableDeclaration 
						|| ex.getExpressionType() == ExpressionType.InitializedVariableDeclaration) {
					Path newPath = new Path (ex);
					if(entry.getValue().getParameters().contains(ex)) {
						newPath.isParameter = true;
					}
					tempPath.add(newPath);
					
					for(int j = i+1;j< tempExpr.size(); j++) {
						setExpression(tempExpr.get(j));
						getVar(currentExpression);
						// create a new path from the def we are looking at (ex) to this expression
						if (partVar.contains(newPath.defVar)) {
							if(tempPath.get(tempPath.size()-1).getUse() != null) {
								tempPath.add(new Path(tempPath.get(tempPath.size()-1).def));
							}
							tempPath.get(tempPath.size()-1).setUse(currentExpression);
						}
						
						
						
						// If we are looking at an uninitialized variable and we find a use for it put it
						// in the path and break
						// Otherwise if it isn't uninitialized just break
						if(currentExpression.getExpressionType() == ExpressionType.Assignment) {
							if(((AssignmentExpression) currentExpression).getAssignTo().equals(newPath.defVar) 
									&& newPath.def.getExpressionType() == ExpressionType.UninitializedVariableDeclaration
									&& !newPath.isParameter){
								tempPath.get(tempPath.size()-1).setUse(currentExpression);
								
								break;
							//Break when find a replacement definition 
							}else if(((AssignmentExpression) currentExpression).getAssignTo().equals(newPath.defVar)) {
								if (!loops.empty() && tempExpr.indexOf(loops.lastElement())
										+ loops.lastElement().getContainedExpressionCount()-1 < j) {
									setExpression(loops.lastElement());
									getVar(loops.lastElement());
									if(partVar.contains(newPath.defVar)) {
										if(tempPath.get(tempPath.size()-1).getUse() != null) {
											tempPath.add(new Path(tempPath.get(tempPath.size()-1).def));
										}
										tempPath.get(tempPath.size()-1).setUse(currentExpression);
									}
									j = tempExpr.indexOf(loops.lastElement());
									continue;
								}else {
									break;
								}
							}
						//break when arriving at a return expression
						}else if(currentExpression.getExpressionType() == ExpressionType.Return) {
							if (!loops.empty() && tempExpr.indexOf(loops.lastElement())
									+ loops.lastElement().getContainedExpressionCount()-1 < j) {
								setExpression(loops.lastElement());
								getVar(loops.lastElement());
								if(partVar.contains(newPath.defVar)) {
									if(tempPath.get(tempPath.size()-1).getUse() != null) {
										tempPath.add(new Path(newPath.def));
									}
									tempPath.get(tempPath.size()-1).setUse(currentExpression);
								}
								j = tempExpr.indexOf(loops.lastElement());
								continue;
							}else {
								break;
							}
						//special case if condition
						}else if(currentExpression.getExpressionType() == ExpressionType.IfThen
								|| currentExpression.getExpressionType() == ExpressionType.IfThenElse
								|| currentExpression.getExpressionType() == ExpressionType.WhileLoop) {
							ArrayList<Path> toAdd = new ArrayList<>();
							if(ex.getExpressionType() == ExpressionType.Assignment) {
								conditional((AssignmentExpression)ex, currentExpression, toAdd);
							}else if(ex.getExpressionType() == ExpressionType.InitializedVariableDeclaration) {
								conditional((InitializedVariableDeclaration<?>)ex, currentExpression, toAdd);
							}else {
								if (newPath.isParameter) {
									conditional((UninitializedVariableDeclaration)ex, currentExpression, toAdd);
								}else {
									Expression temp = conditional((UninitializedVariableDeclaration)ex, currentExpression);
									if(temp != null) {
										tempPath.get(tempPath.size()-1).setUse(temp);
										break;
									}
								}
							}
							if(!toAdd.isEmpty() && tempPath.get(tempPath.size()-1).use == null) {
								tempPath.remove(tempPath.get(tempPath.size()-1));
							}
							tempPath.addAll(toAdd);
							setExpression(tempExpr.get(j));
							j = j + currentExpression.getContainedExpressionCount() - 1;
						}
						
					}
					if(!back.empty() && back.lastElement() != loops.lastElement().getContainedExpressionCount()) {
							back.set(back.size()-1, back.lastElement()+1);
							if (back.lastElement() == loops.lastElement().getContainedExpressionCount()) {
								back.pop();
								loops.pop();
							}
					}
				}else if(ex.getExpressionType() == ExpressionType.Return) {
					break;
				}else if(ex.getExpressionType() == ExpressionType.WhileLoop) {
					loops.add(ex);
					back.add(1);
				}
			}
		}
		for(Entry<Function, List<Path>> f: defsUses.entrySet()) {
			ArrayList<Path> paramPaths = new ArrayList<Path>();
			for(Expression param: f.getKey().getParameters()) {
				Path paramPath = new Path(param);
				paramPath.isParameter = true;
				paramPaths.add(paramPath);
			}
			currentPaths.put(f.getKey(), paramPaths);
			
		}
	}
	
	public void expressionExecuted() {
		List<Path> paths = currentPaths.get(currentFunction);
		List<Path> toAdd = new ArrayList<>();
		getVar(currentExpression);
		for(int i =0; i<paths.size(); i++) {
			Path p = paths.get(i);
			if(partVar.contains(p.defVar) && p.use == null) {
				p.setUse(currentExpression);
				if(defsUses.get(currentFunction).indexOf(p) >= 0) {
					defsUses.get(currentFunction).get(defsUses.get(currentFunction).indexOf(p)).evaluated();
					toAdd.add(new Path(p.def));
					paths.remove(p);
					i--;
				}
			}
		}
		paths.addAll(toAdd);
		
		if (currentExpression.getExpressionType() == ExpressionType.Assignment 
				|| currentExpression.getExpressionType() == ExpressionType.UninitializedVariableDeclaration 
				|| currentExpression.getExpressionType() == ExpressionType.InitializedVariableDeclaration) {
			for(int i = 0; i<paths.size(); i++) {
				Path p = paths.get(i);
				if(currentExpression.getExpressionType() == ExpressionType.Assignment) {
					if(p.defVar.equals(((AssignmentExpression) currentExpression).getAssignTo())) {
						if (p.def.getExpressionType().equals(ExpressionType.UninitializedVariableDeclaration) && 
								!p.isParameter) {
							p.setUse(currentExpression);
						}
						if(defsUses.get(currentFunction).indexOf(p) >= 0) {
							defsUses.get(currentFunction).get(defsUses.get(currentFunction).indexOf(p)).evaluated();
						}
						paths.remove(p);
						i--;
					}
				}else if(currentExpression.getExpressionType() == ExpressionType.InitializedVariableDeclaration) {
					if(p.defVar.getId().equals(((InitializedVariableDeclaration<?>) currentExpression).getID())) {
						if(defsUses.get(currentFunction).indexOf(p) >= 0) {
							defsUses.get(currentFunction).get(defsUses.get(currentFunction).indexOf(p)).evaluated();
						}
						paths.remove(p);
						i--;
					}
				}
			}
			Path newPath = new Path(currentExpression);
			paths.add(newPath);
		}
	}
	
	public void setExpression(Expression e) {
		currentExpression = e;
		partVar.clear();
	}
	
	
	public Map<Function, List<Path>> getCoverage(){
		// In case some definitions have no use match them
		/*for(Entry<Function, List<Path>> f: currentPaths.entrySet()) {
			for (Path p: f.getValue()) {
				if(defsUses.get(f.getKey()).contains(p)) {
					defsUses.get(f.getKey()).get(defsUses.get(f.getKey()).indexOf(p)).evaluated();
				}
			}
		}*/
		return defsUses;
	}
	
	
	public void setFunction(Function f) {
		currentFunction = f;
	}
	
	public void print() {
		for(Entry<Function, List<Path>> e: defsUses.entrySet()) {
			System.out.println(e.getKey() + ":");
			for(Path p: e.getValue()) {
				System.out.println(p);
			}
		}
	}
	
	private void getVar(Expression e) {
		if(e instanceof AssignmentExpression) {
			getVar(((AssignmentExpression) e).getRightSide());
		}else if(e instanceof InitializedVariableDeclaration<?>) {
			getVar(((InitializedVariableDeclaration<?>) e).getInitialValue());
		}else if(e instanceof IfThen) {
			getVar(((IfThen) e).getCondition());
		}else if(e instanceof IfThenElse) {
			getVar(((IfThenElse) e).getCondition());
		}else if(e instanceof WhileLoop) {
			getVar(((WhileLoop) e).getCondition());
		}else if(e instanceof Return) {
			getVar(((Return) e).getValue());
		}else if(e instanceof FunctionCall) {
			for (Expression ex: ((FunctionCall)e).getParameters()) {
				getVar(ex);
			}
		}else if(e instanceof TwoElementExpression<?, ?>) {
			getVar(((TwoElementExpression<?, ?>) e).getLeft());
			getVar(((TwoElementExpression<?, ?>) e).getRight());
		}else if(e instanceof BaseVariable) {
			partVar.add(((BaseVariable) e));
		}
	}
	
	private void conditional(AssignmentExpression def, Expression conditional, List<Path> toReturn) {
		List<Expression> containedExpressions = new ArrayList<>();
		if(conditional.getExpressionType() == ExpressionType.IfThen) {
			IfThen ifConditional = (IfThen) conditional;
			containedExpressions.addAll(ifConditional.getContainedExpressions());
		}else if(conditional.getExpressionType() == ExpressionType.IfThenElse) {
			IfThenElse ifConditional = (IfThenElse) conditional;
			containedExpressions.addAll(ifConditional.getContainedExpressions());
		}else if(conditional.getExpressionType() == ExpressionType.WhileLoop) {
			WhileLoop whileConditional = (WhileLoop) conditional;
			containedExpressions.addAll(whileConditional.getContainedExpressions());
		}
		for(Expression e: containedExpressions) {
			setExpression(e);
			getVar(e);
			if(partVar.contains(def.getAssignTo())) {
				Path p = new Path(def);
				p.setUse(e);
				toReturn.add(p);
			}
			if(e.getExpressionType() == ExpressionType.IfThen || e.getExpressionType() == ExpressionType.IfThenElse) {
				conditional(def, e, toReturn);
			}else if(e.getExpressionType() == ExpressionType.Assignment
					&& def.getAssignTo().equals(((AssignmentExpression) e).getAssignTo())){
				return;
			}
		}
	}
	
	private void conditional(InitializedVariableDeclaration<?> def, Expression conditional, List<Path> toReturn) {
		List<Expression> containedExpressions = new ArrayList<>();
		if(conditional.getExpressionType() == ExpressionType.IfThen) {
			IfThen ifConditional = (IfThen) conditional;
			containedExpressions.addAll(ifConditional.getContainedExpressions());
		}else if(conditional.getExpressionType() == ExpressionType.IfThenElse) {
			IfThenElse ifConditional = (IfThenElse) conditional;
			containedExpressions.addAll(ifConditional.getContainedExpressions());
		}else if(conditional.getExpressionType() == ExpressionType.WhileLoop) {
			WhileLoop whileConditional = (WhileLoop) conditional;
			containedExpressions.addAll(whileConditional.getContainedExpressions());
		}
		BaseVariable defVar;
		if(def.getVariableType() == VariableType.Int32) {
				defVar = new Int32Expression(def.getID());
			}else if(def.getVariableType() == VariableType.Double) {
				defVar = new DoubleExpression(def.getID());
			}else {
				defVar = new BoolExpression(def.getID());
			}
		for(Expression e: containedExpressions) {
			setExpression(e);
			getVar(e);
			if(partVar.contains(defVar)) {
				Path p = new Path(def);
				p.setUse(e);
				toReturn.add(p);
			}
			if(e.getExpressionType() == ExpressionType.IfThen || e.getExpressionType() == ExpressionType.IfThenElse) {
				conditional(def, e, toReturn);
			}else if(e.getExpressionType() == ExpressionType.Assignment
					&& defVar.equals(((AssignmentExpression) e).getAssignTo())){
				return;
			}
		}
	}

	private void conditional(UninitializedVariableDeclaration def, Expression conditional, List<Path> toReturn) {
		List<Expression> containedExpressions = new ArrayList<>();
		if(conditional.getExpressionType() == ExpressionType.IfThen) {
			IfThen ifConditional = (IfThen) conditional;
			containedExpressions.addAll(ifConditional.getContainedExpressions());
		}else if(conditional.getExpressionType() == ExpressionType.IfThenElse) {
			IfThenElse ifConditional = (IfThenElse) conditional;
			containedExpressions.addAll(ifConditional.getContainedExpressions());
		}else if(conditional.getExpressionType() == ExpressionType.WhileLoop) {
			WhileLoop whileConditional = (WhileLoop) conditional;
			containedExpressions.addAll(whileConditional.getContainedExpressions());
		}
		BaseVariable defVar;
		if(def.getVariableType() == VariableType.Int32) {
				defVar = new Int32Expression(def.getID());
			}else if(def.getVariableType() == VariableType.Double) {
				defVar = new DoubleExpression(def.getID());
			}else {
				defVar = new BoolExpression(def.getID());
			}
		for(Expression e: containedExpressions) {
			setExpression(e);
			getVar(e);
			if(partVar.contains(defVar)) {
				Path p = new Path(def);
				p.setUse(e);
				toReturn.add(p);
			}
			if(e.getExpressionType() == ExpressionType.IfThen || e.getExpressionType() == ExpressionType.IfThenElse) {
				conditional(def, e, toReturn);
			}else if(e.getExpressionType() == ExpressionType.Assignment
					&& defVar.equals(((AssignmentExpression) e).getAssignTo())){
				return;
			}
		}
	}
	
	private Expression conditional(UninitializedVariableDeclaration def, Expression conditional) {
		List<Expression> containedExpressions = new ArrayList<>();
		if(conditional.getExpressionType() == ExpressionType.IfThen) {
			IfThen ifConditional = (IfThen) conditional;
			containedExpressions.addAll(ifConditional.getContainedExpressions());
		}else if(conditional.getExpressionType() == ExpressionType.IfThenElse) {
			IfThenElse ifConditional = (IfThenElse) conditional;
			containedExpressions.addAll(ifConditional.getContainedExpressions());
		}else if(conditional.getExpressionType() == ExpressionType.WhileLoop) {
			WhileLoop whileConditional = (WhileLoop) conditional;
			containedExpressions.addAll(whileConditional.getContainedExpressions());
		}
		BaseVariable defVar;
		if(def.getVariableType() == VariableType.Int32) {
				defVar = new Int32Expression(def.getID());
			}else if(def.getVariableType() == VariableType.Double) {
				defVar = new DoubleExpression(def.getID());
			}else {
				defVar = new BoolExpression(def.getID());
			}
		for(Expression e: containedExpressions) {
			setExpression(e);
			getVar(e);
			if(e.getExpressionType() == ExpressionType.IfThen || e.getExpressionType() == ExpressionType.IfThenElse) {
				Expression temp = conditional(def, e);
				if(temp != null) {
					return temp;
				}
			}else if(e.getExpressionType() == ExpressionType.Assignment
					&& defVar.equals(((AssignmentExpression) e).getAssignTo())){
				return e;
			}
		}
		return null;
	}
}
