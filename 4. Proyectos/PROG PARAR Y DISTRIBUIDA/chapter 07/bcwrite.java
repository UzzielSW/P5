import java.io.*;
class p9 {
  public static void main (String args[]) {
  	PrintStream out = new PrintStream(System.out);
    try {
    	out.println("Hello");      }
    catch (Exception e) {
    	System.out.println("Error: " + e.toString());
    }
  }
 }
