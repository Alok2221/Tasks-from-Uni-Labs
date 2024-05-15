package lab10;

public class RecursiveFunctions {
    public static void main(String[] args) {

        System.out.println(power(2, 4));
        System.out.println(powerC(2, -2));
        System.out.println(countExpandedFactorial(5));
        System.out.println(sumOfDigits(1234));
        System.out.println(countDigits(1634));

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
}
