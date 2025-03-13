// Exercise4_4.java: Create a method for
// converting Celsius to Fahrenheit
public class Exercise4_4 {
  public static void main(String[] args) {
    System.out.println("Cels. Temp.\t\tFahr. Temp.");
    System.out.println("-------------------------------");

    for (double celsius = 40; celsius >= 31; celsius--) {
      System.out.println(celsius + "\t\t\t" + celsToFahr(celsius));
    }
  }

  public static double celsToFahr(double cels) {
    return (9.0 / 5.0) * cels + 32;
  }
}