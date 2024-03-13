package lab2;

//   5. Napisz pętlę, która wyświetli prostokąt złożony z określonego znaku – wczytanego z
//      klawiatury.
//      Prostokąt powinien być o wymiarach wczytanych z klawiatury.

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateRectangle {
    private final int height;
    private final int width;
    private final char symbol;

    public CreateRectangle(int height, int width, char symbol) {
        this.height = height;
        this.width = width;
        this.symbol = symbol;
    }

    public String create() {
        return IntStream.range(0, height)
                .mapToObj(i -> IntStream.range(0, width)
                        .mapToObj(j -> Character.toString(symbol))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int height = getUserInput(scanner, "Podaj wysokość prostokąta: ");
            int width = getUserInput(scanner, "Podaj szerokość prostokąta: ");
            char symbol = getCharInput(scanner);

            CreateRectangle rectangular = new CreateRectangle(height, width, symbol);
            System.out.println(rectangular.create());
        }
    }

    private static int getUserInput(Scanner scanner, String message) {
        int input;
        do {
            System.out.println(message);
            while (!scanner.hasNextInt()) {
                System.out.println("To nie jest poprawna wartość. Podaj liczbę całkowitą.");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input <= 0);
        return input;
    }

    private static char getCharInput(Scanner scanner) {
        System.out.println("Podaj znak, którym ma być wypełniony prostokąt: ");
        return scanner.next().charAt(0);
    }
}
