
public class Caja {

    private int cantCajas = 0;
    private int cantPapelCaja = 0;

    private int cajasActuales = 0;
    private int papelActual = 0;

    public void setCajas(int cajas) {
        this.cantCajas = cajas;
    }

    public int getCantCajas() {
        return cantCajas;
    }

    public void setCajasActuales(int cajasActuales) {
        this.cajasActuales = cajasActuales;
    }

    public int getcajasLlenas() {
        return cajasActuales;
    }

    public void setPapelCaja(int papelCaja) {
        this.cantPapelCaja = papelCaja;
    }

    public int getPapelXcaja() {
        return cantPapelCaja;
    }

    public void setPapelActual(int papelActual) {
        this.papelActual = papelActual;
    }

    public int getPapelActual() {
        return papelActual;
    }

}
