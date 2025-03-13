import java.util.*;
import java.io.*;

public class Exercise19_4 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println(
        "Usage: java Exercise19_4 fullfilename");
      System.exit(0);
    }

    String filename = args[0];

    // Create a tree map to hold words and key and count as value
    TreeMap treeMap = new TreeMap();

    try {
      BufferedReader in = new BufferedReader(new FileReader
        (filename));

      String line;

      while ((line = in.readLine()) != null) {
        StringTokenizer st = new StringTokenizer(line,
          " \n\t\r.,)(-\"");

        while (st.hasMoreTokens()) {
          String key = st.nextToken();

          if (treeMap.get(key) != null) {
            int value = ((Integer)treeMap.get(key)).intValue();
            value++;
            treeMap.put(key, new Integer(value));
          }
          else {
            treeMap.put(key, new Integer(1));
          }
        }
      }
    }
    catch (Exception ex) {
      System.err.println(ex);
    }

    // Get an entry set for the tree map
    Set entrySet = treeMap.entrySet();

    // Get an iterator for the entry set
    Iterator iterator = entrySet.iterator();

    // Display mappings
    System.out.println("\nDisplay words and their count in " +
      " ascending order of the words");
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}