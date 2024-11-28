package Races.Especies;

import HablidadesG.*;
import Races.PersonagemBase;

public class Ki extends PersonagemBase {
    public int ki;

    public Ki(String nome, int vida, int velocidade, int forca, int ki) {
        super(nome, vida, velocidade, forca);
        this.ki = ki;
    }

    @Override
    public int getKi() {
        return this.ki;
    }

    @Override
    public  int setKi(int newKi){
        this.ki = newKi;
        return this.ki;
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new Kamehameha());
    }
}
