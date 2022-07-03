package service.impl;

import data.Storage;
import dto.Patient;
import service.PatientService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.UUID;

public class PatientServiceImpl implements PatientService {


    @Override
    public void createPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter fio: ");
        String fio = scanner.nextLine();
        System.out.print("Enter reg year: ");
        int year = scanner.nextInt();
        System.out.print("Enter reg month: ");
        int month = scanner.nextInt();
        System.out.print("Enter reg day: ");
        int day = scanner.nextInt();
        Calendar registrationDate = new GregorianCalendar(year, month, day);

        Storage.patients.add(new Patient(fio, registrationDate));
        System.out.println("Patient was added!");
    }

    @Override
    public void showAllPatients() {
        if (Storage.patients.isEmpty()) {
            System.out.println("No patients");
            return;
        }

        Storage.patients.forEach(p -> {
            System.out.printf("ID: %s\nFIO: %s\nRegistration date: %s", p.getId(), p.getFio(), p.getRegistrationDate());
            System.out.println("\n");
        });
    }

    @Override
    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user id: ");
        UUID patientId = UUID.fromString(scanner.nextLine());
        Storage.patients.removeIf(p -> p.getId().equals(patientId));

        System.out.println("User was delete!");
    }

    @Override
    public void editPatientFio() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user id: ");
        UUID patientId = UUID.fromString(scanner.nextLine());
        Patient patient = Storage.patients.stream().filter(p -> p.getId().equals(patientId)).findFirst().get();


        System.out.print("Enter fio: ");
        String fio = scanner.nextLine();

        patient.setFio(fio);
    }
}
