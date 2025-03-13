import java.util.LinkedList;
import java.util.Random;

public class BusquedaLinealBidimensional {
  public static void main(String[] args) {
    LinkedList vec;
    int rand;
    Random generador = new Random();
    vec = new LinkedList();
    for (int i = 0; i < 20; i++) {
      rand = generador.nextInt(99) + 1;
      vec.add(rand);
    }
    Thread run_buscador1 = new Thread(new HiloBuscadorDesdePrincipio(8, vec));
    // Thread hilo2=new Thread(new HiloBuscadorDesdeFinal(8,vec));
    run_buscador1.start();
    // hilo2.start();
  }
}