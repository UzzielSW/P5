class Buffer {
      private int capacidad = 10;
      private int pila[] = new int[capacidad];
      private int puntero = -1;
      private boolean estaLleno = false;
      private boolean estaVacio = true;
      private String texto="";

      public synchronized int lee() {
             while(estaVacio)       {
                     try {
                             wait();
                     } catch (InterruptedException e) {}
             }

             int num = pila[puntero];
             pila[puntero]=0;
             puntero--;

             if (puntero < 0)
             	estaVacio = true;
             estaLleno = false;
             texto="";

             for (int i=0;i < capacidad;i++)
             	    texto=texto+" "+pila[i];

             BufferFrame.textbuf.setText(texto);
             notify();
             return num;
      }

      public synchronized void escribe(int num) {

             while(estaLleno) {
                     try {
                             wait();
                     } catch (InterruptedException e) {}
             }

             puntero++;
             pila[puntero]=num;

             if (puntero == capacidad-1)
             	 estaLleno = true;
             estaVacio = false;
             texto="";

             for (int i=0;i < capacidad;i++)
             	texto=texto+" "+pila[i];

             BufferFrame.textbuf.setText(texto);
             notify();
      }
}
