import java.awt.*;

public class FlowExample {
 private Frame f;
 private Button b1,b2,b3;
 public FlowExample(){
	f=new Frame("FlowLayout");
	b1=new Button("OK");
	b2=new Button("Open");
	b3=new Button("Close");
 }
 public void launchframe(){
 f.setLayout(new FlowLayout());	 
 f.add(b1);
 f.add(b2);
 f.add(b3);
 f.setVisible(true);
 f.setSize(100,100);
 }
	public static void main(String args[]){
	FlowExample test=new FlowExample();
	test.launchframe();
	}
}
