/**
 * @(#)ExitListener.java
 *
 *
 * @author 
 * @version 1.00 2021/10/27
 */

import java.awt.event.*;
import java.net.*;
public class ExitListener extends WindowAdapter {

   ClientObjectTriangulo client;

   public ExitListener(ClientObjectTriangulo client) {
      this.client = client;
   }
      
   public void windowClosing(WindowEvent e) {
      client.disconnect();
     
   }
}
