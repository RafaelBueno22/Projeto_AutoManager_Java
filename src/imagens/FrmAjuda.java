package imagens;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FrmAjuda extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmAjuda.class.getName());

        
private static final Color FUNDO = new Color(30, 34, 43);
private static final Color PAINEL = new Color(37, 46, 59);
private static final Color TEXTO = new Color(240, 244, 248);
private static final Color SECUNDARIO = new Color(170, 185, 205);
private static final Color AZUL = new Color(96, 165, 250);

private JPanel painelConteudo;

private void criarInterface() {

    JPanel principal = new JPanel(new BorderLayout(0, 20));
    principal.setBackground(FUNDO);
    principal.setBorder(new EmptyBorder(25, 30, 25, 30));

    // CABEÇALHO
    JPanel cabecalho = new JPanel(
            new BorderLayout(0, 5));
    cabecalho.setOpaque(false);

    JLabel titulo = new JLabel("Central de Ajuda");
    titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
    titulo.setForeground(TEXTO);

    JLabel subtitulo = new JLabel(
            "Aprenda a utilizar as funcionalidades do AutoManager");
    subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    subtitulo.setForeground(SECUNDARIO);

    cabecalho.add(titulo, BorderLayout.NORTH);
    cabecalho.add(subtitulo, BorderLayout.SOUTH);

    principal.add(cabecalho, BorderLayout.NORTH);

    // MENU LATERAL
    JPanel menu = new JPanel();
    menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
    menu.setBackground(PAINEL);
    menu.setBorder(new EmptyBorder(15, 12, 15, 12));
    menu.setPreferredSize(new Dimension(210, 0));

    menu.add(criarBotaoMenu("Cadastros", "cadastros"));
    menu.add(Box.createVerticalStrut(10));
    menu.add(criarBotaoMenu("Consultas", "consultas"));
    menu.add(Box.createVerticalStrut(10));
    menu.add(criarBotaoMenu("Ordens de Serviço", "ordens"));
    menu.add(Box.createVerticalStrut(10));
    menu.add(criarBotaoMenu("Relatórios", "relatorios"));
    menu.add(Box.createVerticalGlue());

    // CONTEÚDO
    painelConteudo = new JPanel(new BorderLayout());
    painelConteudo.setBackground(PAINEL);
    painelConteudo.setBorder(
            new EmptyBorder(22, 25, 22, 25));

    JPanel centro = new JPanel(new BorderLayout(15, 0));
    centro.setOpaque(false);
    centro.add(menu, BorderLayout.WEST);
    centro.add(painelConteudo, BorderLayout.CENTER);

    principal.add(centro, BorderLayout.CENTER);

    // RODAPÉ
    JButton btnFechar = new JButton("Fechar");
    btnFechar.setFont(
            new Font("Segoe UI", Font.BOLD, 14));
    btnFechar.setBackground(new Color(75, 85, 99));
    btnFechar.setForeground(Color.WHITE);
    btnFechar.putClientProperty(
            "JButton.buttonType", "roundRect");
    btnFechar.setPreferredSize(new Dimension(150, 42));
    btnFechar.addActionListener(e -> dispose());

    JPanel rodape = new JPanel(new FlowLayout(
            FlowLayout.RIGHT, 0, 0));
    rodape.setOpaque(false);
    rodape.add(btnFechar);

    principal.add(rodape, BorderLayout.SOUTH);

    setContentPane(principal);

    mostrarConteudo("cadastros");
}

private JButton criarBotaoMenu(
        String texto, String categoria) {

    JButton botao = new JButton(texto);
    botao.setFont(new Font("Segoe UI", Font.BOLD, 13));
    botao.setHorizontalAlignment(SwingConstants.LEFT);
    botao.setBackground(new Color(52, 62, 78));
    botao.setForeground(TEXTO);
    botao.setFocusPainted(false);

    botao.putClientProperty(
            "JButton.buttonType", "roundRect");

    botao.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 43));

    botao.setAlignmentX(Component.LEFT_ALIGNMENT);

    botao.addActionListener(
            e -> mostrarConteudo(categoria));

    return botao;
}

private void mostrarConteudo(String categoria) {

    painelConteudo.removeAll();

    String titulo = "";
    String texto = "";

    switch (categoria) {

        case "cadastros":
            titulo = "Cadastros";
            texto = """
                CADASTRO DE CLIENTES

                1. Acesse Cadastros > Clientes.
                2. Preencha nome, CPF, telefone, e-mail e endereço.
                3. Marque a situação do cliente.
                4. Clique em Cadastrar para salvar.

                CADASTRO DE VEÍCULOS

                1. Acesse Cadastros > Veículos.
                2. Selecione o cliente responsável.
                3. Informe placa, marca, modelo, ano e cor.
                4. Clique em Cadastrar.

                CADASTRO DE MECÂNICOS

                1. Acesse Cadastros > Mecânicos.
                2. Informe os dados do profissional.
                3. Clique em Cadastrar.

                CADASTRO DE SERVIÇOS

                1. Acesse Cadastros > Serviços.
                2. Informe descrição, categoria e valor base.
                3. Clique em Cadastrar.
                """;
            break;

        case "consultas":
            titulo = "Consultas";
            texto = """
                CONSULTA DE REGISTROS

                1. Acesse o menu Consultas.
                2. Escolha Clientes, Veículos, Mecânicos,
                   Serviços ou Ordens de Serviço.
                3. Utilize os filtros disponíveis.
                4. Localize o registro desejado na tabela.

                ALTERAÇÃO DE DADOS

                1. Selecione o registro desejado.
                2. Edite as informações permitidas.
                3. Salve as alterações.

                DICA

                Confira os dados antes de confirmar
                qualquer alteração.
                """;
            break;

        case "ordens":
            titulo = "Ordens de Serviço";
            texto = """
                ABRIR UMA ORDEM DE SERVIÇO

                1. Acesse Cadastros > Ordem de Serviço.
                2. Selecione o veículo.
                3. Selecione o mecânico responsável.
                4. Selecione o serviço.
                5. Informe o problema relatado.
                6. Preencha os demais campos necessários.
                7. Clique em Cadastrar.

                ACOMPANHAMENTO

                A ordem de serviço pode apresentar
                os seguintes estados:

                ABERTA
                EM_ANDAMENTO
                CONCLUIDA
                CANCELADA

                Consulte as ordens para acompanhar
                o andamento dos serviços.
                """;
            break;

        case "relatorios":
            titulo = "Relatórios";
            texto = """
                GERAR RELATÓRIOS

                1. Acesse o menu Relatórios.
                2. Escolha o tipo de relatório:

                   - Clientes
                   - Veículos
                   - Mecânicos
                   - Serviços
                   - Ordens de Serviço

                3. Utilize os filtros disponíveis.
                4. Analise os resultados apresentados.

                Os relatórios ajudam a acompanhar
                os registros e as atividades
                da oficina mecânica.
                """;
            break;
    }

    JLabel lblTitulo = new JLabel(titulo);
    lblTitulo.setFont(
            new Font("Segoe UI", Font.BOLD, 21));
    lblTitulo.setForeground(TEXTO);

    JTextArea area = new JTextArea(texto);
    area.setFont(
            new Font("Segoe UI", Font.PLAIN, 14));
    area.setForeground(SECUNDARIO);
    area.setBackground(PAINEL);
    area.setEditable(false);
    area.setFocusable(false);
    area.setLineWrap(true);
    area.setWrapStyleWord(true);
    area.setMargin(new Insets(12, 0, 12, 8));
    area.setCaretPosition(0);

    JScrollPane scroll = new JScrollPane(area);
    scroll.setBorder(null);
    scroll.setOpaque(false);
    scroll.getViewport().setBackground(PAINEL);
    scroll.getVerticalScrollBar().setUnitIncrement(16);

    painelConteudo.add(lblTitulo, BorderLayout.NORTH);
    painelConteudo.add(scroll, BorderLayout.CENTER);

    painelConteudo.revalidate();
    painelConteudo.repaint();
}

    
    
    
    
    
    
    
    public FrmAjuda() {
        initComponents();
        
        setTitle("Central de Ajuda - AutoManager");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(850, 650);
    setMinimumSize(new Dimension(700, 550));
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
        java.awt.EventQueue.invokeLater(() -> new FrmAjuda().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
