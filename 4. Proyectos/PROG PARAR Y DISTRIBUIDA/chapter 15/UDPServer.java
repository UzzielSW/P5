
// UDPServer.java
import java.io.*;
import java.net.*;

class UDPServer {
	final static int USER_PORT = 777;

	public static void main(String args[]) {
		DatagramSocket socket;
		DatagramPacket datagram;
		String receive;
		try {
			socket = new DatagramSocket(USER_PORT);
			while (true) {
				datagram = new DatagramPacket(new byte[1024], 1024);
				socket.receive(datagram);
				receive = new String(datagram.getData());
				System.out.println("Data sent by the client:  " + receive);
				datagram = new DatagramPacket(datagram.getData(), datagram.getLength(),
				datagram.getAddress(), datagram.getPort());
				socket.send(datagram);
			}
		} catch (IOException i) {
			System.out.println("could not receive or send datagram");
		}
	}
}
