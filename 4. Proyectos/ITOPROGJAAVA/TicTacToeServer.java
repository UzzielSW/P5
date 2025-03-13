// TicTacToeServer.java: Server for the TicTacToe game
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TicTacToeServer extends JFrame
  implements TicTacToeConstants {
  // Main method
  public static void main(String[] args) {
    TicTacToeServer frame = new TicTacToeServer();
  }

  public TicTacToeServer() {
    JTextArea jtaLog;

    // Create a scroll pane to hold text area
    JScrollPane scrollPane = new JScrollPane(
      jtaLog = new JTextArea());

    // Add the scroll pane to the frame
    getContentPane().add(scrollPane, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setTitle("TicTacToeServer");
    setVisible(true);

    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(8000);
      jtaLog.append(new Date() +
        ": Server started at socket 8000\n");

      // Number a session
      int sessionNo = 1;

      // Ready to create a session for every two players
      while (true) {
        jtaLog.append(new Date() +
          ": Wait for players to join session " + sessionNo + '\n');

        // Connect to player 1
        Socket player1 = serverSocket.accept();

        jtaLog.append(new Date() + ": Player 1 joined session " +
          sessionNo + '\n');
        jtaLog.append("Player 1's IP address" +
          player1.getInetAddress().getHostAddress() + '\n');

        // Notify that the player is Player 1
        new DataOutputStream(
          player1.getOutputStream()).writeInt(PLAYER1);

        // Connect to player 2
        Socket player2 = serverSocket.accept();

        jtaLog.append(new Date() +
          ": Player 2 joined session " + sessionNo + '\n');
        jtaLog.append("Player 2's IP address" +
          player2.getInetAddress().getHostAddress() + '\n');

        // Notify that the player is Player 2
        new DataOutputStream(
          player2.getOutputStream()).writeInt(PLAYER2);

        // Display this session and increment session number
        jtaLog.append(new Date() + ": Start a thread for session " +
          sessionNo++ + '\n');

        // Create a new thread for this session of two players
        HandleASession thread = new HandleASession(player1, player2);

        // Start the new thread
        thread.start();
      }
    }
    catch(IOException ex) {
      System.err.println(ex);
    }
  }
}

// Define the thread class for handling a new session for two players
class HandleASession extends Thread implements TicTacToeConstants {
  private Socket player1;
  private Socket player2;

  // Create and initialize cells
  private char[][] cell =  new char[3][3];

  private DataInputStream isFromPlayer1;
  private DataOutputStream osToPlayer1;
  private DataInputStream isFromPlayer2;
  private DataOutputStream osToPlayer2;

  // Continue to play
  private boolean continueToPlay = true;

  /** Construct a thread */
  public HandleASession(Socket player1, Socket player2) {
    this.player1 = player1;
    this.player2 = player2;

    // Initialize cells
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        cell[i][j] = ' ';
  }

  /** Implement the run() method for the thread */
  public void run() {
    try {
      // Create data input and output streams
      DataInputStream isFromPlayer1 = new DataInputStream(
        player1.getInputStream());
      DataOutputStream osToPlayer1 = new DataOutputStream(
        player1.getOutputStream());
      DataInputStream isFromPlayer2 = new DataInputStream(
        player2.getInputStream());
      DataOutputStream osToPlayer2 = new DataOutputStream(
        player2.getOutputStream());

      // Write anything to notify player 1 to start
      // This is just to let player 1 know to start
      osToPlayer1.writeInt(1);

      // Continuously serve the players and determine and report
      // the game status to the players
      while (true) {
        // Receive a move from player 1
        int row = isFromPlayer1.readInt();
        int column = isFromPlayer1.readInt();
        cell[row][column] = 'X';

        // Check if Player 1 wins
        if (isWon('X')) {
          osToPlayer1.writeInt(PLAYER1_WON);
          osToPlayer2.writeInt(PLAYER1_WON);
          sendMove(osToPlayer2, row, column);
          break; // Break the loop
        }
        else if (isFull()) { // Check if all cells are filled
          osToPlayer1.writeInt(DRAW);
          osToPlayer2.writeInt(DRAW);
          sendMove(osToPlayer2, row, column);
          break;
        }
        else {
          // Notify player 2 to take the turn
          osToPlayer2.writeInt(CONTINUE);

          // Send player 1's selected row and column to player 2
          sendMove(osToPlayer2, row, column);
       }

        // Receive a move from Player 2
        row = isFromPlayer2.readInt();
        column = isFromPlayer2.readInt();
        cell[row][column] = 'O';

        // Check if Player 2 wins
        if (isWon('O')) {
          osToPlayer1.writeInt(PLAYER2_WON);
          osToPlayer2.writeInt(PLAYER2_WON);
          sendMove(osToPlayer1, row, column);
          break;
        }
        else {
          // Notify player 1 to take the turn
          osToPlayer1.writeInt(CONTINUE);

          // Send player 2's selected row and column to player 1
          sendMove(osToPlayer1, row, column);
        }
      }
    }
    catch(IOException ex) {
      System.err.println(ex);
    }
  }

  /** Send the move to other player */
  private void sendMove(DataOutputStream out, int row, int column)
    throws IOException {
    out.writeInt(row); // Send row index
    out.writeInt(column); // Send column index
  }

  /** Determine if the cells are all occupied */
  private boolean isFull() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (cell[i][j] == ' ')
          return false; // At least one cell is not filled
          
    // All cells are filled
    return true;
  }

  /** Determine if the player with the specified token wins */
  private boolean isWon(char token) {
    // Check all rows
    for (int i = 0; i < 3; i++)
      if ((cell[i][0] == token)
          && (cell[i][1] == token)
          && (cell[i][2] == token)) {
        return true;
      }

    /** Check all columns */
    for (int j = 0; j < 3; j++)
      if ((cell[0][j] == token)
          && (cell[1][j] == token)
          && (cell[2][j] == token)) {
        return true;
      }

    /** Check major diagonal */
    if ((cell[0][0] == token)
        && (cell[1][1] == token)
        && (cell[2][2] == token)) {
      return true;
    }

    /** Check subdiagonal */
    if ((cell[0][2] == token)
        && (cell[1][1] == token)
        && (cell[2][0] == token)) {
      return true;
    }

    /** All checked, but no winner */
    return false;
  }
}