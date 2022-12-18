public class Pacjent {
    private final int idPacjenta;
    private String imiePacjenta;
    private String nazwiskoPacjenta;
    private final long pesel;
    private long nrTelefonu;
    private String narodowosc;
    private final String miejsceUrodzenia;
    //adres będzie klasą, bo jest dość złożony, więc lepiej tak

    public Pacjent(int idPacjenta, String imiePacjenta, String nazwiskoPacjenta, long pesel, long nrTelefonu,
                   String narodowosc, String miejsceUrodzenia) {

        this.idPacjenta = idPacjenta;
        this.imiePacjenta = imiePacjenta;
        this.nazwiskoPacjenta = nazwiskoPacjenta;
        this.pesel = pesel;
        this.nrTelefonu = nrTelefonu;
        this.narodowosc = narodowosc;
        this.miejsceUrodzenia = miejsceUrodzenia;
    }

    public int getIdPacjenta() {
        return this.idPacjenta;
    }

    public String getImiePacjenta() {
        return this.imiePacjenta;
    }

    public void setImiePacjenta(String imiePacjenta) {
        this.imiePacjenta = imiePacjenta;
    }

    public String getNazwiskoPacjenta() {
        return this.nazwiskoPacjenta;
    }

    public void setNazwiskoPacjenta(String nazwiskoPacjenta) {
        this.nazwiskoPacjenta = nazwiskoPacjenta;
    }

    public long getPesel() {
        return this.pesel;
    }

    public long getNrTelefonu() {
        return this.nrTelefonu;
    }

    public void setNrTelefonu(long nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
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


}
