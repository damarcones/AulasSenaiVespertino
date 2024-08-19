package automovel;

public class App {
    public static void main(String[] args) throws Exception {
        Carro carro = new Carro();

        carro.setNome("Carro");
        carro.setModelo("Onix");
        carro.setPotencia(1.4);
        carro.setQntPneu(4);
        carro.setStatus(true);
        carro.setVelocidade(0);

        System.out.println(carro.getNome());
        System.out.println(carro.getModelo());
        System.out.println(carro.getQntPneu());
        System.out.println(carro.getStatus());
        System.err.println(carro.getPotencia());
        System.out.println(carro.getVelocidade());

        System.out.println("\n\n\nAgora vem a moto");

        Moto moto = new Moto();
        moto.setNome("Moto");
        moto.setModelo("Titan");
        moto.setQntPneu(2);
        moto.setStatus(false);
        moto.setVelocidade(0);
        moto.setCilindradas(200);

        System.out.println(moto.getNome());
        System.out.println(moto.getModelo());

        System.out.println(moto.getCilindradas());

        System.out.println(moto.getQntPneu());

        System.out.println(moto.getStatus());

        System.out.println(moto.getVelocidade());

        Caminhao caminhao =  new Caminhao();

        caminhao.setCarga(true);
        caminhao.setalavanca(true);

        System.out.println("\n\n\nDescarregou? " + caminhao.descarregar(caminhao.isCarga(), caminhao.isalavanca()));

        // carro.acelerar(15);
        // carro.acelerar(15);
        // carro.frear(20);
        // carro.parar();
        // System.out.println("Velocidade atual: " + carro.getVelocidade());

        // carro.parar();
        // System.out.println(carro.getVelocidade());


    }
}
