package lab5;

import java.util.Arrays;
import java.util.Scanner;

import static lab5.TabliceMetodyPomocnicze.*;

public class Main {
    public static void main(String[] args) {

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
