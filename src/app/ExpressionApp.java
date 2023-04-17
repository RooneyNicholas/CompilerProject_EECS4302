package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import antlr.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ExprLexer;
import codeCoverage.ControlCoverage;
import codeCoverage.DataCoverage;
import codeCoverage.EvaluationStatus;
import codeCoverage.Path;
import expression.AntlrToProgram;
import expression.Function;
import expression.Program;
import expression.AntlrErrorListener;



public class ExpressionApp {

	public static void main(String[] args) {
		if (args.length != 1 && args.length != 2) {
			System.err.println("Usage : file name");
		} else {

			// Not sure what's the purpose of this:
			/*
			if (args.length == 2) {
				fileName += " " + args[1];
			}
			*/
			String fileName = getFileName(args); // if more then 1 input file it will combine all files and create tmp file

			ExprParser parser = getParser(fileName);
			ParseTree antlrAST = parser.prog();
			
			/* These variables are for html generation*/
			List<String> evaluations = null;
			List<String> semErrors = null;
			LinkedHashMap<Function, List<EvaluationStatus>> controlCoverageReport = null;
			Map<Function, List<Path>> dataCoverageReport = null;

			ControlCoverage controlCoverage = null;
			DataCoverage dataCoverage = null;

			if (!AntlrErrorListener.hasError()) {
				AntlrToProgram progVisitor = new AntlrToProgram();
				Program prog = progVisitor.visit(antlrAST);

				
				if (progVisitor.getSemanticErrors().isEmpty()) {

					ExpressionProcessor ep = new ExpressionProcessor(prog.getFunctions());
					for (String evaluation : ep.getEvaluationResults()) {
						System.out.println(evaluation);
					}

					controlCoverage = ep.getControlCoverage();
					dataCoverage = ep.getDataCoverage();

					System.out.println("-------------------");
					System.out.println(controlCoverage.getControlCoverage());
					System.out.println("-------------------");
					dataCoverage.print();

					controlCoverageReport = controlCoverage.getControlCoverage(); //this will be sent to html generator
					dataCoverageReport = dataCoverage.getCoverage();
					evaluations = ep.getEvaluationResults();
				} else {
					for (String err : progVisitor.getSemanticErrors()) {
						System.err.println(err);
					}
				}
				semErrors = progVisitor.getSemanticErrors();  // for html generator
			}

			/** Generate output HTML file **/
			htmlGenerator generate;
//			boolean[] coverage = {true, true, false, false};  // HARDCODED FOR NOW***

			if (args.length <= 2) {
				generate = new htmlGenerator(args, controlCoverageReport, dataCoverageReport, evaluations, semErrors);
				generate.generateHTMLContent();
			}

		}
	}

	public static ExprParser getParser(String fileName) {
		ExprParser parser = null;
		try {
			CharStream input = CharStreams.fromFileName(fileName);
			ExprLexer lexer = new ExprLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new ExprParser(tokens);

			// syntax error handling
			parser.removeErrorListeners();
			parser.addErrorListener(new AntlrErrorListener());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parser;
	}

	/**
	 * if 1 arg it will return the given file name
	 * else if more than 1 input file then it creates a new temp file and merges the file contents into temp
	 * then temp file's name e.g temp_.tmp will be returned
	 * @param args
	 * @return
	 */
	public static String getFileName(String[] args) {
		String fileName = args[0];

		if(args.length > 1) { // multiple file input; need to combine all
			// PrintWriter object for file3.txt
	        try {
				PrintWriter pw = new PrintWriter("temp_.tmp");

				for (String currentFileName: args) {
					BufferedReader br = new BufferedReader(new FileReader(currentFileName));

			        String line = br.readLine();

			        // loop to copy each line of
			        // file1.txt to  file3.txt
			        while (line != null)
			        {
			            pw.println(line);
			            line = br.readLine();
			        }
			        br.close();
				}
				pw.close();

		        fileName = "temp_.tmp";
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return fileName;
	}
}
