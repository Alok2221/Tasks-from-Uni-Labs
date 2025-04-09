package second_semester.lab5;

//      PAiP Laboratorium 5 - tablice
//      1) Tablice pobierz od użytkownika tablicę liczb całkowitych o pobranej od użytkownika długości.
//         Zastosuj zabezpieczenia przed podaniem błędnej wielkości tablicy.
//      2) Napisz klasę TabliceMetodyPomocnicze zawierającą metody statyczne:
//      a) wyswietlTab – wyswietlajaca na ekranie elementy zadanej parametrem tablicy
//      b) obliczSrednia -obliczajacą średnią z zadanej parametrem tablicy
//      c) znajdzIndeksElementu – zwraca indeks szukanego elementu w tablicy przekazanej parametrem lub -1 jeśli element nie występuje
//      d) zerujParzyste , która wyzeruje elementy parzyste w przekazanej parametrem tablicy, wynikiem funkcji jest liczba wyzerowanych elementów
//      e) zwrocTabliceKwadratów, która dla przekazanej parametrem tablicy liczb całkowitych w wyniku zwróci tablicę zawierająca  kwadraty jej elementów
//      f) znajdzMinOrazIndeks zwracającą minimalną wartość oraz  jej  indeks, w przypadku wystąpienia
//         tej samej wartości kilka razy należy zwrócić indeks pierwszego wystąpienia
//      g) znajdzMaksOrazIndeks zwracającą maksymalną wartość oraz  jej  indeks, w  przypadku wystąpienia
//         tej samej wartości kilka razy należy zwrócić indeks pierwszego wystąpienia
//      h) obliczIlePlusMinusZer,  która  dla  przekazanej  parametrem  tablicy  liczb  całkowitych wyznacza
//      liczbę elementów dodatnich, liczbę elementów ujemnych oraz liczbę zer w tej tablicy
//      Wskazówka:
//       Napisz metody statyczne z pkt. f) oraz g) z użyciem klasy pomocniczej EkstremumIndeks.
//       Napisz  metodę statyczną z  pkt.  h)  z użyciem  klasy  pomocniczej Statystyki.
//      Dodatkowo, klasa powinna mieć nadpisaną metodę toString.
//      3)   Przetestuj napisane metody na stworzonej w punkcie 1) ,
//      -    wypisz na ekranie te liczby, które są mniejsze od średniej arytmetycznej wszystkich liczb w tablicy.
//      -    Wypisz indeksy elementów, których kwadraty są większe od średniej arytmetycznej kwadratów wszystkich liczb w tablicy.

import java.util.Arrays;
import java.util.Scanner;

public class TabliceMetodyPomocnicze {
    public static void wyswietlTab(int[] tab) {
        czyJestPusta(tab);
        for (int el : tab) {
            System.out.print(el + ", ");
        }
        System.out.println();
    }

    public static double obliczSrednia(int[] tab) {
        czyJestPusta(tab);
        return (Arrays.stream(tab).sum() * 1.0 / tab.length);
    }

    public static int znajdzIndeksElementu(int[] tab, int el) {
        czyJestPusta(tab);
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == el) {
                return i;
            }
        }
        return -1;
    }

    public static int zerujParzyste(int[] tab) {
        czyJestPusta(tab);
        int count = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 == 0) {
                count++;
                tab[i] = 0;
            }
        }
        return count;
    }

    public static int[] zwrocTabliceKwadratow(int[] tab) {
        czyJestPusta(tab);
        int[] tabPow = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            tabPow[i] = (int) Math.pow(tab[i], 2);
        }
        return tabPow;
    }

    public static EkstremumIndeks znajdzWartoscOrazIndeks(int[] tab, boolean czyMin) {
        czyJestPusta(tab);
        int ekstremum = tab[0];
        int indeks = 0;

        for (int i = 0; i < tab.length; i++) {
            if (czyMin && tab[i] < ekstremum || !czyMin && tab[i] > ekstremum) {
                ekstremum = tab[i];
                indeks = i;
            }
        }

        return new EkstremumIndeks(ekstremum, indeks);
    }

    public static Statystyki obliczIlePlusMinusZer(int[] tab) {
        czyJestPusta(tab);
        Statystyki statystyki = new Statystyki();

        for (int liczba : tab) {
            if (liczba > 0) {
                statystyki.zwiekszDodatnie();
            } else if (liczba < 0) {
                statystyki.zwiekszUjemne();
            } else {
                statystyki.zwiekszZera();
            }
        }

        return statystyki;
    }

    public static int nieParzyste(int[] tab) {
        int count = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 != 0) {
                tab[i]++;
                count++;
            }
        }
        return count;
    }

    public static int ilePar(int[] tab) {
        int count = 0;
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] == tab[i + 1]) {
                count++;
            }
        }

        return count;
    }

    private static void czyJestPusta(int[] tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Tablica jest pusta");
        }
    }

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
