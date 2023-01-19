public abstract class Czlowiek {
    private String imie;
    private String nazwisko;
    private final long pesel;
    private long nrTelefonu;

    public Czlowiek(String imie, String nazwisko, long pesel, long nrTelefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.nrTelefonu = nrTelefonu;
    }

    public String getImie() {
        return this.imie;
    }

    public String getNazwisko() {
        return this.nazwisko;
    }

    public long getPesel() {
        return this.pesel;
    }

    public long getNrTelefonu() {
        return this.nrTelefonu;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNrTelefonu(long nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

}