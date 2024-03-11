package lab1;

//     1. Napisz program wyświetlający na ekranie własną wizytówkę.
//        Wizytówka powinna zawierać: imię, nazwisko, nazwa zawodu (lub student), miejsce pracy, miejsce zamieszkania, nr
//        telefonu, adres email.

public class BusinessCard {

    private final String imie;
    private final String nazwisko;
    private final String nazwaZawodu;
    private final String miejscePracy;
    private final String nrTelefonu;
    private final String email;

    public BusinessCard(String imie, String nazwisko, String nazwaZawodu,
                        String miejscePracy, String nrTelefonu, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nazwaZawodu = nazwaZawodu;
        this.miejscePracy = miejscePracy;
        this.nrTelefonu = nrTelefonu;
        this.email = email;
    }

    @Override
    public String toString() {
        return """
                %s %s
                   %s %s
                \t%s
                 %s
                """.formatted(imie, nazwisko, nazwaZawodu, miejscePracy, nrTelefonu, email);
    }

    public static void main(String[] args) {

        BusinessCard businessCard = new BusinessCard("Aleksander", "Zadubiec",
                "Student", "KUL", "590789789", "azadubiec@kul.pl");

        System.out.println(businessCard);
    }
}
