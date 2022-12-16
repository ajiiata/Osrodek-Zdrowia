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

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(int nrDomu) {
        this.nrDomu = nrDomu;
    }

    public Optional getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(Optional nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
}
