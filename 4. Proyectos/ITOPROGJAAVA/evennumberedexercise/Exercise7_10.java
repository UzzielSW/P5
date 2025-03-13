public class Exercise7_10 {
  public static void main(String[] args) {
    System.out.println(countLowerCaseLetters("abBD"));
  }
  
  public static int countLowerCaseLetters(String s) {
    int count = 1;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i))) count++;
     }
    
    return count;
 }
}