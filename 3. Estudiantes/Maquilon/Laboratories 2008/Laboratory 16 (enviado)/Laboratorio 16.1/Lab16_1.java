
import java.io.*;

public class Lab16_1 {

    private BufferedReader Datos;

    public Lab16_1(Reader archivo) throws IOException {
        Datos = new BufferedReader(archivo);
    }

    public void Mostrar_Resultados() throws IOException {

        while (true) {
            String casa = Datos.readLine();

            if (casa == null) {
                System.out.println("\t\t\tYa no hay mas resultados...");
                System.in.read();
            }

            int casa_puntos = Integer.parseInt(Datos.readLine());
            String visita = Datos.readLine();
            int visita_puntos = Integer.parseInt(Datos.readLine());

            if (casa_puntos > visita_puntos) {
                System.out.println("      LA CASA\t\t\t\t     VISITA\n\n");
                System.out.println("   " + casa + "\t" + casa_puntos + " *" + "\t\t" + visita + "\t" + visita_puntos + "\n\n");
            } else {
                System.out.println("      LA CASA\t\t\t\t     VISITA\n\n");
                System.out.println("   " + visita + "\t" + visita_puntos + " *" + "\t\t" + casa + "\t" + casa_puntos + "\n\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader Archivo = new FileReader("Datos.txt");
        Lab16_1 Leer_Archivo = new Lab16_1(Archivo);
        Leer_Archivo.Mostrar_Resultados();
    }
}
