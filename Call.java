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

    private void checkFunctionDeclared() {
        String functionName = id.getString();
        if (!Memory.functions.containsKey(functionName)) {
            System.out.println("ERROR: Function call \"" + functionName + "\" was never declared.");
			System.exit(0);
        }
    }

    private void checkDistinctParams() {
        
    }

    public void execute() {
        checkFunctionDeclared();        
        String functionName = id.getString();
        Function calledFunction = Memory.functions.get(functionName);
        List<String> listOfParameters = parameters.execute();
    }

    
}
