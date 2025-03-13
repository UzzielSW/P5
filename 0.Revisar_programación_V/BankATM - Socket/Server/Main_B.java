
public class Main_B {
  public String nombre = null;
  public String apellido = null;
  public static int pos = 0;
  public Archivo archivo;
  private int m = 0, i, l = 0;
  private Main_A Main_A;
  private long clave, claveid;

  /*
   * Metodo verifica que pass exista si exsiste establece el pass como elemento
   * fijo para su utilizasion en las metodos posteriores.
   */

  public Main_B() {
    Main_A = new Main_A();
    archivo = new Archivo();
  }

  public synchronized String search(String NCuenta) {
    String R = "0";
    try {

      Main_A.Archivos(archivo.Lectura());

      if (m == 0)/** if Para que solo lea el archivo una vez */
      {
        try {
          Main_A.Archivos(archivo.Lectura());/**
                                              * Se llama al metodo Archivo de la clase Usuario2 para montar la lista que
                                              * esta en el archivo en la memoria
                                              */
          m = 1;
        } catch (RuntimeException i) {
          // Error de Lectura de Archivo cundo el archino haun no se a creado
        }
      }

      try {
        clave = Long.parseLong(NCuenta); // Captura de la clave introducida en pantalla
        l = Main_A.valor(); // Asignacion del tamaño de la lista a la variable l

        for (i = 0; i < l; i++) // recorrido de la lista
        {

          claveid = Main_A.getCustomer(i).getIdCustomer(); // Solicitando la clave del usuario i

          if (clave == claveid) // si coincide las claves, se accede a los botones de retirar, depositar y ver
                                // el balance
          {
            pos = i;
            nombre = Main_A.getCustomer(i).getFirstName();
            apellido = Main_A.getCustomer(i).getLastName();

            break;
          }

        }
      } catch (Exception t) {
        System.out.println(t.getMessage());
      }
    }

    catch (Exception t) {
      System.out.println(t.getMessage());
    }

    return R;
  }

  /*
   * Metodo encargado de enviar el balance a la pantalla.
   */
  public synchronized double balance(String pass) {
    double balance = 0;
    if (pass != null) {
      Main_A.Archivos(archivo.Lectura());
      try {
        balance = Main_A.getCustomer(pos).getAccount().getBalance();

      } catch (Exception t) {
        System.out.println(t.getMessage());
      }
    }
    return balance;
  }

  /*
   * Metodo encargado de haser los ingresos.
   */
  public synchronized String deposit(double dep, String pass) {
    double tes = 0;
    String arg = null;
    if (pass != null) {
      Main_A.Archivos(archivo.Lectura());
      try {
        l = Main_A.valor();

        for (i = 0; i <= l; i++) {
          String passvalor = toString().valueOf(Main_A.getCustomer(i).getIdCustomer());

          if (Integer.parseInt(pass) == Integer.parseInt(passvalor)) {
            Main_A.getCustomer(i).getAccount().deposit(dep);
            arg = toString().valueOf(Main_A.getCustomer(i).getAccount().getBalance());
            archivo.Escritura(Main_A.get_lista());
            break;
          }
        }
      } catch (Exception t) {
        System.out.println(t.getMessage());
      }
    }

    return arg;
  }

  /*
   * Metodo encaragaddo de haser los retiros.
   */
  public synchronized String withdraw(double dep, String pass) {
    double tes = 0;
    String arg = null;
    if (pass != null) {
      Main_A.Archivos(archivo.Lectura());
      try {
        l = Main_A.valor();

        for (i = 0; i <= l; i++) {
          String passvalor = toString().valueOf(Main_A.getCustomer(i).getIdCustomer());

          if (Integer.parseInt(pass) == Integer.parseInt(passvalor)) {
            try {
              Main_A.getCustomer(i).getAccount().withdraw(dep);
              arg = toString().valueOf(Main_A.getCustomer(i).getAccount().getBalance());
              archivo.Escritura(Main_A.get_lista());
            } catch (OverdraftException e3) {
              // jtfMsn.setText("Deficit: " +e3.getDeficit() + " " + e3.getMessage() + "Actual
              // balance: " + crea_usuario.getCustomer(pos).getAccount().getBalance() );
              arg = "no se puede";
            }

            break;
          }
        }
      } catch (Exception t) {
        System.out.println(t.getMessage());
      }
    }

    return arg;
  }

  public String client_info() {
    return nombre + " " + apellido;
  }
}
