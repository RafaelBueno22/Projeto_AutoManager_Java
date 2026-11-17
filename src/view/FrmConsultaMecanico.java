package view;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmConsultaMecanico extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmConsultaMecanico.class.getName());

        private void atualizarTabela(){
            DefaultTableModel modelo = (DefaultTableModel) tblMecanicos.getModel();
            modelo.setRowCount(0);
            
            String sql = """
                         SELECT id, nome, especialidade, telefone, data_admissao, ativo
                         FROM mecanico ORDER BY id
                         """;
            
            try(Connection conex = Conexao.conectar();
                PreparedStatement stmt = conex.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
                
                while(rs.next()){
                    modelo.addRow(new Object[]{
                        rs.getInt("id"), rs.getString("nome"),
                        rs.getString("especialidade"), rs.getString("telefone"),
                        rs.getString("data_admissao"), rs.getBoolean("ativo")
                    });
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(this, "Erro ao atualizar: " +erro.getMessage());
            }
        }
    
    public FrmConsultaMecanico() {
        initComponents();
        
        tblMecanicos.setModel(new DefaultTableModel(new Object [][]{},
                              new String []{"ID", "Nome", "Especialidade", "Telefone", "Data de Admissao", "Ativo"}){
                        @Override
                        public boolean isCellEditable (int linha, int coluna){
                            return false;
                        }
                              });
        
        atualizarTabela();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbPesquisarPor = new javax.swing.JComboBox<>();
        txtPesquisar = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMecanicos = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEspecialidade = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        chkAtivo = new javax.swing.JCheckBox();
        btnLocalizar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

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

        cbPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome", "Especialidade", " " }));
        cbPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro:"));

        txtPesquisar.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar:"));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);

        tblMecanicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Especialidade", "Telefone", "Data de Admissão", "Ativo"
            }
        ));
        tblMecanicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMecanicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMecanicos);

        txtID.setEditable(false);
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));

        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome:"));

        txtEspecialidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Especialidade"));

        txtData.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Admissão:"));

        txtTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone:"));
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        chkAtivo.setSelected(true);
        chkAtivo.setText("Ativo");

        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(this::btnLocalizarActionPerformed);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(this::btnAlterarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(cbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefone))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(144, 144, 144)
                                .addComponent(chkAtivo)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbPesquisarPor))
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(txtTelefone))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chkAtivo)
                        .addGap(16, 16, 16)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        String pesquisa = txtPesquisar.getText().trim();
        
        if(pesquisa.isEmpty()){
            JOptionPane.showMessageDialog(this, "Digite o nome ou parte do nome do Mecanico", "Pesquisa Vazia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblMecanicos.getModel();
        modelo.setRowCount(0);
        String tipo_pesquisa = cbPesquisarPor.getSelectedItem().toString();
        
        String sql = "";
        
        if(tipo_pesquisa == "ID"){
            sql = """
                  SELECT * FROM mecanico
                  WHERE id = ?
                  ORDER BY id
                  """;
        }else if(tipo_pesquisa == "Nome"){
            sql = """
                  SELECT * FROM mecanico
                  WHERE nome = ?
                  ORDER BY nome
                  """;
        }else{
            sql = """
                  SELECT * FROM mecanico
                  WHERE especialidade = ?
                  ORDER BY especialidade
                  """;
        }
        
        try{
            if(tipo_pesquisa == "ID"){
                int id = Integer.parseInt(txtPesquisar.getText().toString());
            }
        }catch(NumberFormatException erro){
            JOptionPane.showMessageDialog(this, "Informe valores numericos validos!");
            return;
        }
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)){
            if(tipo_pesquisa == "ID"){
                int id = Integer.parseInt(txtPesquisar.getText().toString());
                stmt.setInt(1, id);
            }else{
                stmt.setString(1, "%" +pesquisa+ "%");
            }
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    modelo.addRow(new Object []{
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especialidade"),
                        rs.getString("telefone"),
                        rs.getString("data_admissao"),
                        rs.getBoolean("ativo")
                    });
                }
            }
            if(modelo.getRowCount() ==0) {
                JOptionPane.showMessageDialog(this,
                        "Nenhum Mecanico encontrado para: " + pesquisa,
                        "Resultado da Pesquisa",
                        JOptionPane.WARNING_MESSAGE);
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(this, 
                    "Erro ao localizar o Mecanico:\n" +erro.getMessage(),
                    "Erro no banco de dados",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha =  tblMecanicos.getSelectedRow();
        if(linha == -1){
            JOptionPane.showMessageDialog(this, "Selecione um Mecanico");
            return;
        }
        int id = Integer.parseInt(tblMecanicos.getValueAt(linha, 0).toString());
        String nome = txtNome.getText().trim();
        String especialidade = txtEspecialidade.getText().trim();
        String telefone = txtTelefone.getText();
        String data_admissao = txtData.getText();
        Boolean ativo = chkAtivo.isSelected();
        
        LocalDate dataAdmissao;
        
        try{
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
            
            dataAdmissao = LocalDate.parse(txtData.getText().trim(), formato);
        }catch(DateTimeParseException erro){
            JOptionPane.showMessageDialog(this, "Data Invalida");
            return;
        }
        
        int confirmacao = JOptionPane.showConfirmDialog(this,
                                "Deseja realmente alterar este mecanico?",
                                "Confirmar alteração",
                                JOptionPane.YES_NO_OPTION);
        
        if(confirmacao != JOptionPane.YES_OPTION)return;
        
        String sql = """
                     UPDATE mecanico
                     SET nome = ?,
                     especialidade = ?,
                     telefone = ?,
                     data_admissao = ?,
                     ativo = ?
                     WHERE id = ?                     
                     """;
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)){
                stmt.setString(1, nome);
                stmt.setString(2, especialidade);
                stmt.setString(3, telefone);
                stmt.setDate(4, java.sql.Date.valueOf(dataAdmissao));
                stmt.setBoolean(5, ativo);
                stmt.setInt(6, id);
                
                int linhasAlteradas = stmt.executeUpdate();
                
                if(linhasAlteradas >0){
                    JOptionPane.showMessageDialog(this, "Mecanico alterado com sucesso");
                    
                    atualizarTabela();
                }else{
                    JOptionPane.showMessageDialog(this, "Mecanico nao encontrado");
                }
                
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao alterar mecanico - Erro: " +erro.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tblMecanicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMecanicosMouseClicked
        int linha = tblMecanicos.getSelectedRow();
        if(linha == -1)return;
        
        txtID.setText(tblMecanicos.getValueAt(linha, 0).toString());
        txtNome.setText(tblMecanicos.getValueAt(linha, 1).toString());
        txtEspecialidade.setText(tblMecanicos.getValueAt(linha, 2).toString());
        txtTelefone.setText(tblMecanicos.getValueAt(linha, 3).toString());
        txtData.setText(tblMecanicos.getValueAt(linha, 4).toString());
        
        Object data = tblMecanicos.getModel().getValueAt(linha, 4);
        if(data != null) {
         LocalDate dataAdmissao = LocalDate.parse(data.toString());   
         
         txtData.setText(dataAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/uuuu")));
         
        }else{
            txtData.setText("");
        }
        
        chkAtivo.setSelected(Boolean.TRUE.equals(tblMecanicos.getValueAt(linha, 5)));
        
    }//GEN-LAST:event_tblMecanicosMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
    if (txtID.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Selecione um mecanico para excluir!");
        return;
    }

    int id = Integer.parseInt(txtID.getText().trim());

    
    int confirmar = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir este mecanico?",
            "Confirmar exclusao",
            JOptionPane.YES_NO_OPTION
    );

    if (confirmar != JOptionPane.YES_OPTION) {
        return;
    }

    
    String sqlVerificar = """
        SELECT COUNT(*)
        FROM ordem_servico
        WHERE mecanico_id = ?
        """;

    try (Connection conex = Conexao.conectar()) {

        int quantidade = 0;

        try (PreparedStatement stmt = conex.prepareStatement(sqlVerificar)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    quantidade = rs.getInt(1);
                }
            }
        }

       
        if (quantidade > 0) {

            int opcao = JOptionPane.showConfirmDialog(
                    this,
                    "Este mecanico possui " + quantidade
                    + " Ordem(ns) de Servico vinculada(s).\n"
                    + "Nao é possível exclui-lo.\n\n"
                    + "Deseja desativar o mecanico?",
                    "Mecanico com OS vinculada",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (opcao == JOptionPane.YES_OPTION) {

                String sqlDesativar = """
                    UPDATE mecanico
                    SET ativo = FALSE
                    WHERE id = ?
                    """;

                try (PreparedStatement stmt =
                        conex.prepareStatement(sqlDesativar)) {

                    stmt.setInt(1, id);

                    int linhas = stmt.executeUpdate();

                    if (linhas > 0) {
                        JOptionPane.showMessageDialog(this,
                                "Mecanico desativado com sucesso!");
                    }
                }
            }

        } else {

             
            String sqlExcluir = """
                DELETE FROM mecanico
                WHERE id = ?
                """;

            try (PreparedStatement stmt =
                    conex.prepareStatement(sqlExcluir)) {

                stmt.setInt(1, id);

                int linhas = stmt.executeUpdate();

                if (linhas > 0) {
                    JOptionPane.showMessageDialog(this,
                            "Mecanico excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Mecanico não encontrado!");
                }
            }
        }

       
        atualizarTabela();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(this,
                "Erro ao excluir mecanico: " + erro.getMessage());
     } 
    }//GEN-LAST:event_btnExcluirActionPerformed

    
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
        java.awt.EventQueue.invokeLater(() -> new FrmConsultaMecanico().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox<String> cbPesquisarPor;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMecanicos;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEspecialidade;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
