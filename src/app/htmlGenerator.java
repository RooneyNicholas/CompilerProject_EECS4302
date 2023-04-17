package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import codeCoverage.EvaluationStatus;
import codeCoverage.Path;
import codeCoverage.UseType;
//import expression.BaseExpression;
//import expression.BaseLiteral;
import expression.Function;



/*******
 * Notes on how to use this:
 * initialize this class in `ExpressionApp.java`
 * Pass both inputFile name and testFile name into constructor
 *
 * @author k
 *
 */

public class htmlGenerator {

	final static String HTML_TEMPLATE_PATHWAY = "src/webPage/index.html";
//	final static String OUTPUT_FILE_NAME_PATHWAY = "src/webPage/indexOUT.html"; // Depreciated; usage without resource folder
	final static String OUTPUT_FILE_NAME_PATHWAY = "indexOUT.html"; //use this if you're running from jar file

	private String inputFileName;
	private String testFileName;
	private List<String> evaluations;
	private List<String> semanticErrors;
	Map<Function, List<Path>> dataCoverage;

	private String inputFileNameContents;
	private String testFileNameContents;
	private String coveredContents;
	private String outputContents;

	private double coveragePercent;
	private int missedBranches;
	private double missedStatements;
	private double covDecisionPercent;
	private double totalDecisions;
	private double totalStatements;

	private Map<String, String> dataFlowContents;
	private int pCount;
	private int cCount;
	private int allPsomeCCount;
	private int allCsomePCount;
	private int allDefCount;
	private int allUseCount;
	
	private String alertTags = null;
	private String lineNumbers = "";
	private int currentLineNumber = 0;
	
	private String statementCoverageContent = "";
	private String decisionCoverageContent = "";

	//New construc
	public htmlGenerator(String[] fileNameArguments,
			LinkedHashMap<Function, List<EvaluationStatus>> controlCoverage,
			Map<Function, List<Path>> dataCoverage,
			List<String> evaluations,
			List<String> semErrors) {
		this.inputFileName = fileNameArguments[0];
		this.evaluations = evaluations;
		this.semanticErrors = semErrors;
		this.dataCoverage = dataCoverage;
		

		// Initialize Dataflow Contents
		this.dataFlowContents = new HashMap<>();
		dataFlowContents.put("pUses","");
		dataFlowContents.put("pUseVars","");
		dataFlowContents.put("cUses","");
		dataFlowContents.put("cUseVars","");

		dataFlowContents.put("allPSomeCUses","");
		dataFlowContents.put("allPSomeCVars","");
		dataFlowContents.put("allCSomePUses","");
		dataFlowContents.put("allCSomePVars","");

		dataFlowContents.put("allDefUses", "");
		dataFlowContents.put("allDefVars", "");

		dataFlowContents.put("allUses", "");
		dataFlowContents.put("allUseVars", "");
		//////


		this.inputFileNameContents = readContent(inputFileName);
		this.outputContents = getOutputContent();
		this.coveredContents = readContent(inputFileName, controlCoverage);


		this.testFileNameContents = "<p> No test file was given </p>"; //temp

		// set up testfile later for multiple files***
		if (fileNameArguments.length == 2) {
			this.testFileName = fileNameArguments[1];
			this.testFileNameContents = readContent(testFileName);
		}



//		//testing
//		for(Function func: dataCoverage.keySet()) {
//			List<Path> paths = dataCoverage.get(func);
//			for(Path p: paths) {
//				System.out.println("--------");
//
//				System.out.println(p.toString());
//				if(p.getDefinition().hasLineNumber()) {
//					System.out.println("WOOOOOOOOOOOO>>>>");
//					System.out.println(p.getDefinition().getLineString());
//					System.out.println(p.getDefinition().getLineNumber());
//				}
//				System.out.println(p.getDefType());
//				System.out.println(p.getDefinition());
//				System.out.println(p.getDefVar().getId());
//				System.out.println(p.getEvaluation());
//				System.out.println(p.getUse());
//				if(p.getUse() != null && p.getUse().hasLineNumber()) {
//					System.out.println("WZZZZZZZZZZZZZ>>>>");
//					System.out.println(p.getUse().getLineString());
//					System.out.println(p.getUse().getLineNumber());
//				}
//				System.out.println(p.getUseType());
//			}
//		}
	}

	private String getOutputContent() {
		StringBuilder htmlBuilder = new StringBuilder();
		if (this.evaluations != null) {
			for(String evals: this.evaluations) {
				htmlBuilder.append("<p class=\"noMargin\">" + evals + "</p>");

			}
		}

		if (this.semanticErrors != null) {
			for(String err: this.semanticErrors) {
				htmlBuilder.append("<p class=\"notCovered\">" + err + "</p>");
			}
		}


		String content = htmlBuilder.toString();

		return content;
	}

//	private String getErrorContent() {
//		StringBuilder htmlBuilder = new StringBuilder();
//		
//		if (this.semanticErrors != null) {
//			for(String err: this.semanticErrors) {
//				htmlBuilder.append("<p class=\"notCovered\">" + err + "</p>");
//			}
//		}
//		String content = htmlBuilder.toString();
//
//		return content;
//	}

	private String readContent(String inputFileName, LinkedHashMap<Function, List<EvaluationStatus>> controlCoverage) {
		StringBuilder htmlBuilder = new StringBuilder();
		StringBuilder statementBuilder = new StringBuilder();
		StringBuilder decisionBuilder = new StringBuilder();
		// Used for UI linenumber count
//		int currentLineNumber = 1;
		
		if (controlCoverage == null || controlCoverage.size() == 0) { // coverage error

			this.alertTags = "<div class=\"alert alert-danger alert-dismissible fade show\">" +
			    "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>" +
			    "<strong>ERROR Occured!</strong>  No coverage was able to run." +
			    "</div>";
//			htmlBuilder.append(alertErrorTags);

			if (this.semanticErrors != null) { //safety incase semantic errors wasn't given for coverage error
				for(String err: this.semanticErrors) {
					htmlBuilder.append("<p class=\"notCovered\">" + err + "</p>");
					statementBuilder.append("<p class=\"notCovered\">" + err + "</p>");
					decisionBuilder.append("<p class=\"notCovered\">" + err + "</p>");
					currentLineNumber++;
				}
			}

			String content = htmlBuilder.toString();
			this.statementCoverageContent += statementBuilder.toString();
			this.decisionCoverageContent += decisionBuilder.toString();

			return content;
		} else { // coverage success
			setDataFlowCoverage();
			this.alertTags = "<div class=\"alert alert-success alert-dismissible fade show\">" +
			    "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>" +
			    "<strong>Success!</strong> Coverage was able to run." +
			    "</div>";
//			htmlBuilder.append(alertSuccessTags);
		}

		// IF coverage wasn't null it would execute below:
		try {
			// grab index template
			BufferedReader in = new BufferedReader(new FileReader(inputFileName));
			String str = null;

			
			
			/* Coverage Stats variables */
			double counterTotalStatements = 0;
			double counterStatementCovered = 0;

			double counterTotalDecisions = 0;

			/* Temp */
			// Below var is needed so we can verify if the function was indeed called
			// if after the below iteration the counterStatementCovered > tempPrevious...
			// then that means the function was indeed called so we can add +1 to covered
			double tempPreviousStatementCovered = counterStatementCovered;
			//EvaluationStatus tempPreviousStatus = null;
			int funcCounter = 0; // used to verify if final function was read to output buffer 
			for(Function func: controlCoverage.keySet()) {
				List<EvaluationStatus> evalStatus = controlCoverage.get(func);

				tempPreviousStatementCovered = counterStatementCovered;

				// This will skip lines that have only tokens i.e } or empty string
				while(( str = in.readLine()) != null ) {
					currentLineNumber++;
					// This will be the method name of every new iteration
					if(checkIfStringIsComment(str)) { //check if string is comment
						str = str.replaceAll("\\s", "&nbsp;");; //dont put it before the if statements, will mess up
						htmlBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>")); // can ignore for now
						statementBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>"));
						decisionBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>"));
					} else if(checkIfStringIsToken(str)) { // string is a token
						str = str.replaceAll("\\s", "&nbsp;");
						htmlBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "&nbsp;" + "</p>")); // can ignore for now
						statementBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "&nbsp;" + "</p>")); 
						decisionBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "&nbsp;" + "</p>")); 
						
					} else {
						str = str.replaceAll("\\s", "&nbsp;");
						htmlBuilder.append(htmlTableFormatter("<p class=\"functionDecl\">" + str + "</p>")); //fix this
						statementBuilder.append(htmlTableFormatter("<p class=\"functionDecl\">" + str + "</p>")); 
						decisionBuilder.append(htmlTableFormatter("<p class=\"functionDecl\">" + str + "</p>")); 
						
						
						break; //function name was found
					}
					
				}
				for(int i = 0; i < evalStatus.size();) {
					currentLineNumber++;
					str = in.readLine();//grab next line
					if(str != null && !checkIfStringIsToken(str) ) { //str doesnt contain token
						
						str = str.replaceAll("\\s", "&nbsp;");
						
						switch(evalStatus.get(i)) {
						case None: // not evaluated
							htmlBuilder.append(htmlTableFormatter("<p class=\"notCovered\">" + str + "</p>"));
							statementBuilder.append(htmlTableFormatter("<p class=\"notCovered\">" + str + "</p>"));
							
							if(str.matches("\\s*if\\s*.*")) { //if its an ifstatement turn it red
								decisionBuilder.append(htmlTableFormatter("<p class=\"notCovered\">" + str + "</p>"));
								this.missedBranches += 2; //2 branches missed 
								counterTotalDecisions+= 2; //can be true or false
							} else {
								decisionBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>"));
							}
							break;
						case SomeTrue: //&#9432;
							htmlBuilder.append(htmlTableFormatter("<p class=\"someCovered\" data-bs-toggle=\"tooltip\" title=\"Branch True was covered, missed False\" >"  + str + "</p>", true)); //fix this add tooltip
							statementBuilder.append(htmlTableFormatter("<p class=\"covered\">" + str + "</p>"));
							decisionBuilder.append(htmlTableFormatter("<p class=\"someCovered\" data-bs-toggle=\"tooltip\" title=\"Branch True was covered, missed False\" >"  + str + "</p>", true)); //fix this add tooltip

							//counterCovered += 0.5; //half the weight since 1 branch i.e false is missing
							counterStatementCovered++;
							this.missedBranches++;
							counterTotalDecisions+= 2; //can be true or false
							break;
						case SomeFalse: //&#9432;
							htmlBuilder.append(htmlTableFormatter("<p class=\"someCovered\" data-bs-toggle=\"tooltip\" title=\"Branch False was covered, missed True\" >" + str + "</p>", false)); //fix this add tooltip
							statementBuilder.append(htmlTableFormatter("<p class=\"covered\">" + str + "</p>"));
							decisionBuilder.append(htmlTableFormatter("<p class=\"someCovered\" data-bs-toggle=\"tooltip\" title=\"Branch False was covered, missed True\" >" + str + "</p>", false)); //fix this add tooltip

							
							//counterCovered += 0.5; //half the weight since 1 branch i.e true is missing
							counterStatementCovered++;
							this.missedBranches++;
							counterTotalDecisions+= 2; //can be true or false
							break;
						case Complete:
							htmlBuilder.append(htmlTableFormatter("<p class=\"covered\">" + str + "</p>"));
							statementBuilder.append(htmlTableFormatter("<p class=\"covered\">" + str + "</p>"));

							if(str.matches("\\s*if\\s*.*")) {
								decisionBuilder.append(htmlTableFormatter("<p class=\"covered\">" + str + "</p>"));
							} else {
								decisionBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>"));
							}

//							counterCovered += 1;
							//Need to check if this is an if statement so we count it as decision
							if(str.matches("\\s*if\\s*.*")) {
								counterTotalDecisions +=2; //+=2 because covers both true and false
							}

							counterStatementCovered++;
							break;
						}
						//tempPreviousStatus = evalStatus.get(i);
//						counter += 1;
						counterTotalStatements++;
						i++;
					} else if (str == null) { //safety
						break;
					} else if (checkIfStringIsToken(str)) { //input line is just a token
						htmlBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "&nbsp;" + "</p>")); // can ignore for now
						statementBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "&nbsp;" + "</p>"));
						decisionBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "&nbsp;" + "</p>"));
					} else if(checkIfStringIsComment(str)) { //check if string is comment
						htmlBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>")); // can ignore for now
						statementBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>"));
						decisionBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>"));
					}
				}
				if(str == null) { //safety
					break;
				}
				
				// This will skip lines that have only tokens i.e } or empty string
				in.mark(10000); //need to go reset back to this mark if we see func
				while(( str = in.readLine()) != null) {
					
					// This will be the method name of every new iteration
					if(checkIfStringIsComment(str)) { //check if string is comment
						currentLineNumber++;
						str = str.replaceAll("\\s", "&nbsp;");; //dont put it before the if statements, will mess up
						htmlBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>")); // can ignore for now
						statementBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>"));
						decisionBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "</p>"));
					} else if(checkIfStringIsToken(str)) { // string is a token
						str = str.replaceAll("\\s", "&nbsp;");
						currentLineNumber++;
						htmlBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "&nbsp;" + "</p>")); // can ignore for now
						statementBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "&nbsp;" + "</p>")); 
						decisionBuilder.append(htmlTableFormatter("<p class=\"noMargin\">" + str + "&nbsp;" + "</p>")); 
						
					} else {
						// FUNCTION FOUND, reset back and leave this whileloop
						in.reset();
						break; //function name was found
					}
					in.mark(10000);
				}

				// The below is to include the function line
				if(tempPreviousStatementCovered < counterStatementCovered) {
					counterStatementCovered++;
				}
				counterTotalStatements++;
				funcCounter++;
			}

//			this.coveragePercent = Math.round( ((double)counterCovered/(double)counter)*10000)/100.0; //rounded to 2 decimal places
			this.coveragePercent = Math.round( ((double)counterStatementCovered/(double)counterTotalStatements)*10000)/100.0; //rounded to 2 decimal places
			this.missedStatements = counterTotalStatements - counterStatementCovered;
			this.covDecisionPercent = Math.round( ((double)(counterTotalDecisions - missedBranches)/(double)counterTotalDecisions)*10000)/100.0; //rounded to 2 decimal places

			this.totalStatements = counterTotalStatements;
			this.totalDecisions = counterTotalDecisions;
			// Output Coverage %
//			htmlBuilder.append("<p >" + "Coverage: " + coveragePercent  + "%" + "</p>");

			in.close();
		} catch (IOException e) {
			System.out.println("Error occured in io exception in htmlgenerator.java");
			System.out.println(e);
			htmlBuilder.append("<p>" + "Error: Could not find file location of the input file, maybe incorrect file name" + "</p>");
		}
		String content = htmlBuilder.toString();
		
		this.statementCoverageContent += statementBuilder.toString();
		this.decisionCoverageContent += decisionBuilder.toString();
		
		return content;
	}
	
	private String htmlTableFormatter(String content) {
		return "<tr>"
				+ "<td class=\"w-4 noPadding\"> <strong>" + this.currentLineNumber + "</strong> </td>"
				+ "<td class=\"w-100 vl noPadding\">" + content + "</td>"
				+ "</tr>";
	}
	
	// used for someTrue SomeFalse branches
	private String htmlTableFormatter(String content, boolean missedBranch) {
		if(missedBranch) {
			return "<tr>"
					+ "<td class=\"w-4 noPadding\" style=\"background-color: yellow; padding-right: 2px\" data-bs-toggle=\"tooltip\" title=\"Branch True was covered, missed False\"> <strong> " + this.currentLineNumber + "&#9432;</strong> </td>"
					+ "<td class=\"w-100 vl noPadding\">" + content + "</td>"
					+ "</tr>";
		} else {
			return "<tr>"
					+ "<td class=\"w-4 noPadding\" style=\"background-color: yellow; padding-right: 2px\" data-bs-toggle=\"tooltip\" title=\"Branch False was covered, missed True\"> <strong> " + this.currentLineNumber + "&#9432;</strong> </td>"
					+ "<td class=\"w-100 vl noPadding\">" + content + "</td>"
					+ "</tr>";
		}
		
	}

	private void setDataFlowCoverage() { //call this from readContent(...coverage), basically a helper method
		Map<String, String> dfc = this.dataFlowContents; //rename temp

		//Used for All to Some uses:
		Set<String> varsNotUsedByPUses = new HashSet<>();
		Set<String> varsNotUsedByCUses = new HashSet<>();
		Set<String> varsNotUsedYetAllDef = new HashSet<>();
		for(Function func: dataCoverage.keySet()) {
			List<Path> paths = dataCoverage.get(func);

			for(Path p: paths) {

				varsNotUsedByPUses.add(p.getDefinitionString());
				varsNotUsedByCUses.add(p.getDefinitionString());

				//This if statement will be used later to check for all-defs
				if(p.getDefType() == UseType.Definition) {
					varsNotUsedYetAllDef.add(p.getDefinitionString());
				}


				if(p.getUseType() == UseType.PUse) {
					//For p-use only
					this.pCount++;
					dfc.put("pUses",
						dfc.get("pUses") + p.getDefinitionString() + " &rarr; " + p.getUseString()  + "<br/>");
					dfc.put("pUseVars",
							dfc.get("pUseVars") + p.getDefVar().getId()  + "<br/>");

					//for all-use
					this.allUseCount++;
					dfc.put("allUses",
							dfc.get("allUses") + p.getDefinitionString() + " &rarr; " + p.getUseString()  + "<br/>");
					dfc.put("allUseVars",
								dfc.get("allUseVars") + p.getDefVar().getId()  + "<br/>");

				} else if(p.getUseType() == UseType.CUse) {
					//For c-use only
					this.cCount++;
					dfc.put("cUses",
						dfc.get("cUses") + p.getDefinitionString() + " &rarr; " + p.getUseString()  + "<br/>");
					dfc.put("cUseVars",
						dfc.get("cUseVars") + p.getDefVar().getId()  + "<br/>");

					//for all-use
					this.allUseCount++;
					dfc.put("allUses",
							dfc.get("allUses") + p.getDefinitionString() + " &rarr; " + p.getUseString()  + "<br/>");
					dfc.put("allUseVars",
								dfc.get("allUseVars") + p.getDefVar().getId()  + "<br/>");
				}
			}
		}

//		//Traverse through paths again and remove ones used by P and C respectively from the set
		for(Function func: dataCoverage.keySet()) {
			List<Path> paths = dataCoverage.get(func);

			for(Path p: paths) {
				if(p.getUseType() == UseType.PUse) {
					varsNotUsedByPUses.remove(p.getDefinitionString());
				} else if (p.getUseType() == UseType.CUse) {
					varsNotUsedByCUses.remove(p.getDefinitionString());
				}
			}
		}

		//append all C and P uses to AllPSomeC AllCsomeP respectivily
		dfc.put("allPSomeCUses", dfc.get("pUses"));
		dfc.put("allPSomeCVars", dfc.get("pUseVars"));
		this.allPsomeCCount += this.pCount;

		dfc.put("allCSomePUses", dfc.get("cUses"));
		dfc.put("allCSomePVars", dfc.get("cUseVars"));
		this.allCsomePCount += this.cCount;

		//Traverse paths again, add some uses
		for(Function func: dataCoverage.keySet()) {
			List<Path> paths = dataCoverage.get(func);

			//NOTE to myself; could be just mean 'some' in reference to first occurence, after that just remove from set EZ*** confirm w/ yuval
			for(Path p: paths) {
				if(p.getUseType() == UseType.CUse && varsNotUsedByPUses.contains(p.getDefinitionString())) {
					//add c use to allP-Uses/someC-uses
					this.allPsomeCCount++;
					dfc.put("allPSomeCUses", dfc.get("allPSomeCUses") + p.getDefinitionString() + " &rarr; " + p.getUseString()  + "<br/>");
					dfc.put("allPSomeCVars", dfc.get("allPSomeCVars") + p.getDefVar().getId()  + "<br/>");
					//can remove fromPuses here for 'some' via varsNotUsedByPUses.remove(p.getDefinitionString())
					varsNotUsedByPUses.remove(p.getDefinitionString());
				} else if (p.getUseType() == UseType.PUse && varsNotUsedByCUses.contains(p.getDefinitionString())) {
					//add p use to allC-Uses/someP-uses
					this.allCsomePCount++;
					dfc.put("allCSomePUses", dfc.get("allCSomePUses") + p.getDefinitionString() + " &rarr; " + p.getUseString()  + "<br/>");
					dfc.put("allCSomePVars", dfc.get("allCSomePVars") + p.getDefVar().getId()  + "<br/>");
					//can remove fromCuses here for 'some'
					varsNotUsedByCUses.remove(p.getDefinitionString());
				}
			}
		}

		/*All-Def Coverage*/
		//includes a definition clear path from every def to 'some' corresponding use (c-use or p-use)
		// do we have to show all uses?
		//Traverse paths again, add all def uses
		for(Function func: dataCoverage.keySet()) {
			List<Path> paths = dataCoverage.get(func);

			for(Path p: paths) {

				//if found then add this is 'some' path to all-def, then remove so others wont get appended
				if(varsNotUsedYetAllDef.contains(p.getDefinitionString()) && (p.getUseType() == UseType.PUse || p.getUseType() == UseType.CUse)) {
					this.allDefCount++;
					dfc.put("allDefUses", dfc.get("allDefUses") + p.getDefinitionString() + " &rarr; " + p.getUseString()  + "<br/>");
					dfc.put("allDefVars", dfc.get("allDefVars") + p.getDefVar().getId() + "<br />");
					varsNotUsedYetAllDef.remove(p.getDefinitionString());
				}
			}
		}


		this.dataFlowContents = dfc;
	}

	private Boolean checkIfStringIsToken(String line) {
		String[] tokens = {"{", "}", "(", ")", ""};
		line = line.trim();
		for(String token: tokens) {
			if(token.equals(line)) {
				return true;
			}
		}

		return false;
	}


	private Boolean checkIfStringIsComment(String line) {
		line = line.trim();

		if(line.startsWith("--")) { // it is a comment
			return true;
		}

		return false;
	}

	/**
	 * Used for regular files to read its content and to convert it to HTML tags (string format)
	 * @param fileName
	 * @return
	 */
	private String readContent(String fileName) {
		StringBuilder htmlBuilder = new StringBuilder();
		try {
			// grab index template
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			while ((str = in.readLine()) != null) {
				str = str.replaceAll("\\s", "&nbsp;"); //adds tabs to html if \t was found
//				str = str.replaceAll("^[\t ]+", "&emsp;&emsp;"); //adds tabs to html if \t was found

				htmlBuilder.append("<p class=\"noMargin\">" + str + "</p>");
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error occured in io exception in htmlgenerator.java");
			System.out.println(e);
			htmlBuilder.append("<p>" + "Error: Could not find file location, maybe incorrect file name" + "</p>");
		}
		String content = htmlBuilder.toString();
		//System.out.println(content);

		return content;
	}

	public void generateHTMLContent() {
		StringBuilder htmlBuilder = new StringBuilder();
		try {

			/*// Use this to verify for testing when file/folder paths are messedup
			 * //Usage of these 2 files was to debug where to locate the html file File
			 * myFile = new File("src/index.html");
			 *
			 * System.out.println("Attempting to read from file in: "+myFile.
			 * getCanonicalPath());
			 */

			/* Need to use getResourceasStream due to jar files not being able to read the correct path from the PATHWAY;
			 * due to it can be in a different folder */
			InputStream resTemplate = getClass().getClassLoader().getResourceAsStream("index.html");
			BufferedReader in = new BufferedReader(new InputStreamReader(resTemplate));
			String str;
			while ((str = in.readLine()) != null) {
				htmlBuilder.append(str);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error occured in io exception in htmlgenerator.java");
			System.out.println(e);
		}
		String content = htmlBuilder.toString();

		content = content.replace("$inputFile", this.inputFileNameContents);
		content = content.replace("$testFile", this.testFileNameContents);
		content = content.replace("$outputContent", this.outputContents);
		
		content = content.replace("$coverage", this.coveredContents);
		content = content.replace("$statementCovContent", this.statementCoverageContent);
		content = content.replace("$decisionCovContent", this.decisionCoverageContent);

		
		content = content.replace("$lineNumbers", this.lineNumbers);
		
		/*Below is for coverage Stats*/
		if (this.semanticErrors != null && this.semanticErrors.size() == 0) { //coverage should succeed
			content = content.replace("$alertTags", this.alertTags);
			content = content.replace("$covStatePercent", this.coveragePercent + "");
			content = content.replace("$covDecisionPercent", this.covDecisionPercent + "");

//			$totalStatements
			content = content.replace("$totalStatements", (int)this.totalStatements + "");
			content = content.replace("$totalBranches", (int)this.totalDecisions + "");

			content = content.replace("$missedStatements", (int)this.missedStatements + "");
			content = content.replace("$missedBranches", (int)this.missedBranches + "");

			//Progress bar:
			if (this.coveragePercent > 50) {
				content = content.replace("$covStateBGColor", "bg-success");
			} else {
				content = content.replace("$covStateBGColor", "bg-danger");
			}
			if (this.covDecisionPercent > 50) {
				content = content.replace("$covDecisionBGColor", "bg-success");
			} else {
				content = content.replace("$covDecisionBGColor", "bg-danger");
			}

			// DataFlow Contents
			content = content.replace("$pUseAssociations", this.dataFlowContents.get("pUses"));
			content = content.replace("$pUseVars", this.dataFlowContents.get("pUseVars"));
			content = content.replace("$cUseAssociations", this.dataFlowContents.get("cUses"));
			content = content.replace("$cUseVars", this.dataFlowContents.get("cUseVars"));

			// DataFlow Contents
			content = content.replace("$pUseAssociations", this.dataFlowContents.get("pUses"));
			content = content.replace("$pUseVars", this.dataFlowContents.get("pUseVars"));
			content = content.replace("$cUseAssociations", this.dataFlowContents.get("cUses"));
			content = content.replace("$cUseVars", this.dataFlowContents.get("cUseVars"));

			content = content.replace("$allPSomeCUses", this.dataFlowContents.get("allPSomeCUses"));
			content = content.replace("$allPSomeCVars", this.dataFlowContents.get("allPSomeCVars"));
			content = content.replace("$allCSomePUses", this.dataFlowContents.get("allCSomePUses"));
			content = content.replace("$allCSomePVars", this.dataFlowContents.get("allCSomePVars"));

			content = content.replace("$allDefUses", this.dataFlowContents.get("allDefUses"));
			content = content.replace("$allDefVars", this.dataFlowContents.get("allDefVars"));

			content = content.replace("$allUses", this.dataFlowContents.get("allUses"));
			content = content.replace("$allUseVars", this.dataFlowContents.get("allUseVars"));

			//Data-Flow Coverage Stats
			content = content.replace("$pCount", this.pCount +"");
			content = content.replace("$cCount", this.cCount +"");
			content = content.replace("$allPsomeCCount", this.allPsomeCCount +"");
			content = content.replace("$allCsomePCount", this.allCsomePCount +"");
			content = content.replace("$allDefCount", this.allDefCount +"");
			content = content.replace("$allUseCount", this.allUseCount +"");


		} else { //coverage error occured, hide stats
			content = content.replace("$alertTags", this.alertTags);
			content = content.replace("$statsVisibility", "visibleStatsFalse");
		}

		generateHTMLfromString(content);
	}

	private void generateHTMLfromString(String contentHTML) {
		/** WRITE TO FILE ***/

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME_PATHWAY));
			writer.write(contentHTML);

		} catch (IOException e) {
		}
		// for safety and close writer buffer
		finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
	}
}
