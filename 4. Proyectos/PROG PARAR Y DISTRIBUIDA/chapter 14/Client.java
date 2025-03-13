
// pioclie.java
import java.io.*;
import java.net.*;

class Client {
	public static void main(String arg[]) throws Exception {
		Socket socket;
		DataInputStream input;
		PrintStream output;
		socket = new Socket("10.129.50.20", 50);
		input = new DataInputStream(socket.getInputStream());
		output = new PrintStream(socket.getOutputStream());
		String data, temp, temp1;
		DataInputStream user_input = new DataInputStream(System.in);
		System.out.println("Enter your user name :");
		temp = user_input.readLine();
		InetAddress net = InetAddress.getLocalHost();
		String s = net + ", User:" + temp;
		output.println(s);
		System.out.println("Your address is " + s);
		boolean f;
		f = true;
		while (f) {
			System.out.print("\nEnter Your Choice Upload- u, Download- d, Exit- e :");
			temp = user_input.readLine();
			output.println(temp);
			if (temp.equals("u")) {
				System.out.print("Enter the file name to upload :");
				temp1 = user_input.readLine();
				output.println(temp1);
				BufferedReader file = new BufferedReader(new FileReader("download\\" + temp1));
				temp = file.readLine();
				data = temp;
				while (temp != null) {
					data = data + temp;
					temp = file.readLine();
				}
				output.println(data);
				file.close();
				System.out.print("The file " + temp1 + " uploaded to server ");
				System.out.println();
			} else if (temp.equals("d")) {
				System.out.print("Enter the file name to download	:");
				temp1 = user_input.readLine();
				FileWriter fw = new FileWriter("download\\" + temp1);
				output.println(temp1);
				temp1 = input.readLine();
				fw.write(temp1);
				fw.close();
			} else if (temp.equals("e"))
				f = false;
			else
				System.out.println("Wrong input given......");
		}
		output.close();
		input.close();
	}
}
