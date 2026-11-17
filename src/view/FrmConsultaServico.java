package view;

import conexao.Conexao;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;


public class FrmConsultaServico extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmConsultaServico.class.getName());
    
    private void atualizarTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tblServicos.getModel();
        modelo.setRowCount(0);
        
        String sql = """
                     SELECT id, descricao, categoria, valor_base, tempo_estimado_horas, ativo
                     FROM servico ORDER BY id
                     """;
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
                
                 while(rs.next()){
                   modelo.addRow(new Object []{
                       rs.getInt("id"), rs.getString("descricao"),
                       rs.getString("categoria"), rs.getBigDecimal("valor_base"),
                       rs.getBigDecimal("tempo_estimado_horas"), rs.getBoolean("ativo")
                   });            
            }
        }catch(SQLException erro){
             JOptionPane.showMessageDialog(this, "Erro ao atualizar: " +erro.getMessage());
        }         
    }
  
    public FrmConsultaServico() {
        initComponents();
        
        atualizarTabela();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbPesquisarPor = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtPesquisar = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtValorBase = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtTempoEstimado = new javax.swing.JTextField();
        chkAtivo = new javax.swing.JCheckBox();
        btnAlterar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Descricao", "Categoria", " " }));
        cbPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1109, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        txtPesquisar.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));

        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(this::btnLocalizarActionPerformed);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Categoria", "Valor Base", "Tempo Estimado", "Ativo"
            }
        ));
        tblServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicos);

        txtID.setEditable(false);
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));

        txtDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        txtValorBase.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Base (R$)"));

        txtCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));

        txtTempoEstimado.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo Estimado"));

        chkAtivo.setSelected(true);
        chkAtivo.setText("Ativo");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(this::btnAlterarActionPerformed);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorBase, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addComponent(chkAtivo)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPesquisarPor)
                    .addComponent(btnLocalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorBase, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAtivo)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        String pesquisa = txtPesquisar.getText().trim();
        
        if(pesquisa.isEmpty()){
            JOptionPane.showMessageDialog(this, "Digite nome ou parte do servico", "Pesquisa Vazia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblServicos.getModel();
        modelo.setRowCount(0);
        String tipo_pesquisa = cbPesquisarPor.getSelectedItem().toString();
        
       String sql = "";
       
       if(tipo_pesquisa == "ID"){
           sql = """
                 SELECT * FROM servico
                 WHERE id = ?
                 ORDER BY id
                 """;
       }else if(tipo_pesquisa == "Descricao"){
           sql = """
                 SELECT * FROM servico
                 WHERE descricao = ?
                 ORDER BY descricao
                 """;
       }else{
           sql = """
                 SELECT * FROM servico
                 WHERE categoria = ?
                 ORDER BY categoria
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
                       rs.getInt("id"), rs.getString("descricao"),
                       rs.getString("categoria"), rs.getBigDecimal("valor_base"),
                       rs.getBigDecimal("tempo_estimado_horas"), rs.getBoolean("ativo")
                   });
               }
           }
           if(modelo.getRowCount() ==0){
               JOptionPane.showMessageDialog(this,
                        "Nenhum Serviço encontrado para: " + pesquisa,
                        "Resultado da Pesquisa",
                        JOptionPane.WARNING_MESSAGE);
           }
       }catch(SQLException erro){
             JOptionPane.showMessageDialog(this, 
                    "Erro ao localizar o Serviço:\n" +erro.getMessage(),
                    "Erro no banco de dados",
                    JOptionPane.WARNING_MESSAGE);
       } 
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       int linha = tblServicos.getSelectedRow();
       if(linha == -1){
           JOptionPane.showMessageDialog(this, "Selecione um Servico");
           return;
       }
       int id = Integer.parseInt(tblServicos.getValueAt(linha, 0).toString());
       String descricao = txtDescricao.getText().trim();
       String categoria = txtCategoria.getText().trim();
       Boolean ativo = chkAtivo.isSelected();
       
       BigDecimal valorBase;
       BigDecimal tempoEstimado = null;
       
       try{
           valorBase = new BigDecimal(
                txtValorBase.getText().trim().replace(",", ".")
           );
           if(valorBase.compareTo(BigDecimal.ZERO) <0){
               JOptionPane.showMessageDialog(this, "O valor nao pode ser negativo!");
               return;
           }
           String tempoTexto = txtTempoEstimado.getText().trim();
           
           if(!tempoTexto.isEmpty()){
               tempoEstimado = new BigDecimal (
               tempoTexto.replace(",", ".")
               );
               
               if(tempoEstimado.compareTo(BigDecimal.ZERO) <= 0){
                   JOptionPane.showMessageDialog(this, "O tempo deve ser maior que zero!");
                   return;
               }
           }
       }catch(NumberFormatException erro){
           JOptionPane.showMessageDialog(this, "Informe valores numericos validos!");
           return;
       }
       
       int confirmacao = JOptionPane.showConfirmDialog(this,
                                "Deseja realmente alterar este Serviço?",
                                "Confirmar alteração",
                                JOptionPane.YES_NO_OPTION);
        
        if(confirmacao != JOptionPane.YES_OPTION)return;
        
        String sql = """
                     UPDATE servico
                     SET descricao = ?,
                     categoria = ?,
                     valor_base = ?,
                     tempo_estimado_horas = ?,
                     ativo = ?
                     WHERE id = ?
                     """;
        
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)){
            
            stmt.setString(1, descricao);
            stmt.setString(2, categoria);
            stmt.setBigDecimal(3, valorBase);
            
            if(tempoEstimado == null){
                stmt.setNull(4, java.sql.Types.NUMERIC);
            }else{
                stmt.setBigDecimal(4, tempoEstimado);
            }
            stmt.setBoolean(5, ativo);
            stmt.setInt(6, id);
            
            int linhasAlteradas = stmt.executeUpdate();
            if(linhasAlteradas >0){
                JOptionPane.showMessageDialog(this, "Servico alterado com sucesso!");
                atualizarTabela();
            }else{
                JOptionPane.showMessageDialog(this, "Servico nao encontrado!");
                
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao alterar o servico: " +erro.getMessage());
            
        }
        
        
       
       
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tblServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicosMouseClicked
        int linha = tblServicos.getSelectedRow();
        if(linha == -1)return;
        
        txtID.setText(tblServicos.getValueAt(linha, 0).toString());
        txtDescricao.setText(tblServicos.getValueAt(linha, 1).toString());
        txtCategoria.setText(tblServicos.getValueAt(linha, 2).toString());
        txtValorBase.setText(tblServicos.getValueAt(linha, 3).toString());
        txtTempoEstimado.setText(tblServicos.getValueAt(linha, 4).toString());
        chkAtivo.setSelected(Boolean.TRUE.equals(tblServicos.getValueAt(linha, 5)));
    }//GEN-LAST:event_tblServicosMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(txtID.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Selecione um servico para excluir!");
            return;
        }
        int id = Integer.parseInt(txtID.getText().trim());
        
        int confirmar = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este serviço?",
                "Confirmar exclusao",
                JOptionPane.WARNING_MESSAGE);
        
        if(confirmar != JOptionPane.YES_OPTION)return;
        
        String sqlVerificar = """
                              SELECT COUNT(*)
                              FROM ordem_servico
                              WHERE servico_id = ?
                              """;
        
        try(Connection conex = Conexao.conectar()){
            int quantidade = 0;
            
            try (PreparedStatement stmt = conex.prepareStatement(sqlVerificar)){
                stmt.setInt(1, id);
                
                try(ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        quantidade = rs.getInt(1);
                    }
                }
            }
            
            if(quantidade >0){
                int opcao = JOptionPane.showConfirmDialog(
                        this,
                        "Este Serviço possui " + quantidade
                    + " Ordem(ns) de Servico vinculada(s).\n"
                    + "Nao é possível exclui-lo.\n\n"
                    + "Deseja desativar o mecanico?",
                    "Mecanico com OS vinculada",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
               );
                if(opcao == JOptionPane.YES_OPTION){
                    String sqlDesativar = """
                                          UPDATE servico
                                          SET ativo = FALSE
                                          WHERE id = ?
                                          """;
                    
                    try(PreparedStatement stmt = conex.prepareStatement(sqlDesativar)){
                        stmt.setInt(1, id);
                        
                        int linhas = stmt.executeUpdate();
                        if(linhas > 0 ){
                            JOptionPane.showMessageDialog(this, "Serviço desativado com sucesso!");
                        }
                    }
                }
            }else{
                
                String sqlExcluir = """
                                    DELETE FROM servico
                                    WHERE id = ?
                                    """;
                
                try(PreparedStatement stmt = conex.prepareStatement(sqlExcluir)){
                    
                    stmt.setInt(1, id);
                    
                    int linhas = stmt.executeUpdate();
                    
                    if(linhas > 0){
                        JOptionPane.showMessageDialog(this, "Serviço excluido com sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(this, "Serviço não encontrado!");
                    }
                }
            }
            atualizarTabela();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao excluir serviço: " +erro.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmConsultaServico().setVisible(true));
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
    private javax.swing.JTable tblServicos;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtTempoEstimado;
    private javax.swing.JTextField txtValorBase;
    // End of variables declaration//GEN-END:variables
}
