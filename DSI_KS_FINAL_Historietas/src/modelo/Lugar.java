package modelo;

import java.util.Objects;

public class Lugar {

    private final String nombre;

    public Lugar(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public String getNombre() {
        return nombre;
    }
}