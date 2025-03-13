// Exercise5_4.java: Write a method that returns a new array that
// is a reversal of the original array.
public class Exercise5_4 {
  // Main method
  public static void main(String[] args) {
    int[] list = {1, 2, 4, 5, 10, 100, 2, -22};

    reversal(list);

    System.out.println("The reversal is ");

    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }

  public static void reversal(int[] list) {
    int[] newList = new int[list.length];

    for (int i = 0; i < list.length; i++)
      newList[i] = list[list.length - 1 - i];

    list =  newList;
  }
}