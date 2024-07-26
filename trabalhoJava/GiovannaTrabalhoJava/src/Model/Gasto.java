package Model;

import java.time.LocalDate;

public class Gasto {
    private final TipoGasto tipoGasto;
    private String descricao;
    private double valor;
    private LocalDate data;

    public Gasto(TipoGasto tipoGasto, String descricao, double valor, LocalDate data) {
        this.tipoGasto = tipoGasto;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public enum TipoGasto {
        IMPOSTO("Imposto"),
        MULTA("Multa"),
        MANUTENCAO("Manutenção"),
        OUTROS("Outros");

        private final String descricao;

        TipoGasto(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s - R$ %.2f em %s", tipoGasto, descricao, valor, data);
    }

    public final TipoGasto getTipoGasto(){
        return tipoGasto;
    }
}
