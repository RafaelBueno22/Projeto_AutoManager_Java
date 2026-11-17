package view;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmConsultaCliente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmConsultaCliente.class.getName());

  
        private void atualizarTabela(){
             DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
             modelo.setRowCount(0);
        
        String sql = """
                     SELECT id, nome, CPF, telefone, email, endereco, ativo
                     FROM cliente ORDER BY id
                     """;
        try (Connection conex = Conexao.conectar();
             PreparedStatement stmt = conex.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                modelo.addRow(new Object []{
                   rs.getInt("id"), rs.getString("nome"),
                   rs.getString("CPF"), rs.getString("telefone"),
                   rs.getString("email"), rs.getString("endereco"),
                   rs.getBoolean("ativo")
                });

            }
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + erro.getMessage());
        }
        }          
        
        
    public FrmConsultaCliente() {
        initComponents();
        
        
        tblClientes.setModel(new DefaultTableModel(new Object[][]{},
                             new String [] {"ID", "Nome", "CPF", "Telefone", "Email", "Endereco", "Idade"}){
                        @Override
                        public boolean isCellEditable(int linha, int coluna){
                            return false;
                        }
                             
                             });
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        atualizarTabela();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbPesquisarPor = new javax.swing.JComboBox<>();
        txtPesquisar = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        chkAtivo = new javax.swing.JCheckBox();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        txtCPF = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome", "CPF" }));
        cbPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar por"));

        txtPesquisar.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor pesquisado"));

        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(this::btnLocalizarActionPerformed);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "Email", "Endereço", "Ativo"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Editar cliente selecionado");

        txtID.setEditable(false);
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        txtID.addActionListener(this::txtIDActionPerformed);

        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));

        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        txtEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        chkAtivo.setSelected(true);
        chkAtivo.setText("Ativo");
        chkAtivo.setToolTipText("");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(this::btnAlterarActionPerformed);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        txtCPF.setBorder(javax.swing.BorderFactory.createTitledBorder("CPF"));
        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone"));
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addComponent(txtID))
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLocalizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizar))
                            .addComponent(chkAtivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPesquisar)
                    .addComponent(cbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLocalizar)
                    .addComponent(btnAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefone)
                    .addComponent(txtCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAtivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnFechar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed

        String pesquisa = txtPesquisar.getText().trim();
        
        if(pesquisa.isEmpty()){
            JOptionPane.showMessageDialog(
                    this,
                    "Digite o nome ou parte do nome do Cliente.",
                    "Pesquisa Vazia",
                     JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        
        modelo.setRowCount(0);
        
        String tipo_pesquisa = cbPesquisarPor.getSelectedItem().toString();
        
        String sql = "";
        
        if(tipo_pesquisa == "ID"){
            sql = """
                  SELECT * FROM cliente
                  WHERE id = ?
                  ORDER BY id
                  """;
        }else if(tipo_pesquisa == "Nome" ){
            sql = """
                  SELECT * FROM cliente
                  WHERE nome ILIKE ?
                  ORDER BY nome
                  """;
        }else{
        sql = """
              SELECT * FROM cliente
              WHERE cpf ILIKE ?
              ORDER BY cpf
              """;
        }
        
        try {
            if(tipo_pesquisa == "ID"){
               int id = Integer.parseInt(txtPesquisar.getText().toString());
                
    }
        } catch (NumberFormatException erro) {
        JOptionPane.showMessageDialog(this,
                "Informe valores numéricos válidos!");
        return;

        }
        try (
             Connection conex = Conexao.conectar();
             PreparedStatement stmt = conex.prepareStatement(sql)){
            if(tipo_pesquisa == "ID"){
               int id = Integer.parseInt(txtPesquisar.getText().toString());
                stmt.setInt(1, id);
            }else{
        stmt.setString(1, "%" +pesquisa+ "%");
    }  
            try (ResultSet resultado = stmt.executeQuery()){
                while (resultado.next()){
                    modelo.addRow(new Object [] {
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("CPF"),
                    resultado.getString("telefone"),
                    resultado.getString("email"),
                    resultado.getString("endereco"),
                    resultado.getBoolean("ativo")});
                }
            }
            if(modelo.getRowCount() ==0) {
                JOptionPane.showMessageDialog(this,
                            "Nenhum Cliente encontrado para: " + pesquisa,
                            "Resultado da Pesquisa",
                            JOptionPane.INFORMATION_MESSAGE);
                 }
            }catch(SQLException erro){
                  JOptionPane.showMessageDialog(this,
                    "Erro ao localizar o Cliente:\n" + erro.getMessage(),
                    "Erro no banco de dados",
                     JOptionPane.ERROR_MESSAGE);  
                    }
    

    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblClientes.getSelectedRow();
        if(linha == -1){
           JOptionPane.showMessageDialog(this, "Selecione um Cliente.");
        return; 
        }
        int id = Integer.parseInt(tblClientes.getValueAt(linha,0).toString());
        int resposta = JOptionPane.showConfirmDialog(this,
        "Deseja excluir definitivamente o Cliente ID " + id + "?",
        "Confirmar exclusão", JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE);
    if (resposta != JOptionPane.YES_OPTION) return;
    
    String sqlVerificar = """
                          SELECT COUNT (*) FROM veiculo
                          WHERE cliente_id = ?
                          """;
    
            try(Connection conex = Conexao.conectar()){
                int quantidade = 0;
                
                try(PreparedStatement stmt = conex.prepareStatement(sqlVerificar)){
                    stmt.setInt(1, id);
                    
                    try(ResultSet rs = stmt.executeQuery()){
                        if(rs.next()){
                            quantidade = rs.getInt(1);
                        }
                    }
                }
                if (quantidade > 0){
                    int opcao = JOptionPane.showConfirmDialog(
                    this,
                    "Este cliente possui " + quantidade + " veículo(s) cadastrado(s).\n"
                    + "Não é possível excluí-lo.\n\n"
                    + "Deseja desativar o cliente?",
                    "Cliente com veículos",
                    JOptionPane.YES_NO_OPTION);
                    
                    if(opcao == JOptionPane.YES_OPTION){
                                String sqlDesativar = """
                                                      UPDATE cliente SET ativo = FALSE
                                                      WHERE id = ?
                                                      """;

                                 try (PreparedStatement stmt = conex.prepareStatement(sqlDesativar)) {

                                          stmt.setInt(1, id);
                                          stmt.executeUpdate();

                                          JOptionPane.showMessageDialog(this, "Cliente desativado com sucesso!");
                    }   
                  }
                    
                }else{
                        String sqlExcluir = """
                                            DELETE FROM cliente
                                            WHERE id = ?
                                            """;

                                try (PreparedStatement stmt = conex.prepareStatement(sqlExcluir)) {

                                            stmt.setInt(1, id);
                                            int linhas = stmt.executeUpdate();

                                        if (linhas > 0) {
                                                JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
                            } else {
                                                JOptionPane.showMessageDialog(this,"Cliente não encontrado!");
                       }
                     }
                }
                
                atualizarTabela();
            }catch(SQLException erro){
               JOptionPane.showMessageDialog(this, "Erro ao excluir cliente: " + erro.getMessage());
     } 

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        int linha = tblClientes.getSelectedRow();
        if(linha == -1) return;
        txtID.setText(tblClientes.getValueAt(linha, 0).toString());
        txtNome.setText(tblClientes.getValueAt(linha, 1).toString());
        txtCPF.setText(tblClientes.getValueAt(linha, 2).toString());
        txtTelefone.setText(tblClientes.getValueAt(linha, 3).toString());
        txtEmail.setText(tblClientes.getValueAt(linha, 4).toString());
        txtEndereco.setText(tblClientes.getValueAt(linha, 5).toString());
        chkAtivo.setSelected(Boolean.TRUE.equals(tblClientes.getValueAt(linha, 6)));
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha = tblClientes.getSelectedRow();
        if(linha == -1){
           JOptionPane.showMessageDialog(this, "Selecione um Cliente.");
           return; 
        }
        int id = Integer.parseInt(tblClientes.getValueAt(linha, 0).toString());
        String nome = txtNome.getText().trim();
        String CPF = txtCPF.getText();
        String telefone = txtTelefone.getText().trim();
        String email = txtEmail.getText().trim();
        String endereco = txtEndereco.getText().trim();
        boolean ativo = chkAtivo.isSelected();
        
        
        
        String CPFNumeros = CPF.replaceAll("\\D", "");
        
        if(CPFNumeros.length() != 11) {
           JOptionPane.showMessageDialog(this,
                "O CPF deve conter 11 números!"); 
           return;
        }
        
        int confirmacao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente alterar os dados deste cliente?",
            "Confirmar alteração",
            JOptionPane.YES_NO_OPTION);
        
        if (confirmacao != JOptionPane.YES_OPTION) {
        return;
    }
        
        String sql = """
                    UPDATE cliente
                    SET nome = ?,
                    cpf = ?,
                    telefone = ?,
                    email = ?,
                    endereco = ?,
                    ativo = ?
                    WHERE id = ?
                    """;
        
        try (Connection conex = Conexao.conectar();
         PreparedStatement stmt = conex.prepareStatement(sql)) {

                stmt.setString(1, nome);
                stmt.setString(2, CPF);
                stmt.setString(3, telefone);
                stmt.setString(4, email);
                stmt.setString(5, endereco);
                stmt.setBoolean(6, ativo);
                stmt.setInt(7, id);

        int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {

                JOptionPane.showMessageDialog(this,
                    "Cliente alterado com sucesso!");

            atualizarTabela();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Cliente não encontrado!");
            }

        } catch (SQLException erro) {

        JOptionPane.showMessageDialog(this,
                "Erro ao alterar cliente: " + erro.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new FrmConsultaCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox<String> cbPesquisarPor;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}

