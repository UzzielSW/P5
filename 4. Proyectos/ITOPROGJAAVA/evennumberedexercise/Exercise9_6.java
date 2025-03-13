

/**
 * Title:        Chapter 1, "Introduction to Java and JBuilder"
 * Description:  Examples for Chapter 1
 * Copyright:    Copyright (c) 2000
 * Company:      Armstrong Atlantic State University
 * @author Y. Daniel Liang
 * @version 1.0
 */

public class Exercise9_6 {
  static int i;

  public Exercise9_6() {

  }

  public static void main(String[] args) {
    String[] s = {"CS", "Math", "Biol", "Chem", "Phys", "Buss",
      "Law", "Educ", "Elec Engr", "Mech Engr"};

    Integer[] list = new Integer[10];

    for (int i=0; i<list.length; i++)
      list[i] = new Integer((int)(Math.random()*100));

    ComparableCircle[] circle = new ComparableCircle[10];
    for (int i=0; i<list.length; i++)
      circle[i] = new ComparableCircle((int)(Math.random()*100));

    System.out.println("Max string is " + max(s));
    System.out.println("Max integer is " + max(list));
    System.out.println("Max circle is " + max(circle));
  }

  public static Object max(Object[] a) {
    Comparable max = (Comparable)a[0];

    for (int i=1; i<a.length; i++)
      if (max.compareTo(a[i]) < 0)
        max = (Comparable)a[i];

    return max;
  }
}

class ComparableCircle extends Circle implements Comparable {
  /**Construct a CompareCircle with a specified radius*/
  public ComparableCircle(double r) {
    super(r);
  }

  /**Implement the compareTo method defined in Comparable*/
  public int compareTo(Object o) {
    if (getRadius() > ((Circle)o).getRadius())
      return 1;
    else if (getRadius() < ((Circle)o).getRadius())
      return -1;
    else
      return 0;
  }
}

// ComparableCylinder is a subclass of Cylinder, which implements the
// CompareObject interface
class ComparableCylinder extends Cylinder implements Comparable {
  /**Construct a CompareCylinder with radius and length*/
  ComparableCylinder(double r, double l) {
    super(r, l);
  }

  /**Implement the compareTo method defined in Comparable interface*/
  public int compareTo(Object o) {
    if (findVolume() > ((Cylinder)o).findVolume())
      return 1;
    else if (findVolume() < ((Cylinder)o).findVolume())
      return -1;
    else
      return 0;
  }
}