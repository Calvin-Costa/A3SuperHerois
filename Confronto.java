public class Confronto {
    Personagem vencedor;

    public void confrontar(Personagem p1, Personagem p2) {

        // recuperar tudo
        p1.setPe(p1.getPeInicial());
        p1.setPf(p1.getPfInicial());

        // teste de recuperar tudo

        // System.out.println("O valor da energia resetada do oponente 1 é : " +
        // p1.getPe());
        // System.out.println("O valor da força resetada do oponente 1 é : " +
        // p1.getPf());

        p2.setPe(p2.getPeInicial());
        p2.setPf(p2.getPfInicial());

        // Verificação de editoras
        if (!p1.getEditora().equals(p2.getEditora())) {
            System.out.println("Confronto CrossOver.");
        } else {
            System.out.println("Confronto " + p1.getEditora());
        }

        // Exibur o nonme dos oponentes e seus PFs

        // Oponente 1
        System.out.printf("O(a) %s tem %d de pontos de força, e está pronto para o combate!%n", p1.getNome(),
                p1.getPf());

        // Oponente 2
        System.out.printf("O(a) %s tem %d de pontos de força, e está pronto para o combate!%n", p2.getNome(),
                p2.getPf());

        while (p1.getPf() > 0 && p2.getPf() > 0) {

            p1.Atacar(p2);

            p2.Atacar(p1);

        }

        if (p1.getPf() < 0) {

            this.vencedor = p1;

        } else {

            this.vencedor = p1;
        }
        System.out.printf("%nO(A) %s foi o vencedor desse confronto!%n", vencedor.getNome());
    }
}
