package Turistandomodel;
import Enum.CategoriaGasto;
import java.time.LocalDate;
import java.util.List;

public class Gasto {
        private final CategoriaGasto categoria;
        private double valor;
        private LocalDate data;
        private String descricao;
        public List <CategoriaGasto> categoriaGastos;
        public List <Gasto> gastos;

        
        
     
        
        
        public Gasto(CategoriaGasto categoria, double valor, LocalDate data, String descricao,
                        List<CategoriaGasto> categoriaGastos, List<Gasto> gastos) {
                this.categoria = categoria;
                this.valor = valor;
                this.data = data;
                this.descricao = descricao;
                this.categoriaGastos = categoriaGastos;
                this.gastos = gastos;
        }




        public List<Gasto> getGastos() {
                return gastos;
        }




        public void setGastos(List<Gasto> gastos) {
                this.gastos = gastos;
        }



        public double getValor() {
                return valor;
        }
        
        
        
        
        public void setValor(double valor) {
                this.valor = valor;
        }
        
        
        
        
        public LocalDate getData() {
                return data;
        }
        
        
        
        
        public void setData(LocalDate data) {
                this.data = data;
        }
        
        
        
        
        public String getDescricao() {
                return descricao;
        }
        
        
        
        
        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }
        
        
        
        
        public CategoriaGasto getCategoria() {
                return categoria;
        }
        
        
        public final CategoriaGasto getCategoriaGasto(){
                return categoria;
        }
        
        
        public List<CategoriaGasto> getCategoriaGastos() {
                return categoriaGastos;
        }
        
        
        
        
        public void setCategoriaGastos(List<CategoriaGasto> categoriaGastos) {
                this.categoriaGastos = categoriaGastos;
        }
        

        
        
        
        
}        





