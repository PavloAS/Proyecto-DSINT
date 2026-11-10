package modelo;

import java.util.Objects;

public class PerteneceAGrupo {

    private final String ser;
    private final String grupo;

    public PerteneceAGrupo(String ser, String grupo) {
        this.ser = Objects.requireNonNull(ser);
        this.grupo = Objects.requireNonNull(grupo);
    }

    public String getSer() {
        return ser;
    }

    public String getGrupo() {
        return grupo;
    }
}