package modelo;

import java.util.Objects;

public class Heroe {

    private final String nombre;

    public Heroe(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public String getNombre() {
        return nombre;
    }
}