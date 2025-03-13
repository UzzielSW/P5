// Exercise4_14.java: Create a method for summarizing digits in an int
public class Exercise4_14 {
  public static void main(String[] args) {
    System.out.println("The sum of digits for 234 is " + sumDigits(234));
  }

  public static int sumDigits(long n) {
    if (n == 0) 
      return 0;
    else 
      return (int)(n % 10 + sumDigits(n / 10));
  }
}