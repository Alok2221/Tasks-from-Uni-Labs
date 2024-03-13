package lab2;

//     6. Napisz program, który wczyta od użytkownika n liczb i obliczy ich średnią. Na początku program
//        powinien zapytać użytkownika o ilość liczb (n), które chce wprowadzić, a następnie prosić o
//        wprowadzenie poszczególnych wartości.

import java.util.Scanner;

public class AverageOfNumbers {

    private final int n;

    public AverageOfNumbers(int n) {
        this.n = n;
    }

    public double getAverage() {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Podaj " + (i + 1) + " liczbę: ");
            double number = scanner.nextDouble();
            sum += number;
        }

        return sum / n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj ilość liczb: ");
        int n = scanner.nextInt();

        AverageOfNumbers averageCalculator = new AverageOfNumbers(n);
        double average = averageCalculator.getAverage();

        System.out.println("Średnia liczb wynosi: " + String.format("%.2f", average));
    }
}

