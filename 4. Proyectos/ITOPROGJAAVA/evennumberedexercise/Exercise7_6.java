// Exercise7_6.java: 7.6: Write a program that passes an unspecified
// number of integers as command-line arguments and
// displays their total.
public class Exercise7_6 {
  public static void main(String[] args) {
    int sum = 0;

    for (int i=0; i<args.length; i++) {
      sum += Integer.parseInt(args[i]);
    }

    System.out.println("The total is " + sum);
  }
}