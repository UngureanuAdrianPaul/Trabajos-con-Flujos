package clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FlujoByteVariosAccesos {

    public static void inicio() throws IOException {

        Scanner teclado = new Scanner(System.in);
        escribir(false);
        leer();
        escribir(true);
        leer();
        teclado.close();

    }

    public static void escribir(boolean minusculas) throws IOException {
        FileOutputStream escritor = null;
        try {
            escritor = new FileOutputStream("datos.dat",true);

            if ( minusculas) {
                for (int i = 97; i < 123; i++) {
                    escritor.write(i);
                }
            } else {
                for (int i = 65; i < 91; i++) {
                    escritor.write(i);
                }
            }
            System.out.println();
           

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {

            if (escritor != null) {
                escritor.close();
            }
        }

    }

    public static void leer() throws IOException {
        FileInputStream lector = null;

        try {
            lector = new FileInputStream("datos.dat");
            int num = lector.read();
            while (num!= -1) {
                System.out.print((char) num + " ");
                num =  lector.read();
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector != null) {
                lector.close();
            }
        }
    }
}
