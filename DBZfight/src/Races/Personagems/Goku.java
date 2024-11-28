package Races.Personagems;

import HablidadesG.*;
import Races.Especies.Sayajin;

public class Goku extends Sayajin {
    public Goku(String nome, int vida, int velocidade, int forca, int ki) {
        super(nome, vida, velocidade, forca, ki);
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new SpiritBomb()); // Sua habilidade única
    }
}

