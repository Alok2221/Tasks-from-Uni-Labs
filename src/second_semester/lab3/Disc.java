package second_semester.lab3;

//    1. (Klasy: pola i metody statyczne) W klasie Disc opisującej dyski będziemy mieli
//        pole statyczne:
//        vat (stawka vat)
//        oraz pola niestatyczne:
//        model (opis modelu dysku),
//        capacity (pojemność w GB),
//        price (cenę netto).
//        Każdy dysk będzie się różnił modelem, pojemnością i ceną netto (zatem te elementy będą
//        stanowiły zawartość obiektów), natomiast stawka vat dla wszystkich dysków jest taka sama
//        - nie ma więc sensu zapisywać jej w każdym obiekcie, będzie ona wspólną właściwością
//        klasy, a jako zmienna statyczna - będzie zajmować tylko 8 bajtów na całą klasę, niezależnie
//        od tego czy w programie stworzymy 1 czy 10000 obiektów - dysków.
//        Stwórzmy
//        a) konstruktory: bezparametrowy oraz ustalający zawartość pól na podstawie
//        przekazanych parametrów
//        b) metody get i set
//        c) metody publiczne:
//        - getBruttoPrice - obliczającą cenę brutto
//        - setVat - ustalającą wartość vatu na podstawie parametru przekazanego do
//        metody
//        - nadpisz metodę toString - zwracającą opis dysku (model + pojemnosc)
//        W klasie testowej ustalmy wartość vatu na 23.0, a następnie stwórzmy przykładowy dysk
//        np. "IBM", 2048, 330.0 , a następnie wydrukujmy jego opis i cenę brutto

public class Disc {

    private static double vat;

    private String model;
    private double capacity;
    private double price;

    public Disc() {
    }

    public Disc(String model, double capacity, double price) {
        this.model = model;
        this.capacity = capacity;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBruttoPrice() {
        return (price * vat) + price;
    }

    public void setVat(double vat) {
        Disc.vat = vat;
    }

    @Override
    public String toString() {
        return """
                Dysk: %s
                Pojemność: %s Mb
                """.formatted(model, capacity);
    }

    public static void main(String[] args) {
        Disc disc = new Disc("IBM", 2048, 330.0);

        disc.setVat(12);
        System.out.println(disc);
        System.out.println("Cena brutto dysku: " + disc.getBruttoPrice() + " zł");
    }
}
