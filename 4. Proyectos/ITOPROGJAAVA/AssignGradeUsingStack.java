import java.util.*;

import javax.swing.JOptionPane;

public class AssignGradeUsingStack {
  // Main method
  public static void main(String[] args) {
    Stack scoreStack = new Stack(); // Stack to hold scores
    double best = 0; // The best score
    char grade; // The grade

    do {
      // Read scores and find the best score
      String scoreString = JOptionPane.showInputDialog(null,
        "Please enter a new score"  +
        "\nA negative score terminates input", "Example 19.5 Input",
        JOptionPane.QUESTION_MESSAGE);
      
      // Convert string into int
      double score = Integer.parseInt(scoreString);

      if (score < 0) break;

      // Add the score into the Stack
      scoreStack.push(new Double(score));

      // Find the best score
      if (score > best)
        best = score;
    } while (true);

    // Prepare the output string
    String output = "There are total " + scoreStack.size() +
    " students";

    int i = scoreStack.size();

    // Assign and display grades
    while (!scoreStack.isEmpty()) {
      // Retrieve an element from the Stack
      Double doubleObject = (Double)(scoreStack.pop());

      // Get the score
      double score = doubleObject.doubleValue();

      if (score >= best - 10)
        grade = 'A';
      else if (score >= best - 20)
        grade = 'B';
      else if (score >= best - 30)
        grade = 'C';
      else if (score >= best - 40)
        grade = 'D';
      else
        grade = 'F';

      output += "\nStudent " + i-- + " score is " + score +
        " and grade is " + grade;
    }
    
    JOptionPane.showMessageDialog(null, output,
      "Example 19.5 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }
}