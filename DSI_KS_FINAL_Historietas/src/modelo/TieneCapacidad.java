package modelo;

import java.util.Objects;

public class TieneCapacidad {

    private final String ser;
    private final String capacidad;

    public TieneCapacidad(String ser, String capacidad) {
        this.ser = Objects.requireNonNull(ser);
        this.capacidad = Objects.requireNonNull(capacidad);
    }

    public String getSer() {
        return ser;
    }

    public String getCapacidad() {
        return capacidad;
    }
}