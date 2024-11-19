package grid;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class GridApplet extends Applet {
  Button btn00 = new Button();
  Button btn01 = new Button();
  Button btn02 = new Button();
  Button btn03 = new Button();
  Button btn10 = new Button();
  Button btn11 = new Button();
  Button btn12 = new Button();
  Button btn13 = new Button();
  GridLayout gridLayout1 = new GridLayout();

  public void init() {
    try {
    jbInit();
    }
    catch (Exception e) {
    e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    setBackground(Color.white);
    btn00.setFont(new Font("Dialog", 1, 16));
    btn00.setLabel("00");
    btn01.setFont(new Font("Dialog", 1, 16));
    btn01.setLabel("01");
    btn02.setFont(new Font("Dialog", 1, 16));
    btn02.setLabel("02");
    btn03.setFont(new Font("Dialog", 1, 16));
    btn03.setLabel("03");
    btn10.setFont(new Font("Dialog", 1, 16));
    btn10.setLabel("10");
    btn11.setFont(new Font("Dialog", 1, 16));
    btn11.setLabel("11");
    btn12.setFont(new Font("Dialog", 1, 16));
    btn12.setLabel("12");
    btn13.setFont(new Font("Dialog", 1, 16));
    btn13.setLabel("13");
    gridLayout1.setRows(2);
    gridLayout1.setHgap(10);
    gridLayout1.setColumns(3);
    gridLayout1.setVgap(10);
    this.setLayout(gridLayout1);
    this.add(btn00, null);
    this.add(btn01, null);
    this.add(btn02, null);
    this.add(btn03, null);
    this.add(btn10, null);
    this.add(btn11, null);
    this.add(btn12, null);
    this.add(btn13, null);
  }
}

