
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
public class App {
    public static void main(String[] args) throws CepInvalido {
        String cpf = "";
        String telefone = "";
        String cep = "";

        JTextField getCpf = new JTextField(10);
        JTextField getTelefone = new JTextField(10);
        JTextField getCep = new JTextField(10);
       
        Object[] message = {
            "Insira o CPF:", getCpf,
            "Insira o Telefone:", getTelefone,
            "Insira o cep:", getCep
        };

        
        
        int opcao = JOptionPane.showConfirmDialog(null, message, "Insira os valores", JOptionPane.OK_CANCEL_OPTION);

        if (opcao == JOptionPane.OK_OPTION){
            cpf = getCpf.getText();
            telefone = getTelefone.getText();
            cep = getCep.getText();
        }

        String padraoCep = "##.###-###";
        String padraoCpf = "###.###.###-##";
        String padraoTelefone = "(##) # ####-####";

        String cpfFormatado = FormataCpf(cpf, padraoCpf);
        String telefoneFormatado =  FormataTelefone(telefone, padraoTelefone);
        String cepFormatado = FormataCep(cep, padraoCep);

        JOptionPane.showMessageDialog(null,"CPF: " + cpfFormatado +"\nTelefone: " + telefoneFormatado +"\nCEP: "+ cepFormatado);

    }
    static String FormataCep(String cep, String padrao) throws CepInvalido{
        MaskFormatter mascara;
        
        try {
            mascara =  new MaskFormatter(padrao);
            mascara.setValueContainsLiteralCharacters(false);
            return mascara.valueToString(cep);
        }
         catch ( ParseException  e) {
            throw new RuntimeException(e);
        }
    } 

    static String FormataCpf(String cpf, String padrao){
        MaskFormatter mascara;
        try {
            mascara =  new MaskFormatter(padrao);
            mascara.setValueContainsLiteralCharacters(false);
            return mascara.valueToString(cpf);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    } 

    static String FormataTelefone(String telefone, String padrao){
        MaskFormatter mascara;
        try {
            mascara =  new MaskFormatter(padrao);
            mascara.setValueContainsLiteralCharacters(false);
            return mascara.valueToString(telefone);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    } 

}
