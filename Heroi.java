import javax.swing.ImageIcon;

public class Heroi extends Personagem {

    private String NomeReal;

    // Getters and Setters

    public String getNomeReal() {
        return NomeReal;
    }

    public void setNomeReal(String NomeReal) {
        this.NomeReal = NomeReal;
    }

    // Construtor
    public Heroi(String pronome, String nome, String editora, int pf, int pe, String NomeReal, ImageIcon foto,
            Poder... poder) {
        super(pronome, nome, editora, pf, pe, foto, poder);
        this.NomeReal = NomeReal;
    }
}
