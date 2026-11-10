package main;

public class Main {

    public static void main(String[] args) {
        String escenarios = "escenarios";
        String soluciones = "soluciones";

        if (args.length >= 1) escenarios = args[0];
        if (args.length >= 2) soluciones = args[1];

        ParserEscenario parser = new ParserEscenario();
        String rutaFichero = escenarios + "/Escenario-Prueba.txt";
        
        parser.procesarFichero(rutaFichero);
    }
}