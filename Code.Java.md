//Code.Java
/**
 * 
 * @author MikeBednarski
 * @purpose Translate Hack assembly language mnemonics into binary codes
 */
public class Code {

	//Returns the binary code of the dest mnemonic
	public static String dest(String mnemonic){
		String d1 = null;
		String d2 = null;
		String d3 = null;
		mnemonic = mnemonic.replace(" ", ""); //used in case there is any whitespace in the input
		if (mnemonic.equals("M")){
			d1 = "0";
			d2 = "0";
			d3 = "1";
		}
		else if (mnemonic.equals("D")){
			d1 = "0";
			d2 = "1";
			d3 = "0";
		}
		else if (mnemonic.equals("MD")){
			d1 = "0";
			d2 = "1";
			d3 = "1";
		}
		else if (mnemonic.equals("A")){
			d1 = "1";
			d2 = "0";
			d3 = "0";
		}
		else if (mnemonic.equals("AM")){
			d1 = "1";
			d2 = "0";
			d3 = "1";
		}
		else if (mnemonic.equals("AD")){
			d1 = "1";
			d2 = "1";
			d3 = "0";
		}
		else if (mnemonic.equals("AMD")){
			d1 = "1";
			d2 = "1";
			d3 = "1";
		}
		else{
			d1 = "0";
			d2 = "0";
			d3 = "0";
		}
		String destBits = d1 + d2 + d3;
		return destBits;
	}
	
	//Returns the binary code of the comp mnemonic
	public static String comp(String mnemonic){
		String a = null;
		String c1 = null;
		String c2 = null;
		String c3 = null;
		String c4 = null; 
		String c5 = null;
		String c6 = null;
		mnemonic = mnemonic.replace(" ", "");
		if (mnemonic.contains("M")){ 
			a = "1";
			mnemonic = mnemonic.replace("M", "A"); //Replace M with A just to save some code lines
		}
		else{
			a = "0";
		}
		if (mnemonic.equals("0")){
			c1 = "1";
			c2 = "0";
			c3 = "1";
			c4 = "0";
			c5 = "1";
			c6 = "0";
 		}
		else if (mnemonic.equals("1")){
			c1 = "1";
			c2 = "1";
			c3 = "1";
			c4 = "1";
			c5 = "1";
			c6 = "1";
		}
		else if (mnemonic.equals("-1")){
			c1 = "1";
			c2 = "1";
			c3 = "1";
			c4 = "0";
			c5 = "1";
			c6 = "0";
		}
		else if (mnemonic.equals("D")){
			c1 = "0";
			c2 = "0";
			c3 = "1";
			c4 = "1";
			c5 = "0";
			c6 = "0";
		}
		else if (mnemonic.equals("A")){
			c1 = "1";
			c2 = "1";
			c3 = "0";
			c4 = "0";
			c5 = "0";
			c6 = "0";
		}
		else if (mnemonic.equals("!D")){
			c1 = "0";
			c2 = "0";
			c3 = "1";
			c4 = "1";
			c5 = "0";
			c6 = "1";
		}
		else if (mnemonic.equals("!A")){
			c1 = "1";
			c2 = "1";
			c3 = "0";
			c4 = "0";
			c5 = "0";
			c6 = "1";
		}
		else if (mnemonic.equals("-D")){
			c1 = "0";
			c2 = "0";
			c3 = "1";
			c4 = "1";
			c5 = "1";
			c6 = "1";
		}
		else if (mnemonic.equals("-A")){
			c1 = "1";
			c2 = "1";
			c3 = "0";
			c4 = "0";
			c5 = "1";
			c6 = "1";
		}
		else if (mnemonic.equals("D+1")){
			c1 = "0";
			c2 = "1";
			c3 = "1";
			c4 = "1";
			c5 = "1";
			c6 = "1";
		}
		else if (mnemonic.equals("A+1")){
			c1 = "1";
			c2 = "1";
			c3 = "0";
			c4 = "1";
			c5 = "1";
			c6 = "1";
		}
		else if (mnemonic.equals("D-1")){
			c1 = "0";
			c2 = "0";
			c3 = "1";
			c4 = "1";
			c5 = "1";
			c6 = "0";
		}
		else if (mnemonic.equals("A-1")){
			c1 = "1";
			c2 = "1";
			c3 = "0";
			c4 = "0";
			c5 = "1";
			c6 = "0";
		}
		else if (mnemonic.equals("D+A")){
			c1 = "0";
			c2 = "0";
			c3 = "0";
			c4 = "0";
			c5 = "1";
			c6 = "0";
		}
		else if (mnemonic.equals("D-A")){
			c1 = "0";
			c2 = "1";
			c3 = "0";
			c4 = "0";
			c5 = "1";
			c6 = "1";
		}
		else if (mnemonic.equals("A-D")){
			c1 = "0";
			c2 = "0";
			c3 = "0";
			c4 = "1";
			c5 = "1";
			c6 = "1";
		}
		else if (mnemonic.equals("D&A")){
			c1 = "0";
			c2 = "0";
			c3 = "0";
			c4 = "0";
			c5 = "0";
			c6 = "0";
		}
		else if (mnemonic.equals("D|A")){
			c1 = "0";
			c2 = "1";
			c3 = "0";
			c4 = "1";
			c5 = "0";
			c6 = "1";
		}
		else{
			System.out.println("Error");
		}
		String compBits = a + c1 + c2 + c3 + c4 + c5 + c6;
		return compBits;
		}
		
	// Returns the binary code of the jump mnemonic
	public static String jump(String mnemonic){
		String j1 = null;
		String j2 = null;
		String j3 = null;
		mnemonic = mnemonic.replace(" ", "");
		if (mnemonic.equals("JGT")){
			j1 = "0";
			j2 = "0";
			j3 = "1";
		}
		else if (mnemonic.equals("JEQ")){
			j1 = "0";
			j2 = "1";
			j3 = "0";
		}
		else if (mnemonic.equals("JGE")){
			j1 = "0";
			j2 = "1";
			j3 = "1";
		}
		else if (mnemonic.equals("JLT")){
			j1 = "1";
			j2 = "0";
			j3 = "0";
		}
		else if (mnemonic.equals("JNE")){
			j1 = "1";
			j2 = "0";
			j3 = "1";
		}
		else if (mnemonic.equals("JLE")){
			j1 = "1";
			j2 = "1";
			j3 = "0";
		}
		else if (mnemonic.equals("JMP")){
			j1 = "1";
			j2 = "1";
			j3 = "1";
		}
		else{
			j1 = "0";
			j2 = "0";
			j3 = "0";
		}
		String jmpBits = j1 + j2 + j3;
		return jmpBits;
		
	}
}
