public class Fibonacci {

    static long fib(int numero){
        int F = 0;
        int ant = 0;

        for(int i = 1; i <= numero; i++){
            if(i == 1){
                F = 1;
                ant = 0;
            }else{
                F += ant;
                ant = F - ant;
            }
        }
        return F;
    }

    static long fibRec(int numero){
        if(numero < 2){
            return numero;
        }else
            return fibRec(numero - 1) + fibRec(numero - 2);
    }
    
    static long fibTer(int numero){
        return (numero < 2) ? numero: fibTer(numero - 1) + fibTer(numero -2);
    }

    private  static int[] vetor = new int[50];
    private static int contador;

    static long fibVetor(int numero){
        contador = 1;
        return vetRec(numero);
    }

    static long vetRec(int numero){
        if(numero < 0){
            return vetor[0];
        }else{
            if(contador < 3){
                vetor[numero] =  contador - 1;
                contador++;
            }else{
                vetor[numero] = vetor[numero + 1] + vetor[numero + 2];
            }
            return vetRec(numero - 1);
        }

    }

    public static void main(String[] args) throws Exception {
        // 0 1 1 2 3 5 8 13 21 34 55 89 144
        
        System.out.println("Calculando de maneira interativa");

        for(int i = 0; i < 30; i++){
            
            System.out.println("(" + i +"): " + Fibonacci.fib(i) + "\t");
        }

        System.out.println("Calculando de maneira recursiva 01");
        for(int i = 0; i < 30; i++){
            
            System.out.println("(" + i +"): " + Fibonacci.fibRec(i) + "\t");
        }

        System.out.println("Calculando de maneira recursiva 02 com operador ternário");

        for(int i = 0; i < 30; i++){
            
            System.out.println("(" + i +"): " + Fibonacci.fibTer(i) + "\t");
        }

        System.out.println("Calculando de maneira recursiva 03 com vetor");

        for(int i = 0; i < 30; i++){
            
            System.out.println("(" + i +"): " + Fibonacci.fibVetor(i) + "\t");
        }
        
        System.out.println("Esse é o elemento na posição 07:" + vetor[27]);

    }
}
