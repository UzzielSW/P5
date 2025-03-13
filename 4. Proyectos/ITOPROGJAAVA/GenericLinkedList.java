public class GenericLinkedList {
  private Node first, last;
  private int count = 0; // The number of elements in the list

  public GenericLinkedList() {
  }

  /** Return the first element in the list */
  public Object getFirst() {
    if (count == 0) return null;
    else return first.element;
  }

  /** Return the last element in the list */
  public Object getLast() {
    if (count == 0) return null;
    else return last.element;
  }

  /** Add an element to the beginning of the list */
  public void addFirst(Object element) {
    Node newNode = new Node(element);
    newNode.next = first;
    first = newNode;
    count++;

    if (last == null)
      last = first;
  }

  /** Add an element to the end of the list */
  public void addLast(Object element) {
    if (last == null) {
      first = last = new Node(element);
    }
    else {
      last.next = new Node(element);
      last = last.next;
    }

    count++;
  }

  /** Add an element to the location after index in the list
   * index for the first element in the list is 1.
    */
  public void add(Object element, int index) {
    if (index == 1) addFirst(element);
    else if (index >= count) addLast(element);
    else {
      Node current = first;
      for (int i = 1; i < index; i++)
        current = current.next;
      Node temp = current.next;
      current.next = new Node(element);
      (current.next).next = temp;
      count++;
    }
  }

  /** Remove the first node */
  public boolean removeFirst() {
    if (count == 0) return false;
    else {
      first = first.next;
      count--;
      return true;
    }
  }

  /** Remove the last node */
  public boolean removeLast() {
    if (count == 0) return false;
    else {
      Node current = first;

      for (int i = 1; i <= count - 1; i++) {
        current = current.next;
      }

      last = current;
      last.next = null;
      count--;
      return true;
    }
  }

  /** Remove the node at the specified index
   * Return true if the element is removed
   * Return false if no element is removed
    */
  public boolean remove(int index) {
    if (index == 1) return removeFirst();
    else if (index == count) return removeLast();
    else if ((index < 1) || (index > count)) return false;
    else {
      Node current = first;

      for (int i = 1; i < index - 1; i++) {
        current = current.next;
      }

      current.next = current.next.next;
      count--;
      return true;
    }
  }

  /** Remove the first node that contains the specified element
   * Return true if the element is removed
   * Return false if no element is removed
    */
  public boolean remove(Object element) {
    Node previous = first;
    Node current;

    if (first != null) {
      if (element.equals(first.element)) {
        first = first.next;
        count--;
        return true;
      }
      else {
        current = first.next;
      }
    }
    else
      return false;

    for (int i = 0; i < count - 1; i++) {
      if (element.equals(current.element)) {
        previous.next = current.next; // Remove the current element
        count--;
        return true;
      }
      else {
        previous = current;
        current = current.next;
      }
    }

    return false;
  }

  /** Print the list */
  public void printList() {
    Node current = first;

    for (int i = 0; i < count; i++) {
      System.out.print(current.element + " ");
      current = current.next;
    }

    System.out.println();
  }
}