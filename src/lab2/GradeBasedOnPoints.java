package lab2;

//   2. Napisz program, który prosi użytkownika o wprowadzenie liczby całkowitej z przedziału
//      [0;18] ( oznaczającej liczbę zdobytych punktów z kolokwium) i kontynuuje prośbę, dopóki
//      nie zostanie wprowadzona poprawna wartość (zastosuj pętle while oraz do-while).
//      Następnie program na podstawie zdobytych punktów wyznacza i zwraca jako wartość
//      ocenę z kolokwium według następujących reguł:
//      0-10 pkt – 2
//      11-13 pkt – 3
//      14-16 pkt – 4
//      17-18 pkt – 5

import java.util.Scanner;

public class GradeBasedOnPoints {

    public static int calculateGradeBasedOnPoints(int points) {
        return switch (points) {
            case 17, 18 -> 5;
            case 14, 15, 16 -> 4;
            case 11, 12, 13 -> 3;
            case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> 2;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points;
        int grade;

        do {
            System.out.println("Podaj liczbę punktów [0-18]");
            points = scanner.nextInt();
        } while (points < 0 || points > 18);

        grade = calculateGradeBasedOnPoints(points);

        if (grade != -1) {
            System.out.println("Ocena z kolokwium: " + grade);
        } else {
            System.out.println("Nieznany przypadek. Spróbuj ponownie");
        }

        scanner.close();
    }
}
