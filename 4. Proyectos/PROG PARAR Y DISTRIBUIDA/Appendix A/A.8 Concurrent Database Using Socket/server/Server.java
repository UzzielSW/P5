import java.io.*;
import java.net.*;
import java.sql.*;
public class Server{
	public static int port=0;
	public static server1 s1;
	public static ServerSocket clientsocket=null;
	public Server()    {
		try{	
				
		clientsocket = new ServerSocket(500);
		InetAddress net=InetAddress.getLocalHost();
  		System.out.println("The server "+ net +" is started");
		}catch(IOException ie){System.out.println("Couldn't Listen on Port : 75");	}
			}
			
public static void main(String arg[]) throws IOException{	

new Server();
	
		while(true) {
				server1 s1=new server1(clientsocket.accept());}
		
} }

class server1 implements Runnable{
	DataInputStream input;
	PrintStream output;
	String ip;
public server1(Socket s){
			Socket client;
			client=s;
			try{ 
				input=new DataInputStream(client.getInputStream());
				output=new PrintStream (client.getOutputStream());
								
				Thread th= new Thread(this);
                             
                ip=input.readLine();
                System.out.println("The System IP: "+ ip +" is connceted");
                
                th.start();
              }catch(Exception c) {}
     }
                
public void run(){
			boolean f;
			f=true;
			String data1,t1,t2,t3,t4,t5,t6;
		try{
			
			while(f){
			t1=input.readLine();
		
		  	if(t1.equals("i")){
			  t2=input.readLine();
			  t3=input.readLine();
			  t4=input.readLine();
		  	  t5=input.readLine();
			  t6=input.readLine();
		
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   					String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=net.mdb";
      				Connection con=DriverManager.getConnection(url);
				  	
				  	Statement st=con.createStatement();
				    st.executeUpdate("insert into one values('"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"');");
			  con.close();
			  System.out.println();
		  	  System.out.println("Code			: "+t2);
			  System.out.println("Name			: "+t3);
		  	  System.out.println("Salary		: "+t4);
			  System.out.println("Disignation	: "+t5);
		  	  System.out.println("Age			: "+t6);
		  	  System.out.println("\nThe system IP : "+ip+ " is added one new record to Data Base" );}
		
			else if(t1.equals("d")){
			  	t2=input.readLine();
		
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   					String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=net.mdb";
      				Connection con=DriverManager.getConnection(url);
				  	Statement st=con.createStatement();
				    st.executeUpdate("delete from one where ecode="+t2);
				    con.close();
				    System.out.println("The System IP: " + ip + " has been deleted a record ecode= "+ t2 + " from Data Base" );}
			else if(t1.equals("s")){
		
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   					String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=net.mdb";
      				Connection con=DriverManager.getConnection(url);
			  	Statement st=con.createStatement();
			    ResultSet rs=st.executeQuery("select * from one");
			    String s=" ";
			  while(rs.next())   {
				s=s+"\t"+rs.getString(1)+"\t"+rs.getString(2)+ "\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t\t\t\t\t";
			   }
			   con.close();
			output.println(s);
			System.out.println("The system IP: " + ip + " is viewing the Data Base");} 
		    
		    else if(t1.equals("e")){
		    	output.close();
				input.close();
				}
			}
		    }catch(Exception e){System.out.println("The system IP :" + ip + " is disconnected");}
		}
  }

