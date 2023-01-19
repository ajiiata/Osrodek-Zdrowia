import com.opencsv.CSVReader;
import java.io.*;

public class RepozytoriumPacjentow {
    public static void main(String[] args) {
        try{
            String fileName = "C:\\Studia\\S3\\Osrodek-Zdrowia\\src\\main\\java\\baza_danych_pacjentow.csv";

            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

            String [] nextLine;
            int lineNumber = 0;

            while ((nextLine = reader.readNext()) != null) {
                lineNumber++;
                System.out.println("Line # " + lineNumber);
                System.out.println(nextLine[0] + "etc...");
            }
        } catch (IOException e) {
            System.out.println("Nie ma takiego pliku");
        }
    }
}