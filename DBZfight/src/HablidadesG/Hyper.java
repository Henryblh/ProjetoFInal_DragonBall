package HablidadesG;

import Races.PersonagemBase;

import java.util.Random;

public class Hyper implements HabilidadeP{

    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {

        double dano = usuario.getKi() * 5;  // Ajustando o dano
        Random random = new Random();
        double chanceMiss = inimigo.velocidade * 0.0043; // Ajustando a chance de erro baseado na velocidade
        double resultado = random.nextDouble();

        if (resultado <= chanceMiss) {
            if (resultado < chanceMiss / 2) {
                System.out.println(usuario.nome + " tentou usar Hyper Explosive Demon Wave, mas errou completamente!!!");
            } else {
                System.out.println(usuario.nome + " acertou um Hyper Explosive Demon Wave, mas não pegou em cheio e causou " + dano * 0.7 + " de dano!");
                inimigo.receberDano((int) Math.round(dano * 0.3));  // Dano reduzido para o caso de um "acerto parcial"
            }
        } else {
            System.out.println(usuario.nome + " acertou um Hyper Explosive Demon Wave com toda sua força, causando " + dano +
                    " de dano ao inimigo!, mas tambem sofreu "+dano/3 + " sí mesmo.");

            inimigo.receberDano((int) Math.round(dano));  // Dano completo no inimigo
            usuario.receberDano((int) Math.round(dano/3));//Dano próprio
        }
    }
}
