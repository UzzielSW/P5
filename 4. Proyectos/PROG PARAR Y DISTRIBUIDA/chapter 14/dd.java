// dd.java
class DD implements Runnable {
    Thread t;
    String name, data;

    DD(String name1, String dd) {
        name = name1;
        data = dd;
        t = new Thread(this, name);
        System.out.println(name + " : " + t);
        t.start();
    }

    synchronized public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + " " + data + ":" + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(name + ":  thread interrupted");
        }
        System.out.println("Exit " + name + " Thread");
    }
}

class B {
    public static void main(String BDP[]) {
        String d = "BALA DHANDAYUTHAPANI"; // data dependancy
        new DD("one", d);
        new DD("two", d);
        new DD("three", d);
        new DD("four", d);
    }
}
