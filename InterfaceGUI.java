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
    Personagem personagemSelEsq;
    Personagem personagemSelDir;
    String nomePersonagemSelEsq;
    String nomePersonagemSelDir;
    JPanel painelPersonagensEsq = new JPanel();
    JPanel painelInfos = new JPanel();
    JPanel painelPersonagensDir = new JPanel();
    JPanel pButtons = new JPanel();
    JPanel pSelChar = new JPanel();
    JPanel pStart = new JPanel();
    JPanel pReset = new JPanel();
    JPanel pSelCharR = new JPanel();
    JPanel pBattleDesc = new JPanel();
    JPanel painelInfosEsq = new JPanel();
    JPanel painelInfosDir = new JPanel();
    JLabel lbl1 = new JLabel();
    JLabel lbl1Nome = new JLabel("Personagem");
    JLabel lbl1PF = new JLabel("PF:");
    JLabel lbl1PE = new JLabel("PE:");
    JLabel lbl2 = new JLabel();
    JLabel lbl2Nome = new JLabel("Personagem");
    JLabel lbl2PF = new JLabel("PF:");
    JLabel lbl2PE = new JLabel("PE:");
    JButton botaoSelecionaPersonagemEsq = new JButton("Selecionar Personagem");
    JButton botaoIniciaConfronto = new JButton("Começar Combate");
    JButton botaoResetaConfronto = new JButton("Resetar Personagens");
    JButton botaoSelecionaPersonagemDir = new JButton("Selecionar Personagem");
    ImageIcon img = new ImageIcon("Atividade A3\\images\\heroicon.png");

    // Construtor
    public InterfaceGUI(List<Personagem> listaPersonagens) {
        this.listaDePersonagens = listaPersonagens;
        setList(listaPersonagens);
        setButtonStyleOne(botaoSelecionaPersonagemEsq);
        this.setBounds(0, 0, 1024, 720);
        this.setTitle("A3 Super Heróis!");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(img.getImage());
        this.setLayout(new GridBagLayout());
        setButtonStyleOne(botaoIniciaConfronto);
        setButtonStyleOne(botaoResetaConfronto);
        setButtonStyleOne(botaoSelecionaPersonagemDir);
        botaoSelecionaPersonagemDir.setName("Botão Seleciona Direito");
        botaoSelecionaPersonagemEsq.setName("Botão Seleciona Esquerdo");
        JList listaPersonagemEsq = new JList(listaNomesDosPersonagens.toArray());
        JList listaPersonagemDir = new JList(listaNomesDosPersonagens.toArray());
        listaPersonagemEsq.setFixedCellHeight(30);
        listaPersonagemEsq.setFixedCellWidth(120);
        listaPersonagemEsq.setBorder(new EmptyBorder(30, 0, 30, 0));
        listaPersonagemEsq.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String selectedStringL = (String) listaPersonagemEsq.getSelectedValue();
                findCharName(selectedStringL, 0);
                lbl1Nome.setText(personagemSelEsq.getNome());
                lbl1PF.setText("PF: " + personagemSelEsq.getPf());
                lbl1PE.setText("PE: " + personagemSelEsq.getPe());
                lbl1.setIcon(personagemSelEsq.getFoto());
            }

        });

        listaPersonagemDir.setFixedCellHeight(30);
        listaPersonagemDir.setFixedCellWidth(120);
        listaPersonagemDir.setBorder(new EmptyBorder(30, 0, 30, 0));
        listaPersonagemDir.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String selectedStringR = (String) listaPersonagemDir.getSelectedValue();
                findCharName(selectedStringR, 1);
                lbl2Nome.setText(personagemSelDir.getNome());
                lbl2PF.setText("PF: " + personagemSelDir.getPf());
                lbl2PE.setText("PE: " + personagemSelDir.getPe());
                lbl2.setIcon(personagemSelDir.getFoto());
            }

        });

        addConstraints(this, painelPersonagensEsq, 0, 0, 1, 1, GridBagConstraints.BOTH, 0.1f, 0);
        painelPersonagensEsq.add(listaPersonagemEsq);
        painelPersonagensEsq.setBackground(new Color(64, 73, 202));

        //// Adding "Selected Characters Information" Panel

        addConstraints(this, painelInfos, 1, 0, 1, 1, GridBagConstraints.BOTH);
        painelInfos.setBackground(Color.white);
        GroupLayout gplay = new GroupLayout(painelInfosEsq);
        painelInfosEsq.setLayout(gplay);

        gplay.setHorizontalGroup(
                gplay.createSequentialGroup()
                        .addGroup(gplay.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lbl1Nome)
                                .addComponent(lbl1PF)
                                .addComponent(lbl1PE)
                                .addComponent(lbl1)));
        gplay.setVerticalGroup(
                gplay.createSequentialGroup()
                        .addGroup(gplay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl1Nome))
                        .addGroup(gplay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl1PF))
                        .addGroup(gplay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl1PE))
                        .addGroup(gplay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl1)));
        painelInfos.add(painelInfosEsq);
        painelInfosEsq.setPreferredSize(new Dimension(225, 350));

        // addConstraints(painelInfos, painelInfosDir, 0, 0, 1, 1,
        // GridBagConstraints.BOTH);
        painelInfos.add(painelInfosDir);
        painelInfosDir.setPreferredSize(new Dimension(225, 350));
        painelInfosDir.add(lbl2Nome);
        painelInfosDir.add(lbl2PF);
        painelInfosDir.add(lbl2PE);
        painelInfosDir.add(lbl2);

        // Adding "Characters List on Right Side" Panel
        addConstraints(this, painelPersonagensDir, 2, 0, 1, 1, GridBagConstraints.BOTH, 0.1f, 0);
        painelPersonagensDir.add(new JLabel("Teste 3"));

        painelPersonagensDir.add(listaPersonagemDir);
        painelPersonagensDir.setBackground(new Color(64, 73, 202));

        // Adding Buttons Panel
        addConstraints(this, pButtons, 0, 1, 3, 1, GridBagConstraints.BOTH, 0, 0f);
        pButtons.setBackground(new Color(112, 145, 189));

        // Adding "Combat Description" Panel
        addConstraints(this, pBattleDesc, 0, 2, 3, 3, GridBagConstraints.BOTH, 0, 5);
        pBattleDesc.add(new JLabel("DESCRIÇÃO DO COMBATE AQUI"));
        pBattleDesc.setBackground(Color.gray);

        // ------------------------------
        // Adding Subpanels and buttons in Buttons Panel
        // ------------------------------

        // Adding SubPanel in Buttons Panel
        pButtons.setLayout(new GridBagLayout());

        // Adding Button "select character on the left" on the panel pButtons
        addConstraints(pButtons, pSelChar, 0, 0, 1, 2, GridBagConstraints.BOTH);
        botaoSelecionaPersonagemEsq.addActionListener(e -> {
            try {
                System.out.println(personagemSelEsq.getNome());
            } catch (Exception w) {
                System.out.println("Nenhum personagem selecionado!");
            }
        });
        pSelChar.add(botaoSelecionaPersonagemEsq);

        // Adding Button "start battle" on the Panel pButtons
        addConstraints(pButtons, pStart, 1, 0, 1, 1, GridBagConstraints.BOTH);
        pStart.add(botaoIniciaConfronto);
        // Adding Button "reset characters" on the Panel pButtons
        addConstraints(pButtons, pReset, 1, 1, 1, 1, GridBagConstraints.BOTH);
        pReset.add(botaoResetaConfronto);
        // Adding Button "select character on the right" on the Panel pButtons
        addConstraints(pButtons, pSelCharR, 2, 0, 1, 2, GridBagConstraints.BOTH);
        botaoSelecionaPersonagemDir.addActionListener(e -> {
            System.out.println(personagemSelDir.getNome());
        });
        pSelCharR.add(botaoSelecionaPersonagemDir);

        // Making everything visible at the end to avoid bugs
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
    public void setList(List<Personagem> personagens) {
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
