package src;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.controle.Pao;

public class App {
    public static void main(String[] args) {
        // Pao pao = new Pao();

        Pao[] paes = new Pao[3];

        paes[0] = new Pao();
        paes[0].setTipoPao("Doce");

        paes[1] = new Pao();
        paes[1].setTipoPao("Carteiro");
         
        paes[2] = new Pao();
        paes[2].setTipoPao("Baguete");
         
        for(Pao i: paes){
            System.out.println(i.getTipoPao());
        }

        List <Pao> padaria = new ArrayList<Pao>();

        padaria.add(paes[1]);
        padaria.add(paes[0]);
        padaria.add(paes[2]);
         Pao teste = new Pao();
         teste.setTipoPao("Rosca");
         padaria.add(teste);
         padaria.remove(2);
        System.out.println("\n\nPadaria\n\n");

        for(Pao i: padaria){
            System.out.println(i.getTipoPao());
        }
         
        // pao.setTipoPao("Frances");
        // LocalDate primeiro = LocalDate.of(2024,04,04);
        // LocalDate segundo = LocalDate.of(2024,07,06);
        // System.out.println(pao.validade(primeiro,segundo));

        // LocalDate dataAtual = LocalDate.now();


        // System.out.println("Faltam " + pao.compara(primeiro, segundo)+ " para o vencimento do produto");
    }
}
