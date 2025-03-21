// Exercise14_8.java: Display two digits after the decimal point
import java.text.*;

public class Exercise14_8 {
  public static void main(String[] args) {
    System.out.println("Cels. Temp.\t\tFahr. Temp.");
    System.out.println("--------------------------");
    
    NumberFormat numberForm = NumberFormat.getNumberInstance();
    numberForm.setMaximumFractionDigits(2);
    numberForm.setMinimumFractionDigits(2);
    
    DecimalFormat df = (DecimalFormat)numberForm;
    df.applyPattern("00.00");
    
    NumberFormat currencyForm =
    NumberFormat.getCurrencyInstance();
    
    for (double celsius = 40; celsius >= 31; celsius--) {
      System.out.println(df.format(celsius) + "\t\t\t" +
      numberForm.format(celsToFahr(celsius)));
    }
  }
  
  public static double celsToFahr(double cels) {
    return (9.0/5.0)*cels + 32;
  }
}