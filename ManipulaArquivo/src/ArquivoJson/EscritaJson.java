package ArquivoJson;

import org.json.*;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


@SuppressWarnings("deprecation")
public class EscritaJson {


    public static  void main(String[] args) throws IOException, FileNotFoundException, ParseException{
        // JSONObject jsonObject = new JSONObject();

        // JSONParser parser =  new JSONParser();

        // String nome;
        // String ultimoNome;
        // String cidade;
        // String estado;


        // try {
        //     jsonObject = (JSONObject) parser.parse(new FileReader("ManipulaArquivo\\src\\ArquivoJson\\saida.json"));
        //     nome = (String) jsonObject.get("Nome");
        //     ultimoNome = (String) jsonObject.get("Ultimo Nome");
        //     cidade = (String) jsonObject.get("Cidade");
        //     estado = (String) jsonObject.get("Estado");

        //     System.out.println("O nome completo dele é " +nome + " "+ ultimoNome + ", nascido em " + cidade + " do estado de " + estado + ".");
        // } catch (IOException | ParseException e) {
        //     e.printStackTrace();
        // }

        





        JSONObject jsonObject = new JSONObject();

        FileWriter escreve = null;

        jsonObject.put("Nome", "Damarcones");
        jsonObject.put("Ultimo Nome", "Porto");
        jsonObject.put("Cidade", "Arcoverde");
        jsonObject.put("Estado", "Pernambuco");

        try {
            escreve = new FileWriter("ManipulaArquivo\\src\\ArquivoJson\\saida.json");
            escreve.write(jsonObject.toString());
            escreve.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonObject);
    }
}
