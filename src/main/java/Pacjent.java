public class Pacjent extends Czlowiek {
    private final int idPacjenta;
    private String narodowosc;
    private final String miejsceUrodzenia;

    private String adresZamieszkania;

    private final String dataUrodzenia;

    private String historiaLeczenia;

    private String przyjmowaneLeki;

    public Pacjent(int idPacjenta, String imiePacjenta, String nazwiskoPacjenta, String pesel, String nrTelefonu,
                   String narodowosc, String miejsceUrodzenia, String adresZamieszkania, String dataUrodzenia, String historiaLeczenia, String przyjmowaneLeki) {
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
        return historiaLeczenia;
    }

    public String getPrzyjmowaneLeki() {
        return przyjmowaneLeki;
    }

    public void setHistoriaLeczenia(String historiaLeczenia) {
        this.historiaLeczenia = historiaLeczenia;
    }

    public void setPrzyjmowaneLeki(String przyjmowaneLeki) {
        this.przyjmowaneLeki = przyjmowaneLeki;
    }
}
