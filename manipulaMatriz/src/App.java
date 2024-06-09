import javax.swing.JOptionPane;
public class App {

    



    public static void main(String[] args) throws Exception {
        
        int opcao = -1;

        int tam;
        

        
        
        while(opcao != 0){
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Opções Disponível:\n1) Diagonal superior esquerda;\n2) Diagonal inferior esquerda;\n3) Diagonal inferior direita;\n4) Diagonal supeior direita;\n0) Sair.","Digite o número da opção:"));
            switch (opcao) {
                case 1:

                tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o tamanho da matriz:"));

                primeiraMatriz(tam);
                    
                    break;
                case 2:

                tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o tamanho da matriz:"));

                segundaMatriz(tam);
                    
                    break;
                case 3:

                    tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o tamanho da matriz:"));

                    terceiraMatriz(tam);

                    break;
                case 4:

                tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o tamanho da matriz:"));

                quartaMatriz(tam);
                    
                    break;
                case 0:
                    System.out.println("Encerrando!");
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }


    public static void primeiraMatriz(int tam){
        int matriz[][] = new int[tam][tam];
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam - i; j++){
                matriz[i][j] = 0;

                System.out.print(matriz[i][j]);

            }
            System.out.println();
        }
        System.out.println();
    }

    public static void segundaMatriz(int tam){
        int matriz[][] = new int[tam][tam];
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < i+1; j++){
                matriz[i][j] = 0;

                System.out.print(matriz[i][j]);

            }
            System.out.println();
        }
        System.out.println();
    }

    public static void terceiraMatriz(int tam){
        char matriz[][] = new char[tam][tam];
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                if(tam - j - 1 > i ){
                    matriz[i][j] = ' ';
                    System.out.print(matriz[i][j]);
                }
                else {
                    matriz[i][j] = '0';
                    System.out.print(matriz[i][j]);
                }

            }
            System.out.println();
        }
        System.out.println();
    }

    public static void quartaMatriz(int tam){
        char matriz[][] = new char[tam][tam];
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                if(j < i ){
                    matriz[i][j] = ' ';
                    System.out.print(matriz[i][j]);
                }
                else {
                    matriz[i][j] = '0';
                    System.out.print(matriz[i][j]);
                }

            }
            System.out.println();
        }
        System.out.println();
    }
}
