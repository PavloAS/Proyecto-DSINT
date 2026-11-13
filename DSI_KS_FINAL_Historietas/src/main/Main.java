package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {

    public static void main(String[] args) {
        String escenarios = "escenarios";
        String soluciones = "soluciones";

        if (args.length >= 1) escenarios = args[0];
        if (args.length >= 2) soluciones = args[1];

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        ParserEscenario parser = new ParserEscenario();
        
        PrintStream consola = System.out;
        PrintStream consolaErrores = System.err;

        for (int i = 1; i <= 8; i++) {
            String rutaEntrada = escenarios + "/Escenario.F2-" + i + ".txt";
            String rutaSalida = soluciones + "/RespuestaF2_" + i + ".txt";
            File ficheroEntrada = new File(rutaEntrada);

            if (!ficheroEntrada.exists()) continue;

            try {
                // Redirigimos las salidas (Normal y Errores) desde el principio
                PrintStream archivoSalida = new PrintStream(new FileOutputStream(rutaSalida), true, "UTF-8");
                PrintStream dobleSalida = new PrintStream(archivoSalida) {
                    @Override
                    public void write(int b) {
                        super.write(b);
                        consola.write(b);
                    }
                    @Override
                    public void write(byte[] buf, int off, int len) {
                        super.write(buf, off, len);
                        consola.write(buf, off, len);
                    }
                };
                
                System.setOut(dobleSalida);
                System.setErr(dobleSalida); // Usamos esto para ver los fallos de Drools

                // El enunciado irá directo al .txt
                System.out.println("\n *** Descripción Escenario F2-" + i + " ***\n");
                Files.lines(ficheroEntrada.toPath(), StandardCharsets.UTF_8).forEach(System.out::println);
                System.out.println("\n *** Fin Descripción Escenario ***\n");

                // Crear sesión y ejecutar
                KieSession kSession = kContainer.newKieSession("ksession-rules-dsi");
                parser.procesarFichero(rutaEntrada, kSession);
                kSession.fireAllRules();
                kSession.dispose();

                // Restaurar y cerrar
                System.setOut(consola);
                System.setErr(consolaErrores);
                archivoSalida.close();
                consola.println("\n *** Fin Escenario F2-" + i + " ***\n");

            } catch (Exception e) {
                System.setOut(consola);
                System.setErr(consolaErrores);
                consola.println("Error procesando el escenario " + i + ": " + e.getMessage());
            }
        }
    }
}