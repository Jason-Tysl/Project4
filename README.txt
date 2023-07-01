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


Special Features: Nothing majorly special was done one way or another.

Overall Design: The design is largely taken from the PerfectProject3 from Carmen. New Function, Parameter, and Call
    classes were created to handle function calls. Each of these additionally came with various semantic checks.
    The Memory class was also changed quite a bit, with the local memory changing to be a Stack of Stack of Maps 
    rather than a single Stack of Maps. This caused some other issues when allocating local memory but were reasonably
    easy to fix. The call execute was the most troublesome as it required a large grasp on the concepts of memory.

Testing/Bugs: There was some pretty extensive testing done. Using the test files covered most cases, and at first
    there was a bug because I accidentally added two scopes for each function. After more testing I got most of the
    kinks out. There is a bug that causes a NullPointerException in some cases. I couldn't quite pinpoint the exact
    reason behind this bug, but I have hunch that it has something to do with getting confused between the local
    and global variables that are named the same thing. The Memory.java file has the function getLocalOrGlobal()
    which appears to check the local memory first, which the integer x (in Correct/9.code) should have been in, but
    I think there is some confusion there. It's not recursion or if or anything else like that, so I think there's 
    some scope confusion, but I didn't implement that, and the PerfectProject3 is slightly different from the way I 
    did it in Project 3 so I couldn't figure it out. If I were to go through and absolutely make sure that the scopes
    were separate I think that would fix it.

