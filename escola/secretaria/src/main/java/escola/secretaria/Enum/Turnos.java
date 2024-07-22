package escola.secretaria.Enum;

public enum Turnos {
    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno"),
    INTEGRAL("Integral");

    private String turnos;

    private Turnos(String turnos){
        this.turnos = turnos;
    }
}
