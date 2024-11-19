/* FixedNestedMonitor.java
@author  j.n.magee 14/11/96
*/
/*
 Modificado por Prof. Álvaro Pino N.
 * Fecha: 19/09/2021
*/
//package concurrency.buffer;

import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

//import concurrency.semaphore.*;

/*********************SEMABUFFER*****************************/

class FixedSemaBuffer implements Buffer {
  protected Object[] buf;
  protected int in = 0;
  protected int out= 0;
  protected int count= 0; //only used for display purposes
  protected int size;

  Semaphore full;  //counts number of items
  Semaphore empty; //counts number of spaces

  FixedSemaBuffer(int size) {
    this.size = size; buf = new Object[size];
    full = new Semaphore(0);
    empty= new Semaphore(size);
  }

  public void put(Object o)
              throws InterruptedException {
    empty.down();
    synchronized(this){
      buf[in] = o; ++count; in=(in+1)%size;
    }
    full.up();
  }

  public Object get()
               throws InterruptedException{
    full.down(); Object o;
    synchronized(this){
      o =buf[out]; buf[out]=null; --count; out=(out+1)%size;
    }
    empty.up();
    return (o);
  }
}



public class FixedNestedMonitor extends BoundedBufferPin {


    public void init() {
    	super.init();
        Buffer b = new DisplayFixedSemaBuffer(buffDisplay,5);
        // Create Thread
        prod.start(new Producer(b));
        cons.start(new Consumer(b));
    }
    
    
 public static void main(String [] args)
{
	FixedNestedMonitor applet = new FixedNestedMonitor();
	
	JFrame  frame = new  JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Fixed Nested  Monitor demostration");
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

class DisplayFixedSemaBuffer extends FixedSemaBuffer {
    BufferCanvas disp_;

    DisplayFixedSemaBuffer(BufferCanvas disp,int size) {
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

    public void put(Object o) throws InterruptedException {
        super.put(o);
        synchronized(this){
            display();
            Thread.sleep(400);
        }
    }

    public Object get() throws InterruptedException{
        Object o = super.get();
        synchronized (this){
            display();
        }
        return (o);
    }

 }

