package Races.Especies;

import HablidadesG.*;

public class Sayajin extends Ki {
    public Sayajin(String nome, int vida, int velocidade, int forca, int ki) {
        super(nome, vida, velocidade, forca, ki);
    }


    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new SSJ());
    }
}