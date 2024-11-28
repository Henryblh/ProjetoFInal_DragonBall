package HablidadesG;
import Races.PersonagemBase;
import java.util.Random;

public class Chute implements HabilidadeP {

    // Implementação do método usar da interface HabilidadeP
    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {

        double dano = usuario.forca * 1.8;  // Ajustando o dano
        Random random = new Random();
        double chanceMiss = inimigo.velocidade * 0.002; // Ajustando a chance de erro baseado na velocidade
        double resultado = random.nextDouble();

        if (resultado <= chanceMiss) {
            if (resultado < chanceMiss / 2) {
                System.out.println(usuario.nome + " tentou usar o Chute, mas errou completamente!!!");
            } else {
                System.out.println(usuario.nome + " acertou um Chute, mas não pegou em cheio e causou " + dano * 0.4 + " de dano!");
                inimigo.receberDano((int) Math.round(dano * 0.4));  // Dano reduzido para o caso de um "acerto parcial"
            }
        } else {
            System.out.println(usuario.nome + " acertou um Chute com toda sua força, causando " + dano + " de dano!");
            inimigo.receberDano((int) Math.round(dano));  // Dano completo no inimigo
        }
    }
}