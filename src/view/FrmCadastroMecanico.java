package view;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class FrmCadastroMecanico extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCadastroMecanico.class.getName());

    
    public FrmCadastroMecanico() {
        initComponents();
    }

    private void limparCampos(){
        txtNome.setText("");
        txtEspecialidade.setText("");
        txtTelefone.setText("");
        txtDataAdmissao.setText("");
        txtObservacao.setText("");
        chkAtivo.setSelected(true);
        txtNome.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEspecialidade = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        chkAtivo = new javax.swing.JCheckBox();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        txtDataAdmissao = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtId.setEditable(false);
        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));

        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        txtEspecialidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Especialidade"));

        txtTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone"));
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        txtObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));
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

        txtDataAdmissao.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de admissão"));
        try {
            txtDataAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEspecialidade, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 192, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkAtivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFechar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar)
                        .addGap(11, 11, 11))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkAtivo)
                    .addComponent(btnLimpar)
                    .addComponent(btnCadastrar)
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
        String nome = txtNome.getText().trim().toUpperCase();
        String especialidade = txtEspecialidade.getText().trim();
        String telefone = txtTelefone.getText().trim();
        String observacao = txtObservacao.getText().trim();
        boolean ativo = chkAtivo.isSelected();
        
        if(nome.isEmpty() || especialidade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha nome e especialidade!");
            return;
        }
        
        LocalDate data_Admissao;
        
        try {
    DateTimeFormatter formato = DateTimeFormatter
            .ofPattern("dd/MM/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

    data_Admissao = LocalDate.parse(
            txtDataAdmissao.getText().trim(), formato
    );

} catch (DateTimeParseException erro) {
    JOptionPane.showMessageDialog(this, "Data inválida! Use DD/MM/AAAA");
    return;
}
        
        String sqlInsert = """
                           INSERT INTO mecanico
                           (nome,especialidade,telefone,data_Admissao,observacao,ativo)
                           VALUES (?,?,?,?,?,?)
                           """;
        
         try {
             Connection conex = Conexao.conectar();
             PreparedStatement stmt = conex.prepareStatement(sqlInsert);
             
             stmt.setString(1, nome);
             stmt.setString(2, especialidade);
             stmt.setString(3, telefone);
             stmt.setDate(4, java.sql.Date.valueOf(data_Admissao));
             stmt.setString(5, observacao);
             stmt.setBoolean(6, ativo);
             
             int linhas = stmt.executeUpdate();
             
             if(linhas >0){
              JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
              limparCampos();
             }    
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Não foi possível Cadastrar! - Erro" + erro.getMessage());
        }       
    }//GEN-LAST:event_btnCadastrarActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new FrmCadastroMecanico().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txtDataAdmissao;
    private javax.swing.JTextField txtEspecialidade;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
