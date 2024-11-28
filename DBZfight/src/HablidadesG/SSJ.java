package HablidadesG;

import Races.PersonagemBase;

public class SSJ implements HabilidadeP {

    @Override
    public void usar(PersonagemBase usuario, PersonagemBase inimigo) {
        System.out.println(usuario.nome + " está se transformando em Super Sayajin! Seus atributos aumentaram!");

        // Atualizando os atributos do personagem 'usuario'
        usuario.velocidade = (int) (usuario.velocidade * 1.25);  // Aumento de 25% na velocidade
        usuario.forca = (int) (usuario.forca * 1.5);  // Aumento de 50% na força
        usuario.setKi(usuario.getKi()*2);

        // Mostra os novos valores dos atributos após a transformação
        System.out.println(usuario.nome + " agora tem " + usuario.velocidade + " de velocidade, "
                + usuario.forca + " de força, e " + usuario.getKi() + " de ki!");
    }
}