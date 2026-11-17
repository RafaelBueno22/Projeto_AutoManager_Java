package view;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmRelatorioVeiculos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmRelatorioVeiculos.class.getName());

    private void carregarFiltros(){
        
        cbCliente.removeAllItems();
        cbMarca.removeAllItems();
        
        cbCliente.addItem("Todos");
        cbMarca.addItem("Todos");
        
        String sqlClientes = """
                     SELECT DISTINCT c.nome
                     FROM cliente c
                     JOIN veiculo v ON v.cliente_id = c.id
                     ORDER BY c.nome
                     """;
        
        String sqlMarcas = """
                           SELECT DISTINCT marca
                           FROM veiculo
                           ORDER BY marca
                           """;
        
        try(Connection conex = Conexao.conectar()){
            
            try(PreparedStatement stmt = conex.prepareStatement(sqlClientes);
                ResultSet rs = stmt.executeQuery()){
                
                while(rs.next()){
                    cbCliente.addItem(rs.getString("nome"));
                }
            }
            try(PreparedStatement stmt = conex.prepareStatement(sqlMarcas);
                ResultSet rs = stmt.executeQuery()){
                
                while(rs.next()){
                cbMarca.addItem(rs.getString("marca"));
            }
           
            }     
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao carregar filtros: " +erro.getMessage());
        }
    }
    
    public FrmRelatorioVeiculos() {
        initComponents();
        
        carregarFiltros();
        btnRelatorio.doClick();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        cbSituacao = new javax.swing.JComboBox<>();
        btnRelatorio = new javax.swing.JButton();
        cbCliente = new javax.swing.JComboBox<>();
        cbMarca = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Placa", "Cliente", "Marca", "Modelo", "Ano", "Cor", "Situação"
            }
        ));
        jScrollPane1.setViewportView(tblVeiculos);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Total de veiculos"));

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Ativos", "Inativos" }));
        cbSituacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Situacao"));

        btnRelatorio.setText("Gerar Relatorio");
        btnRelatorio.addActionListener(this::btnRelatorioActionPerformed);

        cbCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        cbMarca.setBorder(javax.swing.BorderFactory.createTitledBorder("Marca"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.Alignment.LEADING, 0, 400, Short.MAX_VALUE)
                    .addComponent(cbCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbMarca)
                    .addComponent(cbCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        String cliente = cbCliente.getSelectedItem().toString();
        String marca = cbMarca.getSelectedItem().toString();
        String situacao = cbSituacao.getSelectedItem().toString();
        
        String sql = """
                     SELECT v.id, v.placa, c.nome AS cliente,
                            v.marca, v.modelo, v.ano, v.cor, v.ativo
                     FROM veiculo v
                     JOIN cliente c ON v.cliente_id = c.id
                     WHERE 1 = 1
                     """;
        
        if(!cliente.equals("Todos")){
            sql += " AND c.nome = ?";
        }
        
        if(!marca.equals("Todos")){
            sql += " AND v.marca = ?";
        }
        
        if(situacao.equals("Ativos")){
            sql += " AND v.ativo = TRUE";
        }else if(situacao.equals("Inativos")){
            sql += " AND v.ativo = FALSE";
        }
        
        sql += " ORDER BY v.id";
        
        DefaultTableModel modelo = (DefaultTableModel) tblVeiculos.getModel();
        
        try(Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sql)){
            
            int parametro = 1;
            
            if(!cliente.equals("Todos")){
                
                stmt.setString(parametro, cliente);
                parametro++;
            }
            if(!marca.equals("Todos")){
                stmt.setString(parametro, marca);
                parametro++;
            }
            
            try(ResultSet rs = stmt.executeQuery()){
                
                modelo.setRowCount(0);
                
                while (rs.next()){
                    
                    modelo.addRow(new Object []{
                        rs.getInt("id"), rs.getString("placa"),
                        rs.getString("cliente"), rs.getString("marca"),
                        rs.getString("modelo"), rs.getInt("ano"),
                        rs.getString("cor"), rs.getBoolean("ativo") ? "Ativo" : "Inativo"
                    });
                }
            }
            txtTotal.setText(String.valueOf(modelo.getRowCount()));
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao gerar o relatorio: " +erro.getMessage());
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
        java.awt.EventQueue.invokeLater(() -> new FrmRelatorioVeiculos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVeiculos;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
