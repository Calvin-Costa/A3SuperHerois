import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public abstract class Personagem {
    private String nome;
    private String editora;
    private int pf;
    private int pe;
    private int peInicial;
    private int pfInicial;
    private ImageIcon foto = new ImageIcon();

    // Criando o Array de personagens
    private ArrayList<Poder> poderes = new ArrayList<Poder>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getPf() {
        return pf;
    }

    public void setPf(int pf) {
        this.pf = pf;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getPeInicial() {
        return peInicial;
    }

    public void setPeInicial(int peInicial) {
        this.peInicial = peInicial;
    }

    public int getPfInicial() {
        return pfInicial;
    }

    public void setPfInicial(int pfInicial) {
        this.pfInicial = pfInicial;
    }

    public void adicionarPoder(Poder p) {
        this.poderes.add(p);
    }

    public void removerPoder(Poder p) {
        this.poderes.remove(p);
    }

    public void copiarPoderes(Personagem copia) {
        this.poderes = copia.poderes;
    }

    // Constutor Personagem
    public Personagem(String nome, String editora, int pf, int pe) {
        this.nome = nome;
        this.editora = editora;
        this.pf = pf;
        this.pe = pe;
    }

    // Construtor Personagem com qtd variável de poderes
    public Personagem(String nome, String editora, int pf, int pe, ImageIcon foto, Poder... poder) {
        this.nome = nome;
        this.editora = editora;
        this.pf = pf;
        this.pe = pe;
        this.pfInicial = pf;
        this.peInicial = pe;
        this.foto = foto;
        for (int i = 0; i < poder.length; i++) {
            this.adicionarPoder(poder[i]);
        }
    }

    public void Atacar(Personagem p2) {

        //
        // System.out.printf("O herói %s possui: %d de energia\n", getNome(), getPe());

        Random random = new Random();
        int randomNumber = random.nextInt(this.poderes.size());

        // System.out.println(this.poderes.get(randomNumber).getPe());

        if (getPe() > this.poderes.get(randomNumber).getPe()) {
            System.out.printf("O(A) %s ataca com com %s e causou %d de dano!%n", getNome(),
                    this.poderes.get(randomNumber).getNome(), this.poderes.get(randomNumber).getDano());

            pe = getPe() - this.poderes.get(randomNumber).getPe();

            int aux;

            aux = p2.getPf() - this.poderes.get(randomNumber).getDano();

            p2.setPf(aux);

            System.out.printf("A nova energia do %s é de: %d%n", getNome(), pe);
            System.out.printf("A nova força do %s é de: %d%n", p2.getNome(), p2.getPf());

        } else {
            System.out.printf("O %s está esgotado. Utilize esse turno para recuperar%n", getNome());

            Recuperar();

        }

    }

    public void Recuperar() {

        pe = peInicial * 30 / 100;

        System.out.printf("A nova energia do %s é de %d pontos%n", getNome(), getPe());

    }

    public void getPoderes() {

        System.out.printf("O %s com dano de %d e energia de %s%n ", this.poderes.get(0).getNome(),
                this.poderes.get(0).getDano(), this.poderes.get(0).getPe());
    }

}
