// Exercise4_2.java: Create a method for summarizing digits in an int
public class Exercise4_2 {
  public static void main(String[] args) {
    System.out.println("The sum of digits for 234 is " + sumDigits(234));
  }

  public static int sumDigits(long n) {
    int temp = (int)Math.abs(n);
    int sum = 0;

    while (temp != 0) {
      int remainder = temp % 10;
      sum += remainder;
      temp = temp / 10;
    }

    return sum;
  }
}