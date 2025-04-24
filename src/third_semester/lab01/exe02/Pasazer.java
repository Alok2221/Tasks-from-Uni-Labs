package third_semester.lab01.exe02;

import java.util.ArrayList;
import java.util.List;

public class Pasazer {
    private final String imie;
    private final String nazwisko;
    private final int wiek;

    public Pasazer(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return """
                Imie: %s
                Nazwisko: %s
                Wiek: %d
                %n""".formatted(imie, nazwisko, wiek);
    }

    public void wyswietl() {
        System.out.printf("""
                Imie: %s
                Nazwisko: %s
                Wiek: %d
                %n""", imie, nazwisko, wiek);
    }

    public static void main(String[] args) {
        Pasazer p1 = new Pasazer("Jan", "Kowalski", 43);
        Pasazer p2 = new Pasazer("Piotr", "Nowak", 26);
        Pasazer p3 = new Pasazer("Jakub", "Glin", 20);
        Pasazer p4 = new Pasazer("Iwona", "Rzepa", 36);
        List<Pasazer> pasazerList = new ArrayList<>(List.of(p1, p2, p3, p4));

        for (Pasazer p : pasazerList) {
            p.wyswietl();
        }
    }
}
