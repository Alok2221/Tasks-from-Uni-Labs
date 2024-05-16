package lab10;

public class RecursiveFunctions {
    public static void main(String[] args) {
        System.out.println(power(2, 4));
        System.out.println(powerC(2, -2));
        System.out.println(countExpandedFactorial(5));
        System.out.println(sumOfDigits(1234));
        System.out.println(countDigits(1634));
        System.out.println(countHexDigits(255));
        System.out.println(nine(35692363));
        printBinary(248);
        System.out.println();
        printDigitsInWords(123);
        System.out.println();
        printHexDigits(7821);
    }

    //   1) Napisz funkcję rekurencyjną obliczającą potęgę o wykładniku całkowitym nieujemnym n (n>=0) z liczby rzeczywistej x
    public static double power(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        return x * power(x, n - 1);
    }

    //   2) Napisz funkcję rekurencyjną obliczającą potęgę o wykładniku całkowitym z liczby rzeczywistej x.
    public static double powerC(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1 / powerC(x, -n);
        }
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    //   3) Napisać funkcję rekurencyjną liczącą „rozszerzoną silnię”, która działa dla wszystkich liczb
    //      całkowitych (dla liczb 0, 1, ... – działa jak zwykła silnia, a dla liczb ujemnych podobnie: (-5)! = (-5)*(-4)*(-3)*(-2)*(-1) = -120)
    public static int countExpandedFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n > 0) {
            return n * countExpandedFactorial(n - 1);
        }
        return n * countExpandedFactorial(n + 1);
    }

    //   4) Napisz rekurencyjną funkcję, która oblicza sumę cyfr liczby.
    public static int sumOfDigits(int n) {
        n = Math.abs(n);

        if (n == 0) {
            return 0;
        }

        int lastDigit = n % 10;
        int restOfNumber = n / 10;

        return lastDigit + sumOfDigits(restOfNumber);
    }

    //   5) Napisz rekurencyjną funkcję, która oblicza ilość cyfr liczby.
    public static int countDigits(int n) {
        n = Math.abs(n);

        if (n == 0) {
            return 1;
        }
        if (n < 10) {
            return 1;
        }
        return 1 + countDigits(n / 10);
    }

    //  6) Napisz funkcję obliczającą ilość cyfr szesnastkowych liczby n.
    public static int countHexDigits(int n) {
        n = Math.abs(n);
        if (n < 16) {
            return 1;
        }
        return 1 + countHexDigits(n / 16);
    }

    //  7) Napisz rekurencyjną funkcję logiczną boolean dziewiatka(int n), która zwraca wartość true, gdy w zapisie
    //     dziesiętnym liczby n znajduje się chociaż jedna liczba 9
    public static boolean nine(int n) {
        n = Math.abs(n);
        if (n == 0) {
            return false;
        }
        if (n % 10 == 9) {
            return true;
        }
        return nine(n / 10);
    }

    //  8) Napisać funkcję rekurencyjną wyświetlającą cyfry reprezentacji dwójkowej danej liczby naturalnej x
    public static void printBinary(int x) {
        if (x == 0) {
            return;
        }
        printBinary(x / 2);
        System.out.print(x % 2);
    }

    //  9) Napisać funkcję rekurencyjną wyświetlającą zapis słowny poszczególnych cyfr danej
    //     liczby naturalnej x. (np. dla 123 wyświetla: jeden dwa trzy)
    private static final String[] words = {"zero", "jeden", "dwa", "trzy", "cztery",
            "pięć", "sześć", "siedem", "osiem", "dziewięć"};

    public static void printDigitsInWords(int x) {
        if (x == 0) {
            return;
        }
        printDigitsInWords(x / 10);
        System.out.print(words[x % 10] + " ");
    }

    //  10) Napisać funkcję rekurencyjną wyświetlającą cyfry reprezentacji szesnastkowej danej liczby naturalnej x
    public static void printHexDigits(int x) {
        if (x == 0) {
            return;
        }
        printHexDigits(x / 16);
        int remainder = x % 16;
        if (remainder < 10) {
            System.out.print(remainder);
        } else {
            System.out.print((char) ('A' + (remainder - 10)));
        }
    }
}
