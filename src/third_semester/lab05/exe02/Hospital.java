package third_semester.lab05.exe02;

import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;

public class Hospital {
    private final Deque<Patient> patients = new LinkedList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public Patient getInformation() {
        return patients.peek();
    }

    public void acceptInTheOffice() {
        patients.pollFirst();
    }

    public void addPatientToFront(Patient patient) {
        if (patient != null) patients.addFirst(patient);
    }

    public void referringThePatientForAdditionalTests() {
        patients.addLast(patients.pollFirst());
    }

    public void getPatientsInfo() {
        patients.forEach(System.out::println);
    }

    public LocalDateTime checkLastVisitTime() {
        if (patients.peekLast() != null) return patients.peekLast().getAppointmentTime();
        return null;
    }
}