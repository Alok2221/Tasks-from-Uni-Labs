package lab3;

public class Main {
    public static void main(String[] args) {
        Disc disc = new Disc("IBM", 2048, 330.0);

        disc.setVat(12);
        System.out.println(disc);
        System.out.println("Cena brutto dysku: " + disc.getBruttoPrice() + " zł");
    }
}
