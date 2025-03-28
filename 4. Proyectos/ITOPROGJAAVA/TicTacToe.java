// TicTacToe.java: Play the TicTacToe game
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicTacToe extends JApplet {
  // Indicate which player has a turn, initially it is the X player
  private char whoseTurn = 'X';

  // Create and initialize cells
  private Cell[][] cells =  new Cell[3][3];

  // Create and initialize a status label
  private JLabel jlblStatus = new JLabel("X's turn to play");

  /** Initialize UI */
  public void init() {
    // Panel p to hold cells
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(3, 3, 0, 0));
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        p.add(cells[i][j] = new Cell());

    // Set line borders on the cells panel and the status label
    p.setBorder(new LineBorder(Color.red, 1));
    jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

    // Place the panel and the label to the applet
    this.getContentPane().add(p, BorderLayout.CENTER);
    this.getContentPane().add(jlblStatus, BorderLayout.SOUTH);
  }

  /** This main method enables the applet to run as an application */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Tic Tac Toe");

    // Create an instance of the applet
    TicTacToe applet = new TicTacToe();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /** Determine if the cells are all occupied */
  public boolean isFull() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (cells[i][j].getToken() == ' ')
          return false;

    return true;
  }

  /** Determine if the player with the specified token wins */
  public boolean isWon(char token) {
    for (int i = 0; i < 3; i++)
      if ((cells[i][0].getToken() == token)
          && (cells[i][1].getToken() == token)
          && (cells[i][2].getToken() == token)) {
        return true;
      }

    for (int j = 0; j < 3; j++)
      if ((cells[0][j].getToken() ==  token)
          && (cells[1][j].getToken() == token)
          && (cells[2][j].getToken() == token)) {
        return true;
      }

    if ((cells[0][0].getToken() == token)
        && (cells[1][1].getToken() == token)
        && (cells[2][2].getToken() == token)) {
      return true;
    }

    if ((cells[0][2].getToken() == token)
        && (cells[1][1].getToken() == token)
        && (cells[2][0].getToken() == token)) {
      return true;
    }

    return false;
  }

  // An inner class for a cell
  public class Cell extends JPanel implements MouseListener {
    // Token used for this cell
    private char token = ' ';

    public Cell() {
      setBorder(new LineBorder(Color.black, 1)); // Set cell's border
      addMouseListener(this);  // Register listener
    }

    /** Return token */
    public char getToken() {
      return token;
    }

    /** Set a new token */
    public void setToken(char c) {
      token = c;
      repaint();
    }

    /** Paint the cell */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (token == 'X') {
        g.drawLine(10, 10, getSize().width-10, getSize().height-10);
        g.drawLine(getSize().width-10, 10, 10, getSize().height-10);
      }
      else if (token == 'O') {
        g.drawOval(10, 10, getSize().width-20, getSize().height-20);
      }
    }

    /** Handle mouse click on a cell */
    public void mouseClicked(MouseEvent e) {
      if (token == ' ') { // If cell is not occupied
        if (whoseTurn == 'X') { // If it is the X player's turn
          setToken('X');  // Set token in the cell
          whoseTurn = 'O';  // Change the turn
          jlblStatus.setText("O's turn");  // Display status
          if (isWon('X'))
            jlblStatus.setText("X won! The game is over");
          else if (isFull())
            jlblStatus.setText("Draw! The game is over");
        }
        else if (whoseTurn == 'O') { // If it is the O player's turn
          setToken('O'); // Set token in the cell
          whoseTurn = 'X';  // Change the turn
          jlblStatus.setText("X's turn"); // Display status
          if (isWon('O'))
            jlblStatus.setText("O won! The game is over");
          else if (isFull())
            jlblStatus.setText("Draw! The game is over");
        }
      }
    }

    public void mousePressed(MouseEvent e) {
      // TODO: implement this java.awt.event.MouseListener method;
    }

    public void mouseReleased(MouseEvent e) {
      // TODO: implement this java.awt.event.MouseListener method;
    }

    public void mouseEntered(MouseEvent e) {
      // TODO: implement this java.awt.event.MouseListener method;
    }

    public void mouseExited(MouseEvent e) {
      // TODO: implement this java.awt.event.MouseListener method;
    }
  }
}