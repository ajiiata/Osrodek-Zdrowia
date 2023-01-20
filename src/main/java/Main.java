import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        var test = new RepozytoriumPacjentow();
        try {
            test.test123();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}