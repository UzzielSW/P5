import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.io.*;

/** Clase que guarda y lee el archivo en el disco */
public class Archivo implements Serializable {
  /** Atributos de la clase Archivo */
  LinkedList lista = new LinkedList();
  Customer cust = new Customer();
  Create_User usuario2;

  /** Contrucutor de la Clase Archivo */
  public Archivo() {
    lista = new LinkedList();
    usuario2 = new Create_User();
  }

  /** Metodo que escribe el archivo en el disco */
  public void Escritura(LinkedList listas) {
    lista = listas;
    try {
      ObjectOutput out = new ObjectOutputStream(new FileOutputStream("Clientes.ATM"));
      out.writeObject(lista);
      out.close();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  /** Metodo que lee el archivo en el disco y lo retorna */
  public LinkedList Lectura() {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("Clientes.ATM")));
      lista = (LinkedList) in.readObject();
      in.close();
    } catch (IOException i) {
      i.printStackTrace();
    } catch (ClassNotFoundException c) {
      System.out.println("Employee class not found");
      c.printStackTrace();
    }

    return lista;
  }

  /** Metodo que retorna la cantidad de clientes en la lista guardada */
  public int sizeLista() {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("Clientes.ATM")));
      lista = (LinkedList) in.readObject();
      in.close();
    } catch (IOException i) {
      i.printStackTrace();
    } catch (ClassNotFoundException c) {
      System.out.println("Employee class not found");
      c.printStackTrace();
    }
    return (lista.size());
  }

  /** Void main de la clse */
  public static void main(String[] args) throws Exception {
    Archivo obj = new Archivo();
  }
}
