import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class servidor extends JFrame {

  private static final long serialVersionUID = 1L;
  final int PUERTO = 3000;
  private InputStream aux;
  private DataInputStream read;
  private OutputStream Client_aux;
  private DataOutputStream Client_envio;
  private ObjectOutputStream oos;
  private JTextArea pantalla = new JTextArea();
  private JScrollPane pantalascr = new JScrollPane(pantalla);
  public Main_B Main_B;
  public Main_A Main_A;

  public servidor() {
    super("BankATM");
    Main_B = new Main_B();
    Main_A = new Main_A();

    try {
      pantalla.setBackground(Color.BLACK);
      pantalla.setForeground(Color.WHITE);
      pantalla.setEditable(false);
      pantalla.setEnabled(false);
      this.add(pantalascr);
      this.setSize(400, 200);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.setVisible(true);

      ServerSocket SerClient = new ServerSocket(PUERTO);
      pantalla.setText("\n Screen Activities");
      Socket Client;
      while (true) {
        Client = SerClient.accept();

        pantalla.setText(pantalla.getText() + "\nAccion Client: " + Client);

        aux = Client.getInputStream();
        read = new DataInputStream(aux);
        String tem = read.readUTF();

        if (tem.compareTo("search") == 0) {
          search(Client);
        } else if (tem.compareTo("balance") == 0) {
          balance(Client);
        } else if (tem.compareTo("deposit") == 0) {
          deposit(Client);
        } else if (tem.compareTo("withdraw") == 0) {
          withdraw(Client);
        } else if (tem.compareTo("client_info") == 0) {
          client_info(Client);
        } else if (tem.compareTo("add_client") == 0) {
          add_client(Client);
        } else if (tem.compareTo("update_client") == 0) {
          update_client(Client);
        } else if (tem.compareTo("view_accounts") == 0) {
          view_accounts(Client);
        }

        Client.close();
      }
    } catch (Exception e) {
      pantalla.setText(e.getMessage());
    }
  }

  public void view_accounts(Socket Client) {
    try {
      Client_aux = Client.getOutputStream();
      oos = new ObjectOutputStream(Client_aux);
      oos.writeObject(Main_A.Create_Data());
      pantalla.setText(pantalla.getText() + "\nActivity: Display Accounts");
    } catch (Exception e) {
      pantalla.setText(e.getMessage());
    }
  }

  private void update_client(Socket Client) {
    try {
      String infoclient[] = new String[3];
      for (int i = 0; i < 3; i++) {
        aux = Client.getInputStream();
        read = new DataInputStream(aux);
        infoclient[i] = read.readUTF();
        System.out.println("" + infoclient[i]);
      }
      Client_aux = Client.getOutputStream();
      Client_envio = new DataOutputStream(Client_aux);
      Client_envio.writeUTF("" + Main_A.update_client(infoclient[0], infoclient[1], infoclient[2]));
      pantalla.setText(pantalla.getText() + "\nActivity: "
          + Main_A.update_client(infoclient[0], infoclient[1], infoclient[2]) + " Change info");
    } catch (Exception e) {
      pantalla.setText(e.getMessage());
    }
  }

  private void add_client(Socket Client) {
    try {
      String infoclient[] = new String[5];
      for (int i = 0; i < 5; i++) {
        aux = Client.getInputStream();
        read = new DataInputStream(aux);
        infoclient[i] = read.readUTF();
      }
      Client_aux = Client.getOutputStream();
      Client_envio = new DataOutputStream(Client_aux);
      Client_envio.writeUTF("" + Main_A.add_client(Long.parseLong(infoclient[0]), infoclient[1], infoclient[2],
          infoclient[3], Double.parseDouble(infoclient[4])));
      pantalla.setText(pantalla.getText() + "\nActivity: Create new Account");
    } catch (Exception e) {
      pantalla.setText(e.getMessage());
    }
  }

  public static void main(String[] args) {
    new servidor();
  }

  public void search(Socket Client) {
    try {
      aux = Client.getInputStream();
      read = new DataInputStream(aux);
      Client_aux = Client.getOutputStream();
      Client_envio = new DataOutputStream(Client_aux);
      Client_envio.writeUTF("" + Main_B.search(read.readUTF()));
      pantalla.setText(pantalla.getText() + "\nActivity: " + Main_B.client_info() + " are login");
    } catch (Exception e) {
      pantalla.setText(e.getMessage());
    }
  }

  private void balance(Socket Client) {
    try {
      aux = Client.getInputStream();
      read = new DataInputStream(aux);

      Client_aux = Client.getOutputStream();
      Client_envio = new DataOutputStream(Client_aux);
      Client_envio.writeUTF("" + Main_B.balance(read.readUTF()));

    } catch (Exception e) {
      pantalla.setText(e.getMessage());
    }
  }

  private void deposit(Socket Client) {
    try {
      aux = Client.getInputStream();
      read = new DataInputStream(aux);
      String tem = read.readUTF();

      aux = Client.getInputStream();
      read = new DataInputStream(aux);
      String tem1 = read.readUTF();

      Client_aux = Client.getOutputStream();
      Client_envio = new DataOutputStream(Client_aux);
      Client_envio.writeUTF("" + Main_B.deposit(Double.parseDouble(tem), tem1));

    } catch (Exception e) {
      pantalla.setText(e.getMessage());
    }
  }

  private void withdraw(Socket Client) {
    try {
      aux = Client.getInputStream();
      read = new DataInputStream(aux);
      String tem = read.readUTF();

      aux = Client.getInputStream();
      read = new DataInputStream(aux);
      String tem1 = read.readUTF();

      Client_aux = Client.getOutputStream();
      Client_envio = new DataOutputStream(Client_aux);
      Client_envio.writeUTF("" + Main_B.withdraw(Double.parseDouble(tem), tem1));
    } catch (Exception e) {
      pantalla.setText(e.getMessage());
    }
  }

  private void client_info(Socket Client) {
    try {
      Client_aux = Client.getOutputStream();
      Client_envio = new DataOutputStream(Client_aux);
      Client_envio.writeUTF("" + Main_B.client_info());
    } catch (Exception e) {
      pantalla.setText(e.getMessage());
    }
  }
}
