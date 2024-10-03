package clases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FlujoBytes {

    public static void inicio() throws IOException {

        escribir();
        leer();
        System.out.println();
        leerTodo();
        System.out.println();
        leerPrimeroUltimo();
    }

    public static void leer() throws IOException {

        FileInputStream lector = null;

        try {
            lector = new FileInputStream("datos.txt");
            int num = lector.read();

            while (num != -1) {
                System.out.print((char) num + " ");
                num = lector.read();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector != null) {
                lector.close();
            }
        }
    }

    public static void escribir() throws IOException {

        File fichero = new File("datos.txt");
        FileOutputStream escritor = null;

        try {
            escritor = new FileOutputStream(fichero);
            for (int i = 97; i < 123; i++) {
                escritor.write(i);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }
    }

    public static void leerTodo() throws IOException {

        FileInputStream lector = null;

        try {
            lector = new FileInputStream("datos.txt");
            byte[] miArray = new byte[13];
            for (int j = 0; j < 2; j++) {
                System.out.println();
                lector.read(miArray);
                for (int i = 0; i < miArray.length; i++) {
                    System.out.print((char) miArray[i] + " ");
                }


            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {

            if (lector != null) {
                lector.close();
            }

        }

    }

    public static void leerPrimeroUltimo() throws IOException {

        FileInputStream lector = null;

        try {
            lector = new FileInputStream("datos.txt");
            int[] miArray = new int[2];
            miArray[0] = lector.read();
            lector.skip(24);
            miArray[1] = lector.read();
            System.out.println(miArray[0] + " " + miArray[1]);
        } catch (FileNotFoundException e){

            System.out.println(e.getMessage());
        } finally { 
            if ((lector != null)) {
                lector.close();
            }
        }

    }

}
