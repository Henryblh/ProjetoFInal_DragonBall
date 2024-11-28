package Races.Personagems;

import HablidadesG.*;
import Races.Especies.Sayajin;

public class Broly extends Sayajin {
    public Broly(String nome, int vida, int velocidade, int forca, int ki) {
        super(nome, vida, velocidade, forca, ki);
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new EraserCannon()); // Sua habilidade única
    }
}
