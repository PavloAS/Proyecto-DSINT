package modelo;

import java.util.Objects;

public class Mision {

    private final String nombre;
    private final String tipo;
    private final String agenteMision;
    private final String objetivoMision;
    private boolean cumplida;

    public Mision(String nombre, String tipo, String agenteMision, String objetivoMision) {
        this.nombre = Objects.requireNonNull(nombre);
        this.tipo = Objects.requireNonNull(tipo);
        this.agenteMision = Objects.requireNonNull(agenteMision);
        this.objetivoMision = Objects.requireNonNull(objetivoMision);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAgenteMision() {
        return agenteMision;
    }

    public String getObjetivoMision() {
        return objetivoMision;
    }

    public boolean isCumplida() {
        return cumplida;
    }

    public void setCumplida(boolean cumplida) {
        this.cumplida = cumplida;
    }
}