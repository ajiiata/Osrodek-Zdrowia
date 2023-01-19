import java.util.Date;
import java.util.Random;

public class Recepta {
    private String imiePacjenta;
    private String nazwiskoPacjenta;
    private final long pesel;
    long numerRecepty;
    String lekarz;
    long kodRecepty;
    Date dataWystawienia;
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
        this.numerRecepty = r.nextLong(10000000); // co zrobic zeby sie nie powtarzalo
        // lub moze baza danych z kodami recepty i nastepna recepta to nastepny numer?
        // np numer recepty to RRRRMMDD00001

        // cos zrobic zeby automatyzowalo dodawanie imie i nazwisko lekarza ktory wystawial recepte,
        // czyli pewnie cos z logowaniem - i jestes zalogowany na swoje konto czy cos?
        // jak sie nie uda to mozna na debila poprostu wpisac imie i nazwisko tak jak wpisujemy inne zmienne dane

        // automatyzacja daty wystawienia do ogarniecia
    }

    //getter --> dostep do pola
    // tam gdzie trzeba zmienic to setter


}
