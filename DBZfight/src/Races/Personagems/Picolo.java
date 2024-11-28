package Races.Personagems;

import HablidadesG.*;
import Races.Especies.Ki;

public class Picolo extends Ki {
    public Picolo(String nome, int vida, int velocidade, int forca, int ki) {
        super(nome, vida, velocidade, forca, ki);
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new Hyper()); // Sua habilidade única
    }
}
