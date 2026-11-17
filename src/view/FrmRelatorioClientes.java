package view;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmRelatorioClientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmRelatorioClientes.class.getName());

    
    public FrmRelatorioClientes() {
        initComponents();
        
        btnRelatorio.doClick();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        cbSituacao = new javax.swing.JComboBox<>();
        btnRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        txtAtivos = new javax.swing.JTextField();
        txtInativos = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();

        jButton3.setText("Gerar Relatorio");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Ativos", "Inativos" }));
        cbSituacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Situacao"));
        cbSituacao.addActionListener(this::cbSituacaoActionPerformed);

        btnRelatorio.setText("Gerar Relatorio");
        btnRelatorio.addActionListener(this::btnRelatorioActionPerformed);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "Email", "Situação"
            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

        txtAtivos.setEditable(false);
        txtAtivos.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtAtivos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAtivos.setBorder(javax.swing.BorderFactory.createTitledBorder("Ativos"));

        txtInativos.setEditable(false);
        txtInativos.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtInativos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInativos.setBorder(javax.swing.BorderFactory.createTitledBorder("Inativos"));

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(txtAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtInativos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInativos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSituacaoActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
         String situacao = cbSituacao.getSelectedItem().toString();

    String sql = """
        SELECT id, nome, cpf, telefone, email, ativo
        FROM cliente
        """;

    if (situacao.equals("Ativos")) {
        sql += " WHERE ativo = TRUE ";
    } else if (situacao.equals("Inativos")) {
        sql += " WHERE ativo = FALSE ";
    }

    sql += " ORDER BY nome";

    DefaultTableModel modelo =
            (DefaultTableModel) tblClientes.getModel();

    try (Connection conex = Conexao.conectar();
         PreparedStatement stmt = conex.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        modelo.setRowCount(0);

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getBoolean("ativo") ? "Ativo" : "Inativo"
            });
        }

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(this,
                "Erro ao gerar relatório: " + erro.getMessage());
        return;
    }

    String sqlTotais = """
        SELECT COUNT(*) AS total,
               COUNT(*) FILTER (WHERE ativo = TRUE) AS ativos,
               COUNT(*) FILTER (WHERE ativo = FALSE) AS inativos
        FROM cliente
        """;

    try (Connection conex = Conexao.conectar();
         PreparedStatement stmt = conex.prepareStatement(sqlTotais);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            txtTotal.setText(rs.getString("total"));
            txtAtivos.setText(rs.getString("ativos"));
            txtInativos.setText(rs.getString("inativos"));
        }

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(this,
                "Erro ao carregar indicadores: " + erro.getMessage());
    }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

 
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
        java.awt.EventQueue.invokeLater(() -> new FrmRelatorioClientes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtAtivos;
    private javax.swing.JTextField txtInativos;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
