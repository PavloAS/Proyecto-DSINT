package modelo;

import java.util.Objects;

public abstract class Ser {

    private final String nombre;
    private String estadoVida = "vivo";
    private String estadoLibertad = "libre";
    private String seEncuentraEn;
    private String tienePadre;
    private String tieneMadre;

    protected Ser(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstadoVida() {
        return estadoVida;
    }

    public void setEstadoVida(String estadoVida) {
        if (!"vivo".equals(estadoVida) && !"muerto".equals(estadoVida)) {
            throw new IllegalArgumentException("Estado de vida no valido");
        }
        this.estadoVida = estadoVida;
    }

    public String getEstadoLibertad() {
        return estadoLibertad;
    }

    public void setEstadoLibertad(String estadoLibertad) {
        if (!"libre".equals(estadoLibertad) && !"preso".equals(estadoLibertad)) {
            throw new IllegalArgumentException("Estado de libertad no valido");
        }
        this.estadoLibertad = estadoLibertad;
    }

    public String getSeEncuentraEn() {
        return seEncuentraEn;
    }

    public void setSeEncuentraEn(String seEncuentraEn) {
        this.seEncuentraEn = seEncuentraEn;
    }

    public String getTienePadre() {
        return tienePadre;
    }

    public void setTienePadre(String tienePadre) {
        this.tienePadre = tienePadre;
    }

    public String getTieneMadre() {
        return tieneMadre;
    }

    public void setTieneMadre(String tieneMadre) {
        this.tieneMadre = tieneMadre;
    }
}