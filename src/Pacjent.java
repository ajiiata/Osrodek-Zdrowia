public class Pacjent {
    private int idPacjenta;
    private String imiePacjenta;
    private String nazwiskoPacjenta;
    private long pesel;
    private long nrTelefonu;
    private String narodowosc;
    private String miejsceUrodzenia;
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
}
