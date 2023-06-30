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

    // returns ArrayList of parameters 
    public List<String> getParameters() {
        List<String> params;
        String functionName = id.getString();
        if (parameters != null) {
            params = parameters.getParameters();
        } else {
            params = new ArrayList<String>();
        }
        params.add(functionName);
        return params;
    }

    
}
