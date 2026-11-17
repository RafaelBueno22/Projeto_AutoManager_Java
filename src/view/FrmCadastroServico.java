package view;
import conexao.Conexao;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FrmCadastroServico extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCadastroServico.class.getName());

    private void limparCampos(){
        txtDescricao.setText("");
        txtCategoria.setText("");
        txtValorBase.setText("");
        txtTempoEstimado.setText("");
        txtObservacao.setText("");
        chkAtivo.setSelected(true);
        txtDescricao.requestFocus();
    }
    public FrmCadastroServico() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtValorBase = new javax.swing.JTextField();
        txtTempoEstimado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        chkAtivo = new javax.swing.JCheckBox();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtId.setEditable(false);
        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));

        txtDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descricao"));

        txtCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));

        txtValorBase.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Base"));

        txtTempoEstimado.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo Estimado"));

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        txtObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Observacao"));
        jScrollPane1.setViewportView(txtObservacao);

        chkAtivo.setSelected(true);
        chkAtivo.setText("Ativo");

        btnLimpar.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(this::btnLimparActionPerformed);

        btnFechar.setBackground(new java.awt.Color(102, 0, 0));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnCadastrar.setBackground(new java.awt.Color(0, 102, 0));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(this::btnCadastrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTempoEstimado, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(txtValorBase)
                            .addComponent(txtCategoria)
                            .addComponent(txtDescricao)
                            .addComponent(txtId))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkAtivo)
                                .addGap(189, 189, 189)
                                .addComponent(btnFechar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtValorBase, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkAtivo)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String descricao = txtDescricao.getText().trim();
        String categoria = txtCategoria.getText().trim();
        String observacao = txtObservacao.getText().trim();
        boolean ativo = chkAtivo.isSelected();

    if (descricao.isEmpty() || categoria.isBlank()) {
        JOptionPane.showMessageDialog(this,
                "Descrição e categoria são obrigatórias!");
        return;
    }
    
    BigDecimal valorBase;
    BigDecimal tempoEstimado = null;
    
    try {
        valorBase = new BigDecimal(
                txtValorBase.getText().trim().replace(",", ".")
        );

        if (valorBase.compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(this,
                    "O valor não pode ser negativo!");
            return;
        }

        String tempoTexto = txtTempoEstimado.getText().trim();

        if (!tempoTexto.isEmpty()) {
            tempoEstimado = new BigDecimal(
                    tempoTexto.replace(",", ".")
            );

            if (tempoEstimado.compareTo(BigDecimal.ZERO) <= 0) {
                JOptionPane.showMessageDialog(this,
                        "O tempo deve ser maior que zero!");
                return;
            }
        }

    } catch (NumberFormatException erro) {
        JOptionPane.showMessageDialog(this,
                "Informe valores numéricos válidos!");
        return;
    }
    
        String sqlInsert = """
                           INSERT INTO servico
                           (descricao,categoria,valor_base,tempo_estimado_horas,observacao,ativo)
                           VALUES (?,?,?,?,?,?)
                           """;
        
        try {
            Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sqlInsert);
            
            stmt.setString(1, descricao);
            stmt.setString(2, categoria);
            stmt.setBigDecimal(3, valorBase);
            
            if (tempoEstimado == null) {
            stmt.setNull(4, java.sql.Types.NUMERIC);
        } else {
            stmt.setBigDecimal(4, tempoEstimado);
        }
            
            stmt.setString(5, observacao);
            stmt.setBoolean(6, ativo);
            
            int linhas = stmt.executeUpdate();
            if(linhas >0){
            JOptionPane.showMessageDialog(this, "Cadastrado realizado com sucesso!");
            limparCampos();
            }
                    
                   
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(this, "Não foi possível Cadastrar! - Erro" + erro.getMessage());
        }       

        

    }//GEN-LAST:event_btnCadastrarActionPerformed
        
    
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
        java.awt.EventQueue.invokeLater(() -> new FrmCadastroServico().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtTempoEstimado;
    private javax.swing.JTextField txtValorBase;
    // End of variables declaration//GEN-END:variables
}
