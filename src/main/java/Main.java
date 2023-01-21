import java.util.Scanner;

public class Main {

    private static final RepozytoriumPacjentow REPOZYTORIUM = new RepozytoriumPacjentow();
    private static String pracownik = "";

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Witaj w naszym Ośrodku Zdrowia! Poniżej wpisz kim jesteś: (0 - wyjdź z programu, 1 - lekarz, 2 - pielęgniarka)\n");
        int danaZKlawiatury = -1;
        while (pracownik.equals("")) {
            danaZKlawiatury = s.nextInt();
            if (danaZKlawiatury == 1) pracownik = "lekarz";
            else if (danaZKlawiatury == 2) pracownik = "pielęgniarka";
            else if (danaZKlawiatury == 0) pracownik = "q";
            else System.out.println("Wprowadź poprawne dane");
        }
        if (pracownik.equals("q")) {
            System.out.println("See you later!");
            s.close();

        } else {
            if (pracownik.equals("lekarz")) {
                while (true) {
                    System.out.println("Co chcesz zrobić lekarzu? (0 - wyjść z programu, 1 - wyświetlić wszystkich pacjentów, 2 - wyszukać pacjenta,\n3- zmodyfikować historię leczenia pacjenta, 4 - zmodyfikować przyjmowane leki pacjenta, 5 - dodać wpis do historii leczenia pacjenta, 6 - dodać pacjentowi nowy przyjmowany lek, \n" +
                            "7 - usunąć wpis z historii leczenia, 8 - usunąć wpis z przyjmowanych leków)\n");
                    int operacjaDoWykonania = s.nextInt();

                    if (operacjaDoWykonania == 0) {
                        System.out.println("See you later!");
                        s.close();
                        break;
                    } else if (operacjaDoWykonania == 1) wyswietlPacjentow();
                    else if (operacjaDoWykonania == 2) wyszukajPacjenta();
                }


            } else {
                System.out.println("Co chcesz zrobić pielęgniarko? (0 - wyjść z programu, 1 - wyświetlić wszystkich pacjentów, 2 - wyszukać pacjenta, 3- zmodyfikować adres zamieszkania pacjenta, 4 - zmodyfikować numer telefonu pacjenta, 5 - dodać nowego pacjenta do bazy)\n");

            }
        }


    }

    private static void wyswietlPacjentow() {
        REPOZYTORIUM.pokazWszystkieDane(pracownik);
    }

    private static void wyszukajPacjenta() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Po czym chcesz wyszukać pacjenta? (0 - wyjdź, 1 - po peselu, 2 - po imieniu i nazwisku)\n");
        int odpowiedz = s1.nextInt();
        if (odpowiedz == 1) {
            System.out.println("Wprowadź pesel: ");
            long pesel = s1.nextLong();
            REPOZYTORIUM.wyszukajPoPeselu(Long.toString(pesel), pracownik);
        } else if (odpowiedz == 2) {
            System.out.println("Podaj imię:");
            String imie = s1.nextLine();
            String[] test = imie.split(" ");

            REPOZYTORIUM.wyszukajPoImieniuINazwisku(test[0], test[1], pracownik);
        }
    }

    private static void zmodyfikujHistorieLeczenia() {

    }


}
