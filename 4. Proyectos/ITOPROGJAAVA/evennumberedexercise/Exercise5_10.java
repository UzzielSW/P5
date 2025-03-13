public class Exercise5_10 {
  public static void main(String[] args) {
    // Initialize the list
    double[] myList = {5.0, 4.4, 1.9, 2.9, 3.4, 3.5};

    // Print the original list
    System.out.println("My list before sort is: ");
    printList(myList);

    // Sort the list
    selectionSort(myList);

    // Print the sorted list
    System.out.println();
    System.out.println("My list after sort is: ");
    printList(myList);
  }

  /** The method for printing numbers */
  static void printList(double[] list) {
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + "  ");
    System.out.println();
  }

  /** The method for sorting the numbers */
  static void selectionSort(double[] list) {
    double currentMin;
    int currentMinIndex;

    for (int i = 0; i < list.length; i++) {
      // Find the smallest in the list[i..list.length-1]
      currentMin = list[i];
      currentMinIndex = i;

      for (int j = i + 1; j < list.length; j++) {
        if (currentMin > list[j]) {
          currentMin = list[j];
          currentMinIndex = j;
        }
      }

      // Swap list[i] with list[currentMinIndex] if necessary;
      if (currentMinIndex != i) {
        list[currentMinIndex] = list[i];
        list[i] = currentMin;
      }
    }
  }
}
