// Exercise3_6.java: Find the smallest number such that n*n < 12000
public class Exercise3_6 {
  // Main method
  public static void main(String[] args) {
    int i = 1;

    while (i * i <= 12000 ) {
      i++;
    }

    System.out.println("This number is " + i);
  }
}