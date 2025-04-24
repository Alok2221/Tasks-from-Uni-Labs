package third_semester.lab05.exe02;

import java.time.LocalDateTime;

public class Patient {
    private String name;
    private String surname;
    private String pesel;
    private String descriptionOfIllness;
    private LocalDateTime appointmentTime;

    public Patient(String name, String surname, String pesel, String descriptionOfIllness, LocalDateTime appointmentTime) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.descriptionOfIllness = descriptionOfIllness;
        this.appointmentTime = appointmentTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getDescriptionOfIllness() {
        return descriptionOfIllness;
    }

    public void setDescriptionOfIllness(String descriptionOfIllness) {
        this.descriptionOfIllness = descriptionOfIllness;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return """
                Pacjent:
                Imie: %s
                Nazwisko: %s
                PESEL: %s
                Opis choroby: %s
                Godzina wizyty: %s
                """.formatted(name, surname, pesel, descriptionOfIllness, appointmentTime);
    }
}
