package view;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.Conexao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class FrmCadastroOS extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCadastroOS.class.getName());

        private ArrayList<Integer> idVeiculos = new ArrayList<>();
        private ArrayList<Integer> idMecanicos = new ArrayList<>();
        private ArrayList<Integer> idServicos = new ArrayList<>();
        private ArrayList<BigDecimal> valoresServicos = new ArrayList<>();
        
        private void limparCampos(){
                
            txtPesquisarVeiculo.setText("");
            txtPesquisarMecanico.setText("");
            txtPesquisarServico.setText("");
            carregarVeiculos("");
            carregarMecanicos("");
            carregarServicos("");
            cbVeiculo.setSelectedIndex(-1);
            cbMecanico.setSelectedIndex(-1);
            cbServico.setSelectedIndex(-1);
            txtDescricao.setText("");
            txtDiagnostico.setText("");
            txtValorCobrado.setText("");
            txtObservacao.setText("");
            txtDescricao.requestFocus();

        }
                
        
        private void carregarServicos(String pesquisa){
            String sql = """
                         SELECT id, descricao, valor_base
                         FROM servico
                         WHERE ativo = TRUE
                         AND (
                         ? = ''
                         OR (? = TRUE AND CAST(id AS TEXT) = ?)
                         OR (? = FALSE AND descricao ILIKE ?)
                         )
                         ORDER BY id
                         """;
            
            cbServico.removeAllItems();
            idServicos.clear();
            valoresServicos.clear();
            
            try (
                 Connection conex = Conexao.conectar();
                 PreparedStatement stmt = conex.prepareStatement(sql);
                    ){
                boolean pesquisaId = pesquisa.matches("\\d+");

                stmt.setString(1, pesquisa);
                stmt.setBoolean(2, pesquisaId);
                stmt.setString(3, pesquisa);
                stmt.setBoolean(4, pesquisaId);
                stmt.setString(5, "%" + pesquisa + "%");

              try (ResultSet rs = stmt.executeQuery()) {
                  
                      while (rs.next()) {

                      int id = rs.getInt("id");
                      String descricao = rs.getString("descricao");
                      BigDecimal valorBase = rs.getBigDecimal("valor_base");
                      
                   
                      cbServico.addItem("ID: " +id+ " - " +descricao+ " - R$ " +valorBase);

                        idServicos.add(id);
                        valoresServicos.add(valorBase);
            }
        }

        cbServico.setSelectedIndex(-1);
        
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(this, "Erro ao pesquisar serviços: " + erro.getMessage());
            }
        }
        
        
        private void carregarMecanicos(String pesquisa){
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
                
        private void carregarVeiculos(String pesquisa){
            String sql = """
                         SELECT id, placa, marca, modelo
                             FROM veiculo
                             WHERE ativo = TRUE
                             AND (
                                 ? = ''
                                 OR (? = TRUE AND CAST(id AS TEXT) = ?)
                                 OR (? = FALSE AND (placa ILIKE ? OR modelo ILIKE ?))
                             )
                             ORDER BY id
                             """;
            
            cbVeiculo.removeAllItems();
            idVeiculos.clear();
            
            try (Connection conex = Conexao.conectar();
                 PreparedStatement stmt = conex.prepareStatement(sql) ){
                
                boolean pesquisaId = pesquisa.matches("\\d+");

                stmt.setString(1, pesquisa);
                stmt.setBoolean(2, pesquisaId);
                stmt.setString(3, pesquisa);
                stmt.setBoolean(4, pesquisaId);
                stmt.setString(5, "%" + pesquisa + "%");
                stmt.setString(6, "%" + pesquisa + "%");
                
                try(ResultSet rs = stmt.executeQuery()){
                
                    while(rs.next()){
                        int id = rs.getInt("id");
                        String placa = rs.getString("placa");
                        String marca = rs.getString("marca");
                        String modelo = rs.getString("modelo");
                        
                        cbVeiculo.addItem("ID: " +id+ " - " +placa+ " - " +marca+ " - " +modelo);
                        
                        idVeiculos.add(id);
                    }
                }
                
                cbVeiculo.setSelectedIndex(-1);
                
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(this, "Erro ao pesquisar veículos: " + erro.getMessage());
            }
        }
        
    public FrmCadastroOS() {
        initComponents();
        
        carregarVeiculos("");
        carregarMecanicos("");
        carregarServicos("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumeroOS = new javax.swing.JTextField();
        txtPesquisarVeiculo = new javax.swing.JTextField();
        btnPesquisarVeiculo = new javax.swing.JButton();
        cbVeiculo = new javax.swing.JComboBox<>();
        txtPesquisarMecanico = new javax.swing.JTextField();
        btnPesquisarMecanico = new javax.swing.JButton();
        cbMecanico = new javax.swing.JComboBox<>();
        txtPesquisarServico = new javax.swing.JTextField();
        cbServico = new javax.swing.JComboBox<>();
        btnPesquisarServico = new javax.swing.JButton();
        txtDataAbertura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        txtStatus = new javax.swing.JTextField();
        txtValorCobrado = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        txtDataConclusao = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnAbrirOS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNumeroOS.setEditable(false);
        txtNumeroOS.setBorder(javax.swing.BorderFactory.createTitledBorder("Numero da OS"));

        txtPesquisarVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar veículo"));

        btnPesquisarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa_transparente_30x30.png"))); // NOI18N
        btnPesquisarVeiculo.addActionListener(this::btnPesquisarVeiculoActionPerformed);

        txtPesquisarMecanico.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar mecanico"));

        btnPesquisarMecanico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa_transparente_30x30.png"))); // NOI18N
        btnPesquisarMecanico.addActionListener(this::btnPesquisarMecanicoActionPerformed);

        cbMecanico.addActionListener(this::cbMecanicoActionPerformed);

        txtPesquisarServico.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar serviço"));

        cbServico.addActionListener(this::cbServicoActionPerformed);

        btnPesquisarServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa_transparente_30x30.png"))); // NOI18N
        btnPesquisarServico.addActionListener(this::btnPesquisarServicoActionPerformed);

        txtDataAbertura.setEditable(false);
        txtDataAbertura.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Abertura"));

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        txtDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descricao do problema"));
        jScrollPane1.setViewportView(txtDescricao);

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setRows(5);
        txtDiagnostico.setBorder(javax.swing.BorderFactory.createTitledBorder("Diagnostico"));
        jScrollPane2.setViewportView(txtDiagnostico);

        txtStatus.setEditable(false);
        txtStatus.setText("ABERTA");
        txtStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        txtValorCobrado.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Cobrado (R$)"));

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        txtObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Observacao"));
        jScrollPane3.setViewportView(txtObservacao);

        txtDataConclusao.setEditable(false);
        txtDataConclusao.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de conclusao"));

        btnLimpar.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(this::btnLimparActionPerformed);

        btnFechar.setBackground(new java.awt.Color(102, 0, 0));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnAbrirOS.setBackground(new java.awt.Color(0, 102, 0));
        btnAbrirOS.setText("Abrir OS");
        btnAbrirOS.addActionListener(this::btnAbrirOSActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNumeroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisarServico))
                            .addComponent(cbMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisarMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarMecanico))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarVeiculo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtValorCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbrirOS)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataAbertura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarVeiculo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPesquisarMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPesquisarMecanico)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPesquisarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPesquisarServico))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txtValorCobrado))
                            .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                        .addComponent(txtDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnAbrirOS)
                    .addComponent(btnFechar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMecanicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMecanicoActionPerformed

    private void btnPesquisarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarVeiculoActionPerformed
        String pesquisa = txtPesquisarVeiculo.getText().trim().toUpperCase();
        
        
        carregarVeiculos(pesquisa);               
    }//GEN-LAST:event_btnPesquisarVeiculoActionPerformed

    private void btnPesquisarMecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarMecanicoActionPerformed
         String pesquisa = txtPesquisarMecanico.getText().trim();

         carregarMecanicos(pesquisa);
    }//GEN-LAST:event_btnPesquisarMecanicoActionPerformed

    private void btnPesquisarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarServicoActionPerformed
        String pesquisa = txtPesquisarServico.getText().trim();
        
         
         carregarServicos(pesquisa);
    }//GEN-LAST:event_btnPesquisarServicoActionPerformed

    private void cbServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServicoActionPerformed
         int posicao = cbServico.getSelectedIndex();

           if (posicao < 0 || posicao >= valoresServicos.size()) {
              txtValorCobrado.setText("");
              return;
        }
    

         BigDecimal valor = valoresServicos.get(posicao);

         txtValorCobrado.setText(valor.toString());
    }//GEN-LAST:event_cbServicoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAbrirOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirOSActionPerformed
        int veiculo = cbVeiculo.getSelectedIndex();
        int mecanico = cbMecanico.getSelectedIndex();
        int servico = cbServico.getSelectedIndex();

    if (veiculo == -1 || mecanico == -1 || servico == -1) {
        JOptionPane.showMessageDialog(this,
                "Selecione um veículo, mecânico e serviço!");
        return;
    }
    
        int idVeiculo = idVeiculos.get(veiculo);
        int idMecanico = idMecanicos.get(mecanico);
        int idServico = idServicos.get(servico); 
        String descricaoProblema = txtDescricao.getText().trim();
        String diagnostico = txtDiagnostico.getText().trim();
        String observacao = txtObservacao.getText().trim();
        
        if(descricaoProblema.isEmpty()){
            JOptionPane.showMessageDialog(this, "Informe a descrição do problema!");
            return;
        }
        BigDecimal valorCobrado;
        
        try {
        valorCobrado = new BigDecimal(
                txtValorCobrado.getText().trim().replace(",", ".")
        );

        if (valorCobrado.compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(this,
                    "O valor cobrado não pode ser negativo!");
            return;
        }

         }    catch (NumberFormatException erro) {
        JOptionPane.showMessageDialog(this,
                "Informe um valor cobrado válido!");
        return;
         }
        
             String sqlInsert = """
                                INSERT INTO ordem_servico
                                (veiculo_id, mecanico_id, servico_id,
                                descricao_problema, diagnostico,
                                valor_cobrado, observacao)
                                VALUES (?, ?, ?, ?, ?, ?, ?)
                                RETURNING id
                                """;
             
             try (
                  Connection conex = Conexao.conectar();
                  PreparedStatement stmt = conex.prepareStatement(sqlInsert)){
                 
                        stmt.setInt(1, idVeiculo);
                        stmt.setInt(2, idMecanico);
                        stmt.setInt(3, idServico);
                        stmt.setString(4, descricaoProblema);
                        stmt.setString(5, diagnostico);
                        stmt.setBigDecimal(6, valorCobrado);
                        stmt.setString(7, observacao);

                try (ResultSet rs = stmt.executeQuery()) {

                     if (rs.next()) {
                     int numeroOS = rs.getInt("id");

                        JOptionPane.showMessageDialog(this, "Ordem de Serviço nº " +numeroOS+ " aberta com sucesso!");
                        limparCampos();
                 }
             }

                } catch (SQLException erro) {
                JOptionPane.showMessageDialog(this, "Erro ao abrir OS: " + erro.getMessage());
            }
    
    }//GEN-LAST:event_btnAbrirOSActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new FrmCadastroOS().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirOS;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisarMecanico;
    private javax.swing.JButton btnPesquisarServico;
    private javax.swing.JButton btnPesquisarVeiculo;
    private javax.swing.JComboBox<String> cbMecanico;
    private javax.swing.JComboBox<String> cbServico;
    private javax.swing.JComboBox<String> cbVeiculo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtDataAbertura;
    private javax.swing.JTextField txtDataConclusao;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextField txtNumeroOS;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPesquisarMecanico;
    private javax.swing.JTextField txtPesquisarServico;
    private javax.swing.JTextField txtPesquisarVeiculo;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtValorCobrado;
    // End of variables declaration//GEN-END:variables
}
