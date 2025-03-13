import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.util.*;

class Chatroom3 extends Dialog implements ActionListener {
	server s;
	TextArea ta1;
	public static java.awt.List list,list1;
	static Vector cs = new Vector();
	static Vector c = new Vector();
	static int first = 0;
	Button bs,close;
	String send;

	public static serverone t;
		BufferedWriter temp;

		public void show(serverone one)
		{
			this.show();
			this.t=one;
			temp=t.bw;
		}




	public Chatroom3(String s,server f){
		super(f,s,false);

		this.s = f;

		this.setSize(400,400);

		this.setLayout(new GridLayout(1,2));
		list = new java.awt.List();
		list1 = new java.awt.List();
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();

		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
	    p4.setLayout(new FlowLayout(FlowLayout.CENTER));
        p1.add(list1,BorderLayout.CENTER);


        p2.add(list,BorderLayout.CENTER);

	    Label ld = new Label("This is " + s);
	    p1.add(ld,BorderLayout.NORTH);

	    Label lc = new Label("Online Users");
	    p2.add(lc,BorderLayout.NORTH);


        ta1 = new TextArea(2,5);
        p1.add(ta1,BorderLayout.SOUTH);

        bs = new Button("Send");
        close = new Button("Exit");
        bs.addActionListener(this);
        close.addActionListener(this);
        p4.add(bs);
        p4.add(close);
        p2.add(p4,BorderLayout.SOUTH);
        this.add(p1);
        this.add(p2);


       //  this.show();

						}

	  public void actionPerformed(ActionEvent ae)
		{
	                 if (ae.getSource().equals(close))
	                 {
						this.dispose();
					 }


					 if (ae.getSource().equals(bs))
					 					 	                 {
					 				try{
		list1.addItem("<Chatroom3>"+ta1.getText());
					 	for(int i = 0;i<c.size();i++){

					 		          t.bw=(BufferedWriter)cs.elementAt(i);
					 		          t.sendtoclients("<Chatroom3>"+ta1.getText());
					 		        //   ta1.setText(" ");

					 			  }
					 			t.bw=temp;

					 		    }
					 		    catch(Exception e)
					 		    {
					 				System.out.println(e.toString());
					 			}
					 					 }






			 }




}





