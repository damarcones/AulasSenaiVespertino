package src.loja;

public class Vendedor extends Funcionario {
        private  int matricula;
        private String setor;

        public int getMatricula() {
            return matricula;
        }
        public void setMatricula(int matricula) {
            this.matricula = matricula;
        }
        public String getSetor() {
            return setor;
        }
        public void setSetor(String setor) {
            this.setor = setor;
        }

        public double realizarVenda(int quantidade, double valor){
            return quantidade * valor;
        }
        

}
