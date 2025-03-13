/*
 * Esta clase es la encargadda del manejo del nodo
 * @author David Rodríguez
 * */
public class ListaS {
    private static Nodo primero;
    private static Nodo ultimo;
    private static int tamano;
    public ListaS() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }
    /*
     * Metodo verifica que la lista se encuentra vacia.
     * */
    
    public boolean lisvasia() {
        return (this.primero == null);
    }
    /*Metodo agregar al final de la lista.
     * 
     */
    public ListaS addLast(int CC, String nombre, String apellido, int TC, double IoR) {
        if(lisvasia()) {
            Nodo nuevo = new Nodo(CC,nombre,apellido,TC,IoR);
            primero = nuevo;
            ultimo = nuevo;
            nuevo.nodoDer = nuevo;
        }
        else {
            Nodo nuevo = new Nodo(CC,nombre,apellido,TC,IoR);
            nuevo.nodoDer = null;
            ultimo.nodoDer = nuevo;
            ultimo = nuevo;
        }
        this.tamano++;
        return this;
    }
    
    public ListaS carga(int CC, String nombre, String apellido, double IoR1, double IoR) {
        int TC=1;
    	if(IoR<0){TC=0;   IoR=IoR1;}
    	if(lisvasia()) {
            Nodo nuevo = new Nodo(CC,nombre,apellido,TC,IoR);
            primero = nuevo;
            ultimo = nuevo;
            nuevo.nodoDer = nuevo;
        }
        else {
            Nodo nuevo = new Nodo(CC,nombre,apellido,TC,IoR);
            nuevo.nodoDer = null;
            ultimo.nodoDer = nuevo;
            ultimo = nuevo;
        }
        this.tamano++;
        return this;
    }
    
    /*
     * Metodo busca si el numero de cuenta generado aleatoriamente ya esta siendo usado.
     */
        public int Ncuantas() {
                Nodo temp = primero;
                int numeroAleatorio = (int) (Math.random()*9999+1000);
                for(int i = 0; i < this.tamano; i++) {
                    if(temp.CCuenta==numeroAleatorio){
                    	Ncuantas();
                    	}
                    temp = temp.nodoDer;
                }
                return numeroAleatorio;  
        }
        /*
         * Metodo busca al usuario para cambiar los valores de nombre y apellido.
         */
        public void Correct(int CX,String NCH,String ACH) {
            Nodo temp = primero;
            for(int i = 0; i < this.tamano; i++) {
                if(temp.CCuenta==CX){
                	temp.Nombre=NCH; 
                	temp.Apellido=ACH;}
                temp = temp.nodoDer;
            }         
        }
        
        /*
         * Metodo busca el nodo perteneciente a la cuenta que se desea encontar.
         */
        public Nodo busca(int CX) {
            Nodo temp = primero;
            for(int i = 0; i < this.tamano; i++) {
                if(temp.CCuenta==CX ){
                	return temp;
                }
                temp = temp.nodoDer;
            }
			return null;         
        }
        
        /*
         * Metodo que retorna las direcciones del nodo.
         */
        public Nodo total(){return primero;}
        /*
         * Metodo que retorna el tamaño total de nodo.
         */
        public int tamT(){return tamano;}    

}