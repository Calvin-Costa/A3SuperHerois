import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterfaceGUI extends JFrame {
    public List<String> listaNomesDosPersonagens = new ArrayList<>();
    public List<Personagem> listaDePersonagens = new ArrayList<>();
    Personagem personagemSelEsq; // Personagem selecionado na lista esquerda
    Personagem personagemSelDir; // Personagem selecionado na lista direita
    String nomePersonagemSelEsq; // Nome do Personagem selecionado na lista esquerda
    String nomePersonagemSelDir; // Nome do Personagem selecionado na lista direita
    JPanel painelPersonagensEsq = new JPanel(); // Painel que contém a lista esquerda para selecionar personagens
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

    JTextArea combateDesc = new JTextArea();
    JScrollPane scrlPane = new JScrollPane(combateDesc);
    JButton botaoIniciaConfronto = new JButton("Começar Combate");
    JButton botaoResetaConfronto = new JButton("Resetar Personagens");
    ImageIcon img = new ImageIcon("images\\heroicon.png");

    // Construtor
    public InterfaceGUI(List<Personagem> listaPersonagens) {
        this.listaDePersonagens = listaPersonagens;
        setListaNomeIgualANomePersonagens(listaPersonagens);
        this.setBounds(0, 0, 1024, 720);
        this.setTitle("A3 Super Heróis!");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(img.getImage());
        this.setLayout(new GridBagLayout());
        setButtonStyleOne(botaoIniciaConfronto);
        setButtonStyleOne(botaoResetaConfronto);
        JList listaPersonagemEsq = new JList(listaNomesDosPersonagens.toArray());
        JList listaPersonagemDir = new JList(listaNomesDosPersonagens.toArray());
        listaPersonagemEsq.setFixedCellHeight(30);
        listaPersonagemEsq.setFixedCellWidth(120);
        listaPersonagemEsq.setBorder(new EmptyBorder(30, 0, 30, 0));
        listaPersonagemEsq.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String selectedStringL = (String) listaPersonagemEsq.getSelectedValue();
                findCharName(selectedStringL, 0);
                nomeEsq.setText(personagemSelEsq.getNome());
                pfEsq.setText("PF: " + personagemSelEsq.getPf());
                peEsq.setText("PE: " + personagemSelEsq.getPe());
                fotoEsq.setIcon(personagemSelEsq.getFoto());
            }

        });

        listaPersonagemDir.setFixedCellHeight(30);
        listaPersonagemDir.setFixedCellWidth(120);
        listaPersonagemDir.setBorder(new EmptyBorder(30, 0, 30, 0));
        listaPersonagemDir.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String selectedStringR = (String) listaPersonagemDir.getSelectedValue();
                findCharName(selectedStringR, 1);
                nomeDir.setText(personagemSelDir.getNome());
                pfDir.setText("PF: " + personagemSelDir.getPf());
                peDir.setText("PE: " + personagemSelDir.getPe());
                fotoDir.setIcon(personagemSelDir.getFoto());
            }
        });
        GroupLayout gLaySelEsq = new GroupLayout(painelPersonagensEsq);
        painelPersonagensEsq.setLayout(gLaySelEsq);
        gLaySelEsq.setHorizontalGroup(
                gLaySelEsq.createSequentialGroup()
                        .addGroup(gLaySelEsq.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(selPersJLabelEsq).addComponent(listaPersonagemEsq)));

        gLaySelEsq.setVerticalGroup(gLaySelEsq.createSequentialGroup()
                .addGroup(gLaySelEsq.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(selPersJLabelEsq))
                .addGroup(gLaySelEsq.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(listaPersonagemEsq)));

        GroupLayout gLayBotoes = new GroupLayout(painelBotoes);
        gLayBotoes.setHorizontalGroup(gLayBotoes.createSequentialGroup().addComponent(botaoIniciaConfronto)
                .addComponent(botaoResetaConfronto));
        gLayBotoes.setVerticalGroup(gLayBotoes.createSequentialGroup().addComponent(botaoIniciaConfronto)
                .addComponent(botaoResetaConfronto));

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

        addConstraints(this, painelPersonagensEsq, 0, 0, 1, 1, GridBagConstraints.BOTH, 0.1f, 0);
        painelPersonagensEsq.setBackground(new Color(64, 73, 202));
        addConstraints(this, painelInfos, 1, 0, 1, 1, GridBagConstraints.BOTH);
        painelInfos.setBackground(Color.white);
        painelInfos.add(painelInfosEsq);
        painelInfosEsq.setPreferredSize(new Dimension(225, 315));
        painelInfosEsq.setBackground(Color.white);
        painelInfos.add(painelInfosDir);
        painelInfosDir.setPreferredSize(new Dimension(225, 315));
        painelInfosDir.setBackground(Color.white);

        // Adding "Characters List on Right Side" Panel
        addConstraints(this, painelPersonagensDir, 2, 0, 1, 1, GridBagConstraints.BOTH, 0.1f, 0);
        painelPersonagensDir.add(new JLabel("Teste 3"));

        painelPersonagensDir.add(listaPersonagemDir);
        painelPersonagensDir.setBackground(new Color(64, 73, 202));

        botaoIniciaConfronto.setSize(512, 30);
        botaoIniciaConfronto.addActionListener(w -> {
            try {
                Confronto c1 = new Confronto(personagemSelEsq, personagemSelDir);
                c1.confrontar();
            } catch (Exception e) {
                System.out.println("Algum erro ocorreu");
            }
        });

        botaoResetaConfronto.setSize(512, 30);
        addConstraints(this, painelBotoes, 0, 1, 3, 1, GridBagConstraints.BOTH, 0.1f, 0);
        addConstraints(this, painelConfronto, 0, 2, 3, 3, GridBagConstraints.BOTH, 0, 5);
        painelConfronto.add(new JLabel("DESCRIÇÃO DO COMBATE AQUI"));
        painelConfronto.setBackground(Color.gray);

        this.setVisible(true);
    }

    // Method that makes it easier and cleaner to add constraints
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

    // Method that makes it easier and cleaner to add constraints with parameters
    // weight being sent as well
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

    // Method that makes it easier and cleaner to add constraints with Insets being
    // sent as well
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

    // Method that makes it cleaner to stylize Buttons
    public void setButtonStyleOne(JButton button) {
        button.setFocusable(false);
        button.setBackground(new Color(61, 181, 210));
        button.setForeground(new Color(185, 80, 0));

    }

    // Method that takes an ArrayList<Personagem> and get the names from every
    // instance of character created, returning a list
    public void setListaNomeIgualANomePersonagens(List<Personagem> personagens) {
        for (int i = 0; i < personagens.size(); i++) {
            this.listaNomesDosPersonagens.add(personagens.get(i).getNome());
        }
    }

    public void findCharName(String name, int i) {
        for (Personagem p : listaDePersonagens) {
            if (p.getNome().equals(name)) {
                if (i == 0) {
                    this.personagemSelEsq = p;
                } else {
                    this.personagemSelDir = p;
                }
            }
        }
    }
}
