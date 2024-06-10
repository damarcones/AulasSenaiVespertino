import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int primeiro = 0, segundo = 0;
        int resultado;
    
        double resDiv; 

        int opcao = -1;

        while (opcao != 0) {
            opcao = entrada.nextInt();

            if(opcao != 0){
                System.out.println("Insira o primeiro numero: ");
                primeiro = entrada.nextInt();

                System.out.println("Inserir o segundo numero: ");
                segundo = entrada.nextInt();
            }
        
            switch (opcao) {
                case 0:
                    System.out.println("Encerrando!");
                    break;
                case 1:
                //Vamos realizar uma soma
                    resultado = primeiro + segundo;
                    System.out.println(resultado);
                    break;
                case 2:
                // Vamos realizar uma subtração
                    resultado = primeiro - segundo;
                    System.out.println(resultado);
                    break;
                case 3:
                // vamos realizar uma multiplicação
                resultado = primeiro * segundo;
                System.out.println(resultado);
                    break;
                case 4:
                // vamos realizar uma divisão
                    resDiv = (double)primeiro / (double)segundo;
                    System.out.printf("%.10f",resDiv);
                    break;
                
                default:
                    break;
            }

        }
    }
}
