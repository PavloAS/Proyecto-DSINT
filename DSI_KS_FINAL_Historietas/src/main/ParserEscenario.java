package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.kie.api.runtime.KieSession;

import modelo.Mision;
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

                
                if	(!leyendoCondiciones) {
                	analizarPregunta(linea, kSession);
                }
                else {
                    analizarHecho(linea, kSession);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void analizarPregunta(String pregunta, KieSession kSession) {
    	String p = pregunta.replace("¿", "").replace("?", "").trim();
    	
    	if(p.contains("Perseo") && p.contains("liberar a Andromeda")) {
    		kSession.insert(new Mision("Liberar a Andromeda", "Liberar", "Perseo", "Andromeda"));
    	}
    	else if (p.contains("Teseo") && p.contains("liberar a Andromeda")) {
            kSession.insert(new Mision("Liberar a Andromeda", "Liberar", "Teseo", "Andromeda"));
        } 
    	else if (p.contains("Heracles") && p.contains("liberar a Andromeda")) {
            kSession.insert(new Mision("Liberar a Andromeda", "Liberar", "Heracles", "Andromeda"));
        }
        if (p.contains("Teseo") && p.contains("matar al Minotauro")) {
            kSession.insert(new Mision("Matar al Minotauro", "Matar", "Teseo", "Minotauro"));
        }
        if (p.contains("Dedalo") && p.contains("escapar")) {
            kSession.insert(new Mision("Escapar del Laberinto", "Liberar", "Dedalo", "Dedalo"));
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

        } else if (linea.contains(" no tienen ") || linea.contains(" no tiene ")) {
            String[] partes = linea.split(" no tiene[n]? "); // Para casos plural y singular
            String personaje = partes[0].trim();
            String objeto = partes[1].trim();
            kSession.insert("DESPOSEER_" + objeto);
            System.out.println("Insertado DESPOSESIÓN: " + personaje + " pierde " + objeto);
        }
    }
}