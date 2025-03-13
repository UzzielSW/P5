// Exercise3_12.java: Approximate PI
public class Exercise3_12 {
  public static void main(String[] args) {
    double pi = 0;
    double term; 
    int sign = 1;
    int k=1;

    for (; true; k++)     {
      term = sign * 4.0 / (2 * k - 1);
      pi += term;
      sign = -1 * sign;

      if ((pi - 3.14159 < 0.00001) && (pi > 3.14159)) 
        break;
    }
		
    System.out.println("The PI is " + pi);
    System.out.println("The number of terms needed to first get this " 
      + k);	
  }
}