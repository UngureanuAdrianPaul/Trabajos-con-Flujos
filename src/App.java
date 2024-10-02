import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        System.out.println();
        File fichero = new File("datos.txt");

        if (!fichero.exists()) {
            fichero.createNewFile();
            System.out.println("Fichero creado correctamente");
        } else {
            System.out.println("El fichero ya esta creado");
        }

        // path absoluto

        File fichero2 = new File(
                "C:\\Users\\Adri\\Desktop\\2º CURSO PROGRAMAS\\Programas\\manejo ficheros\\flujos\\datos2.txt");

        if (!fichero2.exists()) {

            fichero2.createNewFile();
            System.out.println("Fichero segundo creado correctamente");
        } else {
            System.out.println("El fichero ya esta creado");
        }
      
        File directorio = new File("directorio");
        directorio.mkdir();

        File directorio2 = new File(".\\directorio\\subdirectorio\\ultimoDirectorio");
        directorio2.mkdirs();


        //mover a ultimodirectorio
        File fichero3 = new File(".\\\\directorio\\\\subdirectorio\\\\ultimoDirectorio\\datos.txt");

        fichero.renameTo(fichero3);
    }
}
