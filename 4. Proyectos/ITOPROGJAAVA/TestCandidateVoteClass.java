// TestCandidateVoteClass.java: Count votes
import javax.swing.JOptionPane;

public class TestCandidateVoteClass {
  /** Main method */
  public static void main(String[] args) {
    // Create two candidates 
    Candidate candidate1 = new Candidate("George King");
    Candidate candidate2 = new Candidate("Kim Jones");

    // Count votes
    while (true) {
      // Prompt the user to enter a vote for a candidate
      String voteString = JOptionPane.showInputDialog(null, 
        "Enter a vote:",
        "Example 6.9 Input", JOptionPane.QUESTION_MESSAGE);

      // Convert string into integer
      int vote = Integer.parseInt(voteString);
      if (vote == 0) break; // End of the votes
      else if (vote == 1) candidate1.getVote().increment();
      else if (vote == 2) candidate2.getVote().increment();
      else if (vote == -1) candidate1.getVote().decrement();
      else if (vote == -2) candidate2.getVote().decrement();
    }

    // Prepare the result
    String output = "The total number of candidates is " +
      Candidate.getNumOfCandidates();
    output += "\nThe votes for " + candidate1.getName() + " is " +
      candidate1.getVote().getCount();
    output += "\nThe votes for " + candidate2.getName() + " is " +
      candidate2.getVote().getCount();

    // Display the result
    JOptionPane.showMessageDialog(null, output, 
      "Example 6.9 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }
}

// Define the Vote class
class Vote {
  /** The count for a Vote object */
  private int count = 0;

  /** Return the count */
  public int getCount() {
    return count;
  }

  /** Set a new count */
  public void setCount(int count) {
    this.count = count;
  }

  /** Clear this count */
  public void clear() {
    count = 0;
  }

  /** Increment this count */
  public void increment() {
    count++;
  }

  /** Decrement this count */
  public void decrement() {
    count--;
  }
}

class Candidate {
  private String name;
  private Vote vote;
  private static int numOfCandidates = 0;
   
  public Candidate(String name) {
    this.name = name;
    vote = new Vote();
    numOfCandidates++;
  }
  
  /** Return the vote of the candidate */
  public Vote getVote() {
    return vote;
  }
  
  /** Return the name of the candidate */
  public String getName() {
    return name;
  }
  
  /** Return the number of candidates */
  public static int getNumOfCandidates() {
    return numOfCandidates;
  }
}