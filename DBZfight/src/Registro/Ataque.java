package Registro;

import java.util.Objects;

public class Ataque {
    private String usuario;
    private double dano;

    public Ataque(String usuario, double dano) {
        this.usuario = usuario;
        this.dano = dano;
    }

    public String getUsuario() {
        return usuario;
    }

    public double getDano() {
        return dano;
    }

    @Override
    public String toString() {
        return usuario + " causou " + dano + " de dano";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ataque ataque = (Ataque) o;
        return Double.compare(ataque.dano, dano) == 0 && Objects.equals(usuario, ataque.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, dano);
    }
}