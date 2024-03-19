package lab3;

public class Main {
    public static void main(String[] args) {
        Disc disc = new Disc("IBM", 2048, 330.0);

        disc.setVat(12);
        System.out.println(disc);
        System.out.println("Cena brutto dysku: " + disc.getBruttoPrice() + " zł");

        Pracownik pracownik1 = new Pracownik("Anita", "MaxWynn", 120, 60, 200);
        Pracownik pracownik2 = new Pracownik("Marek", "Kowalski", 110, 54, 0);

        pracownik1.wyswietl();
        pracownik2.wyswietl();

        System.out.printf("%.2f", pracownik1.obliczPodstawoweWynagrodzenie()).println(" zł");
        System.out.printf("%.2f", pracownik1.obliczPelneWynagrodzenie()).println(" zł");

        System.out.println(pracownik1.czyJestPremia() ?
                "Pracownik ma premie " + String.format("%.2f", pracownik1.getPremia()) + " zł" : "Brak premii");

        System.out.println(pracownik1);

        System.out.println(pracownik1.wiecejPracuje(pracownik2));
        System.out.println(pracownik1.czyWiecejZarabia(pracownik2));
    }
}
