public class Pacjent extends Czlowiek {
    private final int idPacjenta;
    private String narodowosc;
    private final String miejsceUrodzenia;

    private String adresZamieszkania;

    public Pacjent(int idPacjenta, String imiePacjenta, String nazwiskoPacjenta, long pesel, long nrTelefonu,
                   String narodowosc, String miejsceUrodzenia) {
        super(imiePacjenta, nazwiskoPacjenta, pesel, nrTelefonu);

        this.idPacjenta = idPacjenta;
        this.narodowosc = narodowosc;
        this.miejsceUrodzenia = miejsceUrodzenia;
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
}
