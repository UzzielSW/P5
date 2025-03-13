import java.awt.*;

public class ChatClient{
 private TextArea output;
 private TextField input;
 private Button sendbutton;
 private Button quietbutton;
 
 public ChatClient(){
output=new TextArea(10,50);
output.setEditable(true);
input=new TextField(50);
input.setBackground(Color.white);
output.setText("Bianca: te quiero, ari-kun");
input.setEditable(true);
sendbutton=new Button("Send");
quietbutton=new Button("Quiet");
	
 }
 
 public void launchframe(){
 Frame f=new Frame("Chat Room");
 f.setLayout(new BorderLayout());
 f.add(output,BorderLayout.WEST);
 f.add(input,BorderLayout.SOUTH);
 Panel p1= new Panel();
 p1.add(sendbutton);
 p1.add(quietbutton);
 f.add(p1,BorderLayout.CENTER);
 f.setSize(440,210);
 f.setVisible(true);
 }
	public static void main(String args[]){
	ChatClient test=new ChatClient();
	test.launchframe();
	}
}
