package main;

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
        KieSession kSession = kContainer.newKieSession("ksession-rules-dsi");

        ParserEscenario parser = new ParserEscenario();
        String rutaFichero = escenarios + "/Escenario-Prueba.txt";

        parser.procesarFichero(rutaFichero, kSession);

        kSession.fireAllRules();
        kSession.dispose();
    }
}