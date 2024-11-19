
public class BufferTest {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Productor p1 = new Productor(buffer, 1);
        Consumidor c1 = new Consumidor(buffer, 1);
        p1.start();
        c1.start();
    }
}
