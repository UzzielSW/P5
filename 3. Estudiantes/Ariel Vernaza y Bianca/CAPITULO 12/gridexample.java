import java.awt.*;
public class GridExample{
 private Frame f;
 private Button b1;
 private Button b2;
 private Button b3;
 private Button b4;
 private Button b5;
 public GridExample(){
	f=new Frame("GridExample");
	b1=new Button("1");
	b2=new Button("2");
	b3=new Button("3");
	b4=new Button("4");
	b5=new Button("5");
	
 }
 public void launchframe(){
 f.setLayout(new GridLayout(3,2));
 f.add(b1);
 f.add(b2);
 f.add(b3);
 f.add(b4);
 f.add(b5);
 f.pack();
 f.setVisible(true);
 }
	public static void main(String args[]){
	GridExample test=new GridExample();
	test.launchframe();
	}
}
