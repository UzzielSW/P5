import java.util.*;

public class CountOccurrenceOfWords {
  public static void main(String[] args) {
    // Text in a string
    String text = "Have a good day. Have a good class. " + 
      "Have a good visit. Have fun!";

    // Create a hash map to hold words and key and count as value
    HashMap hashMap = new HashMap();

    StringTokenizer st = new StringTokenizer(text, " .!?");
    while (st.hasMoreTokens()) {
      String key = st.nextToken();

      if (hashMap.get(key) != null) {
        int value = ((Integer)hashMap.get(key)).intValue();
        value++;
        hashMap.put(key, new Integer(value));
      }
      else {
        hashMap.put(key, new Integer(1));
      }
    }
    
    // Create a tree map from the hash map
    TreeMap treeMap = new TreeMap(hashMap);
    
    // Get an entry set for the tree map
    Set entrySet = treeMap.entrySet();

    // Get an iterator for the entry set
    Iterator iterator = entrySet.iterator();

    // Display mappings
    System.out.println("Display words and their count in " +
      "ascending order of the words");
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}