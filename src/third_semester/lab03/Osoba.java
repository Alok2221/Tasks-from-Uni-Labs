package third_semester.lab03;

import java.util.Objects;

public class Osoba implements Comparable<Osoba> {

    private final String pesel;
    private final String imie;
    private final String nazwisko;

    public Osoba(String pesel, String imie, String nazwisko) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public String toString() {
        return """
                PESEL: %s
                Imię: %s
                Nazwisko: %s
                \n
                """.formatted(getPesel(), getImie(), getNazwisko());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return pesel.equals(osoba.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }

    @Override
    public int compareTo(Osoba o) {
        return this.pesel.compareTo(o.pesel);
    }
}