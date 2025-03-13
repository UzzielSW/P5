import java.awt.*;
public class FrameWithPanel{
 private Frame f;
 public FrameWithPanel(String title){
	f=new Frame(title);
 }
 public void launchframe(){
 f.setBackground(Color.blue);
 f.setSize(100,100);
 f.setLayout(null);
 Panel pane=new Panel();
 pane.setSize(50,50);
 pane.setBackground(Color.yellow);
 pane.setVisible(true);
 f.add(pane);
 f.setVisible(true);
 }
	public static void main(String args[]){
	FrameWithPanel test=new FrameWithPanel("Esto tiene muchos colores");
	test.launchframe();
	}
}
