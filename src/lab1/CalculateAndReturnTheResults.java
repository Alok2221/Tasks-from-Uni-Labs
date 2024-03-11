package lab1;

/*
  7.Napisz program, który dla dwóch liczb całkowitych wyświetli ich sumę, różnicę, iloczyn, średnią,
    maksimum oraz minimum. Sprawdź działanie dla liczb 12 i 45
*/

public class CalculateAndReturnTheResults {

    private final int x;
    private final int y;

    public CalculateAndReturnTheResults(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int suma() {
        return x + y;
    }

    public int roznica() {
        return x - y;
    }

    public int iloczyn() {
        return x * y;
    }

    public int srednia() {
        return (x + y) / 2;
    }

    public int maksimum() {
        return Math.max(x, y);
    }

    public int minimum() {
        return Math.min(x, y);
    }

    public static void main(String[] args) {
        CalculateAndReturnTheResults results = new CalculateAndReturnTheResults(6, 7);

        System.out.println("Suma: " + results.suma());
        System.out.println("Różnica: " + results.roznica());
        System.out.println("Iloczyn: " + results.iloczyn());
        System.out.println("Średnia: " + results.srednia());
        System.out.println("Maksimum: " + results.maksimum());
        System.out.println("Minimum: " + results.minimum());

    }
}
