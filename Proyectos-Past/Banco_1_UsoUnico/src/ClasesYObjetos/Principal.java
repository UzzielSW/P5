package ClasesYObjetos;

public class Principal {

    public static void main(String[] args) {
        BaseCuentas base = new BaseCuentas();
        VentanaInicio ventanaU = new VentanaInicio(base);
        ventanaU.setVisible(true);
    }
}
