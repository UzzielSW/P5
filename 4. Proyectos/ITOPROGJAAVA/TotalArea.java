// TotalArea.java: Test passing an array of objects to the method
public class TotalArea {
  /** Main method */
  public static void main(String[] args) {
    // Declare circleArray
    CircleWithAccessors[] circleArray;

    // Create circleArray
    circleArray = createCircleArray();

    // Print circleArray and total areas of the circles
    printCircleWithAccessorsArray(circleArray);
  }

  /** Create an array of CircleWithAccessors objects */
  public static CircleWithAccessors[] createCircleArray() {
    CircleWithAccessors[] circleArray = new CircleWithAccessors[10];

    for (int i = 0; i < circleArray.length; i++) {
      circleArray[i] = new CircleWithAccessors(Math.random() * 100);
    }

    // Return CircleWithAccessors array
    return circleArray;
  }

  /** Print an array of circles and their total area */
  public static void printCircleWithAccessorsArray
    (CircleWithAccessors[] circleArray) {
    System.out.println("The radii of the circles are");
    for (int i = 0; i < circleArray.length; i++) {
      System.out.print("\t\t\t\t" +
        circleArray[i].getRadius() + '\n');
    }

    System.out.println("\t\t\t\t-------------------");

    // Compute and display the result
    System.out.println("The total areas of circles is \t" +
      sum(circleArray));
  }

  /** Add circle areas */
  public static double sum(CircleWithAccessors[] circleArray) {
    // Initialize sum
    double sum = 0;

    // Add areas to sum
    for (int i = 0; i < circleArray.length; i++)
      sum += circleArray[i].findArea();

    return sum;
  }
}