import java.util.*;

public class Parameters {

    Id id;
    // String paramName;
    Parameters parameters;

    public void parse() {
        id = new Id();
        id.parse();
        if (Parser.scanner.currentToken() == Core.COMMA) {
            Parser.scanner.nextToken();
            parameters = new Parameters();
            parameters.parse();
        }
    }

    public void print() {
        id.print();
        if (parameters != null) {
            System.out.print(", ");
            parameters.print();
        }
    }

    private void checkDistinctParams(List<String> existingParams, String paramToCheck) {
        if (existingParams.contains(paramToCheck)) {
            System.out.println("ERROR: Duplicate parameter: " + paramToCheck);
			System.exit(0);
        }
    }

    // returns ArrayList of parameters 
    public List<String> execute() {
        List<String> params;
        String functionName = id.getString();
        if (parameters != null) {
            params = parameters.execute();
        } else {
            params = new ArrayList<String>();
        }
        checkDistinctParams(params, functionName);
        params.add(functionName);
        return params;
    }

    
}
