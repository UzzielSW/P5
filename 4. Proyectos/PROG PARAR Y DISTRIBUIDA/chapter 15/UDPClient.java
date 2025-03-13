
// UDPClient.java
import java.io.*;
import java.net.*;

class UDPClient {
	final static int USER_PORT = 777;

	public static void main(String args[]) {
		DatagramSocket socket;
		DatagramPacket datagram;
		InetAddress destination;
		byte mesg[] = new byte[1024];
		String receive;
		try {
			socket = new DatagramSocket();
			destination = InetAddress.getLocalHost();
			System.out.println("enter the data to be sent by the client  :  ");
			int b = System.in.read(mesg);
			datagram = new DatagramPacket(mesg, mesg.length, destination, USER_PORT);
			socket.send(datagram);
			datagram = new DatagramPacket(mesg, mesg.length);
			socket.receive(datagram);
			receive = new String(datagram.getData());
			System.out.println("\n Data sent by the server :  " + receive);
		} catch (SocketException s) {
			System.out.println("socket could not be opened");
		} catch (IOException s) {
			System.out.println("could not sent or receive datagram");
		}
	}
}
