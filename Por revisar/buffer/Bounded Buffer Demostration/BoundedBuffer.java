/*
@author  j.n.magee 14/11/96
*/
//package concurrency.buffer;

import java.awt.*;
import java.applet.*;
/* import concurrency.display.*;



/****************************APPLET**************************/

public class BoundedBuffer extends Applet {

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

