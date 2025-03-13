package flow;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class FlowApplet extends Applet {
  Button btn1 = new Button();
  Button btn2 = new Button();
  Button btn3 = new Button();
  Button btn4 = new Button();
  FlowLayout flowLayout1 = new FlowLayout();
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
    btn1.setFont(new Font("Dialog", 1, 16));
    btn1.setLabel("1");
    btn2.setFont(new Font("Dialog", 1, 16));
    btn2.setLabel("2");
    btn3.setFont(new Font("Dialog", 1, 16));
    btn3.setLabel("3");
    btn4.setFont(new Font("Dialog", 1, 16));
    btn4.setLabel("4");
    flowLayout1.setHgap(20);
    this.setLayout(flowLayout1);
    this.add(btn1, null);
    this.add(btn2, null);
    this.add(btn3, null);
    this.add(btn4, null);
    
  }
}

 