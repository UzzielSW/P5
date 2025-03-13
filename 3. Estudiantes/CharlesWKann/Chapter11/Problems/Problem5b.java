public class Problem5b implements Runnable {
    SwapObject swapObject;

    public Problem5b(SwapObject swapObject) {
        this.swapObject = (SwapObject)swapObject.clone();
    }

    public void run() {
        swapObject.swap();
        System.out.println(swapObject.toString());
    }

    public static void main(String args[]) {
        SwapObject swapObject = new SwapObject(5,7);
        (new Thread(new Problem5b(swapObject))).start();

        try {
            Thread.sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) {
        }
        swapObject.temp = 22;
    }
}

class SwapObject implements Cloneable{
    int val1, val2, temp;

    public SwapObject(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Invalid Cloning Operation");
        }
        return o;
    }

    public void swap() {
        temp = val1;
        try {
            Thread.sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) {
        }
        val1 = val2;
        val2 = temp;
    }

    public String toString() {
        return ("val1 = " + val1 + " val2 = " + val2);
    }
}
