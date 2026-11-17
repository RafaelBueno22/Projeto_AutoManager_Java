package view;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLaf;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import util.Estilo;
import imagens.FrmSobre;
import imagens.FrmAjuda;
import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class frmPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmPrincipal.class.getName());

        
private static final Color FUNDO = new Color(30, 34, 43);
private static final Color PAINEL = new Color(37, 46, 59);
private static final Color TEXTO = new Color(240, 244, 248);
private static final Color SECUNDARIO = new Color(170, 185, 205);
private static final Color AZUL = new Color(96, 165, 250);

private void criarPainelInicial() {

    JPanel principal = new JPanel(new BorderLayout(0, 25));
    principal.setBackground(FUNDO);
    principal.setBorder(new EmptyBorder(35, 45, 35, 45));

    // CABEÇALHO
    JPanel cabecalho = new JPanel(new BorderLayout());
    cabecalho.setOpaque(false);

    JPanel textos = new JPanel();
    textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
    textos.setOpaque(false);

    JLabel titulo = new JLabel("Bem-vindo ao AutoManager");
    titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
    titulo.setForeground(TEXTO);

    JLabel subtitulo = new JLabel(
            "Gerencie sua oficina de forma simples e organizada.");
    subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    subtitulo.setForeground(SECUNDARIO);

    textos.add(titulo);
    textos.add(Box.createVerticalStrut(8));
    textos.add(subtitulo);

    JLabel versao = new JLabel("VERSÃO 1.0");
    versao.setFont(new Font("Segoe UI", Font.BOLD, 13));
    versao.setForeground(AZUL);

    cabecalho.add(textos, BorderLayout.WEST);
    cabecalho.add(versao, BorderLayout.EAST);

    principal.add(cabecalho, BorderLayout.NORTH);

    // CARDS DE NAVEGAÇÃO
    JPanel cards = new JPanel(new GridLayout(2, 2, 20, 20));
    cards.setOpaque(false);

    cards.add(criarCard(
            "Clientes",
            "Cadastro e gerenciamento de clientes",
            "\u263A"));

    cards.add(criarCard(
            "Veículos",
            "Controle dos veículos cadastrados",
            "\uD83D\uDE97"));

    cards.add(criarCard(
            "Mecânicos",
            "Gerenciamento dos profissionais",
            "\u2699"));

    cards.add(criarCard(
            "Ordens de Serviço",
            "Acompanhamento dos serviços",
            "\u2637"));

    principal.add(cards, BorderLayout.CENTER);

    // RODAPÉ
    JPanel rodape = new JPanel(new BorderLayout());
    rodape.setBackground(PAINEL);
    rodape.setBorder(new EmptyBorder(18, 22, 18, 22));

    JLabel lblStatus = new JLabel("Sistema pronto para uso");
    lblStatus.setFont(
            new Font("Segoe UI", Font.BOLD, 15));
    lblStatus.setForeground(TEXTO);

    JLabel lblDescricao = new JLabel(
            "Utilize a barra de menus para acessar "
            + "cadastros, consultas e relatórios.");
    lblDescricao.setForeground(SECUNDARIO);
    lblDescricao.setFont(
            new Font("Segoe UI", Font.PLAIN, 13));

    JPanel textosRodape = new JPanel();
    textosRodape.setLayout(
            new BoxLayout(textosRodape, BoxLayout.Y_AXIS));
    textosRodape.setOpaque(false);

    textosRodape.add(lblStatus);
    textosRodape.add(Box.createVerticalStrut(6));
    textosRodape.add(lblDescricao);

    rodape.add(textosRodape, BorderLayout.CENTER);

    principal.add(rodape, BorderLayout.SOUTH);

    // Substitui apenas o painel central.
    // A JMenuBar já existente continua funcionando.
    setContentPane(principal);

    revalidate();
    repaint();
}

private JPanel criarCard(
        String titulo, String descricao, String simbolo) {

    JPanel card = new JPanel(new BorderLayout(0, 12));
    card.setBackground(PAINEL);
    card.setBorder(new EmptyBorder(25, 25, 25, 25));

    JLabel icone = new JLabel(simbolo);
    icone.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 34));
    icone.setForeground(AZUL);

    JLabel lblTitulo = new JLabel(titulo);
    lblTitulo.setFont(
            new Font("Segoe UI", Font.BOLD, 20));
    lblTitulo.setForeground(TEXTO);

    JLabel lblDescricao = new JLabel(descricao);
    lblDescricao.setFont(
            new Font("Segoe UI", Font.PLAIN, 13));
    lblDescricao.setForeground(SECUNDARIO);

    JPanel textos = new JPanel();
    textos.setLayout(
            new BoxLayout(textos, BoxLayout.Y_AXIS));
    textos.setOpaque(false);

    lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
    lblDescricao.setAlignmentX(Component.LEFT_ALIGNMENT);

    textos.add(lblTitulo);
    textos.add(Box.createVerticalStrut(8));
    textos.add(lblDescricao);

    card.add(icone, BorderLayout.NORTH);
    card.add(textos, BorderLayout.CENTER);

    return card;
}

    
    
    
    
    
    
    
    
    public frmPrincipal() {
        initComponents();
        Estilo.aplicarTela(this);
        
        setTitle("AutoManager - Menu Principal");
    setSize(1100, 750);
    setMinimumSize(new Dimension(850, 600));
    setLocationRelativeTo(null);

    criarPainelInicial();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCadClientes = new javax.swing.JMenuItem();
        menuCadVeiculos = new javax.swing.JMenuItem();
        menuCadMecanicos = new javax.swing.JMenuItem();
        menuCadServicos = new javax.swing.JMenuItem();
        menuCadOS = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuConsClientes = new javax.swing.JMenuItem();
        menuConsVeiculos = new javax.swing.JMenuItem();
        menuConsMecanicos = new javax.swing.JMenuItem();
        menuConsServicos = new javax.swing.JMenuItem();
        menuConsOS = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuRelClientes = new javax.swing.JMenuItem();
        menuRelVeiculos = new javax.swing.JMenuItem();
        menuRelMecanicos = new javax.swing.JMenuItem();
        menuRelServicos = new javax.swing.JMenuItem();
        menuRelOS = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuSobreAM = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuAjudaSistema = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuSairSistema = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(829, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastro");

        menuCadClientes.setText("Clientes");
        menuCadClientes.addActionListener(this::menuCadClientesActionPerformed);
        jMenu1.add(menuCadClientes);

        menuCadVeiculos.setText("Veículos");
        menuCadVeiculos.addActionListener(this::menuCadVeiculosActionPerformed);
        jMenu1.add(menuCadVeiculos);

        menuCadMecanicos.setText("Mecânicos");
        menuCadMecanicos.addActionListener(this::menuCadMecanicosActionPerformed);
        jMenu1.add(menuCadMecanicos);

        menuCadServicos.setText("Serviços");
        menuCadServicos.addActionListener(this::menuCadServicosActionPerformed);
        jMenu1.add(menuCadServicos);

        menuCadOS.setText("Abrir Ordem de Serviço");
        menuCadOS.addActionListener(this::menuCadOSActionPerformed);
        jMenu1.add(menuCadOS);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consulta");
        jMenu2.addActionListener(this::jMenu2ActionPerformed);

        menuConsClientes.setText("Clientes");
        menuConsClientes.addActionListener(this::menuConsClientesActionPerformed);
        jMenu2.add(menuConsClientes);

        menuConsVeiculos.setText("Veículos");
        menuConsVeiculos.addActionListener(this::menuConsVeiculosActionPerformed);
        jMenu2.add(menuConsVeiculos);

        menuConsMecanicos.setText("Mecânicos");
        menuConsMecanicos.addActionListener(this::menuConsMecanicosActionPerformed);
        jMenu2.add(menuConsMecanicos);

        menuConsServicos.setText("Serviços");
        menuConsServicos.addActionListener(this::menuConsServicosActionPerformed);
        jMenu2.add(menuConsServicos);

        menuConsOS.setText("Ordens de Serviço");
        menuConsOS.addActionListener(this::menuConsOSActionPerformed);
        jMenu2.add(menuConsOS);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatório");

        menuRelClientes.setText("Clientes");
        menuRelClientes.addActionListener(this::menuRelClientesActionPerformed);
        jMenu3.add(menuRelClientes);

        menuRelVeiculos.setText("Veículos");
        menuRelVeiculos.addActionListener(this::menuRelVeiculosActionPerformed);
        jMenu3.add(menuRelVeiculos);

        menuRelMecanicos.setText("Mecânicos");
        menuRelMecanicos.addActionListener(this::menuRelMecanicosActionPerformed);
        jMenu3.add(menuRelMecanicos);

        menuRelServicos.setText("Serviços");
        menuRelServicos.addActionListener(this::menuRelServicosActionPerformed);
        jMenu3.add(menuRelServicos);

        menuRelOS.setText("Ordens de Serviço");
        menuRelOS.addActionListener(this::menuRelOSActionPerformed);
        jMenu3.add(menuRelOS);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sobre");

        menuSobreAM.setText("Sobre o AutoManager");
        menuSobreAM.addActionListener(this::menuSobreAMActionPerformed);
        jMenu4.add(menuSobreAM);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ajuda");

        menuAjudaSistema.setText("Como Utilizar o Sistema");
        menuAjudaSistema.addActionListener(this::menuAjudaSistemaActionPerformed);
        jMenu5.add(menuAjudaSistema);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Sair");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });

        menuSairSistema.setText("Encerrar Sistema");
        jMenu6.add(menuSairSistema);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 195, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadClientesActionPerformed
       FrmCadastroCliente tela2 = new FrmCadastroCliente();
       tela2.setVisible(true);
       
    }//GEN-LAST:event_menuCadClientesActionPerformed

    private void menuConsMecanicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsMecanicosActionPerformed
        FrmConsultaMecanico tela9 = new FrmConsultaMecanico();
        tela9.setVisible(true);
    }//GEN-LAST:event_menuConsMecanicosActionPerformed

    private void menuRelVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelVeiculosActionPerformed
        FrmRelatorioVeiculos tela13 = new FrmRelatorioVeiculos();
        tela13.setVisible(true);
    }//GEN-LAST:event_menuRelVeiculosActionPerformed

    private void menuCadVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadVeiculosActionPerformed
        FrmCadastroVeiculo tela3 = new FrmCadastroVeiculo();
        tela3.setVisible(true);
    }//GEN-LAST:event_menuCadVeiculosActionPerformed

    private void menuCadMecanicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadMecanicosActionPerformed
        FrmCadastroMecanico tela4 = new FrmCadastroMecanico();
        tela4.setVisible(true);
    }//GEN-LAST:event_menuCadMecanicosActionPerformed

    private void menuCadServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadServicosActionPerformed
        FrmCadastroServico tela5 = new FrmCadastroServico();
        tela5.setVisible(true);
    }//GEN-LAST:event_menuCadServicosActionPerformed

    private void menuCadOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadOSActionPerformed
        FrmCadastroOS tela6 = new FrmCadastroOS();
        tela6.setVisible(true);
    }//GEN-LAST:event_menuCadOSActionPerformed

    private void menuConsClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsClientesActionPerformed
        FrmConsultaCliente tela7 = new FrmConsultaCliente();
        tela7.setVisible(true);
    }//GEN-LAST:event_menuConsClientesActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void menuConsVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsVeiculosActionPerformed
        FrmConsultaVeiculo tela8 = new FrmConsultaVeiculo();
        tela8.setVisible(true);
    }//GEN-LAST:event_menuConsVeiculosActionPerformed

    private void menuConsServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsServicosActionPerformed
        FrmConsultaServico tela10 = new FrmConsultaServico();
        tela10.setVisible(true);
    }//GEN-LAST:event_menuConsServicosActionPerformed

    private void menuConsOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsOSActionPerformed
        FrmConsultaOS tela11 = new FrmConsultaOS();
        tela11.setVisible(true);
        
    }//GEN-LAST:event_menuConsOSActionPerformed

    private void menuRelClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelClientesActionPerformed
        FrmRelatorioClientes tela12 = new FrmRelatorioClientes();
        tela12.setVisible(true);
    }//GEN-LAST:event_menuRelClientesActionPerformed

    private void menuRelMecanicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelMecanicosActionPerformed
        FrmRelatorioMecanicos tela14 = new FrmRelatorioMecanicos();
        tela14.setVisible(true);
    }//GEN-LAST:event_menuRelMecanicosActionPerformed

    private void menuRelServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelServicosActionPerformed
        FrmRelatorioServicos tela15 = new FrmRelatorioServicos();
        tela15.setVisible(true);
    }//GEN-LAST:event_menuRelServicosActionPerformed

    private void menuRelOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelOSActionPerformed
        FrmRelatorioOS tela16 = new FrmRelatorioOS();
        tela16.setVisible(true);
    }//GEN-LAST:event_menuRelOSActionPerformed

    private void menuSobreAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreAMActionPerformed
        FrmSobre tela17 = new FrmSobre();
        tela17.setVisible(true);
    }//GEN-LAST:event_menuSobreAMActionPerformed

    private void menuAjudaSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjudaSistemaActionPerformed
        FrmAjuda tela18 = new FrmAjuda();
        tela18.setVisible(true);
    }//GEN-LAST:event_menuAjudaSistemaActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
       int resposta = JOptionPane.showConfirmDialog(
    this,
    "Deseja realmente sair do AutoManager?",
    "Confirmar saída",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE
);

if (resposta == JOptionPane.YES_OPTION) {
    System.exit(0);
} 
    }//GEN-LAST:event_jMenu6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
         Estilo.configurarTema();

        java.awt.EventQueue.invokeLater(() -> {

        frmPrincipal menu = new frmPrincipal();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    });
    
        
        
      //  java.awt.EventQueue.invokeLater(() -> new frmPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuAjudaSistema;
    private javax.swing.JMenuItem menuCadClientes;
    private javax.swing.JMenuItem menuCadMecanicos;
    private javax.swing.JMenuItem menuCadOS;
    private javax.swing.JMenuItem menuCadServicos;
    private javax.swing.JMenuItem menuCadVeiculos;
    private javax.swing.JMenuItem menuConsClientes;
    private javax.swing.JMenuItem menuConsMecanicos;
    private javax.swing.JMenuItem menuConsOS;
    private javax.swing.JMenuItem menuConsServicos;
    private javax.swing.JMenuItem menuConsVeiculos;
    private javax.swing.JMenuItem menuRelClientes;
    private javax.swing.JMenuItem menuRelMecanicos;
    private javax.swing.JMenuItem menuRelOS;
    private javax.swing.JMenuItem menuRelServicos;
    private javax.swing.JMenuItem menuRelVeiculos;
    private javax.swing.JMenuItem menuSairSistema;
    private javax.swing.JMenuItem menuSobreAM;
    // End of variables declaration//GEN-END:variables
}
