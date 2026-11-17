package view;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmRelatorioMecanicos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmRelatorioMecanicos.class.getName());

    private void carregarEspecialidade(){
        
        cbEspecialidade.removeAllItems();
        cbEspecialidade.addItem("Todos");
        
        String sql = """
                     SELECT DISTINCT especialidade
                     FROM mecanico
                     WHERE especialidade IS NOT NULL
                     ORDER BY especialidade
                     """;
        
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                
                cbEspecialidade.addItem(rs.getString("especialidade"));
            }
        }catch(SQLException erro){
            
            JOptionPane.showMessageDialog(this, "Erro ao carregar especialidades: " +erro.getMessage());
        }
    }
   
    public FrmRelatorioMecanicos() {
        initComponents();
        
        carregarEspecialidade();
        btnRelatorio.doClick();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMecanicos = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        txtAtivos = new javax.swing.JTextField();
        txtInativos = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        cbEspecialidade = new javax.swing.JComboBox<>();
        btnRelatorio = new javax.swing.JButton();
        cbSituacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblMecanicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Especialidade", "Telefone", "Data Admissão", "Observação", "Situação"
            }
        ));
        jScrollPane1.setViewportView(tblMecanicos);

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

        cbEspecialidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Especialidade"));

        btnRelatorio.setText("Gerar Relatorio");
        btnRelatorio.addActionListener(this::btnRelatorioActionPerformed);

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Ativos", "Inativos" }));
        cbSituacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Situacao"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(txtAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtInativos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInativos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        String especialidade = cbEspecialidade.getSelectedItem().toString();
        String situacao = cbSituacao.getSelectedItem().toString();
        
        String sql = """
                     SELECT id, nome, especialidade, telefone,
                            data_admissao, observacao, ativo
                     FROM mecanico
                     WHERE 1 = 1
                     """;
        
        if(!especialidade.equals("Todos")){
            
            sql += " AND especialidade = ?";
        }
        
        if(situacao.equals("Ativos")){
            
            sql += " AND ativo = TRUE";
            
        }else if(situacao.equals("Inativos")){
            
            sql += " AND ativo = FALSE";
        }
        
        sql += " ORDER BY nome";
        
        DefaultTableModel modelo = (DefaultTableModel) tblMecanicos.getModel();
        
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)){
            
            if(!especialidade.equals("Todos")){
                
                stmt.setString(1, especialidade);
            }
            
            try(ResultSet rs = stmt.executeQuery()){
                
                modelo.setRowCount(0);
                
                while(rs.next()){
                    
                    modelo.addRow(new Object[]{
                        
                     rs.getInt("id"), rs.getString("nome"),
                     rs.getString("especialidade"), rs.getString("telefone"),
                     rs.getDate("data_admissao"), rs.getString("observacao"),
                     rs.getBoolean("ativo")? "Ativo" : "Inativo"   
                    });
                }
            }
        }catch(SQLException erro){
            
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatorio: " +erro.getMessage());
            return;
        }
        
        String sqlTotais = """
                           SELECT COUNT(*) AS total,
                           COUNT(*) FILTER (WHERE ativo = TRUE) AS ativos,
                           COUNT(*) FILTER (WHERE ativo = FALSE) AS inativos
                           FROM mecanico
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
        JOptionPane.showMessageDialog(this, "Erro ao carregar indicadores: " +erro.getMessage());
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
        java.awt.EventQueue.invokeLater(() -> new FrmRelatorioMecanicos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> cbEspecialidade;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMecanicos;
    private javax.swing.JTextField txtAtivos;
    private javax.swing.JTextField txtInativos;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
