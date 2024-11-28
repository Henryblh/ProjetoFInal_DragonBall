package HablidadesG;

import Races.PersonagemBase;
import java.util.Random;

public class EraserCannon implements HabilidadeP {

    // Implementação do método usar da interface HabilidadeP
    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {

        double dano = usuario.getKi() * 10;  // Ajustando o dano
        Random random = new Random();
        double chanceMiss = inimigo.velocidade * 0.001; // Ajustando a chance de erro baseado na velocidade
        double resultado = random.nextDouble();

        if (resultado <= chanceMiss) {
            System.out.println(usuario.nome + " Lançou um enorme raio de energio e "+inimigo.nome+" esviou, porem o raio atingiu a terra e desimou o terreno");}
        else {
            System.out.println(usuario.nome + " Lançou um enorme raio de energia, um Eraser Cannon, o inimigo sofreu "+ dano+" de dano ");
            inimigo.receberDano((int) Math.round(dano));
        }
    }
}