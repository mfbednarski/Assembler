/*Author: Garrett Lonier
 * Date: 11/6/2017
 * References: The Elements of Computing Systems Chapter 6 Pg 113 -114
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class parse {
	
	public String MyArray[];  
	public BufferedReader reader;
	public String InFile; 
	public static Type InstructionType;  
	public int AtLine;
	public static int symbol=16; 
	
	parse(String OurFile) throws IOException 
	//Main Parser class, reads the file and stores into the InFile string. also replaces unwanted comments or other symbols not needed
	//once done array is populated with commands from the file.
	{
	  int contins;
	  AtLine=0;
	  
	  FileInputStream stream = null; 
	  stream = new FileInputStream(OurFile);
	  while ((contins = stream.read()) != -1) 
	  {
	   InFile += (char) contins;
	  }
	
	  DataInputStream streamin = new DataInputStream(stream);
	  reader = new BufferedReader(new InputStreamReader(streamin));
	  String replacer =  InFile.replaceAll( "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/|(?m)^[\t]*\r?\n|null|\t","");
	  replacer = replacer.replaceAll("(?m)^[\t]*\r?\n","");
	  InFile = replacer;
      MyArray = InFile.split("\n"); //populate array with strings from file
      for(int j=0; j < MyArray.length; j++)
      {
	   MyArray[j] =  MyArray[j].trim();
      }
			  
	}
	
	public enum Type
	{
		C_COMMAND,A_COMMAND,L_COMMAND
	}
	
	public Type Type() //Find what type of command is being read
	{
	  if(MyArray[AtLine].startsWith("@"))
	  {
	   return InstructionType = Type.A_COMMAND; //A Instruction was found return type A
	  }
		
	  if(MyArray[AtLine].startsWith("("))
	  {
	   return InstructionType = Type.L_COMMAND; //Label was found return type L
	  }
		
	  else
		{
		  return Type.C_COMMAND; //Was not L or A so return as C instruction type
		}
		
	}
	
	public String symbol() //Only call if the command type is a A or L command not C
	{
	  String lable = "";
	  if(MyArray[AtLine].startsWith("("))
	  {
	    lable = MyArray[AtLine];
	    lable = lable.replaceAll("\\((.*?)\\)","re"); //replace the label symbols with re
	  }
	  
	  else {
	   if(MyArray[AtLine].startsWith("@"))
	   {
		lable = MyArray[AtLine];
		lable = lable.replaceAll("@",""); //replace the @ with nothing
		}
	  }
	  
	  return lable;
	 }
	
	public String Jump() 
	{
     if(MyArray[AtLine].contains(";"))
	 {
	   String jump= MyArray[AtLine]; 
	   int lastOf= jump.lastIndexOf(";");
	   return jump.substring(lastOf+1,jump.length());
	  }
	  return null; // return null if no jump is given in command
	}
	
	public String Destination() //Method for destination
	{
	  if(MyArray[AtLine].contains("="))
	  {
	   String destination = MyArray[AtLine];
	   int lastOf= destination.lastIndexOf("=");
	   destination= destination.substring(0,lastOf);
	   return destination;
	  }
		
	  return null; //return null in event no destination is given in command
	}
	
	public String Computation() 
	{
	  String computation = MyArray[AtLine]; 
	  if(MyArray[AtLine].contains(";"))
	  {
	   int lastOf= computation.lastIndexOf(";");
	   computation= computation.substring(0,lastOf);
	  }

	  else if(MyArray[AtLine].contains("="))
	  {
	   int lastOf= computation.lastIndexOf("=");
	   computation= computation.substring(lastOf+1,computation.length());
	  }
	  return computation;	
	 }
	
	public boolean Commands() {
		if(AtLine != MyArray.length) 
		{
		 return true; //Look at the Array and the current line if they are not equal there are more commands so return true else false.	
		}
		return false;
	}
	
	public  void Continue()
	{
		AtLine++; //Move to the next command only called if more commands are found.
	}
	
}