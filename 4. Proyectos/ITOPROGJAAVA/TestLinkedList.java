public class TestLinkedList {
  public static void main(String[] args) {
    // Create a linked list
    GenericLinkedList list = new GenericLinkedList();

    // Add elements to the list
    list.addFirst("Tom");
    list.addFirst("John");
    list.addLast("George");
    list.addLast("Michael");
    list.add("Michelle", 2);
    list.add("Samantha", 5);
    list.add("Daniel", 0);

    // Print the list
    System.out.println("Strings are added to the list");
    list.printList();
    System.out.println();

    // Remove elements from the list
    list.remove("Daniel");
    list.remove(2);
    list.removeLast();

    // Print the list
    System.out.println("The contents of the list after deletions");
    list.printList();
  }
}