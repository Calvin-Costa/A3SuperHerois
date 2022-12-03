import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Main {
        public static void main(String[] args) throws Exception {
                ArrayList<Personagem> listaPersonagens = new ArrayList<>();
                String marvel = "Marvel Comics";
                String dc = "DC Comics";

                Poder fSuperman = new Poder("Força", 10, 8);
                Poder visaoSuperman = new Poder("Visão de Raios", 5, 5);
                Poder soproSuperman = new Poder("Super Sopro", 4, 4);
                Heroi superman = new Heroi("Superman", dc, 100, 70, "Clark Kent",
                                new ImageIcon("images\\superman_img.jpg"), fSuperman, visaoSuperman,
                                soproSuperman);
                listaPersonagens.add(superman);

                Poder fHomemAranha = new Poder("Força", 7, 5);
                Poder soltarTeia = new Poder("Soltar Teia", 5, 5);
                Heroi homemAranha = new Heroi("Homem-Aranha", marvel, 80, 50, "Peter Parker",
                                new ImageIcon("images\\homenaranha_img.jpg"), fHomemAranha,
                                soltarTeia);
                listaPersonagens.add(homemAranha);

                Poder fFenix = new Poder("Força", 12, 10);
                Heroi fenix = new Heroi("Fênix", marvel, 150, 100, "Jean Grey",
                                new ImageIcon("images\\fenix_img.jpg"), fFenix);
                listaPersonagens.add(fenix);

                // Adicionando Vilões

                Poder fSuperBizarro = new Poder("Força", 10, 8);
                Poder visaoBizarro = new Poder("Visao de Raios", 5, 5);
                Poder soproBizarro = new Poder("Supersopro", 4, 4);
                Vilao superBizarro = new Vilao("Superbizarro", dc, 95, 65, 50,
                                new ImageIcon("images\\superbizarro_img.jpg"), fSuperBizarro,
                                soproBizarro, visaoBizarro);
                listaPersonagens.add(superBizarro);

                Poder fDuende = new Poder("Força", 7, 5);
                Poder granada = new Poder("Granada de Abóbora", 5, 5);
                Vilao duendeVerde = new Vilao("Duende Verde", marvel, 80, 60, 70,
                                new ImageIcon("images\\duendeverde_img.jpg"), fDuende, granada);
                listaPersonagens.add(duendeVerde);

                Poder tentaculos = new Poder("Tentáculos", 6, 4);
                Vilao doutorOctopus = new Vilao("Doutor Octopus", marvel, 40, 40, 40,
                                new ImageIcon("images\\droctopus_img.jpg"), tentaculos);
                listaPersonagens.add(doutorOctopus);

                Vilao Mimico = new Vilao("Mímico", marvel, 70, 50, 70, new ImageIcon("images\\droctopus_img.jpg"));

                InterfaceGUI guii = new InterfaceGUI(listaPersonagens);

                Confronto c1 = new Confronto(homemAranha, Mimico);
                c1.confrontar();
        }
}
