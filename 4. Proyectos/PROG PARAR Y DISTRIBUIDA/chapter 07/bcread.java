import java.io.*;
class p8 {
	public static void main (String args[]) {
	    DataInputStream in = new DataInputStream(System.in);
	    String s = new String();
	    try {
	      s = in.readLine();
	      System.out.println(s);}
	    catch (Exception e) {
	      System.out.println("Error: " + e.toString());
	    }
	}
}
