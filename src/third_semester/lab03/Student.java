package third_semester.lab03;

public class Student extends Osoba {
    private final long ID;
    private double srednia;

    public Student(String pesel, String imie, String nazwisko, long ID, double srednia) {
        super(pesel, imie, nazwisko);
        this.ID = ID;
        this.srednia = srednia;
    }

    public long getID() {
        return ID;
    }

    public double getSrednia() {
        return srednia;
    }

    public void setSrednia(double srednia) {
        this.srednia = srednia;
    }

    @Override
    public String toString() {
        return """
                PESEL: %s
                Imię: %s
                Nazwisko: %s
                ID: %d
                Średnia: %f
                %n
                """.formatted(getPesel(), getImie(), getNazwisko(), ID, srednia);
    }
}
