public abstract class Czlowiek {
    private String imie;
    private String nazwisko;
    private final String pesel;
    private String nrTelefonu;

    public Czlowiek(String imie, String nazwisko, String pesel, String nrTelefonu) {
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

    public String getPesel() {
        return this.pesel;
    }

    public String getNrTelefonu() {
        return this.nrTelefonu;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

}