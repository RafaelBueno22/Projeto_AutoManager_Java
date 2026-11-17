package imagens;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FrmSobre extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmSobre.class.getName());

    private static final Color FUNDO = new Color(30, 34, 43);
private static final Color PAINEL = new Color(37, 46, 59);
private static final Color TEXTO = new Color(240, 244, 248);
private static final Color SECUNDARIO = new Color(170, 185, 205);
private static final Color AZUL = new Color(96, 165, 250);
private static final Color BORDA = new Color(65, 75, 90);

private void criarInterface() {

    JPanel principal = new JPanel(new BorderLayout(0, 22));
    principal.setBackground(FUNDO);
    principal.setBorder(new EmptyBorder(28, 32, 28, 32));

    // CABEÇALHO
    JPanel cabecalho = new JPanel();
    cabecalho.setOpaque(false);
    cabecalho.setLayout(
            new BoxLayout(cabecalho, BoxLayout.Y_AXIS));

    JLabel icone = new JLabel("\u2699");
    icone.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 50));
    icone.setForeground(AZUL);
    icone.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel titulo = new JLabel("AutoManager");
    titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
    titulo.setForeground(TEXTO);
    titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel subtitulo = new JLabel(
            "Sistema de Gerenciamento de Oficinas");
    subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    subtitulo.setForeground(SECUNDARIO);
    subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel versao = new JLabel("VERSÃO 1.0");
    versao.setFont(new Font("Segoe UI", Font.BOLD, 13));
    versao.setForeground(AZUL);
    versao.setAlignmentX(Component.CENTER_ALIGNMENT);

    cabecalho.add(icone);
    cabecalho.add(Box.createVerticalStrut(8));
    cabecalho.add(titulo);
    cabecalho.add(Box.createVerticalStrut(5));
    cabecalho.add(subtitulo);
    cabecalho.add(Box.createVerticalStrut(12));
    cabecalho.add(versao);

    principal.add(cabecalho, BorderLayout.NORTH);

    // PAINEL DE INFORMAÇÕES
    JPanel informacoes = new JPanel();
    informacoes.setLayout(
            new BoxLayout(informacoes, BoxLayout.Y_AXIS));
    informacoes.setBackground(PAINEL);
    informacoes.setBorder(new EmptyBorder(22, 22, 22, 22));

    JLabel sobre = criarLabel("Sobre o sistema", 17, true);

    JTextArea descricao = new JTextArea(
            "O AutoManager é um sistema de gerenciamento "
            + "de oficinas mecânicas, desenvolvido para "
            + "facilitar o cadastro de clientes, veículos, "
            + "mecânicos e serviços, além do controle de "
            + "ordens de serviço e geração de relatórios.");

    descricao.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    descricao.setForeground(SECUNDARIO);
    descricao.setBackground(PAINEL);
    descricao.setLineWrap(true);
    descricao.setWrapStyleWord(true);
    descricao.setEditable(false);
    descricao.setFocusable(false);
    descricao.setAlignmentX(Component.LEFT_ALIGNMENT);

    informacoes.add(sobre);
    informacoes.add(Box.createVerticalStrut(10));
    informacoes.add(descricao);
    informacoes.add(Box.createVerticalStrut(18));

    JSeparator separador = new JSeparator();
    separador.setForeground(BORDA);
    separador.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 1));
    informacoes.add(separador);

    informacoes.add(Box.createVerticalStrut(20));

    informacoes.add(criarLabel(
            "DESENVOLVEDOR", 11, false));
    informacoes.add(Box.createVerticalStrut(5));
    informacoes.add(criarLabel(
            "Rafael Correa Bueno", 14, true));

    informacoes.add(Box.createVerticalStrut(18));

    informacoes.add(criarLabel("TURMA", 11, false));
    informacoes.add(Box.createVerticalStrut(5));
    informacoes.add(criarLabel("261T", 14, true));

    informacoes.add(Box.createVerticalStrut(18));

    informacoes.add(criarLabel(
            "TECNOLOGIAS", 11, false));
    informacoes.add(Box.createVerticalStrut(5));
    informacoes.add(criarLabel(
            "Java | Swing | NetBeans | JDBC | PostgreSQL",
            13, true));

    principal.add(informacoes, BorderLayout.CENTER);

    // BOTÃO FECHAR
    JButton btnFechar = new JButton("Fechar");
    btnFechar.setFont(
            new Font("Segoe UI", Font.BOLD, 14));
    btnFechar.setBackground(new Color(75, 85, 99));
    btnFechar.setForeground(Color.WHITE);
    btnFechar.setFocusPainted(false);

    btnFechar.putClientProperty(
            "JButton.buttonType", "roundRect");

    btnFechar.setPreferredSize(new Dimension(160, 42));
    btnFechar.addActionListener(e -> dispose());

    JPanel rodape = new JPanel(new FlowLayout(
            FlowLayout.CENTER, 0, 0));
    rodape.setOpaque(false);
    rodape.add(btnFechar);

    principal.add(rodape, BorderLayout.SOUTH);

    setContentPane(principal);
}

private JLabel criarLabel(
        String texto, int tamanho, boolean destaque) {

    JLabel label = new JLabel(texto);

    label.setFont(new Font(
            "Segoe UI",
            destaque ? Font.BOLD : Font.PLAIN,
            tamanho));

    label.setForeground(
            destaque ? TEXTO : SECUNDARIO);

    label.setAlignmentX(Component.LEFT_ALIGNMENT);

    return label;
}
    
    
    
    
    
    public FrmSobre() {
        initComponents();
        
    setTitle("Sobre - AutoManager");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(560, 720);
    setMinimumSize(new Dimension(520, 680));
    setLocationRelativeTo(null);

    criarInterface();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        com.formdev.flatlaf.FlatDarkLaf.setup();
        
        java.awt.EventQueue.invokeLater(() -> new FrmSobre().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
