import javax.swing.JOptionPane;


public class CadastroVeiculo{ 
    private String nomeUsuario = "";
    private String carro = "";
    private double combustivel =0; 
    private double combustivelGastoPorLitro =0; 
    private double kilometroRodado =0;
    private double gastosTotal = 0; 


    public CadastroVeiculo( ){ 
    }
    private double setKilometroRodado(double kilometroRodado){ 
        System.out.println("Kilometro rodado:" + kilometroRodado);
        return this.kilometroRodado += kilometroRodado;
    }
    private double setCombustivel(double setCombustivel){ 
        System.out.println("Total de combustivél abastecido:" + combustivel);
        return this.combustivel += setCombustivel;
    }
    public double gastarPorLitro(double combustivelGasto, double quilometragemRodada){
        System.out.println("Em media ele gasta ? " + combustivelGasto / quilometragemRodada);
        return combustivelGasto / quilometragemRodada;
    }
    public void gastoTotalDoVeiculo(){ 
        System.out.println("Gasto total: " + gastosTotal);
    }
    public void multas(String multas, double valor){
        this.gastosTotal += valor;
        JOptionPane.showMessageDialog(null, multas, "multas", JOptionPane.INFORMATION_MESSAGE);
    }

    public double impostos(double impostos){
        return this.gastosTotal  += impostos; 

    }
    public void completarTanque(String carro, String tipoCombustivel, double quilometragem){ 
        if(carro == this.carro){ 
            if(tipoCombustivel != "Gasolina"){ 
                System.out.println("Tipo de combustivél errado");
            }else{ 
                setKilometroRodado(quilometragem);
                setCombustivel(100.0);
                System.out.println("Combustivél abastecido");
            }
        }else{ 
            System.err.println("Carro inválido");
        }
    }

    public void cadastroUsuario(String nome, String carro){ 
        try{ 
            if(nome == ""){ 
                throw new IllegalStateException("Valor de usuário inválido");
            }
            this.nomeUsuario = nome;
            this.carro = carro;
    
            System.out.println("===================");
            System.out.println("Usuario Cadastrado");
            System.out.println("Nome :" + nome);
            System.out.println("Carro :" + carro);
            System.out.println("===================");
           
        }catch(IllegalStateException e){ 
            System.err.println("Valor de usuário inválido");
        }
    }
} 


