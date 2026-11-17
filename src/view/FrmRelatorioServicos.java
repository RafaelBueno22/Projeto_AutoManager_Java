package view;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmRelatorioServicos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmRelatorioServicos.class.getName());

    private void carregarCategorias(){
        cbCategoria.removeAllItems();
        cbCategoria.addItem("Todos");
        
        String sql = """
                     SELECT DISTINCT categoria
                     FROM servico
                     WHERE categoria IS NOT NULL
                     ORDER BY categoria
                     """;
        
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                
                cbCategoria.addItem(rs.getString("categoria"));
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao carregar categorias: " +erro.getMessage());
        }
        
    }

   
    public FrmRelatorioServicos() {
        initComponents();
        
        carregarCategorias();
        btnRelatorio.doClick();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        txtAtivos = new javax.swing.JTextField();
        txtInativos = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        cbCategoria = new javax.swing.JComboBox<>();
        btnRelatorio = new javax.swing.JButton();
        cbSituacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Categoria", "Valor Base", "Tempo Estimado", "Observação", "Situação"
            }
        ));
        jScrollPane1.setViewportView(tblServicos);

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

        cbCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Situacao"));

        btnRelatorio.setText("Gerar Relatorio");
        btnRelatorio.addActionListener(this::btnRelatorioActionPerformed);

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Ativos", "Inativos" }));
        cbSituacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Situacao"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(txtInativos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        String categoria = cbCategoria.getSelectedItem().toString();
        String situacao = cbSituacao.getSelectedItem().toString();
        
        String sql = """
                     SELECT id, descricao, categoria, valor_base,
                            tempo_estimado_horas, observacao, ativo
                     FROM servico
                     WHERE 1 = 1
                     """;
        
        if(!categoria.equals("Todos")){
            
            sql += " AND categoria = ?";
        }
        
        if(situacao.equals("Ativos")){
            
            sql += " AND ativo = TRUE";
            
        }else if(situacao.equals("Inativos")){
            
            sql += " AND ativo = FALSE";
        }
        
        sql += " ORDER BY id";
        
        DefaultTableModel modelo = (DefaultTableModel)  tblServicos.getModel();
        
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)){
            
            if(!categoria.equals("Todos")){
                
                stmt.setString(1, categoria);
            }
            
            try(ResultSet rs = stmt.executeQuery()){
                
                modelo.setRowCount(0);
                
                while(rs.next()){
                    
                    modelo.addRow(new Object []{
                        rs.getInt("id"), rs.getString("descricao"),
                        rs.getString("categoria"), rs.getBigDecimal("valor_base"),
                        rs.getString("tempo_estimado_horas"), rs.getString("observacao"),
                        rs.getBoolean("ativo") ? "Ativo" : "Inativo"
                    });
                }
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao gerar o relatorio: " +erro.getMessage());
            return;
        }
        
        String sqlTotais = """
                           SELECT COUNT(*) AS total,
                           COUNT(*) FILTER (WHERE ativo = TRUE) AS ativos,
                           COUNT(*) FILTER (WHERE ativo = FALSE) AS inativos
                           FROM servico
                           """;
        
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sqlTotais);
            ResultSet rs = stmt.executeQuery()){
            
            if(rs.next()){
                
                txtTotal.setText(rs.getString("total"));
                txtAtivos.setText(rs.getString("ativos"));
                txtInativos.setText(rs.getString("inativos"));
            }
            
        }catch(SQLException erro){
            
            JOptionPane.showMessageDialog(this, "Erro ao carregar indicadores: " +erro.getMessage());
        }
            
            
            
    }//GEN-LAST:event_btnRelatorioActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmRelatorioServicos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServicos;
    private javax.swing.JTextField txtAtivos;
    private javax.swing.JTextField txtInativos;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
