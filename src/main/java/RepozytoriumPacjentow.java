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

public class RepozytoriumPacjentow {


    private HashMap<Integer, Pacjent> pacjenci = new HashMap<Integer, Pacjent>();

    public RepozytoriumPacjentow() {
        try {
            Path bazaPacjentow = Paths.get(ClassLoader.getSystemResource("pacjenci_baza_danych.csv").toURI());
            this.zaladujDane(bazaPacjentow);
        } catch (URISyntaxException e) {
            System.out.println("Nie udało się załadować danych, sorki :(");
        }
    }

    ;

    public void zaladujDane(Path sciezka) throws URISyntaxException {
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

        try (Reader reader = Files.newBufferedReader(sciezka)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).withCSVParser(parser).build()) {
                String[] linia;
                while ((linia = csvReader.readNext()) != null) {
                    Pacjent pacjent = new Pacjent(Integer.parseInt(linia[8]), linia[0], linia[1], Long.parseLong(linia[5]), Long.parseLong(linia[6]), linia[2], linia[4], linia[7], linia[3]);
                    this.pacjenci.put(Integer.parseInt(linia[8]), pacjent);
                }
            }
            System.out.println("Załadowano dane.");
        } catch (IOException e) {
            System.out.println("Nie udało się pobrać danych, sorki :(");
        }
    }

    private void wyswietlPacjenta(Pacjent pacjent, String pracownik) {
        if (Objects.equals(pracownik, "pielęgniarka")) {
            String format = "| %-4d | %-14s | %-14s | %-11d | %-11s | %-14s | %-23s | %-9d | %-40s |%n";
            System.out.printf(format, pacjent.getIdPacjenta(), pacjent.getImie(), pacjent.getNazwisko(), pacjent.getPesel(), pacjent.getNarodowosc(), pacjent.getDataUrodzenia(), pacjent.getMiejsceUrodzenia(), pacjent.getNrTelefonu(), pacjent.getAdresZamieszkania());
        }

    }

    public void wyszukajPoImieniuINazwisku(String imie, String nazwisko, String pracownik) {
        if (Objects.equals(pracownik, "pielęgniarka")) {
            String format = "| %-4s | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s | %-9s | %-40s |%n";
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
            System.out.printf(format, "ID", "Imię", "Nazwisko", "PESEL", "Narodowość", "Data urodzenia", "Miejsce urodzenia", "Nr tel", "Adres zamieszkania");
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
        }


        for (Map.Entry<Integer, Pacjent> wpis : this.pacjenci.entrySet()) {
            Pacjent pacjent = wpis.getValue();
            if (Objects.equals(pacjent.getImie(), imie) && Objects.equals(pacjent.getNazwisko(), nazwisko)) {
                this.wyswietlPacjenta(pacjent, pracownik);
            }

        }
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");

    }


    public void pokazWszystkieDane(String pracownik) {
        if (Objects.equals(pracownik, "pielęgniarka")) {
            String format = "| %-4s | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s | %-9s | %-40s |%n";
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
            System.out.printf(format, "ID", "Imię", "Nazwisko", "PESEL", "Narodowość", "Data urodzenia", "Miejsce urodzenia", "Nr tel", "Adres zamieszkania");
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
        } else {
            String format = "| %-4s | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s |%n";
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+%n");
            System.out.printf(format, "ID", "Imię", "Nazwisko", "PESEL", "Narodowość", "Data urodzenia", "Miejsce urodzenia");
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+%n");
        }


        for (Map.Entry<Integer, Pacjent> wpis : this.pacjenci.entrySet()) {
            Pacjent pacjent = wpis.getValue();

            this.wyswietlPacjenta(pacjent, pracownik);
        }
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
    }


    public void wyszukajPoPeselu(long pesel, String pracownik) {
        if (Objects.equals(pracownik, "pielęgniarka")) {
            String format = "| %-4s | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s | %-9s | %-40s |%n";
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
            System.out.printf(format, "ID", "Imię", "Nazwisko", "PESEL", "Narodowość", "Data urodzenia", "Miejsce urodzenia", "Nr tel", "Adres zamieszkania");
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
        } else {
            String format = "| %-4s | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s |%n";
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+%n");
            System.out.printf(format, "ID", "Imię", "Nazwisko", "PESEL", "Narodowość", "Data urodzenia", "Miejsce urodzenia");
            System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+%n");
        }


        for (Map.Entry<Integer, Pacjent> wpis : this.pacjenci.entrySet()) {
            Pacjent pacjent = wpis.getValue();
            if (pacjent.getPesel() == pesel) {
                this.wyswietlPacjenta(pacjent, pracownik);
            }
        }
        if (Objects.equals(pracownik, "pielęgniarka")) this.ostatniaLiniaPielegniarki();
        else this.ostatniaLiniaLekarza();
    }

    private void naglowekLekarza() {
        String format = "| %-4s | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s |%n";
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+%n");
        System.out.printf(format, "ID", "Imię", "Nazwisko", "PESEL", "Narodowość", "Data urodzenia", "Miejsce urodzenia");
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+%n");
    }

    private void naglowekPielegniarka() {
        String format = "| %-4s | %-14s | %-14s | %-11s | %-11s | %-14s | %-23s | %-9s | %-40s |%n";
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
        System.out.printf(format, "ID", "Imię", "Nazwisko", "PESEL", "Narodowość", "Data urodzenia", "Miejsce urodzenia", "Nr tel", "Adres zamieszkania");
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
    }

    private void ostatniaLiniaLekarza() {
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+%n");
    }

    private void ostatniaLiniaPielegniarki() {
        System.out.printf("+------+----------------+----------------+-------------+-------------+----------------+-------------------------+-----------+------------------------------------------+%n");
    }

}