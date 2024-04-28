package lab7;

//        1) Pobierz liczbę elementów  n z klawiatury.  Utwórz tablicę o wymiarze n x n. Wypełnij ją losowymi liczbami z przedziału 0 – 10.
//        a.   Oblicz sumę liczb, znajdujących się na przekątnych.
//              Wykonaj podobne działanie dla tablicy n x n x n.
//        b.   Znajdź   największą   wartość   w   tablicy   wielowymiarowej n x n, wyświetl jej indeksy(który wiersz i kolumna)
//        c.    Oblicz, ile liczb jest większych od średniej elementów tablicy
//        2)   Dla zadanej tablicy n x m utwórz nową tablicę o długości n (lub m),
//              uzupełnij ją kolejno średnimi wartościami z poszczególnych wierszy / kolumny pierwszej tablicy.
//        3) Napisz metodę obliczSrednieWierszami,  która  dla  danej  parametrem  macierzy
//              zwróci  w wyniku  tablicę  w  której    kolejnych  składowych  zapisze  średnie odpowiednich    wierszy macierzy.
//        4) Napisz metodę obliczMinimaWierszami,  która  dla  danej  parametrem  macierzy
//              zwróci  w wyniku tablicę w której  kolejnych składowych zapisze elementy minimalne odpowiednich  wierszy macierzy.
//        5)   Napisz  metodę  wyznaczIndeksWierszaZMinSuma  zwraca  numer  tego  wiersza
//              macierzy, będącej parametrem funkcji, w którym suma elementów w wierszu była najmniejsza
//        6)   Napisz  funkcję  wyznaczIndeksKolumnyMaxSuma  zwraca  numer  tej  kolumny
//              macierzy, będącej parametrem funkcji, w którym suma elementów była największa
//        7)   Napisz program, który:
//        a.   stworzy tablicę (macierz) 5 x 5 liczb całkowitych,
//        b.   wypełnij ją losowymi wartościami z zakresu {-5, . . . , 10},
//        c.    dla każdej kolumny wyznacz minimum,
//        d.   dla każdej kolumny wyznaczy maksimum.
//        Program   ma   wyświetlać   tablicę   wypełnioną   liczbami   oraz   tablice   z   minimami   oraz maksymami.
//        Wsk. Skorzystaj np. z metody nextInt(n) z klasy Random

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MultiDimensionalArrays {
    public static void main(String[] args) {
        System.out.println("Podaj liczbe naturalna n: ");
        int n = new Scanner(System.in).nextInt();

        int[][] arrTwoD = generateTwoDimArray(n);
        System.out.println(Arrays.deepToString(arrTwoD));
        System.out.println(diagonalSumTwoDim(arrTwoD));

        int[][][] arrThreeD = generateThreeDimArray(n);
        System.out.println(Arrays.deepToString(arrThreeD));
        System.out.println(diagonalSumThreeDim(arrThreeD));


    }

    public static int[][] generateTwoDimArray(int length) {
        Random random = new Random();
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            arr[i][i] = random.nextInt(11);
        }
        return arr;
    }

    public static int[][][] generateThreeDimArray(int length) {
        Random random = new Random();
        int[][][] arr = new int[length][length][length];
        for (int i = 0; i < length; i++) {
            arr[i][i][i] = random.nextInt(11);
        }
        return arr;
    }

    public static int diagonalSumTwoDim(int[][] arr) {
        int sum = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            sum += arr[i][i];
            sum += arr[i][size - 1 - i];
        }
        return sum;
    }

    public static int diagonalSumThreeDim(int[][][] arr) {
        int sum = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            sum += arr[i][i][i];
            sum += arr[i][i][size - 1 - i];
        }
        return sum;
    }
}
