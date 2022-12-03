import javax.swing.ImageIcon;

public class Vilao extends Personagem {
    private int nivelDeMaldade;

    public int getNivelDeMaldade() {
        return nivelDeMaldade;
    }

    public void setNivelDeMaldade(int nivelDeMaldade) {
        this.nivelDeMaldade = nivelDeMaldade;
    }

    public Vilao(String pronome, String nome, String editora, int pf, int pe, int nivelDeMaldade, ImageIcon foto,
            Poder... poder) {
        super(pronome, nome, editora, pf, pe, foto, poder);
        this.nivelDeMaldade = nivelDeMaldade;
    }

}
