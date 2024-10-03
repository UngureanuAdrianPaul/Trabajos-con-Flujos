import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FlujoAleatorio {

    public static void inicio() throws IOException {
        char letra = 'a';
        System.out.println("La letra " + letra + " aparece " + cuentaLetra(letra) + " veces");
        mostrarFichero("datos.dat");
        invertirCase();
        mostrarFichero("datos.dat");
        System.out.println("La letra " + letra + " aparece " + cuentaLetra(letra) + " veces");
    }

    public static boolean mostrarFichero(String fichero) throws IOException {
        RandomAccessFile acceso = null;
        try {
            acceso = new RandomAccessFile("datos.dat", "r");

            int letra = acceso.read();

            while (letra != -1) {
                System.out.print((char) letra + " ");
                letra = acceso.read();
            }
            System.out.println();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (acceso != null) {
                acceso.close();
            }
        }

    }

    public static int cuentaLetra(char letra) throws IOException {

        RandomAccessFile acceso = null;
        int contador = 0;
        int posicion = 0;
        try {
            acceso = new RandomAccessFile("datos.dat", "rw");
            posicion = buscarLetra(letra, acceso);

            while (posicion != -1) {
                contador++;
                posicion = buscarLetra(letra, acceso);
            }
            return contador;

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return -1;
        } finally {
            if (acceso != null) {
                acceso.close();
            }
        }
    }

    public static int buscarLetra(char letra, RandomAccessFile acceso) throws IOException {

        int posicion = 0;

        try {
            int lectura = acceso.read();
            while (((int) letra != lectura) && (lectura != -1)) {
                posicion++;
                lectura = acceso.read();
            }

            if (lectura == -1) {
                return -1;
            } else {
                return posicion;
            }

        } catch (IOException e) {
            return -2;
        }

    }

    public static boolean invertirCase() throws IOException {

        RandomAccessFile acceso = null;
        try {
            acceso = new RandomAccessFile("datos.dat", "rw");

            int valor = acceso.read();

            if (valor == -1) {
                return false;
            }

            Character letra;

            while (valor != -1) {

                letra = (char) valor;
                if (letra != Character.toUpperCase(letra)) {
                    letra = Character.toUpperCase(letra);
                } else {
                    letra = Character.toLowerCase(letra);
                }
                acceso.seek(acceso.getFilePointer() - 1);
                acceso.write(letra);
                valor = acceso.read();

            }

            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (acceso != null) {
                acceso.close();
            }
        }

    }
}
