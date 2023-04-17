grammar Test;
@header{
	package antlrTest;
}

testProg: (testDecl)+ EOF #TestProgram
    ;
	
testDecl: 'Test' ID ':' (varDecl | expr)* check   #TestDeclaration
		;
	
	
varDecl:  type ID                                                          #UninitializedDeclaration
    	| type ID '=' (operator | function_call)                           #InitializedDeclaration
    	;
    	
check: 'check' function_call  #CheckStatement
		;
	
expr: ID '=' (operator | function_call)                                 #Operation
    | 'if' '(' (logicalOp | relationalOp) ')' '{' (varDecl|expr)+ '}'   #IfConditional
    | function_call                                                     #NoReturnFunction
    ;

operator: arithmeticOp      #Arithmetic
        | logicalOp         #Logical
        | relationalOp      #Relational
        | number            #ExprNumber
        | ID                #ExprVariable
        | BOOL              #ExprBool
        ;

arithmeticOp: arithmeticOp '*' arithmeticOp     #Multiplication
            | arithmeticOp '+' arithmeticOp     #Addition
            | arithmeticOp '-' arithmeticOp     #Subtraction
            | arithmeticOp '/' arithmeticOp     #Division
            | arithmeticOp '&' arithmeticOp     #BitwiseAnd
            | arithmeticOp '|' arithmeticOp     #BitwiseOr
            | arithmeticOp '^' arithmeticOp     #BitwiseXor
            | number                            #ArithmeticNumber
            | ID                                #AritmeticVariable
            ;

logicalOp: logicalOp '&&' logicalOp             #LogicalAnd
        | logicalOp '||' logicalOp              #LogicalOr
        | ID                                    #LogicalVariable
        | BOOL                                  #LogicalBool
        ;

relationalOp: arithmeticOp '>' arithmeticOp     #GreaterThan
            | arithmeticOp '<' arithmeticOp     #LessThan
            | arithmeticOp '<=' arithmeticOp    #LessOrEqual
            | arithmeticOp '>=' arithmeticOp    #GreaterOrEqual
            | arithmeticOp '==' arithmeticOp    #Equals
            | ID                                #RelationalVariable
            ;

function_call: ID '(' (operator (',' operator)*)? ')' #FunctionCall 
            ;

type: INT32_TYPE    #INT32
    | DOUBLE_TYPE   #DOUBLE
    | BOOL_TYPE		#BOOL
    ;

number: INTEGER_NUMBER  #IntegerNumber
      | REAL_NUMBER     #RealNumber
      ;

BOOL: 'true' | 'false'; //Keep higher precedence as ID these strings are subsets of ID terminal
BOOL_TYPE : 'bool';
INT32_TYPE : 'int32';
DOUBLE_TYPE: 'double';

ID : [a-z][a-zA-Z0-9_]*;
INTEGER_NUMBER : '0' | '-'?[1-9][0-9]*;
REAL_NUMBER: (('+'|'-')?([0-9]+)('.'[0-9]+)?)|(('+'|'-')?'.'?[0-9]+);
COMMENT : '--' ~[\r?\n]* -> skip;
WS : [ \t\r\n]+ -> skip;