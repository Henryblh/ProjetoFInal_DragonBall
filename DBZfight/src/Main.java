import Exceptions.DontExistException;
import Exceptions.NullException;
import Exceptions.NumException;
import Registro.Ataque;
import Races.*;
import Races.Personagems.*;
import Registro.RegistroDeBatalha;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        boolean sair = true;

        List<PersonagemBase> personagens = new ArrayList<>();// Lista de personagens disponíveis

        //Instanciar personagens como Personagembase
        personagens.add(new Goku("Goku", 5000, 150, 250, 100));
        personagens.add(new Vegeta("Vegeta", 5000, 150, 250, 100));
        personagens.add(new Android_17("Android 17", 3000, 200, 100));
        personagens.add(new Android_18("Android 18", 4500, 180, 120));
        personagens.add(new Android_16("Android 16", 4000, 140, 180));
        personagens.add(new Picolo("Picolo", 6000, 120, 200, 250));
        personagens.add(new Broly("Broly", 10000, 100, 1000, 500));
        personagens.add(new Cell("Perfect Cell", 7000, 170, 200, 150));

        //criar ou encontrar o arquivo Registro De Batalha
        RegistroDeBatalha registroDeBatalha = new RegistroDeBatalha("RegistroDeBatalha.txt");

        Scanner scanner = new Scanner(System.in);

        while (sair) {

            System.out.println("\n--- Batalha ---");
            System.out.println("Selecione os personagens para a batalha digitando seus nomes:");
            for (PersonagemBase p : personagens) {
                System.out.println("- " + p.nome);
            }

            // Selecionar o primeiro personagem
            PersonagemBase per1 = null;
            while (per1 == null) {
                System.out.print("Digite o nome do primeiro personagem: ");
                String nome1 = scanner.nextLine();
                per1 = buscarPersonagemPorNome(personagens, nome1);
            }

            // Selecionar o segundo personagem
            PersonagemBase per2 = null;
            while (per2 == null || per2 == per1) {
                System.out.print("Digite o nome do segundo personagem: ");
                String nome2 = scanner.nextLine();
                per2 = buscarPersonagemPorNome(personagens, nome2);
                if (per2 == per1) {
                    System.out.println("Você não pode selecionar o mesmo personagem duas vezes! Escolha outro.");
                }
            }

            //Array da classe que guarda informações sobre a batalha
            List<Ataque> registroAtaques = new ArrayList<>();

            // Iniciar a batalha
            System.out.println("\nA batalha começa entre " + per1.nome + " e " + per2.nome + "\n\n");

            //Inicia a logica ciclica das batalhas
            while (per1.vida > 0 && per2.vida > 0) {

                //Ataques
                if (per1.velocidade > per2.velocidade) {
                    per1.usarHabilidadeAleatoria(per1, per2);
                    registroAtaques.add(new Ataque(per1.nome, per2.getUltimoDano()));

                    if (per2.vida > 0) {
                        per2.usarHabilidadeAleatoria(per2, per1);
                        registroAtaques.add(new Ataque(per2.nome, per1.getUltimoDano()));
                    }
                }

                //Ataques
                else {
                    per2.usarHabilidadeAleatoria(per2, per1);
                    registroAtaques.add(new Ataque(per1.nome, per2.getUltimoDano()));

                    if (per1.vida > 0) {
                        per1.usarHabilidadeAleatoria(per1, per2);
                        registroAtaques.add(new Ataque(per2.nome, per1.getUltimoDano()));
                    }
                }

                // Exibir status dos personagens após cada rodada
                System.out.println("\n\n" + per1.nome + " tem " + per1.vida + " HP");
                System.out.println(per2.nome + " tem " + per2.vida + " HP\n\n");
            }

            // Declarar o vencedor
            if (per1.vida > 0) {
                System.out.println(per1.nome + " venceu a batalha!");
            } else {
                System.out.println(per2.nome + " venceu a batalha!");
            }

            // Organiza os 5 ataques mais fortes Usando a Collections API
            Collections.sort(registroAtaques, Comparator.comparingDouble(Ataque::getDano).reversed());
            List<Ataque> topAtaques = new ArrayList<>();
            for (int i = 0; i < Math.min(5, registroAtaques.size()); i++) {
                topAtaques.add(registroAtaques.get(i));
            }

            // Salva no arquivo As intancias dos ataques mais fortes de cada batalha
            registroDeBatalha.salvarRegistro(topAtaques,per1.nome, per2.nome);

            //Resta a vida dos personagens na batalha
            per1.resetarVida();
            per2.resetarVida();

            //Menu Opções

            while(true){
                System.out.println("\n--- Menu Principal ---");
                System.out.println("1. Iniciar nova batalha");
                System.out.println("2. Sair");
                System.out.println("3. Ler registros de batalhas");

                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                if (escolha == 1) {
                    System.out.println("Iniciando nova batalha...");
                    break;
                    //O while Persiste

                } else if (escolha == 2) {
                    System.out.println("Encerrando programa...");
                    sair = false;
                    break;
                    //Sai do While

                } else if (escolha == 3) {
                    registroDeBatalha.lerRegistro();
                    //Sai do While


                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    // Método auxiliar para buscar personagem pelo nome
    private static PersonagemBase buscarPersonagemPorNome(List<PersonagemBase> personagens, String nome) {
        try {
            // Verificar se o nome está vazio ou é um número
            if (nome == null || nome.trim().isEmpty()) {
                throw new NullException("O nome do personagem não pode ser vazio!!!");
            }
            if (nome.matches("\\d+")) {
                throw new NumException("O nome do personagem não pode conter apenas números!!!");
            }

            // Buscar o personagem pelo nome
            for (PersonagemBase p : personagens) {
                if (p.nome.equalsIgnoreCase(nome)) {
                    return p;
                }
            }

            // Se não encontrou, lança exceção
            throw new DontExistException("Personagem com nome '" + nome + "' BLOQUEADO, compre a mais nova DLC para ter a acesso a " + nome);
        } catch (NullException | NumException | DontExistException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
        return null;
    }
}