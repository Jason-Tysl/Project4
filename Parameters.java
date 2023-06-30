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
    
    public void execute() {
        
    }
}
