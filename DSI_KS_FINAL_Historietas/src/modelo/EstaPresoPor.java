package modelo;

import java.util.Objects;

public class EstaPresoPor {

    private final String ser;
    private final String captor;

    public EstaPresoPor(String ser, String captor) {
        this.ser = Objects.requireNonNull(ser);
        this.captor = Objects.requireNonNull(captor);
    }

    public String getSer() {
        return ser;
    }

    public String getCaptor() {
        return captor;
    }
}