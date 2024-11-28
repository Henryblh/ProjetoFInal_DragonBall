package HablidadesG;

import Races.PersonagemBase;
import java.util.Random;

public class Absorver implements HabilidadeP {

    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {
        Random random = new Random();
        double dano = usuario.forca * 0.5; // Dano reduzido
        double chanceMiss = inimigo.velocidade * 0.003; // Chance de errar
        double resultado = random.nextDouble();

        // Verifica se o ataque acerta
        if (resultado <= chanceMiss) {
            System.out.println(usuario.nome + " tentou usar Absorver, mas errou!");
            return;
        }

        // Dano e absorção
        System.out.println(usuario.nome + " usou Absorver e causou " + dano + " de dano!");
        inimigo.receberDano((int) Math.round(dano));

        // Verifica se o inimigo tem habilidades
        if (inimigo.habilidades.isEmpty()) {
            System.out.println(inimigo.nome + " não tem habilidades para serem absorvidas!");
            return;
        }

        // Filtra habilidades que o usuário ainda não possui
        for (HabilidadeP habilidade : inimigo.habilidades) {
            if (!usuario.habilidades.contains(habilidade)) {
                usuario.habilidades.add(habilidade);
                System.out.println(usuario.nome + " roubou a habilidade " + habilidade.getClass().getSimpleName() + " de " + inimigo.nome + "!");
                return;
            }
        }

        // Caso todas as habilidades já sejam conhecidas
        System.out.println(usuario.nome + " tentou absorver, mas já possui todas as habilidades de " + inimigo.nome + "!");
    }
}