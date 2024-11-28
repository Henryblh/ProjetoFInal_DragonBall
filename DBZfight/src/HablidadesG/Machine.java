package HablidadesG;

import Races.PersonagemBase;

import java.util.Random;

public class Machine implements HabilidadeP{

    // Implementação do método usar da interface HabilidadeP
    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {
        double dano = usuario.forca * 4; // Ajusta o dano conforme a força atual
        Random random = new Random();
        double chanceMiss = inimigo.velocidade * 0.0037;
        double resultado = random.nextDouble();

        if (resultado <= chanceMiss) {
            System.out.println(usuario.nome + "  Colide com toda a força de seu corpo, mas acertou uma parede, e sofreu "+ dano/2+" de dano!");
            usuario.receberDano((int) Math.round(dano/2));}
        else {
            System.out.println(usuario.nome + " Colide com toda a força de seu corpo, e acertou o inimigo com tudo, dando " + dano + " de dano!");
            inimigo.receberDano((int) Math.round(dano));
        }

    }
}
