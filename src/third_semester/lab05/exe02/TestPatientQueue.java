package third_semester.lab05.exe02;

import java.time.LocalDateTime;

public class TestPatientQueue {
    public static void main(String[] args) {
        Patient patient1 = new Patient(
                "Jan",
                "Kowalski",
                "90010112345",
                "Przeziębienie z gorączką 38°C",
                LocalDateTime.of(2023, 11, 15, 10, 30));

        Patient patient2 = new Patient(
                "Anna",
                "Nowak",
                "92020254321",
                "Konsultacja kardiologiczna - nadciśnienie",
                LocalDateTime.of(2023, 11, 15, 11, 15)
        );
        Patient patient3 = new Patient(
                "Marek",
                "Wiśniewski",
                "88030398765",
                "Złamanie lewej ręki - wymaga gipsu",
                LocalDateTime.of(2023, 11, 16, 9, 0)
        );
        Patient patient4 = new Patient(
                "Katarzyna",
                "Lewandowska",
                "95040445678",
                "Badanie kontrolne po antybiotykoterapii",
                LocalDateTime.of(2023, 11, 16, 14, 45)
        );

        Hospital hospital = new Hospital();
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        hospital.addPatient(patient3);
        hospital.addPatient(patient4);

        hospital.removePatient(patient2);
        System.out.println(hospital.getInformation());
        hospital.getPatientsInfo();
        hospital.acceptInTheOffice();
        hospital.addPatientToFront(new Patient("Kuba", "Maj", "936402392", "Ból brzucha", LocalDateTime.of(2025, 5, 23, 11, 50)));
        hospital.referringThePatientForAdditionalTests();
        hospital.checkLastVisitTime();
        hospital.getPatientsInfo();
    }
}