package view;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmRelatorioOS extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmRelatorioOS.class.getName());

        
    
    
    public FrmRelatorioOS() {
        initComponents();
        
        btnRelatorio.doClick();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOS = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        txtAbertas = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        txtAndamento = new javax.swing.JTextField();
        txtCanceladas = new javax.swing.JTextField();
        txtConcluidas = new javax.swing.JTextField();
        txtValorConcluidas = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataFim = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº OS", "Placa", "Cliente", "Mecânico", "Serviço", "Data Abertura", "Status", "Valor Cobrado", "Data Conclusão"
            }
        ));
        jScrollPane1.setViewportView(tblOS);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Total de OS"));

        txtAbertas.setEditable(false);
        txtAbertas.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtAbertas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbertas.setBorder(javax.swing.BorderFactory.createTitledBorder("Abertas"));

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnRelatorio.setText("Gerar Relatorio");
        btnRelatorio.addActionListener(this::btnRelatorioActionPerformed);

        txtAndamento.setEditable(false);
        txtAndamento.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtAndamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAndamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Em andamento"));

        txtCanceladas.setEditable(false);
        txtCanceladas.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtCanceladas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCanceladas.setBorder(javax.swing.BorderFactory.createTitledBorder("Canceladas"));

        txtConcluidas.setEditable(false);
        txtConcluidas.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtConcluidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConcluidas.setBorder(javax.swing.BorderFactory.createTitledBorder("Concluidas"));

        txtValorConcluidas.setEditable(false);
        txtValorConcluidas.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtValorConcluidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValorConcluidas.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor das Concluidas"));

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ABERTA", "EM_ANDAMENTO", "CONCLUIDA", "CANCELADA" }));
        cbStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        txtDataInicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Inicial"));
        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtDataFim.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Final"));
        try {
            txtDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
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
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataFim, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(txtAndamento)
                            .addComponent(txtCanceladas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtConcluidas, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAbertas)
                            .addComponent(txtValorConcluidas)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAbertas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAndamento, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConcluidas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorConcluidas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String status = cbStatus.getSelectedItem().toString();

        String textoInicio = txtDataInicio.getText().trim();
        String textoFim = txtDataFim.getText().trim();

        LocalDate dataInicio = null;
        LocalDate dataFim = null;

        DateTimeFormatter formato = DateTimeFormatter
            .ofPattern("dd/MM/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

    try {

        String numerosInicio = textoInicio.replaceAll("\\D", "");
        String numerosFim = textoFim.replaceAll("\\D", "");

        
        if (numerosInicio.isEmpty() != numerosFim.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Informe as duas datas ou deixe ambas vazias!");
            return;
        }

        if (!numerosInicio.isEmpty()) {

            dataInicio = LocalDate.parse(textoInicio, formato);
            dataFim = LocalDate.parse(textoFim, formato);

            if (dataFim.isBefore(dataInicio)) {
                JOptionPane.showMessageDialog(this,
                        "A data final não pode ser anterior à inicial!");
                return;
            }
        }

    } catch (DateTimeParseException erro) {
        JOptionPane.showMessageDialog(this,
                "Data inválida! Use DD/MM/AAAA.");
        return;
    }

    String sql = """
        SELECT os.id, v.placa, c.nome AS cliente,
               m.nome AS mecanico, s.descricao AS servico,
               os.data_abertura, os.status,
               os.valor_cobrado, os.data_conclusao
        FROM ordem_servico os
        JOIN veiculo v ON os.veiculo_id = v.id
        JOIN cliente c ON v.cliente_id = c.id
        JOIN mecanico m ON os.mecanico_id = m.id
        JOIN servico s ON os.servico_id = s.id
        WHERE 1 = 1
        """;

    String sqlTotais = """
        SELECT COUNT(*) AS total,
               COUNT(*) FILTER (WHERE status = 'ABERTA') AS abertas,
               COUNT(*) FILTER (WHERE status = 'EM_ANDAMENTO') AS andamento,
               COUNT(*) FILTER (WHERE status = 'CONCLUIDA') AS concluidas,
               COUNT(*) FILTER (WHERE status = 'CANCELADA') AS canceladas,
               COALESCE(SUM(valor_cobrado)
                   FILTER (WHERE status = 'CONCLUIDA'), 0) AS valor_concluidas
        FROM ordem_servico
        WHERE 1 = 1
        """;

    if (dataInicio != null) {
        sql += " AND os.data_abertura >= ? AND os.data_abertura < ? ";
        sqlTotais += " AND data_abertura >= ? AND data_abertura < ? ";
    }

    if (!status.equals("Todos")) {
        sql += " AND os.status = ? ";
        sqlTotais += " AND status = ? ";
    }

    sql += " ORDER BY os.id";

    DefaultTableModel modelo =
            (DefaultTableModel) tblOS.getModel();

    try (Connection conex = Conexao.conectar();
         PreparedStatement stmt = conex.prepareStatement(sql);
         PreparedStatement stmtTotais =
                 conex.prepareStatement(sqlTotais)) {

        int parametro = 1;

        if (dataInicio != null) {

            Timestamp inicio = Timestamp.valueOf(
                    dataInicio.atStartOfDay());

            Timestamp fim = Timestamp.valueOf(
                    dataFim.plusDays(1).atStartOfDay());

            stmt.setTimestamp(parametro, inicio);
            stmtTotais.setTimestamp(parametro, inicio);
            parametro++;

            stmt.setTimestamp(parametro, fim);
            stmtTotais.setTimestamp(parametro, fim);
            parametro++;
        }

        if (!status.equals("Todos")) {
            stmt.setString(parametro, status);
            stmtTotais.setString(parametro, status);
        }

        try (ResultSet rs = stmt.executeQuery()) {

            modelo.setRowCount(0);

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getInt("id"), rs.getString("placa"),
                    rs.getString("cliente"), rs.getString("mecanico"),
                    rs.getString("servico"), rs.getTimestamp("data_abertura"),
                    rs.getString("status"), rs.getBigDecimal("valor_cobrado"),
                    rs.getTimestamp("data_conclusao")
                });
            }
        }

        try (ResultSet rs = stmtTotais.executeQuery()) {

            if (rs.next()) {

                txtTotal.setText(rs.getString("total"));
                txtAbertas.setText(rs.getString("abertas"));
                txtAndamento.setText(rs.getString("andamento"));
                txtConcluidas.setText(rs.getString("concluidas"));
                txtCanceladas.setText(rs.getString("canceladas"));
                txtValorConcluidas.setText("R$ " + rs.getBigDecimal("valor_concluidas"));
            }
        }

        } catch (SQLException erro) {

           JOptionPane.showMessageDialog(this, "Erro ao gerar relatório de OS: "  +erro.getMessage());
      }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    
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
        java.awt.EventQueue.invokeLater(() -> new FrmRelatorioOS().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOS;
    private javax.swing.JTextField txtAbertas;
    private javax.swing.JTextField txtAndamento;
    private javax.swing.JTextField txtCanceladas;
    private javax.swing.JTextField txtConcluidas;
    private javax.swing.JFormattedTextField txtDataFim;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorConcluidas;
    // End of variables declaration//GEN-END:variables
}
