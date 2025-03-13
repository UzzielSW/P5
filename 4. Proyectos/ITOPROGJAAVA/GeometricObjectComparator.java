import java.util.Comparator;

public class GeometricObjectComparator implements Comparator {
  public int compare(Object o1, Object o2) {
    double area1 = ((GeometricObject)o1).findArea();
    double area2 = ((GeometricObject)o2).findArea();

    if (area1 < area2)
      return -1;
    else if (area1 == area2)
      return 0;
    else
      return 1;
  }
}