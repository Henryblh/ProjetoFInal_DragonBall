package HablidadesG;

import Races.PersonagemBase;

import java.util.Random;

public class Infinity implements HabilidadeP {

    // Implementação do método usar da interface HabilidadeP
    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {
        double dano = usuario.forca * 3; // Ajusta o dano conforme a força atual
        Random random = new Random();
        double chanceMiss = inimigo.velocidade * 0.002;
        double resultado = random.nextDouble();

        if (resultado <= chanceMiss) {
            System.out.println(usuario.nome + " Atira um feixe de energia, próximo do alvo, mas errou");}
        else {
            System.out.println(usuario.nome + " Atira um feixe de energia, e acerta o alvo, dando " + dano + " de dano!");
            inimigo.receberDano((int) Math.round(dano));
        }

    }
}
