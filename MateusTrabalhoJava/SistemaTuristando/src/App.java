import com.abastecimento.Abastecimento;
import com.controle.SistemaTuristando;
import com.veiculo.Veiculo;


public class App {
    public static void main(String[] args) throws Exception {
        
        SistemaTuristando sistema = new SistemaTuristando();

        Veiculo veiculo1 = new Veiculo("Honda", "Civic", 2024, 2024, "184cv",
        50.00, "gasolina", "Branca", "ABC123", "12345678912");


        Veiculo veiculo2 = new Veiculo("Honda", "Fit", 2024, 2024, "154cv",
        50.00, "gasolina", "Branca", "ABC654", "12345679912");


        sistema.adicionarVeiculoALista(veiculo1);
        sistema.adicionarVeiculoALista(veiculo2);

        sistema.registrarAbastecimento(new Abastecimento( veiculo1, 100.00, "gasolina", 27.42, 164.52));

        sistema.registrarAbastecimento(new Abastecimento( veiculo1, 310.00, "gasolina", 16.0, 180.6));

        

        sistema.registrarAbastecimento(new Abastecimento( veiculo2, 400.00, "gasolina", 27.42, 164.52));

        sistema.registrarAbastecimento(new Abastecimento( veiculo2, 618.00, "gasolina", 16.0, 180.6));

        //sistema.gerarRelatorio();

        sistema.calcularConsumoMedio();

        //sistema.exibirListaVeiculos();

    }
}
