
/*
@author  j.n.magee 14/11/96
*/
//package concurrency.buffer;

/*
 * NestedMonitor.java
 *@author  j.n.magee 20/04/98
*
* Modificado por Prof. Álvaro Pino N.
 * Fecha: 19/09/2021
*/
import java.awt.*;
import java.applet.*;

import javax.swing.*;
import java.awt.event.*;

//import concurrency.display.*;
//import concurrency.semaphore.*;

/*********************SEMABUFFER*****************************/

class SemaBuffer implements Buffer {
	
  protected Object[] buf;
  protected int in = 0;
  protected int out= 0;
  protected int count= 0;
  protected int size;

  Semaphore full; //counts number of items
  Semaphore empty;//counts number of spaces

  SemaBuffer(int size) {
    this.size = size; buf = new Object[size];
    full = new Semaphore(0);
    empty= new Semaphore(size);
  }

  synchronized public void put(Object o)
              throws InterruptedException {
    empty.down();
    buf[in] = o;
    ++count;
    in=(in+1) % size;
    full.up();
  }

  synchronized public Object get()
               throws InterruptedException{
    full.down();
    Object o =buf[out];
    buf[out]=null;
    --count;
    out=(out+1) % size;
    empty.up();
    return (o);
  }
}


public class NestedMonitor extends BoundedBufferPin {

/* Agregado por Prof. Álvaro Pino N. */
	 
	private static final long serialVersionUID = 1L;

    public void start() {
        Buffer b = new DisplaySemaBuffer(buffDisplay,5);
        // Create Thread
        prod.start(new Producer(b));
        cons.start(new Consumer(b));
    }
    
      public static void main(String [] args)
{
	NestedMonitor applet = new NestedMonitor();
	
	JFrame  frame = new  JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("NestedMonitor");
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

class DisplaySemaBuffer extends SemaBuffer {
    BufferCanvas disp_;

    DisplaySemaBuffer(BufferCanvas disp,int size) {
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

    synchronized public Object get() throws InterruptedException{
        Object o = super.get();
        display();
        return (o);
    }

 }

