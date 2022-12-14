import javax.swing.JTextArea;
import java.util.List;
import java.util.ArrayList;

public class Confronto {
    Personagem vencedor;
    Personagem perdedor;
    Personagem p1;
    Personagem p2;
    List<String> listaStringConfronto = new ArrayList<>();

    public Confronto(Personagem p1, Personagem p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public List<String> confrontar() {
        int turno = 1;
        // Verificação de editoras
        verificaEditoras();
        verificaClassesPersonagens();
        if (p1.isTipoMimico() && p2.isTipoMimico()) {
            listaStringConfronto.add("Deu empate. Dois mimicos não lutam entre si!");
            return listaStringConfronto;
        }
        if (p1.isTipoMimico()) {
            p1.clonarPoderes(p2);
        }
        if (p2.isTipoMimico()) {
            p2.clonarPoderes(p1);
        }

        // Exibir o nome dos oponentes e seus PFs
        // Oponente 1
        listaStringConfronto
                .add(String.format(
                        "%s %s tem %d de pontos de força e %d de energia e está pronto para o combate!%n",
                        p1.getPronome(),
                        p1.getNome(),
                        p1.getPf(), p1.getPeInicial()));
        System.out.printf("%s %s tem %d de pontos de força, e está pronto para o combate!%n", p1.getPronome(),
                p1.getNome(),
                p1.getPf());

        // Oponente 2
        listaStringConfronto
                .add(String.format("%s %s tem %d de pontos de força e %d de energia, e está pronto para o combate!%n",
                        p2.getPronome(),
                        p2.getNome(),
                        p2.getPf(), p2.getPeInicial()));
        System.out.printf("%s %s tem %d de pontos de força, e está pronto para o combate!%n", p2.getPronome(),
                p2.getNome(),
                p2.getPf());

        while (p1.getPf() > 0 && p2.getPf() > 0) {
            listaStringConfronto.add(String.format("----------------------------------%n"));
            listaStringConfronto.add(String.format("%dº Turno %n", turno));
            listaStringConfronto.add(String.format("----------------------------------%n"));
            listaStringConfronto.addAll(p1.atacar(p2));

            listaStringConfronto.addAll(p2.atacar(p1));
            turno = turno + 1;
        }
        determinaVencedor();
        p1.recuperarTudo();
        p2.recuperarTudo();
        return listaStringConfronto;
    }

    public void verificaEditoras() {
        if (!p1.getEditora().equals(p2.getEditora())) {
            listaStringConfronto.add(String.format("----------------------------------%n"));
            listaStringConfronto.add(String.format("Confronto CrossOver.%n"));
            listaStringConfronto.add(String.format("----------------------------------%n"));
            System.out.printf("Confronto CrossOver.%n");
        } else {
            System.out.println("Confronto " + p1.getEditora());
            listaStringConfronto.add(String.format("----------------------------------%n"));
            listaStringConfronto.add(String.format("Confronto %s%n", p1.getEditora()));
            listaStringConfronto.add(String.format("----------------------------------%n"));

        }
    }

    public void verificaClassesPersonagens() {
        if (p1.getClass() != p2.getClass()) {
            listaStringConfronto.add(String.format("Duelo entre o bem e o mal!%n"));
            listaStringConfronto.add(String.format("----------------------------------%n"));
        }
        if ((p1.getClass().getName() == "Heroi") && (p2.getClass().getName() == "Heroi")) {
            listaStringConfronto.add(String.format("Confronto de heróis!!%n"));
            listaStringConfronto.add(String.format("----------------------------------%n"));
        }
        if ((p1.getClass().getName() == "Vilao") && (p2.getClass().getName() == "Vilao")) {
            listaStringConfronto.add(String.format("Confronto de vilões!!%n"));
            listaStringConfronto.add(String.format("----------------------------------%n"));
        }
    }

    public void determinaVencedor() {

        if (p1.getPf() <= 0) {

            this.vencedor = p2;
            this.perdedor = p1;
        } else {
            this.vencedor = p1;
            this.perdedor = p2;

        }
        if (vencedor.isTipoParasita()) {
            vencedor.drenar(perdedor);
            listaStringConfronto.add(
                    String.format("%n%s %s drenou a energia de %s! Sua energia agora é %d%n",
                            vencedor.getPronome(), vencedor.getNome(), perdedor.getNome(),
                            vencedor.getPeInicial()));
        }
        listaStringConfronto.add(String.format("----------------------------------%n"));
        listaStringConfronto.add(
                String.format("%s %s foi o vencedor desse confronto!%n", vencedor.getPronome(), vencedor.getNome()));
        listaStringConfronto.add(String.format("----------------------------------%n"));
        System.out.printf("%n%s %s foi o vencedor desse confronto!%n", vencedor.getPronome(), vencedor.getNome());
    }
}
