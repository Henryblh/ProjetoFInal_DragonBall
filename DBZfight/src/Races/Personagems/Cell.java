package Races.Personagems;

import HablidadesG.Absorver;
import Races.PersonagemBase;

public class Cell extends PersonagemBase {
    public int ki;

    public Cell(String nome, int vida, int velocidade, int forca, int ki) {
        super(nome, vida, velocidade, forca);
        this.ki = ki;  // Atribua o valor de ki diretamente
    }

    @Override
    public int getKi() {
        return this.ki;  // Retorna o valor de ki
    }

    @Override
    public int setKi(int newKi) {
        this.ki = newKi;  // Atribui o novo valor ao ki
        return this.ki;  // Retorna o novo valor de ki
    }

    @Override
    protected void adicionarHabilidades() {
        habilidades.add(new Absorver());
    }
}
