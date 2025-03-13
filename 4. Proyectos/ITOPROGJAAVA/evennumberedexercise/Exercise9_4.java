public class Exercise9_4 {
  public static void main(String[] args) {
    GenericLinkedList list1 = new GenericLinkedList();
    list1.addLast("Happy Days!");
    list1.addLast("Grrr!");
    list1.addLast("Welcome to Java!");
    list1.addLast("Hello World!");

    // Prints list as is.
    list1.printList();

    // Adds a node after Grrr!
    list1.add("I'm sorry!!!",2);

    // Prints list.
    list1.printList();

    // Removes the added node.
    list1.remove(3);

    // Prints list.
    list1.printList();

    // Sorts list.
    list1 = list1.sort(list1);
    list1.printList();
  }
}

class GenericLinkedList {
  public Node first;
  public Node last;
  public int count = 0;

  public void addFirst(Object e) {
    if(first == null) {
      first = new Node(e);
      last = first;
    }
    else {
      Node temp = first;
      first = new Node(e);
      first.next = temp;
      temp.previous = first;
    }
    count++;
  }

  public void addLast(Object e) {
    if(last == null) {
      last = new Node(e);
      first = last;
    }
    else {
      Node temp = last;
      last = new Node(e);
      last.previous = temp;
      temp.next = last;
    }
    count++;
  }

  /**
   *  Adds new Node after specified index
   */
  public void add(Object e, int index) {
    if (index == 0) addFirst(e);
    else if (index == count) addLast(e);
    else {
      Node current = first;
      for(int i = 1; i <= index-1; i++)
        current = current.next;
      Node insert = new Node(e);
      insert.next = current.next;
      insert.previous = current;
      current.next.previous = insert;
      current.next = insert;
      count++;
    }
  }

  public void removeFirst() {
    if(first != null) {
      first = first.next;
      if(first != null)
        first.previous = null;
      count--;
    }
  }

  public void removeLast() {
    if(last != null) {
      last = last.previous;
      last.next = null;
      count--;
    }
  }

  /**
   *   Removes node at index
   */
  public void remove(int index) {
    if (index == 1) removeFirst();
    else if (index == count) removeLast();
    else {
        Node current = first;
        for(int i = 1; i <= index-1; i++)
          current = current.next;
        current.previous.next = current.next;
        current.next.previous = current.previous;
        count--;
    }
  }

  public GenericLinkedList sort(Object o) {
    GenericLinkedList toReturn = new GenericLinkedList();
    for(int k = 0; k <=((GenericLinkedList) o).count + 2; k++) {
       Node min =((GenericLinkedList) o).first;
       Node current = ((GenericLinkedList) o).first.next;
       if(current == null) {
         toReturn.addLast(min);
       }
       int minIndex = 1;
       for(int i = 1; i < ((GenericLinkedList) o).count;i++) {
         if(((Comparable)min.element).compareTo(current.element) >= 0) {
           min = current;
           minIndex = i + 1 ;
         }
         current = current.next;
       }

       if((min.element.equals(((GenericLinkedList)o).first.element)) &&
          (min.element.equals(((GenericLinkedList)o).last.element))) {
         min.previous = null;
         min.next = null;
       }

       if(minIndex == 1) {
         ((GenericLinkedList)o).removeFirst();
       }
       else if(minIndex == count) {
         ((GenericLinkedList)o).removeLast();
       }
       else {
         ((GenericLinkedList)o).remove(minIndex);
       }
       toReturn.addLast(min.element);
    }
    return toReturn;
  }

  public void printList() {
    Node temp = this.first;
    while(temp != null) {
      System.out.print(temp.element.toString() + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  private class Node {
    public Object element;
    public Node next;
    public Node previous;

    public Node(Object e) {
      element = e;
    }
  }
}