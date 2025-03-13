
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class client extends Frame implements ActionListener,ItemListener{

	public Label l1,l2,l3,l4;
	public Button Ok,Cancel;
	public TextField login,pwd;
	public Checkbox Chatroom1,Chatroom2,Chatroom3;
	public CheckboxGroup cbg;
	public client1 c1;
	public static String l,c,p,a;

	public client() {

        super("Client Login Frame");

		Panel p2 = new Panel();
		p2.setBackground(Color.lightGray);

		Panel p4 = new Panel();
		p4.setBackground(Color.lightGray);
		Panel p5 = new Panel();
		p5.setBackground(Color.lightGray);
		Panel p6 = new Panel();
		p6.setBackground(Color.lightGray);

		p2.setLayout(new FlowLayout(FlowLayout.CENTER));

		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.setLayout(new GridLayout(4,1));

       this.setLayout(new GridLayout(4,1));
	   		l2 = new Label("Username");
	           login = new TextField(10);
	           p2.add(l2);
	           p2.add(login);
	           l3 = new Label("Password");
	           pwd = new TextField(10);
	           pwd.setEchoChar('*');
	           p2.add(l3);
	           p2.add(pwd);
	           l4 = new Label("ChatRooms");
	           p4.add(l4);
        cbg = new CheckboxGroup();
        Chatroom1 = new Checkbox("Chatroom1",cbg,true);
        Chatroom2 = new Checkbox("Chatroom2",cbg,false);
        Chatroom3 = new Checkbox("Chatroom3",cbg,false);
        p5.add(Chatroom1);
        p5.add(Chatroom2);
        p5.add(Chatroom3);
        Ok = new Button("Ok");
        Cancel = new Button("Cancel");
        p6.add(Ok);
        p6.add(Cancel);
        login.addActionListener(this);
        pwd.addActionListener(this);
        Chatroom1.addItemListener(this);
        Chatroom2.addItemListener(this);
        Chatroom3.addItemListener(this);
        Ok.addActionListener(this);
        Cancel.addActionListener(this);

          this.add(p4);
          this.add(p5);
          this.add(p2);
        this.add(p6);
	}

	public void actionPerformed(ActionEvent e){

		String str = e.getActionCommand();

		if(str.equals("Ok")){

		    l = login.getText();
			login.setText("");
		    p = pwd.getText();
			pwd.setText("");

			c = cbg.getSelectedCheckbox().getLabel();

		if(l.equals(p))
			c1 = new client1(this);
		else
           login.setText("Invalid Login");
		}
		if(str.equals("Cancel"))
		{
		System.exit(0);
	    }

	}

	public void itemStateChanged(ItemEvent ie){

	}

	public static void main (String[] args) {
		client dc = new client();
		dc.setSize(500,200);
		dc.setVisible(true);
		Image Icon = Toolkit.getDefaultToolkit().getImage("hi.gif") ;
                             dc.setIconImage(Icon);
	}
}

 class client1 extends Frame
{
	public static int l=0;

         public static client c;
	    public InetAddress addr;
		public static Socket s;
		public static BufferedReader br;
		public static BufferedWriter bw;
		public static TextField text;
	    public static Button sendBut, exitBut;
		public static List list,list1;



	public client1(client c)
	{

        this.c=c;
		boolean b=true;
		Image Icon = Toolkit.getDefaultToolkit().getImage("hi.gif") ;

      Frame h=new Frame("Client : "+c.l);
      h.setSize(400,300);
      h.setIconImage(Icon);
	  h.setLocation(300,0);
       h.setLayout(new BorderLayout());

      Label ld = new Label("You are in "+c.c+"                                Online Users");
      ld.setBackground(new Color(192, 192, 192));
      h.add(ld,BorderLayout.NORTH);

      h.setBackground(new Color(192, 192, 192));
      Panel f=new Panel();
      f.setLayout(new GridLayout(1,2));
      list=new List();
      f.add(list);
      list1=new List();
      Panel f1=new Panel();
      Panel f2=new Panel();
      Panel f3=new Panel();
      f1.setLayout(new GridLayout(2,1));
      f1.add(list1);
      f2.setLayout(new GridLayout(2,1));
      text=new TextField(25);
     // text.setSize(25);
      f2.add(text);
      sendBut = new Button("Send");
      exitBut = new Button("Logout");
      f3.add(sendBut);
      f3.add(exitBut);
      f2.add(f3);


      f1.add(f2);

      f.add(f1);
      h.add(f);

      h.setVisible(true);
      c.setVisible(false);

						try{
		        		InetAddress addr=InetAddress.getByName(null);
		            	Clientone ct=new Clientone(addr);
						}
						catch(IOException e)
						{
						}

	}
}


class Clientone extends Frame implements ActionListener, Runnable
{

        public InetAddress addr;
	Socket s;
	BufferedReader br;
	BufferedWriter bw;

        public Clientone(InetAddress addr)
	{
                super("Chat Client Application");
                this.addr=addr;


                client1.sendBut.addActionListener(this);
                client1.exitBut.addActionListener(this);



                try
                {


                        s = new Socket("127.0.0.1", 8085);
                        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
						bw.write(client.l);
						bw.newLine();
						bw.write(client.c);
						bw.newLine();
                        bw.flush();
                //   client1.list1.addItem(client.l);

			Thread th;
			th = new Thread(this);
			th.start();

		}catch(Exception e){}

	}


        public void run()
	{

                while (true)
		{
			try
       {                  String str=br.readLine();

                          if(str.startsWith("Users"))
                          {
							client1.list1.addItem(str.substring(5,str.length()));
						  }
					else if(str.equals("Clear"))
                          {
							client1.list1.removeAll();
						  }
					else if(str.startsWith("Remove"))
                          {
							client1.list1.remove(str.substring(6,str.length()));
						  }

						  else
						  {
                          client1.list.addItem(str);
					       }
			}catch (Exception h){}
		}
	}



        public void actionPerformed(ActionEvent ae)
	{
                 if(ae.getSource().equals(client1.exitBut))
                 {
                     try
                        {
				   bw.write("Dispose"+client.c+client.l);
                   bw.newLine();
                   bw.flush();
			       System.exit(0);
			       }catch(Exception r){}

			      }
		 else
                 {
                        try
                        {
							String room=null;
							if(client.c.equals("Chatroom1"))
							{
							room="<room1>";
							}
							else if(client.c.equals("Chatroom2"))
							room="<room2>";
							else if(client.c.equals("Chatroom3"))
							room="<room3>";

                                bw.write(room+"<"+client1.c.l+">"+client1.text.getText());
                                bw.newLine();
                                bw.flush();
                                client1.text.setText("");
                        }catch(Exception m){}
		 }

	}

}
