/*
 * WriteReadCollections.java
 *
 * Created on 10 de diciembre de 2007, 03:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.*;
//import java.util.Arrays;
//import java.util.Enumeration;

/**
 *
 * @author Carlos Quiros (QuiroSan) modificado por Prof. Alvaro Pino N. para
 * almacenar y recuperar una lista enlazada
 */
public class WriteReadCollections2 {

    private static LinkedList lista = new LinkedList();

    public static void main(String[] args) throws Exception {
        // Crea la Lista  y la salva en un archivo COQS.PIN

        LinkedList l = new LinkedList();

        String[] arreglo = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        int j = 0;
        while (j < arreglo.length) {
            l.add(arreglo[j++]);
        }

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("COQS.PIN"));
        out.writeObject(l);

        // Lee el archivo COQS.PIN, crea el vector y se imprime la data
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("COQS.PIN")));

        LinkedList l2 = new LinkedList();

        l2 = (LinkedList) in.readObject();
        lista = l2;

        Object[] otro = lista.toArray();

        System.out.println("hay: " + otro.length);

        int i = 0;
        while (i < otro.length) {
            System.out.println("[" + otro[i].toString() + "] ");
            i++;
        }

    }
}
