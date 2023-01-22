import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Pacjent extends Czlowiek {
    private final int idPacjenta;
    private String narodowosc;
    private final String miejsceUrodzenia;

    private String adresZamieszkania;

    private final String dataUrodzenia;

    private ArrayList<String> historiaLeczenia;

    private ArrayList<String> przyjmowaneLeki;

    public Pacjent(int idPacjenta, String imiePacjenta, String nazwiskoPacjenta, String pesel, String nrTelefonu,
                   String narodowosc, String miejsceUrodzenia, String adresZamieszkania, String dataUrodzenia, ArrayList<String> historiaLeczenia, ArrayList<String> przyjmowaneLeki) {
        super(imiePacjenta, nazwiskoPacjenta, pesel, nrTelefonu);

        this.idPacjenta = idPacjenta;
        this.narodowosc = narodowosc;
        this.miejsceUrodzenia = miejsceUrodzenia;
        this.adresZamieszkania = adresZamieszkania;
        this.dataUrodzenia = dataUrodzenia;
        this.historiaLeczenia = historiaLeczenia;
        this.przyjmowaneLeki = przyjmowaneLeki;
    }

    public int getIdPacjenta() {
        return this.idPacjenta;
    }

    public String getNarodowosc() {
        return this.narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc = narodowosc;
    }

    public String getMiejsceUrodzenia() {
        return this.miejsceUrodzenia;
    }

    public String getAdresZamieszkania() {
        return this.adresZamieszkania;
    }

    public void setAdresZamieszkania(String adresZamieszkania) {
        this.adresZamieszkania = adresZamieszkania;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getHistoriaLeczenia() {
        String leczenie = this.historiaLeczenia.toString();
        return leczenie.substring(1, leczenie.length() - 2).replaceAll("  ", " ");
    }

    public String getPrzyjmowaneLeki() {
        String leki = this.przyjmowaneLeki.toString();
        return leki.substring(1, leki.length() - 2).replaceAll("  ", " ");
    }

    public void dodajDoHistoriiLeczenia(String nowyElementWHistoriiLeczenia) {
        this.historiaLeczenia.add(nowyElementWHistoriiLeczenia);
    }

    public void dodajPrzyjmowanyLek(String nowyLek) {
        this.przyjmowaneLeki.add(nowyLek);
    }

    public void usunElementZHistoriiLeczeniaPoIndeksie(int indeksDoUsuniecia) {
        this.historiaLeczenia.remove(indeksDoUsuniecia);
    }

    public void usunElementZPrzyjmowanychLekowPoIndeksie(int indeksDoUsuniecia) {
        this.przyjmowaneLeki.remove(indeksDoUsuniecia);
    }

    public void zmodyfikujElementZHistoriiLeczeniaPoIndeksie(int indeksDoModyfikacji, String poprawionyElement) {
        this.historiaLeczenia.set(indeksDoModyfikacji, poprawionyElement);
    }

    public void zmodyfikujElementZPrzyjmowanychLekow(int indeksDoModyfikacji, String poprawionyElement) {
        this.przyjmowaneLeki.set(indeksDoModyfikacji, poprawionyElement);
    }

    public void usunElementZHistoriiLeczeniaPoWartosci(String wartoscDoUsuniecia) {
        this.historiaLeczenia.remove(wartoscDoUsuniecia);
    }

    public void usunElementZPrzyjmowanychLekowPoWartosci(String wartoscDoUsuniecia) {
        this.przyjmowaneLeki.remove(wartoscDoUsuniecia);
    }

    public void modyfikujElementZHistoriiLeczeniaPoWartosci(String wartoscDoZmiany, String nowaWartosc) {
        ListIterator<String> iterator = historiaLeczenia.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals(wartoscDoZmiany)) {
                iterator.set(nowaWartosc);
            }
        }
    }


    public void modyfikujElementZPrzyjmowanychLekowPoWartosci(String wartoscDoZmiany, String nowaWartosc) {
        ListIterator<String> iterator = przyjmowaneLeki.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals(wartoscDoZmiany)) {
                iterator.set(nowaWartosc);
            }
        }
    }


}
