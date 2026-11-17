
package view;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.Conexao;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class FrmCadastroVeiculo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCadastroVeiculo.class.getName());

    private ArrayList<Integer> idClientes = new ArrayList<>();

   
    
    
    public FrmCadastroVeiculo() {
        initComponents();
        carregarClientes("");
    }
    
    private void limparCampos(){
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAno.setText("");
        txtCor.setText("");
        txtObservacao.setText("");
        txtPesquisarCliente.setText("");
        cbCliente.setSelectedIndex(-1);
        chkAtivo.setSelected(true);
        carregarClientes("");
        txtPlaca.requestFocus();
    }
    
    private void carregarClientes(String pesquisa){
        String sql = """
                     SELECT id, nome
                     FROM cliente
                     WHERE ativo = TRUE
                     AND (
                     ? = ''
                     OR (? = TRUE AND CAST(id AS TEXT) = ?)
                     OR (? = FALSE AND (nome ILIKE ? ))
                     )
                     
                     """;
        
        cbCliente.removeAllItems();
        idClientes.clear();
        
        try (Connection conex = Conexao.conectar();
             PreparedStatement stmt = conex.prepareStatement(sql)){
            
            boolean pesquisaId = pesquisa.matches("\\d+");

            stmt.setString(1, pesquisa);
            stmt.setBoolean(2, pesquisaId);
            stmt.setString(3, pesquisa);
            stmt.setBoolean(4, pesquisaId);
            stmt.setString(5, "%" + pesquisa + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                
                cbCliente.addItem("ID: " + id + " - " + nome);
                idClientes.add(id);
                
            }
            
          }  
            
            cbCliente.setSelectedIndex(-1);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar clientes: " + erro.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        txtPesquisarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        txtPlaca = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        cbCliente = new javax.swing.JComboBox<>();
        txtAno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        chkAtivo = new javax.swing.JCheckBox();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtID.setEditable(false);
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        txtPesquisarCliente.setToolTipText("Digite aqui o ID do cliente:");
        txtPesquisarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        txtPesquisarCliente.addActionListener(this::txtPesquisarClienteActionPerformed);

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa_transparente_30x30.png"))); // NOI18N
        btnBuscarCliente.addActionListener(this::btnBuscarClienteActionPerformed);

        txtPlaca.setToolTipText("Digite aqui a placa do carro:");
        txtPlaca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Placa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        txtMarca.setToolTipText("Digite aqui a marca do carro:");
        txtMarca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Marca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        txtModelo.setToolTipText("Digite aqui o modelo do carro:");
        txtModelo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        txtModelo.addActionListener(this::txtModeloActionPerformed);

        txtCor.setToolTipText("Digite aqui a cor do carro:");
        txtCor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        txtAno.setBorder(javax.swing.BorderFactory.createTitledBorder("Ano"));

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        txtObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));
        jScrollPane2.setViewportView(txtObservacao);

        chkAtivo.setSelected(true);
        chkAtivo.setText("Veículo ativo");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtAno))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, 193, Short.MAX_VALUE)
                                            .addComponent(txtPesquisarCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMarca))))
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarCliente))
                            .addComponent(chkAtivo))
                        .addGap(0, 133, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkAtivo)
                        .addGap(0, 154, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarClienteActionPerformed
        
    }//GEN-LAST:event_txtPesquisarClienteActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
     
        int posicao = cbCliente.getSelectedIndex();
        
        if(posicao == -1){
            JOptionPane.showMessageDialog(this, "Selecione um Cliente!");
            return;
        }
        
        int idCliente = idClientes.get(posicao);
        
          String placa = txtPlaca.getText().trim().toUpperCase();
          String marca = txtMarca.getText().trim();
          String modelo = txtModelo.getText().trim();
          String cor = txtCor.getText().trim();
          String observacao = txtObservacao.getText().trim();
          boolean ativo = chkAtivo.isSelected();
          
          if(placa.isEmpty() || marca.isEmpty() || modelo.isEmpty()){
              JOptionPane.showMessageDialog(this, "Preencha placa, marca e modelo!");
              return;
          }
          
          int ano;
          
          try {
            ano = Integer.parseInt(txtAno.getText().trim());
            
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Digite um ano válido!");
            return;
        }
          
          if(ano < 1900 || ano > 2100){
              JOptionPane.showMessageDialog(this, "O ano deve ser entre 1900 e 2100!");
              return;
          }
        
        String sqlInsert = """
                           INSERT INTO veiculo
                           (cliente_id,placa,marca,modelo,ano,cor,observacao,ativo)
                           VALUES (?,?,?,?,?,?,?,?)
                           """;
        
        try {
            Connection conex = Conexao.conectar();
            PreparedStatement stmt = conex.prepareStatement(sqlInsert);
            
          stmt.setInt(1, idCliente);
          stmt.setString(2, placa);
          stmt.setString(3, marca);
          stmt.setString(4, modelo);
          stmt.setInt(5, ano);
          stmt.setString(6, cor);
          stmt.setString(7, observacao);
          stmt.setBoolean(8, ativo);                  

            int linhas = stmt.executeUpdate();
            if(linhas >0){
            JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");
            limparCampos();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o veículo: " + erro.getMessage());
        }
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
    String pesquisa = txtPesquisarCliente.getText().trim();
    
        carregarClientes(pesquisa);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmCadastroVeiculo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPesquisarCliente;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
