package Races.Personagems;

import HablidadesG.*;
import Races.Especies.Androids;

public class Android_16 extends Androids {
    public Android_16(String nome, int vida, int velocidade, int forca) {
        super(nome, vida, velocidade, forca);
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new Machine()); // Sua habilidade única
    }
}

