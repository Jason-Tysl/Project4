class DeclSeq {
	Decl decl;
	DeclSeq ds;
	Function function;

	void parse() {
		if (Parser.scanner.currentToken() == Core.PROCEDURE) {
			function = new Function();
			function.parse();
		} else {
			decl = new Decl();
			decl.parse();
		}

		if (Parser.scanner.currentToken() != Core.BEGIN) {
			ds = new DeclSeq();
			ds.parse();
		}
	}
	
	void print(int indent) {
		if (function != null) {
			function.print(indent);
		} else {
			decl.print(indent);
		}
		if (ds != null) {
			ds.print(indent);
		}
	}
	
	void execute() {
		if (function != null) {
			function.execute();
		} else {
			decl.execute();
		}
		if (ds != null) {
			ds.execute();
		}
	}
}