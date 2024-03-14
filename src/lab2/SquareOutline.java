package lab2;

//  10. Przygotuj pętlę zagnieżdżoną, która wyświetli:
//        *******
//        *******
//        **   **
//        **   **
//        **   **
//        **   **
//        **   **
//        **   **
//        **   **
//        *******
//        *******
//      Znak oraz liczba linii powinny zostać wczytane z klawiatury.

import java.util.Scanner;

public class SquareOutline {

    private final char symbol;
    private final int size;

    public SquareOutline(char symbol, int size) {
        this.symbol = symbol;
        this.size = size;
    }

    public void displaySquarePattern() {
        printLines(symbol, size);
        printColumns(symbol, size);
        printLines(symbol, size);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj symbol: ");
        char symbol = scanner.next().charAt(0);
        System.out.print("Podaj rozmiar: ");
        int size = scanner.nextInt();

        SquareOutline squarePattern = new SquareOutline(symbol, size);
        squarePattern.displaySquarePattern();

        scanner.close();
    }

    private static void printLines(char symbol, int size) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void printColumns(char symbol, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print(symbol);
                }
                System.out.print(" ".repeat(size - 4));
            }
            System.out.println();
        }
    }
}
