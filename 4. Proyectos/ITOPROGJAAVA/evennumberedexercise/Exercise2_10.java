// Exercise2_10.java: Convert uppercase letters to lowercase
public class Exercise2_10 {
  public static void main(String[] args) {
    // Assign an uppercase letter
    char uppercase = 'F';

    int offset = (int)'a' - (int)'A';
    char lowercase = (char)((int)uppercase + offset);

    System.out.print("The lowercase letter is " + lowercase);
  }
}