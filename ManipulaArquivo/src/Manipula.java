public class Manipula {
    public static void main(String[] args) throws Exception {
        
        String caminho = "ManipulaArquivo\\teste.txt";

        ManipuladorArquivos.escrita(caminho);
        ManipuladorArquivos.leitura(caminho);
    }
}
