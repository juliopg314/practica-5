
package BD; //


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ManejadorArchivos {

    public String[] leerArchivoComoArreglo(String nombreArchivo) {

        List<String> lineas = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {

            System.err.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
        }


        return lineas.toArray(new String[0]);
    }


    public String buscarLinea(String cadenaBuscada, String nombreArchivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                if (linea.contains(cadenaBuscada)) {
                    return linea;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
        return null;
    }


    public void escribirLineaAlFinal(String linea, String nombreArchivo) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir (append) en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }


    public void escribirArregloAArchivo(String[] lineas, String nombreArchivo) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir (overwrite) en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
}