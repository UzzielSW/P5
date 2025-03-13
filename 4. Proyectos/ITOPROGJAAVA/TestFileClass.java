// TestFileClass.java: Demonstrate the File class
import java.io.*;
import java.util.*;

public class TestFileClass {
  public static void main(String[] args) {
    // Create a File object 
    File file = new File(".", "image" + File.separator + "us.gif");
    System.out.println("Does it exist? " + file.exists());
    System.out.println("Can it be read? " + file.canRead());
    System.out.println("Can it be written? " + file.canRead());
    System.out.println("Is it a directory? " + file.isDirectory());
    System.out.println("Is it a file? " + file.isFile());
    System.out.println("Is it absolute? " + file.isAbsolute());
    System.out.println("Is it hidden? " + file.isHidden());
    System.out.println("What is its absolute path? " + 
      file.getAbsolutePath());

    try {
      System.out.println("What is its canonical path? " + 
        file.getCanonicalPath());
    }
    catch (IOException ex) { }

    System.out.println("What is its name? " + file.getName());
    System.out.println("What is its path? " + file.getPath());
    System.out.println("When was it last modified? " + 
      new Date(file.lastModified()));

    System.out.println("What is the path separator? " + 
      File.pathSeparatorChar);
    System.out.println("What is the name separator? " + 
      File.separatorChar);
  }
}