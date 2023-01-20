import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var test = new RepozytoriumPacjentow();
        Scanner s = new Scanner(System.in);
        long wybor = s.nextLong();
        test.wyszukajPoPeselu(wybor, "pielęgniarka");
    }}