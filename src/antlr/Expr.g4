grammar Expr;
@header{
	package antlr;
}

prog: main_decl (test_decl | function_decl)* EOF #Program
    ;

main_decl: 'void main' '(' param_list ')' '{' expr_list* '}'     #MainDeclaration
		;

test_decl: '@Test' ID '(' param_list ')' '{' expr_list* '}'     #TestDeclaration
	;
		
function_decl: type ID '(' param_list ')' '{' expr_list* '}'     #FunctionDeclaration
		;											

param_list: (decl (',' decl)*)?   #FunctionParams
        ;

expr_list: decl
        | expr
        | conditional
	    | while
	    | print
        ;

print: 'print' '(' print_options ')'
     ;

print_options: function_call
             | array_access
             | operator
             ;

decl: type ID                                                           #UninitializedDeclaration
    | type ID '=' (operator | function_call | array_access)             #InitializedDeclaration
    | array_decl                                                        #ArrayDeclaration
    ;

array_decl: type '[' array_index ']' ID                       #UninitializedArray
          | type '[' array_index ']' ID '=' array_init        #InitializedArray
          ;

array_init: '{' (operator | function_call) (',' (operator | function_call))* '}' #InitialArrayValues
          ;

array_access: ID '[' array_index ']'
            ;

array_index: integer
           | function_call
           | arithmeticOp
           | ID
           ;
	
expr: ID '=' (operator | function_call | array_access)                  #Operation
    | array_access '=' (operator | function_call | array_access)        #ArrayOperation
    | function_call                                                     #NoReturnFunction
    | 'return' (expr | number | BOOL)									#ReturnExpression
    | array_access                                                      #ArrayAccessExpression
    | ID                                                                #Variable
    ;

while: 'while' '(' (logicalOp | relationalOp) ')' '{' expr_list* '}'   #WhileLoop
	;

conditional: 'if' '(' (logicalOp | relationalOp) ')' '{' expr_list* '}'    #IfThen
           | 'if' '(' (logicalOp | relationalOp) ')' '{' expr_list* '}' 'else' else_block #IfThenElse
           ;

else_block: conditional         #ElseIf
          | '{' expr_list* '}'  #ElseBody
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
            | ID                                #ArithmeticVariable
            ;

logicalOp: logicalOp '&&' logicalOp             #LogicalAnd
        | logicalOp '||' logicalOp              #LogicalOr
        | ID                                    #LogicalVariable
        | BOOL                                  #LogicalBool
        | relationalOp							#LogicalRelational
        ;

relationalOp: arithmeticOp '>' arithmeticOp     #GreaterThan
            | arithmeticOp '<' arithmeticOp     #LessThan
            | arithmeticOp '<=' arithmeticOp    #LessOrEqual
            | arithmeticOp '>=' arithmeticOp    #GreaterOrEqual
            | arithmeticOp '==' arithmeticOp    #Equals
            | ID                                #RelationalVariable
            ;

function_call: ID '(' (operator (',' operator)*)? ')' #FunctionCall  //TODO chained calls
            ;

type: INT32_TYPE    #INT32
    | DOUBLE_TYPE   #DOUBLE
    | BOOL_TYPE		#BOOL
    ;

number: integer
      | real_number
      ;

integer: INTEGER_NUMBER     #IntegerNumber
       ;

real_number: REAL_NUMBER    #RealNumber
           ;

BOOL: 'true' | 'false'; //Keep higher precedence as these strings are subsets of ID terminal
BOOL_TYPE : 'bool';
INT32_TYPE : 'int32';
DOUBLE_TYPE: 'double';

ID : [a-z][a-zA-Z0-9_]*;
INTEGER_NUMBER : '0' | '-'?[1-9][0-9]*;
REAL_NUMBER: (('+'|'-')?([0-9]+)('.'[0-9]+)?)|(('+'|'-')?'.'?[0-9]+);
COMMENT : '--' ~[\r?\n]* -> skip;
WS : [ \t\r\n]+ -> skip;
