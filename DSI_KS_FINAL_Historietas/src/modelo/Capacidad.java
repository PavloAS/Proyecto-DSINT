package modelo;

import java.util.Objects;

public abstract class Capacidad {

    private final String nombre;

    protected Capacidad(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public String getNombre() {
        return nombre;
    }
}