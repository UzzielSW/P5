import java.util.*;

public class TestMap {
  public static void main(String[] args) {
    // Create a hash set
    HashMap hashMap = new HashMap();
    hashMap.put("John F Smith", new Mortgage(7, 15, 150000));
    hashMap.put("Greg Z Anderson", new Mortgage(7.5, 30, 150000));
    hashMap.put("Joyce M Jones", new Mortgage(7, 15, 250000));
    hashMap.put("Gerry K Lewis", new Mortgage(7.85, 30, 20000));
    hashMap.put("Mathew T Cook", new Mortgage(7, 15, 100000));

    // Display the loan amount for Gerry K Lewis
    System.out.println("The loan amount for " + "Gerry K Lewis is " +
      ((Mortgage)(hashMap.get("Gerry K Lewis"))).getLoanAmount());

    // Create a tree map from the previous hash map
    TreeMap treeMap = new TreeMap(hashMap);

    // Get an entry set for the tree map
    Set entrySet = treeMap.entrySet();

    // Get an iterator for the entry set
    Iterator iterator = entrySet.iterator();

    // Display mappings
    System.out.println("\nDisplay mapping in ascending order of key");
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}