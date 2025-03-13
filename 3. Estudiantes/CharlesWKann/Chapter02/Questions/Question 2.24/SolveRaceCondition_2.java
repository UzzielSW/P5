//
//    Program Name:     SolveRaceConditon_2.java
//    Purpose:          This program solves a race condition using a
//                      syncrhonized method.
//  
// (C) Copyright 2002 Charles Kann
//  All Rights Reserved.

class SwapInt {
    private int tmp;

    synchronized public void swap(SolveRaceCondition_2 s) {
	tmp = s.val1;
	s.val1 = s.val2;
        try {
            // Thread.yield();
            // Thread.sleep(1000);
            // Thread.notify();
            // Thread.notifyAll();
            // wait();
            // wait(1000);
            // wait(1);
            // wait(0);
        } catch (Exception e) {
             e.printStackTrace();
        }
	s.val2 = tmp;
    }
}

public class SolveRaceCondition_2 implements Runnable{
    int val1, val2;
    static SwapInt so = new SwapInt();

    public SolveRaceCondition_2(int i1, int i2){
	val1 = i1; val2 = i2;
    }

    public void run() {
      so.swap(this);
	System.out.println("Val1 = " + val1 + " Val2 = " + val2);
    }

    public static void main(String args[]) {
	
      (new Thread(new SolveRaceCondition_2(4,7))).start();
      (new Thread(new SolveRaceCondition_2(2,5))).start();
    }
}

