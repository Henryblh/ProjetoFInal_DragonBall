package Races.Especies;

import HablidadesG.*;
import Races.PersonagemBase;

public class Androids extends PersonagemBase {
    public Androids(String nome, int vida, int velocidade, int forca) {
        super(nome, vida, velocidade, forca);
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new Nonstop());
    }
}