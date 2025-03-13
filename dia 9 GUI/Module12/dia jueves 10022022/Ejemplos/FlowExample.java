import java.awt.*;

public class FlowExample {
	private Frame f;
	private Button b1;
	private Button b2;
	private Button b3;
	
	public FlowExample(){
		f   = new Frame("Flow Layout");
		b1  = new Button("OK");
		b2  = new Button("Open");
		b3  = new Button("Close");
		
	}
	
	public void launchFrame() {
		f.setLayout( new FlowLayout());
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setSize(100,100);
		f.setBackground(Color.blue);
		f.setVisible(true);
	}
	
	public static void main(String [] args) {
		FlowExample  guiWindow  = new FlowExample();
		guiWindow.launchFrame();
	}
}