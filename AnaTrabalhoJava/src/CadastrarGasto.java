
import javax.swing.JOptionPane;

public class CadastrarGasto {

    private static void CadastrarGasto(){
        if(Veiculos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não há veículos cadastrados. Cadastre um veículo primeiro.");
            return;
        }
            Gasto gasto = new Gasto();
            gasto.setCategoria(JOptionPane.showInputDialog("Categoria de gasto:"));
            gasto.setValor(JOptionPane.showInputDialog("Valor do gasto:"));

            gasto.add(gasto);
            JOptionPane.showMessageDialog(null, "Gasto registrado com sucesso!");
    }
}
