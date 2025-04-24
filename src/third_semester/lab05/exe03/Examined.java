package third_semester.lab05.exe03;

public record Examined(String firstName, String lastName, String pesel, String diseaseDescription, boolean isVip) {

    @Override
    public String toString() {
        return """
                Pacjent:
                Imie: %s
                Nazwisko: %s
                PESEL: %s
                Opis choroby: %s
                VIP: %b
                """.formatted(firstName, lastName, pesel, diseaseDescription, isVip ? "Tak" : "Nie");
    }
}
