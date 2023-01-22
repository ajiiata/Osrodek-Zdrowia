import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.opencsv.CSVWriter;


public class RepozytoriumPacjentow {


    private final HashMap<Integer, Pacjent> pacjenci = new HashMap<>();

    public RepozytoriumPacjentow() {
        try {
            Path bazaPacjentow = Path.of("./final_baza_danych_pacjentow.csv");
            this.zaladujDane(bazaPacjentow);
        } catch (URISyntaxException e) {
            System.out.println("Nie udało się załadować danych, sorki :(");
        }
    }


    public void zaladujDane(Path sciezka) throws URISyntaxException {
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

        try (Reader reader = Files.newBufferedReader(sciezka)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build()) {
                String[] linia;
                while ((linia = csvReader.readNext()) != null) {
                    ArrayList<String> historiaLeczenia = new ArrayList<>(Arrays.asList(linia[9].split(",")));
                    ArrayList<String> przyjmowaneLeki = new ArrayList<>(Arrays.asList(linia[10].split(",")));
                    Pacjent pacjent = new Pacjent(Integer.parseInt(linia[8]), linia[0], linia[1], linia[5], linia[6], linia[2], linia[4], linia[7], linia[3], historiaLeczenia, przyjmowaneLeki);
                    this.pacjenci.put(Integer.parseInt(linia[8]), pacjent);
                }
            }
            System.out.println("Załadowano dane.");
        } catch (IOException e) {
            System.out.println("Nie udało się pobrać danych, sorki :(");
        }
    }

    //--------------------------------------------------
    private void wyswietlPacjenta(Pacjent pacjent, String pracownik) {
        if (Objects.equals(pracownik, "pielęgniarka")) {
            String format = "| %-4d | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s | %-9s | %-40s |%n";
            System.out.printf(format, pacjent.getIdPacjenta(), pacjent.getImie(), pacjent.getNazwisko(), pacjent.getPesel(), pacjent.getNarodowosc(), pacjent.getDataUrodzenia(), pacjent.getMiejsceUrodzenia(), pacjent.getNrTelefonu(), pacjent.getAdresZamieszkania());
        } else {
            String format = "| %-4d | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s | %-200s | %-100s |%n";
            System.out.printf(format, pacjent.getIdPacjenta(), pacjent.getImie(), pacjent.getNazwisko(), pacjent.getPesel(), pacjent.getNarodowosc(), pacjent.getDataUrodzenia(), pacjent.getMiejsceUrodzenia(), pacjent.getHistoriaLeczenia(), pacjent.getPrzyjmowaneLeki());
        }
    }

    public void wyszukajPoImieniuINazwisku(String imie, String nazwisko, String pracownik) {
        if (Objects.equals(pracownik, "pielęgniarka")) this.naglowekPielegniarka();
        else this.naglowekLekarza();

        for (Map.Entry<Integer, Pacjent> wpis : this.pacjenci.entrySet()) {
            Pacjent pacjent = wpis.getValue();
            if (Objects.equals(pacjent.getImie(), imie) && Objects.equals(pacjent.getNazwisko(), nazwisko)) {
                this.wyswietlPacjenta(pacjent, pracownik);
            }

        }
        if (Objects.equals(pracownik, "pielęgniarka")) this.ostatniaLiniaPielegniarki();
        else this.ostatniaLiniaLekarza();
    }


    public void pokazWszystkieDane(String pracownik) {
        if (Objects.equals(pracownik, "pielęgniarka")) this.naglowekPielegniarka();
        else this.naglowekLekarza();

        for (Map.Entry<Integer, Pacjent> wpis : this.pacjenci.entrySet()) {
            Pacjent pacjent = wpis.getValue();

            this.wyswietlPacjenta(pacjent, pracownik);
        }
        if (Objects.equals(pracownik, "pielęgniarka")) this.ostatniaLiniaPielegniarki();
        else this.ostatniaLiniaLekarza();
    }


    public void wyszukajPoPeselu(String pesel, String pracownik) {
        if (Objects.equals(pracownik, "pielęgniarka")) this.naglowekPielegniarka();
        else this.naglowekLekarza();

        for (Map.Entry<Integer, Pacjent> wpis : this.pacjenci.entrySet()) {
            Pacjent pacjent = wpis.getValue();
            if (Objects.equals(pacjent.getPesel(), pesel)) {
                this.wyswietlPacjenta(pacjent, pracownik);
            }
        }
        if (Objects.equals(pracownik, "pielęgniarka")) this.ostatniaLiniaPielegniarki();
        else this.ostatniaLiniaLekarza();
    }

    private void naglowekLekarza() {
        String format = "| %-4s | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s | %-200s | %-100s |%n";
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+------------------------------------------------------------------------------------------------------+%n");
        System.out.printf(format, "ID", "Imię", "Nazwisko", "PESEL", "Narodowość", "Data urodzenia", "Miejsce urodzenia", "Historia leczenia", "Przyjmowane leki");
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+------------------------------------------------------------------------------------------------------+%n");
    }

    private void naglowekPielegniarka() {
        String format = "| %-4s | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s | %-9s | %-40s |%n";
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
        System.out.printf(format, "ID", "Imię", "Nazwisko", "PESEL", "Narodowość", "Data urodzenia", "Miejsce urodzenia", "Nr tel", "Adres zamieszkania");
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
    }

    private void ostatniaLiniaLekarza() {
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+------------------------------------------------------------------------------------------------------+%n");

    }

    private void ostatniaLiniaPielegniarki() {
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
    }

    public void zmodyfikujAdres(int id, String nowyAdres) {
        Pacjent pacjentDoZmianyAdresu = pacjenci.get(id);
        pacjentDoZmianyAdresu.setAdresZamieszkania(nowyAdres);
    }

    public void zmodyfikujNrTelefonu(int id, String nowyNrTelefonu) {
        Pacjent pacjentDoZmianyNrTelefonu = pacjenci.get(id);
        pacjentDoZmianyNrTelefonu.setNrTelefonu(nowyNrTelefonu);
    }

    public void zmodyfikujHistoriePacjentaPoID(int idPacjenta, int idElementu, String noweDane) {
        try {
            this.pacjenci.get(idPacjenta).zmodyfikujElementZHistoriiLeczeniaPoIndeksie(idElementu, noweDane);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }


    public void zmodyfikujHistoriePacjentaPoWartosci(int idPacjenta, String wartosc, String noweDane) {
        try {
            this.pacjenci.get(idPacjenta).modyfikujElementZHistoriiLeczeniaPoWartosci(wartosc, noweDane);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }

    public void zmodyfikujLekiPacjentaPoID(int idPacjenta, int idElementu, String noweDane) {
        try {
            this.pacjenci.get(idPacjenta).zmodyfikujElementZPrzyjmowanychLekow(idElementu, noweDane);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }

    public void zmodyfikujLekiPacjentaPoWartosci(int idPacjenta, String wartosc, String noweDane) {
        try {
            this.pacjenci.get(idPacjenta).modyfikujElementZPrzyjmowanychLekowPoWartosci(wartosc, noweDane);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }

    public void dodajElementDoHistoriiLeczenia(int idPacjenta, String noweDane) {
        try {
            this.pacjenci.get(idPacjenta).dodajDoHistoriiLeczenia(noweDane);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }

    public void dodajElementDoLekow(int idPacjenta, String noweDane) {
        try {
            this.pacjenci.get(idPacjenta).dodajPrzyjmowanyLek(noweDane);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }

    public void usunElementZHistoriiLeczeniaPoID(int idPacjenta, int idElementu) {
        try {
            this.pacjenci.get(idPacjenta).usunElementZHistoriiLeczeniaPoIndeksie(idElementu);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }

    public void usunLekPoID(int idPacjenta, int idElementu) {
        try {
            this.pacjenci.get(idPacjenta).usunElementZPrzyjmowanychLekowPoIndeksie(idElementu);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }

    public void usunElementZHistoriiLeczeniaPoWartosci(int idPacjenta, String staraTresc) {
        try {
            this.pacjenci.get(idPacjenta).usunElementZHistoriiLeczeniaPoWartosci(staraTresc);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }

    public void usunLekPoWartosci(int idPacjenta, String staraTresc) {
        try {
            this.pacjenci.get(idPacjenta).usunElementZPrzyjmowanychLekowPoWartosci(staraTresc);
            System.out.println("Modyfikacja się powiodła");
        } catch (Exception e) {
            System.out.println("Modyfikacja nie powiodła się");
        }
    }


    public void dodajPacjenta(String imie, String nazwisko, String narodowosc, String pesel, String nrTelefonu, String adresZamieszkania, String miejsceUrodzenia, String dataUrodzenia) {
        int idPacjenta = pacjenci.size() + 1;
        Pacjent pacjentDoDodania = new Pacjent(idPacjenta, imie, nazwisko, pesel, nrTelefonu, narodowosc, miejsceUrodzenia, adresZamieszkania, dataUrodzenia, new ArrayList<>(), new ArrayList<>());
        pacjenci.put(idPacjenta, pacjentDoDodania);
    }

    public void zapiszDoPliku() {
        try {
            final Path CSV_FILE_PATH = Path.of("./final_baza_danych_pacjentow.csv");
            FileWriter outputfile = new FileWriter(CSV_FILE_PATH.toFile());
            CSVWriter writer = new CSVWriter(outputfile, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            List<String[]> data = new ArrayList<>();
            String[] naglowki = new String[11];
            naglowki[0] = "Imię";
            naglowki[1] = "Nazwisko";
            naglowki[2] = "Narodowość";
            naglowki[3] = "Data urodzenia";
            naglowki[4] = "Miejsce urodzenia";
            naglowki[5] = "Pesel";
            naglowki[6] = "Nr telefonu";
            naglowki[7] = "Adres zamieszkania";
            naglowki[8] = "ID";
            naglowki[9] = "Historia leczenia";
            naglowki[10] = "Przyjmowane leki";
            data.add(naglowki);

            for (Map.Entry<Integer, Pacjent> e : this.pacjenci.entrySet()) {
                String[] tab = new String[11];
                tab[0] = e.getValue().getImie();
                tab[1] = e.getValue().getNazwisko();
                tab[2] = e.getValue().getNarodowosc();
                tab[3] = e.getValue().getDataUrodzenia();
                tab[4] = e.getValue().getMiejsceUrodzenia();
                tab[5] = e.getValue().getPesel();
                tab[6] = e.getValue().getNrTelefonu();
                tab[7] = e.getValue().getAdresZamieszkania();
                tab[8] = String.valueOf(e.getValue().getIdPacjenta());
                tab[9] = e.getValue().getHistoriaLeczenia();
                tab[10] = e.getValue().getPrzyjmowaneLeki();

                data.add(tab);
            }

            writer.writeAll(data);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}