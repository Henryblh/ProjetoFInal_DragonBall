package Registro;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;

public class RegistroDeBatalha {
    private final Path caminhoArquivo;

    public RegistroDeBatalha(String caminhoArquivo) {
        this.caminhoArquivo = Paths.get("RegistrodeBatalha.txt");
        verificarArquivo();
    }

    // Verificar se o arquivo existe; se não, cria um novo
    private void verificarArquivo() {
        try {
            if (!Files.exists(caminhoArquivo)) {
                Files.createFile(caminhoArquivo);
            }
        } catch (IOException e) {
            System.err.println("Erro ao verificar/criar o arquivo: " + e.getMessage());
        }
    }

    // Salvar registro de batalha com os personagens
    public void salvarRegistro( List<Ataque> topAtaques, String per1, String per2) {
        StringBuilder conteudo = new StringBuilder();

        // Adicionar no início a batalha e os personagens
                conteudo.append("Batalha: ").append(per1).append(" vs ").append(per2).append("\n");

        // Adicionar detalhes dos ataques
        for (Ataque ataque : topAtaques) {
            conteudo.append("- ").append(ataque.getUsuario())
                    .append(" causou ")
                    .append(ataque.getDano())
                    .append(" de dano\n");
        }
        conteudo.append("\n");

        try {
            // Usar Files.writeString() para adicionar ao final do arquivo
            Files.writeString(caminhoArquivo, conteudo.toString(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao salvar registro de batalha: " + e.getMessage());
        }
    }

    // Ler registros de batalha
    public void lerRegistro() {
        try {
            List<String> linhas = Files.readAllLines(caminhoArquivo, StandardCharsets.UTF_8);
            System.out.println("O arquivo manipulado está localizado em: " + caminhoArquivo.toAbsolutePath());

            System.out.println("\n--- Registro do Maior dano em Batalhas ---");
            if (linhas.isEmpty()) {
                System.out.println("Nenhuma batalha registrada ainda.");
            } else {
                for (String linha : linhas) {
                    System.out.println(linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o registro de batalhas: " + e.getMessage());
        }
    }
}