package modelo;

import java.util.Objects;

public class Accion {

    private final String nombre;
    private final String tipo;
    private final String agenteAccion;
    private final String pacienteAccion;

    public Accion(String nombre, String tipo, String agenteAccion, String pacienteAccion) {
        this.nombre = Objects.requireNonNull(nombre);
        this.tipo = Objects.requireNonNull(tipo);
        this.agenteAccion = agenteAccion;
        this.pacienteAccion = pacienteAccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAgenteAccion() {
        return agenteAccion;
    }

    public String getPacienteAccion() {
        return pacienteAccion;
    }
}