// Exercise3_4.java: Find number of positive nad negative values
import javax.swing.JOptionPane;

public class Exercise3_4 {
  public static void main(String[] args) {
    int countPositive=0, countNegative = 0;
    int num;
    do {
      // Read the next data
      String dataString = JOptionPane.showInputDialog(null, 
        "Enter an int value, \nthe program exits if the input is 0",
        "Exercise3_4", JOptionPane.QUESTION_MESSAGE);

      num = Integer.parseInt(dataString);
       
      if (num > 0)
        countPositive++;
      else if (num < 0)
        countNegative++;
    } while (num != 0);

    System.out.println("the number of postives is "+countPositive);
    System.out.println("the number of negatives is "+countNegative);
    
    System.exit(0);
  }
}