package HablidadesG;

import Races.PersonagemBase;
import java.util.Random;

public class Nonstop implements HabilidadeP {

    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {
        double multiplicador = 1.0; // Multiplicador base para o ataque
        double chanceMiss = 0.0; // Chance inicial de errar
        double misschance = 0.0;
        Random random = new Random();
        int i = 1 ;

        double dano = usuario.forca * multiplicador; // Calcula o dano do ataque

        while (true) {double resultado = random.nextDouble(); // Gera um número aleatório para determinar se o ataque acerta

            if (resultado <= misschance) {
                // Registro.Ataque falhou
                System.out.println(usuario.nome + " tentou usar Nonstop, mas errou!");
                break; // Sai do loop ao errar
            } else {
                // Registro.Ataque acertou
                dano *= 1.1;
                System.out.println(usuario.nome + " acertou o Non-stop Violence " +i+ " vezes , causando " + Math.round(dano) + " de dano!");
                inimigo.receberDano((int) Math.round(dano));

                // Aumenta a chance de erro para os próximos golpes
                chanceMiss += 0.0005;
                misschance = inimigo.velocidade * chanceMiss;
                i++;

                // Condição para finalizar o inimigo (opcional, evita loop infinito)
                if (inimigo.vida <= 0) {
                    break;
                }
            }
        }
    }
}