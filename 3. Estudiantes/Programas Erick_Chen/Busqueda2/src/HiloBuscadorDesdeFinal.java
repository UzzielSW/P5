import java.util.LinkedList;

class HiloBuscadorDesdeFinal extends Thread {
  LinkedList datos;
  public int dato_buscado;
  public boolean finalizo_con_exito = false;

  public HiloBuscadorDesdeFinal(int dato, LinkedList datos) {
    dato_buscado = dato;
    this.datos = datos;
  }

  public void run() {
    int i;
    for (i = datos.size() - 1; i > (datos.size() / 2); i--) {
      if (dato_buscado == datos.get(i)) {
        System.out.println("==>FINAL:" + dato_buscado + " ENCONTRADO EN " + i);
        // finalizo_con_exito = true;
        return;
      }
    }
    if (i == (datos.size() / 2))
      System.out.println("==> Final Fallo,No se Encontro Nada");
  }
}
