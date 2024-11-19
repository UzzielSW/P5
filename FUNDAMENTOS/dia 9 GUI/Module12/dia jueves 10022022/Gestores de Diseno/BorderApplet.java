package border;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class BorderApplet extends Applet {
  Button btnOeste = new Button();
  Button btnEste = new Button();
  Button btnNorte = new Button();
  Button btnSur = new Button();
  Button btnCentro = new Button();
  BorderLayout borderLayout1 = new BorderLayout();

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
    this.setSize(new Dimension(336, 253));
    this.setLayout(borderLayout1);
    btnOeste.setFont(new Font("Dialog", 1, 16));
    btnOeste.setLabel("Oeste");
    btnEste.setFont(new Font("Dialog", 1, 16));
    btnEste.setLabel("Este");
    btnNorte.setFont(new Font("Dialog", 1, 16));
    btnNorte.setLabel("Norte");
    btnSur.setFont(new Font("Dialog", 1, 16));
    btnSur.setLabel("Sur");
    btnCentro.setFont(new Font("Dialog", 1, 16));
    btnCentro.setLabel("Centro");
    borderLayout1.setVgap(20);
    borderLayout1.setHgap(20);
    this.add(btnOeste, BorderLayout.WEST);
    this.add(btnEste, BorderLayout.EAST);
    this.add(btnNorte, BorderLayout.NORTH);
    this.add(btnSur, BorderLayout.SOUTH);
    this.add(btnCentro, BorderLayout.CENTER);
  }
}

