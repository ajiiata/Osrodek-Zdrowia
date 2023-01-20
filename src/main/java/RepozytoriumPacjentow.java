import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class RepozytoriumPacjentow {


    private HashMap<Integer, Pacjent> pacjenci = new HashMap<Integer, Pacjent>();
    public RepozytoriumPacjentow(){
        try {
            Path bazaPacjentow = Paths.get(ClassLoader.getSystemResource("pacjenci_baza_danych.csv").toURI());
            this.zaladujDane(bazaPacjentow);
        } catch (URISyntaxException e) {
            System.out.println("Nie udało się załadować danych, sorki :(");
        }
    };

    public void zaladujDane(Path sciezka) throws URISyntaxException {
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

        try (Reader reader = Files.newBufferedReader(sciezka)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build()) {
                String[] linia;
                while ((linia = csvReader.readNext()) != null) {
                    Pacjent pacjent = new Pacjent(Integer.parseInt(linia[8]), linia[0], linia[1], Long.parseLong(linia[5]), Long.parseLong(linia[6]), linia[2], linia[4], linia[7]);
                    this.pacjenci.put(Integer.parseInt(linia[8]), pacjent);
                }
            }
            System.out.println("Załadowano dane.");
        } catch (IOException e) {
            System.out.println("Nie udało się pobrać danych, sorki :(");
        }
    }

    public Pacjent getPacjentById(int id){
        return this.pacjenci.get(id);
    }

}