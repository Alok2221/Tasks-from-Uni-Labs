package lab2;


//   9. Przygotuj pętlę zagnieżdżoną, która wyświetli:
//      **        **
//      **        **
//      **        **
//      **        **
//      **        **
//      **        **
//      **        **
//      **        **
//      **        **
//      **        **
//      Znak oraz liczba linii powinny zostać wczytane z klawiatury

import java.util.Scanner;

public class PrintColumns {
    private final char symbol;
    private final int lines;

    public PrintColumns(char symbol, int lines) {
        this.symbol = symbol;
        this.lines = lines;
    }

    public void print() {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print(symbol);
                }
                System.out.print("\t\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj znak, który chcesz wyświetlić: ");
        char symbol = scanner.next().charAt(0);

        System.out.print("Podaj liczbę linii: ");
        int lines = scanner.nextInt();

        PrintColumns printColumns = new PrintColumns(symbol, lines);
        printColumns.print();

        scanner.close();
    }
}
