
//Server.java
import java.io.*;
import java.net.*;

public class Server {
	public static int port = 0;
	public static server1 s1;
	public static ServerSocket clientsocket = null;

	public Server() {
		try {
			clientsocket = new ServerSocket(50);
			InetAddress net = InetAddress.getLocalHost();
			System.out.println("The server " + net + " is started");
		} catch (IOException ie) {
			System.out.println("Couldn't Listen on Port : 50");
		}
	}

	public static void main(String arg[]) throws IOException {
		new Server();
		while (true) {
			server1 s1 = new server1(clientsocket.accept());
		}
	}
}

class server1 implements Runnable {
	DataInputStream input;
	PrintStream output;
	String ip;

	public server1(Socket s) {
		Socket client;
		client = s;
		try {
			input = new DataInputStream(client.getInputStream());
			output = new PrintStream(client.getOutputStream());
			Thread th = new Thread(this);
			ip = input.readLine();
			System.out.println("The System IP: " + ip + " is connceted");
			th.start();
		} catch (Exception c) {
		}
	}

	public void run() {
		boolean f;
		f = true;
		String temp, temp1;
		String data, t1, t2, t3, t4, t5, t6;
		try {
			while (f) {
				t1 = input.readLine();
				if (t1.equals("u")) {
					temp1 = input.readLine();
					FileWriter fw = new FileWriter("download\\" + temp1);
					System.out.print("The file " + temp1 + "from" + ip + " uplaoded to Server");
					temp1 = input.readLine();
					fw.write(temp1);
					fw.close();
				} else if (t1.equals("d")) {
					temp1 = input.readLine();
					BufferedReader file = new BufferedReader(new FileReader("download\\" + temp1));
					temp = file.readLine();
					data = temp;
					while (temp != null) {
						data = data + temp;
						temp = file.readLine();
					}
					output.println(data);
					file.close();
					System.out.print("The file " + temp1 + " downloaded to " + ip + "client ");
					System.out.println();
				} else if (t1.equals("e")) {
					output.close();
					input.close();
				}
			}
		} catch (Exception e) {
			System.out.println("The system IP :" + ip + " is disconnected");
		}
	}
}
