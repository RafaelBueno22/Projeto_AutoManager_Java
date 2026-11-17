package view;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.math.BigDecimal;

public class FrmConsultaOS extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmConsultaOS.class.getName());

        private void atualizarTabela(){
            String sql = """
                         SELECT os.id,
                         v.placa,
                         c.nome AS cliente,
                         m.nome AS mecanico,
                         s.descricao AS servico,
                         os.data_abertura,
                         os.status,
                         os.valor_cobrado,
                         os.data_conclusao
                         FROM ordem_servico os
                         JOIN veiculo v ON os.veiculo_id = v.id
                         JOIN cliente c ON v.cliente_id = c.id
                         JOIN mecanico m ON os.mecanico_id = m.id
                         JOIN servico s ON os.servico_id = s.id
                         ORDER BY os.id 
                         """;
            
            DefaultTableModel modelo = (DefaultTableModel) tblOS.getModel();
            
            modelo.setRowCount(0);
            
            try(Connection conex = Conexao.conectar();
                PreparedStatement stmt = conex.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
                
                while(rs.next()){
                    modelo.addRow(new Object []{
                        rs.getInt("id"), rs.getString("placa"),
                        rs.getString("cliente"), rs.getString("mecanico"),
                        rs.getString("servico"), rs.getTimestamp("data_abertura"),
                        rs.getString("status"),  rs.getBigDecimal("valor_cobrado"),
                        rs.getTimestamp("data_conclusao")
                    });
                }
            }catch(SQLException erro) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar OS: " +erro.getMessage());
            }
        }
        
        private ArrayList<Integer> idMecanicos = new ArrayList<>();
        private ArrayList<Integer> idServicos = new ArrayList<>();
        
        private void carregarMecanicos(String pesquisa, boolean somenteAtivos){
            String sql = """
                         SELECT id, nome, especialidade
                         FROM mecanico
                         WHERE ativo = TRUE
                         AND(
                            ? = ''
                            OR (? = TRUE AND CAST (id AS TEXT) = ?)
                            OR (? = FALSE AND nome ILIKE ? )
                        )
                        ORDER BY id
                         
                         """;
            
            cbMecanico.removeAllItems();
            idMecanicos.clear();
            
            try (
                 Connection conex = Conexao.conectar();
                 PreparedStatement stmt = conex.prepareStatement(sql)
                    ){
                boolean pesquisaId = pesquisa.matches("\\d+");

                stmt.setString(1, pesquisa);
                stmt.setBoolean(2, pesquisaId);
                stmt.setString(3, pesquisa);
                stmt.setBoolean(4, pesquisaId);
                stmt.setString(5, "%" + pesquisa + "%");
                
                
                try(ResultSet rs = stmt.executeQuery()){
                    while(rs.next()){
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        String especialidade = rs.getString("especialidade");
                        
                       
                        cbMecanico.addItem("ID: " +id+ " - " +nome+ " - " +especialidade);
                        
                        idMecanicos.add(id);
                    }       
                
                    }
                cbMecanico.setSelectedIndex(-1);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(this, "Erro ao pesquisar mecanicos: " + erro.getMessage());
            }
            
        }
        
        private void carregarServicos(String pesquisa, boolean somenteAtivos) {

    String sql = """
        SELECT id, descricao, valor_base
        FROM servico
        WHERE (? = FALSE OR ativo = TRUE)
        AND (
            ? = ''
            OR (? = TRUE AND CAST(id AS TEXT) = ?)
            OR (? = FALSE AND descricao ILIKE ?)
        )
        ORDER BY id
        """;

    cbServico.removeAllItems();
    idServicos.clear();
   

    try (Connection conex = Conexao.conectar();
         PreparedStatement stmt = conex.prepareStatement(sql)) {

        boolean pesquisaId = pesquisa.matches("\\d+");

        stmt.setBoolean(1, somenteAtivos);
        stmt.setString(2, pesquisa);
        stmt.setBoolean(3, pesquisaId);
        stmt.setString(4, pesquisa);
        stmt.setBoolean(5, pesquisaId);
        stmt.setString(6, "%" + pesquisa + "%");

        try (ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                BigDecimal valorBase = rs.getBigDecimal("valor_base");

                cbServico.addItem(
                    "ID: " + id + " - " + descricao
                    + " - R$ " + valorBase
                );

                idServicos.add(id);
                
            }
        }

        cbServico.setSelectedIndex(-1);

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(this,
                "Erro ao carregar serviços: " + erro.getMessage());
    }
}
    
    public FrmConsultaOS() {
        initComponents();
        
        tblOS.setModel(new DefaultTableModel(new Object [][]{},
                                             new String[]{
                                                 "Nº OS", "Placa", "Cliente", "Mecânico",
                                                 "Serviço", "Data Abertura", "Status",
                                                 "Valor Cobrado", "Data Conclusão"
                                             }
                                            ){
                                                @Override 
                                                public boolean isCellEditable(int linha, int coluna){
                                                    return false;
                                                }
                                            });
        
        carregarMecanicos("", false);
        carregarServicos("", false);
        atualizarTabela();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextField7 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cbPesquisarPor = new javax.swing.JComboBox<>();
        txtPesquisar = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOS = new javax.swing.JTable();
        txtNOS = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        cbMecanico = new javax.swing.JComboBox<>();
        cbServico = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        cbStatus = new javax.swing.JComboBox<>();
        txtValorCobrado = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        btnAlterar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataFim = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDataAbertura = new javax.swing.JFormattedTextField();
        txtDataConclusao = new javax.swing.JFormattedTextField();
        txtCliente = new javax.swing.JTextField();

        jScrollPane2.setViewportView(jTextPane1);

        jTextField7.setText("jTextField7");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cbPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número da OS", "Placa", "Cliente", "Mecânico", "Status", "Período de Abertura", " " }));
        cbPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro:"));

        txtPesquisar.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa:"));

        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(this::btnLocalizarActionPerformed);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);

        tblOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº OS", "Placa", "Cliente", "Mecânico", "Serviço", "Data Abertura", "Status", "Valor Cobrado", "Data Conclusão"
            }
        ));
        tblOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOS);

        txtNOS.setEditable(false);
        txtNOS.setBorder(javax.swing.BorderFactory.createTitledBorder("Nº OS"));

        txtPlaca.setEditable(false);
        txtPlaca.setBorder(javax.swing.BorderFactory.createTitledBorder("Placa"));

        cbMecanico.setBorder(javax.swing.BorderFactory.createTitledBorder("Mecanico:"));

        cbServico.setBorder(javax.swing.BorderFactory.createTitledBorder("Servico:"));

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setRows(5);
        txtDiagnostico.setBorder(javax.swing.BorderFactory.createTitledBorder("Diagnostico:"));
        jScrollPane3.setViewportView(txtDiagnostico);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ABERTA", "EM_ANDAMENTO", "CONCLUIDA", "CANCELADA", " " }));
        cbStatus.setBorder(null);
        cbStatus.addActionListener(this::cbStatusActionPerformed);

        txtValorCobrado.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Cobrado"));

        txtObs.setColumns(20);
        txtObs.setRows(5);
        txtObs.setBorder(javax.swing.BorderFactory.createTitledBorder("Observacao"));
        jScrollPane4.setViewportView(txtObs);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(this::btnAlterarActionPerformed);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        txtDataInicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Periodo Abertura"));
        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicio.addActionListener(this::txtDataInicioActionPerformed);

        try {
            txtDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("até");

        txtDataAbertura.setEditable(false);
        txtDataAbertura.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Abertura"));
        try {
            txtDataAbertura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtDataConclusao.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Conclusao"));
        try {
            txtDataConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtCliente.setEditable(false);
        txtCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente:"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNOS, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(220, 220, 220)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDataAbertura, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(txtDataConclusao))
                                .addGap(51, 51, 51)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbPesquisarPor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPesquisar)
                        .addComponent(txtDataInicio)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataInicioActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        String pesquisa = txtPesquisar.getText().trim();
        String tipo_pesquisa = cbPesquisarPor.getSelectedItem().toString();
        
        if(!tipo_pesquisa.equals("Período de Abertura") && pesquisa.isEmpty()){
                JOptionPane.showMessageDialog(this,"Digite um valor para pesquisar!",
                                              "Pesquisa Vazia", JOptionPane.WARNING_MESSAGE);
                                return;
        }
        
        String sql = """
                     SELECT os.id, v.placa, c.nome AS cliente,
                     m.nome AS mecanico, s.descricao AS servico,
                     os.data_abertura, os.status,
                     os.valor_cobrado, os.data_conclusao
                     FROM ordem_servico os
                     JOIN veiculo v ON os.veiculo_id = v.id
                     JOIN cliente c ON v.cliente_id = c.id
                     JOIN mecanico m ON os.mecanico_id = m.id
                     JOIN servico s ON os.servico_id = s.id
                     """;
        
        switch (tipo_pesquisa) {
            case "Número da OS":
                sql += " WHERE os.id = ?";
                break;
            case "Placa":
                sql += " WHERE v.placa ILIKE ?";
                break;
            case "Cliente":
                sql += " WHERE c.nome ILIKE ?";
                break;
            case "Mecânico":
                sql += " WHERE m.nome ILIKE ?";
                break;
            case "Status":
                sql += " WHERE os.status = ?";
                break;
            case "Período de Abertura":
                sql += " WHERE os.data_abertura >= ? AND os.data_abertura < ?";
                break;
            default:
                JOptionPane.showMessageDialog(this, "Filtro inválido!");
                return;
        }
        
        sql += " ORDER BY os.id";
        
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)){
            
            switch (tipo_pesquisa) {
                case "Número da OS" -> stmt.setInt(1, Integer.parseInt(pesquisa));
                case "Status" -> stmt.setString(1, pesquisa.toUpperCase().replace(" ", "_"));
                case "Período de Abertura" -> {
                    DateTimeFormatter formato = DateTimeFormatter
                            .ofPattern("dd/MM/uuuu")
                            .withResolverStyle(ResolverStyle.STRICT);
                    LocalDate inicio = LocalDate.parse(
                            txtDataInicio.getText().trim(), formato);
                    LocalDate fim = LocalDate.parse(
                            txtDataFim.getText().trim(), formato);
                    if (fim.isBefore(inicio)) {
                        
                        JOptionPane.showMessageDialog(this,
                                "A data final não pode ser anterior à inicial!");
                        return;
                    }       stmt.setTimestamp(1,
                            java.sql.Timestamp.valueOf(inicio.atStartOfDay()));
                    stmt.setTimestamp(2,
                            java.sql.Timestamp.valueOf(fim.plusDays(1).atStartOfDay()));
                }
                default -> stmt.setString(1, "%" +pesquisa+ "%");
            }
            
            DefaultTableModel modelo = (DefaultTableModel) tblOS.getModel();
            
            try(ResultSet rs = stmt.executeQuery()){
                
                modelo.setRowCount(0);
                
                while(rs.next()){
                    modelo.addRow(new Object []{
                     rs.getInt("id"), rs.getString("placa"),
                     rs.getString("cliente"), rs.getString("mecanico"),
                     rs.getString("servico"), rs.getTimestamp("data_abertura"),
                     rs.getString("status"), rs.getBigDecimal("valor_cobrado"),
                     rs.getTimestamp("data_conclusao")   
                    });
                }
            }
            
            if(modelo.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Nenhuma Ordem de Servico encontrada!");
            } 
            
        }catch(NumberFormatException erro){
            JOptionPane.showMessageDialog(this, "ID invalido!");
            
        }catch(DateTimeParseException erro){
            JOptionPane.showMessageDialog(this, "Data inválida! Use DD/MM/AAAA.");
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao localizar OS: " + erro.getMessage());
        }
        
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha = tblOS.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma Ordem de Serviço!");
        return;
    }

    int linhaModelo = tblOS.convertRowIndexToModel(linha);

    int id = Integer.parseInt(
            tblOS.getModel().getValueAt(linhaModelo, 0).toString());

    int posMecanico = cbMecanico.getSelectedIndex();
    int posServico = cbServico.getSelectedIndex();

    if (posMecanico < 0 || posMecanico >= idMecanicos.size()
            || posServico < 0 || posServico >= idServicos.size()) {

        JOptionPane.showMessageDialog(this, "Selecione um mecânico e um serviço!");
        return;
    }

    int mecanicoId = idMecanicos.get(posMecanico);
    int servicoId = idServicos.get(posServico);

    String diagnostico = txtDiagnostico.getText().trim();
    String observacao = txtObs.getText().trim();

    if (cbStatus.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this,
                "Selecione um status!");
        return;
    }

    String status = cbStatus.getSelectedItem().toString()
            .trim().toUpperCase().replace(" ", "_");

    if (!status.equals("ABERTA")
            && !status.equals("EM_ANDAMENTO")
            && !status.equals("CONCLUIDA")
            && !status.equals("CANCELADA")) {

        JOptionPane.showMessageDialog(this, "Status inválido!");
        return;
    }

    BigDecimal valor;

    try {
        String textoValor = txtValorCobrado.getText() .trim().replace(",", ".");

        valor = new BigDecimal(textoValor);

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(this, "O valor cobrado não pode ser negativo!");
            return;
        }

    } catch (NumberFormatException erro) {
        JOptionPane.showMessageDialog(this, "Informe um valor cobrado válido!");
        return;
    }

   
    DateTimeFormatter formato = DateTimeFormatter
        .ofPattern("dd/MM/uuuu")
        .withResolverStyle(ResolverStyle.STRICT);

            LocalDate dataConclusao = null;

            String textoData = txtDataConclusao.getText().trim();


            String numerosData = textoData.replaceAll("\\D", "");

        try {

             if (!numerosData.isEmpty()) {

              dataConclusao = LocalDate.parse(textoData, formato);

         }

         } catch (DateTimeParseException erro) {

             JOptionPane.showMessageDialog(this, "Data inválida! Use DD/MM/AAAA.");
         return;
  }

    if (status.equals("CONCLUIDA") && dataConclusao == null) {
        JOptionPane.showMessageDialog(this, "Informe a data de conclusão!");
        return;
    }

    if (!status.equals("CONCLUIDA") && dataConclusao != null) {
        JOptionPane.showMessageDialog(this, "Somente OS concluídas podem ter data de conclusão!");
        return;
    }

    String sql = """
        UPDATE ordem_servico
        SET mecanico_id = ?,
            servico_id = ?,
            diagnostico = ?,
            status = ?,
            valor_cobrado = ?,
            observacao = ?,
            data_conclusao = ?
        WHERE id = ?
        """;

    try (Connection conex = Conexao.conectar()) {

        String sqlVerificar = """
            SELECT data_abertura, status
            FROM ordem_servico
            WHERE id = ?
            """;

        LocalDate dataAbertura;
        String statusAtual;

        try (PreparedStatement stmt =
                conex.prepareStatement(sqlVerificar)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(this,
                            "Ordem de Serviço não encontrada!");
                    return;
                }

                dataAbertura = rs.getTimestamp("data_abertura")
                        .toLocalDateTime().toLocalDate();

                statusAtual = rs.getString("status");
            }
        }

        if (dataConclusao != null
                && dataConclusao.isBefore(dataAbertura)) {

            JOptionPane.showMessageDialog(this, "A conclusão não pode ser anterior à abertura!");
            return;
        }

        boolean transicaoValida =
                statusAtual.equals(status)
                || (statusAtual.equals("ABERTA")
                    && (status.equals("EM_ANDAMENTO")
                        || status.equals("CANCELADA")))
                || (statusAtual.equals("EM_ANDAMENTO")
                    && (status.equals("CONCLUIDA")
                        || status.equals("CANCELADA")));

        if (!transicaoValida) {
            JOptionPane.showMessageDialog(this, "Alteração de status não permitida: "
                                          + statusAtual + " para " + status);
            return;
        }

        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente alterar a OS nº " + id + "?",
                                                  "Confirmar alteração", JOptionPane.YES_NO_OPTION);

        if (opcao != JOptionPane.YES_OPTION) {
            return;
        }

        try (PreparedStatement stmt = conex.prepareStatement(sql)) {

            stmt.setInt(1, mecanicoId);
            stmt.setInt(2, servicoId);
            stmt.setString(3, diagnostico);
            stmt.setString(4, status);
            stmt.setBigDecimal(5, valor);
            stmt.setString(6, observacao);

            if (dataConclusao != null) {
                stmt.setTimestamp(7,
                        java.sql.Timestamp.valueOf(
                                dataConclusao.atStartOfDay()));
            } else {
                stmt.setNull(7, java.sql.Types.TIMESTAMP);
            }

            stmt.setInt(8, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                JOptionPane.showMessageDialog(this, "Ordem de Serviço alterada com sucesso!");

                atualizarTabela();

            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma Ordem de Serviço foi alterada!");
            }
        }

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(this, "Erro ao alterar OS: " + erro.getMessage());
      }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tblOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOSMouseClicked
         int linha = tblOS.getSelectedRow();

    if (linha == -1) {
        return;
    }

    int linhaModelo = tblOS.convertRowIndexToModel(linha);

    int id = Integer.parseInt(
            tblOS.getModel().getValueAt(linhaModelo, 0).toString());

    String sql = """
        SELECT os.*, v.placa, c.nome AS cliente
        FROM ordem_servico os
        JOIN veiculo v ON os.veiculo_id = v.id
        JOIN cliente c ON v.cliente_id = c.id
        WHERE os.id = ?
        """;

    try (Connection conex = Conexao.conectar();
         PreparedStatement stmt = conex.prepareStatement(sql)) {

        stmt.setInt(1, id);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {

                
                txtCliente.setText(rs.getString("cliente"));
                txtPlaca.setText(rs.getString("placa"));

                
                int idMecanico = rs.getInt("mecanico_id");
                int posMecanico = idMecanicos.indexOf(idMecanico);

                cbMecanico.setSelectedIndex(posMecanico);

                
                int idServico = rs.getInt("servico_id");
                int posServico = idServicos.indexOf(idServico);

                cbServico.setSelectedIndex(posServico);

                
                txtDiagnostico.setText(rs.getString("diagnostico"));
                txtObs.setText(rs.getString("observacao"));

                
                String status = rs.getString("status");

                cbStatus.setSelectedItem(status);

                
                BigDecimal valor = rs.getBigDecimal("valor_cobrado");

                txtValorCobrado.setText(valor.toString());

                
                DateTimeFormatter formato =
                        DateTimeFormatter.ofPattern("dd/MM/uuuu");

                
                java.sql.Timestamp abertura =
                        rs.getTimestamp("data_abertura");

                txtDataAbertura.setText(
                        abertura.toLocalDateTime()
                                .toLocalDate()
                                .format(formato));

               
                java.sql.Timestamp conclusao =
                        rs.getTimestamp("data_conclusao");

                if (conclusao != null) {

                    txtDataConclusao.setText(
                            conclusao.toLocalDateTime()
                                    .toLocalDate()
                                    .format(formato));

                } else {

                    txtDataConclusao.setText("");
                }
            }
        }

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(this, "Erro ao carregar OS: " + erro.getMessage());
     } 
    }//GEN-LAST:event_tblOSMouseClicked

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
          int linha = tblOS.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this,
                "Selecione uma Ordem de Serviço para excluir!");
        return;
    }

    int linhaModelo = tblOS.convertRowIndexToModel(linha);

    int id = Integer.parseInt(
            tblOS.getModel().getValueAt(linhaModelo, 0).toString());

    int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir a OS nº " + id + "?\n"
            + "Essa ação não poderá ser desfeita!",
            "Confirmar Exclusão",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
    );

    if (opcao != JOptionPane.YES_OPTION) {
        return;
    }

    String sql = "DELETE FROM ordem_servico WHERE id = ?";

    try (Connection conex = Conexao.conectar();
         PreparedStatement stmt = conex.prepareStatement(sql)) {

        stmt.setInt(1, id);

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {

            JOptionPane.showMessageDialog(this,
                    "Ordem de Serviço excluída com sucesso!");

            atualizarTabela();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Ordem de Serviço não encontrada!");
        }

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(this,
                "Erro ao excluir OS: " + erro.getMessage());
     } 
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
         if (cbStatus.getSelectedItem() == null) {
        return;
    }

    String status = cbStatus.getSelectedItem().toString();

    if (status.equals("CONCLUIDA")) {

        LocalDate hoje = LocalDate.now();

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        txtDataConclusao.setText(hoje.format(formato));
    }
    }//GEN-LAST:event_cbStatusActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmConsultaOS().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox<String> cbMecanico;
    private javax.swing.JComboBox<String> cbPesquisarPor;
    private javax.swing.JComboBox<String> cbServico;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tblOS;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtDataAbertura;
    private javax.swing.JFormattedTextField txtDataConclusao;
    private javax.swing.JFormattedTextField txtDataFim;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextField txtNOS;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtValorCobrado;
    // End of variables declaration//GEN-END:variables
}
