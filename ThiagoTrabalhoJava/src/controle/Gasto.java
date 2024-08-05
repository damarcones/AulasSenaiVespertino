package controle;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gasto {

    private String tipo;
    private String descricao;
    private double valor;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void cadastrarGasto() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JTextField campoTipo = new JTextField(20);
        JTextField campoDescricao = new JTextField(20);
        JTextField campoValor = new JTextField(20);

        painel.add(new JLabel("Tipo: "));
        painel.add(campoTipo);
        painel.add(new JLabel("Descrição: "));
        painel.add(campoDescricao);
        painel.add(new JLabel("Valor: "));
        painel.add(campoValor);

        int resultado = JOptionPane.showConfirmDialog(null, painel, "Cadastrar Despesa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (resultado == JOptionPane.OK_OPTION) {
            try {
                tipo = campoTipo.getText();
                descricao = campoDescricao.getText();
                valor = Double.parseDouble(campoValor.getText());
                mostrarGasto();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void mostrarGasto() {
        String mensagem = String.format("Despesa Cadastrada:\n" +
                "Tipo: %s\nDescrição: %s\n" +
                "Valor: R$%.2f", tipo.toUpperCase(), descricao.toUpperCase(), valor);
        JOptionPane.showMessageDialog(null, mensagem, "Dados da Despesa", JOptionPane.INFORMATION_MESSAGE);
    }
}