import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;



public class server extends Frame implements ActionListener
{
	public static final int port=8085;
	public static int m;
	public static Button sendBut, exitBut ,room1,room2,room3;
    public static java.awt.List list,list1,list2,list3;
    public static Chatroom1 ch1;
    public static Chatroom2 ch2;
    public static Chatroom3 ch3;
	public static Vector clients=new Vector();
    public static TextField text;
    public static server f;
    public static serverone s1;

    public server()
    {
	}

	public static void main(String[] args) throws IOException
	{
		boolean k=true;
		ServerSocket s=null;
		Image Icon = Toolkit.getDefaultToolkit().getImage("hi.gif");

		try
		{
			s=new ServerSocket(8085);
		}
		catch(IOException ie)
		{
			System.out.println("Couldn't Listen on Port : 1053");
		}

		f=new server();
		f.setSize(500, 300);
		f.setTitle("Server Application");
		f.setIconImage(Icon);

		                f.setBackground(new Color(192, 192, 192));
		                f.setLayout(new GridLayout(3, 4));

		                Panel panels[] = new Panel[12];
		                panels[0] = new Panel();
		                panels[1] = new Panel();
		                panels[5] = new Panel();
		                panels[6] = new Panel();

		                panels[0].setLayout(new BorderLayout());
		                panels[1].setLayout(new FlowLayout(FlowLayout.LEFT));
		                panels[5].setLayout(new GridLayout(1, 3));
		                panels[6].setLayout(new GridLayout(2, 3));

		                sendBut = new Button("Send");
		                exitBut = new Button("Exit");
		                room1=new Button("Chat Room 1");
		                room2=new Button("Chat Room 2");
		                room3=new Button("Chat Room 3");
		                room1.addActionListener(f);
		                room2.addActionListener(f);
		                room3.addActionListener(f);




		                list = new java.awt.List();
		                list1 = new java.awt.List();
		                list2 = new java.awt.List();
		                list3 = new java.awt.List();

		                list.addItem("Server Started");


		                text = new TextField(25);


		                panels[0].add(list);

		                panels[6].add(list1);
		                panels[6].add(list2);
		                panels[6].add(list3);

		                panels[1].add(text);
		                panels[1].add(sendBut);
		                panels[1].add(exitBut);

		                panels[6].add(room1);
		                panels[6].add(room2);
		                panels[6].add(room3);


		                f.add(panels[0]);


                    f.add(panels[1]);
                    f.add(panels[6]);
             //     f.add(panels[5]);

		f.setVisible(true);

		ch1=new Chatroom1("Chatroom 1",f);
		ch2=new Chatroom2("Chatroom 2",f);
		ch3=new Chatroom3("Chatroom 3",f);

		while(k)
		s1=new serverone(s.accept());

		s.close();
	}




	  public void actionPerformed(ActionEvent ae)
		{
	                 if (ae.getSource().equals(room1))
	                 {

						 ch1.show(s1);
					 }
	                 if (ae.getSource().equals(room2))
	                 {
                         ch2.show(s1);
					 }
	                 if (ae.getSource().equals(room3))
	                 {
                         ch3.show(s1);
					 }

			 }




}



class serverone extends Frame implements ActionListener,Runnable
{
        Image Icon = Toolkit.getDefaultToolkit().getImage("hi.gif");

        Socket s;
	public BufferedReader br;
	public BufferedWriter bw;

        public serverone(Socket s)
	{
		       super("Server Application");

		       this.s=s;


                try
                {

                        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        bw.write("<Server>Hi!");
                        bw.newLine();
                        bw.flush();
						String k=br.readLine();
						System.out.println(k);

						String k1=br.readLine();
						System.out.println(k1);
						if(k1.equals("Chatroom1"))
						{
					    server.ch1.c.addElement(k);
					    server.ch1.list.addItem(k);
                        server.list1.addItem(k);
					    server.ch1.cs.addElement(bw);


                     BufferedWriter temp2=bw;
                 for(int m = 0;m<server.ch1.c.size();m++){

		          bw=(BufferedWriter)server.ch1.cs.elementAt(m);
                  for(int n = 0;n<server.ch1.c.size();n++)
		          sendtoclients("Clear");
            			  }
                              bw=temp2;



                        BufferedWriter temp1=bw;
                 for(int i = 0;i<server.ch1.c.size();i++){

		          bw=(BufferedWriter)server.ch1.cs.elementAt(i);
                  for(int j = 0;j<server.ch1.c.size();j++)
		          sendtoclients("Users"+server.ch1.c.elementAt(j));
            			  }
                              bw=temp1;

						}

						else if(k1.equals("Chatroom2"))
						{
					    server.ch2.c.addElement(k);
					    server.ch2.list.addItem(k);
					    server.list2.addItem(k);
					    server.ch2.cs.addElement(bw);



                   BufferedWriter temp2=bw;
                  for(int m = 0;m<server.ch2.c.size();m++){

		          bw=(BufferedWriter)server.ch2.cs.elementAt(m);
                  for(int n = 0;n<server.ch2.c.size();n++)
		          sendtoclients("Clear");
            			  }
                              bw=temp2;



                        BufferedWriter temp1=bw;
                 for(int i = 0;i<server.ch2.c.size();i++){

		          bw=(BufferedWriter)server.ch2.cs.elementAt(i);
                  for(int j = 0;j<server.ch2.c.size();j++)
		          sendtoclients("Users"+server.ch2.c.elementAt(j));
            			  }
                              bw=temp1;





						}
						else if(k1.equals("Chatroom3"))
						{
					    server.ch3.c.addElement(k);
					    server.ch3.list.addItem(k);
					    server.list3.addItem(k);
					    server.ch3.cs.addElement(bw);


		BufferedWriter temp2=bw;
                 for(int m = 0;m<server.ch3.c.size();m++){

		          bw=(BufferedWriter)server.ch3.cs.elementAt(m);
                  for(int n = 0;n<server.ch3.c.size();n++)
		          sendtoclients("Clear");
            			  }
                              bw=temp2;



                        BufferedWriter temp1=bw;
                 for(int i = 0;i<server.ch3.c.size();i++){

		          bw=(BufferedWriter)server.ch3.cs.elementAt(i);
                  for(int j = 0;j<server.ch3.c.size();j++)
		          sendtoclients("Users"+server.ch3.c.elementAt(j));
            			  }
                              bw=temp1;




						}



                        server.sendBut.addActionListener(this);
		                server.exitBut.addActionListener(this);

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
                        {
							String readl=br.readLine();
							    if(readl.startsWith("Dispose"))
							    {
	server.list.addItem(readl.substring(16,readl.length())+" Logged out of "+readl.substring(7,16));
								}

                                if((readl).startsWith("<room1>"))
                                {

                    BufferedWriter temp=bw;


  		          server.ch1.list1.addItem(readl.substring(7,readl.length()));
                  for(int i = 0;i<server.ch1.c.size();i++){

		          bw=(BufferedWriter)server.ch1.cs.elementAt(i);

		          sendtoclients(readl.substring(7,readl.length()));
            			  }
                              bw=temp;


								}



                                if((readl).startsWith("<room2>"))
                                {

                    BufferedWriter temp=bw;

    		          server.ch2.list1.addItem(readl.substring(7,readl.length()));
                   for(int i = 0;i<server.ch2.c.size();i++){

    		          bw=(BufferedWriter)server.ch2.cs.elementAt(i);

    		          sendtoclients(readl.substring(7,readl.length()));
                 			  }
                              bw=temp;


								}


                                if((readl).startsWith("<room3>"))
                                {

                    BufferedWriter temp=bw;

                  server.ch3.list1.addItem(readl.substring(7,readl.length()));
                   for(int i = 0;i<server.ch3.c.size();i++){

    		          bw=(BufferedWriter)server.ch3.cs.elementAt(i);

    		          sendtoclients(readl.substring(7,readl.length()));
                 			  }
                              bw=temp;


								}

				if((readl).startsWith("Dispose"))
				{

                   if((readl.substring(7,16)).equals("Chatroom1"))
                   {

                    int ind=server.ch1.c.indexOf(readl.substring(16,readl.length()));
                    //boolean del=server.ch1.c.removeElement(readl.substring(16,readl.length()));
                    server.ch1.c.removeElementAt(ind);
                    server.ch1.cs.removeElementAt(ind);
                    server.ch1.list.remove(readl.substring(16,readl.length()));
                    server.ch1.list1.addItem(readl.substring(16,readl.length())+" Logged out");
                    server.list1.remove(readl.substring(16,readl.length()));

                     BufferedWriter temp=bw;
	        	     for(int i = 0;i<server.ch1.c.size();i++){
    		          bw=(BufferedWriter)server.ch1.cs.elementAt(i);
    		          sendtoclients("Remove"+readl.substring(16,readl.length()));
                 			  }
	                	  bw=temp;

				   }
                  if((readl.substring(7,16)).equals("Chatroom2"))
                   {

                    int ind=server.ch2.c.indexOf(readl.substring(16,readl.length()));
                    boolean del=server.ch2.c.removeElement(readl.substring(16,readl.length()));
                    server.ch2.cs.removeElementAt(ind);
                    server.ch2.list.remove(readl.substring(16,readl.length()));
                    server.ch2.list1.addItem(readl.substring(16,readl.length())+" Logged out");
                    server.list2.remove(readl.substring(16,readl.length()));
                     BufferedWriter temp=bw;
	        	     for(int i = 0;i<server.ch2.c.size();i++){
    		          bw=(BufferedWriter)server.ch2.cs.elementAt(i);
    		          sendtoclients("Remove"+readl.substring(16,readl.length()));
                 			  }
	                	  bw=temp;

				   }
                  if((readl.substring(7,16)).equals("Chatroom3"))
                   {
                    int ind=server.ch3.c.indexOf(readl.substring(16,readl.length()));
                    boolean del=server.ch3.c.removeElement(readl.substring(16,readl.length()));
                    server.ch3.cs.removeElementAt(ind);
                    server.ch3.list.remove(readl.substring(16,readl.length()));
                    server.ch3.list1.addItem(readl.substring(16,readl.length())+" Logged out");
                    server.list3.remove(readl.substring(16,readl.length()));

                        BufferedWriter temp=bw;
	        	     for(int i = 0;i<server.ch3.c.size();i++){
    		          bw=(BufferedWriter)server.ch3.cs.elementAt(i);
    		          sendtoclients("Remove"+readl.substring(16,readl.length()));
                 			  }
	                	  bw=temp;





				   }
				}

				else
                                server.list.addItem(readl);



                        }catch (Exception e){}
		}
	}



        public void actionPerformed(ActionEvent ae)
	{
                 if (ae.getSource().equals(server.exitBut))
			 System.exit(0);
                 else
                 {
                String d=server.text.getText();
               // server.list.addItem("<Server>"+d);
              //  server.text.setText(" ");
                sendtoclients("<Server>"+d);
		           }

	}


	public void sendtoclients(String msg)
	{
		                        try
		                        {

										bw.write(msg);
		                                bw.newLine();
		                                bw.flush();
		                                //server.text.setText("");
									 // }
                        }catch(Exception x){}

	}

}
