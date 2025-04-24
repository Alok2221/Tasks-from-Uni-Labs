package third_semester.lab05.exe03;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class Clinic {
    private Queue<Examined> waitingPatients = new LinkedList<>();
    private Queue<Examined> waitingVipPatients = new PriorityQueue<>((p1, p2) -> Boolean.compare(p2.isVip(), p1.isVip()));
    private TreeSet<LocalDateTime> availableAppointments = new TreeSet<>();

    // Dodanie nowych dostępnych godzin przez lekarza
    public void addAvailableAppointment(LocalDateTime dateTime) {
        availableAppointments.add(dateTime);
        assignPatientToAppointment();
    }

    // Dodanie pacjenta do kolejki
    public void addPatientToQueue(Examined examined) {
        if (examined.isVip()) {
            waitingVipPatients.add(examined);
        } else {
            waitingPatients.add(examined);
        }
        assignPatientToAppointment();
    }

    // Usunięcie pacjenta z kolejki
    public boolean removePatientFromQueue(String pesel) {
        boolean removed = removeFromQueue(waitingPatients, pesel);
        if (!removed) {
            removed = removeFromQueue(waitingVipPatients, pesel);
        }
        return removed;
    }

    private boolean removeFromQueue(Queue<Examined> queue, String pesel) {
        return queue.removeIf(patient -> patient.pesel().equals(pesel));
    }

    // Usunięcie wolnego terminu
    public boolean removeAvailableAppointment(LocalDateTime dateTime) {
        return availableAppointments.remove(dateTime);
    }

    // Sprawdzenie najbliższego wolnego terminu
    public LocalDateTime getNearestAvailableAppointment() {
        return availableAppointments.isEmpty() ? null : availableAppointments.first();
    }

    // Wyświetlenie wolnych terminów
    public void displayAvailableAppointments() {
        if (availableAppointments.isEmpty()) {
            System.out.println("Brak dostępnych terminów.");
            return;
        }

        System.out.println("Dostępne terminy:");
        int i = 1;
        for (LocalDateTime dt : availableAppointments) {
            System.out.println(i++ + ". " + dt);
        }
    }

    // Wyświetlenie oczekujących pacjentów
    public void displayWaitingPatients() {
        System.out.println("Pacjenci oczekujący:");

        System.out.println("\nVIP:");
        int counter = 1;
        for (Examined e : waitingVipPatients) {
            System.out.println(counter++ + ". " + e.firstName() + " " + e.lastName() +
                    " (PESEL: " + e.pesel() + ") - " + e.diseaseDescription() +
                    (e.isVip() ? " [VIP]" : ""));
        }

        System.out.println("\nStandard:");
        for (Examined e : waitingPatients) {
            System.out.println(counter++ + ". " + e.firstName() + " " + e.lastName() +
                    " (PESEL: " + e.pesel() + ") - " + e.diseaseDescription());
        }
    }

    // Automatyczne przypisywanie pacjentów do terminów
    private void assignPatientToAppointment() {
        while (!availableAppointments.isEmpty() && (!waitingVipPatients.isEmpty() || !waitingPatients.isEmpty())) {
            LocalDateTime nearestAppointment = availableAppointments.pollFirst();
            Examined examined = !waitingVipPatients.isEmpty() ? waitingVipPatients.poll() : waitingPatients.poll();
            System.out.println("Pacjent " + examined.firstName() + " " + examined.lastName() +
                    " został zapisany na wizytę dnia " + nearestAppointment);
        }
    }
}