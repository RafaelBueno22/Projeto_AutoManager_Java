package util;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class Estilo {
    
    // ========================================
    // PALETA DE CORES
    // ========================================

    public static final Color FUNDO =
            new Color(30, 34, 43);

    public static final Color COMPONENTE =
            new Color(37, 46, 59);

    public static final Color CABECALHO =
            new Color(41, 52, 72);

    public static final Color TEXTO =
            new Color(240, 244, 248);

    public static final Color TEXTO_SECUNDARIO =
            new Color(190, 200, 215);

    public static final Color AZUL =
            new Color(37, 99, 235);

    public static final Color VERDE =
            new Color(22, 163, 74);

    public static final Color VERMELHO =
            new Color(185, 28, 28);

    public static final Color CINZA =
            new Color(75, 85, 99);

    public static final Color BORDA =
            new Color(65, 75, 90);

    // ========================================
    // CONFIGURAÇÃO GLOBAL DO FLATLAF
    // ========================================

    public static void configurarTema() {

        FlatDarkLaf.setup();

        UIManager.put("defaultFont",
                new Font("Segoe UI", Font.PLAIN, 14));

        // Painéis
        UIManager.put("Panel.background", FUNDO);
        UIManager.put("Viewport.background", FUNDO);

        // Botões
        UIManager.put("Button.background", COMPONENTE);
        UIManager.put("Button.foreground", TEXTO);
        UIManager.put("Button.arc", 16);

        // Campos
        UIManager.put("TextField.background", COMPONENTE);
        UIManager.put("TextField.foreground", TEXTO);

        UIManager.put("FormattedTextField.background", COMPONENTE);
        UIManager.put("FormattedTextField.foreground", TEXTO);

        UIManager.put("TextArea.background", COMPONENTE);
        UIManager.put("TextArea.foreground", TEXTO);

        UIManager.put("Component.arc", 12);
        UIManager.put("TextComponent.arc", 12);

        // ComboBoxes
        UIManager.put("ComboBox.background", COMPONENTE);
        UIManager.put("ComboBox.foreground", TEXTO);

        // Tabelas
        UIManager.put("Table.background", COMPONENTE);
        UIManager.put("Table.foreground", TEXTO);

        UIManager.put("Table.selectionBackground", AZUL);
        UIManager.put("Table.selectionForeground", Color.WHITE);

        UIManager.put("Table.gridColor", BORDA);
        UIManager.put("Table.rowHeight", 35);

        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("Table.showVerticalLines", false);

        // Cabeçalho
        UIManager.put("TableHeader.background", CABECALHO);
        UIManager.put("TableHeader.foreground", TEXTO);

        // Labels
        UIManager.put("Label.foreground", TEXTO);

        // Scroll
        UIManager.put("ScrollPane.background", FUNDO);
    }

    // ========================================
    // BOTÕES
    // ========================================

    public static void configurarBotao(
            JButton botao, String tipo) {

        botao.putClientProperty(
                "JButton.buttonType", "roundRect");

        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);

        switch (tipo.toLowerCase()) {

            case "azul":
                botao.setBackground(AZUL);
                break;

            case "verde":
                botao.setBackground(VERDE);
                break;

            case "vermelho":
                botao.setBackground(VERMELHO);
                break;

            case "cinza":
                botao.setBackground(CINZA);
                break;

            default:
                botao.setBackground(COMPONENTE);
                break;
        }
    }

    // ========================================
    // CAMPOS DE TEXTO
    // ========================================

    public static void configurarCampo(
            JTextField campo) {

        campo.setBackground(COMPONENTE);
        campo.setForeground(TEXTO);
        campo.setCaretColor(TEXTO);

        campo.putClientProperty(
                "JComponent.roundRect", true);
    }

    public static void configurarCampo(
            JTextField campo, String dica) {

        configurarCampo(campo);

        campo.putClientProperty(
                "JTextField.placeholderText", dica);
    }

    // ========================================
    // COMBOBOX
    // ========================================

    public static void configurarCombo(
            JComboBox<?> combo) {

        combo.setBackground(COMPONENTE);
        combo.setForeground(TEXTO);

        combo.putClientProperty(
                "JComponent.roundRect", true);
    }

    // ========================================
    // ÁREAS DE TEXTO
    // ========================================

    public static void configurarArea(
            JTextArea area) {

        area.setBackground(COMPONENTE);
        area.setForeground(TEXTO);
        area.setCaretColor(TEXTO);

        area.setLineWrap(true);
        area.setWrapStyleWord(true);
    }

    // ========================================
    // TABELAS
    // ========================================

    public static void configurarTabela(
            JTable tabela) {

        tabela.setBackground(COMPONENTE);
        tabela.setForeground(TEXTO);

        tabela.setSelectionBackground(AZUL);
        tabela.setSelectionForeground(Color.WHITE);

        tabela.setGridColor(BORDA);
        tabela.setRowHeight(35);

        tabela.setShowVerticalLines(false);
        tabela.setShowHorizontalLines(true);
        tabela.setFillsViewportHeight(true);

        JTableHeaderConfig(tabela);
    }

    private static void JTableHeaderConfig(JTable tabela) {

        tabela.getTableHeader().setBackground(CABECALHO);
        tabela.getTableHeader().setForeground(TEXTO);

        tabela.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14));

        tabela.getTableHeader()
                .setReorderingAllowed(false);
    }

    // ========================================
    // INDICADORES
    // ========================================

    public static void configurarIndicador(
            JTextField campo) {

        configurarCampo(campo);

        campo.setFont(
                new Font("Segoe UI", Font.BOLD, 28));

        campo.setHorizontalAlignment(JTextField.CENTER);
        campo.setEditable(false);
    }

    // ========================================
    // BORDAS COM TÍTULO
    // ========================================

    public static void configurarBorda(
            JComponent componente, String titulo) {

        TitledBorder borda =
                BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(
                            BORDA, 1),
                    titulo
                );

        borda.setTitleColor(TEXTO_SECUNDARIO);

        borda.setTitleFont(
                new Font("Segoe UI", Font.PLAIN, 13));

        componente.setBorder(borda);
    }

    // Personaliza bordas já criadas no NetBeans
    public static void atualizarBorda(
            JComponent componente) {

        Border bordaAtual = componente.getBorder();

        if (bordaAtual instanceof TitledBorder borda) {

            borda.setTitleColor(TEXTO_SECUNDARIO);

            borda.setTitleFont(
                    new Font("Segoe UI", Font.PLAIN, 13));

            componente.repaint();
        }
    }

    // ========================================
    // TÍTULOS
    // ========================================

    public static void configurarTitulo(
            JLabel label) {

        label.setForeground(TEXTO);

        label.setFont(
                new Font("Segoe UI", Font.BOLD, 24));
    }

    // ========================================
    // PAINÉIS
    // ========================================

    public static void configurarPainel(
            JPanel painel) {

        painel.setBackground(FUNDO);
    }

    // ========================================
    // APLICAR ESTILO AUTOMATICAMENTE
    // ========================================

    public static void aplicarTela(Container tela) {

        // Configura o fundo da janela
        if (tela instanceof JFrame janela) {
            janela.getContentPane().setBackground(FUNDO);
        }

        // Percorre todos os componentes
        for (Component componente : tela.getComponents()) {

            // BOTÕES
            if (componente instanceof JButton botao) {

                String nome = botao.getText() == null
                        ? ""
                        : botao.getText().toLowerCase();

                if (nome.contains("excluir")
                        || nome.contains("cancelar")) {

                    configurarBotao(botao, "vermelho");

                } else if (nome.contains("cadastrar")
                        || nome.contains("salvar")
                        || nome.contains("alterar")
                        || nome.contains("confirmar")) {

                    configurarBotao(botao, "verde");

                } else if (nome.contains("fechar")
                        || nome.contains("voltar")
                        || nome.contains("limpar")) {

                    configurarBotao(botao, "cinza");

                } else {

                    configurarBotao(botao, "azul");
                }
            }

            // TABELAS
            if (componente instanceof JTable tabela) {
                configurarTabela(tabela);
            }

            // COMBOBOX
            if (componente instanceof JComboBox<?> combo) {
                configurarCombo(combo);
            }

            // CAMPOS DE TEXTO
            if (componente instanceof JTextField campo) {
                configurarCampo(campo);
            }

            // ÁREAS DE TEXTO
            if (componente instanceof JTextArea area) {
                configurarArea(area);
            }

            // BORDAS EXISTENTES
            if (componente instanceof JComponent comp) {
                atualizarBorda(comp);
            }

            // COMPONENTES INTERNOS
            if (componente instanceof Container container) {
                aplicarTela(container);
            }
        }
    }
}
