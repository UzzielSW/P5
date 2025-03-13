public class Buffer {
    private static final int BUFFER_SIZE = 5;
    private int cant; // items en el buffer
    private int in; // Proximo libre
    private int out; // Proximo lleno
    private Object[] buffer;

    public Buffer() {
        cant = 0; // Comienza Vacio
        in = 0;
        out = 0;
        buffer = new Object[BUFFER_SIZE];
    }

    public synchronized void poner(Object item) {
        while (cant == BUFFER_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        ++cant; // Agrega al buffer
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        // El propósito de la línea anterior (in = (in + 1) % BUFFER_SIZE) es:
        // 1. Avanzar el índice 'in' al siguiente espacio disponible en el buffer.
        // 2. Mantener 'in' dentro de los límites del buffer (comportamiento circular).
        //
        // Funcionamiento:
        // - La operación módulo hace que 'in' vuelva a 0 cuando alcance BUFFER_SIZE.
        // - Esto crea un buffer circular o anillo.
        //
        // Ventajas de este enfoque:
        // - Evita mover elementos en el buffer.
        // - Utiliza eficientemente todo el espacio del buffer.
        // - Simplifica la lógica para agregar y quitar elementos.
        if (cant == BUFFER_SIZE)
            System.out.println("Entro " + item + " Buffer LLENO");
        else
            System.out.println("Entro  " + item + " Buffer Size = " + cant);

        notify(); // despierta algun consumidor
    }

    public synchronized Object sacar() {
        Object item;
        while (cant == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        --cant;
        item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        if (cant == 0)
            System.out.println("Salio " + item + " Buffer VACIO");
        else
            System.out.println("Salio " + item + " Buffer Size = " + cant);
        notify();

        return item;
    }
}