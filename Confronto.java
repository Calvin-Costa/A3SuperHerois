import javax.swing.JTextArea;
import java.util.List;
import java.util.ArrayList;

public class Confronto {
    Personagem vencedor;
    Personagem p1;
    Personagem p2;
    JTextArea jta = new JTextArea();
    List<String> listaStringConfronto = new ArrayList<>();

    public Confronto(Personagem p1, Personagem p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public List<String> confrontar() {
        if (p1.isTipoMimico() && p2.isTipoMimico()) {
            listaStringConfronto.add("Deu empate. Dois mimicos não lutam entre si!");
            return listaStringConfronto;
        }
        if (p1.isTipoMimico()) {
            p1.copiarPoderes(p2);
        }
        if (p2.isTipoMimico()) {
            p2.copiarPoderes(p1);
        }

        // recuperar tudo no p1
        p1.setPe(p1.getPeInicial());
        p1.setPf(p1.getPfInicial());
        // recuperar tudo no p2
        p2.setPe(p2.getPeInicial());
        p2.setPf(p2.getPfInicial());

        // Verificação de editoras
        if (!p1.getEditora().equals(p2.getEditora())) {
            listaStringConfronto.add(String.format("Confronto CrossOver.%n"));
            System.out.printf("Confronto CrossOver.%n");
        } else {
            System.out.println("Confronto " + p1.getEditora());
            listaStringConfronto.add(String.format("Confronto %s%n", p1.getEditora()));

        }

        // Exibur o nome dos oponentes e seus PFs

        // Oponente 1
        listaStringConfronto
                .add(String.format("%s %s tem %d de pontos de força, e está pronto para o combate!%n", p1.getPronome(),
                        p1.getNome(),
                        p1.getPf()));
        System.out.printf("%s %s tem %d de pontos de força, e está pronto para o combate!%n", p1.getPronome(),
                p1.getNome(),
                p1.getPf());

        // Oponente 2
        listaStringConfronto
                .add(String.format("%s %s tem %d de pontos de força, e está pronto para o combate!%n", p2.getPronome(),
                        p2.getNome(),
                        p2.getPf()));
        System.out.printf("%s %s tem %d de pontos de força, e está pronto para o combate!%n", p2.getPronome(),
                p2.getNome(),
                p2.getPf());

        while (p1.getPf() > 0 && p2.getPf() > 0) {

            listaStringConfronto.addAll(p1.atacar(p2));

            listaStringConfronto.addAll(p2.atacar(p1));

        }

        if (p1.getPf() < 0) {

            this.vencedor = p2;

        } else {

            this.vencedor = p1;
        }
        listaStringConfronto.add(
                String.format("%n%s %s foi o vencedor desse confronto!%n", vencedor.getPronome(), vencedor.getNome()));
        System.out.printf("%n%s %s foi o vencedor desse confronto!%n", vencedor.getPronome(), vencedor.getNome());

        return listaStringConfronto;
    }

    public JTextArea gTextArea() {
        return jta;
    }
}
