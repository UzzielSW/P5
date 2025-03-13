import java.awt.*;
public class FrameExample {
 private Frame f;
 public FrameExample(){
	f=new Frame("Hello out there!");
 }
 public void launchframe(){
 f.setVisible(true);
 f.setBackground(Color.blue);
 f.setSize(100,100);
 }
	public static void main(String args[]){
	FrameExample test=new FrameExample();
	test.launchframe();
	}
}
