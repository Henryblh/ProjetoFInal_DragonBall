package Races.Personagems;

import HablidadesG.*;
import Races.Especies.Androids;

public class Android_17 extends Androids {
    public Android_17(String nome, int vida, int velocidade, int forca) {
        super(nome, vida, velocidade, forca);
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new Photon()); // Sua habilidade única
    }
}

