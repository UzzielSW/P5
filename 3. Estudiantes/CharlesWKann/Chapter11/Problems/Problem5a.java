public class Problem5a implements Runnable {
    SwapObject swapObject;

    public Problem5a(SwapObject swapObject) {
        this.swapObject = swapObject;
    }

    public void run() {
        swapObject.swap();
        System.out.println(swapObject.toString());
    }

    public static void main(String args[]) {
        SwapObject swapObject = new SwapObject(5, 7);
        (new Thread(new Problem5a(swapObject))).start();

        try {
            Thread.sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) {
        }
        swapObject.temp = 22;
    }
}

class SwapObject {
    int val1, val2, temp;

    public SwapObject(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
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
