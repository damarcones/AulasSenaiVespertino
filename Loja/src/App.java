package src;

import java.util.Calendar;
import java.util.Date;

import src.loja.Gerente;
import src.loja.Secretario;

public class App {
    public static void main(String[] args) throws Exception {
        
        Calendar c = Calendar.getInstance();
		Date data = c.getTime();
        Gerente gerente1 = new Gerente();

        gerente1.setNome("Damarcones");

        Secretario secretario1 = new Secretario();

        secretario1.setNome("Fulano");

        System.out.println(secretario1.marcaReuniao(data , gerente1.getNome()));

    }
}
