# EECS4302_Project
Team Credit:<br />
Brynn Perit<br />
Yuval Rif<br />
Krishaanth Manoharan<br />
Nicholas Rooney<br />

This is a compiler created in ANTLR4 as the final project in EECS4302.

To view what features are supported in this compiler, go to src/docs/Report.docx for a full report.<br />
# Data Types:
Integer: int32<br />
Double precision: double<br />
Boolean: bool<br />

To declare a variable, the syntax is the data type followed by variable name. Examples:<br />
`int32 myVariable`<br />
`double myDoubleVariable`<br />
`bool boolean1`<br />

Variable can be assigned when declared, or after declaration at a separate time. Examples:<br />
`int32 myVariable = 5` <br />
```
    double myDoubleVariable
    myDoubleVariable = 1.25
```
# Arrays
It is also possible to create an array of values. This is done by adding `[]` after the data type. It is important to note that an array size must be know at runtime. The size is denoted by a value (or an int32 variable holding a value) within the square brackets.<br />
Examples:<br />
`int32[5] myInt32Array`<br />
`int32[x] myInt32Array`<br />

An array can be declared without initialization, in which case it hold values of 0 (or false in the case of boolean).<br />
To initialize an array when declaring it, place the list of comma separated values between `{}`. Example:<br />
`int32[5] myInt32Array = {1, 2, 3, 4, 5}`<br />
Note that when declaring and initializing at once, the total number of values must equal the size of the array declared within the `[]`.<br />

To access a value within the array, the same `[]` notation is used, and the value within the square brackets is the index to access. Arrays are 0 indexed in this language.<br />
Example:<br />
```
    int32[5] myInt32Array = {1, 2, 3, 4, 5}
    int32 firstIndexValue = myInt32Array[0]
```
In this case `firstIndexValue` will hold the value of 1. Likewise, if we accessed `myInt32Array[4]` the value will be 5.<br />

# Comments
To add a comment, or comment out a line of code, use `--`.<br />
Example:<br />
```
    --This line of code declare a variable called isTrue
    bool isTrue
````
```

    int32[5] myInt32Array = {1, 2, 3, 4, 5}
    int32 firstIndexValue = myInt32Array[0]
    --int32 addVariable = firstIndexValue + 5 This line of code will not run as it is commented out
```
# Functions
Functions are declared with their data type, followed by the name of the function, followed by a list of comman separated parameters to give the function in parantheses. These parameters must have their data type declared within the parantheses. Following the parameters, is the function scope, which is denoted by `{}`. All statements within the function are required to be within these curly braces. This language also supports void functions, where the keyword `void` is used in place of the data type. Non-void functions are required to have a `return` statement.<br />
Examples:<br />
```
    int32 add2Numbers(int32 x, int32 y) {
      return x + y
    }
```
```
    void modifyArray(int32[] x, int32 newVal) {
      x[0] = newVAl
    }
```

The starting point of any program written in this language is denoted by `void main()`.<br />
There exists a built in print operation that called by using `print()` with the value wanted in the parantheses. It may be a variable, an expression, or a function call.<br />

# Operations
This language supports most arithmetic operations and boolean operations.<br />
**Arithmetic operations**<br />
Addition: `+`<br />
Multiplication: `*`<br />
Subtraction: `-`<br />
Division: `\`<br />
Bitwise And: `&`<br />
Bitwise Or: `|`<br />
Bitwise Xor: `^`<br />
**Logical operations**<br />
Logical And: `&&`<br />
Logical Or: `||`<br />
Greater than: `>`<br />
Greater than or equal: `>=`<br />
Less than: `<`<br />
Less than or equal: `<=`<br />
Equals: `==`<br />

Example:<br />
```
    int32 myVar = 5
    int32 newVar = 5 - 1 
    double divisionVar = myVar / newVar
    bool isEqual = myVar == divisionVar
    newVar = myVar && newVar
```
# Branching statements
This language supports if/else if/else branching statements. Do note, that like Java/C and others, the dangling else issue exists here too. To declare an if statement, write `if(some boolean statement)` where some boolean statements represents any logical operation . The same is done for else if statements, just becoming `else if(some boolean statement)`. Finally, else is just declared as its own keyword, with no parentheses. Each of these statements creates a new scope, as with functions, that scope is declared with `{}`, and all statements within each block are required to be within the curly braces.<br />
Examples:<br />
```
    if (x > 5) {
      x = x + 1
    } else if (x < 0) {
      x = x - 1
    } else {
      x = x * 2
    }
```
```
    if (x == y || x == z) {
      y = y + 1
      z = z - 1
    } else {
      y = y - 1
      z = z + 1
    }
```

# Loops
Currently, only a while loop is supported. It is similar to other C like languages to use. It is declared with the keyword `while` followed by some condition in parantheses, then its scope is declared with `{}`.<br />
Example:<br />
```
while (i > 0) {
  x[i] = i
  i--
}
```

# Example Program
With all this put together, here are some example programs written in this language. 
```
void main() {
    int32 a = 5
    int32 b
    int32 c = 7
    if (a < 5) {
        b = 1 --skip
    } else if (a < 6 && c == 7) {
        b = 10 --execute
    } else if (a < 3) {
        b = 5 --skip
    } else {
        b = 6 --skip
    }
    bool test = true

    if (a == 5 && test) {
        b = 7 --execute
    } else {
        b = 8 --skip
    }

    if (a < 1) {
        b = 9 --skip
    } else {
        b = 10 --execute
    }
    
    print(someFunction(5))
    someFunction(4)
}

bool someFunction(int32 sample){
	if (sample < 5){
		return false
	}else{
		return true
	}
}
```
```
--array assignment and access, from left and right side
void main() {
   int32 a = 4
   int32[5] b = {1, 2, 3, 4, 5}
   b[a] = 12345
   a = b[a]
}
```
