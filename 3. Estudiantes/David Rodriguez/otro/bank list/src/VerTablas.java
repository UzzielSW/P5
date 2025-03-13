import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/*
 * Esta clase genera la ventana de todos los registros
 * @author David Rodríguez
 * */
public class VerTablas extends JFrame {
	private static final long serialVersionUID = 1L;
	private	String		data[][];
	private static	ListaS lisC=null;
	
	/*
     * Metodo el cual crea la tabla y adiere los datos.
     * */
     public VerTablas() {
        super("Clientes");

        CreateData();

        String[] columnNames = {"Nombre", "Apellido", "ID","Balance", "Tipo de cuenta"};

        final JTable table = new JTable(data,columnNames);
   
        table.setPreferredScrollableViewportSize(new Dimension(500,500));
        
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

    }

    public static void main(ListaS lis) {
    	if(lisC==null){lisC=lis;}
        VerTablas run = new VerTablas();
        run.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		run.pack();
		run.setResizable(false);
		run.setVisible(true);
    }
   /*
    * Metodo encargado de introducir los valores de una lista en un arreglo
    * e indentifica el estado de la cuenta.
    * */
   public void CreateData()
	{
		data = new String[lisC.tamT()][5];
		Nodo temp = lisC.total();
        for(int i = 0; i < lisC.tamT(); i++) {
        	data[i][0]= temp.Nombre;
        	data[i][1]= temp.Apellido;
        	data[i][2]= ""+temp.CCuenta;
        	if(temp.SaldoA==-1){
        		data[i][3]= ""+temp.SaldoC;
				data[i][4] ="corriente";}
				else {
					data[i][3]= ""+temp.SaldoA;
					data[i][4] ="ahorro";}

            temp = temp.nodoDer;
        }
		
		

}

}