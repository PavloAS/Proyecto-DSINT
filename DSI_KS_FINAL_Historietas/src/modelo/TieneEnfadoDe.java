package modelo;

import java.util.Objects;

public class TieneEnfadoDe {

    private final String personaje;
    private final String ser;

    public TieneEnfadoDe(String personaje, String ser) {
        this.personaje = Objects.requireNonNull(personaje);
        this.ser = Objects.requireNonNull(ser);
    }

    public String getPersonaje() {
        return personaje;
    }

    public String getSer() {
        return ser;
    }
}