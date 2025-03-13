import java.rmi.*;
import java.net.*;
import java.util.*;
import java.io.*;


class RmiClient{
public static void main(String args[]){
  try{
  	String ip=" ";
  	String data="",temp="",t1,t2,t3,t4,t5;
  	
	InetAddress net=InetAddress.getLocalHost();
  	System.out.println("The client "+ net +" is started");
  	
  	DataInputStream user_input=new DataInputStream(System.in);
	System.out.print("\nEnter Your user name: ");
	temp=user_input.readLine();
	ip=net+", user: "+temp;
	RmiIntf im1=(RmiIntf)Naming.lookup("rmi://127.0.0.1/FTP");
	String wel=im1.connect(ip);
	System.out.println(wel);
	   
  	boolean f;
	f=true;
	while(f){
	   System.out.print("\nEnter Your Choice Upload- u, Download- d, Exit- e :");
	   temp=user_input.readLine();
	   
	   RmiIntf im=(RmiIntf)Naming.lookup("rmi://127.0.0.1/FTP");
	  
	  if (temp.equals("u")){
	  	System.out.print("Enter the file name to upload	:");	t1=user_input.readLine();	
		BufferedReader file= new BufferedReader(new FileReader("download\\"+t1));
			
		temp=file.readLine();
		data=temp;
		
		while(temp != null)		{
			temp=file.readLine();
			data=data + "\n" + temp;
			}
		file.close();	
		im.upload(t1,data,ip);	
		System.out.print("The file " + t1 + " uploaded to server ");
		System.out.println();
			}
	  	
	  else if(temp.equals("d")){		
	  	System.out.print("Enter the file name to download :");	t1=user_input.readLine();
		String s=im.download(t1,ip);
		System.out.println("---------------------------------------------------------------");		
		System.out.println(s);
		System.out.println("---------------------------------------------------------------");		
		
		FileWriter fw=new FileWriter("download\\"+t1);
		fw.write(s);
		fw.close();
		}
				
	 	else if(temp.equals("e")){
	 		String dis=im.disconnect(ip);
	 		f=false;}
	 	else
	 		System.out.println("Wrong input given......"); 
		}
		
		
     } catch(Exception e1){System.out.println(e1);}
   }
  }
