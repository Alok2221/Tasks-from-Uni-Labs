package lab2;

//   8. Napisz program, który przyjmie od użytkownika liczbę całkowitą, a następnie wydrukuje
//      ją od tyłu, np. dla liczby 12345, wynik działania programu to 54321.
//      (dwie wersje: z wyznaczaniem i bez wyznaczania liczby o odwrotnych cyfrach)

import java.util.Scanner;

public class ReverseNumber {

    private final int num;

    public ReverseNumber(int num) {
        this.num = num;
    }

    public int reverse() {
        int reverse = 0;
        int number = num;
        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println("Podaj liczbę do odwrócenia ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Liczba: " + number + " po odwróceniu, wynosi: " + new ReverseNumber(number).reverse());

    }
}
