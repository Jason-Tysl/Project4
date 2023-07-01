import java.util.*;

class Call implements Stmt {

    Id id;
    Parameters parameters;

    public void parse() {
        Parser.expectedToken(Core.BEGIN);
        Parser.scanner.nextToken();
        id = new Id();
        id.parse();
        Parser.expectedToken(Core.LPAREN);
        Parser.scanner.nextToken();
        parameters = new Parameters();
        parameters.parse();
        Parser.expectedToken(Core.RPAREN);
        Parser.scanner.nextToken();
        Parser.expectedToken(Core.SEMICOLON);
        Parser.scanner.nextToken();

    }

    public void print(int indent) {
        for (int i=0; i<indent; i++) {
			System.out.print("\t");
		}
		System.out.print("begin ");
        id.print();
        System.out.print("(");
        parameters.print();
        System.out.println(");");
    }

    // if the function was never declared you can't call it
    private void checkFunctionDeclared() {
        String functionName = id.getString();
        if (!Memory.functions.containsKey(functionName)) {
            System.out.println("ERROR: Function call \"" + functionName + "\" was never declared.");
			System.exit(0);
        }
    }

    // if the function call and declaration have a different number of params you can't call it
    private void checkSameNumOfParams(List<String> formalParamList, List<String> actualParamList) {
        if (formalParamList.size() > actualParamList.size()) {
            System.out.println("ERROR: Too few actual parameters in function call: " + id.getString());
			System.exit(0);
        } else if (formalParamList.size() < actualParamList.size()) {
            System.out.println("ERROR: Too many actual parameters in function call: " + id.getString());
			System.exit(0);
        }
    }

    public void execute() {
        checkFunctionDeclared(); // semantic check
        String functionName = id.getString();
        Function calledFunction = Memory.functions.get(functionName);
        Parameters calledParameters = calledFunction.params;
        StmtSeq calledStmtSeq = calledFunction.stmtSeq;
        List<String> listOfFormalParameters = calledParameters.getParameters();
        List<String> listOfActualParameters = parameters.getParameters(); //this.parameters.getParameters();
        checkSameNumOfParams(listOfFormalParameters, listOfActualParameters); // semantic check
        
        // allocate memory for call
        Memory.pushStackCall(listOfFormalParameters, listOfActualParameters);
        Memory.local.peek().push(new HashMap<String, Memory.Value>());

        calledStmtSeq.execute();
        Memory.local.pop();
    }

    
}
