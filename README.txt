Name: Jason Tysl

Files:

The only new files are ______. The rest are taken from the "Perfect Project 3"
on Carmen. Some of the other files were slightly edited to account for the new function calls added in 
project 4. The main change is ___________.

Assign.java - this file contains the parsing and executing for the three different productions of <assign>. 
    It also contains two semantic error checks that check if the id has been declared and if it
    is a record id when needed.

Call.java - this file contains the specific function calls within the program. It allows access to the HashMap
    of function definitions from earlier in the <decl-seq>.

Cmpr.java - this file contains the parsing and executing for the three different productions of <cmpr>.

Cond.java - this file contains the parsing and executing for the three different productions of <cond>.

Core.java - this file contains the Core enum that is used to check if we're accessing the correct token.

CoreType.java - this file is a pseudo map that initiales integers to 0 and records to null.
    This space is also used to determine what types are stored where and gain access to them easier.

Decl.java - this file contains the parsing and executing for the two different productions of <decl>.

DeclInteger.java - this file contains the parsing and executing for the <decl-integer> production. It stores
    the id into the map to be checked later. It also checks for doubly declaring.

DeclRecord.java - this file contains the parsing and executing for the <decl-record> production. It stores
    the id into the map to be checked later. It also checks for doubly declaring.

DeclSeq.java - this file contains the parsing and executing for the four different productions of <decl-seq>.
    it could be just a declaration, multiple declarations, a function declaration, or a function declaration
    and one or more variable declarations.

Executor.java - this file contains the scanner that is used for input of data as well as the initialize function
    which initializes the memory spaces.

Expr.java - this file contains the parsing and executing for the three different productions of <expr>.

Factor.java - this file contains the parsing and executing for the five different productions of <factor>.
    It is the last production.

Function.java - this file handles the declarations of new functions. It adds the new function to a HashMap with
    the function name as the key and the function itself as the value.

If.java - this file contains the parsing and executing for the two different productions of <if>.

Id.java - this file contains the parsing and executing for the two different productions of <index>.

Loop.java - this file contains the parsing and executing for the <loop>.

Main.java - this file creates two scanners which get used by the parser which parses the input file.
    The second scanner is used by the executor to execute the parsed data.

Memory.java - this file contains the memory map, stack of maps, and function declarations that get used by the 
    executor functions.

Out.java - this file contains the parsing and executing for the <out>.

Parameters.java - this file contains the storage of formal parameters within a fuction definition as well as the
    function call parameters.

Parser.java - the parser of the input file.

Procedure.java - this file contains the parsing and executing for the two productions of <procedure>.

README.txt - this file contains the creator's name and information about how the entire parser program works.

Scanner.java - this file contains the scanner that was taken from the "PerfectProject1.zip" from carmen. It
    scans and tokenizes all of the words from an input file.

Stmt.java - this file contains the parsing and executing for the six different productions of <stmt>. With the
    PerfectProject3 implementation, this is slightly changed and handled in StmtSeq.java.

StmtSeq.java - this file contains the parsing and executing for the two different productions of <stmt-seq>.
 
Term.java - this file contains the parsing and executing for the three different productions of <term>.


Special Features:

Overall Design:

Testing/Bugs:

