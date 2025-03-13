
// Inet.java
import java.net.*;

public class Demoinet {
  public static void main(String as[]) throws Exception {
    InetAddress net = InetAddress.getLocalHost();
    System.out.println("InetAddress: " + net);
    InetAddress net1 = InetAddress.getByName("www.mu.edu.et");
    System.out.println(net1);
    InetAddress net2[] = InetAddress.getAllByName("www.google.com");
    for (int i = 0; i < net2.length; i++)
      System.out.println(net2[i]);
  }
}
