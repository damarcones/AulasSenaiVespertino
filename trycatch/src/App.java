
import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        // int[] vetor = new int[3];

        // try {

        //     System.out.println(1/0);
        // }
        // catch(ArithmeticException f){
        //     System.err.println(f.getMessage());
        // }
         

        // try { for(int i = 0; i < 4; i++){
        //     vetor[i] = i; 
        //     System.out.println(vetor[i]);
        // }
        // } catch (IndexOutOfBoundsException e) {
        //     System.err.println(e.getMessage());
        // }
        // finally{
        //     System.err.println("Final segundo try.");
            
        // }

     
       int x =  Integer.parseInt(JOptionPane.showInputDialog("Teste"));
        
       JOptionPane.showConfirmDialog(null, args, null, x);
    }
}
