/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.simplejpa;

import com.SimpleJPA.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author BALA
 */
import java.io.DataInputStream;
import java.io.IOException;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
         Address a = new Address();
    DataInputStream d=new DataInputStream(System.in);
    String name,place;
    System.out.println("Enter the Name: ");name=d.readLine();
    System.out.println("Enter the Place: ");place=d.readLine();
    a.setName(name);
    a.setPlace(place);
    Main demo = new Main();
    demo.persist(a);

    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
