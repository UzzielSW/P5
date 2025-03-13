

/**
 * Title:        Exercise Solutions
 * Description:  Solutions to the exercises for Introduciton to Java Programming with JBuilder 4
 * Copyright:    Copyright (c) 2000
 * Company:      Armstrong Atlantic State University
 * @author Y. Daniel Liang
 * @version 1.0
 */

public class Exercise4_12 {
  public static void main(String[] args) {
    System.out.println(format(10.3422345, 2));
    System.out.println(format(-0.343434, 3));
  }

  public static double format(double number, int numOfDigits) {
    return (int)(number*Math.pow(10, numOfDigits))/
      Math.pow(10, numOfDigits);
  }
}