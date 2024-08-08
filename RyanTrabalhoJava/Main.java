public class Main { 
    public static void main(String[] args) { 
        CadastroVeiculo rodrigo = new CadastroVeiculo(); 
        rodrigo.cadastroUsuario("Rodrigo", "HB20");
        rodrigo.cadastroUsuario("", "HB20");
        rodrigo.completarTanque("HB20","Gaslon", 110.0);
        rodrigo.completarTanque("HB","Gaslon", 110.0);
        rodrigo.completarTanque("HB20","Gasolina", 110.0);
        rodrigo.multas("IPVA", 2000.00);
        rodrigo.multas("Velocidade", 2000.00);
        rodrigo.multas("Seguro", 2000.00);
        rodrigo.gastoTotalDoVeiculo();
        rodrigo.gastarPorLitro(100.0, 10.0);
    } 
}
