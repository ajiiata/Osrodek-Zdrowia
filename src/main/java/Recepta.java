import java.time.LocalDate;
import java.util.Random;

public class Recepta {
    private String imiePacjenta;
    private String nazwiskoPacjenta;
    private final long pesel;
    long numerRecepty;
    long kodRecepty;
    LocalDate dataWystawienia;
    String nazwaLeku;
    String dodatkoweInformacje;
    String podmiotWystawiajacy = "Osrodek Zdrowia HAI";

    public Recepta(String imiePacjenta, String nazwiskoPacjenta, long pesel, String nazwaLeku, String dodatkoweInformacje) {
        this.imiePacjenta = imiePacjenta;
        this.nazwiskoPacjenta = nazwiskoPacjenta;
        this.pesel = pesel;
        this.nazwaLeku = nazwaLeku;
        this.dodatkoweInformacje = dodatkoweInformacje;
        this.podmiotWystawiajacy = "Osrodek Zdrowia HAI";
        Random r = new Random();
        this.kodRecepty = r.nextLong(10000);
        this.numerRecepty = r.nextLong(10000000);
        this.dataWystawienia = LocalDate.now();
    }


    void wyswietlRecepte() {
        System.out.println("Wystawiono recepte:" + "\n Podmiot wystawiający: " + podmiotWystawiajacy +
                "\nData: " + dataWystawienia + "\nNumer recepty: " + numerRecepty +
                "\n Imię i Nazwisko: " + imiePacjenta + " " + nazwiskoPacjenta + "\nPesel: " + pesel +
                "Informacje: " + dodatkoweInformacje + "\nLek: "+ nazwaLeku + "\nKod recepty: " + kodRecepty);
    }

}
