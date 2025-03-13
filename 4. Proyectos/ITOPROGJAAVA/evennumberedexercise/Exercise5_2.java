// Exercise5_2.java: Write a method that finds the smallest element
// in an array of integers.
public class Exercise5_2 {
  // Main method
  public static void main(String[] args) {
    double[] list = {15, 20.3, 4.5, 5.5, 10.3, 450, 20.4, -22.3} ;

    System.out.println("The average is " + average(list));
  }

  public static double average(double[] list) {
    double total = 0;

    for (int i = 0; i < list.length; i++)
      total += list[i];

    return total / list.length;
  }
}