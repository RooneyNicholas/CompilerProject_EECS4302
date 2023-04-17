

Usage:
java -jar BKMRCompiler.jar input-1.txt

This outputs:
Command Line: The results of any print() statements that were executed during the execution of the program
Files: A file called indexOUT.html is created or overwritten in the current directory. It contains the complete code coverage in a visually friendly form

Expression guide:

CALL:[function testFunction],[[declaration ID: param1, type: int32, value:[literal Integer: 7]], [declaration ID: param2, type: double, value:[literal Real: 5.0]]]
This means a function call is being made to the function "testFunction" with parameters "param1"=7 and "param2"=5.0

WRIT:[declaration ID: second, type: int32, value:[[var int32 id=first] + [literal Integer: 20]]]
This is an expression before it is evaluated. This statement declares a variable of type "int32" named "second" which is initialized to that value

EVAL:[declaration ID: second, type: int32, value:[literal Integer: 27]]
This is the same expression after it is evaluated, indicating that second was initialised to 27; the variable reference first had a value of 7, and 7+20=27