package HablidadesG;

import Races.PersonagemBase;
import java.util.Random;

public class Soco implements HabilidadeP {

    // Implementação do método usar da interface HabilidadeP
    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {
        // Recalcula o dano usando a força atualizada do personagem
        double dano = usuario.forca * 1.5; // Ajusta o dano conforme a força atual
        Random random = new Random();
        double chanceMiss = inimigo.velocidade * 0.003;
        double resultado = random.nextDouble();

        if (resultado <= chanceMiss) {
            if (resultado < chanceMiss / 2) {
                System.out.println(usuario.nome + " tentou usar o Soco, mas errou completamente!!!");
            } else {
                System.out.println(usuario.nome + " acertou o Soco, mas não pegou em cheio e causou " + dano * 0.5 + " de dano!");
                inimigo.receberDano((int) Math.round(dano * 0.5));
            }
        } else {
            System.out.println(usuario.nome + " acertou um Soco com toda sua força, causando " + dano + " de dano!");
            inimigo.receberDano((int) Math.round(dano));
        }
    }
}