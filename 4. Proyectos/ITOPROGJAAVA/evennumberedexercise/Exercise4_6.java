// Exercise4_6.java: Display sin and cos table
public class Exercise4_6 {
  public static void main(String[] args) {
    System.out.println("Degree\tSin\t\tCos");

    for (int degree = 0; degree <= 360; degree += 10) {
      System.out.println(degree + "\t" +
        format(Math.sin(degree * Math.PI / 180), 4)
        + "\t\t" + format(Math.cos(degree * Math.PI / 180), 4));
    }
  }

  public static double format(double d, int position) {
    return Math.round(d * Math.pow(10, position)) / Math.pow(10, position);
  }
}