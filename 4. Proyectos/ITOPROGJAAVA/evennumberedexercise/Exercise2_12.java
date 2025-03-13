import javax.swing.JOptionPane;

public class Exercise2_12 {
  public static void main(String args[]) {
    // Read subtotal
    String subtotalString = JOptionPane.showInputDialog(null, 
      "Enter subtotal:",
      "Exercise2_12", JOptionPane.QUESTION_MESSAGE);

    double subtotal = Double.parseDouble(subtotalString);
     
    // Read subtotal
    String rateString = JOptionPane.showInputDialog(null, 
      "Enter gratuity rate:",
      "Exercise2_12", JOptionPane.QUESTION_MESSAGE);

    double rate = Double.parseDouble(rateString);
    
    double gratuity = subtotal * rate / 100;
    double total = subtotal + gratuity;   
    
    System.out.println("Gratuity is " + gratuity);
    System.out.println("Total is " + total);
    
    System.exit(0);
  }
}