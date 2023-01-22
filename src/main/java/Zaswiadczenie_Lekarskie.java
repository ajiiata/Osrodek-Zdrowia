import java.time.LocalDate;

public class Zaswiadczenie_Lekarskie {
    String typ_zaswiadczenia;
    LocalDate dataWystawienia;
    private String miejscowosc;
    private String imiePacjenta;
    private String nazwiskoPacjenta;
    private final String pesel;
    private String podmiotWystawiajacy = "Osrodek Zdrowia HAI";
    private String dodatkoweInformacje;

    public Zaswiadczenie_Lekarskie(String typ_zaswiadczenia, String imiePacjenta, String nazwiskoPacjenta, String pesel, String miejscowosc, String dodatkoweInformacje) {
        this.typ_zaswiadczenia = typ_zaswiadczenia;
        this.imiePacjenta = imiePacjenta;
        this.nazwiskoPacjenta = nazwiskoPacjenta;
        this.pesel = pesel;
        this.miejscowosc = miejscowosc;
        this.dodatkoweInformacje = dodatkoweInformacje;
        this.podmiotWystawiajacy = "Osrodek Zdrowia HAI";
        this.dataWystawienia = LocalDate.now();
    }

    void wyswietlZaswiadczenie() {
        System.out.println("\nUtworzono zaswiadczenie lekarskie:" + typ_zaswiadczenia +
                "\nPodmiot wystawiający: " + podmiotWystawiajacy + "\nData: " + dataWystawienia + " Miejscowość: " + miejscowosc +
                "\nImię i Nazwisko: " + imiePacjenta + " " + nazwiskoPacjenta + "\nPesel: " + pesel +
                "\nInformacje: " + dodatkoweInformacje);
    }


}
