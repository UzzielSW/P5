
import java.net.*;

import javax.swing.*;

import java.awt.*;

import java.io.*;

import javax.swing.event.*;

import java.awt.event.*;

public class URLProgram implements ActionListener {
	JTextField textField;

	JFrame component;

	JButton connect, makeaWebPage;

	JDialog waiting;

	JTextArea textArea;

	//////////////////

	URL connectingTo;

	/////////////////

	String Filename = "webPage.html";

	JMenu option;

	JMenuItem option1, option2;

	public void Design() {
		JPanel options = new JPanel();

		options.setLayout(null);

		options.setBounds(4, 240, 484, 110);

		options.setBackground(Color.black);

		JMenuBar bar = new JMenuBar();

		bar.setBounds(4, 4, 484, 50);

		bar.setBackground(Color.black);

		option = new JMenu("Options!");

		option.setForeground(Color.white);

		option1 = new JMenuItem("a Connection");

		option1.setBackground(Color.black);

		option1.addActionListener(this);

		option1.setForeground(Color.white);

		option2 = new JMenuItem("Make a Web Page !");

		option2.setForeground(Color.white);

		option2.setBackground(Color.black);

		option2.addActionListener(this);

		option.add(option1);

		option.add(option2);

		bar.add(option);

		options.add(bar);

		component = new JFrame("URLProgram...!");

		component.setSize(500, 388);

		component.setLayout(null);

		JPanel centerPanel = new JPanel();

		centerPanel.setLayout(null);

		JPanel southPanel = new JPanel();

		southPanel.setLayout(null);

		centerPanel.setBackground(Color.black);

		southPanel.setBackground(Color.black);

		///////////////// For example

		textField = new JTextField("http://www.google.com");

		////////////////////////////////////////////////////

		textArea = new JTextArea();

		textArea.setBounds(5, 5, 475, 189);

		textArea.setBackground(Color.white);

		JScrollPane scrollPane = new JScrollPane(textArea);

		scrollPane.setBounds(5, 5, 475, 189);

		centerPanel.add(scrollPane);

		JLabel message = new JLabel("Insert a URL : ");

		message.setForeground(Color.white);

		Font fontType = new Font("Times new Roman", Font.PLAIN, 13);

		message.setFont(fontType);

		message.setBounds(53, 20, 180, 20);

		southPanel.add(message);

		textField.setBounds(133, 20, 180, 20);

		southPanel.add(textField);

		connect = new JButton("Connect");

		connect.setBounds(323, 20, 100, 20);

		connect.addActionListener(this);

		makeaWebPage = new JButton("web Page");

		makeaWebPage.setBounds(323, 20, 100, 20);

		makeaWebPage.addActionListener(this);

		southPanel.add(connect);

		southPanel.add(makeaWebPage);

		Container container = component.getContentPane();

		centerPanel.setBounds(4, 4, 484, 200);

		container.add(centerPanel);

		southPanel.setBounds(4, 200, 484, 58);

		container.add(southPanel);

		container.add(options);

		component.setLocationRelativeTo(null);

		connect.setVisible(false);

		makeaWebPage.setVisible(false);

		component.setVisible(true);

		//////////////////////////////////////////
	}

	public void actionPerformed(ActionEvent r) {
		String press = r.getActionCommand();

		if (press.equals("Connect")) {

			try {

				String url = textField.getText();

				connectingTo = new URL(url);

				/////////////////////////////////////////////// Threads

				Runnable run = new Runnable() {

					public void run() {

						waiting = new JDialog(component, "  Connecting to URL...", false);

						JPanel panel = new JPanel();

						panel.setBackground(Color.white);

						JLabel message = new JLabel("  Loading the code");

						panel.add(message);

						waiting.add(panel, BorderLayout.CENTER);

						waiting.setSize(365, 65);

						waiting.setLocationRelativeTo(null);

						waiting.setVisible(true);

					}

				};

				Thread wait = new Thread(run, "waiting");

				wait.start();

				////////////////////////////////////////////

				Runnable run2 = new Runnable() {
					public void run() {
						try {

							Thread.sleep(3000);

						} catch (InterruptedException s) {
						}

						System.out.println(textField.getText());

						waiting.setVisible(false);

						////////////////////////////////////////////////////////////////

						try {

							DataInputStream in = new DataInputStream(connectingTo.openStream());

							String inputLine;

							while ((inputLine = in.readLine()) != null) {
								textArea.append(inputLine + "\n");
							}

						} catch (IOException c) {
						}

						////////////////////////////////////////////////////////

					}

				};

				Thread nowContinue = new Thread(run2, "newContinue");

				nowContinue.start();

				////////////////////////////////////////////

				URLConnection urlConnection = connectingTo.openConnection();

				HttpURLConnection connection = null;

				if (urlConnection instanceof HttpURLConnection) {
					connection = (HttpURLConnection) urlConnection;
				}

				else {
					JOptionPane.showMessageDialog(component,

							"Eggs are not supposed to be green.",

							"Nots Instance",

							JOptionPane.ERROR_MESSAGE);
				}

			} catch (MalformedURLException e) {
				JOptionPane.showMessageDialog(component,

						"Incorrect URL, please try again !",

						"URL Exception",

						JOptionPane.ERROR_MESSAGE);
			}

			catch (IOException d) {
			}

		}

		else if (press.equals("a Connection")) {
			makeaWebPage.setVisible(false);

			connect.setVisible(true);
		}

		else if (press.equals("Make a Web Page !")) {
			connect.setVisible(false);

			makeaWebPage.setVisible(true);
		}

		else if (press.equals("web Page")) {

			/////////////////////////////////// Threads

			Runnable run = new Runnable() {

				public void run() {

					waiting = new JDialog(component, "  Connecting to URL...", false);

					JPanel panel = new JPanel();

					panel.setBackground(Color.white);

					JLabel message = new JLabel("      Creating the page in process");

					panel.add(message);

					waiting.add(panel, BorderLayout.CENTER);

					waiting.setSize(440, 65);

					waiting.setLocationRelativeTo(null);

					waiting.setVisible(true);

				}

			};

			Thread wait = new Thread(run, "waiting");

			wait.start();

			////////////////////////////////////////////

			Runnable run2 = new Runnable() {
				public void run() {
					try {

						Thread.sleep(3000);

					} catch (InterruptedException s) {
					}

					waiting.setVisible(false);

					//////////////////////////////////////////////////////////////

					try {

						ObjectOutput escribir = new ObjectOutputStream(new FileOutputStream(Filename));

						escribir.writeObject(textArea.getText());

					} catch (Exception s) {
					}

					/////////////////////////////////////////////////////////////

				}

			};

			Thread nowContinue = new Thread(run2, "newContinue");

			nowContinue.start();

		}
	}

	/////////////////////////////////////////////////////////

	public static void main(String[] args) {
		URLProgram Make = new URLProgram();

		Make.Design();
	}
}