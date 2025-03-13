/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hellosession;

import com.HelloSession.ejb.EchoRemote;
import javax.ejb.EJB;

/**
 *
 * @author BALA
 */
public class Main {
    @EJB
    private static EchoRemote echo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println(echo.Echo("BALA DHANDAYUTHAPANI VEERASAMY"));

    }

}
