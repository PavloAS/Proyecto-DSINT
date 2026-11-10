package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ParserEscenario {

    public void procesarFichero(String rutaFichero) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(rutaFichero), StandardCharsets.UTF_8))) { 

            String linea;
            boolean leyendoCondiciones = false;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                
                if (linea.isEmpty()) continue;

                if (linea.startsWith("Condiciones:")) {
                    leyendoCondiciones = true;
                    continue;
                }

                if (leyendoCondiciones) {
                    analizarHecho(linea);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void analizarHecho(String linea) {
        if (linea.contains(" tiene el favor de ")) {
            String[] partes = linea.split(" tiene el favor de ");
            System.out.println("FAVOR: " + partes[0].trim() + " -> " + partes[1].trim());

        } else if (linea.contains(" tiene el enojo de ")) {
            String[] partes = linea.split(" tiene el enojo de ");
            System.out.println("ENOJO: " + partes[0].trim() + " -> " + partes[1].trim());
            
        } else if (linea.contains(" no tiene ")) {
            String[] partes = linea.split(" no tiene ");
            System.out.println("DESPOSICIÓN: " + partes[0].trim() + " pierde " + partes[1].trim());
        }
    }
}