import java.util.*;

public class TestList {
  public static void main(String[] args) {
    ArrayList arrayList = new ArrayList();
    arrayList.add(new Integer(1));
    arrayList.add(new Integer(2));
    arrayList.add(new Integer(3));
    arrayList.add(new Integer(1));
    arrayList.add(new Integer(4));
    arrayList.add(0, new Integer(10));
    arrayList.add(3, new Integer(30));

    System.out.println("A list of integers in the array list:");
    System.out.println(arrayList);

    LinkedList linkedList = new LinkedList(arrayList);
    linkedList.add(1, "red");
    linkedList.removeLast();
    linkedList.addFirst("green");

    System.out.println("Display the linked list forward:");
    ListIterator listIterator = linkedList.listIterator();
    while (listIterator.hasNext()) {
      System.out.print(listIterator.next() + " ");
    }
    System.out.println();

    System.out.println("Display the linked list backward:");
    listIterator = linkedList.listIterator(linkedList.size());
    while (listIterator.hasPrevious()) {
      System.out.print(listIterator.previous() + " ");
    }
  }
}