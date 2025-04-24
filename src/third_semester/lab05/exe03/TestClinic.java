package third_semester.lab05.exe03;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TestClinic {
    public static void main(String[] args) {
        Clinic system = new Clinic();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Dodaj dostępny termin (lekarz)");
            System.out.println("2. Zapisz się na wizytę (pacjent)");
            System.out.println("3. Wyrejestruj się z kolejki");
            System.out.println("4. Usuń termin wizyty");
            System.out.println("5. Sprawdź najbliższy termin");
            System.out.println("6. Wyświetl dostępne terminy");
            System.out.println("7. Wyświetl kolejkę pacjentów");
            System.out.println("8. Wyjście");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Podaj termin wizyty (RRRR-MM-DDTHH:MM):");
                    LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
                    system.addAvailableAppointment(dateTime);
                    break;
                case 2:
                    System.out.println("Imię:");
                    String firstName = scanner.nextLine();
                    System.out.println("Nazwisko:");
                    String lastName = scanner.nextLine();
                    System.out.println("PESEL:");
                    String pesel = scanner.nextLine();
                    System.out.println("Opis choroby:");
                    String disease = scanner.nextLine();
                    System.out.println("Czy VIP? (t/n)");
                    boolean isVip = scanner.nextLine().equalsIgnoreCase("t");

                    Examined examined = new Examined(firstName, lastName, pesel, disease, isVip);
                    system.addPatientToQueue(examined);
                    break;
                case 3:
                    System.out.println("Podaj PESEL:");
                    String peselToRemove = scanner.nextLine();
                    if (system.removePatientFromQueue(peselToRemove)) {
                        System.out.println("Pacjent został usunięty z kolejki.");
                    } else {
                        System.out.println("Nie znaleziono pacjenta o podanym PESEL.");
                    }
                    break;
                case 4:
                    System.out.println("Podaj termin do usunięcia (RRRR-MM-DDTHH:MM):");
                    LocalDateTime dtToRemove = LocalDateTime.parse(scanner.nextLine());
                    if (system.removeAvailableAppointment(dtToRemove)) {
                        System.out.println("Termin został usunięty.");
                    } else {
                        System.out.println("Nie znaleziono podanego terminu.");
                    }
                    break;
                case 5:
                    LocalDateTime nearest = system.getNearestAvailableAppointment();
                    if (nearest != null) {
                        System.out.println("Najbliższy termin: " + nearest);
                    } else {
                        System.out.println("Brak dostępnych terminów.");
                    }
                    break;
                case 6:
                    system.displayAvailableAppointments();
                    break;
                case 7:
                    system.displayWaitingPatients();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Nieprawidłowy wybór.");
            }
        }
    }

}
