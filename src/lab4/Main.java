package lab4;

public class Main {
    public static void main(String[] args) {
        Samochod samochod = new Samochod("Audi", "A6", 2020, 14.4, 260, 5.2, "7hd85j");
        samochod.wyswietl();
        samochod.setStanPaliwa(5);
        samochod.jedz(20);
        System.out.println(samochod.getStanPaliwa());
    }
}
