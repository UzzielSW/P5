
import java.io.Serializable;
import java.util.ArrayList;


public class Factura implements Serializable{
    private double total;
    ArrayList<Pedido> Pedidos;
    String mensaje;

    public Factura() {
        this.total = 0.00;
        this.Pedidos = new ArrayList<>();
        this.mensaje = "";
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Pedido> getPedidos() {
        return Pedidos;
    }

    public void setPedidos(Pedido Pedidos) {
        this.Pedidos.add(Pedidos);
    }

    @Override
    public String toString() {
        return "Factura{" + "total=" + total + ", Pedidos=" + Pedidos + '}';
    }
    
    public void calcularFactura(){
        this.Pedidos.forEach((t) -> {
            this.total += t.getTotal();
        });
        
        mensaje = "\nTotal: $" + this.total + "\n\n¡Gracias por su compra!";
    }
    
}
