import java.util.LinkedList;

class HiloBuscadorDesdePrincipio extends Thread {
  LinkedList datos;
  public int dato_buscado;
  public boolean finalizo_con_exito = false;

  public HiloBuscadorDesdePrincipio(int dato, LinkedList datos) {
    dato_buscado = dato;
    this.datos = datos;
  }

  public void run() {
    int i;
    for (i = 0; i < datos.size(); i++) {
      if (datos.get(i) == dato_buscado) {
        System.out.println("==> PRINCIPIO:" + dato_buscado + " ENCONTRADO EN " + i);
        // finalizo_con_exito = true;
        return;
      }
      if (i == (datos.size() / 2))
        System.out.println("==> Principio:!!!FALLO,No se Encontro Nada");
    }
  }
}