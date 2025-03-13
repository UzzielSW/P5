// RmiClient.java
import java.rmi.*;
class RmiClient {
public static void main(String args[]){
try{
RmiIntf im=(RmiIntf)Naming.lookup("rmi://10.129.50.20/call");
	     String s=im.call();
	     System.out.println(s);
	}catch(Exception e1){System.out.println(e1);}
}}
