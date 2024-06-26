import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ManipuladorArquivos {

    public static void leitura(String caminho) throws IOException{
        BufferedReader buff = new BufferedReader(new FileReader(caminho));
        String linha;
        String aux[] = new String[3];
        Vector <Integer> vetor = new Vector<>();
        try {
            
            while (true) {
                linha = buff.readLine();
                if(linha == null) 
                    break;
                else{
                    aux = linha.split(" ");
                    for(String i: aux)
                        vetor.add(Integer.valueOf(i));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        escrita("ManipulaArquivo\\saida.txt", vetor);
        
        // System.out.println(vetor);

        buff.close();
    }

    public static void escrita(String caminho, Vector<Integer> vetor) throws IOException{
        int aux;
        Vector <String> saida = new Vector<>();

        for(int i = 0; i < vetor.size(); i+=2){
            aux = vetor.get(i) * vetor.get(i+1);
            saida.add(String.valueOf(vetor.get(i)) + " x " + String.valueOf(vetor.get(i+1)) + " = " + String.valueOf(aux));
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminho,true));
            for(String i: saida)
                writer.append(i + "\n\n");
            writer.close();
        
        
    } catch (IOException e) {
        System.err.println(e);
    }
        
    }

}
