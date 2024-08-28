package turistando.app.Exceptions;

public class ValidaQuilometragem extends Exception {
    public String ValidaKm(){
        return "A quilometragem atual não deve ser menor que a última quilometragem cadastrada";
    }

}
