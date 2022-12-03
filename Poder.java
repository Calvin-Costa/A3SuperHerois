public class Poder {
    private String nome;
    private int dano;
    private int pe;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    // Criando o costrutor

    public Poder(String nome, int dano, int pe) {
        this.nome = nome;
        this.dano = dano;
        this.pe = pe;
    }
    public Poder() {
    }
}
