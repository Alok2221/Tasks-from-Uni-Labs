import lab3.Disc;
import lab3.Pracownik;
import lab4.Samochod;

import java.util.Arrays;
import java.util.Scanner;

import static lab5.TabliceMetodyPomocnicze.*;

public class Main {
    public static void main(String[] args) {
        Disc disc = new Disc("IBM", 2048, 330.0);

        disc.setVat(12);
        System.out.println(disc);
        System.out.println("Cena brutto dysku: " + disc.getBruttoPrice() + " zł");

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

        Samochod samochod = new Samochod("Audi", "A6", 2020, 14.4, 260, 5.2, "7hd85j");
        samochod.wyswietl();

        int[] t1 = new int[]{1, 2, 3, 3, 4, 5, 5, -5};

        System.out.println("Podaj rozmiar tablicy ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] table = new int[size];

        for (int i = 0; i < table.length; i++) {
            System.out.println("Podej element: ");
            table[i] = new Scanner(System.in).nextInt();
        }
        wyswietlTab(table);
        System.out.println(obliczSrednia(table));
        System.out.println(znajdzIndeksElementu(t1, 9));
        System.out.println(zerujParzyste(t1));
        System.out.println(Arrays.toString(t1));
        System.out.println(Arrays.toString(zwrocTabliceKwadratow(t1)));
        System.out.println(znajdzWartoscOrazIndeks(t1, true));
        System.out.println(znajdzWartoscOrazIndeks(t1, false));
        System.out.println(obliczIlePlusMinusZer(t1));

        double srednia = obliczSrednia(t1);
        for (int j : t1) {
            if (j < srednia) System.out.print(j + ", ");
        }
        System.out.println();

        int[] tabPow = zwrocTabliceKwadratow(t1);
        double sredniaPow = obliczSrednia(tabPow);

        for (int i : tabPow) {
            if (i < sredniaPow) System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("Liczby nie parzyste: " + nieParzyste(t1));
        System.out.println(ilePar(t1));
    }
}
