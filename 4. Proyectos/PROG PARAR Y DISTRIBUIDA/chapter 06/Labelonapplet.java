import java.applet.*;
import java.awt.*;
 public class Labelonapplet extends Applet {
   public void init() {
      setVisible(true);
      setLayout(new GridLayout(3,1));
      add(new Label("aligned left", Label.LEFT));
      add(new Label("aligned center", Label.CENTER));
      add(new Label("aligned right", Label.RIGHT));
    } 
 }
