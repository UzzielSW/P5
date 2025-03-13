class SingleThread {
    public static void main(String [] BDP) {
        // main() is run in a single thread
        System.out.println(Thread.currentThread());
        for (int i=0; i<50; i++) {
            System.out.print("i == " + i);        
            } 
    }
 }
