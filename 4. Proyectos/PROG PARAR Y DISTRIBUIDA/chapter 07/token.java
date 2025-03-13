import java.lang.System;
import java.io.StreamTokenizer;
import java.io.DataInputStream;
import java.io.IOException;

class StreamTokenApp {
	 public static void main(String args[]) throws IOException {
		 DataInputStream inData = new DataInputStream(System.in); 
		 StreamTokenizer inStream = new StreamTokenizer(inData);
		 inStream.commentChar('#');
		 inStream.eolIsSignificant(true);
		 inStream.whitespaceChars(0,32);
		 boolean eof = false;
		 do {
		 int token=inStream.nextToken();
		 switch(token){
		 	case StreamTokenizer.TT_EOF:
			    eof = true;
			    System.out.println("EOF encountered."); 
			    break;
		    case StreamTokenizer.TT_EOL:
			    System.out.println("EOL encountered."); 
			    break;
		    case StreamTokenizer.TT_WORD:
			    System.out.println("Word: "+ inStream.sval); 
			    break;
		    case StreamTokenizer.TT_NUMBER:
			    System.out.println("Number: " + inStream.nval); 
		    	break;
		    default:
		    	System.out.println((char) token+" encountered.");
		    	if(token=='!') eof=true;
		   	}
		  } while(!eof);
	 }
} 
