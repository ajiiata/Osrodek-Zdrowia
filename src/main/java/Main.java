import java.util.Scanner;

public class Main {

    private static final Scanner SKANER = new Scanner(System.in);
    private static final RepozytoriumPacjentow REPOZYTORIUM = new RepozytoriumPacjentow();
    private static String pracownik = "";

    public static void main(String[] args) {

        System.out.println("Witaj w naszym Ośrodku Zdrowia! Poniżej wpisz kim jesteś: (0 - wyjdź z programu, 1 - lekarz, 2 - pielęgniarka)");
        while (pracownik.equals("")) {
            int danaZKlawiatury = SKANER.nextInt();
            if (danaZKlawiatury == 1) pracownik = "lekarz";
            else if (danaZKlawiatury == 2) pracownik = "pielęgniarka";
            else if (danaZKlawiatury == 0) pracownik = "q";
            else System.out.println("Wprowadź poprawne dane");
        }
        if (pracownik.equals("q")) {
            System.out.println("See you later!");
            SKANER.close();

        } else {
            if (pracownik.equals("lekarz")) {
                while (true) {
                    System.out.println("""
                            Co chcesz zrobić lekarzu? (0 - wyjść z programu, 1 - wyświetlić wszystkich pacjentów, 2 - wyszukać pacjenta,
                            3- zmodyfikować historię leczenia pacjenta, 4 - zmodyfikować przyjmowane leki pacjenta, 5 - dodać wpis do historii leczenia pacjenta, 6 - dodać pacjentowi nowy przyjmowany lek,\s
                            7 - usunąć wpis z historii leczenia, 8 - usunąć wpis z przyjmowanych leków)""");
                    int operacjaDoWykonania = SKANER.nextInt();

                    if (operacjaDoWykonania == 0) {
                        System.out.println("See you later!");
                        SKANER.close();
                        break;
                    } else if (operacjaDoWykonania == 1) wyswietlPacjentow();
                    else if (operacjaDoWykonania == 2) wyszukajPacjenta();
                }


            } else {
                System.out.println("Co chcesz zrobić pielęgniarko? (0 - wyjść z programu, 1 - wyświetlić wszystkich pacjentów, 2 - wyszukać pacjenta, 3- zmodyfikować adres zamieszkania pacjenta, 4 - zmodyfikować numer telefonu pacjenta, 5 - dodać nowego pacjenta do bazy)");

            }
        }


    }

    private static void wyswietlPacjentow() {
        REPOZYTORIUM.pokazWszystkieDane(pracownik);
    }

    private static void wyszukajPacjenta() {
        System.out.println("Po czym chcesz wyszukać pacjenta? (0 - cofnij, 1 - po peselu, 2 - po imieniu i nazwisku)");
        int odpowiedz = SKANER.nextInt();
        if (odpowiedz == 1) {
            System.out.println("Wprowadź pesel: ");
            long pesel = SKANER.nextLong();
            REPOZYTORIUM.wyszukajPoPeselu(Long.toString(pesel), pracownik);
        } else if (odpowiedz == 2) {
            System.out.println("Podaj imię:");
            SKANER.nextLine();
            String imie = SKANER.nextLine();
            String[] test = imie.split(" ");

            REPOZYTORIUM.wyszukajPoImieniuINazwisku(test[0], test[1], pracownik);
        }
    }

    private static void modyfikujHistorieLeczenia(){
        System.out.println("Podaj ID pacjenta, którego dane chcesz zmienić: ");
        int idPacjenta = SKANER.nextInt();
        System.out.println("W jaki sposób chcesz podmienić dane w historii leczenia? (0 - cofnij, 1 - podać indeks elementu do zmiany, 2 - podać wartość zmienianiego elementu)");
        int opcja = SKANER.nextInt();
        if(opcja == 1){
            System.out.println("Podaj indeks elementu do zmiany: ");
            int indeks = SKANER.nextInt();
            System.out.println("Podaj zmodyfikowaną treść: ");
            String tresc = SKANER.nextLine();
            REPOZYTORIUM.zmodyfikujHistoriePacjentaPoID(idPacjenta, indeks, tresc);
        } else if (opcja == 2) {
            System.out.println("Podaj wartość elementu do zmiany: ");
            String staraWartosc = SKANER.nextLine();
            System.out.println("Podaj zmodyfikowaną treść: ");
            String tresc = SKANER.nextLine();
        }
    }


}
