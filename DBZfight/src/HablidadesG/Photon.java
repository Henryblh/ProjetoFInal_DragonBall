package HablidadesG;

import Races.PersonagemBase;

import java.util.Random;

public class Photon implements HabilidadeP {

    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {
        double dano = usuario.forca * 8; // Ajusta o dano conforme a força atual
        Random random = new Random();
        double chanceMiss = inimigo.velocidade * 0.0056;
        double resultado = random.nextDouble();

        if (resultado <= chanceMiss) {
            System.out.println(usuario.nome + " juntou energia do ambiente e lançou um grande ataque, mas errou ");}
        else {
            System.out.println(usuario.nome + " juntou energia do ambiente e lançou um grande ataque, e acertou em cheio " + dano + " de dano!");
            inimigo.receberDano((int) Math.round(dano));
        }

    }
}
