package second_semester.lab5;

//        Klasa EkstremumIndeks powinna posiadać dwa pola całkowite ekstremum oraz indeks, które przechowują
//        wartość ekstremalną oraz jej indeks odpowiednio. Ponadto klasa powinna zawierać konstruktor parametrowy oraz gettery.

public class EkstremumIndeks {

    private final int ekstremum;
    private final int indeks;

    public EkstremumIndeks(int ekstremum, int indeks) {
        this.ekstremum = ekstremum;
        this.indeks = indeks;
    }

    public int getEkstremum() {
        return ekstremum;
    }

    public int getIndeks() {
        return indeks;
    }

    @Override
    public String toString() {
        return """
                %s
                %s
                """.formatted(getEkstremum(), getIndeks());
    }
}
