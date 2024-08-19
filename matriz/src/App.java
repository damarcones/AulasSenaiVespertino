
import javax.swing.JOptionPane;



public class App {
    public static void main(String[] args) throws Exception {
        int tam;

        
        tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o tamanho da matriz:"));
        
        int matriz[][] = new int[tam][tam];

        
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                matriz[i][j] = 0;

                System.out.print(matriz[i][j]);

            }
            System.out.println();
        }
    }
}
