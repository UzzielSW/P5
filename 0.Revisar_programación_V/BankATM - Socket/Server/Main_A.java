import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.*;
import java.util.*;

/*
 * Esta clase genera las acciones de relasion entre el grafico y el sql solo de la interfas addcustomer
 * */
public class Main_A implements Serializable {
  public static String nombre = null;
  public static String apellido = null;
  private Customer cust, cli;
  private LinkedList lista;
  LinkedList<Customer> lits;
  public Archivo archivo;

  private Object[][] data;

  private int a = 0, i, l;
  /*
   * Esta clase genera las acciones de relasion entre el grafico y el sql solo de
   * la interfas addcustomer
   * 
   */

  public Main_A() {
    lista = new LinkedList();
  }

  public String add_client(long pass, String nombre, String apellido, String tipocuenta, double apertura) {
    cust = new Customer();

    try {
      cust.setFirstName(nombre);
      cust.setLastName(apellido);
      cust.setIdCustomer(pass);
      cust.setTCuenta(tipocuenta);
      Account acct = new Account(apertura);
      cust.setAccount(acct);
      lista.add(a, cust);
      a++;
      Archivo archivo = new Archivo();
      archivo.Escritura(lista);
      nombre = nombre;
      apellido = apellido;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return "" + nombre;
  }

  public synchronized void Archivos(LinkedList lista) {
    this.lista = lista;
    archivo = new Archivo();
    try {
      a = archivo.sizeLista();

    } catch (Exception i) {
      i.printStackTrace();
    }
  }

  public LinkedList get_lista() {
    return lista;
  }

  public Customer getCustomer(int ID) {
    Customer cust1 = (Customer) lista.get(ID);
    return (cust1);
  }

  public int valor() {
    System.out.println(a);
    return a;
  }

  /*
   * Metodo encargado de actualizar la cuenta del cliente.
   */
  public String update_client(String pass, String nombre, String apellido) {
    long passvalor;
    try {

      Archivos(get_lista());

      for (i = 0; i <= valor(); i++) {
        System.out.println("" + nombre + "" + pass);
        passvalor = getCustomer(i).getIdCustomer();
        System.out.println("" + passvalor);
        if (Long.parseLong(pass) == passvalor) {
          System.out.println("" + nombre + "" + apellido);
          getCustomer(i).setFirstName(nombre);
          getCustomer(i).setLastName(apellido);
          archivo.Escritura(get_lista());
          break;
        }

      }
    } catch (Exception t) {
      System.out.println(t.getMessage());
    }
    return "" + nombre;
  }

  public Object[][] Create_Data() {

    Archivo archivo = new Archivo();
    Archivos(archivo.Lectura());
    lits = lista;

    data = new Object[a][1];
    System.out.println("" + a);
    String h, g;

    for (int i = 0; i < lits.size(); i++) {
      // Incorporacion de datos llamados de las lista

      String[] customerData = new String[5];
      Customer cli = lits.get(i);
      customerData[0] = cli.getFirstName();
      customerData[1] = cli.getLastName();
      customerData[2] = "" + cli.getIdCustomer();
      customerData[3] = "" + cli.getAccount().getBalance();
      customerData[4] = "" + cli.getTCuenta();

      data[i] = customerData;
    }

    return data;
  }
}
