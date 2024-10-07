package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AccesoBuffer {

   public static void inicio() throws IOException {
      mostrarYcontarContenido("texto.txt");
   }

   private static boolean mostrarContenido(String nombreFichero) throws IOException {

      BufferedReader lectorBufer = null;

      try {
         lectorBufer = new BufferedReader(new FileReader(nombreFichero));
         String frase = lectorBufer.readLine();
         while (frase != null) {
            System.out.println(frase);
            frase = lectorBufer.readLine();
         }
         return true;
      } catch (FileNotFoundException e) {
         System.out.println(e.getMessage());
         return false;
      } finally {
         if (lectorBufer != null) {
            lectorBufer.close();
         }
      }

   }

   private static boolean mostrarYcontarContenido(String nombreFichero) throws IOException {
      // contar significa contar las lineas totales y cuantas vacias hay

      BufferedReader lectorBufer = null;
      int cuentaFrase = 0;
      int cuentaEspacio = 0;

      try {
         lectorBufer = new BufferedReader(new FileReader(nombreFichero));
         String frase = lectorBufer.readLine();

         while (frase != null) {
            cuentaFrase++;
            if (frase.isEmpty()) {
               cuentaEspacio++;

            }
            frase = lectorBufer.readLine();
         }
         System.out.println();
         System.out.println("Hay un total de " + cuentaFrase + " lineas de texto.");
         System.err.println();
         System.out.println("Hay un total de " + cuentaEspacio + " lineas vacias");

         return true;

      } catch (FileNotFoundException e) {
         e.getMessage();
         return false;
      } finally {
         if (lectorBufer != null) {
            lectorBufer.close();
         }
      }

   }

}
