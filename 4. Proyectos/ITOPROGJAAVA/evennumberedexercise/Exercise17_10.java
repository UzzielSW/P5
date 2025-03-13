// Exercise17_10: Use StreamTokenizer to get numbers in a text file
import java.io.*;

public class Exercise17_10 {
  public static void main(String args[]) {
    StreamTokenizer in = null;

    int sum = 0;

    try {
      //create file input stream
      in = new StreamTokenizer(new FileReader("Exercise15_10.dat"));

      in.nextToken();

      while (in.ttype != in.TT_EOF) {
        sum += in.nval;
        in.nextToken();
      }

      System.out.println("The sum is " + sum);
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}