import java.util.Optional;

public class Adres {
    private String ulica;
    private int nrDomu;
    private Optional nrMieszkania = Optional.ofNullable(null);
    private String miejscowosc;
    private String kodPocztowy; // kod pocztowy zmodelowac przez wyrazenia regularne

    public Adres(String ulica, int nrDomu, Optional nrMieszkania, String miejscowosc, String kodPocztowy) {
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
    }




}
