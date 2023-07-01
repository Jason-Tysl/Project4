import java.util.*;

class Memory {
	//scanner is stored here as a static field so it is avaiable to the execute method for factor
	public static Scanner data;
	
	// Class and data structures to represent variables
	static class Value {
		Core type;
		int integerVal;
		int[] recordVal;
		Value(Core t) {
			this.type = t;
		}
	}
	
	public static HashMap<String, Value> global;
	public static Stack<Stack<HashMap<String, Value>>> local;
	public static HashMap<String, Function> functions;
	
	// Helper methods to manage memory
	
	// This inializes the global memory structure
	// Called before executing the DeclSeq
	public static void initializeGlobal() {
		global = new HashMap<String, Value>();
	}
	
	// Initializes the local data structure
	// Called before executing the main StmtSeq
	public static void initializeLocal() {
		local = new Stack<Stack<HashMap<String, Value>>>();
		local.push(new Stack<HashMap<String, Value>>());
		local.peek().push(new HashMap<String, Value>());
	}

	public static void inializeFunctions() {
		functions = new HashMap<String, Function>();
	}
	
	// Pushes a "scope" for if/loop stmts
	public static void pushScope() {
		local.peek().push(new HashMap<String, Value>());
	}
	
	// Pops a "scope"
	public static void popScope() {
		local.pop();
	}

	public static void pushStackCall(List<String> formalParamList, List<String> actualParamList) {
		// create new stack of hashMaps for the function call
		Stack<HashMap<String, Value>> callStack = new Stack<HashMap<String, Value>>();
		callStack.push(new HashMap<String, Value>());

		for (int i = 0; i < formalParamList.size(); i++) {
			Value actualValue = new Value(Core.RECORD);
			actualValue = getLocalOrGlobal(actualParamList.get(i));
			callStack.peek().put(formalParamList.get(i), actualValue);
		}

		// add to local memory for function call
		local.push(callStack);
	}

	// Handles decl integer
	public static void declareInteger(String id) {
		Value v = new Value(Core.INTEGER);
		if (local != null) {
			local.peek().peek().put(id, v);
		} else {
			global.put(id, v);
		}
	}
	
	// Handles decl record
	public static void declareRecord(String id) {
		Value v = new Value(Core.RECORD);
		if (local != null) {
			local.peek().peek().put(id, v);
		} else {
			global.put(id, v);
		}
	}
	
	// Retrives a value from memory (integer or record at index 0
	public static int load(String id) {
		int value;
		Value v = getLocalOrGlobal(id);
		if (v.type == Core.INTEGER) {
			value = v.integerVal;
		} else {
			value = v.recordVal[0];
		}
		return value;
	}
	
	// Retrieves a record value from the index
	public static int load(String id, int index) {
		Value v = getLocalOrGlobal(id);
		return v.recordVal[index];
	}
	
	// Stores a value (integer or record at index 0
	public static void store(String id, int value) {
		Value v = getLocalOrGlobal(id);
		if (v.type == Core.INTEGER) {
			v.integerVal = value;
		} else {
			v.recordVal[0] = value;
		}
	}
	
	// Stores a value at record index
	public static void store(String id, int index, int value) {
		Value v = getLocalOrGlobal(id);
		v.recordVal[index] = value;
	}
	
	// Handles "new record" assignment
	public static void allocate(String id, int index) {
		Value v = getLocalOrGlobal(id);
		v.recordVal = new int[index];
	}
	
	// Handles "id := record id" assignment
	public static void alias(String lhs, String rhs) {
		Value v1 = getLocalOrGlobal(lhs);
		Value v2 = getLocalOrGlobal(rhs);
		v1.recordVal = v2.recordVal;
	}
	
	// Looks up value of the variables, searches local then global
	private static Value getLocalOrGlobal(String id) {
		Value result;
		if (local.size() > 0) {
			if (local.peek().peek().containsKey(id)) {
				result = local.peek().peek().get(id);
			} else {
				Stack<HashMap<String, Value>> temp = local.pop();
				result = getLocalOrGlobal(id);
				local.push(temp);
			}
		} else {
			result = global.get(id);
		}
		return result;
	}

}