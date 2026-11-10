package modelo;

import java.util.Objects;

public class Objeto {

    private final String nombre;
    private String perteneceASer;
    private boolean estaRoto;

    public Objeto(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public String getPerteneceASer() {
        return perteneceASer;
    }

    public void setPerteneceASer(String perteneceASer) {
        this.perteneceASer = perteneceASer;
    }

    public boolean isEstaRoto() {
        return estaRoto;
    }

    public void setEstaRoto(boolean estaRoto) {
        this.estaRoto = estaRoto;
    }
}