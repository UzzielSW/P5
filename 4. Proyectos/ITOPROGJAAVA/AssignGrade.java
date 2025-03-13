// AssignGrade.java: Assign grade
import javax.swing.JOptionPane;

public class AssignGrade {
  /** Main method */
  public static void main(String[] args) {
    int numOfStudents = 0; // The number of students
    int[] scores; // Array scores
    int best = 0; // The best score
    char grade; // The grade

    // Get number of students
    String numOfStudentsString = JOptionPane.showInputDialog(null, 
      "Please enter number of students:",
      "Example 5.2 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into integer
    numOfStudents = Integer.parseInt(numOfStudentsString);

    // Create array scores
    scores = new int[numOfStudents];

    // Read scores and find the best score
    for (int i = 0; i < scores.length; i++) {
      String scoreString = JOptionPane.showInputDialog(null, 
      "Please enter a score:",
      "Example 5.2 Input", JOptionPane.QUESTION_MESSAGE);

      // Convert string into integer
      scores[i] = Integer.parseInt(scoreString);
      if (scores[i] > best)
        best = scores[i];
    }

    // Declare and initialize output string
    String output = ""; 
    
    // Assign and display grades
    for (int i = 0; i < scores.length; i++) {
      if (scores[i] >= best - 10)
        grade = 'A';
      else if (scores[i] >= best - 20)
        grade = 'B';
      else if (scores[i] >= best - 30)
        grade = 'C';
      else if (scores[i] >= best - 40)
        grade = 'D';
      else
        grade = 'F';

      output += "Student " + i + " score is " + 
        scores[i] + " and grade is " + grade + "\n";
    }
    
    // Display the result
    JOptionPane.showMessageDialog(null, output, 
      "Example 5.2 Output", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}