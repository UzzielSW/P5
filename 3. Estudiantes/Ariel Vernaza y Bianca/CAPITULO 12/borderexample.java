import java.awt.*;
public class BorderExample {
 private Frame f;
 private Button bn,bs,bw,be,bc;
 public BorderExample(){
	f=new Frame("BorderLayout");
	bn=new Button("B1");
	bs=new Button("B2");
	bw=new Button("B3");
	be=new Button("B4");
	bc=new Button("B5");
 }
 public void launchframe(){
 f.add(bn,BorderLayout.NORTH);
 f.add(bs,BorderLayout.SOUTH);
 f.add(bw,BorderLayout.WEST);
 f.add(be,BorderLayout.EAST);
 f.add(bc,BorderLayout.CENTER);
 f.setVisible(true);
 f.setSize(200,200);
 }
	public static void main(String args[]){
	BorderExample test=new BorderExample();
	test.launchframe();
	}
}
