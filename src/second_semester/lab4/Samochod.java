package second_semester.lab4;

//      Napisz klasę Samochod, posiadającą następujące pola prywatne:
//        - marka (pole stałe)
//        - model (pole stałe)
//        - rocznik (pole stałe)
//        - przebieg
//        - spalanie
//        - predkoscMaksymalna
//        - predkoscAktualna
//        - pojemnoscZbiornika
//        - stanPaliwa
//        - numerRejestracyjny
//        gettery i settery oraz publiczne metody:
//        - konstruktor – ustawiający pola predkoscAktualna, stanPaliwa na zero oraz ustawiający
//        wartości pozostałych pól na podstawie parametrów (domyślnie wartość pola rocznik
//        jest ustawiana na aktualny rok, natomiast wartość pola przebieg domyślnie ma wartość zero)
//        - zwrocWiek – zwraca wiek samochodu obliczony na postawie pola rocznik
//        - zmienNrRej – zmieniająca numer rejestracyjny pojazdu na wartość podaną jako parametr
//        - przyspiesz – zwiększa aktualną prędkość samochodu o wartość przekazaną jako parametr
//        - zwolnij – zmniejsza aktualną prędkość samochodu o wartość przekazaną jako parametr
//        - zatankuj – zwiększa stan paliwa o wartość przekazaną jako parametr
//        - zatankujDoPelna – ustawia stan paliwa na maksymalną pojemność silnika
//        - czyPusty – metoda logiczna, zwraca true jeżeli zbiornik paliwa jest pusty i false w przeciwnym wypadku
//        - czyPelny – metoda logiczna, zwraca true jeżeli zbiornik paliwa jest pełny i false w przeciwnym wypadku
//        - wyswietl – wyświetla wszystkie dostępne informacje o pojeździe
//        - jedz – zwiększająca przebieg samochodu o wartość podaną jako parametr i pomniejszająca odpowiednio
//          ilość dostępnego paliwa
//        - zatrzymajSie – ustawia aktualną prędkość samochodu na 0
//        - wykonajTuning – zwiększa prędkość maksymalną samochodu o wartość podaną jako parametr
//        - czyStarszy – metoda logiczna, zwraca true jeżeli pojazd na rzecz którego
//        wywoływana jest metoda jest starszy od samochodu przekazanego jako parametr i false w przeciwnym wypadku

import java.time.Year;

public class Samochod {
    private final String marka;
    private final String model;
    private final int rocznik;
    private int przebieg;
    private double spalanie;
    private int predkoscMaksymalna;
    private int predkoscAktualna;
    private double pojemnoscZbiornika;
    private double stanPaliwa;
    private String numerRejestracyjny;

    public Samochod(String marka, String model, int rocznik, double spalanie, int predkoscMaksymalna,
                    double pojemnoscZbiornika, String numerRejestracyjny) {
        this.marka = marka;
        this.model = model;
        this.rocznik = rocznik;
        this.przebieg = 0;
        this.spalanie = spalanie;
        this.predkoscMaksymalna = predkoscMaksymalna;
        this.predkoscAktualna = 0;
        this.pojemnoscZbiornika = pojemnoscZbiornika;
        this.stanPaliwa = 0;
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public int zwrocWiek() {
        return Year.now().getValue() - rocznik;
    }

    public void zmienNrRej(String nowyNumer) {
        this.numerRejestracyjny = nowyNumer;
    }

    public void przyspiesz(int wartosc) {
        if (predkoscAktualna + wartosc <= predkoscMaksymalna)
            predkoscAktualna += wartosc;
        else
            predkoscAktualna = predkoscMaksymalna;
    }

    public void zwolnij(int wartosc) {
        if (predkoscAktualna - wartosc >= 0)
            predkoscAktualna -= wartosc;
        else
            predkoscAktualna = 0;
    }

    public void zatankuj(double iloscPaliwa) {
        if (stanPaliwa + iloscPaliwa <= pojemnoscZbiornika)
            stanPaliwa += iloscPaliwa;
        else
            stanPaliwa = pojemnoscZbiornika;
    }

    public void zatankujDoPelna() {
        stanPaliwa = pojemnoscZbiornika;
    }

    public boolean czyPusty() {
        return stanPaliwa == 0;
    }

    public boolean czyPelny() {
        return stanPaliwa == pojemnoscZbiornika;
    }

    public void wyswietl() {
        System.out.printf("""
                        Marka: %s
                        Model: %s
                        Rocznik: %s
                        Przebieg: %s
                        Spalanie: %s l/100km
                        Prędkość maksymalna: %s
                        Prędkość aktualna: %s
                        Pojemność zbiornika: %s
                        Stan paliwa: %s
                        Numer rejestracyjny: %s
                        %n""", marka, model, rocznik, przebieg, spalanie, predkoscMaksymalna,
                predkoscAktualna, pojemnoscZbiornika, stanPaliwa, numerRejestracyjny);
    }

    public void jedz(int dystans) {
        if (!czyPusty()) {
            double zuzytePaliwo = dystans * spalanie / 100;
            if (zuzytePaliwo <= stanPaliwa) {
                przebieg += dystans;
                stanPaliwa -= zuzytePaliwo;
            } else {
                System.out.println("Brak wystarczającej ilości paliwa.");
            }
        } else {
            System.out.println("Zbiornik paliwa jest pusty.");
        }
    }

    public void zatrzymajSie() {
        predkoscAktualna = 0;
    }

    public void wykonajTuning(int dodatkowaPredkosc) {
        predkoscMaksymalna += dodatkowaPredkosc;
    }

    public boolean czyStarszy(Samochod innySamochod) {
        return this.rocznik < innySamochod.rocznik;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public double getSpalanie() {
        return spalanie;
    }

    public void setSpalanie(double spalanie) {
        this.spalanie = spalanie;
    }

    public int getPredkoscMaksymalna() {
        return predkoscMaksymalna;
    }

    public void setPredkoscMaksymalna(int predkoscMaksymalna) {
        this.predkoscMaksymalna = predkoscMaksymalna;
    }

    public int getPredkoscAktualna() {
        return predkoscAktualna;
    }

    public void setPredkoscAktualna(int predkoscAktualna) {
        this.predkoscAktualna = predkoscAktualna;
    }

    public double getPojemnoscZbiornika() {
        return pojemnoscZbiornika;
    }

    public void setPojemnoscZbiornika(double pojemnoscZbiornika) {
        this.pojemnoscZbiornika = pojemnoscZbiornika;
    }

    public double getStanPaliwa() {
        return stanPaliwa;
    }

    public void setStanPaliwa(double stanPaliwa) {
        this.stanPaliwa = stanPaliwa;
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public static void main(String[] args) {
        Samochod samochod = new Samochod("Audi", "A6", 2020, 14.4, 260, 5.2, "7hd85j");
        samochod.wyswietl();
        samochod.setStanPaliwa(5);
        samochod.jedz(20);
        System.out.println(samochod.getStanPaliwa());
    }
}

