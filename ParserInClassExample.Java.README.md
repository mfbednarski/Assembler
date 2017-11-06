public class Parser {
	public static String comp = "";
	public static String dest = "";
	public static String jump = "";
	public Parser(String inst){
		comp = inst;
		if (inst.indexOf('=') >= 0){
			//contains '='
			dest = inst.substring(0, inst.indexOf('='));
			comp = inst.substring(inst.indexOf('=') + 1);
		}
		if (comp.indexOf(';') >= 0){
			//contains ';'
			jump = inst.substring(inst.indexOf(';') + 1);
			comp = comp.substring(0,comp.indexOf(';'));
		}
	}
  }
  
  /*
  		String inst = "M=M+1;JMP";
		Parser parser = new Parser(inst);
		System.out.println(parser.comp);
		System.out.println(parser.dest);
		System.out.println(parser.jump);
    */ //Using the Parser outside the Parser class.
