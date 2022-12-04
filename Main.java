import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Main {
        public static void main(String[] args) throws Exception {
                ArrayList<Personagem> listaPersonagens = new ArrayList<>();
                String marvel = "Marvel Comics";
                String dc = "DC Comics";
                String pronomeO = "O";
                String pronomeA = "A";
                Poder fSuperman = new Poder("Força", 10, 8);
                Poder visaoSuperman = new Poder("Visão de Raios", 5, 5);
                Poder soproSuperman = new Poder("Super Sopro", 4, 4);
                Heroi superman = new Heroi(pronomeO, "Superman", dc, 100, 70, "Clark Kent",
                                new ImageIcon("images\\superman_img.jpg"), fSuperman, visaoSuperman,
                                soproSuperman);
                listaPersonagens.add(superman);

                Poder fHomemAranha = new Poder("Força", 7, 5);
                Poder soltarTeia = new Poder("Soltar Teia", 5, 5);
                Heroi homemAranha = new Heroi(pronomeO, "Homem-Aranha", marvel, 80, 50, "Peter Parker",
                                new ImageIcon("images\\homenaranha_img.jpg"), fHomemAranha,
                                soltarTeia);
                listaPersonagens.add(homemAranha);

                Poder fFenix = new Poder("Força", 12, 10);
                Heroi fenix = new Heroi(pronomeA, "Fênix", marvel, 150, 100, "Jean Grey",
                                new ImageIcon("images\\fenix_img.jpg"), fFenix);
                listaPersonagens.add(fenix);

                Heroi mimico = new Heroi(pronomeO, "Mímico", marvel, 70, 50, "Calvin Montgomery Rankin",
                                new ImageIcon("images\\mimico_img.jpg"));
                mimico.setTipoMimico(true);
                listaPersonagens.add(mimico);

                // Adicionando Vilões

                Poder fSuperBizarro = new Poder("Força", 10, 8);
                Poder visaoBizarro = new Poder("Visao de Raios", 5, 5);
                Poder soproBizarro = new Poder("Supersopro", 4, 4);
                Vilao superBizarro = new Vilao(pronomeO, "Superbizarro", dc, 95, 65, 50,
                                new ImageIcon("images\\superbizarro_img.jpg"), fSuperBizarro,
                                soproBizarro, visaoBizarro);
                listaPersonagens.add(superBizarro);

                Poder fDuende = new Poder("Força", 7, 5);
                Poder granada = new Poder("Granada de Abóbora", 5, 5);
                Vilao duendeVerde = new Vilao(pronomeO, "Duende Verde", marvel, 80, 60, 70,
                                new ImageIcon("images\\duendeverde_img.jpg"), fDuende, granada);
                listaPersonagens.add(duendeVerde);

                Poder tentaculos = new Poder("Tentáculos", 6, 4);
                Vilao doutorOctopus = new Vilao(pronomeO, "Doutor Octopus", marvel, 40, 40, 40,
                                new ImageIcon("images\\droctopus_img.jpg"), tentaculos);
                listaPersonagens.add(doutorOctopus);

                Vilao superSkrull = new Vilao(pronomeO, "SuperSkrull", marvel, 90, 60, 100,
                                new ImageIcon("images\\superskrull_img.jpg"));
                superSkrull.setTipoMimico(true);
                listaPersonagens.add(superSkrull);

                Poder fParasita = new Poder("Força", 7, 8);
                Poder rajada = new Poder("Rajada Energética", 6, 8);
                Vilao parasita = new Vilao(pronomeO, "Parasita", dc, 70, 90, 70,
                                new ImageIcon("images\\parasita_img.jpg"), fParasita, rajada);
                listaPersonagens.add(parasita);
                InterfaceGUI guii = new InterfaceGUI(listaPersonagens);
        }
}
