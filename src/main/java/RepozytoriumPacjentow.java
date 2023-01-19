import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RepozytoriumPacjentow {
    public static void main(String[] args) {

        String fileName = "C:\\Studia\\S3\\Osrodek-Zdrowia\\src\\main\\java\\pacjenci_baza_danych.csv";

        //CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        List<String[]> test;
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        try (Reader reader = Files.newBufferedReader(Path.of(fileName))) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build()) {
                test =  csvReader.readAll();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(test.get(0)[7]);
    }
}