import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.applet.*;
import javax.swing.*;

public class Exercise12_18 extends JApplet implements ActionListener {
  public JLabel jlblStatus = new JLabel("X's turn");
  public char turn = 'X';
  public Cell[][] c = new Cell[3][3];
  public char com = ' ';
  public char hum = ' ';

  /**Initialize the applet*/
  public void init() {
    JPanel p = new JPanel(new GridLayout(3,3));
    p.setBorder(new LineBorder(Color.red));
    for(int row = 0; row < 3; row++) {
      for(int col = 0; col < 3; col++) {
        p.add(c[row][col] = new Cell());
      }
    }

    JMenuBar mb = new JMenuBar();
    this.setJMenuBar(mb);

    JMenu file = new JMenu("File");
    file.setMnemonic('f');
    mb.add(file);

    JMenuItem newM = new JMenuItem("New Game");
    newM.setMnemonic('n');
    newM.addActionListener(this);
    file.add(newM);

    JMenuItem exit = new JMenuItem("Exit");
    exit.setMnemonic('x');
    exit.addActionListener(this);
    file.add(exit);

    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(jlblStatus, BorderLayout.SOUTH);

    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        c[i][j].token = ' ';
        c[i][j].repaint();
        c[i][j].removeMouseListener(c[i][j]);
        c[i][j].addMouseListener(c[i][j]);
      }
    }
    jlblStatus.setText("X's turn");
    turn = 'X';
    com = 'O';
    hum = 'X';
  }

  public static void main(String[] args) {
    Exercise12_18 applet = new Exercise12_18();
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setDefaultCloseOperation(3);
    frame.setTitle("Exercise 12.18: Play again the computer");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2,
                      (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() instanceof JMenuItem) {
      if(e.getActionCommand() == "New Game") {
        JOptionPane pane = new JOptionPane("Do you wish to go first?",
                                         JOptionPane.QUESTION_MESSAGE,
                                         JOptionPane.YES_NO_OPTION);
        JDialog dialog = pane.createDialog(this,"1P");
        dialog.show();
        Object selectedValue = pane.getValue();
        if(selectedValue.equals(new Integer(JOptionPane.YES_OPTION))) {
          for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
              c[i][j].token = ' ';
              c[i][j].repaint();
              c[i][j].removeMouseListener(c[i][j]);
              c[i][j].addMouseListener(c[i][j]);
            }
          }
          jlblStatus.setText("X's turn");
          turn = 'X';
          com = 'O';
          hum = 'X';
        }
        else {
          for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
              c[i][j].token = ' ';
              c[i][j].repaint();
              c[i][j].addMouseListener(c[i][j]);
            }
          }
          jlblStatus.setText("X's turn");
          turn = 'X';
          com = 'X';
          hum = 'O';
          int r = (int)(3*Math.random());
          int col = (int)(3*Math.random());
          c[r][col].token = com;
          c[r][col].repaint();
          turn = hum;
          jlblStatus.setText(turn + "'s turn");
        }
      }
      else if (e.getActionCommand() == "Exit") {
        System.exit(1);
      }
    }
  }

  public void comTurn() {
    boolean found = false;

    if(!found) {
      for(int row=0;row<3;row++) {
        if(found)
          break;
        if((c[row][0].token == com) &&
           (c[row][1].token == com)) {
          if(c[row][2].token == ' ') {
            c[row][2].token = com;
            c[row][2].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int row=0;row<3;row++) {
        if(found)
          break;
        if((c[row][1].token == com) &&
           (c[row][2].token == com)) {
          if(c[row][0].token == ' ') {
            c[row][0].token = com;
            c[row][0].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int row=0;row<3;row++) {
        if(found)
          break;
        if((c[row][0].token == com) &&
           (c[row][2].token == com)) {
          if(c[row][1].token == ' ') {
            c[row][1].token = com;
            c[row][1].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int col=0;col<3;col++) {
        if(found)
          break;
        if((c[0][col].token == turn) &&
           (c[1][col].token == turn)) {
          if(c[2][col].token == ' ') {
            c[2][col].token = com;
            c[2][col].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int col=0;col<3;col++) {
        if(found)
          break;
        if((c[1][col].token == turn) &&
           (c[2][col].token == turn)) {
          if(c[0][col].token == ' ') {
            c[0][col].token = com;
            c[0][col].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int col=0;col<3;col++) {
        if(found)
          break;
        if((c[0][col].token == turn) &&
           (c[2][col].token == turn)) {
          if(c[1][col].token == ' ') {
            c[1][col].token = com;
            c[1][col].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      if((c[0][0].token == com) &&
         (c[1][1].token == com)) {
        if(c[2][2].token == ' ') {
          c[2][2].token = com;
          c[2][2].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[2][2].token == com) &&
         (c[1][1].token == com)) {
        if(c[0][0].token == ' ') {
          c[0][0].token = com;
          c[0][0].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[0][0].token == com) &&
         (c[2][2].token == com)) {
        if(c[1][1].token == ' ') {
          c[1][1].token = com;
          c[1][1].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[0][2].token == com) &&
         (c[2][0].token == com)) {
        if(c[1][1].token == ' ') {
          c[1][1].token = com;
          c[1][1].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[2][0].token == com) &&
         (c[1][1].token == com)) {
        if(c[0][2].token == ' ') {
          c[0][2].token = com;
          c[0][2].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[0][2].token == com) &&
         (c[1][1].token == com)) {
        if(c[2][0].token == ' ') {
          c[2][0].token = com;
          c[2][0].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      for(int row=0;row<3;row++) {
        if(found)
          break;
        if((c[row][0].token == hum) &&
           (c[row][1].token == hum)) {
          if(c[row][2].token == ' ') {
            c[row][2].token = com;
            c[row][2].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int row=0;row<3;row++) {
        if(found)
          break;
        if((c[row][1].token == hum) &&
           (c[row][2].token == hum)) {
          if(c[row][0].token == ' '); {
            c[row][0].token = com;
            c[row][0].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int row=0;row<3;row++) {
        if(found)
          break;
        if((c[row][0].token == hum) &&
           (c[row][2].token == hum)) {
          if(c[row][1].token == ' ') {
            c[row][1].token = com;
            c[row][1].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int col=0;col<3;col++) {
        if((c[0][col].token == hum) &&
           (c[1][col].token == hum)) {
          if(c[2][col].token == ' ') {
            c[2][col].token = com;
            c[2][col].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int col=0;col<3;col++) {
        if((c[1][col].token == hum) &&
           (c[2][col].token == hum)) {
          if(c[0][col].token == ' ') {
            c[0][col].token = com;
            c[0][col].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      for(int col=0;col<3;col++) {
        if((c[0][col].token == hum) &&
           (c[2][col].token == hum)) {
          if(c[1][col].token == ' ') {
            c[1][col].token = com;
            c[1][col].repaint();
            found = true;
          }
        }
      }
    }

    if(!found) {
      if((c[0][0].token == hum) &&
         (c[1][1].token == hum)) {
        if(c[2][2].token == ' ') {
          c[2][2].token = com;
          c[2][2].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[2][2].token == hum) &&
         (c[1][1].token == hum)) {
        if(c[0][0].token == ' ') {
          c[0][0].token = com;
          c[0][0].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[0][0].token == hum) &&
         (c[2][2].token == hum)) {
        if(c[1][1].token == ' ') {
          c[1][1].token = com;
          c[1][1].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[0][2].token == hum) &&
         (c[2][0].token == hum)) {
        if(c[1][1].token == ' ') {
          c[1][1].token = com;
          c[1][1].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[2][0].token == hum) &&
         (c[1][1].token == hum)) {
        if(c[0][2].token == ' ') {
          c[0][2].token = com;
          c[0][2].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if((c[0][2].token == hum) &&
         (c[1][1].token == hum)) {
        if(c[2][0].token == ' ') {
          c[2][0].token = com;
          c[2][0].repaint();
          found = true;
        }
      }
    }

    if(!found) {
      if(c[1][1].token == ' ') {
        c[1][1].token = com;
        c[1][1].repaint();
        found = true;
      }
    }

    if(!found) {
      for(int i = 0; i<3;i++) {
        if(found)
          break;
        for(int j = 0; j<3; j++) {
          if(found)
            break;
          if(c[i][j].token == ' ') {
            c[i][j].token = com;
            c[i][j].repaint();
            found = true;
          }
        }
      }
    }

    if(winGame()) {
      jlblStatus.setText(turn + " wins the game.");
      removeListeners();
    }
    else if(drawGame()) {
      jlblStatus.setText("Draw game, reset to play again.");
    }
    else {
      if(com == 'X') {
        turn = 'O';
      }
      else {
        turn = 'X';
      }
      jlblStatus.setText(turn + "'s turn");
    }
  }

  public boolean winGame() {
    for(int row=0;row<3;row++) {
      if((c[row][0].token == turn) &&
         (c[row][1].token == turn) &&
         (c[row][2].token == turn))
           return true;
    }

    for(int col=0;col<3;col++) {
      if((c[0][col].token == turn) &&
         (c[1][col].token == turn) &&
         (c[2][col].token == turn))
           return true;
    }

    if((c[0][0].token == turn) &&
       (c[1][1].token == turn) &&
       (c[2][2].token == turn))
         return true;

    if((c[0][2].token == turn) &&
       (c[1][1].token == turn) &&
       (c[2][0].token == turn))
         return true;

    return false;
  }

  public void removeListeners() {
    for(int i=0;i<3;i++) {
      for(int j=0;j<3;j++) {
        c[i][j].removeMouseListener(c[i][j]);
      }
    }
  }

  public boolean drawGame() {
    for(int i=0;i<3;i++) {
      for(int j=0;j<3;j++) {
        if(c[i][j].token == ' ')
          return false;
      }
    }

    return true;
  }


  class Cell extends JPanel implements MouseListener {
    char token = ' ';

    public Cell() {
      this.setBorder(new LineBorder(Color.black, 1));
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (token == 'X') {
        g.setColor(Color.black);
        g.drawLine(5,5, getWidth()-5, getHeight()-5);
        g.drawLine(5, getHeight()-5, getWidth()-5, 5);
      }
      else if (token == 'O') {
        g.setColor(Color.black);
        g.drawOval(5,5, getWidth()-10, getHeight()-10);
      }
    }

    public void mouseClicked(MouseEvent e) {
      if(token == ' ') {
        this.token = turn;
        this.repaint();
        if(winGame()) {
          jlblStatus.setText(turn + " wins the game.");
          removeListeners();
        }
        else if(drawGame()) {
          jlblStatus.setText("Draw game, reset to play again.");
        }
        else {
          if(turn == 'X') {
            turn = 'O';
            jlblStatus.setText(turn + "'s turn");
          }
          else if (turn == 'O') {
            turn = 'X';
            jlblStatus.setText(turn + "'s turn");
          }

          if(turn == com) {
            comTurn();
          }
        }
      }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
  }
}