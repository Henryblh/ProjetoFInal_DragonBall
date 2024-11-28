package Races.Personagems;

import HablidadesG.*;
import Races.Especies.Androids;

public class Android_18 extends Androids {
    public Android_18(String nome, int vida, int velocidade, int forca) {
        super(nome, vida, velocidade, forca);
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new Infinity()); // Sua habilidade única
    }
}

