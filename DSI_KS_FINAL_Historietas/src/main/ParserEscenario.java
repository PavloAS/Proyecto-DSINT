package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.kie.api.runtime.KieSession;

import modelo.TieneEnfadoDe;
import modelo.TieneFavorDe;

public class ParserEscenario {

    public void procesarFichero(String rutaFichero, KieSession kSession) {
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
                    analizarHecho(linea, kSession);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void analizarHecho(String linea, KieSession kSession) {
        if (linea.contains(" tiene el favor de ")) {
            String[] partes = linea.split(" tiene el favor de ");
            String personaje = partes[0].trim();
            String dios = partes[1].trim();
            kSession.insert(new TieneFavorDe(personaje, dios));
            System.out.println("Insertado FAVOR: " + personaje + " -> " + dios);

        } else if (linea.contains(" tiene el enfado de ")) {
            String[] partes = linea.split(" tiene el enfado de ");
            String personaje = partes[0].trim();
            String dios = partes[1].trim();
            kSession.insert(new TieneEnfadoDe(personaje, dios));
            System.out.println("Insertado ENFADO: " + personaje + " -> " + dios);

        } else if (linea.contains(" no tiene ")) {
            String[] partes = linea.split(" no tiene ");
            System.out.println("DESPOSESIÓN: " + partes[0].trim() + " pierde " + partes[1].trim());
        }
    }
}