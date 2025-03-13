import java.*;
import java.io.*;

public class Clrscr {

public void clrscr()  {

String str;

Runtime comando = Runtime.getRuntime();

Process pro =null;


try {

   String cadena = "clear";

   pro = comando.exec(cadena);

  // DataInputStream string_exit = new  DataIputStream( pro.getInputStream());

BufferedReader string_exit = new BufferedReader( new InputStreamReader (pro.getInputStream()) );


   try {
      while (( str = string_exit.readLine()) != null ) {

          System.out.println("\n" + str);
       }
    } catch(IOException e) {

          System.exit(0);
      }

} catch ( Exception d) {

        System.out.println("Error en ");

        }

return;

  }

}

