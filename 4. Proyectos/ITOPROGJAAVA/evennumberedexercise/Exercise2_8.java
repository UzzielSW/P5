import javax.swing.JOptionPane;

public class Exercise2_8 {
  public static void main(String[] args) {
    // Prompt the input
    String poundString = JOptionPane.showInputDialog(null, 
      "Enter a number in pound:",
      "Exercise2_8 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    double pound = Double.parseDouble(poundString);
    double kilogram = pound * 0.454;
    
    System.out.println("It is " + kilogram + " kilograms");

    System.exit(0);
  }
}