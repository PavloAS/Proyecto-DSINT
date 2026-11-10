package modelo;

import java.util.Objects;

public class OtorgaCapacidad {

    private final String objeto;
    private final String capacidad;

    public OtorgaCapacidad(String objeto, String capacidad) {
        this.objeto = Objects.requireNonNull(objeto);
        this.capacidad = Objects.requireNonNull(capacidad);
    }

    public String getObjeto() {
        return objeto;
    }

    public String getCapacidad() {
        return capacidad;
    }
}