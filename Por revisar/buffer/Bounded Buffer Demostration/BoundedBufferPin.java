/*
@author  j.n.magee 14/11/96
*/

/* @author: Jeff Magee
 *  BoundedBuffer.java
 * 
 * Modificado y Adaptado 
 *  por Prof. Álvaro Pino N.
 *  BoundedBufferPin.java
 * Fecha: 19/09/2021
*/

//package concurrency.buffer;

import java.awt.*;
import java.applet.*;

import javax.swing.*;
import java.awt.event.*;

/* import concurrency.display.*;



/****************************APPLET**************************/

public class BoundedBufferPin extends Applet {

private static final long serialVersionUID = 1L;

    ThreadPanel prod;
    ThreadPanel cons;
    BufferCanvas buffDisplay;

    public void init() {
        super.init();
        // Set up Display
        prod = new ThreadPanel("Producer",Color.blue);
        cons = new ThreadPanel("Consumer",Color.yellow);
        buffDisplay =  new BufferCanvas("Buffer",5);
        GridBagLayout gridbag = new GridBagLayout();
        setLayout(gridbag);
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.NORTH;
        gridbag.setConstraints(buffDisplay, gc);
        gridbag.setConstraints(prod, gc);
        gridbag.setConstraints(cons, gc);
        add(prod);
        add(buffDisplay);
        add(cons);
        /* inicio el Applet */
         
        Buffer b = new DisplayBuffer(buffDisplay,5);
        // Create Thread
        prod.start(new Producer(b));
        cons.start(new Consumer(b));
        
    }

    public void start() {
        Buffer b = new DisplayBuffer(buffDisplay,5);
        // Create Thread
        prod.start(new Producer(b));
        cons.start(new Consumer(b));
    }


    public void stop() {
        prod.stop();
        cons.stop();
    }
    
    public static void main(String [] args)
{
	BoundedBufferPin applet = new BoundedBufferPin();
	
	JFrame  frame = new  JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Bounde Buffer demostration");
	Color fondo =  new Color(0,192,255);
	applet.setBackground(fondo);
	frame.getContentPane().add(applet, BorderLayout.CENTER);
	applet.init();
	frame.setSize(600,400);
	frame.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	frame.setVisible(true);
}

    
}

/**************************************************************/

class DisplayBuffer extends BufferImpl {
    BufferCanvas disp_;

    DisplayBuffer(BufferCanvas disp,int size) {
        super(size);
        disp_ = disp;
    }

    private void display() {
        char[] tmp = new char[size];
        for (int i=0; i<size ; i++) {
            if (buf[i] != null)
                tmp[i] = ((Character)buf[i]).charValue();
            else
                tmp[i] = ' ';
        }
        disp_.setvalue(tmp,in,out);
    }

    synchronized public void put(Object o) throws InterruptedException {
        super.put(o);
        display();
        Thread.sleep(400);
    }

    synchronized public Object get() throws InterruptedException {
        Object o = super.get();
        display();
        return (o);
    }
    
     
 }

