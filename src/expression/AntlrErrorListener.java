package expression;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

public class AntlrErrorListener extends BaseErrorListener {
	private static boolean error = false;
	
	public static boolean hasError() {
		return error;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		error = true;
		List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		System.err.println("Syntax error");
		System.err.println("Token " + "\"" + ((Token) offendingSymbol).getText() + "\"" + " (line " + line + ", column " + (charPositionInLine + 1) + ")" + ": " + msg);
		System.err.println("Rule Stack: " + stack);
	}
	
}
