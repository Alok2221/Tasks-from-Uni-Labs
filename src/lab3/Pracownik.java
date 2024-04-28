package lab3;

//   3. Zdefiniuj klasę Pracownik służącą do przechowywania informacji o pracowniku. Klasa
//      powinna posiadać następujące pola prywatne:
//      - string imie
//      - string nazwisko
//      - double stawka // określające wynagrodzenie za 1 godzinę pracy
//      - double godz // liczba przepracowanych godzin w miesiącu
//      - double premia // reprezentuje kwotę premii pracownika
//      metody dostępowe: gettery i settery oraz publiczne metody:
//      - konstruktor – ustawiający wartości pól na podstawie swoich parametrów
//      - obliczPodstawoweWynagrodzenie – zwracająca wynagrodzenie pracownika
//      należne za przepracowane godziny (bez premii)
//      - obliczPelneWynagrodzenie – zwracająca wynagrodzenie pracownika wraz z
//      premią
//      - zmienPremie – zmieniająca premię pracownika na wartość podaną jako parametr
//      - dajPodwyzke – zwiększająca stawkę godzinową pracownika o wartość podaną jako
//      parametr
//      - czyJestPremia – metoda logiczna, zwracająca true jeżeli pracownik otrzymuje
//      premię (tzn. premia > 0) i false w przeciwnym wypadku
//      - metoda logiczna wiecejPracuje zwraca true jesli pracownik na rzecz którego
//      wywoływana jest metoda(this) pracuje więcej godzin niż pracownik przekazany przez
//      parametr, false w przeciwnym razie
//      - wyswietl – wyświetlająca na ekranie dane osobowe pracownika oraz jego
//      miesięczne wynagrodzenie
//      Utwórz dowolny obiekt typu Pracownik, a następnie
//      - wyświetl wszystkie dane o pracowniku
//      - przyznaj premię
//      - wyświetl informację o wynagrodzeniu należnym po podwyżce

public class Pracownik {
    private final String imie;
    private final String nazwisko;
    private double stawka;
    private final int godz;
    private double premia;

    public Pracownik(String imie, String nazwisko, double stawka, int godz, double premia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stawka = stawka;
        this.godz = godz;
        this.premia = premia;
    }

    public double getPremia() {
        return premia;
    }

    public double obliczPodstawoweWynagrodzenie() {
        return stawka * godz;
    }

    public double obliczPelneWynagrodzenie() {
        return obliczPodstawoweWynagrodzenie() + premia;
    }

    public void zmienPremie(double nowaPremia) {
        premia = nowaPremia;
    }

    public void dajPodwyzke(double dodatkowaPremia) {
        stawka += dodatkowaPremia;
    }

    public boolean czyJestPremia() {
        return premia > 0;
    }

    public boolean wiecejPracuje(Pracownik pracownik) {
        return this.godz > pracownik.godz;
    }

    public boolean czyWiecejZarabia(Pracownik pracownik) {
        return this.obliczPodstawoweWynagrodzenie() > pracownik.obliczPodstawoweWynagrodzenie();
    }

    public void wyswietl() {
        System.out.printf("""
                %s %s
                Miesięczne wynagrodzenie %s zł
                %n""", imie, nazwisko, String.format("%.2f", obliczPelneWynagrodzenie()));
    }

    @Override
    public String toString() {
        return """
                %s %s
                Stawka: %s zł
                Liczba godzin: %s
                Premia: %s zł
                """.formatted(imie, nazwisko, String.format("%.2f", stawka), godz, String.format("%.2f", premia));
    }

    public static void main(String[] args) {
        Pracownik pracownik1 = new Pracownik("Anita", "MaxWynn", 120, 60, 200);
        Pracownik pracownik2 = new Pracownik("Marek", "Kowalski", 110, 54, 0);

        pracownik1.wyswietl();
        pracownik2.wyswietl();

        System.out.printf("%.2f", pracownik1.obliczPodstawoweWynagrodzenie()).println(" zł");
        System.out.printf("%.2f", pracownik1.obliczPelneWynagrodzenie()).println(" zł");

        System.out.println(pracownik1.czyJestPremia() ?
                "Pracownik ma premie " + String.format("%.2f", pracownik1.getPremia()) + " zł" : "Brak premii");

        System.out.println(pracownik1);

        System.out.println(pracownik1.wiecejPracuje(pracownik2));
        System.out.println(pracownik1.czyWiecejZarabia(pracownik2));
    }
}
