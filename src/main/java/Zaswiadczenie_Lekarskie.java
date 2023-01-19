import java.util.Date;

public class Zaswiadczenie_Lekarskie {
    // czy moze jakis typZaswiadczenia - tu wybieramy: skierowanie, zwolnienie?
    String skierowanie;
    String zwolnienie;
    Date dataWystawienia;
    private String miejscowosc;
    private String imiePacjenta;
    private String nazwiskoPacjenta;
    private final long pesel;
    private String podmiotWystawiajacy = "Osrodek Zdrowia HAI";
    private String dodatkoweInformacje;

    public Zaswiadczenie_Lekarskie(String imiePacjenta, String nazwiskoPacjenta, long pesel, String miejscowosc, String dodatkoweInformacje) {
        this.imiePacjenta = imiePacjenta;
        this.nazwiskoPacjenta = nazwiskoPacjenta;
        this.pesel = pesel;
        this.miejscowosc = miejscowosc;
        this.dodatkoweInformacje = dodatkoweInformacje;
        this.podmiotWystawiajacy = "Osrodek Zdrowia HAI";

        // no chyba ze wpisujemy tylko idPacjenta i to uzupelnia i oddaje automatycznie jego dane...

        // data do rozkminienia

        // tu tez sie przyda jaki lekarz wystawil zaswiadczenie
    }


}
