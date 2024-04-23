package lab6;

//  Stwórzmy klasę Publication.  O każdej publikacji powinniśmy wiedzieć:
//        - jaki jest jej tytuł - title
//        - jaki jest jej numer identyfikacyjny (ISBN, ISSN, jakiś inny) - ident,
//        - jaka jest cena (powiedzmy hurtowa) - price,
//        - ile egzemplarzy tej publikacji posiada księgarnia - quantity.
//        Zauważmy, że budując klasę publikacji, staramy się znaleźć wspólne atrybuty wszystkichpublikacji.
//        Zatem np. właściwość "autor" zostaje tu pominięta, bo nie wszystkie publikacje (np. czasopisma) mają autorów
//        Napisz:
//        - Konstruktor ustalający pola klasy za pomocą przekazanych parametrów
//        - Metody: get  +set
//        dodatkowo :
//        - buy-zakup n egzemplarzy- metoda zwiększająca liczbę egzemplarzy
//          o wartość n przekazaną parametrem.
//        - raise –podwyżka ceny o procent przekazany parametrem
//        - display  –metoda wyświetlająca dane publikacji
//        - metoda toString() zwracajaca  String –  napis zawierający informacje o publikacji

public class Publication {
    private String title;
    private String ident;
    private double price;
    private int quantity;

    public Publication(String title, String ident, double price, int quantity) {
        this.title = title;
        this.ident = ident;
        this.price = price;
        this.quantity = quantity;
    }

    public void buy(int amount) {
        this.quantity += amount;
    }

    public void raise(double percent) {
        this.price = this.price + (percent * this.price);
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return """
                title: "%s"
                ident: %s
                price: %s zł
                quantity: %s
                        """.formatted(title, ident, price, quantity);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
