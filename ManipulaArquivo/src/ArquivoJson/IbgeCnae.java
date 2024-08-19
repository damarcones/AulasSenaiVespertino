package ArquivoJson;

// import java.io.FileWriter;

// import javax.json.JsonBuilderFactory;
// import javax.json.JsonObjectBuilder;
import javax.json.*;
import jdk.jshell.JShellConsole;

// import org.json.simple.JSONObject;

// @SuppressWarnings("deprecation")
public class IbgeCnae {
    public static void main(String[] args) {
        // JsonBuilderFactory teste = Json.createBuilderFactory(null);
         JsonObject arquivoJson = Json.createObjectBuilder().add("Nome", "Damarones")
         .add("Telefones", Json.createArrayBuilder()
         .add(Json.createObjectBuilder()
         .add("Tipo", "Residencial")))
        .add("Ultimo Nome", "Porto")
        .add("Cidade", "Arcoverde")
        .add("Estado", "Pernambuco").build();
         

        System.out.println(arquivoJson);

         
    }
}
