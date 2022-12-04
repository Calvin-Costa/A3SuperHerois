import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InterfaceGUI extends JFrame {
    public List<String> listaNomesDosPersonagens = new ArrayList<>();
    public List<Personagem> listaDePersonagens = new ArrayList<>();
    Personagem persSelEsq; // Personagem selecionado na lista esquerda
    Personagem persSelDir; // Personagem selecionado na lista direita
    String nomePersonagemSelEsq; // Nome do Personagem selecionado na lista esquerda
    String nomePersonagemSelDir; // Nome do Personagem selecionado na lista direita
    JPanel painelPersonagensEsq = new JPanel(); // Painel que contém a
    // lista esquerda para selecionar personagens
    JLabel selPersJLabelEsq = new JLabel("Selecione o Personagem");
    JPanel painelPersonagensDir = new JPanel(); // Painel que contém a lista direita para selecionar personagens
    JLabel selPersJLabelDir = new JLabel("Selecione o Personagem");
    JPanel painelInfos = new JPanel(); // Painel que contém as propriedades dos personagens selecionados nas listas
    JPanel painelInfosEsq = new JPanel(); // Subpainel que contém as propriedades dos personagens da esquerda
    JLabel perEsq = new JLabel("Jogador nº1");
    JLabel fotoEsq = new JLabel(); // label que contém a imagem do personagem selecionado na esquerda
    JLabel nomeEsq = new JLabel("Personagem");
    JLabel pfEsq = new JLabel("PF:");
    JLabel peEsq = new JLabel("PE:");
    JPanel painelInfosDir = new JPanel(); // Subpainel que contém as propriedades dos personagens da direita
    JLabel perDir = new JLabel("Jogador nº2");
    JLabel fotoDir = new JLabel(); // label que contém a imagem do personagem selecionado na direita
    JLabel nomeDir = new JLabel("Personagem");
    JLabel pfDir = new JLabel("PF:");
    JLabel peDir = new JLabel("PE:");
    JPanel painelBotoes = new JPanel(); // Painel que contém os botões da interface
    JPanel painelConfronto = new JPanel(); // Painel que contém a descrição do confronto
    JPanel bordaPreta = new JPanel(); // Borda pra dividir os dois paineis de informações de personagem
    JPanel painelBranco = new JPanel(); // Painel para adicionar uma margente entre a borda e o próximo painel

    JTextArea descCombate = new JTextArea();
    JScrollPane scrlPane = new JScrollPane(descCombate);

    JButton botaoIniciaConfronto = new JButton("Começar Combate");
    JButton botaoResetaConfronto = new JButton("Resetar Personagens");
    ImageIcon img = new ImageIcon("images\\heroicon.png");
    // cores da GUI
    Color corFundoListas = new Color(95, 157, 247);
    Color corFundoPaineis = new Color(23, 70, 162);
    Color corFundoPaineisBotoes = new Color(255, 29, 29);
    Color corPainelInfos = new Color(255, 247, 233);

    // Construtor
    public InterfaceGUI(
            List<Personagem> listaPersonagens) {

        // Setando dados básicos do programa
        this.setBounds(0, 0, 1024, 720);
        this.setTitle("A3 Super Heróis!");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(img.getImage());
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.black);
        // Fazendo um tratamento das listas
        this.listaDePersonagens = listaPersonagens;
        setListaNomeIgualANomePersonagens(listaPersonagens);
        JList listaPersonagemEsq = new JList(listaNomesDosPersonagens.toArray());
        JList listaPersonagemDir = new JList(listaNomesDosPersonagens.toArray());
        setEstiloDasListas(listaPersonagemEsq);
        setEstiloDasListas(listaPersonagemDir);
        // Adicionando os listeners das listas
        listaPersonagemEsq.addListSelectionListener(e -> {
            persSelEsq = achaPersDeNomeIgualA((String) listaPersonagemEsq.getSelectedValue());
            setCharInfos(0);
        });
        listaPersonagemDir.addListSelectionListener(e -> {
            persSelDir = achaPersDeNomeIgualA((String) listaPersonagemDir.getSelectedValue());
            setCharInfos(1);
        });

        // Setando estilo dos botões
        setEstiloBotao(botaoIniciaConfronto);
        setEstiloBotao(botaoResetaConfronto);
        setInstrucoes();
        // Configurando o Layout manager(GroupLayout) interno do painel com a lista
        // esquerda de personagens
        GroupLayout gLaySelEsq = new GroupLayout(painelPersonagensEsq);
        painelPersonagensEsq.setLayout(gLaySelEsq);
        gLaySelEsq.setHorizontalGroup(
                gLaySelEsq.createSequentialGroup()
                        .addGap(10, 20, 20)
                        .addGroup(gLaySelEsq.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(selPersJLabelEsq).addComponent(listaPersonagemEsq)));

        gLaySelEsq.setVerticalGroup(gLaySelEsq.createSequentialGroup()
                .addGap(10, 20, 20)
                .addGroup(gLaySelEsq.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(selPersJLabelEsq))
                .addGap(10, 10, 10)
                .addGroup(gLaySelEsq.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(listaPersonagemEsq)));

        // Configurando o Layout manager(GroupLayout) interno do painel com a lista
        // direita de personagens
        GroupLayout gLaySelDir = new GroupLayout(painelPersonagensDir);
        painelPersonagensDir.setLayout(gLaySelDir);
        gLaySelDir.setHorizontalGroup(
                gLaySelDir.createSequentialGroup()
                        .addGap(10, 20, 20)
                        .addGroup(gLaySelDir.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(selPersJLabelDir).addComponent(listaPersonagemDir)));

        gLaySelDir.setVerticalGroup(gLaySelDir.createSequentialGroup()
                .addGap(10, 20, 20)
                .addGroup(gLaySelDir.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(selPersJLabelDir))
                .addGap(10, 10, 10)
                .addGroup(gLaySelDir.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(listaPersonagemDir)));

        selPersJLabelEsq.setForeground(Color.white);
        selPersJLabelDir.setForeground(Color.white);
        // Configurando o Layout manager(GroupLayout) interno do painel esquerdo de
        // informações do personagem selecionado na lista esquerda
        GroupLayout gLayInfoEsq = new GroupLayout(painelInfosEsq);
        painelInfosEsq.setLayout(gLayInfoEsq);
        gLayInfoEsq.setHorizontalGroup(
                gLayInfoEsq.createSequentialGroup()
                        .addGroup(gLayInfoEsq.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(perEsq)
                                .addComponent(nomeEsq)
                                .addComponent(pfEsq)
                                .addComponent(peEsq)
                                .addComponent(fotoEsq)));
        gLayInfoEsq.setVerticalGroup(
                gLayInfoEsq.createSequentialGroup()
                        .addGroup(gLayInfoEsq.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(perEsq))
                        .addGroup(gLayInfoEsq.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nomeEsq))
                        .addGroup(gLayInfoEsq.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(pfEsq))
                        .addGroup(gLayInfoEsq.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(peEsq))
                        .addGroup(gLayInfoEsq.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(fotoEsq)));

        // Configurando o Layout manager(GroupLayout) interno do painel direito de
        // informações do personagem selecionado na lista direita

        GroupLayout gLayInfoDir = new GroupLayout(painelInfosDir);
        painelInfosDir.setLayout(gLayInfoDir);
        gLayInfoDir.setHorizontalGroup(
                gLayInfoDir.createSequentialGroup()
                        .addGroup(gLayInfoDir.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(perDir)
                                .addComponent(nomeDir)
                                .addComponent(pfDir)
                                .addComponent(peDir)
                                .addComponent(fotoDir)));
        gLayInfoDir.setVerticalGroup(
                gLayInfoDir.createSequentialGroup()
                        .addGroup(gLayInfoDir.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(perDir))
                        .addGroup(gLayInfoDir.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nomeDir))
                        .addGroup(gLayInfoDir.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(pfDir))
                        .addGroup(gLayInfoDir.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(peDir))
                        .addGroup(gLayInfoDir.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(fotoDir)));

        // Configurando o Layout manager(GroupLayout) interno dos botões
        GroupLayout gLayBotoes = new GroupLayout(painelBotoes);
        gLayBotoes.setHorizontalGroup(gLayBotoes.createSequentialGroup().addComponent(botaoIniciaConfronto)
                .addComponent(botaoResetaConfronto));
        gLayBotoes.setVerticalGroup(gLayBotoes.createSequentialGroup().addComponent(botaoIniciaConfronto)
                .addComponent(botaoResetaConfronto));

        // Adicionando o painel que contém a lista esquerda de personagens ao
        // GridBagLayout

        addConstraints(this, painelPersonagensEsq, 0, 0, 1, 1, GridBagConstraints.BOTH, 0.1f, 0);
        painelPersonagensEsq.setBackground(corFundoPaineis);

        // Adicionando o painel de informações dos personagens ao GridBagLayout
        addConstraints(this, painelInfos, 1, 0, 1, 1, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10));
        painelInfos.setBackground(corPainelInfos);
        painelInfos.add(painelInfosEsq);
        painelInfosEsq.setPreferredSize(new Dimension(225, 315));
        bordaPreta.setBackground(corFundoPaineis);
        bordaPreta.setPreferredSize(new Dimension(1, 335));
        painelInfos.add(bordaPreta);
        painelBranco.setBackground(corPainelInfos);
        ;
        painelBranco.setPreferredSize(new Dimension(50, 335));
        painelInfos.add(painelBranco);
        painelInfosEsq.setBackground(corPainelInfos);
        painelInfos.add(painelInfosDir);
        painelInfosDir.setPreferredSize(new Dimension(225, 315));
        painelInfosDir.setBackground(corPainelInfos);

        addConstraints(this, painelPersonagensDir, 2, 0, 1, 1, GridBagConstraints.BOTH, 0.1f, 0);
        painelPersonagensDir.add(new JLabel("Teste 3"));

        painelPersonagensDir.add(listaPersonagemDir);
        painelPersonagensDir.setBackground(corFundoPaineis);

        botaoIniciaConfronto.setSize(512, 30);
        botaoIniciaConfronto.addActionListener(w -> {
            try {
                Confronto c1 = new Confronto(persSelEsq, persSelDir);
                descCombate.setText("");
                List<String> listaStrings = c1.confrontar();
                for (String a : listaStrings) {
                    descCombate.append(a);
                }
                setCharInfos(2);
            } catch (Exception e) {
                descCombate.append("Um ou mais personagem não foi selecionado. Tente novamente!");
            }
        });

        botaoResetaConfronto.setSize(512, 30);
        botaoResetaConfronto.addActionListener(e -> {
            try {
                achaPersDeNomeIgualA("Parasita").setPeInicial(70);
                setCharInfos(2);
                // descCombate.append("Energia do personagem Parasita resetada!");
            } catch (Exception w) {
                System.out.println("Algum erro ocorreu");
            }
        });
        addConstraints(this, painelBotoes, 0, 2, 3, 1, GridBagConstraints.BOTH, 0.1f, 0);
        addConstraints(this, painelConfronto, 0, 3, 3, 3, GridBagConstraints.BOTH, 0, 5);

        painelConfronto.setLayout(new BorderLayout());
        painelConfronto.add(scrlPane);

        painelBotoes.setBackground(corFundoPaineisBotoes);
        descCombate.setOpaque(false);
        descCombate.setForeground(Color.white);
        scrlPane.getViewport().setOpaque(false);
        scrlPane.setOpaque(false);
        painelConfronto.setBackground(corFundoPaineis);

        this.setVisible(true);
    }

    // Metodo para facilitar adição de constraints
    public void addConstraints(Container container, Component component, int gridx, int gridy, int width, int height,
            int fill) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        container.add(component, gbc);

    }

    // Metodo addConstraints sobrecarregado com pesos
    public void addConstraints(Container container, Component component, int gridx, int gridy, int width, int height,
            int fill, float weightx, float weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        container.add(component, gbc);

    }

    // Metodo addConstraints sobrecarregado com insets
    public void addConstraints(Container container, Component component, int gridx, int gridy, int width, int height,
            int fill, Insets insets) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.insets = insets;
        container.add(component, gbc);

    }

    // Metodo addConstraints sobrecarregado com peso e insets
    public void addConstraints(Container container, Component component, int gridx, int gridy, int width, int height,
            int fill, float weightx, float weighty, Insets insets) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.insets = insets;
        container.add(component, gbc);

    }

    // Method that takes an ArrayList<Personagem> and get the names from every
    // instance of character created, returning a list
    public void setListaNomeIgualANomePersonagens(List<Personagem> personagens) {
        for (int i = 0; i < personagens.size(); i++) {
            this.listaNomesDosPersonagens.add(personagens.get(i).getNome());
        }
    }

    public Personagem achaPersDeNomeIgualA(String name) {
        Personagem a = null;
        for (Personagem p : listaDePersonagens) {
            if (p.getNome().equals(name)) {
                a = p;
            }
        }
        return a;
    }

    public void setCharInfos(int index) {
        if (index == 0) {
            nomeEsq.setText(persSelEsq.getNome());
            pfEsq.setText("PF: " + persSelEsq.getPfInicial());
            peEsq.setText("PE: " + persSelEsq.getPeInicial());
            fotoEsq.setIcon(persSelEsq.getFoto());
        } else if (index == 1) {
            nomeDir.setText(persSelDir.getNome());
            pfDir.setText("PF: " + persSelDir.getPfInicial());
            peDir.setText("PE: " + persSelDir.getPeInicial());
            fotoDir.setIcon(persSelDir.getFoto());
        } else {
            nomeEsq.setText(persSelEsq.getNome());
            pfEsq.setText("PF: " + persSelEsq.getPfInicial());
            peEsq.setText("PE: " + persSelEsq.getPeInicial());
            fotoEsq.setIcon(persSelEsq.getFoto());
            nomeDir.setText(persSelDir.getNome());
            pfDir.setText("PF: " + persSelDir.getPfInicial());
            peDir.setText("PE: " + persSelDir.getPeInicial());
            fotoDir.setIcon(persSelDir.getFoto());
        }
    }

    // Metodo para estilizar os botões
    public void setEstiloBotao(JButton button) {
        button.setFocusable(false);
        button.setBackground(corFundoPaineis);
        button.setForeground(Color.white);

    }

    public void setEstiloDasListas(JList list) {
        list.setFixedCellHeight(30);
        list.setFixedCellWidth(120);
        list.setBackground(corFundoListas);
        list.setForeground(Color.black);
        list.setSelectionForeground(Color.white);
        list.setSelectionBackground(corFundoPaineisBotoes);
        list.setBorder(new EmptyBorder(15, 5, 15, 5));
    }

    public void setInstrucoes() {
        descCombate.append(String.format(
                "Bem vindo ao Projeto Confronto entre SuperHeróis e SuperVilões!%n%n%nEste projeto foi feito como trabalho da avaliação A3 da UC Programação de Soluções Computacionais.%n%nSua utilização é bem simples:%n%n1. Selecione um personagem na lista esquerda ou direita.%n2. Selecione um personagem na outra lista.%n3. Clique no botão 'Começar Combate'.%n4. Caso desejar, pode mudar os personagens escolhidos em alguma lista e iniciar um novo combate.%n%nInformações importantes:%n(a) Os Personagens 'Mímico' e 'Superskrull' copiam os poderes do personagem adversário.%n(b) Caso o Personagem 'Parasita' vença o duelo, ele irá drenar a energia final de seu oponente. %nPara resetar a energia dele, é só clicar no botão 'Resetar Personagens'.%nEspero que gostem do trabalho! "));
    }
}
