// Exercise4_10.java: Find the number of moves for the
// Towers of Hanoi problem
import javax.swing.JOptionPane;

public class Exercise4_10 {
  public static void main (String args[]) {
    //read number of disks, n
    System.out.println("Enter number of disks");

    // Read number of disks, n
    String intString = JOptionPane.showInputDialog(null, 
      "Enter number of disks:",
      "Exercise 4.10 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into integer
    int n = Integer.parseInt(intString);

    System.out.println("The moves are:");
    int numOfMoves = moveDisks(n, 'A', 'B', 'C');
    System.out.println("The nuber of moves is "+numOfMoves);
    
    System.exit(0);
  }

  public static int moveDisks(int n, char fromTower, char toTower, char auxTower) {
    if (n == 1) { //stopping condition 
      System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
      return 1;
    }
    else {
      int i1 = moveDisks(n - 1, fromTower, auxTower, toTower);
      System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
      i1++;
      return i1 + moveDisks(n - 1, auxTower, toTower, fromTower);
    }
  }

  /* what is wrong with this implementation?
     public static int moveDisks(int n, char fromTower, char toTower, char auxTower) {
    int numOfMoves = 0;

    if (n==1) //stopping condition {
      System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);
      numOfMoves++;
    }
    else {
      moveDisks(n-1, fromTower, auxTower, toTower);
      System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);
      numOfMoves++;
      moveDisks(n-1, auxTower, toTower, fromTower);
    }

    return numOfMoves;
  }*/
}