import lab5.TabliceMetodyPomocnicze;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Disc disc = new Disc("IBM", 2048, 330.0);
//
//        disc.setVat(12);
//        System.out.println(disc);
//        System.out.println("Cena brutto dysku: " + disc.getBruttoPrice() + " zł");
//
//        Pracownik pracownik1 = new Pracownik("Anita", "MaxWynn", 120, 60, 200);
//        Pracownik pracownik2 = new Pracownik("Marek", "Kowalski", 110, 54, 0);
//
//        pracownik1.wyswietl();
//        pracownik2.wyswietl();
//
//        System.out.printf("%.2f", pracownik1.obliczPodstawoweWynagrodzenie()).println(" zł");
//        System.out.printf("%.2f", pracownik1.obliczPelneWynagrodzenie()).println(" zł");
//
//        System.out.println(pracownik1.czyJestPremia() ?
//                "Pracownik ma premie " + String.format("%.2f", pracownik1.getPremia()) + " zł" : "Brak premii");
//
//        System.out.println(pracownik1);
//
//        System.out.println(pracownik1.wiecejPracuje(pracownik2));
//        System.out.println(pracownik1.czyWiecejZarabia(pracownik2));
//
//        Samochod samochod = new Samochod("Audi", "A6", 2020, 14.4, 260, 5.2, "7hd85j");
//        samochod.wyswietl();

        int[] t1 = new int[]{1, 2, 3, 4, 5};

        System.out.println("Podaj rozmiar tablicy ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] table = new int[size];


        for (int i = 0; i < table.length; i++) {
            System.out.println("Podej element: ");
            table[i] = new Scanner(System.in).nextInt();
        }
        TabliceMetodyPomocnicze.wyswietlTab(table);
        System.out.println(TabliceMetodyPomocnicze.obliczSrednia(table));
        System.out.println(TabliceMetodyPomocnicze.znajdzIndeksElementu(t1, 9));
        System.out.println(TabliceMetodyPomocnicze.zerujParzyste(t1));
        System.out.println(Arrays.toString(t1));

    }
}
