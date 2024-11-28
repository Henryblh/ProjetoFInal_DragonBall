package Races;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import HablidadesG.*;

public abstract class PersonagemBase {
    public String nome;
    public double vida;
    public int velocidade;
    public int forca;
    public List<HabilidadeP> habilidades;
    private double ultimoDano;
    public double vidaOriginal;

    public PersonagemBase(String nome, int vidaOriginal, int velocidade, int forca) {
        this.nome = nome;
        this.vidaOriginal = vidaOriginal;
        this.vida = vidaOriginal; // Inicializa a vida com o valor original
        this.velocidade = velocidade;
        this.forca = forca;
        this.habilidades = new ArrayList<>();
        adicionarHabilidades();
    }

    // Método para resetar a vida ao valor original
    public void resetarVida() {
        this.vida = this.vidaOriginal;
    }

    public int getKi() {
        throw new UnsupportedOperationException("Este personagem não possui Ki");
    }

    public int setKi(int new_ki) {
        throw new UnsupportedOperationException("Este personagem não possui Ki");
    }

    public double getUltimoDano() {
        return ultimoDano;
    }

    protected void adicionarHabilidades() {
        habilidades.add(new Soco()); // Não precisa passar a velocidade
        habilidades.add(new Chute());
    }

    public void usarHabilidadeAleatoria(PersonagemBase usuario,PersonagemBase inimigo) {
        Random random = new Random();
        int index = random.nextInt(habilidades.size());
        habilidades.get(index).usar(usuario, inimigo);
    }

    public void receberDano(int dano) {
        this.ultimoDano = dano;
        vida = Math.max(vida - dano, 0);
        if (vida == 0) {
            System.out.println(nome + " foi derrotado!");
        }
    }
}