package HablidadesG;

import Races.PersonagemBase;
import java.util.Random;

public class SpiritBomb implements HabilidadeP {

    // Implementação do método usar da interface HabilidadeP
    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {

        double  dano = usuario.getKi() * 4 ;
        Random random = new Random();
        double chanceMiss = inimigo.velocidade * 0.002; // Chance de erro baseado na velocidade do inimigo
        double resultado = random.nextDouble();


        if (resultado <= chanceMiss) {
            if (resultado < chanceMiss/2){
                System.out.println(usuario.nome + " tentou usar SpiritBomb porém errou!!!)");
            }
            else {
                System.out.println(usuario.nome + " Acertou um Spirit Bomb mas nao pegou em cheio, e deu "+ dano * 0.25+" de dano!!");
                inimigo.receberDano((int) Math.round(dano * 0.25));
            }
        }
        else {
            System.out.println(usuario.nome + " Acertou um Spirit Bomb com tudo que tinha "+ dano+ " de dano!!");
            inimigo.receberDano((int) Math.round(dano));

        }

    }
}
