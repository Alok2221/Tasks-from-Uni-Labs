package lab2;

//   7. Napisz metodę, która zwróci sumę pierwszej i ostatniej cyfry liczby całkowitej przekazanej
//      jako parametr.

import java.util.Scanner;

public class SumOfFirstAndLastDigit {

    private final long num;

    public SumOfFirstAndLastDigit(long num) {
        this.num = num;
    }

    private long sum() {
        String numStr = Long.toString(num);

        char firstDigit = numStr.charAt(0);
        char lastDigit = numStr.charAt(numStr.length() - 1);

        int first = Character.getNumericValue(firstDigit);
        int last = Character.getNumericValue(lastDigit);

        return first + last;
    }

    public static void main(String[] args) {
        System.out.println("Podaj liczbę do zsumowania: ");
        long number = new Scanner(System.in).nextLong();

        long sum = new SumOfFirstAndLastDigit(number).sum();
        System.out.println("Suma pierwszej i ostatniej cyfry liczby " + number + " wynosi: " + sum);
    }
}
