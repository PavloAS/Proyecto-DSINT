package modelo;

import java.util.Objects;

public class ObjetoUsado {

    private final String accion;
    private final String objeto;

    public ObjetoUsado(String accion, String objeto) {
        this.accion = Objects.requireNonNull(accion);
        this.objeto = Objects.requireNonNull(objeto);
    }

    public String getAccion() {
        return accion;
    }

    public String getObjeto() {
        return objeto;
    }
}