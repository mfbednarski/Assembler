//SymbolTable.java
/**
 * @author Mike Bednarski
 * @purpose A symbol table that keeps a correspondence between symbolic labels and numeric addresses.
 */
import java.util.Hashtable;

public class SymbolTable {

	Hashtable<String, Integer> symbolTable; //Textbook suggests using a HashTable
	
	//Create a new symbol table with pre-existing values
	public SymbolTable(){
		symbolTable = new Hashtable<String, Integer>();
		symbolTable.put("SP", 0);
		symbolTable.put("LCL", 1);
		symbolTable.put("ARG", 2);
		symbolTable.put("THIS", 3);
		symbolTable.put("THAT", 4);

		for (int i=0; i<16; i++){ //For loop to put in the R values (saves some code lines
			symbolTable.put("R" + i, i);
		}
		
		symbolTable.put("SCREEN", 16384);
		symbolTable.put("KBD", 24576);
	}
	
	//Adds the pair (symbol, address) to the table.
	public void addEntry(String symbol, int address){
		symbolTable.put(symbol, address);
	}
	
	//Returns if symbol table contains the given symbol
	public boolean contains(String symbol){
		return symbolTable.containsKey(symbol);
	}
	
	//Returns the address associated with the symbol
	public int getAddress(String symbol){
		return symbolTable.get(symbol);
	}
	
}
