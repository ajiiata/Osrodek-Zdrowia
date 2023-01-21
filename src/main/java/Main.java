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
                    }
                    else if (operacjaDoWykonania == 1) wyswietlPacjentow();
                    else if (operacjaDoWykonania == 2) wyszukajPacjenta();
                    else if (operacjaDoWykonania == 3) modyfikujHistorieLeczenia();
                    else if (operacjaDoWykonania == 4) modyfikujLeki();
                    else if (operacjaDoWykonania == 5) dodajHistorieLeczenia();
                    else if (operacjaDoWykonania == 6) dodajLek();
                    else if (operacjaDoWykonania == 7) usunElementZHistoriiLeczenia();
                    else if (operacjaDoWykonania == 8) usunLek();
                }

            } else{
                while (true) {
                    System.out.println("Co chcesz zrobić pielęgniarko? (0 - wyjść z programu, 1 - wyświetlić wszystkich pacjentów, 2 - wyszukać pacjenta, 3- zmodyfikować adres zamieszkania pacjenta, 4 - zmodyfikować numer telefonu pacjenta, 5 - dodać nowego pacjenta do bazy)");
                    int operacjaDoWykonania = SKANER.nextInt();
                    if (operacjaDoWykonania == 0){
                        System.out.println("See you later!");
                        SKANER.close();
                        break;
                } else if (operacjaDoWykonania == 1) wyswietlPacjentow();
                  else if (operacjaDoWykonania == 2) wyszukajPacjenta();
                  else if(operacjaDoWykonania == 3) zmodyfikujAdresZamieszkania();
                  else if(operacjaDoWykonania == 4) zmodyfikujNrTelefonu();
                  else if(operacjaDoWykonania == 5) dodajNowegoPacjenta();

                }
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
            REPOZYTORIUM.zmodyfikujHistoriePacjentaPoWartosci(idPacjenta, staraWartosc, tresc);
        }
    }


    private static void modyfikujLeki(){
        System.out.println("Podaj ID pacjenta, którego dane chcesz zmienić: ");
        int idPacjenta = SKANER.nextInt();
        System.out.println("W jaki sposób chcesz podmienić dane w przyjmowanych lekach? (0 - cofnij, 1 - podać indeks elementu do zmiany, 2 - podać wartość zmienianiego elementu)");
        int opcja = SKANER.nextInt();
        if(opcja == 1){
            System.out.println("Podaj indeks elementu do zmiany: ");
            int indeks = SKANER.nextInt();
            System.out.println("Podaj zmodyfikowaną treść: ");
            String tresc = SKANER.nextLine();
            REPOZYTORIUM.zmodyfikujLekiPacjentaPoID(idPacjenta, indeks, tresc);
        } else if (opcja == 2) {
            System.out.println("Podaj wartość elementu do zmiany: ");
            String staraWartosc = SKANER.nextLine();
            System.out.println("Podaj zmodyfikowaną treść: ");
            String tresc = SKANER.nextLine();
            REPOZYTORIUM.zmodyfikujLekiPacjentaPoWartosci(idPacjenta, staraWartosc, tresc);
        }
    }

    private static void dodajHistorieLeczenia(){
        System.out.println("Podaj ID pacjenta, do którego historii leczenia chcesz dodać wpis: (0 - cofnij)");
        int idPacjenta = SKANER.nextInt();
        System.out.println("Podaj nowy element historii leczenia: ");
        String nowyWpis = SKANER.nextLine();
        REPOZYTORIUM.dodajElementDoHistoriiLeczenia(idPacjenta, nowyWpis);
    }

    private static void dodajLek(){
        System.out.println("Podaj ID pacjenta, któremu chcesz dodać lek: (0 - cofnij)");
        int idPacjenta = SKANER.nextInt();
        System.out.println("Podaj nowy element historii leczenia: ");
        String nowyWpis = SKANER.nextLine();
        REPOZYTORIUM.dodajElementDoLekow(idPacjenta, nowyWpis);
    }

    private static void usunElementZHistoriiLeczenia(){
        System.out.println("Podaj ID pacjenta, któremu chcesz usunąć element z historii leczenia: (0 - cofnij)");
        int idPacjenta = SKANER.nextInt();
        System.out.println("W jaki sposób chcesz usunąć element z historii leczenia? (0 - cofnij, 1 - po ID elementu, 2 - po wartości elementu)");
        int opcja = SKANER.nextInt();
        if (opcja == 1){
            System.out.println("Podaj indeks elementu do usunięcia: ");
            int IdUsuwanegoElementu = SKANER.nextInt();
            REPOZYTORIUM.usunElementZHistoriiLeczeniaPoID(idPacjenta, IdUsuwanegoElementu);
        }else if (opcja == 2){
            System.out.println("Podaj wartość elementu do usunięcia: ");
            String elementDoUsuniecia = SKANER.nextLine();
            REPOZYTORIUM.usunElementZHistoriiLeczeniaPoWartosci(idPacjenta, elementDoUsuniecia);
        }
    }

    private static void usunLek(){
        System.out.println("Podaj ID pacjenta, któremu chcesz usunąć lek: (0 - cofnij)");
        int idPacjenta = SKANER.nextInt();
        System.out.println("W jaki sposób chcesz usunąć lek? (0 - cofnij, 1 - po ID leku, 2 - po nazwie leku)");
        int opcja = SKANER.nextInt();
        if (opcja == 1){
            System.out.println("Podaj indeks leku do usunięcia: ");
            int IdUsuwanegoLeku = SKANER.nextInt();
            REPOZYTORIUM.usunLekPoID(idPacjenta, IdUsuwanegoLeku);
        }else if (opcja == 2){
            System.out.println("Podaj nazwę do usunięcia: ");
            String lekDoUsuniecia = SKANER.nextLine();
            REPOZYTORIUM.usunLekPoWartosci(idPacjenta, lekDoUsuniecia);
        }
    }

    private static void zmodyfikujAdresZamieszkania(){
        System.out.println("Podaj ID pacjenta, któremu chcesz zmienić adres zamieszkania (0 - cofnij)");
        int idPacjenta = SKANER.nextInt();
        System.out.println("Podaj zaktualizowany adres zamieszkania pacjenta: ");
        String nowyAdresZamieszkania = SKANER.nextLine();
        REPOZYTORIUM.zmodyfikujAdres(idPacjenta, nowyAdresZamieszkania);
    }

    private static void zmodyfikujNrTelefonu(){
        System.out.println("Podaj ID pacjenta, któremu chcesz zmienić numer telefonu (0 - cofnij)");
        int idPacjenta = SKANER.nextInt();
        System.out.println("Podaj zaktualizowany numer telefonu pacjenta: ");

        while (true) {
            String nowyNrTel = SKANER.nextLine();
            if(nowyNrTel.matches("^[0-9]{9}$")){
                REPOZYTORIUM.zmodyfikujNrTelefonu(idPacjenta, nowyNrTel);
                break;
            }else System.out.println("Podaj poprawny numer.");
        }
    }

    private static void dodajNowegoPacjenta(){
        System.out.println("Wciśnij 0, aby wyjść");
        System.out.println("Podaj imię pacjenta: ");
        String imie = SKANER.nextLine();
        System.out.println("Podaj nazwisko pacjenta: ");
        String nazwisko = SKANER.nextLine();
        System.out.println("Podaj narodowość pacjenta: ");
        String narodowosc = SKANER.nextLine();
        System.out.println("Podaj numer PESEL pacjenta");
        String pesel = SKANER.nextLine();
        System.out.println("Podaj numer telefonu pacjenta: ");
        String nrTel = SKANER.nextLine();
        System.out.println("Podaj adres zamieszkania pacjenta");
        String adres = SKANER.nextLine();
        System.out.println("Podaj miejsce urodzenia pacjenta: ");
        String miejsceUrodzenia = SKANER.nextLine();
        System.out.println("Podaj datę urodzenia pacjenta");
        String dataUrodzenia = SKANER.nextLine();

        while (true) {
            if(pesel.matches("^[0-9]{11}$") && nrTel.matches("^[0-9]{9}$")){
                REPOZYTORIUM.dodajPacjenta(imie, nazwisko, narodowosc, pesel, nrTel, adres, miejsceUrodzenia, dataUrodzenia);
                break;
            }else System.out.println("Podaj poprawne dane.");
        }
    }


}
