package modelo;

import java.util.Objects;

public class RequiereCapacidad {

    private final String accion;
    private final String capacidad;

    public RequiereCapacidad(String accion, String capacidad) {
        this.accion = Objects.requireNonNull(accion);
        this.capacidad = Objects.requireNonNull(capacidad);
    }

    public String getAccion() {
        return accion;
    }

    public String getCapacidad() {
        return capacidad;
    }
}