// Calculator.java: Pass parameters from the command line
public class Calculator {
  /** Main method */
  public static void main(String[] args) {
    // Check command-line arguments
    if (args.length != 3) {
      System.out.println(
        "Usage: java Calculator operator operand1 operand2");
      System.exit(0);
    }

    // The result of the operation
    int result = 0;

    // Determine the operator
    switch (args[0].charAt(0)) {
      case '+': result = Integer.parseInt(args[1]) +
                         Integer.parseInt(args[2]);
                break;
      case '-': result = Integer.parseInt(args[1]) -
                         Integer.parseInt(args[2]);
                break;
      case '*': result = Integer.parseInt(args[1]) *
                         Integer.parseInt(args[2]);
                break;
      case '/': result = Integer.parseInt(args[1]) /
                         Integer.parseInt(args[2]);
    }

    // Display result
    System.out.println(args[1] + ' ' + args[0] + ' ' + args[2]
      + " = " + result);
  }
}