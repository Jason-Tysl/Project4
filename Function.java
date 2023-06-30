import java.util.*;

public class Function {
    // Id id;
    String functionName;
    Parameters params;
    StmtSeq stmtSeq;

    // declares function

    public void parse() {
        Parser.expectedToken(Core.PROCEDURE);
		Parser.scanner.nextToken();
		Parser.expectedToken(Core.ID);
		functionName = Parser.scanner.getId();
		Parser.scanner.nextToken();
        Parser.expectedToken(Core.LPAREN);
		Parser.scanner.nextToken();
        params = new Parameters();
        params.parse();
        // params gives next token, (should be RPAREN)
        Parser.expectedToken(Core.RPAREN);
		Parser.scanner.nextToken();
        Parser.expectedToken(Core.IS);
		Parser.scanner.nextToken();
        stmtSeq = new StmtSeq();
        stmtSeq.parse();
        // params gives next token, (should be END)
        Parser.expectedToken(Core.END);
		Parser.scanner.nextToken();

    }

    public void print(int indent) {
        for (int i=0; i<indent; i++) {
			System.out.print("\t");
		}
        System.out.print("procedure " + functionName + "( ");
        params.print();
        System.out.println(" ) is ");
        stmtSeq.print(indent + 1);
        for (int i=0; i<indent; i++) {
			System.out.print("\t");
		}
        System.out.println("end");
    }

    private void checkOverload() {
        if (Memory.functions.containsKey(functionName)) {
            System.out.println("ERROR: Overloaded function: " + functionName);
			System.exit(0);
        }
    }

    private void checkDistinctParams(List<String> paramList) {
        List<String> distinctList = new ArrayList<String>();
        for (String param : paramList) {
            if (!distinctList.contains(param)) {
                distinctList.add(param);
            }
        }

        if (distinctList.size() != paramList.size()) {
            System.out.println("ERROR: Declared function \"" + functionName + "\" has formal parameters with the same name. (Indistinct)");
			System.exit(0);
        }

    }

    public void execute() {
        checkOverload();
        List<String> formalParamList = this.params.getParameters();
        checkDistinctParams(formalParamList);
        Memory.functions.put(functionName, this);
    }
    
}
