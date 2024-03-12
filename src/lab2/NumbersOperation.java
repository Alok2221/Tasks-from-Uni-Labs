package lab2;

//   3. Napisz program, który wczyta od użytkownika kolejno liczbę a, znak operacji o i drugą
//      liczbę b.
//      Program w zależności od wczytanego argumentu o powinien wypisać wynik odpowiedniej
//      operacji lub pokazać komunikat o tym, że operacja jest nieznana. Na przykład, dla 5 - 6
//      program powinien wypisać -1.
//      Przygotuj dwie wersje: w pierwszej operator ma być wczytany do zmiennej typu char,
//      w drugim – String.
//      Wskazówka: do pobrania znaku operacji zastosuj scanner.next().charAt(0)

import java.util.Scanner;

public class NumbersOperation {

    private final int a;
    private final int b;
    private final char o;
    private final String d;

    public NumbersOperation(int a, char o, int b) {
        this.a = a;
        this.o = o;
        this.b = b;
        this.d = null;
    }

    public NumbersOperation(int a, String d, int b) {
        this.a = a;
        this.d = d;
        this.b = b;
        this.o = '\0';
    }

    public String calculate() {
        int result;
        if (o != '\0') {
            switch (o) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = (b != 0) ? a / b : Integer.MIN_VALUE;
                    break;
                default:
                    return "Nieznany operator!";
            }
        } else if (d != null) {
            switch (d) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = (b != 0) ? a / b : Integer.MIN_VALUE;
                    break;
                default:
                    return "Nieznany operator!";
            }
        } else {
            return "Nieznany operator!";
        }

        return (result == Integer.MIN_VALUE) ? "Nie można dzielić przez zero!" : String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj pierwszą liczbę");
        int a = scanner.nextInt();
        System.out.println("Podaj znak operacji");
        char o = scanner.next().charAt(0);
        System.out.println("Podaj drugą liczbę");
        int b = scanner.nextInt();
        NumbersOperation charOperation = new NumbersOperation(a, o, b);
        System.out.println("\n" + charOperation.calculate());

        System.out.println("Podaj pierwszą liczbę");
        int c = scanner.nextInt();
        System.out.println("Podaj znak operacji");
        String d = scanner.next();
        System.out.println("Podaj drugą liczbę");
        int f = scanner.nextInt();
        NumbersOperation stringOperation = new NumbersOperation(c, d, f);
        System.out.println("\n" + stringOperation.calculate());

        scanner.close();
    }
}

