package clases;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FlujoChar {
    


    public static void inicio() throws IOException {
        
        FileReader lector = null;

        try {
            lector = new FileReader("datos.txt");
            int letra = lector.read();
            while (letra != -1) {
                System.out.print((char) letra + " ");
                letra = lector.read();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {

            if (lector != null) {
                lector.close();
            }
        }
    }
}
